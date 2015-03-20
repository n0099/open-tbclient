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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bli = {u.icon_pop_key_all, u.icon_pop_key_f, u.icon_pop_key_d};
    private static final int[] blj = {y.info_privacy_all, y.info_privacy_friend, y.info_privacy_hide};
    private static final int[] blk = {1, 2, 3};
    private FragmentTabHost aPm;
    private int[] bla;
    private String blc;
    private ImageView ble;
    private LinearLayout blf;
    private LinearLayout blg;
    private int blh;
    private i bll;
    private List<GroupInfoData> commonGroups;
    private List<GroupInfoData> groups;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private int bkZ = -1;
    int blb = 0;
    private boolean bld = false;
    private View mBack = null;
    private j blm = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.requestCode == 23003) {
            if (2 == this.blh) {
                a(com.baidu.tbadk.game.b.zh().zj(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId());
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.a(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.n.d(getPageContext().getContext(), t.ds640), -2));
        aVar.bZ(shareFromGameCenterMsgData.getTitle());
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getContext());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.j(bVar);
        aVar.a(y.share, new a(this, i, shareFromGameCenterMsgData, bVar));
        aVar.b(y.alert_no_button, new b(this, bVar));
        aVar.ad(false);
        aVar.b(getPageContext()).re();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_person_group);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bkZ = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.blh = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bkZ = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.blh = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.blc = getPageContext().getContext().getString(y.me);
            this.bld = true;
        } else {
            this.bld = false;
            switch (this.mSex) {
                case 1:
                    this.blc = getPageContext().getContext().getString(y.he);
                    break;
                case 2:
                    this.blc = getPageContext().getContext().getString(y.she);
                    break;
                default:
                    this.blc = getPageContext().getContext().getString(y.ta);
                    break;
            }
        }
        if (this.blm == null) {
            if (!this.bld) {
                this.blm = new j(this, com.baidu.adp.lib.g.c.a(this.mUid, 0L));
            } else {
                this.blm = new j(this);
            }
        }
        if (com.baidu.adp.lib.util.m.isEmpty(this.mUid)) {
            finish();
        } else {
            initUI(bundle);
        }
        if (this.blh != 1) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SET_PRIVATE);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            registerListener(new c(this, CmdConfigHttp.SET_PRIVATE_CMD));
            return;
        }
        registerListener(103008, new d(this, 0));
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(v.person_group_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getContext().getString(y.person_group), this.blc));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new e(this));
        if (this.blh == 1) {
            this.mNavigationBar.setTitleText(getResources().getString(y.groups));
            this.blf = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            if (TbadkCoreApplication.m411getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                this.blf.setVisibility(4);
            } else {
                this.blf.setVisibility(0);
            }
            this.blf.setOnClickListener(new f(this));
            this.blg = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.blg.setOnClickListener(new g(this));
        } else if (this.bld && this.requestCode != 23003) {
            this.ble = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_privacy, (View.OnClickListener) null);
            ba.c(this.ble, bli[com.baidu.tbadk.core.a.j.bl(3) - 1]);
            this.ble.setOnClickListener(new h(this));
        }
        this.bla = new int[]{0, 1};
        this.bll = new i(this, this.bld);
        this.aPm = (FragmentTabHost) findViewById(v.person_group_tab_host);
        this.aPm.setup(getSupportFragmentManager());
        this.aPm.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.aPm.setOnPageChangeListener(this);
        this.aPm.reset();
        SO();
        if (this.bld) {
            this.aPm.getFragmentTabWidget().setVisibility(8);
        }
        this.aPm.setCurrentTab(this.bkZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qo() {
        showProgressBar();
        this.blm.ab(0L);
    }

    private void SO() {
        if (this.bll != null) {
            boolean z = this.bld ? true : true;
            Fragment item = this.bll.getItem(0);
            int gi = this.bll.gi(0);
            if (item != null) {
                a(item, gi, getPageContext().getContext().getString(y.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.bll.getItem(1);
                int gi2 = this.bll.gi(1);
                if (item2 != null) {
                    a(item2, gi2, getPageContext().getContext().getString(y.person_group_no_common_title));
                }
            }
            this.aPm.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.SQ = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.alL = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.fontsize32));
            bVar.SP = fragmentTabIndicator;
            this.aPm.a(bVar);
        }
    }

    public void R(int i, int i2) {
        if (!this.bld && this.bll != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aPm.bN(0).SP;
            if (i <= 0) {
                fragmentTabIndicator.setText(getPageContext().getContext().getString(y.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(y.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aPm.bN(1).SP;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getPageContext().getContext().getString(y.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(y.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int SP() {
        return this.bkZ == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
        if (this.blm == null) {
            this.blm = new j(this);
        }
    }

    public String SQ() {
        return this.blc;
    }

    public boolean SR() {
        return this.bld;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bkZ);
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
        if (i >= 0 && i < 2 && i != this.bkZ) {
            this.bkZ = i;
            if (!this.bld && this.bla[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public j SS() {
        return this.blm;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public boolean gh(int i) {
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
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aPm.onChangeSkinType(i);
        ba.i(this.aPm, com.baidu.tieba.s.group_list_item_bg_n);
        if (this.bll != null) {
            int i2 = this.bld ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.bll.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
