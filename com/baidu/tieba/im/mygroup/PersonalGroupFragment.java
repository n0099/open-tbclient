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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
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
/* loaded from: classes26.dex */
public class PersonalGroupFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView kns = null;
    private g mPullView = null;
    private a knt = null;
    private NoDataView fun = null;
    private View knu = null;
    private int pageType = 0;
    private final c knv = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.jQd = true;
        }
    };
    private final c knw = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            switch (socketResponsedMessage.getCmd()) {
                case CmdConfigSocket.CMD_ADD_GROUP /* 103101 */:
                case CmdConfigSocket.CMD_UPDATE_GROUP /* 103102 */:
                case CmdConfigSocket.CMD_DISSMISS_GROUP /* 103104 */:
                case CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP /* 103105 */:
                case CmdConfigSocket.CMD_REMOVE_MEMBERS /* 103112 */:
                case CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE /* 2001109 */:
                    if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() == 0 || ((socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) && socketResponsedMessage.getError() == 2230110)) {
                        PersonalGroupFragment.this.jQd = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c knx = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity cUD = PersonalGroupFragment.this.cUD();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.kns != null && cUD != null && cUD.cUA() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.kns.completePullRefreshPostDelayed(0L);
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
                if (!cUD.Wq()) {
                    cUD.setGroups(responseGroupsByUidMessage.getGroups());
                    cUD.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                cUD.cT(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.knt.es(groups);
                    PersonalGroupFragment.this.knt.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.fun.setVisibility(8);
                        PersonalGroupFragment.this.kns.removeHeaderView(PersonalGroupFragment.this.fun);
                    } else {
                        PersonalGroupFragment.this.fun.setVisibility(0);
                        PersonalGroupFragment.this.kns.removeHeaderView(PersonalGroupFragment.this.fun);
                        PersonalGroupFragment.this.kns.addHeaderView(PersonalGroupFragment.this.fun);
                    }
                    PersonalGroupFragment.this.kns.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.jQd = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && cUD.cUA() != null) {
                    cUD.cUA().update();
                }
            }
        }
    };
    private final CustomMessageListener kny = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity cUD = PersonalGroupFragment.this.cUD();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.kns != null && cUD != null && cUD.cUA() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (cUD.Wq()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    cUD.cT(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.knt.es(groups);
                        PersonalGroupFragment.this.knt.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.fun.setVisibility(8);
                            PersonalGroupFragment.this.kns.removeHeaderView(PersonalGroupFragment.this.fun);
                        } else {
                            PersonalGroupFragment.this.fun.setVisibility(0);
                            PersonalGroupFragment.this.kns.removeHeaderView(PersonalGroupFragment.this.fun);
                            PersonalGroupFragment.this.kns.addHeaderView(PersonalGroupFragment.this.fun);
                        }
                        PersonalGroupFragment.this.kns.setVisibility(0);
                    }
                }
                if (cUD.cUA() != null) {
                    cUD.cUA().update();
                }
            }
        }
    };
    private final CustomMessageListener exi = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean jQd = false;

    public PersonGroupActivity cUD() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jQd) {
            this.kns.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.knx);
        MessageManager.getInstance().unRegisterListener(this.knw);
        MessageManager.getInstance().unRegisterListener(this.exi);
        MessageManager.getInstance().unRegisterListener(this.knv);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(CmdConfigSocket.CMD_QUERY_GROUP_BY_UID, this.knx);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_BY_UID_LOCAL, this.kny);
        registerListener(CmdConfigSocket.CMD_ADD_GROUP, this.knw);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.knw);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.knw);
        registerListener(CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE, this.knw);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.knw);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.knw);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.knv);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.knv);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.knv);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.knv);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.knv);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.knv);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.exi);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fun != null) {
            this.fun.e(cUD().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fun != null) {
            this.fun.bso();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d dS;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity cUD = cUD();
        if (cUD != null && !cUD.Wq()) {
            if (this.pageType == 0) {
                dS = NoDataViewFactory.d.Cr(String.format(getString(R.string.person_group_no_personal_info), cUD.cUz()));
            } else {
                dS = NoDataViewFactory.d.Cr(getString(R.string.person_group_no_common_info));
            }
        } else {
            dS = (cUD == null || !cUD.Wq()) ? null : NoDataViewFactory.d.dS(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.fun = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), dS, null);
        this.kns = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.mPullView = new g(getPageContext());
        this.knt = new a(this);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonGroupActivity cUD2 = PersonalGroupFragment.this.cUD();
                if (cUD2 != null) {
                    cUD2.cUA().update();
                }
            }
        });
        this.kns.setPullRefresh(this.mPullView);
        this.kns.setAdapter((ListAdapter) this.knt);
        this.kns.setOnItemClickListener(this);
        this.fun.setVisibility(8);
        this.kns.removeHeaderView(this.fun);
        this.knu = inflate.findViewById(R.id.group_fragment_parent);
        if (cUD() != null && this.pageType == cUD().cUy()) {
            this.kns.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.knt.getItem(i);
        PersonGroupActivity cUD = cUD();
        if (cUD != null && !cUD.b(item) && item != null) {
            if (this.pageType == 1 || cUD.Wq()) {
                if (cUD.Wq()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (cUD.gi(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else {
                TiebaStatic.eventStat(getActivity(), "his_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
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
            PersonGroupActivity cUD = cUD();
            if (cUD != null && !cUD.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.knt != null) {
            this.knt.notifyDataSetChanged();
        }
        if (this.fun != null) {
            ap.setBackgroundColor(this.fun, R.color.cp_bg_line_d);
        }
        if (isAdded()) {
            cUD().getLayoutMode().onModeChanged(this.knu);
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && j.isNetWorkAvailable()) {
                    this.jQd = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
