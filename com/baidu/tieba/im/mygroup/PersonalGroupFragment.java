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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
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
    public BdListView eAk = null;
    private h mPullView = null;
    private a eAl = null;
    private NoDataView aSW = null;
    private View eAm = null;
    private int pageType = 0;
    private final c eAn = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.eeN = true;
        }
    };
    private final c eAo = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.eeN = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c eAp = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aMR = PersonalGroupFragment.this.aMR();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eAk != null && aMR != null && aMR.aMO() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eAk.completePullRefreshPostDelayed(2000L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        PersonalGroupFragment.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? PersonalGroupFragment.this.getResources().getString(d.j.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (PersonalGroupFragment.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!aMR.aMN()) {
                    aMR.setGroups(responseGroupsByUidMessage.getGroups());
                    aMR.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aMR.bi(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.eAl.cu(groups);
                    PersonalGroupFragment.this.eAl.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.aSW.setVisibility(8);
                        PersonalGroupFragment.this.eAk.removeHeaderView(PersonalGroupFragment.this.aSW);
                    } else {
                        PersonalGroupFragment.this.aSW.setVisibility(0);
                        PersonalGroupFragment.this.eAk.removeHeaderView(PersonalGroupFragment.this.aSW);
                        PersonalGroupFragment.this.eAk.addHeaderView(PersonalGroupFragment.this.aSW);
                    }
                    PersonalGroupFragment.this.eAk.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eeN = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aMR.aMO() != null) {
                    aMR.aMO().update();
                }
            }
        }
    };
    private final CustomMessageListener eAq = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aMR = PersonalGroupFragment.this.aMR();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eAk != null && aMR != null && aMR.aMO() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aMR.aMN()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aMR.bi(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.eAl.cu(groups);
                        PersonalGroupFragment.this.eAl.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.aSW.setVisibility(8);
                            PersonalGroupFragment.this.eAk.removeHeaderView(PersonalGroupFragment.this.aSW);
                        } else {
                            PersonalGroupFragment.this.aSW.setVisibility(0);
                            PersonalGroupFragment.this.eAk.removeHeaderView(PersonalGroupFragment.this.aSW);
                            PersonalGroupFragment.this.eAk.addHeaderView(PersonalGroupFragment.this.aSW);
                        }
                        PersonalGroupFragment.this.eAk.setVisibility(0);
                    }
                }
                if (aMR.aMO() != null) {
                    aMR.aMO().update();
                }
            }
        }
    };
    private final CustomMessageListener acq = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean eeN = false;

    public PersonGroupActivity aMR() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eeN) {
            this.eAk.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.eAp);
        MessageManager.getInstance().unRegisterListener(this.eAo);
        MessageManager.getInstance().unRegisterListener(this.acq);
        MessageManager.getInstance().unRegisterListener(this.eAn);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.eAp);
        registerListener(2001106, this.eAq);
        registerListener(103101, this.eAo);
        registerListener(103112, this.eAo);
        registerListener(103102, this.eAo);
        registerListener(2001109, this.eAo);
        registerListener(103104, this.eAo);
        registerListener(103105, this.eAo);
        registerListener(2001126, this.eAn);
        registerListener(2001128, this.eAn);
        registerListener(2001132, this.eAn);
        registerListener(2001133, this.eAn);
        registerListener(2001130, this.eAn);
        registerListener(2001134, this.eAn);
        registerListener(2001137, this.acq);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aSW != null) {
            this.aSW.e(aMR().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aSW != null) {
            this.aSW.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d ah;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(d.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aMR = aMR();
        if (aMR != null && !aMR.aMN()) {
            if (this.pageType == 0) {
                ah = NoDataViewFactory.d.fm(String.format(getString(d.j.person_group_no_personal_info), aMR.aMM()));
            } else {
                ah = NoDataViewFactory.d.fm(getString(d.j.person_group_no_common_info));
            }
        } else {
            ah = (aMR == null || !aMR.aMN()) ? null : NoDataViewFactory.d.ah(getString(d.j.group_no_data_tip), getString(d.j.group_no_data_tip_1));
        }
        this.aSW = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), ah, null);
        this.eAk = (BdListView) inflate.findViewById(d.g.person_group_list);
        this.mPullView = new h(getPageContext());
        this.eAl = new a(this);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                PersonGroupActivity aMR2 = PersonalGroupFragment.this.aMR();
                if (aMR2 != null) {
                    aMR2.aMO().update();
                }
            }
        });
        this.eAk.setPullRefresh(this.mPullView);
        this.eAk.setAdapter((ListAdapter) this.eAl);
        this.eAk.setOnItemClickListener(this);
        this.aSW.setVisibility(8);
        this.eAk.removeHeaderView(this.aSW);
        this.eAm = inflate.findViewById(d.g.group_fragment_parent);
        if (aMR() != null && this.pageType == aMR().aML()) {
            this.eAk.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.eAl.getItem(i);
        PersonGroupActivity aMR = aMR();
        if (aMR != null && !aMR.b(item) && item != null) {
            if (this.pageType == 1 || aMR.aMN()) {
                if (aMR.aMN()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aMR.cd(item.getGroupId())) {
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
        if (view.getId() == d.g.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity aMR = aMR();
            if (aMR != null && !aMR.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eAl != null) {
            this.eAl.notifyDataSetChanged();
        }
        if (this.aSW != null) {
            am.j(this.aSW, d.C0140d.cp_bg_line_d);
        }
        if (isAdded()) {
            aMR().getLayoutMode().onModeChanged(this.eAm);
            this.mPullView.dC(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.jE()) {
                    this.eeN = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
