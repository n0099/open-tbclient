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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
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
    public BdListView eQz = null;
    private k mPullView = null;
    private a eQA = null;
    private NoDataView bby = null;
    private View eQB = null;
    private int pageType = 0;
    private final c eQC = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.evs = true;
        }
    };
    private final c eQD = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.evs = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c eQE = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aRO = PersonalGroupFragment.this.aRO();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eQz != null && aRO != null && aRO.aRL() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eQz.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        PersonalGroupFragment.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? PersonalGroupFragment.this.getResources().getString(e.j.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (PersonalGroupFragment.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!aRO.aRK()) {
                    aRO.setGroups(responseGroupsByUidMessage.getGroups());
                    aRO.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aRO.br(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.eQA.cI(groups);
                    PersonalGroupFragment.this.eQA.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.bby.setVisibility(8);
                        PersonalGroupFragment.this.eQz.removeHeaderView(PersonalGroupFragment.this.bby);
                    } else {
                        PersonalGroupFragment.this.bby.setVisibility(0);
                        PersonalGroupFragment.this.eQz.removeHeaderView(PersonalGroupFragment.this.bby);
                        PersonalGroupFragment.this.eQz.addHeaderView(PersonalGroupFragment.this.bby);
                    }
                    PersonalGroupFragment.this.eQz.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.evs = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aRO.aRL() != null) {
                    aRO.aRL().update();
                }
            }
        }
    };
    private final CustomMessageListener eQF = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aRO = PersonalGroupFragment.this.aRO();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eQz != null && aRO != null && aRO.aRL() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aRO.aRK()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aRO.br(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.eQA.cI(groups);
                        PersonalGroupFragment.this.eQA.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.bby.setVisibility(8);
                            PersonalGroupFragment.this.eQz.removeHeaderView(PersonalGroupFragment.this.bby);
                        } else {
                            PersonalGroupFragment.this.bby.setVisibility(0);
                            PersonalGroupFragment.this.eQz.removeHeaderView(PersonalGroupFragment.this.bby);
                            PersonalGroupFragment.this.eQz.addHeaderView(PersonalGroupFragment.this.bby);
                        }
                        PersonalGroupFragment.this.eQz.setVisibility(0);
                    }
                }
                if (aRO.aRL() != null) {
                    aRO.aRL().update();
                }
            }
        }
    };
    private final CustomMessageListener akD = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean evs = false;

    public PersonGroupActivity aRO() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.evs) {
            this.eQz.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.eQE);
        MessageManager.getInstance().unRegisterListener(this.eQD);
        MessageManager.getInstance().unRegisterListener(this.akD);
        MessageManager.getInstance().unRegisterListener(this.eQC);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.eQE);
        registerListener(2001106, this.eQF);
        registerListener(103101, this.eQD);
        registerListener(103112, this.eQD);
        registerListener(103102, this.eQD);
        registerListener(2001109, this.eQD);
        registerListener(103104, this.eQD);
        registerListener(103105, this.eQD);
        registerListener(2001126, this.eQC);
        registerListener(2001128, this.eQC);
        registerListener(2001132, this.eQC);
        registerListener(2001133, this.eQC);
        registerListener(2001130, this.eQC);
        registerListener(2001134, this.eQC);
        registerListener(2001137, this.akD);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bby != null) {
            this.bby.e(aRO().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bby != null) {
            this.bby.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d aA;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(e.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aRO = aRO();
        if (aRO != null && !aRO.aRK()) {
            if (this.pageType == 0) {
                aA = NoDataViewFactory.d.fV(String.format(getString(e.j.person_group_no_personal_info), aRO.aRJ()));
            } else {
                aA = NoDataViewFactory.d.fV(getString(e.j.person_group_no_common_info));
            }
        } else {
            aA = (aRO == null || !aRO.aRK()) ? null : NoDataViewFactory.d.aA(getString(e.j.group_no_data_tip), getString(e.j.group_no_data_tip_1));
        }
        this.bby = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0200e.ds102)), aA, null);
        this.eQz = (BdListView) inflate.findViewById(e.g.person_group_list);
        this.mPullView = new k(getPageContext());
        this.eQA = new a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                PersonGroupActivity aRO2 = PersonalGroupFragment.this.aRO();
                if (aRO2 != null) {
                    aRO2.aRL().update();
                }
            }
        });
        this.eQz.setPullRefresh(this.mPullView);
        this.eQz.setAdapter((ListAdapter) this.eQA);
        this.eQz.setOnItemClickListener(this);
        this.bby.setVisibility(8);
        this.eQz.removeHeaderView(this.bby);
        this.eQB = inflate.findViewById(e.g.group_fragment_parent);
        if (aRO() != null && this.pageType == aRO().aRI()) {
            this.eQz.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.eQA.getItem(i);
        PersonGroupActivity aRO = aRO();
        if (aRO != null && !aRO.b(item) && item != null) {
            if (this.pageType == 1 || aRO.aRK()) {
                if (aRO.aRK()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aRO.cj(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else {
                TiebaStatic.eventStat(getActivity(), "his_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == e.g.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity aRO = aRO();
            if (aRO != null && !aRO.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eQA != null) {
            this.eQA.notifyDataSetChanged();
        }
        if (this.bby != null) {
            al.j(this.bby, e.d.cp_bg_line_d);
        }
        if (isAdded()) {
            aRO().getLayoutMode().onModeChanged(this.eQB);
            this.mPullView.ek(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.kV()) {
                    this.evs = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
