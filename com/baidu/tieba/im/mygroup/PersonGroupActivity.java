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
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
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
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] biX;
    private static final int[] biY;
    private static final int[] biZ;
    private FragmentTabHost aIf;
    private int[] biP;
    private String biR;
    private ImageView biT;
    private LinearLayout biU;
    private LinearLayout biV;
    private int biW;
    private i bja;
    private List<GroupInfoData> commonGroups;
    private List<GroupInfoData> groups;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private int biO = -1;
    int biQ = 0;
    private boolean biS = false;
    private View mBack = null;
    private j bjb = null;

    static {
        TbadkApplication.getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        biX = new int[]{v.icon_pop_key_all, v.icon_pop_key_f, v.icon_pop_key_d};
        biY = new int[]{z.info_privacy_all, z.info_privacy_friend, z.info_privacy_hide};
        biZ = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.requestCode == 23003) {
            if (2 == this.biW) {
                a(com.baidu.tbadk.game.b.vv().vx(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId());
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
        aVar.a(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.d(getPageContext().getContext(), u.ds640), -2));
        aVar.bX(shareFromGameCenterMsgData.getTitle());
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getContext());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.j(bVar);
        aVar.a(z.share, new a(this, i, shareFromGameCenterMsgData, bVar));
        aVar.b(z.alert_no_button, new b(this, bVar));
        aVar.ag(false);
        aVar.b(getPageContext()).nU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.activity_person_group);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.biO = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.biW = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.biO = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.biW = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.biR = getPageContext().getContext().getString(z.me);
            this.biS = true;
        } else {
            this.biS = false;
            switch (this.mSex) {
                case 1:
                    this.biR = getPageContext().getContext().getString(z.he);
                    break;
                case 2:
                    this.biR = getPageContext().getContext().getString(z.she);
                    break;
                default:
                    this.biR = getPageContext().getContext().getString(z.ta);
                    break;
            }
        }
        if (this.bjb == null) {
            if (!this.biS) {
                this.bjb = new j(this, com.baidu.adp.lib.g.c.a(this.mUid, 0L));
            } else {
                this.bjb = new j(this);
            }
        }
        if (com.baidu.adp.lib.util.k.isEmpty(this.mUid)) {
            finish();
        } else {
            initUI(bundle);
        }
        if (this.biW != 1) {
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
        this.mNavigationBar = (NavigationBar) findViewById(w.person_group_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getContext().getString(z.person_group), this.biR));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new e(this));
        if (this.biW == 1) {
            this.mNavigationBar.setTitleText(getResources().getString(z.groups));
            this.biU = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            if (TbadkCoreApplication.m255getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                this.biU.setVisibility(4);
            } else {
                this.biU.setVisibility(0);
            }
            this.biU.setOnClickListener(new f(this));
            this.biV = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.biV.setOnClickListener(new g(this));
        } else if (this.biS && this.requestCode != 23003) {
            this.biT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_privacy, (View.OnClickListener) null);
            ax.c(this.biT, biX[com.baidu.tbadk.core.account.o.bh(3) - 1]);
            this.biT.setOnClickListener(new h(this));
        }
        this.biP = new int[]{0, 1};
        this.bja = new i(this, this.biS);
        this.aIf = (FragmentTabHost) findViewById(w.person_group_tab_host);
        this.aIf.setup(getSupportFragmentManager());
        this.aIf.setTabWidgetBackgroundColor(getResources().getColor(t.maintab_bg));
        this.aIf.setOnPageChangeListener(this);
        this.aIf.reset();
        Rs();
        if (this.biS) {
            this.aIf.getFragmentTabWidget().setVisibility(8);
        }
        this.aIf.setCurrentTab(this.biO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OA() {
        showProgressBar();
        this.bjb.ab(0L);
    }

    private void Rs() {
        if (this.bja != null) {
            boolean z = this.biS ? true : true;
            Fragment item = this.bja.getItem(0);
            int go = this.bja.go(0);
            if (item != null) {
                a(item, go, getPageContext().getContext().getString(z.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.bja.getItem(1);
                int go2 = this.bja.go(1);
                if (item2 != null) {
                    a(item2, go2, getPageContext().getContext().getString(z.person_group_no_common_title));
                }
            }
            this.aIf.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.GI = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.abR = t.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.fontsize32));
            bVar.GH = fragmentTabIndicator;
            this.aIf.a(bVar);
        }
    }

    public void X(int i, int i2) {
        if (!this.biS && this.bja != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aIf.bH(0).GH;
            if (i <= 0) {
                fragmentTabIndicator.setText(getPageContext().getContext().getString(z.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(z.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aIf.bH(1).GH;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getPageContext().getContext().getString(z.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(z.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int Rt() {
        return this.biO == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
        if (this.bjb == null) {
            this.bjb = new j(this);
        }
    }

    public String Ru() {
        return this.biR;
    }

    public boolean Rv() {
        return this.biS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.biO);
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
        if (i >= 0 && i < 2 && i != this.biO) {
            this.biO = i;
            if (!this.biS && this.biP[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public j Rw() {
        return this.bjb;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public boolean gn(int i) {
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
        this.aIf.onChangeSkinType(i);
        ax.i(this.aIf, t.group_list_item_bg_n);
        if (this.bja != null) {
            int i2 = this.biS ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.bja.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
