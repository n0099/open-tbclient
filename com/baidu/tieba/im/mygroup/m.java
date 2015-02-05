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
    public BdListView bkO = null;
    private ak mPullView = null;
    private k bkP = null;
    private x afq = null;
    private View bkQ = null;
    private int bkS = 0;
    private final com.baidu.adp.framework.listener.e bkT = new n(this, 0);
    private final com.baidu.adp.framework.listener.e bkU = new o(this, 0);
    private final com.baidu.adp.framework.listener.e bkV = new p(this, 0);
    private final CustomMessageListener bkW = new q(this, 0);
    private final CustomMessageListener CI = new r(this, 0);
    public boolean bkR = false;

    public PersonGroupActivity RR() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bkR) {
            this.bkO.jC();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.bkV);
        MessageManager.getInstance().unRegisterListener(this.bkU);
        MessageManager.getInstance().unRegisterListener(this.CI);
        MessageManager.getInstance().unRegisterListener(this.bkT);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.bkV);
        registerListener(2001106, this.bkW);
        registerListener(103101, this.bkU);
        registerListener(103112, this.bkU);
        registerListener(103102, this.bkU);
        registerListener(2001109, this.bkU);
        registerListener(103104, this.bkU);
        registerListener(103105, this.bkU);
        registerListener(2001130, this.bkT);
        registerListener(2001132, this.bkT);
        registerListener(2001136, this.bkT);
        registerListener(2001137, this.bkT);
        registerListener(2001134, this.bkT);
        registerListener(2001138, this.bkT);
        registerListener(2001141, this.CI);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.afq != null) {
            this.afq.f(RR().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.afq != null) {
            this.afq.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        ab abVar;
        this.bkS = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.person_group_fragment, viewGroup, false);
        PersonGroupActivity RR = RR();
        if (RR != null && !RR.RM()) {
            i = (int) getResources().getDimension(u.ds80);
            if (this.bkS == 0) {
                abVar = ab.cQ(String.format(getString(z.person_group_no_personal_info), RR.RL()));
            } else {
                abVar = ab.cQ(getString(z.person_group_no_common_info));
            }
        } else if (RR == null || !RR.RM()) {
            i = 0;
            abVar = null;
        } else {
            i = (int) getResources().getDimension(u.ds160);
            abVar = ab.ac(getString(z.group_no_data_tip), getString(z.group_no_data_tip_1));
        }
        this.afq = NoDataViewFactory.a(getActivity(), inflate, aa.a(NoDataViewFactory.ImgType.NODATA, i), abVar, null);
        this.bkO = (BdListView) inflate.findViewById(w.person_group_list);
        this.mPullView = new ak(getBaseFragmentActivity().getPageContext());
        this.bkP = new k(this);
        this.mPullView.a(new s(this));
        this.bkO.setPullRefresh(this.mPullView);
        this.bkO.setAdapter((ListAdapter) this.bkP);
        this.bkO.setOnItemClickListener(this);
        this.afq.setVisibility(8);
        this.bkQ = inflate.findViewById(w.group_fragment_parent);
        if (RR() != null && this.bkS == RR().RK()) {
            this.bkO.jC();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.bkP.getItem(i);
        PersonGroupActivity RR = RR();
        if (RR != null && !RR.b(item) && item != null) {
            if (this.bkS == 1 || RR.RM()) {
                if (RR.RM()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (RR.gw(item.getGroupId())) {
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
            PersonGroupActivity RR = RR();
            if (RR != null && !RR.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.afq != null) {
            bc.j(this.afq, t.cp_bg_line_d);
        }
        if (isAdded()) {
            RR().getLayoutMode().h(this.bkQ);
            this.mPullView.cs(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDismissGroup(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.i.ff()) {
                    this.bkR = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
