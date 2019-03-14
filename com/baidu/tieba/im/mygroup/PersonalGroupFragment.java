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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
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
    public BdListView gqZ = null;
    private i mPullView = null;
    private a gra = null;
    private NoDataView cpw = null;
    private View grb = null;
    private int pageType = 0;
    private final c grc = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.fVS = true;
        }
    };
    private final c grd = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.fVS = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c gre = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity bvy = PersonalGroupFragment.this.bvy();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gqZ != null && bvy != null && bvy.bvv() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gqZ.completePullRefreshPostDelayed(0L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        PersonalGroupFragment.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? PersonalGroupFragment.this.getResources().getString(d.j.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (PersonalGroupFragment.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!bvy.bvu()) {
                    bvy.setGroups(responseGroupsByUidMessage.getGroups());
                    bvy.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                bvy.bM(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.gra.da(groups);
                    PersonalGroupFragment.this.gra.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.cpw.setVisibility(8);
                        PersonalGroupFragment.this.gqZ.removeHeaderView(PersonalGroupFragment.this.cpw);
                    } else {
                        PersonalGroupFragment.this.cpw.setVisibility(0);
                        PersonalGroupFragment.this.gqZ.removeHeaderView(PersonalGroupFragment.this.cpw);
                        PersonalGroupFragment.this.gqZ.addHeaderView(PersonalGroupFragment.this.cpw);
                    }
                    PersonalGroupFragment.this.gqZ.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.fVS = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && bvy.bvv() != null) {
                    bvy.bvv().update();
                }
            }
        }
    };
    private final CustomMessageListener grf = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity bvy = PersonalGroupFragment.this.bvy();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gqZ != null && bvy != null && bvy.bvv() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (bvy.bvu()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    bvy.bM(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.gra.da(groups);
                        PersonalGroupFragment.this.gra.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.cpw.setVisibility(8);
                            PersonalGroupFragment.this.gqZ.removeHeaderView(PersonalGroupFragment.this.cpw);
                        } else {
                            PersonalGroupFragment.this.cpw.setVisibility(0);
                            PersonalGroupFragment.this.gqZ.removeHeaderView(PersonalGroupFragment.this.cpw);
                            PersonalGroupFragment.this.gqZ.addHeaderView(PersonalGroupFragment.this.cpw);
                        }
                        PersonalGroupFragment.this.gqZ.setVisibility(0);
                    }
                }
                if (bvy.bvv() != null) {
                    bvy.bvv().update();
                }
            }
        }
    };
    private final CustomMessageListener bvt = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean fVS = false;

    public PersonGroupActivity bvy() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fVS) {
            this.gqZ.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.gre);
        MessageManager.getInstance().unRegisterListener(this.grd);
        MessageManager.getInstance().unRegisterListener(this.bvt);
        MessageManager.getInstance().unRegisterListener(this.grc);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.gre);
        registerListener(2001106, this.grf);
        registerListener(103101, this.grd);
        registerListener(103112, this.grd);
        registerListener(103102, this.grd);
        registerListener(2001109, this.grd);
        registerListener(103104, this.grd);
        registerListener(103105, this.grd);
        registerListener(2001126, this.grc);
        registerListener(2001128, this.grc);
        registerListener(2001132, this.grc);
        registerListener(2001133, this.grc);
        registerListener(2001130, this.grc);
        registerListener(2001134, this.grc);
        registerListener(2001137, this.bvt);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cpw != null) {
            this.cpw.e(bvy().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cpw != null) {
            this.cpw.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d bM;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(d.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity bvy = bvy();
        if (bvy != null && !bvy.bvu()) {
            if (this.pageType == 0) {
                bM = NoDataViewFactory.d.no(String.format(getString(d.j.person_group_no_personal_info), bvy.bvt()));
            } else {
                bM = NoDataViewFactory.d.no(getString(d.j.person_group_no_common_info));
            }
        } else {
            bM = (bvy == null || !bvy.bvu()) ? null : NoDataViewFactory.d.bM(getString(d.j.group_no_data_tip), getString(d.j.group_no_data_tip_1));
        }
        this.cpw = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), bM, null);
        this.gqZ = (BdListView) inflate.findViewById(d.g.person_group_list);
        this.mPullView = new i(getPageContext());
        this.gra = new a(this);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                PersonGroupActivity bvy2 = PersonalGroupFragment.this.bvy();
                if (bvy2 != null) {
                    bvy2.bvv().update();
                }
            }
        });
        this.gqZ.setPullRefresh(this.mPullView);
        this.gqZ.setAdapter((ListAdapter) this.gra);
        this.gqZ.setOnItemClickListener(this);
        this.cpw.setVisibility(8);
        this.gqZ.removeHeaderView(this.cpw);
        this.grb = inflate.findViewById(d.g.group_fragment_parent);
        if (bvy() != null && this.pageType == bvy().bvs()) {
            this.gqZ.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.gra.getItem(i);
        PersonGroupActivity bvy = bvy();
        if (bvy != null && !bvy.b(item) && item != null) {
            if (this.pageType == 1 || bvy.bvu()) {
                if (bvy.bvu()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (bvy.da(item.getGroupId())) {
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
        if (view.getId() == d.g.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity bvy = bvy();
            if (bvy != null && !bvy.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gra != null) {
            this.gra.notifyDataSetChanged();
        }
        if (this.cpw != null) {
            al.l(this.cpw, d.C0277d.cp_bg_line_d);
        }
        if (isAdded()) {
            bvy().getLayoutMode().onModeChanged(this.grb);
            this.mPullView.ic(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.kY()) {
                    this.fVS = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
