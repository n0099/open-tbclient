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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.Game2GroupShareDialogView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private List<GroupInfoData> commonGroups;
    private PersonGroupAdapter faC;
    private int[] faq;
    private String fas;
    private ImageView fat;
    private LinearLayout fau;
    private LinearLayout fav;
    private int faw;
    private int fax;
    private List<GroupInfoData> groups;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private static final int[] fay = {e.f.icon_pop_key_all_bg, e.f.icon_pop_key_f_bg, e.f.icon_pop_key_d_bg};
    private static final int[] faz = {e.f.icon_pop_key_all_bg_w, e.f.icon_pop_key_f_bg_w, e.f.icon_pop_key_d_bg_w};
    private static final int[] faA = {e.j.info_privacy_all, e.j.info_privacy_friend, e.j.info_privacy_hide};
    private static final int[] faB = {1, 2, 3};
    private int cat = -1;
    int far = 0;
    private boolean isHost = false;
    private View aNy = null;
    private PersonGroupModel faD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(GroupInfoData groupInfoData) {
        if (groupInfoData != null && this.faw == 23003) {
            if (2 == this.fax) {
                a(com.baidu.tbadk.game.a.Ny().NB(), groupInfoData.getGroupId(), groupInfoData.getName());
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
        aVar.dd(1);
        final Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getContext());
        game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
        aVar.G(game2GroupShareDialogView);
        aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long aC = b.aUa().aC(String.valueOf(j), 1);
                MessageUtils.createGroupChatMessage(aC, 9, shareFromGameCenterMsgData.toChatMessageContent(), j);
                MessageUtils.createGroupChatMessage(aC + 1, 1, game2GroupShareDialogView.getLeaveMsg(), j);
                aVar2.dismiss();
                PersonGroupActivity.this.setResult(-1);
                if (!j.kV()) {
                    PersonGroupActivity.this.showToast(PersonGroupActivity.this.getPageContext().getContext().getString(e.j.no_network_guide));
                }
                PersonGroupActivity.this.finish();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                ((InputMethodManager) PersonGroupActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(game2GroupShareDialogView.getWindowToken(), 2);
            }
        });
        aVar.b(getPageContext()).BS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.activity_person_group);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.cat = bundle.getInt("key_current_tab", 0);
            this.faw = bundle.getInt("tb_request_code", 0);
            this.fax = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.cat = getIntent().getIntExtra("key_current_tab", 0);
            this.faw = getIntent().getIntExtra("tb_request_code", 0);
            this.fax = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? TbadkApplication.getCurrentAccount() : this.mUid;
        if (TextUtils.equals(this.mUid, TbadkApplication.getCurrentAccount())) {
            this.fas = getPageContext().getContext().getString(e.j.me);
            this.isHost = true;
        } else {
            this.isHost = false;
            switch (this.mSex) {
                case 1:
                    this.fas = getPageContext().getContext().getString(e.j.he);
                    break;
                case 2:
                    this.fas = getPageContext().getContext().getString(e.j.she);
                    break;
                default:
                    this.fas = getPageContext().getContext().getString(e.j.ta);
                    break;
            }
        }
        if (this.faD == null) {
            if (!this.isHost) {
                this.faD = new PersonGroupModel(this, com.baidu.adp.lib.g.b.d(this.mUid, 0L));
            } else {
                this.faD = new PersonGroupModel(this);
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
        } else {
            y(bundle);
        }
        if (this.fax != 1) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            registerListener(new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage.isSuccess()) {
                        if (httpResponsedMessage.getError() == 0) {
                            com.baidu.tbadk.core.a.e.w(3, PersonGroupActivity.faB[PersonGroupActivity.this.far]);
                            al.a(PersonGroupActivity.this.fat, PersonGroupActivity.faz[PersonGroupActivity.this.far], PersonGroupActivity.fay[PersonGroupActivity.this.far]);
                            PersonGroupActivity.this.showToastWithIcon(PersonGroupActivity.this.getPageContext().getContext().getString(PersonGroupActivity.faA[PersonGroupActivity.this.far]), e.f.icon_toast_info);
                            PersonGroupActivity.this.fat.setContentDescription(PersonGroupActivity.this.getPageContext().getString(PersonGroupActivity.faA[com.baidu.tbadk.core.a.e.cz(3) % 3]));
                            return;
                        }
                        PersonGroupActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonGroupActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                    PersonGroupActivity.this.showToast(PersonGroupActivity.this.getPageContext().getContext().getString(e.j.neterror));
                }
            });
            return;
        }
        registerListener(103008, new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
                    try {
                        ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                        if (responseUserPermissionMessage.getError() > 0) {
                            PersonGroupActivity.this.showToast(StringUtils.isNull(responseUserPermissionMessage.getErrorString()) ? PersonGroupActivity.this.getResources().getString(e.j.neterror) : responseUserPermissionMessage.getErrorString());
                            return;
                        }
                        GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                        if (groupPermData != null) {
                            if (groupPermData.isCreatePersonal()) {
                                PersonGroupActivity.this.sendMessage(new CustomMessage(2002001, new CreateGroupStepActivityConfig(PersonGroupActivity.this.getPageContext().getContext(), 2, 0, 1012, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
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

    private void y(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.person_group_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(String.format(getPageContext().getContext().getString(e.j.person_group), this.fas));
        this.mNavigationBar.showBottomLine();
        this.aNy = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.aNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonGroupActivity.this.finish();
            }
        });
        if (this.fax == 1) {
            this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.groups));
            this.fau = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            if (TbadkCoreApplication.getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                this.fau.setVisibility(4);
            } else {
                this.fau.setVisibility(0);
            }
            this.fau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PersonGroupActivity.this.aUM();
                }
            });
            this.fav = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.fav.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PersonGroupActivity.this.sendMessage(new CustomMessage(2002001, new AddGroupActivityConfig(PersonGroupActivity.this.getPageContext().getPageActivity())));
                }
            });
        } else if (this.isHost && this.faw != 23003) {
            this.fat = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_privacy, (View.OnClickListener) null);
            al.a(this.fat, faz[com.baidu.tbadk.core.a.e.cz(3) - 1], fay[com.baidu.tbadk.core.a.e.cz(3) - 1]);
            this.far = com.baidu.tbadk.core.a.e.cz(3) % 3;
            this.fat.setContentDescription(getPageContext().getString(faA[this.far]));
            this.fat.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.mygroup.PersonGroupActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PersonGroupActivity.this.far = com.baidu.tbadk.core.a.e.cz(3) % 3;
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                    httpMessage.addParam("opt", "group");
                    httpMessage.addParam("val", String.valueOf(PersonGroupActivity.this.far + 1));
                    PersonGroupActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.faq = new int[]{0, 1};
        this.faC = new PersonGroupAdapter(this, this.isHost);
        this.mTabHost = (FragmentTabHost) findViewById(e.g.person_group_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight(l.h(getApplicationContext(), e.C0210e.ds80));
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(e.d.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        if (this.mTabHost.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mTabHost.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        }
        initTabSpec();
        if (this.isHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.cat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUM() {
        showProgressBar();
        this.faD.cw(0L);
    }

    private void initTabSpec() {
        if (this.faC != null) {
            boolean z = this.isHost ? true : true;
            Fragment item = this.faC.getItem(0);
            int qD = this.faC.qD(0);
            if (item != null) {
                a(item, qD, getPageContext().getContext().getString(e.j.person_group_no_personal_title));
            }
            if (z) {
                Fragment item2 = this.faC.getItem(1);
                int qD2 = this.faC.qD(1);
                if (item2 != null) {
                    a(item2, qD2, getPageContext().getContext().getString(e.j.commongroup));
                }
            }
            this.mTabHost.initViewPager();
        }
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.aAb = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.bem = e.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(e.C0210e.fontsize32));
            bVar.aAa = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void bq(int i, int i2) {
        if (!this.isHost && this.faC != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.dz(0).aAa;
            if (i <= 0) {
                fragmentTabIndicator.setText(getPageContext().getContext().getString(e.j.person_group_no_personal_title));
            } else {
                fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(e.j.person_group_personal), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.dz(1).aAa;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(getPageContext().getContext().getString(e.j.commongroup));
            } else {
                fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(e.j.person_group_common), Integer.valueOf(i2)));
            }
        }
    }

    public int aUN() {
        return this.cat == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
        if (this.faD == null) {
            this.faD = new PersonGroupModel(this);
        }
    }

    public String aUO() {
        return this.fas;
    }

    public boolean aUP() {
        return this.isHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cat);
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
        if (i >= 0 && i < 2 && i != this.cat) {
            this.cat = i;
            if (!this.isHost && this.faq[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), "common_group", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        }
    }

    public PersonGroupModel aUQ() {
        return this.faD;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public boolean cv(long j) {
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
        this.mTabHost.onChangeSkinType(i);
        al.i(this.mTabHost, e.d.common_color_10173);
        if (this.faC != null) {
            int i2 = this.isHost ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.faC.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }
}
