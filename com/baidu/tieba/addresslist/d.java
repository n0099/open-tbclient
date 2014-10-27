package com.baidu.tieba.addresslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.newFriends.NewFriendsActivityConfig;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tieba.addresslist.view.AssortView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseFragment implements com.baidu.adp.widget.ListView.f, com.baidu.tieba.addresslist.b.b, com.baidu.tieba.addresslist.view.a {
    private y Yc;
    private View agA;
    private AssortView agB;
    private View agC;
    private BdListView agD;
    private com.baidu.tieba.addresslist.a.a agE;
    private int agF;
    private boolean agG;
    private com.baidu.tieba.addresslist.c.a agu;
    private e agv;
    private f agw;
    private g agx;
    private h agy;
    private long agz;
    private com.baidu.tbadk.core.d mLayoutMode;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.agz = 0L;
        this.agu = new com.baidu.tieba.addresslist.c.a(getActivity());
        this.agu.setUniqueId(getUniqueId());
        this.agG = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("show_new_icon_for_new_friend_" + TbadkApplication.getCurrentAccount(), true);
        if (this.agG) {
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("show_new_icon_for_new_friend_" + TbadkApplication.getCurrentAccount(), false);
        }
    }

    private void registerListener() {
        this.agv = new e(this);
        registerListener(this.agv);
        this.agw = new f(this);
        registerListener(this.agw);
        this.agx = new g(this);
        registerListener(this.agx);
        this.agy = new h(this);
        registerListener(this.agy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xw();
        com.baidu.tbadk.core.i.m(TbadkApplication.m251getInst().getApplicationContext(), "contacts_list");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        xv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.agu.b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) getActivity();
        if (baseFragmentActivity != null) {
            this.mLayoutMode = baseFragmentActivity.getLayoutMode();
        }
        return b(layoutInflater);
    }

    private View b(LayoutInflater layoutInflater) {
        this.agA = layoutInflater.inflate(w.addresslist_fragment, (ViewGroup) null);
        this.Yc = new y(TbadkApplication.m251getInst().getApplicationContext());
        this.agE = new com.baidu.tieba.addresslist.a.a(TbadkApplication.m251getInst().getApplicationContext(), this.mLayoutMode);
        this.agE.bj(this.agG);
        this.agC = layoutInflater.inflate(w.addresslist_search_layout, (ViewGroup) null, false);
        this.agC.setOnClickListener(this);
        this.agD = (BdListView) this.agA.findViewById(v.addresslist_contacts_list);
        this.agD.setPullRefresh(this.Yc);
        this.agD.addHeaderView(this.agC);
        this.agD.setAdapter((ListAdapter) this.agE);
        this.agD.setOnItemClickListener(this);
        this.Yc.a(this);
        this.agB = (AssortView) this.agA.findViewById(v.addresslist_assortview);
        this.agB.setClickable(true);
        this.agB.setOnTouchListener(this);
        return this.agA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.agu.a(this);
        xu();
    }

    private void xu() {
        this.agu.xC();
    }

    private void xv() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void xw() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189));
    }

    private void t(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.agE.bj(this.agG);
        this.agE.setContacts(list);
        this.agE.dJ(this.agF);
        this.agE.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.agB.setVisibility(8);
        } else {
            this.agB.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.b
    public void u(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        t(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.h(this.agA);
            this.mLayoutMode.h(this.agC);
        }
        this.Yc.bM(i);
        this.agE.notifyDataSetChanged();
        this.agB.invalidate();
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.agz) <= 30000) {
            this.agD.hN();
        } else if (com.baidu.adp.lib.util.m.isNetOk()) {
            this.agz = System.currentTimeMillis();
            this.agu.xD();
        } else {
            this.agD.hN();
            showToast(com.baidu.tieba.y.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == v.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
            this.agF = 0;
            if (this.agG) {
                this.agG = false;
            }
            this.agE.bj(this.agG);
            this.agE.dJ(this.agF);
            this.agE.notifyDataSetChanged();
            com.baidu.tbadk.core.i.l(TbadkApplication.m251getInst().getApplicationContext(), "contacts_new");
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            com.baidu.tbadk.core.i.l(TbadkApplication.m251getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = this.agE.getItem(i);
            if (item != null && item.getUserId() > 0) {
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.m251getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void eg(String str) {
        int ej;
        List<com.baidu.tbadk.coreExtra.relationship.b> xB = this.agu.xB();
        if (xB != null && xB.size() != 0 && (ej = this.agu.ej(str)) >= 0) {
            this.agD.setSelection(ej + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void xx() {
    }
}
