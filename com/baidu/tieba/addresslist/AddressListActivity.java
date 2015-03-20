package com.baidu.tieba.addresslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tbadk.newFriends.NewFriendsActivityConfig;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tieba.addresslist.view.AssortView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class AddressListActivity extends BaseActivity<AddressListActivity> implements ae, com.baidu.tieba.addresslist.b.b, com.baidu.tieba.addresslist.view.a {
    private com.baidu.tieba.addresslist.c.a axd;
    private c axe;
    private d axf;
    private e axg;
    private f axh;
    private long axi;
    private LinearLayout axj;
    private AssortView axk;
    private LinearLayout axl;
    private BdListView axm;
    private com.baidu.tieba.addresslist.a.a axn;
    private TextView axo;
    private ImageView axp;
    private int axq;
    private com.baidu.tbadk.core.c mLayoutMode;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener mNetworkChangedMessageListener = new a(this, 2001121);
    private ag mPullView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.axi = 0L;
        this.axd = new com.baidu.tieba.addresslist.c.a(this);
        this.axd.setUniqueId(getUniqueId());
        EJ();
        this.axd.a(this);
        EK();
    }

    private void registerListener() {
        this.axe = new c(this);
        registerListener(this.axe);
        this.axf = new d(this);
        registerListener(this.axf);
        this.axg = new e(this);
        registerListener(this.axg);
        this.axh = new f(this);
        registerListener(this.axh);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        EL();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.axd.b(this);
    }

    private void EJ() {
        setContentView(w.addresslist_fragment);
        this.axj = (LinearLayout) findViewById(v.addresslist_container);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(y.my_good_friends));
        this.mPullView = new ag(getPageContext());
        this.axn = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.m411getInst().getApplicationContext(), this.mLayoutMode);
        this.axl = (LinearLayout) com.baidu.adp.lib.g.b.hH().a(getBaseContext(), w.addresslist_search_layout, null, false);
        this.axl.setOnClickListener(this);
        this.axp = (ImageView) this.axl.findViewById(v.addresslist_search_icon);
        this.axo = (TextView) this.axl.findViewById(v.addresslist_search_bar);
        this.axm = (BdListView) this.axj.findViewById(v.addresslist_contacts_list);
        this.axm.setPullRefresh(this.mPullView);
        this.axm.addHeaderView(this.axl);
        this.axm.setAdapter((ListAdapter) this.axn);
        this.axm.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.axk = (AssortView) this.axj.findViewById(v.addresslist_assortview);
        this.axk.setClickable(true);
        this.axk.setOnTouchListener(this);
        this.mLayoutMode = getLayoutMode();
    }

    private void EK() {
        this.axd.Fn();
    }

    private void EL() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void t(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.axn.setContacts(list);
        this.axn.en(this.axq);
        this.axn.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.axk.setVisibility(8);
        } else {
            this.axk.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.b
    public void u(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        t(list);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.X(i == 1);
            this.mLayoutMode.h(this.axj);
            this.mLayoutMode.h(this.axl);
        }
        ba.i(this.axl, s.cp_bg_line_d);
        ba.i((View) this.axo, u.enter_forum_inputbox_top);
        ba.b(this.axo, s.cp_cont_d, 1);
        ba.i(this.axp, u.icon_head_bar_search);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ct(i);
        this.axn.notifyDataSetChanged();
        this.axk.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.axi) <= 30000) {
            this.axm.mW();
        } else if (com.baidu.adp.lib.util.n.isNetOk()) {
            this.axi = System.currentTimeMillis();
            this.axd.Fd();
        } else {
            this.axm.mW();
            showToast(y.no_network_guide);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == v.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            startActivity(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
            this.axq = 0;
            this.axn.en(this.axq);
            this.axn.notifyDataSetChanged();
            com.baidu.tbadk.core.k.A(TbadkCoreApplication.m411getInst().getApplicationContext(), "contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            com.baidu.tbadk.core.k.A(TbadkCoreApplication.m411getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.axn.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.m411getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void eT(String str) {
        int fi;
        List<com.baidu.tbadk.coreExtra.relationship.a> Fm = this.axd.Fm();
        if (Fm != null && Fm.size() != 0 && (fi = this.axd.fi(str)) >= 0) {
            this.axm.setSelection(fi + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void EM() {
    }
}
