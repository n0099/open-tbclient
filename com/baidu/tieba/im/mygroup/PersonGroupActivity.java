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
import com.baidu.tbadk.core.util.bc;
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
    private static final int[] bku;
    private static final int[] bkv;
    private static final int[] bkw;
    private FragmentTabHost aJp;
    private int[] bkm;
    private String bko;
    private ImageView bkq;
    private LinearLayout bkr;
    private LinearLayout bks;
    private int bkt;
    private i bkx;
    private List<GroupInfoData> commonGroups;
    private List<GroupInfoData> groups;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private int bkl = -1;
    int bkn = 0;
    private boolean bkp = false;
    private View mBack = null;
    private j bky = null;

    static {
        TbadkApplication.getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        bku = new int[]{v.icon_pop_key_all, v.icon_pop_key_f, v.icon_pop_key_d};
        bkv = new int[]{z.info_privacy_all, z.info_privacy_friend, z.info_privacy_hide};
        bkw = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.requestCode == 23003) {
            if (2 == this.bkt) {
                a(com.baidu.tbadk.game.b.vN().vP(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId());
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
        aVar.bV(shareFromGameCenterMsgData.getTitle());
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getContext());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.j(bVar);
        aVar.a(z.share, new a(this, i, shareFromGameCenterMsgData, bVar));
        aVar.b(z.alert_no_button, new b(this, bVar));
        aVar.ai(false);
        aVar.b(getPageContext()).nX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.activity_person_group);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bkl = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.bkt = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bkl = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.bkt = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bko = getPageContext().getContext().getString(z.me);
            this.bkp = true;
        } else {
            this.bkp = false;
            switch (this.mSex) {
                case 1:
                    this.bko = getPageContext().getContext().getString(z.he);
                    break;
                case 2:
                    this.bko = getPageContext().getContext().getString(z.she);
                    break;
                default:
                    this.bko = getPageContext().getContext().getString(z.ta);
                    break;
            }
        }
        if (this.bky == null) {
            if (!this.bkp) {
                this.bky = new j(this, com.baidu.adp.lib.g.c.a(this.mUid, 0L));
            } else {
                this.bky = new j(this);
            }
        }
        if (com.baidu.adp.lib.util.k.isEmpty(this.mUid)) {
            finish();
        } else {
            initUI(bundle);
        }
        if (this.bkt != 1) {
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
        this.mNavigationBar.setTitleText(String.format(getPageContext().getContext().getString(z.person_group), this.bko));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new e(this));
        if (this.bkt == 1) {
            this.mNavigationBar.setTitleText(getResources().getString(z.groups));
            this.bkr = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            if (TbadkCoreApplication.m255getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                this.bkr.setVisibility(4);
            } else {
                this.bkr.setVisibility(0);
            }
            this.bkr.setOnClickListener(new f(this));
            this.bks = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.bks.setOnClickListener(new g(this));
        } else if (this.bkp && this.requestCode != 23003) {
            this.bkq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_privacy, (View.OnClickListener) null);
            bc.c(this.bkq, bku[com.baidu.tbadk.core.account.o.bm(3) - 1]);
            this.bkq.setOnClickListener(new h(this));
        }
        this.bkm = new int[]{0, 1};
        this.bkx = new i(this, this.bkp);
        this.aJp = (FragmentTabHost) findViewById(w.person_group_tab_host);
        this.aJp.setup(getSupportFragmentManager());
        this.aJp.setTabWidgetBackgroundColor(getResources().getColor(t.maintab_bg));
        this.aJp.setOnPageChangeListener(this);
        this.aJp.reset();
        RO();
        if (this.bkp) {
            this.aJp.getFragmentTabWidget().setVisibility(8);
        }
        this.aJp.setCurrentTab(this.bkl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OX() {
        showProgressBar();
        this.bky.ab(0L);
    }

    private void RO() {
        if (this.bkx != null) {
            boolean z = this.bkp ? true : true;
            Fragment item = this.bkx.getItem(0);
            int gx = this.bkx.gx(0);
            if (item != null) {
                a(item, gx, getPageContext().getContext().getString(z.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.bkx.getItem(1);
                int gx2 = this.bkx.gx(1);
                if (item2 != null) {
                    a(item2, gx2, getPageContext().getContext().getString(z.person_group_no_common_title));
                }
            }
            this.aJp.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.GS = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.aco = t.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.fontsize32));
            bVar.GR = fragmentTabIndicator;
            this.aJp.a(bVar);
        }
    }

    public void Y(int i, int i2) {
        if (!this.bkp && this.bkx != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aJp.bM(0).GR;
            if (i <= 0) {
                fragmentTabIndicator.setText(getPageContext().getContext().getString(z.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(z.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aJp.bM(1).GR;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getPageContext().getContext().getString(z.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(z.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int RP() {
        return this.bkl == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
        if (this.bky == null) {
            this.bky = new j(this);
        }
    }

    public String RQ() {
        return this.bko;
    }

    public boolean RR() {
        return this.bkp;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bkl);
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
        if (i >= 0 && i < 2 && i != this.bkl) {
            this.bkl = i;
            if (!this.bkp && this.bkm[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public j RS() {
        return this.bky;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public boolean gw(int i) {
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
        this.aJp.onChangeSkinType(i);
        bc.i(this.aJp, t.group_list_item_bg_n);
        if (this.bkx != null) {
            int i2 = this.bkp ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.bkx.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
