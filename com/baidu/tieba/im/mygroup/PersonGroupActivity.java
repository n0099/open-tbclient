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
import com.baidu.tbadk.core.atomData.ba;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.List;
/* loaded from: classes.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] p;
    private static final int[] q;
    private static final int[] r;
    private int[] e;
    private String f;
    private String g;
    private int h;
    private NavigationBar j;
    private ImageView l;
    private LinearLayout m;
    private int n;
    private int o;
    private FragmentTabHost s;
    private s t;
    private List<GroupInfoData> v;
    private List<GroupInfoData> w;
    private int d = -1;
    int c = 0;
    private boolean i = false;
    private View k = null;
    private t u = null;

    static {
        TbadkApplication.m252getInst().RegisterIntent(ba.class, PersonGroupActivity.class);
        p = new int[]{com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
        q = new int[]{com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
        r = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(GroupInfoData groupInfoData) {
        if (groupInfoData == null || this.n != 23003) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, groupInfoData.getGroupId());
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME, groupInfoData.getName());
        intent.putExtra("group_author_id", groupInfoData.getAuthorId());
        setResult(-1, intent);
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.activity_person_group);
        if (bundle != null) {
            this.f = bundle.getString("key_uid");
            this.h = bundle.getInt("key_sex", 0);
            this.d = bundle.getInt("key_current_tab", 0);
            this.n = bundle.getInt("tb_request_code", 0);
            this.o = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.f = getIntent().getStringExtra("key_uid");
            this.h = getIntent().getIntExtra("key_sex", 0);
            this.d = getIntent().getIntExtra("key_current_tab", 0);
            this.n = getIntent().getIntExtra("tb_request_code", 0);
            this.o = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.f = this.f == null ? "" : this.f;
        if (this.f.equals(TbadkApplication.getCurrentAccount())) {
            this.g = getString(com.baidu.tieba.y.me);
            this.i = true;
        } else {
            this.i = false;
            switch (this.h) {
                case 1:
                    this.g = getString(com.baidu.tieba.y.he);
                    break;
                case 2:
                    this.g = getString(com.baidu.tieba.y.she);
                    break;
                default:
                    this.g = getString(com.baidu.tieba.y.ta);
                    break;
            }
        }
        if (this.u == null) {
            if (!this.i) {
                this.u = new t(com.baidu.adp.lib.f.b.a(this.f, 0L));
            } else {
                this.u = new t();
            }
            this.u.setUniqueId(getUniqueId());
        }
        if (com.baidu.adp.lib.util.i.b(this.f)) {
            finish();
        } else {
            a(bundle);
        }
        if (this.o != 1) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001506, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SET_PRIVATE);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            a(new n(this, 1001506));
            return;
        }
        a(103008, new o(this, 0));
    }

    private void a(Bundle bundle) {
        this.j = (NavigationBar) findViewById(com.baidu.tieba.v.person_group_navigation_bar);
        this.j.a(String.format(getString(com.baidu.tieba.y.person_group), this.g));
        this.k = (View) this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.k.setOnClickListener(new p(this));
        if (this.o == 1) {
            this.m = (LinearLayout) this.j.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            this.m.setOnClickListener(new q(this));
        } else if (this.i && this.n != 23003) {
            this.l = (ImageView) this.j.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            bk.c(this.l, p[com.baidu.tbadk.core.account.o.a(3) - 1]);
            this.l.setOnClickListener(new r(this));
        }
        this.e = new int[]{0, 1};
        this.t = new s(this, this.i);
        this.s = (FragmentTabHost) findViewById(com.baidu.tieba.v.person_group_tab_host);
        this.s.setup(getSupportFragmentManager());
        this.s.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.s.setOnPageChangeListener(this);
        this.s.b();
        o();
        if (this.i) {
            this.s.getFragmentTabWidget().setVisibility(8);
        }
        this.s.setCurrentTab(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        e_();
        this.u.a(0L);
    }

    private void o() {
        if (this.t != null) {
            int i = this.i ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.t.getItem(i2);
                int a = this.t.a(i2);
                if (item != null) {
                    a(item, a, getString(com.baidu.tieba.y.person_group_no_common_title));
                }
            }
            this.s.a();
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
            fragmentTabIndicator.b = com.baidu.tieba.s.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.b = fragmentTabIndicator;
            this.s.a(bVar);
        }
    }

    public void b(int i, int i2) {
        if (!this.i && this.t != null) {
            FragmentTabIndicator fragmentTabIndicator = this.s.a(0).b;
            if (i <= 0) {
                fragmentTabIndicator.setText(getString(com.baidu.tieba.y.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getString(com.baidu.tieba.y.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.s.a(1).b;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getString(com.baidu.tieba.y.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getString(com.baidu.tieba.y.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int g() {
        return this.d == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b(TbadkApplication.m252getInst().getSkinType());
        if (this.u == null) {
            this.u = new t();
            this.u.setUniqueId(getUniqueId());
        }
    }

    public String h() {
        return this.g;
    }

    public boolean i() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.d);
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
        if (i >= 0 && i < 2 && i != this.d) {
            this.d = i;
            if (!this.i && this.e[i] == 1) {
                TiebaStatic.eventStat(this, "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public t j() {
        return this.u;
    }

    public void a(List<GroupInfoData> list) {
        this.v = list;
    }

    public void b(List<GroupInfoData> list) {
        this.w = list;
    }

    public boolean d(int i) {
        if (this.w != null && this.w.size() > 0) {
            for (GroupInfoData groupInfoData : this.w) {
                if (i == groupInfoData.getGroupId()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.j.c(i);
        this.s.b(i);
        bk.f(this.s, com.baidu.tieba.s.group_list_item_bg_n);
        if (this.t != null) {
            int i2 = this.i ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.t.getItem(i3);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).b(i);
                }
            }
        }
    }
}
