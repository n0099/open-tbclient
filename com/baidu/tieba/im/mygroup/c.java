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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
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
public class c extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView eLk = null;
    private k mPullView = null;
    private b eLl = null;
    private h byZ = null;
    private View eLm = null;
    private int pageType = 0;
    private final com.baidu.adp.framework.listener.c eLn = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.mygroup.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            c.this.epY = true;
        }
    };
    private final com.baidu.adp.framework.listener.c eLo = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.mygroup.c.3
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
                        c.this.epY = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eLp = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.mygroup.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aLu = c.this.aLu();
            if (c.this.getActivity() != null && c.this.eLk != null && aLu != null && aLu.aLq() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    c.this.eLk.completePullRefreshPostDelayed(2000L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        c.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? c.this.getResources().getString(d.j.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (c.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!aLu.aLp()) {
                    aLu.setGroups(responseGroupsByUidMessage.getGroups());
                    aLu.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aLu.ce(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    c.this.eLl.cp(groups);
                    c.this.eLl.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        c.this.byZ.setVisibility(8);
                        c.this.eLk.removeHeaderView(c.this.byZ);
                    } else {
                        c.this.byZ.setVisibility(0);
                        c.this.eLk.removeHeaderView(c.this.byZ);
                        c.this.eLk.addHeaderView(c.this.byZ);
                    }
                    c.this.eLk.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    c.this.epY = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aLu.aLq() != null) {
                    aLu.aLq().update();
                }
            }
        }
    };
    private final CustomMessageListener eLq = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aLu = c.this.aLu();
            if (c.this.getActivity() != null && c.this.eLk != null && aLu != null && aLu.aLq() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        c.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aLu.aLp()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (c.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aLu.ce(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        c.this.eLl.cp(groups);
                        c.this.eLl.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            c.this.byZ.setVisibility(8);
                            c.this.eLk.removeHeaderView(c.this.byZ);
                        } else {
                            c.this.byZ.setVisibility(0);
                            c.this.eLk.removeHeaderView(c.this.byZ);
                            c.this.eLk.addHeaderView(c.this.byZ);
                        }
                        c.this.eLk.setVisibility(0);
                    }
                }
                if (aLu.aLq() != null) {
                    aLu.aLq().update();
                }
            }
        }
    };
    private final CustomMessageListener aJr = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                c.this.d(p);
            }
        }
    };
    public boolean epY = false;

    public PersonGroupActivity aLu() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.epY) {
            this.eLk.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.eLp);
        MessageManager.getInstance().unRegisterListener(this.eLo);
        MessageManager.getInstance().unRegisterListener(this.aJr);
        MessageManager.getInstance().unRegisterListener(this.eLn);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.eLp);
        registerListener(2001106, this.eLq);
        registerListener(103101, this.eLo);
        registerListener(103112, this.eLo);
        registerListener(103102, this.eLo);
        registerListener(2001109, this.eLo);
        registerListener(103104, this.eLo);
        registerListener(103105, this.eLo);
        registerListener(2001126, this.eLn);
        registerListener(2001128, this.eLn);
        registerListener(2001132, this.eLn);
        registerListener(2001133, this.eLn);
        registerListener(2001130, this.eLn);
        registerListener(2001134, this.eLn);
        registerListener(2001137, this.aJr);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.byZ != null) {
            this.byZ.e(aLu().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.byZ != null) {
            this.byZ.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d ae;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(d.h.person_group_fragment, viewGroup, false);
        PersonGroupActivity aLu = aLu();
        if (aLu != null && !aLu.aLp()) {
            if (this.pageType == 0) {
                ae = NoDataViewFactory.d.eT(String.format(getString(d.j.person_group_no_personal_info), aLu.aLo()));
            } else {
                ae = NoDataViewFactory.d.eT(getString(d.j.person_group_no_common_info));
            }
        } else {
            ae = (aLu == null || !aLu.aLp()) ? null : NoDataViewFactory.d.ae(getString(d.j.group_no_data_tip), getString(d.j.group_no_data_tip_1));
        }
        this.byZ = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), ae, null);
        this.eLk = (BdListView) inflate.findViewById(d.g.person_group_list);
        this.mPullView = new k(getPageContext());
        this.eLl = new b(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.im.mygroup.c.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                PersonGroupActivity aLu2 = c.this.aLu();
                if (aLu2 != null) {
                    aLu2.aLq().update();
                }
            }
        });
        this.eLk.setPullRefresh(this.mPullView);
        this.eLk.setAdapter((ListAdapter) this.eLl);
        this.eLk.setOnItemClickListener(this);
        this.byZ.setVisibility(8);
        this.eLk.removeHeaderView(this.byZ);
        this.eLm = inflate.findViewById(d.g.group_fragment_parent);
        if (aLu() != null && this.pageType == aLu().aLn()) {
            this.eLk.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.eLl.getItem(i);
        PersonGroupActivity aLu = aLu();
        if (aLu != null && !aLu.b(item) && item != null) {
            if (this.pageType == 1 || aLu.aLp()) {
                if (aLu.aLp()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aLu.qw(item.getGroupId())) {
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
            PersonGroupActivity aLu = aLu();
            if (aLu != null && !aLu.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eLl != null) {
            this.eLl.notifyDataSetChanged();
        }
        if (this.byZ != null) {
            aj.t(this.byZ, d.C0141d.cp_bg_line_d);
        }
        if (isAdded()) {
            aLu().getLayoutMode().aM(this.eLm);
            this.mPullView.gx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.oJ()) {
                    this.epY = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
