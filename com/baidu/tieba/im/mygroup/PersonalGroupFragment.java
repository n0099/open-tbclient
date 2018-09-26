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
    public BdListView eHx = null;
    private k mPullView = null;
    private a eHy = null;
    private NoDataView aWl = null;
    private View eHz = null;
    private int pageType = 0;
    private final c eHA = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.emf = true;
        }
    };
    private final c eHB = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.emf = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c eHC = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aPd = PersonalGroupFragment.this.aPd();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eHx != null && aPd != null && aPd.aPa() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eHx.completePullRefreshPostDelayed(2000L);
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
                if (!aPd.aOZ()) {
                    aPd.setGroups(responseGroupsByUidMessage.getGroups());
                    aPd.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aPd.bm(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.eHy.cv(groups);
                    PersonalGroupFragment.this.eHy.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.aWl.setVisibility(8);
                        PersonalGroupFragment.this.eHx.removeHeaderView(PersonalGroupFragment.this.aWl);
                    } else {
                        PersonalGroupFragment.this.aWl.setVisibility(0);
                        PersonalGroupFragment.this.eHx.removeHeaderView(PersonalGroupFragment.this.aWl);
                        PersonalGroupFragment.this.eHx.addHeaderView(PersonalGroupFragment.this.aWl);
                    }
                    PersonalGroupFragment.this.eHx.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.emf = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aPd.aPa() != null) {
                    aPd.aPa().update();
                }
            }
        }
    };
    private final CustomMessageListener eHD = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aPd = PersonalGroupFragment.this.aPd();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.eHx != null && aPd != null && aPd.aPa() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aPd.aOZ()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aPd.bm(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.eHy.cv(groups);
                        PersonalGroupFragment.this.eHy.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.aWl.setVisibility(8);
                            PersonalGroupFragment.this.eHx.removeHeaderView(PersonalGroupFragment.this.aWl);
                        } else {
                            PersonalGroupFragment.this.aWl.setVisibility(0);
                            PersonalGroupFragment.this.eHx.removeHeaderView(PersonalGroupFragment.this.aWl);
                            PersonalGroupFragment.this.eHx.addHeaderView(PersonalGroupFragment.this.aWl);
                        }
                        PersonalGroupFragment.this.eHx.setVisibility(0);
                    }
                }
                if (aPd.aPa() != null) {
                    aPd.aPa().update();
                }
            }
        }
    };
    private final CustomMessageListener aeT = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean emf = false;

    public PersonGroupActivity aPd() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.emf) {
            this.eHx.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.eHC);
        MessageManager.getInstance().unRegisterListener(this.eHB);
        MessageManager.getInstance().unRegisterListener(this.aeT);
        MessageManager.getInstance().unRegisterListener(this.eHA);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.eHC);
        registerListener(2001106, this.eHD);
        registerListener(103101, this.eHB);
        registerListener(103112, this.eHB);
        registerListener(103102, this.eHB);
        registerListener(2001109, this.eHB);
        registerListener(103104, this.eHB);
        registerListener(103105, this.eHB);
        registerListener(2001126, this.eHA);
        registerListener(2001128, this.eHA);
        registerListener(2001132, this.eHA);
        registerListener(2001133, this.eHA);
        registerListener(2001130, this.eHA);
        registerListener(2001134, this.eHA);
        registerListener(2001137, this.aeT);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aWl != null) {
            this.aWl.e(aPd().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aWl != null) {
            this.aWl.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d ao;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(e.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aPd = aPd();
        if (aPd != null && !aPd.aOZ()) {
            if (this.pageType == 0) {
                ao = NoDataViewFactory.d.fG(String.format(getString(e.j.person_group_no_personal_info), aPd.aOY()));
            } else {
                ao = NoDataViewFactory.d.fG(getString(e.j.person_group_no_common_info));
            }
        } else {
            ao = (aPd == null || !aPd.aOZ()) ? null : NoDataViewFactory.d.ao(getString(e.j.group_no_data_tip), getString(e.j.group_no_data_tip_1));
        }
        this.aWl = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0141e.ds102)), ao, null);
        this.eHx = (BdListView) inflate.findViewById(e.g.person_group_list);
        this.mPullView = new k(getPageContext());
        this.eHy = new a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                PersonGroupActivity aPd2 = PersonalGroupFragment.this.aPd();
                if (aPd2 != null) {
                    aPd2.aPa().update();
                }
            }
        });
        this.eHx.setPullRefresh(this.mPullView);
        this.eHx.setAdapter((ListAdapter) this.eHy);
        this.eHx.setOnItemClickListener(this);
        this.aWl.setVisibility(8);
        this.eHx.removeHeaderView(this.aWl);
        this.eHz = inflate.findViewById(e.g.group_fragment_parent);
        if (aPd() != null && this.pageType == aPd().aOX()) {
            this.eHx.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.eHy.getItem(i);
        PersonGroupActivity aPd = aPd();
        if (aPd != null && !aPd.b(item) && item != null) {
            if (this.pageType == 1 || aPd.aOZ()) {
                if (aPd.aOZ()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aPd.ch(item.getGroupId())) {
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
        if (view.getId() == e.g.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity aPd = aPd();
            if (aPd != null && !aPd.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eHy != null) {
            this.eHy.notifyDataSetChanged();
        }
        if (this.aWl != null) {
            al.j(this.aWl, e.d.cp_bg_line_d);
        }
        if (isAdded()) {
            aPd().getLayoutMode().onModeChanged(this.eHz);
            this.mPullView.dM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.kK()) {
                    this.emf = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
