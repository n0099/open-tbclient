package com.baidu.tieba.im.mygroup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.Game2GroupShareDialogView;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.r.s.a;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static final String CURRTABINDEX = "CurrTabIndex";
    public static final String KEY_PAGE_SIZE = "page_size";
    public static final String KEY_PAGE_TYPE = "page_type";
    public static final int PAGE_TYPE_AMOUNT = 2;
    public static final int PAGE_TYPE_COMMONGROUP = 1;
    public static final int PAGE_TYPE_PERSONALGROUP = 0;
    public static final int[] PRIVACY_IMAGE_LIST = {R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
    public static final int[] PRIVACY_IMAGE_LIST_DEEP = {R.drawable.icon_pop_key_all_bg_w, R.drawable.icon_pop_key_f_bg_w, R.drawable.icon_pop_key_d_bg_w};
    public static final int[] PRIVACY_INFO_TEXT_LIST = {R.string.info_privacy_all, R.string.info_privacy_friend, R.string.info_privacy_hide};
    public static final int[] PRIVATESTATE = {1, 2, 3};
    public static final String TAG = "PersonGroupActivity";
    public List<GroupInfoData> commonGroups;
    public int fromWhere;
    public List<GroupInfoData> groups;
    public ImageView mCreateGroup;
    public LinearLayout mCreateGroupButton;
    public NavigationBar mNavigationBar;
    public PersonGroupAdapter mPersonGroupAdapter;
    public ImageView mPrivacyButton;
    public ImageView mSearchGroup;
    public LinearLayout mSearchGroupButtion;
    public int mSex;
    public FragmentTabHost mTabHost;
    public int[] mTypes;
    public String mUid;
    public String mUtype;
    public int requestCode;
    public int mCurrTabIndex = -1;
    public int wantPrivcay = 0;
    public boolean isHost = false;
    public View mBack = null;
    public PersonGroupModel mModel = null;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f17744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareFromGameCenterMsgData f17745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f17746g;

        public a(long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, Game2GroupShareDialogView game2GroupShareDialogView) {
            this.f17744e = j;
            this.f17745f = shareFromGameCenterMsgData;
            this.f17746g = game2GroupShareDialogView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            long t = d.b.i0.e1.k.b.o().t(String.valueOf(this.f17744e), 1);
            MessageUtils.createGroupChatMessage(t, 9, this.f17745f.toChatMessageContent(), this.f17744e);
            MessageUtils.createGroupChatMessage(t + 1, 1, this.f17746g.getLeaveMsg(), this.f17744e);
            aVar.dismiss();
            PersonGroupActivity.this.setResult(-1);
            if (!j.z()) {
                PersonGroupActivity personGroupActivity = PersonGroupActivity.this;
                personGroupActivity.showToast(personGroupActivity.getPageContext().getContext().getString(R.string.no_network_guide));
            }
            PersonGroupActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f17748e;

        public b(Game2GroupShareDialogView game2GroupShareDialogView) {
            this.f17748e = game2GroupShareDialogView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            ((InputMethodManager) PersonGroupActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(this.f17748e.getWindowToken(), 2);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    d.b.h0.r.l.f.c(3, PersonGroupActivity.PRIVATESTATE[PersonGroupActivity.this.wantPrivcay]);
                    SkinManager.setNavbarIconSrc(PersonGroupActivity.this.mPrivacyButton, PersonGroupActivity.PRIVACY_IMAGE_LIST_DEEP[PersonGroupActivity.this.wantPrivcay], PersonGroupActivity.PRIVACY_IMAGE_LIST[PersonGroupActivity.this.wantPrivcay]);
                    PersonGroupActivity personGroupActivity = PersonGroupActivity.this;
                    personGroupActivity.showToastWithIcon(personGroupActivity.getPageContext().getContext().getString(PersonGroupActivity.PRIVACY_INFO_TEXT_LIST[PersonGroupActivity.this.wantPrivcay]), R.drawable.icon_toast_info);
                    PersonGroupActivity.this.mPrivacyButton.setContentDescription(PersonGroupActivity.this.getPageContext().getString(PersonGroupActivity.PRIVACY_INFO_TEXT_LIST[d.b.h0.r.l.f.a(3) % 3]));
                    return;
                }
                PersonGroupActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonGroupActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                return;
            }
            PersonGroupActivity personGroupActivity2 = PersonGroupActivity.this;
            personGroupActivity2.showToast(personGroupActivity2.getPageContext().getContext().getString(R.string.neterror));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.b.c.c.g.c {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUserPermissionMessage responseUserPermissionMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
                try {
                    responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                } catch (Exception unused) {
                } catch (Throwable th) {
                    PersonGroupActivity.this.hideProgressBar();
                    throw th;
                }
                if (responseUserPermissionMessage.getError() > 0) {
                    PersonGroupActivity.this.showToast(StringUtils.isNull(responseUserPermissionMessage.getErrorString()) ? PersonGroupActivity.this.getResources().getString(R.string.neterror) : responseUserPermissionMessage.getErrorString());
                    PersonGroupActivity.this.hideProgressBar();
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
                PersonGroupActivity.this.hideProgressBar();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonGroupActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonGroupActivity.this.sendUserPermissionMessage();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonGroupActivity.this.sendMessage(new CustomMessage(2002001, new AddGroupActivityConfig(PersonGroupActivity.this.getPageContext().getPageActivity())));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonGroupActivity.this.wantPrivcay = d.b.h0.r.l.f.a(3) % 3;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
            httpMessage.addParam("opt", "group");
            httpMessage.addParam("val", String.valueOf(PersonGroupActivity.this.wantPrivcay + 1));
            PersonGroupActivity.this.sendMessage(httpMessage);
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i, String str) {
        if (fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f12974c = fragment;
        bVar.f12972a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        bVar.f12973b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private void initTabSpec() {
        if (this.mPersonGroupAdapter != null) {
            char c2 = this.isHost ? (char) 1 : (char) 2;
            Fragment item = this.mPersonGroupAdapter.getItem(0);
            int i = this.mPersonGroupAdapter.i(0);
            if (item != null) {
                createAndAddTabSpec(item, i, getPageContext().getContext().getString(R.string.person_group_no_personal_title));
            }
            if (c2 == 2) {
                Fragment item2 = this.mPersonGroupAdapter.getItem(1);
                int i2 = this.mPersonGroupAdapter.i(1);
                if (item2 != null) {
                    createAndAddTabSpec(item2, i2, getPageContext().getContext().getString(R.string.commongroup));
                }
            }
            this.mTabHost.j();
        }
    }

    private void initUI(Bundle bundle) {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.person_group_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(String.format(getPageContext().getContext().getString(R.string.person_group), this.mUtype));
        this.mNavigationBar.showBottomLine();
        View view = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack = view;
        view.setOnClickListener(new e());
        if (this.fromWhere == 1) {
            this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.groups));
            LinearLayout linearLayout = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_create_group_btn, (View.OnClickListener) null);
            this.mCreateGroupButton = linearLayout;
            this.mCreateGroup = (ImageView) linearLayout.findViewById(R.id.group_create);
            if (TbadkCoreApplication.getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                this.mCreateGroupButton.setVisibility(4);
            } else {
                this.mCreateGroupButton.setVisibility(0);
            }
            this.mCreateGroupButton.setOnClickListener(new f());
            LinearLayout linearLayout2 = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search_group_btn, (View.OnClickListener) null);
            this.mSearchGroupButtion = linearLayout2;
            this.mSearchGroup = (ImageView) linearLayout2.findViewById(R.id.search_gorup);
            this.mSearchGroupButtion.setOnClickListener(new g());
        } else if (this.isHost && this.requestCode != 23003) {
            ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_privacy, (View.OnClickListener) null);
            this.mPrivacyButton = imageView;
            SkinManager.setNavbarIconSrc(imageView, PRIVACY_IMAGE_LIST_DEEP[d.b.h0.r.l.f.a(3) - 1], PRIVACY_IMAGE_LIST[d.b.h0.r.l.f.a(3) - 1]);
            this.wantPrivcay = d.b.h0.r.l.f.a(3) % 3;
            this.mPrivacyButton.setContentDescription(getPageContext().getString(PRIVACY_INFO_TEXT_LIST[this.wantPrivcay]));
            this.mPrivacyButton.setOnClickListener(new h());
        }
        this.mTypes = new int[]{0, 1};
        this.mPersonGroupAdapter = new PersonGroupAdapter(this, this.isHost);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.person_group_tab_host);
        this.mTabHost = fragmentTabHost;
        fragmentTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight(l.g(getApplicationContext(), R.dimen.ds80));
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.p();
        if (this.mTabHost.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mTabHost.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        }
        initTabSpec();
        if (this.isHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.mCurrTabIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserPermissionMessage() {
        showProgressBar();
        this.mModel.t(0L);
    }

    private void showConfirmShareToGroupDialog(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
        aVar.setContentViewSize(1);
        Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getContext());
        game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
        aVar.setContentView(game2GroupShareDialogView);
        aVar.setPositiveButton(R.string.share, new a(j, shareFromGameCenterMsgData, game2GroupShareDialogView));
        aVar.setNegativeButton(R.string.cancel, new b(game2GroupShareDialogView));
        aVar.create(getPageContext()).show();
    }

    public int getCurrentPageType() {
        return this.mCurrTabIndex == 0 ? 0 : 1;
    }

    public List<GroupInfoData> getGroups() {
        return this.groups;
    }

    public boolean getIsHost() {
        return this.isHost;
    }

    public PersonGroupModel getMyGroupModel() {
        return this.mModel;
    }

    public int getSex() {
        return this.mSex;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUtype() {
        return this.mUtype;
    }

    public List<GroupInfoData> getcommonGroups() {
        return this.groups;
    }

    public boolean isCommonGroup(long j) {
        List<GroupInfoData> list = this.commonGroups;
        if (list == null || list.size() <= 0) {
            return false;
        }
        Iterator<GroupInfoData> it = this.commonGroups.iterator();
        while (it.hasNext()) {
            if (j == it.next().getGroupId()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mSearchGroup, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mCreateGroup, R.drawable.icon_pure_topbar_establish44_svg, R.color.CAM_X0105, null);
        this.mTabHost.o(i);
        SkinManager.setBackgroundResource(this.mTabHost, R.color.common_color_10173);
        if (this.mPersonGroupAdapter != null) {
            int i2 = this.isHost ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.mPersonGroupAdapter.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_person_group);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.mCurrTabIndex = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.fromWhere = bundle.getInt("key_from_where", 0);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.mCurrTabIndex = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.fromWhere = getIntent().getIntExtra("key_from_where", 0);
        } else {
            finish();
        }
        String str = this.mUid;
        if (str == null) {
            str = TbadkCoreApplication.getCurrentAccount();
        }
        this.mUid = str;
        if (TextUtils.equals(str, TbadkCoreApplication.getCurrentAccount())) {
            this.mUtype = getPageContext().getContext().getString(R.string.me);
            this.isHost = true;
        } else {
            this.isHost = false;
            int i = this.mSex;
            if (i == 1) {
                this.mUtype = getPageContext().getContext().getString(R.string.he);
            } else if (i != 2) {
                this.mUtype = getPageContext().getContext().getString(R.string.ta);
            } else {
                this.mUtype = getPageContext().getContext().getString(R.string.she);
            }
        }
        if (this.mModel == null) {
            if (!this.isHost) {
                this.mModel = new PersonGroupModel(this, d.b.c.e.m.b.f(this.mUid, 0L));
            } else {
                this.mModel = new PersonGroupModel(this);
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
        } else {
            initUI(bundle);
        }
        if (this.fromWhere != 1) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            registerListener(new c(CmdConfigHttp.SET_PRIVATE_CMD));
            return;
        }
        registerListener(103008, new d(0));
    }

    public boolean onGroupSelected(GroupInfoData groupInfoData) {
        if (groupInfoData == null || this.requestCode != 23003) {
            return false;
        }
        if (2 == this.fromWhere) {
            showConfirmShareToGroupDialog(d.b.h0.y.a.d().e(), groupInfoData.getGroupId(), groupInfoData.getName());
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i < 0 || i >= 2 || i == this.mCurrTabIndex) {
            return;
        }
        this.mCurrTabIndex = i;
        if (this.isHost || this.mTypes[i] != 1) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getContext(), "common_group", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
        if (this.mModel == null) {
            this.mModel = new PersonGroupModel(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.mCurrTabIndex);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public void updateTabTitle(int i, int i2) {
        if (this.isHost || this.mPersonGroupAdapter == null) {
            return;
        }
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.g(0).f12973b;
        if (i <= 0) {
            fragmentTabIndicator.setText(getPageContext().getContext().getString(R.string.person_group_no_personal_title));
        } else {
            fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(R.string.person_group_personal), Integer.valueOf(i)));
        }
        FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.g(1).f12973b;
        if (i2 <= 0) {
            fragmentTabIndicator2.setText(getPageContext().getContext().getString(R.string.commongroup));
        } else {
            fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(R.string.person_group_common), Integer.valueOf(i2)));
        }
    }
}
