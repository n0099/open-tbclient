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
    private com.baidu.tieba.addresslist.c.a axl;
    private c axm;
    private d axn;
    private e axo;
    private f axp;
    private long axq;
    private LinearLayout axr;
    private AssortView axs;
    private LinearLayout axt;
    private BdListView axu;
    private com.baidu.tieba.addresslist.a.a axv;
    private TextView axw;
    private ImageView axx;
    private int axy;
    private com.baidu.tbadk.core.c mLayoutMode;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener mNetworkChangedMessageListener = new a(this, 2001121);
    private ag mPullView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.axq = 0L;
        this.axl = new com.baidu.tieba.addresslist.c.a(this);
        this.axl.setUniqueId(getUniqueId());
        EP();
        this.axl.a(this);
        EQ();
    }

    private void registerListener() {
        this.axm = new c(this);
        registerListener(this.axm);
        this.axn = new d(this);
        registerListener(this.axn);
        this.axo = new e(this);
        registerListener(this.axo);
        this.axp = new f(this);
        registerListener(this.axp);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ER();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.axl.b(this);
    }

    private void EP() {
        setContentView(w.addresslist_fragment);
        this.axr = (LinearLayout) findViewById(v.addresslist_container);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(y.my_good_friends));
        this.mPullView = new ag(getPageContext());
        this.axv = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.m411getInst().getApplicationContext(), this.mLayoutMode);
        this.axt = (LinearLayout) com.baidu.adp.lib.g.b.hH().a(getBaseContext(), w.addresslist_search_layout, null, false);
        this.axt.setOnClickListener(this);
        this.axx = (ImageView) this.axt.findViewById(v.addresslist_search_icon);
        this.axw = (TextView) this.axt.findViewById(v.addresslist_search_bar);
        this.axu = (BdListView) this.axr.findViewById(v.addresslist_contacts_list);
        this.axu.setPullRefresh(this.mPullView);
        this.axu.addHeaderView(this.axt);
        this.axu.setAdapter((ListAdapter) this.axv);
        this.axu.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.axs = (AssortView) this.axr.findViewById(v.addresslist_assortview);
        this.axs.setClickable(true);
        this.axs.setOnTouchListener(this);
        this.mLayoutMode = getLayoutMode();
    }

    private void EQ() {
        this.axl.Ft();
    }

    private void ER() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void t(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.axv.setContacts(list);
        this.axv.en(this.axy);
        this.axv.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.axs.setVisibility(8);
        } else {
            this.axs.setVisibility(0);
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
            this.mLayoutMode.h(this.axr);
            this.mLayoutMode.h(this.axt);
        }
        ba.i(this.axt, s.cp_bg_line_d);
        ba.i((View) this.axw, u.enter_forum_inputbox_top);
        ba.b(this.axw, s.cp_cont_d, 1);
        ba.i(this.axx, u.icon_head_bar_search);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ct(i);
        this.axv.notifyDataSetChanged();
        this.axs.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.axq) <= 30000) {
            this.axu.mW();
        } else if (com.baidu.adp.lib.util.n.isNetOk()) {
            this.axq = System.currentTimeMillis();
            this.axl.Fj();
        } else {
            this.axu.mW();
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
            this.axy = 0;
            this.axv.en(this.axy);
            this.axv.notifyDataSetChanged();
            com.baidu.tbadk.core.k.A(TbadkCoreApplication.m411getInst().getApplicationContext(), "contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            com.baidu.tbadk.core.k.A(TbadkCoreApplication.m411getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.axv.getItem(i);
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
    public void eW(String str) {
        int fl;
        List<com.baidu.tbadk.coreExtra.relationship.a> Fs = this.axl.Fs();
        if (Fs != null && Fs.size() != 0 && (fl = this.axl.fl(str)) >= 0) {
            this.axu.setSelection(fl + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void ES() {
    }
}
