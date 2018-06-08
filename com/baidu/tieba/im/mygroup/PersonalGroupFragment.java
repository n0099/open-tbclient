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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
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
    public BdListView esA = null;
    private g mPullView = null;
    private a esB = null;
    private NoDataView aSa = null;
    private View esC = null;
    private int pageType = 0;
    private final c esD = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.dXe = true;
        }
    };
    private final c esE = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.dXe = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c esF = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aLl = PersonalGroupFragment.this.aLl();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.esA != null && aLl != null && aLl.aLh() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.esA.completePullRefreshPostDelayed(2000L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        PersonalGroupFragment.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? PersonalGroupFragment.this.getResources().getString(d.k.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (PersonalGroupFragment.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!aLl.aLg()) {
                    aLl.setGroups(responseGroupsByUidMessage.getGroups());
                    aLl.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aLl.bh(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.esB.cq(groups);
                    PersonalGroupFragment.this.esB.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.aSa.setVisibility(8);
                        PersonalGroupFragment.this.esA.removeHeaderView(PersonalGroupFragment.this.aSa);
                    } else {
                        PersonalGroupFragment.this.aSa.setVisibility(0);
                        PersonalGroupFragment.this.esA.removeHeaderView(PersonalGroupFragment.this.aSa);
                        PersonalGroupFragment.this.esA.addHeaderView(PersonalGroupFragment.this.aSa);
                    }
                    PersonalGroupFragment.this.esA.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.dXe = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aLl.aLh() != null) {
                    aLl.aLh().update();
                }
            }
        }
    };
    private final CustomMessageListener esG = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aLl = PersonalGroupFragment.this.aLl();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.esA != null && aLl != null && aLl.aLh() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aLl.aLg()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aLl.bh(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.esB.cq(groups);
                        PersonalGroupFragment.this.esB.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.aSa.setVisibility(8);
                            PersonalGroupFragment.this.esA.removeHeaderView(PersonalGroupFragment.this.aSa);
                        } else {
                            PersonalGroupFragment.this.aSa.setVisibility(0);
                            PersonalGroupFragment.this.esA.removeHeaderView(PersonalGroupFragment.this.aSa);
                            PersonalGroupFragment.this.esA.addHeaderView(PersonalGroupFragment.this.aSa);
                        }
                        PersonalGroupFragment.this.esA.setVisibility(0);
                    }
                }
                if (aLl.aLh() != null) {
                    aLl.aLh().update();
                }
            }
        }
    };
    private final CustomMessageListener acJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean dXe = false;

    public PersonGroupActivity aLl() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dXe) {
            this.esA.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.esF);
        MessageManager.getInstance().unRegisterListener(this.esE);
        MessageManager.getInstance().unRegisterListener(this.acJ);
        MessageManager.getInstance().unRegisterListener(this.esD);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.esF);
        registerListener(2001106, this.esG);
        registerListener(103101, this.esE);
        registerListener(103112, this.esE);
        registerListener(103102, this.esE);
        registerListener(2001109, this.esE);
        registerListener(103104, this.esE);
        registerListener(103105, this.esE);
        registerListener(2001126, this.esD);
        registerListener(2001128, this.esD);
        registerListener(2001132, this.esD);
        registerListener(2001133, this.esD);
        registerListener(2001130, this.esD);
        registerListener(2001134, this.esD);
        registerListener(2001137, this.acJ);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aSa != null) {
            this.aSa.e(aLl().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aSa != null) {
            this.aSa.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d aj;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(d.i.person_group_fragment, viewGroup, false);
        PersonGroupActivity aLl = aLl();
        if (aLl != null && !aLl.aLg()) {
            if (this.pageType == 0) {
                aj = NoDataViewFactory.d.fk(String.format(getString(d.k.person_group_no_personal_info), aLl.aLf()));
            } else {
                aj = NoDataViewFactory.d.fk(getString(d.k.person_group_no_common_info));
            }
        } else {
            aj = (aLl == null || !aLl.aLg()) ? null : NoDataViewFactory.d.aj(getString(d.k.group_no_data_tip), getString(d.k.group_no_data_tip_1));
        }
        this.aSa = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), aj, null);
        this.esA = (BdListView) inflate.findViewById(d.g.person_group_list);
        this.mPullView = new g(getPageContext());
        this.esB = new a(this);
        this.mPullView.a(new f.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                PersonGroupActivity aLl2 = PersonalGroupFragment.this.aLl();
                if (aLl2 != null) {
                    aLl2.aLh().update();
                }
            }
        });
        this.esA.setPullRefresh(this.mPullView);
        this.esA.setAdapter((ListAdapter) this.esB);
        this.esA.setOnItemClickListener(this);
        this.aSa.setVisibility(8);
        this.esA.removeHeaderView(this.aSa);
        this.esC = inflate.findViewById(d.g.group_fragment_parent);
        if (aLl() != null && this.pageType == aLl().aLe()) {
            this.esA.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.esB.getItem(i);
        PersonGroupActivity aLl = aLl();
        if (aLl != null && !aLl.b(item) && item != null) {
            if (this.pageType == 1 || aLl.aLg()) {
                if (aLl.aLg()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aLl.cc(item.getGroupId())) {
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
            PersonGroupActivity aLl = aLl();
            if (aLl != null && !aLl.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.esB != null) {
            this.esB.notifyDataSetChanged();
        }
        if (this.aSa != null) {
            al.j(this.aSa, d.C0141d.cp_bg_line_d);
        }
        if (isAdded()) {
            aLl().getLayoutMode().onModeChanged(this.esC);
            this.mPullView.dy(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.jD()) {
                    this.dXe = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
