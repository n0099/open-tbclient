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
    private com.baidu.tieba.addresslist.c.a aoL;
    private f aoM;
    private g aoN;
    private h aoO;
    private i aoP;
    private long aoQ;
    private AssortView aoR;
    private View aoS;
    private BdListView aoT;
    private com.baidu.tieba.addresslist.a.a aoU;
    private int aoV;
    private boolean aoW;
    private com.baidu.tbadk.core.c mLayoutMode;
    private View mParent;
    private ak mPullView;
    private boolean aoX = false;
    private final CustomMessageListener mNetworkChangedMessageListener = new e(this, 2001121);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.aoQ = 0L;
        this.aoL = new com.baidu.tieba.addresslist.c.a(getBaseFragmentActivity());
        this.aoL.setUniqueId(getUniqueId());
        this.aoW = com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    private void registerListener() {
        this.aoM = new f(this);
        registerListener(this.aoM);
        this.aoN = new g(this);
        registerListener(this.aoN);
        this.aoO = new h(this);
        registerListener(this.aoO);
        this.aoP = new i(this);
        registerListener(this.aoP);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        Bl();
        com.baidu.tbadk.core.i.B(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_list");
        if (this.aoX && com.baidu.adp.lib.util.l.isNetOk()) {
            this.aoT.jC();
        }
        if (com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Bk();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.aoL.b(this);
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
        this.aoU = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.m255getInst().getApplicationContext(), this.mLayoutMode);
        this.aoU.bk(this.aoW);
        this.aoS = layoutInflater.inflate(x.addresslist_search_layout, (ViewGroup) null, false);
        this.aoS.setOnClickListener(this);
        this.aoT = (BdListView) this.mParent.findViewById(w.addresslist_contacts_list);
        this.aoT.setPullRefresh(this.mPullView);
        this.aoT.addHeaderView(this.aoS);
        this.aoT.setAdapter((ListAdapter) this.aoU);
        this.aoT.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.aoR = (AssortView) this.mParent.findViewById(w.addresslist_assortview);
        this.aoR.setClickable(true);
        this.aoR.setOnTouchListener(this);
        return this.mParent;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aoL.a(this);
        Bj();
    }

    private void Bj() {
        if (com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
            this.aoX = true;
        }
        this.aoL.Br();
    }

    private void Bk() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void Bl() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189));
    }

    private void y(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.aoU.bk(this.aoW);
        this.aoU.setContacts(list);
        this.aoU.ej(this.aoV);
        this.aoU.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.aoR.setVisibility(8);
        } else {
            this.aoR.setVisibility(0);
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
            this.mLayoutMode.h(this.aoS);
        }
        this.mPullView.cs(i);
        this.aoU.notifyDataSetChanged();
        this.aoR.invalidate();
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.aoQ) <= 30000) {
            this.aoT.jB();
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            this.aoQ = System.currentTimeMillis();
            this.aoL.Bs();
        } else {
            this.aoT.jB();
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
            this.aoV = 0;
            if (this.aoW) {
                this.aoW = false;
            }
            this.aoU.bk(this.aoW);
            this.aoU.ej(this.aoV);
            this.aoU.notifyDataSetChanged();
            com.baidu.tbadk.core.i.A(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_new");
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            com.baidu.tbadk.core.i.A(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = this.aoU.getItem(i);
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
    public void eM(String str) {
        int eO;
        List<com.baidu.tbadk.coreExtra.relationship.b> Bq = this.aoL.Bq();
        if (Bq != null && Bq.size() != 0 && (eO = this.aoL.eO(str)) >= 0) {
            this.aoT.setSelection(eO + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void Bm() {
    }
}
