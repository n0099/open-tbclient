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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes20.dex */
public class PersonalGroupFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView jir = null;
    private g mPullView = null;
    private a jis = null;
    private NoDataView eGk = null;
    private View jit = null;
    private int pageType = 0;
    private final c jiu = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.iKY = true;
        }
    };
    private final c jiv = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.iKY = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c jiw = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity cwP = PersonalGroupFragment.this.cwP();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.jir != null && cwP != null && cwP.cwM() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.jir.completePullRefreshPostDelayed(0L);
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
                if (!cwP.cwL()) {
                    cwP.setGroups(responseGroupsByUidMessage.getGroups());
                    cwP.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                cwP.cE(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.jis.dJ(groups);
                    PersonalGroupFragment.this.jis.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.eGk.setVisibility(8);
                        PersonalGroupFragment.this.jir.removeHeaderView(PersonalGroupFragment.this.eGk);
                    } else {
                        PersonalGroupFragment.this.eGk.setVisibility(0);
                        PersonalGroupFragment.this.jir.removeHeaderView(PersonalGroupFragment.this.eGk);
                        PersonalGroupFragment.this.jir.addHeaderView(PersonalGroupFragment.this.eGk);
                    }
                    PersonalGroupFragment.this.jir.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.iKY = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && cwP.cwM() != null) {
                    cwP.cwM().update();
                }
            }
        }
    };
    private final CustomMessageListener jix = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity cwP = PersonalGroupFragment.this.cwP();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.jir != null && cwP != null && cwP.cwM() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (cwP.cwL()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    cwP.cE(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.jis.dJ(groups);
                        PersonalGroupFragment.this.jis.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.eGk.setVisibility(8);
                            PersonalGroupFragment.this.jir.removeHeaderView(PersonalGroupFragment.this.eGk);
                        } else {
                            PersonalGroupFragment.this.eGk.setVisibility(0);
                            PersonalGroupFragment.this.jir.removeHeaderView(PersonalGroupFragment.this.eGk);
                            PersonalGroupFragment.this.jir.addHeaderView(PersonalGroupFragment.this.eGk);
                        }
                        PersonalGroupFragment.this.jir.setVisibility(0);
                    }
                }
                if (cwP.cwM() != null) {
                    cwP.cwM().update();
                }
            }
        }
    };
    private final CustomMessageListener dLt = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean iKY = false;

    public PersonGroupActivity cwP() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iKY) {
            this.jir.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.jiw);
        MessageManager.getInstance().unRegisterListener(this.jiv);
        MessageManager.getInstance().unRegisterListener(this.dLt);
        MessageManager.getInstance().unRegisterListener(this.jiu);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(CmdConfigSocket.CMD_QUERY_GROUP_BY_UID, this.jiw);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_BY_UID_LOCAL, this.jix);
        registerListener(CmdConfigSocket.CMD_ADD_GROUP, this.jiv);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.jiv);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.jiv);
        registerListener(CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE, this.jiv);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.jiv);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.jiv);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.jiu);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.jiu);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.jiu);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.jiu);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.jiu);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.jiu);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.dLt);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eGk != null) {
            this.eGk.e(cwP().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.eGk != null) {
            this.eGk.bbU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d m31do;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity cwP = cwP();
        if (cwP != null && !cwP.cwL()) {
            if (this.pageType == 0) {
                m31do = NoDataViewFactory.d.yn(String.format(getString(R.string.person_group_no_personal_info), cwP.cwK()));
            } else {
                m31do = NoDataViewFactory.d.yn(getString(R.string.person_group_no_common_info));
            }
        } else {
            m31do = (cwP == null || !cwP.cwL()) ? null : NoDataViewFactory.d.m31do(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.eGk = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), m31do, null);
        this.jir = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.mPullView = new g(getPageContext());
        this.jis = new a(this);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonGroupActivity cwP2 = PersonalGroupFragment.this.cwP();
                if (cwP2 != null) {
                    cwP2.cwM().update();
                }
            }
        });
        this.jir.setPullRefresh(this.mPullView);
        this.jir.setAdapter((ListAdapter) this.jis);
        this.jir.setOnItemClickListener(this);
        this.eGk.setVisibility(8);
        this.jir.removeHeaderView(this.eGk);
        this.jit = inflate.findViewById(R.id.group_fragment_parent);
        if (cwP() != null && this.pageType == cwP().cwJ()) {
            this.jir.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.jis.getItem(i);
        PersonGroupActivity cwP = cwP();
        if (cwP != null && !cwP.b(item) && item != null) {
            if (this.pageType == 1 || cwP.cwL()) {
                if (cwP.cwL()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (cwP.eT(item.getGroupId())) {
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
            PersonGroupActivity cwP = cwP();
            if (cwP != null && !cwP.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jis != null) {
            this.jis.notifyDataSetChanged();
        }
        if (this.eGk != null) {
            ao.setBackgroundColor(this.eGk, R.color.cp_bg_line_d);
        }
        if (isAdded()) {
            cwP().getLayoutMode().onModeChanged(this.jit);
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && j.isNetWorkAvailable()) {
                    this.iKY = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
