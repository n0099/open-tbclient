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
    public BdListView faf = null;
    private k mPullView = null;
    private a fag = null;
    private NoDataView bfa = null;
    private View fah = null;
    private int pageType = 0;
    private final c fai = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.eFc = true;
        }
    };
    private final c faj = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.eFc = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c fak = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aUt = PersonalGroupFragment.this.aUt();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.faf != null && aUt != null && aUt.aUq() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.faf.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
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
                if (!aUt.aUp()) {
                    aUt.setGroups(responseGroupsByUidMessage.getGroups());
                    aUt.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aUt.bq(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.fag.cN(groups);
                    PersonalGroupFragment.this.fag.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.bfa.setVisibility(8);
                        PersonalGroupFragment.this.faf.removeHeaderView(PersonalGroupFragment.this.bfa);
                    } else {
                        PersonalGroupFragment.this.bfa.setVisibility(0);
                        PersonalGroupFragment.this.faf.removeHeaderView(PersonalGroupFragment.this.bfa);
                        PersonalGroupFragment.this.faf.addHeaderView(PersonalGroupFragment.this.bfa);
                    }
                    PersonalGroupFragment.this.faf.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eFc = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aUt.aUq() != null) {
                    aUt.aUq().update();
                }
            }
        }
    };
    private final CustomMessageListener fal = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aUt = PersonalGroupFragment.this.aUt();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.faf != null && aUt != null && aUt.aUq() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aUt.aUp()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aUt.bq(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.fag.cN(groups);
                        PersonalGroupFragment.this.fag.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.bfa.setVisibility(8);
                            PersonalGroupFragment.this.faf.removeHeaderView(PersonalGroupFragment.this.bfa);
                        } else {
                            PersonalGroupFragment.this.bfa.setVisibility(0);
                            PersonalGroupFragment.this.faf.removeHeaderView(PersonalGroupFragment.this.bfa);
                            PersonalGroupFragment.this.faf.addHeaderView(PersonalGroupFragment.this.bfa);
                        }
                        PersonalGroupFragment.this.faf.setVisibility(0);
                    }
                }
                if (aUt.aUq() != null) {
                    aUt.aUq().update();
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
    public boolean eFc = false;

    public PersonGroupActivity aUt() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eFc) {
            this.faf.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.fak);
        MessageManager.getInstance().unRegisterListener(this.faj);
        MessageManager.getInstance().unRegisterListener(this.aof);
        MessageManager.getInstance().unRegisterListener(this.fai);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.fak);
        registerListener(2001106, this.fal);
        registerListener(103101, this.faj);
        registerListener(103112, this.faj);
        registerListener(103102, this.faj);
        registerListener(2001109, this.faj);
        registerListener(103104, this.faj);
        registerListener(103105, this.faj);
        registerListener(2001126, this.fai);
        registerListener(2001128, this.fai);
        registerListener(2001132, this.fai);
        registerListener(2001133, this.fai);
        registerListener(2001130, this.fai);
        registerListener(2001134, this.fai);
        registerListener(2001137, this.aof);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bfa != null) {
            this.bfa.e(aUt().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bfa != null) {
            this.bfa.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d aD;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(e.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aUt = aUt();
        if (aUt != null && !aUt.aUp()) {
            if (this.pageType == 0) {
                aD = NoDataViewFactory.d.go(String.format(getString(e.j.person_group_no_personal_info), aUt.aUo()));
            } else {
                aD = NoDataViewFactory.d.go(getString(e.j.person_group_no_common_info));
            }
        } else {
            aD = (aUt == null || !aUt.aUp()) ? null : NoDataViewFactory.d.aD(getString(e.j.group_no_data_tip), getString(e.j.group_no_data_tip_1));
        }
        this.bfa = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds102)), aD, null);
        this.faf = (BdListView) inflate.findViewById(e.g.person_group_list);
        this.mPullView = new k(getPageContext());
        this.fag = new a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                PersonGroupActivity aUt2 = PersonalGroupFragment.this.aUt();
                if (aUt2 != null) {
                    aUt2.aUq().update();
                }
            }
        });
        this.faf.setPullRefresh(this.mPullView);
        this.faf.setAdapter((ListAdapter) this.fag);
        this.faf.setOnItemClickListener(this);
        this.bfa.setVisibility(8);
        this.faf.removeHeaderView(this.bfa);
        this.fah = inflate.findViewById(e.g.group_fragment_parent);
        if (aUt() != null && this.pageType == aUt().aUn()) {
            this.faf.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.fag.getItem(i);
        PersonGroupActivity aUt = aUt();
        if (aUt != null && !aUt.b(item) && item != null) {
            if (this.pageType == 1 || aUt.aUp()) {
                if (aUt.aUp()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aUt.cv(item.getGroupId())) {
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
            PersonGroupActivity aUt = aUt();
            if (aUt != null && !aUt.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fag != null) {
            this.fag.notifyDataSetChanged();
        }
        if (this.bfa != null) {
            al.j(this.bfa, e.d.cp_bg_line_d);
        }
        if (isAdded()) {
            aUt().getLayoutMode().onModeChanged(this.fah);
            this.mPullView.ey(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.kV()) {
                    this.eFc = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
