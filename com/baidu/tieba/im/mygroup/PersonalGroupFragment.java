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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
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
    public BdListView ehk = null;
    private f mPullView = null;
    private a ehl = null;
    private NoDataView aJz = null;
    private View ehm = null;
    private int pageType = 0;
    private final c ehn = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.dLS = true;
        }
    };
    private final c eho = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.dLS = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c ehp = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aGq = PersonalGroupFragment.this.aGq();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.ehk != null && aGq != null && aGq.aGm() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.ehk.completePullRefreshPostDelayed(2000L);
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
                if (!aGq.aGl()) {
                    aGq.setGroups(responseGroupsByUidMessage.getGroups());
                    aGq.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aGq.bf(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.ehl.cl(groups);
                    PersonalGroupFragment.this.ehl.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.aJz.setVisibility(8);
                        PersonalGroupFragment.this.ehk.removeHeaderView(PersonalGroupFragment.this.aJz);
                    } else {
                        PersonalGroupFragment.this.aJz.setVisibility(0);
                        PersonalGroupFragment.this.ehk.removeHeaderView(PersonalGroupFragment.this.aJz);
                        PersonalGroupFragment.this.ehk.addHeaderView(PersonalGroupFragment.this.aJz);
                    }
                    PersonalGroupFragment.this.ehk.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.dLS = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aGq.aGm() != null) {
                    aGq.aGm().update();
                }
            }
        }
    };
    private final CustomMessageListener ehq = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aGq = PersonalGroupFragment.this.aGq();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.ehk != null && aGq != null && aGq.aGm() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aGq.aGl()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aGq.bf(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.ehl.cl(groups);
                        PersonalGroupFragment.this.ehl.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.aJz.setVisibility(8);
                            PersonalGroupFragment.this.ehk.removeHeaderView(PersonalGroupFragment.this.aJz);
                        } else {
                            PersonalGroupFragment.this.aJz.setVisibility(0);
                            PersonalGroupFragment.this.ehk.removeHeaderView(PersonalGroupFragment.this.aJz);
                            PersonalGroupFragment.this.ehk.addHeaderView(PersonalGroupFragment.this.aJz);
                        }
                        PersonalGroupFragment.this.ehk.setVisibility(0);
                    }
                }
                if (aGq.aGm() != null) {
                    aGq.aGm().update();
                }
            }
        }
    };
    private final CustomMessageListener UJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean dLS = false;

    public PersonGroupActivity aGq() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dLS) {
            this.ehk.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.ehp);
        MessageManager.getInstance().unRegisterListener(this.eho);
        MessageManager.getInstance().unRegisterListener(this.UJ);
        MessageManager.getInstance().unRegisterListener(this.ehn);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.ehp);
        registerListener(2001106, this.ehq);
        registerListener(103101, this.eho);
        registerListener(103112, this.eho);
        registerListener(103102, this.eho);
        registerListener(2001109, this.eho);
        registerListener(103104, this.eho);
        registerListener(103105, this.eho);
        registerListener(2001126, this.ehn);
        registerListener(2001128, this.ehn);
        registerListener(2001132, this.ehn);
        registerListener(2001133, this.ehn);
        registerListener(2001130, this.ehn);
        registerListener(2001134, this.ehn);
        registerListener(2001137, this.UJ);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aJz != null) {
            this.aJz.e(aGq().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aJz != null) {
            this.aJz.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d af;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(d.i.person_group_fragment, viewGroup, false);
        PersonGroupActivity aGq = aGq();
        if (aGq != null && !aGq.aGl()) {
            if (this.pageType == 0) {
                af = NoDataViewFactory.d.eL(String.format(getString(d.k.person_group_no_personal_info), aGq.aGk()));
            } else {
                af = NoDataViewFactory.d.eL(getString(d.k.person_group_no_common_info));
            }
        } else {
            af = (aGq == null || !aGq.aGl()) ? null : NoDataViewFactory.d.af(getString(d.k.group_no_data_tip), getString(d.k.group_no_data_tip_1));
        }
        this.aJz = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), af, null);
        this.ehk = (BdListView) inflate.findViewById(d.g.person_group_list);
        this.mPullView = new f(getPageContext());
        this.ehl = new a(this);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                PersonGroupActivity aGq2 = PersonalGroupFragment.this.aGq();
                if (aGq2 != null) {
                    aGq2.aGm().update();
                }
            }
        });
        this.ehk.setPullRefresh(this.mPullView);
        this.ehk.setAdapter((ListAdapter) this.ehl);
        this.ehk.setOnItemClickListener(this);
        this.aJz.setVisibility(8);
        this.ehk.removeHeaderView(this.aJz);
        this.ehm = inflate.findViewById(d.g.group_fragment_parent);
        if (aGq() != null && this.pageType == aGq().aGj()) {
            this.ehk.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        GroupInfoData item = this.ehl.getItem(i);
        PersonGroupActivity aGq = aGq();
        if (aGq != null && !aGq.b(item) && item != null) {
            if (this.pageType == 1 || aGq.aGl()) {
                if (aGq.aGl()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aGq.bW(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else {
                TiebaStatic.eventStat(getActivity(), "his_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2.getId() == d.g.click_head) {
            GroupInfoData groupInfoData = null;
            if (view2.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view2.getTag();
            }
            PersonGroupActivity aGq = aGq();
            if (aGq != null && !aGq.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ehl != null) {
            this.ehl.notifyDataSetChanged();
        }
        if (this.aJz != null) {
            ak.j(this.aJz, d.C0126d.cp_bg_line_d);
        }
        if (isAdded()) {
            aGq().getLayoutMode().u(this.ehm);
            this.mPullView.dw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.gP()) {
                    this.dLS = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
