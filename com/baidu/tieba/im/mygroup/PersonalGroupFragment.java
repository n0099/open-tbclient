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
    public BdListView gPa = null;
    private i mPullView = null;
    private a gPb = null;
    private NoDataView cLr = null;
    private View gPc = null;
    private int pageType = 0;
    private final c gPd = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.gtQ = true;
        }
    };
    private final c gPe = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.gtQ = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c gPf = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity bDC = PersonalGroupFragment.this.bDC();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gPa != null && bDC != null && bDC.bDz() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gPa.completePullRefreshPostDelayed(0L);
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
                if (!bDC.bDy()) {
                    bDC.setGroups(responseGroupsByUidMessage.getGroups());
                    bDC.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                bDC.bS(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.gPb.dt(groups);
                    PersonalGroupFragment.this.gPb.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.cLr.setVisibility(8);
                        PersonalGroupFragment.this.gPa.removeHeaderView(PersonalGroupFragment.this.cLr);
                    } else {
                        PersonalGroupFragment.this.cLr.setVisibility(0);
                        PersonalGroupFragment.this.gPa.removeHeaderView(PersonalGroupFragment.this.cLr);
                        PersonalGroupFragment.this.gPa.addHeaderView(PersonalGroupFragment.this.cLr);
                    }
                    PersonalGroupFragment.this.gPa.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gtQ = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && bDC.bDz() != null) {
                    bDC.bDz().update();
                }
            }
        }
    };
    private final CustomMessageListener gPg = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity bDC = PersonalGroupFragment.this.bDC();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gPa != null && bDC != null && bDC.bDz() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (bDC.bDy()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    bDC.bS(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.gPb.dt(groups);
                        PersonalGroupFragment.this.gPb.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.cLr.setVisibility(8);
                            PersonalGroupFragment.this.gPa.removeHeaderView(PersonalGroupFragment.this.cLr);
                        } else {
                            PersonalGroupFragment.this.cLr.setVisibility(0);
                            PersonalGroupFragment.this.gPa.removeHeaderView(PersonalGroupFragment.this.cLr);
                            PersonalGroupFragment.this.gPa.addHeaderView(PersonalGroupFragment.this.cLr);
                        }
                        PersonalGroupFragment.this.gPa.setVisibility(0);
                    }
                }
                if (bDC.bDz() != null) {
                    bDC.bDz().update();
                }
            }
        }
    };
    private final CustomMessageListener bVR = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean gtQ = false;

    public PersonGroupActivity bDC() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gtQ) {
            this.gPa.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.gPf);
        MessageManager.getInstance().unRegisterListener(this.gPe);
        MessageManager.getInstance().unRegisterListener(this.bVR);
        MessageManager.getInstance().unRegisterListener(this.gPd);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(CmdConfigSocket.CMD_QUERY_GROUP_BY_UID, this.gPf);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_BY_UID_LOCAL, this.gPg);
        registerListener(CmdConfigSocket.CMD_ADD_GROUP, this.gPe);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.gPe);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.gPe);
        registerListener(CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE, this.gPe);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.gPe);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.gPe);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.gPd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.gPd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.gPd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.gPd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.gPd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.gPd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.bVR);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cLr != null) {
            this.cLr.e(bDC().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cLr != null) {
            this.cLr.anG();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d bU;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity bDC = bDC();
        if (bDC != null && !bDC.bDy()) {
            if (this.pageType == 0) {
                bU = NoDataViewFactory.d.ow(String.format(getString(R.string.person_group_no_personal_info), bDC.bDx()));
            } else {
                bU = NoDataViewFactory.d.ow(getString(R.string.person_group_no_common_info));
            }
        } else {
            bU = (bDC == null || !bDC.bDy()) ? null : NoDataViewFactory.d.bU(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.cLr = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), bU, null);
        this.gPa = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.mPullView = new i(getPageContext());
        this.gPb = new a(this);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                PersonGroupActivity bDC2 = PersonalGroupFragment.this.bDC();
                if (bDC2 != null) {
                    bDC2.bDz().update();
                }
            }
        });
        this.gPa.setPullRefresh(this.mPullView);
        this.gPa.setAdapter((ListAdapter) this.gPb);
        this.gPa.setOnItemClickListener(this);
        this.cLr.setVisibility(8);
        this.gPa.removeHeaderView(this.cLr);
        this.gPc = inflate.findViewById(R.id.group_fragment_parent);
        if (bDC() != null && this.pageType == bDC().bDw()) {
            this.gPa.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.gPb.getItem(i);
        PersonGroupActivity bDC = bDC();
        if (bDC != null && !bDC.b(item) && item != null) {
            if (this.pageType == 1 || bDC.bDy()) {
                if (bDC.bDy()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (bDC.dh(item.getGroupId())) {
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
            PersonGroupActivity bDC = bDC();
            if (bDC != null && !bDC.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gPb != null) {
            this.gPb.notifyDataSetChanged();
        }
        if (this.cLr != null) {
            am.setBackgroundColor(this.cLr, R.color.cp_bg_line_d);
        }
        if (isAdded()) {
            bDC().getLayoutMode().onModeChanged(this.gPc);
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && j.isNetWorkAvailable()) {
                    this.gtQ = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
