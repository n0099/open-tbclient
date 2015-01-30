package com.baidu.tieba.addresslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.newFriends.NewFriendsActivityConfig;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tieba.addresslist.view.AssortView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseFragment implements com.baidu.adp.widget.ListView.g, com.baidu.tieba.addresslist.b.b, com.baidu.tieba.addresslist.view.a {
    private com.baidu.tieba.addresslist.c.a aoO;
    private f aoP;
    private g aoQ;
    private h aoR;
    private i aoS;
    private long aoT;
    private AssortView aoU;
    private View aoV;
    private BdListView aoW;
    private com.baidu.tieba.addresslist.a.a aoX;
    private int aoY;
    private boolean aoZ;
    private com.baidu.tbadk.core.c mLayoutMode;
    private View mParent;
    private ak mPullView;
    private boolean apa = false;
    private final CustomMessageListener mNetworkChangedMessageListener = new e(this, 2001121);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.aoT = 0L;
        this.aoO = new com.baidu.tieba.addresslist.c.a(getBaseFragmentActivity());
        this.aoO.setUniqueId(getUniqueId());
        this.aoZ = com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    private void registerListener() {
        this.aoP = new f(this);
        registerListener(this.aoP);
        this.aoQ = new g(this);
        registerListener(this.aoQ);
        this.aoR = new h(this);
        registerListener(this.aoR);
        this.aoS = new i(this);
        registerListener(this.aoS);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        Br();
        com.baidu.tbadk.core.i.B(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_list");
        if (this.apa && com.baidu.adp.lib.util.l.isNetOk()) {
            this.aoW.jJ();
        }
        if (com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Bq();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.aoO.b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity != null) {
            this.mLayoutMode = baseFragmentActivity.getLayoutMode();
        }
        return b(layoutInflater);
    }

    private View b(LayoutInflater layoutInflater) {
        this.mParent = layoutInflater.inflate(x.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new ak(getBaseFragmentActivity().getPageContext());
        this.aoX = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.m255getInst().getApplicationContext(), this.mLayoutMode);
        this.aoX.bk(this.aoZ);
        this.aoV = layoutInflater.inflate(x.addresslist_search_layout, (ViewGroup) null, false);
        this.aoV.setOnClickListener(this);
        this.aoW = (BdListView) this.mParent.findViewById(w.addresslist_contacts_list);
        this.aoW.setPullRefresh(this.mPullView);
        this.aoW.addHeaderView(this.aoV);
        this.aoW.setAdapter((ListAdapter) this.aoX);
        this.aoW.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.aoU = (AssortView) this.mParent.findViewById(w.addresslist_assortview);
        this.aoU.setClickable(true);
        this.aoU.setOnTouchListener(this);
        return this.mParent;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aoO.a(this);
        Bp();
    }

    private void Bp() {
        if (com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
            this.apa = true;
        }
        this.aoO.Bx();
    }

    private void Bq() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void Br() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189));
    }

    private void y(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.aoX.bk(this.aoZ);
        this.aoX.setContacts(list);
        this.aoX.ej(this.aoY);
        this.aoX.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.aoU.setVisibility(8);
        } else {
            this.aoU.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.b
    public void z(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        y(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.h(this.mParent);
            this.mLayoutMode.h(this.aoV);
        }
        this.mPullView.cs(i);
        this.aoX.notifyDataSetChanged();
        this.aoU.invalidate();
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.aoT) <= 30000) {
            this.aoW.jI();
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            this.aoT = System.currentTimeMillis();
            this.aoO.By();
        } else {
            this.aoW.jI();
            showToast(z.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == w.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
            this.aoY = 0;
            if (this.aoZ) {
                this.aoZ = false;
            }
            this.aoX.bk(this.aoZ);
            this.aoX.ej(this.aoY);
            this.aoX.notifyDataSetChanged();
            com.baidu.tbadk.core.i.A(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_new");
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            com.baidu.tbadk.core.i.A(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = this.aoX.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.m255getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void eP(String str) {
        int eR;
        List<com.baidu.tbadk.coreExtra.relationship.b> Bw = this.aoO.Bw();
        if (Bw != null && Bw.size() != 0 && (eR = this.aoO.eR(str)) >= 0) {
            this.aoW.setSelection(eR + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void Bs() {
    }
}
