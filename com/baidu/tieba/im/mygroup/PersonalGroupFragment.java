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
    public BdListView ePh = null;
    private k mPullView = null;
    private a ePi = null;
    private NoDataView baL = null;
    private View ePj = null;
    private int pageType = 0;
    private final c ePk = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.etZ = true;
        }
    };
    private final c ePl = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.etZ = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c ePm = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aSr = PersonalGroupFragment.this.aSr();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.ePh != null && aSr != null && aSr.aSo() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.ePh.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
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
                if (!aSr.aSn()) {
                    aSr.setGroups(responseGroupsByUidMessage.getGroups());
                    aSr.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aSr.bp(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.ePi.cK(groups);
                    PersonalGroupFragment.this.ePi.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.baL.setVisibility(8);
                        PersonalGroupFragment.this.ePh.removeHeaderView(PersonalGroupFragment.this.baL);
                    } else {
                        PersonalGroupFragment.this.baL.setVisibility(0);
                        PersonalGroupFragment.this.ePh.removeHeaderView(PersonalGroupFragment.this.baL);
                        PersonalGroupFragment.this.ePh.addHeaderView(PersonalGroupFragment.this.baL);
                    }
                    PersonalGroupFragment.this.ePh.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.etZ = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aSr.aSo() != null) {
                    aSr.aSo().update();
                }
            }
        }
    };
    private final CustomMessageListener ePn = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aSr = PersonalGroupFragment.this.aSr();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.ePh != null && aSr != null && aSr.aSo() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aSr.aSn()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aSr.bp(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.ePi.cK(groups);
                        PersonalGroupFragment.this.ePi.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.baL.setVisibility(8);
                            PersonalGroupFragment.this.ePh.removeHeaderView(PersonalGroupFragment.this.baL);
                        } else {
                            PersonalGroupFragment.this.baL.setVisibility(0);
                            PersonalGroupFragment.this.ePh.removeHeaderView(PersonalGroupFragment.this.baL);
                            PersonalGroupFragment.this.ePh.addHeaderView(PersonalGroupFragment.this.baL);
                        }
                        PersonalGroupFragment.this.ePh.setVisibility(0);
                    }
                }
                if (aSr.aSo() != null) {
                    aSr.aSo().update();
                }
            }
        }
    };
    private final CustomMessageListener ajQ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean etZ = false;

    public PersonGroupActivity aSr() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.etZ) {
            this.ePh.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.ePm);
        MessageManager.getInstance().unRegisterListener(this.ePl);
        MessageManager.getInstance().unRegisterListener(this.ajQ);
        MessageManager.getInstance().unRegisterListener(this.ePk);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.ePm);
        registerListener(2001106, this.ePn);
        registerListener(103101, this.ePl);
        registerListener(103112, this.ePl);
        registerListener(103102, this.ePl);
        registerListener(2001109, this.ePl);
        registerListener(103104, this.ePl);
        registerListener(103105, this.ePl);
        registerListener(2001126, this.ePk);
        registerListener(2001128, this.ePk);
        registerListener(2001132, this.ePk);
        registerListener(2001133, this.ePk);
        registerListener(2001130, this.ePk);
        registerListener(2001134, this.ePk);
        registerListener(2001137, this.ajQ);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.baL != null) {
            this.baL.e(aSr().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.baL != null) {
            this.baL.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d aA;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(e.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aSr = aSr();
        if (aSr != null && !aSr.aSn()) {
            if (this.pageType == 0) {
                aA = NoDataViewFactory.d.fU(String.format(getString(e.j.person_group_no_personal_info), aSr.aSm()));
            } else {
                aA = NoDataViewFactory.d.fU(getString(e.j.person_group_no_common_info));
            }
        } else {
            aA = (aSr == null || !aSr.aSn()) ? null : NoDataViewFactory.d.aA(getString(e.j.group_no_data_tip), getString(e.j.group_no_data_tip_1));
        }
        this.baL = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0175e.ds102)), aA, null);
        this.ePh = (BdListView) inflate.findViewById(e.g.person_group_list);
        this.mPullView = new k(getPageContext());
        this.ePi = new a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                PersonGroupActivity aSr2 = PersonalGroupFragment.this.aSr();
                if (aSr2 != null) {
                    aSr2.aSo().update();
                }
            }
        });
        this.ePh.setPullRefresh(this.mPullView);
        this.ePh.setAdapter((ListAdapter) this.ePi);
        this.ePh.setOnItemClickListener(this);
        this.baL.setVisibility(8);
        this.ePh.removeHeaderView(this.baL);
        this.ePj = inflate.findViewById(e.g.group_fragment_parent);
        if (aSr() != null && this.pageType == aSr().aSl()) {
            this.ePh.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.ePi.getItem(i);
        PersonGroupActivity aSr = aSr();
        if (aSr != null && !aSr.b(item) && item != null) {
            if (this.pageType == 1 || aSr.aSn()) {
                if (aSr.aSn()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aSr.co(item.getGroupId())) {
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
            PersonGroupActivity aSr = aSr();
            if (aSr != null && !aSr.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ePi != null) {
            this.ePi.notifyDataSetChanged();
        }
        if (this.baL != null) {
            al.j(this.baL, e.d.cp_bg_line_d);
        }
        if (isAdded()) {
            aSr().getLayoutMode().onModeChanged(this.ePj);
            this.mPullView.dW(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.kX()) {
                    this.etZ = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
