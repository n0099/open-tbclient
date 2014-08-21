package com.baidu.tieba.im.mygroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.List;
/* loaded from: classes.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] r;
    private static final int[] s;
    private static final int[] t;
    private int[] f;
    private String g;
    private String h;
    private int i;
    private NavigationBar k;
    private ImageView m;
    private LinearLayout n;
    private LinearLayout o;
    private int p;
    private int q;
    private FragmentTabHost u;
    private w v;
    private List<GroupInfoData> x;
    private List<GroupInfoData> y;
    private int e = -1;
    int d = 0;
    private boolean j = false;
    private View l = null;
    private x w = null;

    static {
        TbadkApplication.m252getInst().RegisterIntent(bg.class, PersonGroupActivity.class);
        r = new int[]{com.baidu.tieba.t.icon_pop_key_all, com.baidu.tieba.t.icon_pop_key_f, com.baidu.tieba.t.icon_pop_key_d};
        s = new int[]{com.baidu.tieba.x.info_privacy_all, com.baidu.tieba.x.info_privacy_friend, com.baidu.tieba.x.info_privacy_hide};
        t = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.p == 23003) {
            if (2 == this.q) {
                a(com.baidu.tbadk.game.c.a().c(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId());
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, groupInfoData.getGroupId());
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME, groupInfoData.getName());
            intent.putExtra("group_author_id", groupInfoData.getAuthorId());
            setResult(-1, intent);
            finish();
            return true;
        }
        return false;
    }

    private void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, int i, String str, int i2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.a(shareFromGameCenterMsgData.getShareSource());
        a aVar2 = new a(this);
        aVar2.setData(shareFromGameCenterMsgData);
        aVar.a(aVar2);
        aVar.a(com.baidu.tieba.x.share, new o(this, i, str, i2, aVar2, shareFromGameCenterMsgData));
        aVar.b(com.baidu.tieba.x.alert_no_button, new p(this, aVar2));
        aVar.a(false);
        aVar.a().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.activity_person_group);
        if (bundle != null) {
            this.g = bundle.getString("key_uid");
            this.i = bundle.getInt("key_sex", 0);
            this.e = bundle.getInt("key_current_tab", 0);
            this.p = bundle.getInt("tb_request_code", 0);
            this.q = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.g = getIntent().getStringExtra("key_uid");
            this.i = getIntent().getIntExtra("key_sex", 0);
            this.e = getIntent().getIntExtra("key_current_tab", 0);
            this.p = getIntent().getIntExtra("tb_request_code", 0);
            this.q = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.g = this.g == null ? TbadkApplication.getCurrentAccount() : this.g;
        if (this.g.equals(TbadkApplication.getCurrentAccount())) {
            this.h = getString(com.baidu.tieba.x.me);
            this.j = true;
        } else {
            this.j = false;
            switch (this.i) {
                case 1:
                    this.h = getString(com.baidu.tieba.x.he);
                    break;
                case 2:
                    this.h = getString(com.baidu.tieba.x.she);
                    break;
                default:
                    this.h = getString(com.baidu.tieba.x.ta);
                    break;
            }
        }
        if (this.w == null) {
            if (!this.j) {
                this.w = new x(this, com.baidu.adp.lib.e.c.a(this.g, 0L));
            } else {
                this.w = new x(this);
            }
        }
        if (com.baidu.adp.lib.util.i.c(this.g)) {
            finish();
        } else {
            a(bundle);
        }
        if (this.q != 1) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SET_PRIVATE);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            a(new q(this, CmdConfigHttp.SET_PRIVATE_CMD));
            return;
        }
        a(103008, new r(this, 0));
    }

    private void a(Bundle bundle) {
        this.k = (NavigationBar) findViewById(com.baidu.tieba.u.person_group_navigation_bar);
        this.k.a(String.format(getString(com.baidu.tieba.x.person_group), this.h));
        this.l = (View) this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.l.setOnClickListener(new s(this));
        if (this.q == 1) {
            this.k.a(getResources().getString(com.baidu.tieba.x.groups));
            this.n = (LinearLayout) this.k.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            this.n.setOnClickListener(new t(this));
            this.o = (LinearLayout) this.k.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.o.setOnClickListener(new u(this));
        } else if (this.j && this.p != 23003) {
            this.m = (ImageView) this.k.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_privacy, (View.OnClickListener) null);
            ay.c(this.m, r[com.baidu.tbadk.core.account.o.a(3) - 1]);
            this.m.setOnClickListener(new v(this));
        }
        this.f = new int[]{0, 1};
        this.v = new w(this, this.j);
        this.u = (FragmentTabHost) findViewById(com.baidu.tieba.u.person_group_tab_host);
        this.u.setup(getSupportFragmentManager());
        this.u.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.r.maintab_bg));
        this.u.setOnPageChangeListener(this);
        this.u.b();
        o();
        if (this.j) {
            this.u.getFragmentTabWidget().setVisibility(8);
        }
        this.u.setCurrentTab(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        e_();
        this.w.a(0L);
    }

    private void o() {
        if (this.v != null) {
            int i = this.j ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.v.getItem(i2);
                int a = this.v.a(i2);
                if (item != null) {
                    a(item, a, getString(com.baidu.tieba.x.person_group_no_common_title));
                }
            }
            this.u.a();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.c = fragment;
            bVar.a = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.b = com.baidu.tieba.r.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.r.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.s.fontsize32));
            bVar.b = fragmentTabIndicator;
            this.u.a(bVar);
        }
    }

    public void b(int i, int i2) {
        if (!this.j && this.v != null) {
            FragmentTabIndicator fragmentTabIndicator = this.u.a(0).b;
            if (i <= 0) {
                fragmentTabIndicator.setText(getString(com.baidu.tieba.x.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getString(com.baidu.tieba.x.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.u.a(1).b;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getString(com.baidu.tieba.x.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getString(com.baidu.tieba.x.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int g() {
        return this.e == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b(TbadkApplication.m252getInst().getSkinType());
        if (this.w == null) {
            this.w = new x(this);
        }
    }

    public String h() {
        return this.h;
    }

    public boolean i() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.e);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.e) {
            this.e = i;
            if (!this.j && this.f[i] == 1) {
                TiebaStatic.eventStat(this, "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public x j() {
        return this.w;
    }

    public void a(List<GroupInfoData> list) {
        this.x = list;
    }

    public void b(List<GroupInfoData> list) {
        this.y = list;
    }

    public boolean d(int i) {
        if (this.y != null && this.y.size() > 0) {
            for (GroupInfoData groupInfoData : this.y) {
                if (i == groupInfoData.getGroupId()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.k.c(i);
        this.u.b(i);
        ay.f(this.u, com.baidu.tieba.r.group_list_item_bg_n);
        if (this.v != null) {
            int i2 = this.j ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.v.getItem(i3);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).b(i);
                }
            }
        }
    }
}
