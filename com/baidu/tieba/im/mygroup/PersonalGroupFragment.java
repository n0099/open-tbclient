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
    public BdListView faT = null;
    private k mPullView = null;
    private a faU = null;
    private NoDataView bfM = null;
    private View faV = null;
    private int pageType = 0;
    private final c faW = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.eFP = true;
        }
    };
    private final c faX = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.eFP = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c faY = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aUT = PersonalGroupFragment.this.aUT();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.faT != null && aUT != null && aUT.aUQ() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.faT.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
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
                if (!aUT.aUP()) {
                    aUT.setGroups(responseGroupsByUidMessage.getGroups());
                    aUT.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aUT.bq(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.faU.cO(groups);
                    PersonalGroupFragment.this.faU.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.bfM.setVisibility(8);
                        PersonalGroupFragment.this.faT.removeHeaderView(PersonalGroupFragment.this.bfM);
                    } else {
                        PersonalGroupFragment.this.bfM.setVisibility(0);
                        PersonalGroupFragment.this.faT.removeHeaderView(PersonalGroupFragment.this.bfM);
                        PersonalGroupFragment.this.faT.addHeaderView(PersonalGroupFragment.this.bfM);
                    }
                    PersonalGroupFragment.this.faT.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eFP = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aUT.aUQ() != null) {
                    aUT.aUQ().update();
                }
            }
        }
    };
    private final CustomMessageListener faZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aUT = PersonalGroupFragment.this.aUT();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.faT != null && aUT != null && aUT.aUQ() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aUT.aUP()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aUT.bq(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.faU.cO(groups);
                        PersonalGroupFragment.this.faU.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.bfM.setVisibility(8);
                            PersonalGroupFragment.this.faT.removeHeaderView(PersonalGroupFragment.this.bfM);
                        } else {
                            PersonalGroupFragment.this.bfM.setVisibility(0);
                            PersonalGroupFragment.this.faT.removeHeaderView(PersonalGroupFragment.this.bfM);
                            PersonalGroupFragment.this.faT.addHeaderView(PersonalGroupFragment.this.bfM);
                        }
                        PersonalGroupFragment.this.faT.setVisibility(0);
                    }
                }
                if (aUT.aUQ() != null) {
                    aUT.aUQ().update();
                }
            }
        }
    };
    private final CustomMessageListener aoI = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean eFP = false;

    public PersonGroupActivity aUT() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eFP) {
            this.faT.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.faY);
        MessageManager.getInstance().unRegisterListener(this.faX);
        MessageManager.getInstance().unRegisterListener(this.aoI);
        MessageManager.getInstance().unRegisterListener(this.faW);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.faY);
        registerListener(2001106, this.faZ);
        registerListener(103101, this.faX);
        registerListener(103112, this.faX);
        registerListener(103102, this.faX);
        registerListener(2001109, this.faX);
        registerListener(103104, this.faX);
        registerListener(103105, this.faX);
        registerListener(2001126, this.faW);
        registerListener(2001128, this.faW);
        registerListener(2001132, this.faW);
        registerListener(2001133, this.faW);
        registerListener(2001130, this.faW);
        registerListener(2001134, this.faW);
        registerListener(2001137, this.aoI);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bfM != null) {
            this.bfM.e(aUT().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bfM != null) {
            this.bfM.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d aE;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(e.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aUT = aUT();
        if (aUT != null && !aUT.aUP()) {
            if (this.pageType == 0) {
                aE = NoDataViewFactory.d.gC(String.format(getString(e.j.person_group_no_personal_info), aUT.aUO()));
            } else {
                aE = NoDataViewFactory.d.gC(getString(e.j.person_group_no_common_info));
            }
        } else {
            aE = (aUT == null || !aUT.aUP()) ? null : NoDataViewFactory.d.aE(getString(e.j.group_no_data_tip), getString(e.j.group_no_data_tip_1));
        }
        this.bfM = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds102)), aE, null);
        this.faT = (BdListView) inflate.findViewById(e.g.person_group_list);
        this.mPullView = new k(getPageContext());
        this.faU = new a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                PersonGroupActivity aUT2 = PersonalGroupFragment.this.aUT();
                if (aUT2 != null) {
                    aUT2.aUQ().update();
                }
            }
        });
        this.faT.setPullRefresh(this.mPullView);
        this.faT.setAdapter((ListAdapter) this.faU);
        this.faT.setOnItemClickListener(this);
        this.bfM.setVisibility(8);
        this.faT.removeHeaderView(this.bfM);
        this.faV = inflate.findViewById(e.g.group_fragment_parent);
        if (aUT() != null && this.pageType == aUT().aUN()) {
            this.faT.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.faU.getItem(i);
        PersonGroupActivity aUT = aUT();
        if (aUT != null && !aUT.b(item) && item != null) {
            if (this.pageType == 1 || aUT.aUP()) {
                if (aUT.aUP()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aUT.cv(item.getGroupId())) {
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
            PersonGroupActivity aUT = aUT();
            if (aUT != null && !aUT.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.faU != null) {
            this.faU.notifyDataSetChanged();
        }
        if (this.bfM != null) {
            al.j(this.bfM, e.d.cp_bg_line_d);
        }
        if (isAdded()) {
            aUT().getLayoutMode().onModeChanged(this.faV);
            this.mPullView.ey(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.kV()) {
                    this.eFP = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
