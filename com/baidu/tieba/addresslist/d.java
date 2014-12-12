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
    private com.baidu.tieba.addresslist.c.a anT;
    private f anU;
    private g anV;
    private h anW;
    private i anX;
    private long anY;
    private AssortView anZ;
    private View aoa;
    private BdListView aob;
    private com.baidu.tieba.addresslist.a.a aoc;
    private int aod;
    private boolean aoe;
    private com.baidu.tbadk.core.c mLayoutMode;
    private View mParent;
    private ak mPullView;
    private boolean aof = false;
    private final CustomMessageListener mNetworkChangedMessageListener = new e(this, 2001121);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.anY = 0L;
        this.anT = new com.baidu.tieba.addresslist.c.a(getBaseFragmentActivity());
        this.anT.setUniqueId(getUniqueId());
        this.aoe = com.baidu.tbadk.core.sharedPref.b.og().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    private void registerListener() {
        this.anU = new f(this);
        registerListener(this.anU);
        this.anV = new g(this);
        registerListener(this.anV);
        this.anW = new h(this);
        registerListener(this.anW);
        this.anX = new i(this);
        registerListener(this.anX);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        AR();
        com.baidu.tbadk.core.i.C(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_list");
        if (this.aof && com.baidu.adp.lib.util.l.isNetOk()) {
            this.aob.jK();
        }
        if (com.baidu.tbadk.core.sharedPref.b.og().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.og().putBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        AQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.anT.b(this);
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
        this.mPullView = new ak(TbadkCoreApplication.m255getInst().getApplicationContext());
        this.aoc = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.m255getInst().getApplicationContext(), this.mLayoutMode);
        this.aoc.bi(this.aoe);
        this.aoa = layoutInflater.inflate(x.addresslist_search_layout, (ViewGroup) null, false);
        this.aoa.setOnClickListener(this);
        this.aob = (BdListView) this.mParent.findViewById(w.addresslist_contacts_list);
        this.aob.setPullRefresh(this.mPullView);
        this.aob.addHeaderView(this.aoa);
        this.aob.setAdapter((ListAdapter) this.aoc);
        this.aob.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.anZ = (AssortView) this.mParent.findViewById(w.addresslist_assortview);
        this.anZ.setClickable(true);
        this.anZ.setOnTouchListener(this);
        return this.mParent;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.anT.a(this);
        AP();
    }

    private void AP() {
        if (com.baidu.tbadk.core.sharedPref.b.og().getBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
            this.aof = true;
        }
        this.anT.AX();
    }

    private void AQ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void AR() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189));
    }

    private void y(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.aoc.bi(this.aoe);
        this.aoc.setContacts(list);
        this.aoc.ed(this.aod);
        this.aoc.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.anZ.setVisibility(8);
        } else {
            this.anZ.setVisibility(0);
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
            this.mLayoutMode.h(this.aoa);
        }
        this.mPullView.cl(i);
        this.aoc.notifyDataSetChanged();
        this.anZ.invalidate();
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.anY) <= 30000) {
            this.aob.jJ();
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            this.anY = System.currentTimeMillis();
            this.anT.AY();
        } else {
            this.aob.jJ();
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
            this.aod = 0;
            if (this.aoe) {
                this.aoe = false;
            }
            this.aoc.bi(this.aoe);
            this.aoc.ed(this.aod);
            this.aoc.notifyDataSetChanged();
            com.baidu.tbadk.core.i.B(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_new");
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            com.baidu.tbadk.core.i.B(TbadkCoreApplication.m255getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = this.aoc.getItem(i);
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
        int eP;
        List<com.baidu.tbadk.coreExtra.relationship.b> AW = this.anT.AW();
        if (AW != null && AW.size() != 0 && (eP = this.anT.eP(str)) >= 0) {
            this.aob.setSelection(eP + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void AS() {
    }
}
