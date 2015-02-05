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
    private static final int[] bkt;
    private static final int[] bku;
    private static final int[] bkv;
    private FragmentTabHost aJm;
    private int[] bkl;
    private String bkn;
    private ImageView bkp;
    private LinearLayout bkq;
    private LinearLayout bkr;
    private int bks;
    private i bkw;
    private List<GroupInfoData> commonGroups;
    private List<GroupInfoData> groups;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private int bkk = -1;
    int bkm = 0;
    private boolean bko = false;
    private View mBack = null;
    private j bkx = null;

    static {
        TbadkApplication.getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        bkt = new int[]{v.icon_pop_key_all, v.icon_pop_key_f, v.icon_pop_key_d};
        bku = new int[]{z.info_privacy_all, z.info_privacy_friend, z.info_privacy_hide};
        bkv = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.requestCode == 23003) {
            if (2 == this.bks) {
                a(com.baidu.tbadk.game.b.vH().vJ(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId());
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
        aVar.bS(shareFromGameCenterMsgData.getTitle());
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getContext());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.j(bVar);
        aVar.a(z.share, new a(this, i, shareFromGameCenterMsgData, bVar));
        aVar.b(z.alert_no_button, new b(this, bVar));
        aVar.ai(false);
        aVar.b(getPageContext()).nQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.activity_person_group);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bkk = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.bks = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bkk = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.bks = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bkn = getPageContext().getContext().getString(z.me);
            this.bko = true;
        } else {
            this.bko = false;
            switch (this.mSex) {
                case 1:
                    this.bkn = getPageContext().getContext().getString(z.he);
                    break;
                case 2:
                    this.bkn = getPageContext().getContext().getString(z.she);
                    break;
                default:
                    this.bkn = getPageContext().getContext().getString(z.ta);
                    break;
            }
        }
        if (this.bkx == null) {
            if (!this.bko) {
                this.bkx = new j(this, com.baidu.adp.lib.g.c.a(this.mUid, 0L));
            } else {
                this.bkx = new j(this);
            }
        }
        if (com.baidu.adp.lib.util.k.isEmpty(this.mUid)) {
            finish();
        } else {
            initUI(bundle);
        }
        if (this.bks != 1) {
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
        this.mNavigationBar.setTitleText(String.format(getPageContext().getContext().getString(z.person_group), this.bkn));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new e(this));
        if (this.bks == 1) {
            this.mNavigationBar.setTitleText(getResources().getString(z.groups));
            this.bkq = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            if (TbadkCoreApplication.m255getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                this.bkq.setVisibility(4);
            } else {
                this.bkq.setVisibility(0);
            }
            this.bkq.setOnClickListener(new f(this));
            this.bkr = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.bkr.setOnClickListener(new g(this));
        } else if (this.bko && this.requestCode != 23003) {
            this.bkp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_privacy, (View.OnClickListener) null);
            bc.c(this.bkp, bkt[com.baidu.tbadk.core.account.o.bm(3) - 1]);
            this.bkp.setOnClickListener(new h(this));
        }
        this.bkl = new int[]{0, 1};
        this.bkw = new i(this, this.bko);
        this.aJm = (FragmentTabHost) findViewById(w.person_group_tab_host);
        this.aJm.setup(getSupportFragmentManager());
        this.aJm.setTabWidgetBackgroundColor(getResources().getColor(t.maintab_bg));
        this.aJm.setOnPageChangeListener(this);
        this.aJm.reset();
        RJ();
        if (this.bko) {
            this.aJm.getFragmentTabWidget().setVisibility(8);
        }
        this.aJm.setCurrentTab(this.bkk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OS() {
        showProgressBar();
        this.bkx.ab(0L);
    }

    private void RJ() {
        if (this.bkw != null) {
            boolean z = this.bko ? true : true;
            Fragment item = this.bkw.getItem(0);
            int gx = this.bkw.gx(0);
            if (item != null) {
                a(item, gx, getPageContext().getContext().getString(z.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.bkw.getItem(1);
                int gx2 = this.bkw.gx(1);
                if (item2 != null) {
                    a(item2, gx2, getPageContext().getContext().getString(z.person_group_no_common_title));
                }
            }
            this.aJm.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.GP = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.acl = t.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.fontsize32));
            bVar.GN = fragmentTabIndicator;
            this.aJm.a(bVar);
        }
    }

    public void Z(int i, int i2) {
        if (!this.bko && this.bkw != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aJm.bM(0).GN;
            if (i <= 0) {
                fragmentTabIndicator.setText(getPageContext().getContext().getString(z.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(z.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aJm.bM(1).GN;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getPageContext().getContext().getString(z.person_group_no_common_title));
            } else {
                fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(z.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int RK() {
        return this.bkk == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
        if (this.bkx == null) {
            this.bkx = new j(this);
        }
    }

    public String RL() {
        return this.bkn;
    }

    public boolean RM() {
        return this.bko;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bkk);
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
        if (i >= 0 && i < 2 && i != this.bkk) {
            this.bkk = i;
            if (!this.bko && this.bkl[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public j RN() {
        return this.bkx;
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
        this.aJm.onChangeSkinType(i);
        bc.i(this.aJm, t.group_list_item_bg_n);
        if (this.bkw != null) {
            int i2 = this.bko ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.bkw.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
