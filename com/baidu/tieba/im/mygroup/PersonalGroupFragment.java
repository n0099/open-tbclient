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
import com.baidu.tbadk.core.util.am;
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
    public BdListView gOn = null;
    private i mPullView = null;
    private a gOo = null;
    private NoDataView cyV = null;
    private View gOp = null;
    private int pageType = 0;
    private final c gOq = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.gtk = true;
        }
    };
    private final c gOr = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.gtk = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c gOs = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity bFP = PersonalGroupFragment.this.bFP();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gOn != null && bFP != null && bFP.bFM() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gOn.completePullRefreshPostDelayed(0L);
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
                if (!bFP.bFL()) {
                    bFP.setGroups(responseGroupsByUidMessage.getGroups());
                    bFP.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                bFP.bZ(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.gOo.dh(groups);
                    PersonalGroupFragment.this.gOo.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.cyV.setVisibility(8);
                        PersonalGroupFragment.this.gOn.removeHeaderView(PersonalGroupFragment.this.cyV);
                    } else {
                        PersonalGroupFragment.this.cyV.setVisibility(0);
                        PersonalGroupFragment.this.gOn.removeHeaderView(PersonalGroupFragment.this.cyV);
                        PersonalGroupFragment.this.gOn.addHeaderView(PersonalGroupFragment.this.cyV);
                    }
                    PersonalGroupFragment.this.gOn.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gtk = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && bFP.bFM() != null) {
                    bFP.bFM().update();
                }
            }
        }
    };
    private final CustomMessageListener gOt = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity bFP = PersonalGroupFragment.this.bFP();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gOn != null && bFP != null && bFP.bFM() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (bFP.bFL()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    bFP.bZ(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.gOo.dh(groups);
                        PersonalGroupFragment.this.gOo.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.cyV.setVisibility(8);
                            PersonalGroupFragment.this.gOn.removeHeaderView(PersonalGroupFragment.this.cyV);
                        } else {
                            PersonalGroupFragment.this.cyV.setVisibility(0);
                            PersonalGroupFragment.this.gOn.removeHeaderView(PersonalGroupFragment.this.cyV);
                            PersonalGroupFragment.this.gOn.addHeaderView(PersonalGroupFragment.this.cyV);
                        }
                        PersonalGroupFragment.this.gOn.setVisibility(0);
                    }
                }
                if (bFP.bFM() != null) {
                    bFP.bFM().update();
                }
            }
        }
    };
    private final CustomMessageListener bDy = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean gtk = false;

    public PersonGroupActivity bFP() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gtk) {
            this.gOn.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.gOs);
        MessageManager.getInstance().unRegisterListener(this.gOr);
        MessageManager.getInstance().unRegisterListener(this.bDy);
        MessageManager.getInstance().unRegisterListener(this.gOq);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.gOs);
        registerListener(2001106, this.gOt);
        registerListener(103101, this.gOr);
        registerListener(103112, this.gOr);
        registerListener(103102, this.gOr);
        registerListener(2001109, this.gOr);
        registerListener(103104, this.gOr);
        registerListener(103105, this.gOr);
        registerListener(2001126, this.gOq);
        registerListener(2001128, this.gOq);
        registerListener(2001132, this.gOq);
        registerListener(2001133, this.gOq);
        registerListener(2001130, this.gOq);
        registerListener(2001134, this.gOq);
        registerListener(2001137, this.bDy);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cyV != null) {
            this.cyV.e(bFP().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cyV != null) {
            this.cyV.aku();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d bX;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity bFP = bFP();
        if (bFP != null && !bFP.bFL()) {
            if (this.pageType == 0) {
                bX = NoDataViewFactory.d.oP(String.format(getString(R.string.person_group_no_personal_info), bFP.bFK()));
            } else {
                bX = NoDataViewFactory.d.oP(getString(R.string.person_group_no_common_info));
            }
        } else {
            bX = (bFP == null || !bFP.bFL()) ? null : NoDataViewFactory.d.bX(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.cyV = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), bX, null);
        this.gOn = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.mPullView = new i(getPageContext());
        this.gOo = new a(this);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                PersonGroupActivity bFP2 = PersonalGroupFragment.this.bFP();
                if (bFP2 != null) {
                    bFP2.bFM().update();
                }
            }
        });
        this.gOn.setPullRefresh(this.mPullView);
        this.gOn.setAdapter((ListAdapter) this.gOo);
        this.gOn.setOnItemClickListener(this);
        this.cyV.setVisibility(8);
        this.gOn.removeHeaderView(this.cyV);
        this.gOp = inflate.findViewById(R.id.group_fragment_parent);
        if (bFP() != null && this.pageType == bFP().bFJ()) {
            this.gOn.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.gOo.getItem(i);
        PersonGroupActivity bFP = bFP();
        if (bFP != null && !bFP.b(item) && item != null) {
            if (this.pageType == 1 || bFP.bFL()) {
                if (bFP.bFL()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (bFP.dH(item.getGroupId())) {
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
            PersonGroupActivity bFP = bFP();
            if (bFP != null && !bFP.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gOo != null) {
            this.gOo.notifyDataSetChanged();
        }
        if (this.cyV != null) {
            am.l(this.cyV, R.color.cp_bg_line_d);
        }
        if (isAdded()) {
            bFP().getLayoutMode().onModeChanged(this.gOp);
            this.mPullView.iV(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.kc()) {
                    this.gtk = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
