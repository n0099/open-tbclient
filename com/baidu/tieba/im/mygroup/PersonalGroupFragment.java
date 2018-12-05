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
    public BdListView eXo = null;
    private k mPullView = null;
    private a eXp = null;
    private NoDataView beX = null;
    private View eXq = null;
    private int pageType = 0;
    private final c eXr = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.eCl = true;
        }
    };
    private final c eXs = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.eCl = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c eXt = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aTG = PersonalGroupFragment.this.aTG();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eXo != null && aTG != null && aTG.aTD() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eXo.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
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
                if (!aTG.aTC()) {
                    aTG.setGroups(responseGroupsByUidMessage.getGroups());
                    aTG.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aTG.bp(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.eXp.cM(groups);
                    PersonalGroupFragment.this.eXp.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.beX.setVisibility(8);
                        PersonalGroupFragment.this.eXo.removeHeaderView(PersonalGroupFragment.this.beX);
                    } else {
                        PersonalGroupFragment.this.beX.setVisibility(0);
                        PersonalGroupFragment.this.eXo.removeHeaderView(PersonalGroupFragment.this.beX);
                        PersonalGroupFragment.this.eXo.addHeaderView(PersonalGroupFragment.this.beX);
                    }
                    PersonalGroupFragment.this.eXo.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eCl = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aTG.aTD() != null) {
                    aTG.aTD().update();
                }
            }
        }
    };
    private final CustomMessageListener eXu = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aTG = PersonalGroupFragment.this.aTG();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eXo != null && aTG != null && aTG.aTD() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aTG.aTC()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aTG.bp(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.eXp.cM(groups);
                        PersonalGroupFragment.this.eXp.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.beX.setVisibility(8);
                            PersonalGroupFragment.this.eXo.removeHeaderView(PersonalGroupFragment.this.beX);
                        } else {
                            PersonalGroupFragment.this.beX.setVisibility(0);
                            PersonalGroupFragment.this.eXo.removeHeaderView(PersonalGroupFragment.this.beX);
                            PersonalGroupFragment.this.eXo.addHeaderView(PersonalGroupFragment.this.beX);
                        }
                        PersonalGroupFragment.this.eXo.setVisibility(0);
                    }
                }
                if (aTG.aTD() != null) {
                    aTG.aTD().update();
                }
            }
        }
    };
    private final CustomMessageListener aof = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean eCl = false;

    public PersonGroupActivity aTG() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eCl) {
            this.eXo.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.eXt);
        MessageManager.getInstance().unRegisterListener(this.eXs);
        MessageManager.getInstance().unRegisterListener(this.aof);
        MessageManager.getInstance().unRegisterListener(this.eXr);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.eXt);
        registerListener(2001106, this.eXu);
        registerListener(103101, this.eXs);
        registerListener(103112, this.eXs);
        registerListener(103102, this.eXs);
        registerListener(2001109, this.eXs);
        registerListener(103104, this.eXs);
        registerListener(103105, this.eXs);
        registerListener(2001126, this.eXr);
        registerListener(2001128, this.eXr);
        registerListener(2001132, this.eXr);
        registerListener(2001133, this.eXr);
        registerListener(2001130, this.eXr);
        registerListener(2001134, this.eXr);
        registerListener(2001137, this.aof);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.beX != null) {
            this.beX.e(aTG().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.beX != null) {
            this.beX.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d aD;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(e.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aTG = aTG();
        if (aTG != null && !aTG.aTC()) {
            if (this.pageType == 0) {
                aD = NoDataViewFactory.d.gn(String.format(getString(e.j.person_group_no_personal_info), aTG.aTB()));
            } else {
                aD = NoDataViewFactory.d.gn(getString(e.j.person_group_no_common_info));
            }
        } else {
            aD = (aTG == null || !aTG.aTC()) ? null : NoDataViewFactory.d.aD(getString(e.j.group_no_data_tip), getString(e.j.group_no_data_tip_1));
        }
        this.beX = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds102)), aD, null);
        this.eXo = (BdListView) inflate.findViewById(e.g.person_group_list);
        this.mPullView = new k(getPageContext());
        this.eXp = new a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                PersonGroupActivity aTG2 = PersonalGroupFragment.this.aTG();
                if (aTG2 != null) {
                    aTG2.aTD().update();
                }
            }
        });
        this.eXo.setPullRefresh(this.mPullView);
        this.eXo.setAdapter((ListAdapter) this.eXp);
        this.eXo.setOnItemClickListener(this);
        this.beX.setVisibility(8);
        this.eXo.removeHeaderView(this.beX);
        this.eXq = inflate.findViewById(e.g.group_fragment_parent);
        if (aTG() != null && this.pageType == aTG().aTA()) {
            this.eXo.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.eXp.getItem(i);
        PersonGroupActivity aTG = aTG();
        if (aTG != null && !aTG.b(item) && item != null) {
            if (this.pageType == 1 || aTG.aTC()) {
                if (aTG.aTC()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aTG.cq(item.getGroupId())) {
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
            PersonGroupActivity aTG = aTG();
            if (aTG != null && !aTG.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eXp != null) {
            this.eXp.notifyDataSetChanged();
        }
        if (this.beX != null) {
            al.j(this.beX, e.d.cp_bg_line_d);
        }
        if (isAdded()) {
            aTG().getLayoutMode().onModeChanged(this.eXq);
            this.mPullView.ey(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.kV()) {
                    this.eCl = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
