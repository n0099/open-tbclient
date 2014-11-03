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
    private static final int[] bfK;
    private static final int[] bfL;
    private static final int[] bfM;
    private int JW;
    private int[] bfC;
    private String bfE;
    private ImageView bfG;
    private LinearLayout bfH;
    private LinearLayout bfI;
    private int bfJ;
    private FragmentTabHost bfN;
    private j bfO;
    private List<GroupInfoData> commonGroups;
    private List<GroupInfoData> groups;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bfB = -1;
    int bfD = 0;
    private boolean bfF = false;
    private View Jt = null;
    private k bfP = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        bfK = new int[]{u.icon_pop_key_all, u.icon_pop_key_f, u.icon_pop_key_d};
        bfL = new int[]{y.info_privacy_all, y.info_privacy_friend, y.info_privacy_hide};
        bfM = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.JW == 23003) {
            if (2 == this.bfJ) {
                a(com.baidu.tbadk.game.b.rU().rW(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId());
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
            this.bfB = bundle.getInt("key_current_tab", 0);
            this.JW = bundle.getInt("tb_request_code", 0);
            this.bfJ = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bfB = getIntent().getIntExtra("key_current_tab", 0);
            this.JW = getIntent().getIntExtra("tb_request_code", 0);
            this.bfJ = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bfE = getString(y.me);
            this.bfF = true;
        } else {
            this.bfF = false;
            switch (this.mSex) {
                case 1:
                    this.bfE = getString(y.he);
                    break;
                case 2:
                    this.bfE = getString(y.she);
                    break;
                default:
                    this.bfE = getString(y.ta);
                    break;
            }
        }
        if (this.bfP == null) {
            if (!this.bfF) {
                this.bfP = new k(this, com.baidu.adp.lib.g.c.a(this.mUid, 0L));
            } else {
                this.bfP = new k(this);
            }
        }
        if (com.baidu.adp.lib.util.l.aA(this.mUid)) {
            finish();
        } else {
            e(bundle);
        }
        if (this.bfJ != 1) {
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
        this.mNavigationBar.setTitleText(String.format(getString(y.person_group), this.bfE));
        this.Jt = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.Jt.setOnClickListener(new f(this));
        if (this.bfJ == 1) {
            this.mNavigationBar.setTitleText(getResources().getString(y.groups));
            this.bfH = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            this.bfH.setOnClickListener(new g(this));
            this.bfI = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.bfI.setOnClickListener(new h(this));
        } else if (this.bfF && this.JW != 23003) {
            this.bfG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_privacy, (View.OnClickListener) null);
            aw.c(this.bfG, bfK[com.baidu.tbadk.core.account.o.aL(3) - 1]);
            this.bfG.setOnClickListener(new i(this));
        }
        this.bfC = new int[]{0, 1};
        this.bfO = new j(this, this.bfF);
        this.bfN = (FragmentTabHost) findViewById(v.person_group_tab_host);
        this.bfN.setup(getSupportFragmentManager());
        this.bfN.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.bfN.setOnPageChangeListener(this);
        this.bfN.reset();
        QT();
        if (this.bfF) {
            this.bfN.getFragmentTabWidget().setVisibility(8);
        }
        this.bfN.setCurrentTab(this.bfB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nr() {
        showProgressBar();
        this.bfP.sendUserPermissionMessage(0L);
    }

    private void QT() {
        if (this.bfO != null) {
            boolean z = this.bfF ? true : true;
            Fragment item = this.bfO.getItem(0);
            int gf = this.bfO.gf(0);
            if (item != null) {
                a(item, gf, getString(y.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.bfO.getItem(1);
                int gf2 = this.bfO.gf(1);
                if (item2 != null) {
                    a(item2, gf2, getString(y.person_group_no_common_title));
                }
            }
            this.bfN.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.Cz = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.VR = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.Cy = fragmentTabIndicator;
            this.bfN.a(bVar);
        }
    }

    public void P(int i, int i2) {
        if (!this.bfF && this.bfO != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bfN.bk(0).Cy;
            if (i <= 0) {
                fragmentTabIndicator.setText(getString(y.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getString(y.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bfN.bk(1).Cy;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getString(y.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getString(y.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int QU() {
        return this.bfB == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        if (this.bfP == null) {
            this.bfP = new k(this);
        }
    }

    public String QV() {
        return this.bfE;
    }

    public boolean Az() {
        return this.bfF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bfB);
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
        if (i >= 0 && i < 2 && i != this.bfB) {
            this.bfB = i;
            if (!this.bfF && this.bfC[i] == 1) {
                TiebaStatic.eventStat(this, "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public k QW() {
        return this.bfP;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bfN.onChangeSkinType(i);
        aw.h(this.bfN, com.baidu.tieba.s.group_list_item_bg_n);
        if (this.bfO != null) {
            int i2 = this.bfF ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.bfO.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
