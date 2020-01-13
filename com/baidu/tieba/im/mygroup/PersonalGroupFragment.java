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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
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
/* loaded from: classes11.dex */
public class PersonalGroupFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView hFQ = null;
    private h mPullView = null;
    private a hFR = null;
    private NoDataView dyD = null;
    private View hFS = null;
    private int pageType = 0;
    private final c hFT = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.hkI = true;
        }
    };
    private final c hFU = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.hkI = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c hFV = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity bVV = PersonalGroupFragment.this.bVV();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.hFQ != null && bVV != null && bVV.bVS() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.hFQ.completePullRefreshPostDelayed(0L);
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
                if (!bVV.bVR()) {
                    bVV.setGroups(responseGroupsByUidMessage.getGroups());
                    bVV.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                bVV.ci(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.hFR.di(groups);
                    PersonalGroupFragment.this.hFR.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.dyD.setVisibility(8);
                        PersonalGroupFragment.this.hFQ.removeHeaderView(PersonalGroupFragment.this.dyD);
                    } else {
                        PersonalGroupFragment.this.dyD.setVisibility(0);
                        PersonalGroupFragment.this.hFQ.removeHeaderView(PersonalGroupFragment.this.dyD);
                        PersonalGroupFragment.this.hFQ.addHeaderView(PersonalGroupFragment.this.dyD);
                    }
                    PersonalGroupFragment.this.hFQ.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.hkI = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && bVV.bVS() != null) {
                    bVV.bVS().update();
                }
            }
        }
    };
    private final CustomMessageListener hFW = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity bVV = PersonalGroupFragment.this.bVV();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.hFQ != null && bVV != null && bVV.bVS() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (bVV.bVR()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    bVV.ci(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.hFR.di(groups);
                        PersonalGroupFragment.this.hFR.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.dyD.setVisibility(8);
                            PersonalGroupFragment.this.hFQ.removeHeaderView(PersonalGroupFragment.this.dyD);
                        } else {
                            PersonalGroupFragment.this.dyD.setVisibility(0);
                            PersonalGroupFragment.this.hFQ.removeHeaderView(PersonalGroupFragment.this.dyD);
                            PersonalGroupFragment.this.hFQ.addHeaderView(PersonalGroupFragment.this.dyD);
                        }
                        PersonalGroupFragment.this.hFQ.setVisibility(0);
                    }
                }
                if (bVV.bVS() != null) {
                    bVV.bVS().update();
                }
            }
        }
    };
    private final CustomMessageListener cHC = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean hkI = false;

    public PersonGroupActivity bVV() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hkI) {
            this.hFQ.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.hFV);
        MessageManager.getInstance().unRegisterListener(this.hFU);
        MessageManager.getInstance().unRegisterListener(this.cHC);
        MessageManager.getInstance().unRegisterListener(this.hFT);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(CmdConfigSocket.CMD_QUERY_GROUP_BY_UID, this.hFV);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_BY_UID_LOCAL, this.hFW);
        registerListener(CmdConfigSocket.CMD_ADD_GROUP, this.hFU);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.hFU);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.hFU);
        registerListener(CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE, this.hFU);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.hFU);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.hFU);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.hFT);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.hFT);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.hFT);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.hFT);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.hFT);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.hFT);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.cHC);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dyD != null) {
            this.dyD.e(bVV().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dyD != null) {
            this.dyD.aFn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d cr;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity bVV = bVV();
        if (bVV != null && !bVV.bVR()) {
            if (this.pageType == 0) {
                cr = NoDataViewFactory.d.tE(String.format(getString(R.string.person_group_no_personal_info), bVV.bVQ()));
            } else {
                cr = NoDataViewFactory.d.tE(getString(R.string.person_group_no_common_info));
            }
        } else {
            cr = (bVV == null || !bVV.bVR()) ? null : NoDataViewFactory.d.cr(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.dyD = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), cr, null);
        this.hFQ = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.mPullView = new h(getPageContext());
        this.hFR = new a(this);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                PersonGroupActivity bVV2 = PersonalGroupFragment.this.bVV();
                if (bVV2 != null) {
                    bVV2.bVS().update();
                }
            }
        });
        this.hFQ.setPullRefresh(this.mPullView);
        this.hFQ.setAdapter((ListAdapter) this.hFR);
        this.hFQ.setOnItemClickListener(this);
        this.dyD.setVisibility(8);
        this.hFQ.removeHeaderView(this.dyD);
        this.hFS = inflate.findViewById(R.id.group_fragment_parent);
        if (bVV() != null && this.pageType == bVV().bVP()) {
            this.hFQ.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.hFR.getItem(i);
        PersonGroupActivity bVV = bVV();
        if (bVV != null && !bVV.b(item) && item != null) {
            if (this.pageType == 1 || bVV.bVR()) {
                if (bVV.bVR()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (bVV.dR(item.getGroupId())) {
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
            PersonGroupActivity bVV = bVV();
            if (bVV != null && !bVV.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hFR != null) {
            this.hFR.notifyDataSetChanged();
        }
        if (this.dyD != null) {
            am.setBackgroundColor(this.dyD, R.color.cp_bg_line_d);
        }
        if (isAdded()) {
            bVV().getLayoutMode().onModeChanged(this.hFS);
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && j.isNetWorkAvailable()) {
                    this.hkI = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
