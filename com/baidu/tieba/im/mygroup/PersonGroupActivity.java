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
    private FragmentTabHost aPD;
    private i blB;
    private int[] blq;
    private String bls;
    private ImageView blu;
    private LinearLayout blv;
    private LinearLayout blw;
    private int blx;
    private List<GroupInfoData> commonGroups;
    private List<GroupInfoData> groups;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private static final int[] bly = {u.icon_pop_key_all, u.icon_pop_key_f, u.icon_pop_key_d};
    private static final int[] blz = {y.info_privacy_all, y.info_privacy_friend, y.info_privacy_hide};
    private static final int[] blA = {1, 2, 3};
    private int blp = -1;
    int blr = 0;
    private boolean blt = false;
    private View mBack = null;
    private j blC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.requestCode == 23003) {
            if (2 == this.blx) {
                a(com.baidu.tbadk.game.b.zn().zp(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId());
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
            this.blp = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.blx = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.blp = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.blx = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bls = getPageContext().getContext().getString(y.me);
            this.blt = true;
        } else {
            this.blt = false;
            switch (this.mSex) {
                case 1:
                    this.bls = getPageContext().getContext().getString(y.he);
                    break;
                case 2:
                    this.bls = getPageContext().getContext().getString(y.she);
                    break;
                default:
                    this.bls = getPageContext().getContext().getString(y.ta);
                    break;
            }
        }
        if (this.blC == null) {
            if (!this.blt) {
                this.blC = new j(this, com.baidu.adp.lib.g.c.a(this.mUid, 0L));
            } else {
                this.blC = new j(this);
            }
        }
        if (com.baidu.adp.lib.util.m.isEmpty(this.mUid)) {
            finish();
        } else {
            initUI(bundle);
        }
        if (this.blx != 1) {
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
        this.mNavigationBar.setTitleText(String.format(getPageContext().getContext().getString(y.person_group), this.bls));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new e(this));
        if (this.blx == 1) {
            this.mNavigationBar.setTitleText(getResources().getString(y.groups));
            this.blv = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            if (TbadkCoreApplication.m411getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                this.blv.setVisibility(4);
            } else {
                this.blv.setVisibility(0);
            }
            this.blv.setOnClickListener(new f(this));
            this.blw = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.blw.setOnClickListener(new g(this));
        } else if (this.blt && this.requestCode != 23003) {
            this.blu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_privacy, (View.OnClickListener) null);
            ba.c(this.blu, bly[com.baidu.tbadk.core.a.j.bl(3) - 1]);
            this.blu.setOnClickListener(new h(this));
        }
        this.blq = new int[]{0, 1};
        this.blB = new i(this, this.blt);
        this.aPD = (FragmentTabHost) findViewById(v.person_group_tab_host);
        this.aPD.setup(getSupportFragmentManager());
        this.aPD.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.aPD.setOnPageChangeListener(this);
        this.aPD.reset();
        Tb();
        if (this.blt) {
            this.aPD.getFragmentTabWidget().setVisibility(8);
        }
        this.aPD.setCurrentTab(this.blp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QB() {
        showProgressBar();
        this.blC.ab(0L);
    }

    private void Tb() {
        if (this.blB != null) {
            boolean z = this.blt ? true : true;
            Fragment item = this.blB.getItem(0);
            int gk = this.blB.gk(0);
            if (item != null) {
                a(item, gk, getPageContext().getContext().getString(y.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.blB.getItem(1);
                int gk2 = this.blB.gk(1);
                if (item2 != null) {
                    a(item2, gk2, getPageContext().getContext().getString(y.person_group_no_common_title));
                }
            }
            this.aPD.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.SS = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.alT = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.fontsize32));
            bVar.SR = fragmentTabIndicator;
            this.aPD.a(bVar);
        }
    }

    public void R(int i, int i2) {
        if (!this.blt && this.blB != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aPD.bN(0).SR;
            if (i <= 0) {
                fragmentTabIndicator.setText(getPageContext().getContext().getString(y.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(y.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aPD.bN(1).SR;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getPageContext().getContext().getString(y.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(y.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int Tc() {
        return this.blp == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
        if (this.blC == null) {
            this.blC = new j(this);
        }
    }

    public String Td() {
        return this.bls;
    }

    public boolean Te() {
        return this.blt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.blp);
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
        if (i >= 0 && i < 2 && i != this.blp) {
            this.blp = i;
            if (!this.blt && this.blq[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public j Tf() {
        return this.blC;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public boolean gj(int i) {
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
        this.aPD.onChangeSkinType(i);
        ba.i(this.aPD, com.baidu.tieba.s.group_list_item_bg_n);
        if (this.blB != null) {
            int i2 = this.blt ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.blB.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
