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
import com.baidu.tieba.f;
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
    public BdListView eAg = null;
    private h mPullView = null;
    private a eAh = null;
    private NoDataView aSW = null;
    private View eAi = null;
    private int pageType = 0;
    private final c eAj = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.eeK = true;
        }
    };
    private final c eAk = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.eeK = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c eAl = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aMO = PersonalGroupFragment.this.aMO();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eAg != null && aMO != null && aMO.aML() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eAg.completePullRefreshPostDelayed(2000L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        PersonalGroupFragment.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? PersonalGroupFragment.this.getResources().getString(f.j.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (PersonalGroupFragment.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!aMO.aMK()) {
                    aMO.setGroups(responseGroupsByUidMessage.getGroups());
                    aMO.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aMO.bi(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.eAh.cu(groups);
                    PersonalGroupFragment.this.eAh.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.aSW.setVisibility(8);
                        PersonalGroupFragment.this.eAg.removeHeaderView(PersonalGroupFragment.this.aSW);
                    } else {
                        PersonalGroupFragment.this.aSW.setVisibility(0);
                        PersonalGroupFragment.this.eAg.removeHeaderView(PersonalGroupFragment.this.aSW);
                        PersonalGroupFragment.this.eAg.addHeaderView(PersonalGroupFragment.this.aSW);
                    }
                    PersonalGroupFragment.this.eAg.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eeK = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aMO.aML() != null) {
                    aMO.aML().update();
                }
            }
        }
    };
    private final CustomMessageListener eAm = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aMO = PersonalGroupFragment.this.aMO();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eAg != null && aMO != null && aMO.aML() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aMO.aMK()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aMO.bi(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.eAh.cu(groups);
                        PersonalGroupFragment.this.eAh.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.aSW.setVisibility(8);
                            PersonalGroupFragment.this.eAg.removeHeaderView(PersonalGroupFragment.this.aSW);
                        } else {
                            PersonalGroupFragment.this.aSW.setVisibility(0);
                            PersonalGroupFragment.this.eAg.removeHeaderView(PersonalGroupFragment.this.aSW);
                            PersonalGroupFragment.this.eAg.addHeaderView(PersonalGroupFragment.this.aSW);
                        }
                        PersonalGroupFragment.this.eAg.setVisibility(0);
                    }
                }
                if (aMO.aML() != null) {
                    aMO.aML().update();
                }
            }
        }
    };
    private final CustomMessageListener acr = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean eeK = false;

    public PersonGroupActivity aMO() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eeK) {
            this.eAg.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.eAl);
        MessageManager.getInstance().unRegisterListener(this.eAk);
        MessageManager.getInstance().unRegisterListener(this.acr);
        MessageManager.getInstance().unRegisterListener(this.eAj);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.eAl);
        registerListener(2001106, this.eAm);
        registerListener(103101, this.eAk);
        registerListener(103112, this.eAk);
        registerListener(103102, this.eAk);
        registerListener(2001109, this.eAk);
        registerListener(103104, this.eAk);
        registerListener(103105, this.eAk);
        registerListener(2001126, this.eAj);
        registerListener(2001128, this.eAj);
        registerListener(2001132, this.eAj);
        registerListener(2001133, this.eAj);
        registerListener(2001130, this.eAj);
        registerListener(2001134, this.eAj);
        registerListener(2001137, this.acr);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aSW != null) {
            this.aSW.e(aMO().getPageContext());
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
        NoDataViewFactory.d ag;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(f.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aMO = aMO();
        if (aMO != null && !aMO.aMK()) {
            if (this.pageType == 0) {
                ag = NoDataViewFactory.d.fm(String.format(getString(f.j.person_group_no_personal_info), aMO.aMJ()));
            } else {
                ag = NoDataViewFactory.d.fm(getString(f.j.person_group_no_common_info));
            }
        } else {
            ag = (aMO == null || !aMO.aMK()) ? null : NoDataViewFactory.d.ag(getString(f.j.group_no_data_tip), getString(f.j.group_no_data_tip_1));
        }
        this.aSW = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(f.e.ds102)), ag, null);
        this.eAg = (BdListView) inflate.findViewById(f.g.person_group_list);
        this.mPullView = new h(getPageContext());
        this.eAh = new a(this);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                PersonGroupActivity aMO2 = PersonalGroupFragment.this.aMO();
                if (aMO2 != null) {
                    aMO2.aML().update();
                }
            }
        });
        this.eAg.setPullRefresh(this.mPullView);
        this.eAg.setAdapter((ListAdapter) this.eAh);
        this.eAg.setOnItemClickListener(this);
        this.aSW.setVisibility(8);
        this.eAg.removeHeaderView(this.aSW);
        this.eAi = inflate.findViewById(f.g.group_fragment_parent);
        if (aMO() != null && this.pageType == aMO().aMI()) {
            this.eAg.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.eAh.getItem(i);
        PersonGroupActivity aMO = aMO();
        if (aMO != null && !aMO.b(item) && item != null) {
            if (this.pageType == 1 || aMO.aMK()) {
                if (aMO.aMK()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aMO.cd(item.getGroupId())) {
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
        if (view.getId() == f.g.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity aMO = aMO();
            if (aMO != null && !aMO.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eAh != null) {
            this.eAh.notifyDataSetChanged();
        }
        if (this.aSW != null) {
            am.j(this.aSW, f.d.cp_bg_line_d);
        }
        if (isAdded()) {
            aMO().getLayoutMode().onModeChanged(this.eAi);
            this.mPullView.dB(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.jE()) {
                    this.eeK = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
