package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView bkP = null;
    private ak mPullView = null;
    private k bkQ = null;
    private x aft = null;
    private View bkR = null;
    private int bkT = 0;
    private final com.baidu.adp.framework.listener.e bkU = new n(this, 0);
    private final com.baidu.adp.framework.listener.e bkV = new o(this, 0);
    private final com.baidu.adp.framework.listener.e bkW = new p(this, 0);
    private final CustomMessageListener bkX = new q(this, 0);
    private final CustomMessageListener CL = new r(this, 0);
    public boolean bkS = false;

    public PersonGroupActivity RW() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bkS) {
            this.bkP.jJ();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.bkW);
        MessageManager.getInstance().unRegisterListener(this.bkV);
        MessageManager.getInstance().unRegisterListener(this.CL);
        MessageManager.getInstance().unRegisterListener(this.bkU);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.bkW);
        registerListener(2001106, this.bkX);
        registerListener(103101, this.bkV);
        registerListener(103112, this.bkV);
        registerListener(103102, this.bkV);
        registerListener(2001109, this.bkV);
        registerListener(103104, this.bkV);
        registerListener(103105, this.bkV);
        registerListener(2001130, this.bkU);
        registerListener(2001132, this.bkU);
        registerListener(2001136, this.bkU);
        registerListener(2001137, this.bkU);
        registerListener(2001134, this.bkU);
        registerListener(2001138, this.bkU);
        registerListener(2001141, this.CL);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aft != null) {
            this.aft.f(RW().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aft != null) {
            this.aft.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        ab abVar;
        this.bkT = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.person_group_fragment, viewGroup, false);
        PersonGroupActivity RW = RW();
        if (RW != null && !RW.RR()) {
            i = (int) getResources().getDimension(u.ds80);
            if (this.bkT == 0) {
                abVar = ab.cT(String.format(getString(z.person_group_no_personal_info), RW.RQ()));
            } else {
                abVar = ab.cT(getString(z.person_group_no_common_info));
            }
        } else if (RW == null || !RW.RR()) {
            i = 0;
            abVar = null;
        } else {
            i = (int) getResources().getDimension(u.ds160);
            abVar = ab.ac(getString(z.group_no_data_tip), getString(z.group_no_data_tip_1));
        }
        this.aft = NoDataViewFactory.a(getActivity(), inflate, aa.a(NoDataViewFactory.ImgType.NODATA, i), abVar, null);
        this.bkP = (BdListView) inflate.findViewById(w.person_group_list);
        this.mPullView = new ak(getBaseFragmentActivity().getPageContext());
        this.bkQ = new k(this);
        this.mPullView.a(new s(this));
        this.bkP.setPullRefresh(this.mPullView);
        this.bkP.setAdapter((ListAdapter) this.bkQ);
        this.bkP.setOnItemClickListener(this);
        this.aft.setVisibility(8);
        this.bkR = inflate.findViewById(w.group_fragment_parent);
        if (RW() != null && this.bkT == RW().RP()) {
            this.bkP.jJ();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.bkQ.getItem(i);
        PersonGroupActivity RW = RW();
        if (RW != null && !RW.b(item) && item != null) {
            if (this.bkT == 1 || RW.RR()) {
                if (RW.RR()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (RW.gw(item.getGroupId())) {
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
        if (view.getId() == w.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity RW = RW();
            if (RW != null && !RW.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aft != null) {
            bc.j(this.aft, t.cp_bg_line_d);
        }
        if (isAdded()) {
            RW().getLayoutMode().h(this.bkR);
            this.mPullView.cs(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDismissGroup(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.i.ff()) {
                    this.bkS = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
