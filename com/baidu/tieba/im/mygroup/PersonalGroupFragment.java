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
/* loaded from: classes8.dex */
public class PersonalGroupFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView kKK = null;
    private g mPullView = null;
    private a kKL = null;
    private NoDataView fIt = null;
    private View kKM = null;
    private int pageType = 0;
    private final c kKN = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.kvv = true;
        }
    };
    private final c kKO = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.kvv = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c kKP = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity cXw = PersonalGroupFragment.this.cXw();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.kKK != null && cXw != null && cXw.cXt() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.kKK.completePullRefreshPostDelayed(0L);
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
                if (!cXw.Xg()) {
                    cXw.setGroups(responseGroupsByUidMessage.getGroups());
                    cXw.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                cXw.cR(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.kKL.eB(groups);
                    PersonalGroupFragment.this.kKL.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.fIt.setVisibility(8);
                        PersonalGroupFragment.this.kKK.removeHeaderView(PersonalGroupFragment.this.fIt);
                    } else {
                        PersonalGroupFragment.this.fIt.setVisibility(0);
                        PersonalGroupFragment.this.kKK.removeHeaderView(PersonalGroupFragment.this.fIt);
                        PersonalGroupFragment.this.kKK.addHeaderView(PersonalGroupFragment.this.fIt);
                    }
                    PersonalGroupFragment.this.kKK.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.kvv = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && cXw.cXt() != null) {
                    cXw.cXt().update();
                }
            }
        }
    };
    private final CustomMessageListener kKQ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity cXw = PersonalGroupFragment.this.cXw();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.kKK != null && cXw != null && cXw.cXt() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (cXw.Xg()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    cXw.cR(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.kKL.eB(groups);
                        PersonalGroupFragment.this.kKL.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.fIt.setVisibility(8);
                            PersonalGroupFragment.this.kKK.removeHeaderView(PersonalGroupFragment.this.fIt);
                        } else {
                            PersonalGroupFragment.this.fIt.setVisibility(0);
                            PersonalGroupFragment.this.kKK.removeHeaderView(PersonalGroupFragment.this.fIt);
                            PersonalGroupFragment.this.kKK.addHeaderView(PersonalGroupFragment.this.fIt);
                        }
                        PersonalGroupFragment.this.kKK.setVisibility(0);
                    }
                }
                if (cXw.cXt() != null) {
                    cXw.cXt().update();
                }
            }
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean kvv = false;

    public PersonGroupActivity cXw() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.kvv) {
            this.kKK.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.kKP);
        MessageManager.getInstance().unRegisterListener(this.kKO);
        MessageManager.getInstance().unRegisterListener(this.eJz);
        MessageManager.getInstance().unRegisterListener(this.kKN);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(CmdConfigSocket.CMD_QUERY_GROUP_BY_UID, this.kKP);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_BY_UID_LOCAL, this.kKQ);
        registerListener(CmdConfigSocket.CMD_ADD_GROUP, this.kKO);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.kKO);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.kKO);
        registerListener(CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE, this.kKO);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.kKO);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.kKO);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.kKN);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.kKN);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.kKN);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.kKN);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.kKN);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.kKN);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.eJz);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fIt != null) {
            this.fIt.e(cXw().getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fIt != null) {
            this.fIt.btX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d dS;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity cXw = cXw();
        if (cXw != null && !cXw.Xg()) {
            if (this.pageType == 0) {
                dS = NoDataViewFactory.d.BB(String.format(getString(R.string.person_group_no_personal_info), cXw.cXs()));
            } else {
                dS = NoDataViewFactory.d.BB(getString(R.string.person_group_no_common_info));
            }
        } else {
            dS = (cXw == null || !cXw.Xg()) ? null : NoDataViewFactory.d.dS(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.fIt = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), dS, null);
        this.kKK = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.mPullView = new g(getPageContext());
        this.kKL = new a(this);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonGroupActivity cXw2 = PersonalGroupFragment.this.cXw();
                if (cXw2 != null) {
                    cXw2.cXt().update();
                }
            }
        });
        this.kKK.setPullRefresh(this.mPullView);
        this.kKK.setAdapter((ListAdapter) this.kKL);
        this.kKK.setOnItemClickListener(this);
        this.fIt.setVisibility(8);
        this.kKK.removeHeaderView(this.fIt);
        this.kKM = inflate.findViewById(R.id.group_fragment_parent);
        if (cXw() != null && this.pageType == cXw().cXr()) {
            this.kKK.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.kKL.getItem(i);
        PersonGroupActivity cXw = cXw();
        if (cXw != null && !cXw.a(item) && item != null) {
            if (this.pageType == 1 || cXw.Xg()) {
                if (cXw.Xg()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (cXw.gS(item.getGroupId())) {
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
            PersonGroupActivity cXw = cXw();
            if (cXw != null && !cXw.a(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kKL != null) {
            this.kKL.notifyDataSetChanged();
        }
        if (this.fIt != null) {
            ap.setBackgroundColor(this.fIt, R.color.CAM_X0201);
        }
        if (isAdded()) {
            cXw().getLayoutMode().onModeChanged(this.kKM);
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && j.isNetWorkAvailable()) {
                    this.kvv = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
