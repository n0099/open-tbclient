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
    private y Yg;
    private com.baidu.tieba.addresslist.c.a agC;
    private e agD;
    private f agE;
    private g agF;
    private h agG;
    private long agH;
    private View agI;
    private AssortView agJ;
    private View agK;
    private BdListView agL;
    private com.baidu.tieba.addresslist.a.a agM;
    private int agN;
    private boolean agO;
    private boolean agP = false;
    private com.baidu.tbadk.core.d mLayoutMode;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.agH = 0L;
        this.agC = new com.baidu.tieba.addresslist.c.a(getActivity());
        this.agC.setUniqueId(getUniqueId());
        this.agO = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("show_new_icon_for_new_friend_" + TbadkApplication.getCurrentAccount(), true);
        if (this.agO) {
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("show_new_icon_for_new_friend_" + TbadkApplication.getCurrentAccount(), false);
        }
    }

    private void registerListener() {
        this.agD = new e(this);
        registerListener(this.agD);
        this.agE = new f(this);
        registerListener(this.agE);
        this.agF = new g(this);
        registerListener(this.agF);
        this.agG = new h(this);
        registerListener(this.agG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xy();
        com.baidu.tbadk.core.j.m(TbadkApplication.m251getInst().getApplicationContext(), "contacts_list");
        if (this.agP) {
            this.agL.hO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        xx();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.agC.b(this);
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
        this.agI = layoutInflater.inflate(w.addresslist_fragment, (ViewGroup) null);
        this.Yg = new y(TbadkApplication.m251getInst().getApplicationContext());
        this.agM = new com.baidu.tieba.addresslist.a.a(TbadkApplication.m251getInst().getApplicationContext(), this.mLayoutMode);
        this.agM.bj(this.agO);
        this.agK = layoutInflater.inflate(w.addresslist_search_layout, (ViewGroup) null, false);
        this.agK.setOnClickListener(this);
        this.agL = (BdListView) this.agI.findViewById(v.addresslist_contacts_list);
        this.agL.setPullRefresh(this.Yg);
        this.agL.addHeaderView(this.agK);
        this.agL.setAdapter((ListAdapter) this.agM);
        this.agL.setOnItemClickListener(this);
        this.Yg.a(this);
        this.agJ = (AssortView) this.agI.findViewById(v.addresslist_assortview);
        this.agJ.setClickable(true);
        this.agJ.setOnTouchListener(this);
        return this.agI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.agC.a(this);
        xw();
    }

    private void xw() {
        if (com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), true)) {
            this.agP = true;
        }
        this.agC.xE();
    }

    private void xx() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void xy() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189));
    }

    private void t(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.agM.bj(this.agO);
        this.agM.setContacts(list);
        this.agM.dJ(this.agN);
        this.agM.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.agJ.setVisibility(8);
        } else {
            this.agJ.setVisibility(0);
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
            this.mLayoutMode.h(this.agI);
            this.mLayoutMode.h(this.agK);
        }
        this.Yg.bM(i);
        this.agM.notifyDataSetChanged();
        this.agJ.invalidate();
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (!z) {
            if (Math.abs(System.currentTimeMillis() - this.agH) <= 30000) {
                this.agL.hN();
            } else if (com.baidu.adp.lib.util.m.isNetOk()) {
                this.agH = System.currentTimeMillis();
                this.agC.xF();
            } else {
                this.agL.hN();
                showToast(com.baidu.tieba.y.no_network_guide);
            }
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
            this.agN = 0;
            if (this.agO) {
                this.agO = false;
            }
            this.agM.bj(this.agO);
            this.agM.dJ(this.agN);
            this.agM.notifyDataSetChanged();
            com.baidu.tbadk.core.j.l(TbadkApplication.m251getInst().getApplicationContext(), "contacts_new");
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            com.baidu.tbadk.core.j.l(TbadkApplication.m251getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = this.agM.getItem(i);
            if (item != null && item.getUserId() > 0) {
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.m251getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void eg(String str) {
        int ej;
        List<com.baidu.tbadk.coreExtra.relationship.b> xD = this.agC.xD();
        if (xD != null && xD.size() != 0 && (ej = this.agC.ej(str)) >= 0) {
            this.agL.setSelection(ej + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void xz() {
    }
}
