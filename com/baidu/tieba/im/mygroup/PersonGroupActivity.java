package com.baidu.tieba.im.mygroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.Game2GroupShareDialogView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes13.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] iHL = {R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
    private static final int[] iHM = {R.drawable.icon_pop_key_all_bg_w, R.drawable.icon_pop_key_f_bg_w, R.drawable.icon_pop_key_d_bg_w};
    private static final int[] iHN = {R.string.info_privacy_all, R.string.info_privacy_friend, R.string.info_privacy_hide};
    private static final int[] iHO = {1, 2, 3};
    private List<GroupInfoData> commonGroups;
    private List<GroupInfoData> groups;
    private int[] iHB;
    private String iHD;
    private ImageView iHE;
    private LinearLayout iHF;
    private LinearLayout iHG;
    private ImageView iHH;
    private ImageView iHI;
    private int iHJ;
    private int iHK;
    private PersonGroupAdapter iHP;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private int fwd = -1;
    int iHC = 0;
    private boolean isHost = false;
    private View mBack = null;
    private PersonGroupModel iHQ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.iHJ == 23003) {
            if (2 == this.iHK) {
                a(com.baidu.tbadk.game.a.beh().bek(), groupInfoData.getGroupId(), groupInfoData.getName());
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

    private void a(final ShareFromGameCenterMsgData shareFromGameCenterMsgData, final long j, String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kG(1);
        final Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getContext());
        game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
        aVar.aP(game2GroupShareDialogView);
        aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long bk = b.cnY().bk(String.valueOf(j), 1);
                MessageUtils.createGroupChatMessage(bk, 9, shareFromGameCenterMsgData.toChatMessageContent(), j);
                MessageUtils.createGroupChatMessage(bk + 1, 1, game2GroupShareDialogView.getLeaveMsg(), j);
                aVar2.dismiss();
                PersonGroupActivity.this.setResult(-1);
                if (!j.isNetWorkAvailable()) {
                    PersonGroupActivity.this.showToast(PersonGroupActivity.this.getPageContext().getContext().getString(R.string.no_network_guide));
                }
                PersonGroupActivity.this.finish();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                ((InputMethodManager) PersonGroupActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(game2GroupShareDialogView.getWindowToken(), 2);
            }
        });
        aVar.b(getPageContext()).aST();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_person_group);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.fwd = bundle.getInt("key_current_tab", 0);
            this.iHJ = bundle.getInt("tb_request_code", 0);
            this.iHK = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.fwd = getIntent().getIntExtra("key_current_tab", 0);
            this.iHJ = getIntent().getIntExtra("tb_request_code", 0);
            this.iHK = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (TextUtils.equals(this.mUid, TbadkApplication.getCurrentAccount())) {
            this.iHD = getPageContext().getContext().getString(R.string.me);
            this.isHost = true;
        } else {
            this.isHost = false;
            switch (this.mSex) {
                case 1:
                    this.iHD = getPageContext().getContext().getString(R.string.he);
                    break;
                case 2:
                    this.iHD = getPageContext().getContext().getString(R.string.she);
                    break;
                default:
                    this.iHD = getPageContext().getContext().getString(R.string.ta);
                    break;
            }
        }
        if (this.iHQ == null) {
            if (!this.isHost) {
                this.iHQ = new PersonGroupModel(this, com.baidu.adp.lib.f.b.toLong(this.mUid, 0L));
            } else {
                this.iHQ = new PersonGroupModel(this);
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
        } else {
            av(bundle);
        }
        if (this.iHK != 1) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001506, TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            registerListener(new HttpMessageListener(1001506) { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage.isSuccess()) {
                        if (httpResponsedMessage.getError() == 0) {
                            e.aC(3, PersonGroupActivity.iHO[PersonGroupActivity.this.iHC]);
                            am.setNavbarIconSrc(PersonGroupActivity.this.iHE, PersonGroupActivity.iHM[PersonGroupActivity.this.iHC], PersonGroupActivity.iHL[PersonGroupActivity.this.iHC]);
                            PersonGroupActivity.this.showToastWithIcon(PersonGroupActivity.this.getPageContext().getContext().getString(PersonGroupActivity.iHN[PersonGroupActivity.this.iHC]), R.drawable.icon_toast_info);
                            PersonGroupActivity.this.iHE.setContentDescription(PersonGroupActivity.this.getPageContext().getString(PersonGroupActivity.iHN[e.jZ(3) % 3]));
                            return;
                        }
                        PersonGroupActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonGroupActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                    PersonGroupActivity.this.showToast(PersonGroupActivity.this.getPageContext().getContext().getString(R.string.neterror));
                }
            });
            return;
        }
        registerListener(CmdConfigSocket.CMD_GET_USER_PERMISSION, new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
                    try {
                        ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                        if (responseUserPermissionMessage.getError() > 0) {
                            PersonGroupActivity.this.showToast(StringUtils.isNull(responseUserPermissionMessage.getErrorString()) ? PersonGroupActivity.this.getResources().getString(R.string.neterror) : responseUserPermissionMessage.getErrorString());
                            return;
                        }
                        GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                        if (groupPermData != null) {
                            if (groupPermData.isCreatePersonal()) {
                                PersonGroupActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupStepActivityConfig(PersonGroupActivity.this.getPageContext().getContext(), 2, 0, 1012, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
                            } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                                PersonGroupActivity.this.showToast(groupPermData.getCreatePersonalTip());
                            }
                        }
                    } catch (Exception e) {
                    } finally {
                        PersonGroupActivity.this.hideProgressBar();
                    }
                }
            }
        });
    }

    private void av(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.person_group_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(String.format(getPageContext().getContext().getString(R.string.person_group), this.iHD));
        this.mNavigationBar.showBottomLine();
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonGroupActivity.this.finish();
            }
        });
        if (this.iHK == 1) {
            this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.groups));
            this.iHF = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            this.iHI = (ImageView) this.iHF.findViewById(R.id.group_create);
            if (TbadkCoreApplication.getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                this.iHF.setVisibility(4);
            } else {
                this.iHF.setVisibility(0);
            }
            this.iHF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PersonGroupActivity.this.coH();
                }
            });
            this.iHG = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.iHH = (ImageView) this.iHG.findViewById(R.id.search_gorup);
            this.iHG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PersonGroupActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddGroupActivityConfig(PersonGroupActivity.this.getPageContext().getPageActivity())));
                }
            });
        } else if (this.isHost && this.iHJ != 23003) {
            this.iHE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_privacy, (View.OnClickListener) null);
            am.setNavbarIconSrc(this.iHE, iHM[e.jZ(3) - 1], iHL[e.jZ(3) - 1]);
            this.iHC = e.jZ(3) % 3;
            this.iHE.setContentDescription(getPageContext().getString(iHN[this.iHC]));
            this.iHE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PersonGroupActivity.this.iHC = e.jZ(3) % 3;
                    HttpMessage httpMessage = new HttpMessage(1001506);
                    httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, TbEnum.ParamKey.GROUP);
                    httpMessage.addParam("val", String.valueOf(PersonGroupActivity.this.iHC + 1));
                    PersonGroupActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.iHB = new int[]{0, 1};
        this.iHP = new PersonGroupAdapter(this, this.isHost);
        this.mTabHost = (FragmentTabHost) findViewById(R.id.person_group_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight(l.getDimens(getApplicationContext(), R.dimen.ds80));
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        if (this.mTabHost.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mTabHost.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        }
        initTabSpec();
        if (this.isHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.fwd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coH() {
        showProgressBar();
        this.iHQ.eD(0L);
    }

    private void initTabSpec() {
        if (this.iHP != null) {
            boolean z = this.isHost ? true : true;
            Fragment item = this.iHP.getItem(0);
            int yb = this.iHP.yb(0);
            if (item != null) {
                a(item, yb, getPageContext().getContext().getString(R.string.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.iHP.getItem(1);
                int yb2 = this.iHP.yb(1);
                if (item2 != null) {
                    a(item2, yb2, getPageContext().getContext().getString(R.string.commongroup));
                }
            }
            this.mTabHost.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.mContentFragment = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
            bVar.dLP = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void cv(int i, int i2) {
        if (!this.isHost && this.iHP != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.kW(0).dLP;
            if (i <= 0) {
                fragmentTabIndicator.setText(getPageContext().getContext().getString(R.string.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(R.string.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.kW(1).dLP;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getPageContext().getContext().getString(R.string.commongroup));
            } else {
                fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(R.string.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int coI() {
        return this.fwd == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
        if (this.iHQ == null) {
            this.iHQ = new PersonGroupModel(this);
        }
    }

    public String coJ() {
        return this.iHD;
    }

    public boolean coK() {
        return this.isHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.fwd);
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
        if (i >= 0 && i < 2 && i != this.fwd) {
            this.fwd = i;
            if (!this.isHost && this.iHB[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), "common_group", "click", 1, new Object[0]);
            }
        }
    }

    public PersonGroupModel coL() {
        return this.iHQ;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public boolean eC(long j) {
        if (this.commonGroups != null && this.commonGroups.size() > 0) {
            Iterator<GroupInfoData> it = this.commonGroups.iterator();
            while (it.hasNext()) {
                if (j == it.next().getGroupId()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SvgManager.aUV().a(this.iHH, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        SvgManager.aUV().a(this.iHI, R.drawable.icon_pure_topbar_establish44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mTabHost.onChangeSkinType(i);
        am.setBackgroundResource(this.mTabHost, R.color.common_color_10173);
        if (this.iHP != null) {
            int i2 = this.isHost ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.iHP.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
