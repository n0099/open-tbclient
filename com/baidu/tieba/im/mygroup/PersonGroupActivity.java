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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bfw;
    private static final int[] bfx;
    private static final int[] bfy;
    private int JV;
    private j bfA;
    private int[] bfo;
    private String bfq;
    private ImageView bfs;
    private LinearLayout bft;
    private LinearLayout bfu;
    private int bfv;
    private FragmentTabHost bfz;
    private List<GroupInfoData> commonGroups;
    private List<GroupInfoData> groups;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bfn = -1;
    int bfp = 0;
    private boolean bfr = false;
    private View Js = null;
    private k bfB = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        bfw = new int[]{u.icon_pop_key_all, u.icon_pop_key_f, u.icon_pop_key_d};
        bfx = new int[]{y.info_privacy_all, y.info_privacy_friend, y.info_privacy_hide};
        bfy = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.JV == 23003) {
            if (2 == this.bfv) {
                a(com.baidu.tbadk.game.b.rS().rU(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId());
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra("group_id", groupInfoData.getGroupId());
            intent.putExtra("group_name", groupInfoData.getName());
            intent.putExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, groupInfoData.getAuthorId());
            setResult(-1, intent);
            finish();
            return true;
        }
        return false;
    }

    private void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, int i, String str, int i2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.a(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.m.c(this, com.baidu.tieba.t.ds640), -2));
        aVar.bf(shareFromGameCenterMsgData.getTitle());
        a aVar2 = new a(this);
        aVar2.setData(shareFromGameCenterMsgData);
        aVar.j(aVar2);
        aVar.a(y.share, new b(this, i, shareFromGameCenterMsgData, aVar2));
        aVar.b(y.alert_no_button, new c(this, aVar2));
        aVar.P(false);
        aVar.kT().kW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_person_group);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bfn = bundle.getInt("key_current_tab", 0);
            this.JV = bundle.getInt("tb_request_code", 0);
            this.bfv = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bfn = getIntent().getIntExtra("key_current_tab", 0);
            this.JV = getIntent().getIntExtra("tb_request_code", 0);
            this.bfv = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bfq = getString(y.me);
            this.bfr = true;
        } else {
            this.bfr = false;
            switch (this.mSex) {
                case 1:
                    this.bfq = getString(y.he);
                    break;
                case 2:
                    this.bfq = getString(y.she);
                    break;
                default:
                    this.bfq = getString(y.ta);
                    break;
            }
        }
        if (this.bfB == null) {
            if (!this.bfr) {
                this.bfB = new k(this, com.baidu.adp.lib.g.c.a(this.mUid, 0L));
            } else {
                this.bfB = new k(this);
            }
        }
        if (com.baidu.adp.lib.util.l.aA(this.mUid)) {
            finish();
        } else {
            e(bundle);
        }
        if (this.bfv != 1) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SET_PRIVATE);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            registerListener(new d(this, CmdConfigHttp.SET_PRIVATE_CMD));
            return;
        }
        registerListener(103008, new e(this, 0));
    }

    private void e(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(v.person_group_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getString(y.person_group), this.bfq));
        this.Js = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.Js.setOnClickListener(new f(this));
        if (this.bfv == 1) {
            this.mNavigationBar.setTitleText(getResources().getString(y.groups));
            this.bft = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            this.bft.setOnClickListener(new g(this));
            this.bfu = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.bfu.setOnClickListener(new h(this));
        } else if (this.bfr && this.JV != 23003) {
            this.bfs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_privacy, (View.OnClickListener) null);
            aw.c(this.bfs, bfw[com.baidu.tbadk.core.account.o.aL(3) - 1]);
            this.bfs.setOnClickListener(new i(this));
        }
        this.bfo = new int[]{0, 1};
        this.bfA = new j(this, this.bfr);
        this.bfz = (FragmentTabHost) findViewById(v.person_group_tab_host);
        this.bfz.setup(getSupportFragmentManager());
        this.bfz.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.bfz.setOnPageChangeListener(this);
        this.bfz.reset();
        QQ();
        if (this.bfr) {
            this.bfz.getFragmentTabWidget().setVisibility(8);
        }
        this.bfz.setCurrentTab(this.bfn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nn() {
        showProgressBar();
        this.bfB.sendUserPermissionMessage(0L);
    }

    private void QQ() {
        if (this.bfA != null) {
            boolean z = this.bfr ? true : true;
            Fragment item = this.bfA.getItem(0);
            int gf = this.bfA.gf(0);
            if (item != null) {
                a(item, gf, getString(y.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.bfA.getItem(1);
                int gf2 = this.bfA.gf(1);
                if (item2 != null) {
                    a(item2, gf2, getString(y.person_group_no_common_title));
                }
            }
            this.bfz.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.Cy = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.VN = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.Cx = fragmentTabIndicator;
            this.bfz.a(bVar);
        }
    }

    public void P(int i, int i2) {
        if (!this.bfr && this.bfA != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bfz.bk(0).Cx;
            if (i <= 0) {
                fragmentTabIndicator.setText(getString(y.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getString(y.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bfz.bk(1).Cx;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getString(y.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getString(y.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int QR() {
        return this.bfn == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        if (this.bfB == null) {
            this.bfB = new k(this);
        }
    }

    public String QS() {
        return this.bfq;
    }

    public boolean Ax() {
        return this.bfr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bfn);
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
        if (i >= 0 && i < 2 && i != this.bfn) {
            this.bfn = i;
            if (!this.bfr && this.bfo[i] == 1) {
                TiebaStatic.eventStat(this, "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public k QT() {
        return this.bfB;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public boolean ge(int i) {
        if (this.commonGroups != null && this.commonGroups.size() > 0) {
            for (GroupInfoData groupInfoData : this.commonGroups) {
                if (i == groupInfoData.getGroupId()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bfz.onChangeSkinType(i);
        aw.h(this.bfz, com.baidu.tieba.s.group_list_item_bg_n);
        if (this.bfA != null) {
            int i2 = this.bfr ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.bfA.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
