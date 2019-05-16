package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonalGroupFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView gIa = null;
    private i mPullView = null;
    private a gIb = null;
    private NoDataView cxF = null;
    private View gIc = null;
    private int pageType = 0;
    private final c gId = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.gmU = true;
        }
    };
    private final c gIe = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            switch (socketResponsedMessage.getCmd()) {
                case 103101:
                case 103102:
                case 103104:
                case 103105:
                case 103112:
                case 2001109:
                    if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() == 0 || ((socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) && socketResponsedMessage.getError() == 2230110)) {
                        PersonalGroupFragment.this.gmU = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c gIf = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity bDe = PersonalGroupFragment.this.bDe();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gIa != null && bDe != null && bDe.bDb() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gIa.completePullRefreshPostDelayed(0L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        PersonalGroupFragment.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? PersonalGroupFragment.this.getResources().getString(R.string.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (PersonalGroupFragment.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!bDe.bDa()) {
                    bDe.setGroups(responseGroupsByUidMessage.getGroups());
                    bDe.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                bDe.bT(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.gIb.df(groups);
                    PersonalGroupFragment.this.gIb.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.cxF.setVisibility(8);
                        PersonalGroupFragment.this.gIa.removeHeaderView(PersonalGroupFragment.this.cxF);
                    } else {
                        PersonalGroupFragment.this.cxF.setVisibility(0);
                        PersonalGroupFragment.this.gIa.removeHeaderView(PersonalGroupFragment.this.cxF);
                        PersonalGroupFragment.this.gIa.addHeaderView(PersonalGroupFragment.this.cxF);
                    }
                    PersonalGroupFragment.this.gIa.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gmU = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && bDe.bDb() != null) {
                    bDe.bDb().update();
                }
            }
        }
    };
    private final CustomMessageListener gIg = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity bDe = PersonalGroupFragment.this.bDe();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gIa != null && bDe != null && bDe.bDb() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (bDe.bDa()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    bDe.bT(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.gIb.df(groups);
                        PersonalGroupFragment.this.gIb.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.cxF.setVisibility(8);
                            PersonalGroupFragment.this.gIa.removeHeaderView(PersonalGroupFragment.this.cxF);
                        } else {
                            PersonalGroupFragment.this.cxF.setVisibility(0);
                            PersonalGroupFragment.this.gIa.removeHeaderView(PersonalGroupFragment.this.cxF);
                            PersonalGroupFragment.this.gIa.addHeaderView(PersonalGroupFragment.this.cxF);
                        }
                        PersonalGroupFragment.this.gIa.setVisibility(0);
                    }
                }
                if (bDe.bDb() != null) {
                    bDe.bDb().update();
                }
            }
        }
    };
    private final CustomMessageListener bCA = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean gmU = false;

    public PersonGroupActivity bDe() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gmU) {
            this.gIa.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.gIf);
        MessageManager.getInstance().unRegisterListener(this.gIe);
        MessageManager.getInstance().unRegisterListener(this.bCA);
        MessageManager.getInstance().unRegisterListener(this.gId);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.gIf);
        registerListener(2001106, this.gIg);
        registerListener(103101, this.gIe);
        registerListener(103112, this.gIe);
        registerListener(103102, this.gIe);
        registerListener(2001109, this.gIe);
        registerListener(103104, this.gIe);
        registerListener(103105, this.gIe);
        registerListener(2001126, this.gId);
        registerListener(2001128, this.gId);
        registerListener(2001132, this.gId);
        registerListener(2001133, this.gId);
        registerListener(2001130, this.gId);
        registerListener(2001134, this.gId);
        registerListener(2001137, this.bCA);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cxF != null) {
            this.cxF.e(bDe().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cxF != null) {
            this.cxF.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d bW;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity bDe = bDe();
        if (bDe != null && !bDe.bDa()) {
            if (this.pageType == 0) {
                bW = NoDataViewFactory.d.oz(String.format(getString(R.string.person_group_no_personal_info), bDe.bCZ()));
            } else {
                bW = NoDataViewFactory.d.oz(getString(R.string.person_group_no_common_info));
            }
        } else {
            bW = (bDe == null || !bDe.bDa()) ? null : NoDataViewFactory.d.bW(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.cxF = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), bW, null);
        this.gIa = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.mPullView = new i(getPageContext());
        this.gIb = new a(this);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                PersonGroupActivity bDe2 = PersonalGroupFragment.this.bDe();
                if (bDe2 != null) {
                    bDe2.bDb().update();
                }
            }
        });
        this.gIa.setPullRefresh(this.mPullView);
        this.gIa.setAdapter((ListAdapter) this.gIb);
        this.gIa.setOnItemClickListener(this);
        this.cxF.setVisibility(8);
        this.gIa.removeHeaderView(this.cxF);
        this.gIc = inflate.findViewById(R.id.group_fragment_parent);
        if (bDe() != null && this.pageType == bDe().bCY()) {
            this.gIa.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.gIb.getItem(i);
        PersonGroupActivity bDe = bDe();
        if (bDe != null && !bDe.b(item) && item != null) {
            if (this.pageType == 1 || bDe.bDa()) {
                if (bDe.bDa()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (bDe.dx(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else {
                TiebaStatic.eventStat(getActivity(), "his_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity bDe = bDe();
            if (bDe != null && !bDe.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gIb != null) {
            this.gIb.notifyDataSetChanged();
        }
        if (this.cxF != null) {
            al.l(this.cxF, R.color.cp_bg_line_d);
        }
        if (isAdded()) {
            bDe().getLayoutMode().onModeChanged(this.gIc);
            this.mPullView.iP(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.jS()) {
                    this.gmU = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
