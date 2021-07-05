package com.baidu.tieba.im.mygroup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.s.a;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CURRTABINDEX = "CurrTabIndex";
    public static final String KEY_PAGE_SIZE = "page_size";
    public static final String KEY_PAGE_TYPE = "page_type";
    public static final int PAGE_TYPE_AMOUNT = 2;
    public static final int PAGE_TYPE_COMMONGROUP = 1;
    public static final int PAGE_TYPE_PERSONALGROUP = 0;
    public static final int[] PRIVACY_IMAGE_LIST;
    public static final int[] PRIVACY_IMAGE_LIST_DEEP;
    public static final int[] PRIVACY_INFO_TEXT_LIST;
    public static final int[] PRIVATESTATE;
    public static final String TAG = "PersonGroupActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public List<GroupInfoData> commonGroups;
    public int fromWhere;
    public List<GroupInfoData> groups;
    public boolean isHost;
    public View mBack;
    public ImageView mCreateGroup;
    public LinearLayout mCreateGroupButton;
    public int mCurrTabIndex;
    public PersonGroupModel mModel;
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
    public int wantPrivcay;

    /* loaded from: classes5.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f17587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareFromGameCenterMsgData f17588f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f17589g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PersonGroupActivity f17590h;

        public a(PersonGroupActivity personGroupActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity, Long.valueOf(j), shareFromGameCenterMsgData, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17590h = personGroupActivity;
            this.f17587e = j;
            this.f17588f = shareFromGameCenterMsgData;
            this.f17589g = game2GroupShareDialogView;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                long t = d.a.s0.i1.k.b.o().t(String.valueOf(this.f17587e), 1);
                MessageUtils.createGroupChatMessage(t, 9, this.f17588f.toChatMessageContent(), this.f17587e);
                MessageUtils.createGroupChatMessage(t + 1, 1, this.f17589g.getLeaveMsg(), this.f17587e);
                aVar.dismiss();
                this.f17590h.setResult(-1);
                if (!j.z()) {
                    PersonGroupActivity personGroupActivity = this.f17590h;
                    personGroupActivity.showToast(personGroupActivity.getPageContext().getContext().getString(R.string.no_network_guide));
                }
                this.f17590h.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f17591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonGroupActivity f17592f;

        public b(PersonGroupActivity personGroupActivity, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17592f = personGroupActivity;
            this.f17591e = game2GroupShareDialogView;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                ((InputMethodManager) this.f17592f.getSystemService("input_method")).hideSoftInputFromWindow(this.f17591e.getWindowToken(), 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonGroupActivity f17593a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonGroupActivity personGroupActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17593a = personGroupActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage.isSuccess()) {
                    if (httpResponsedMessage.getError() == 0) {
                        d.a.r0.r.l.f.c(3, PersonGroupActivity.PRIVATESTATE[this.f17593a.wantPrivcay]);
                        SkinManager.setNavbarIconSrc(this.f17593a.mPrivacyButton, PersonGroupActivity.PRIVACY_IMAGE_LIST_DEEP[this.f17593a.wantPrivcay], PersonGroupActivity.PRIVACY_IMAGE_LIST[this.f17593a.wantPrivcay]);
                        PersonGroupActivity personGroupActivity = this.f17593a;
                        personGroupActivity.showToastWithIcon(personGroupActivity.getPageContext().getContext().getString(PersonGroupActivity.PRIVACY_INFO_TEXT_LIST[this.f17593a.wantPrivcay]), R.drawable.icon_toast_info);
                        this.f17593a.mPrivacyButton.setContentDescription(this.f17593a.getPageContext().getString(PersonGroupActivity.PRIVACY_INFO_TEXT_LIST[d.a.r0.r.l.f.a(3) % 3]));
                        return;
                    }
                    this.f17593a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f17593a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    return;
                }
                PersonGroupActivity personGroupActivity2 = this.f17593a;
                personGroupActivity2.showToast(personGroupActivity2.getPageContext().getContext().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonGroupActivity f17594a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonGroupActivity personGroupActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17594a = personGroupActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUserPermissionMessage responseUserPermissionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
                try {
                    responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f17594a.hideProgressBar();
                    throw th;
                }
                if (responseUserPermissionMessage.getError() > 0) {
                    this.f17594a.showToast(StringUtils.isNull(responseUserPermissionMessage.getErrorString()) ? this.f17594a.getResources().getString(R.string.neterror) : responseUserPermissionMessage.getErrorString());
                    this.f17594a.hideProgressBar();
                    return;
                }
                GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                if (groupPermData != null) {
                    if (groupPermData.isCreatePersonal()) {
                        this.f17594a.sendMessage(new CustomMessage(2002001, new CreateGroupStepActivityConfig(this.f17594a.getPageContext().getContext(), 2, 0, 1012, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
                    } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                        this.f17594a.showToast(groupPermData.getCreatePersonalTip());
                    }
                }
                this.f17594a.hideProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonGroupActivity f17595e;

        public e(PersonGroupActivity personGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17595e = personGroupActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17595e.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonGroupActivity f17596e;

        public f(PersonGroupActivity personGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17596e = personGroupActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17596e.sendUserPermissionMessage();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonGroupActivity f17597e;

        public g(PersonGroupActivity personGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17597e = personGroupActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17597e.sendMessage(new CustomMessage(2002001, new AddGroupActivityConfig(this.f17597e.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonGroupActivity f17598e;

        public h(PersonGroupActivity personGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17598e = personGroupActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17598e.wantPrivcay = d.a.r0.r.l.f.a(3) % 3;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                httpMessage.addParam("opt", "group");
                httpMessage.addParam("val", String.valueOf(this.f17598e.wantPrivcay + 1));
                this.f17598e.sendMessage(httpMessage);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1079891931, "Lcom/baidu/tieba/im/mygroup/PersonGroupActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1079891931, "Lcom/baidu/tieba/im/mygroup/PersonGroupActivity;");
                return;
            }
        }
        PRIVACY_IMAGE_LIST = new int[]{R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
        PRIVACY_IMAGE_LIST_DEEP = new int[]{R.drawable.icon_pop_key_all_bg_w, R.drawable.icon_pop_key_f_bg_w, R.drawable.icon_pop_key_d_bg_w};
        PRIVACY_INFO_TEXT_LIST = new int[]{R.string.info_privacy_all, R.string.info_privacy_friend, R.string.info_privacy_hide};
        PRIVATESTATE = new int[]{1, 2, 3};
    }

    public PersonGroupActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrTabIndex = -1;
        this.wantPrivcay = 0;
        this.isHost = false;
        this.mBack = null;
        this.mModel = null;
    }

    private void createAndAddTabSpec(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65545, this, fragment, i2, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f12348c = fragment;
        bVar.f12346a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        bVar.f12347b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private void initTabSpec() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.mPersonGroupAdapter == null) {
            return;
        }
        char c2 = this.isHost ? (char) 1 : (char) 2;
        Fragment item = this.mPersonGroupAdapter.getItem(0);
        int i2 = this.mPersonGroupAdapter.i(0);
        if (item != null) {
            createAndAddTabSpec(item, i2, getPageContext().getContext().getString(R.string.person_group_no_personal_title));
        }
        if (c2 == 2) {
            Fragment item2 = this.mPersonGroupAdapter.getItem(1);
            int i3 = this.mPersonGroupAdapter.i(1);
            if (item2 != null) {
                createAndAddTabSpec(item2, i3, getPageContext().getContext().getString(R.string.commongroup));
            }
        }
        this.mTabHost.j();
    }

    private void initUI(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.person_group_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(String.format(getPageContext().getContext().getString(R.string.person_group), this.mUtype));
            this.mNavigationBar.showBottomLine();
            View view = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
            this.mBack = view;
            view.setOnClickListener(new e(this));
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
                this.mCreateGroupButton.setOnClickListener(new f(this));
                LinearLayout linearLayout2 = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search_group_btn, (View.OnClickListener) null);
                this.mSearchGroupButtion = linearLayout2;
                this.mSearchGroup = (ImageView) linearLayout2.findViewById(R.id.search_gorup);
                this.mSearchGroupButtion.setOnClickListener(new g(this));
            } else if (this.isHost && this.requestCode != 23003) {
                ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_privacy, (View.OnClickListener) null);
                this.mPrivacyButton = imageView;
                SkinManager.setNavbarIconSrc(imageView, PRIVACY_IMAGE_LIST_DEEP[d.a.r0.r.l.f.a(3) - 1], PRIVACY_IMAGE_LIST[d.a.r0.r.l.f.a(3) - 1]);
                this.wantPrivcay = d.a.r0.r.l.f.a(3) % 3;
                this.mPrivacyButton.setContentDescription(getPageContext().getString(PRIVACY_INFO_TEXT_LIST[this.wantPrivcay]));
                this.mPrivacyButton.setOnClickListener(new h(this));
            }
            this.mTypes = new int[]{0, 1};
            this.mPersonGroupAdapter = new PersonGroupAdapter(this, this.isHost);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.person_group_tab_host);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setTabWidgetViewHeight(l.g(getApplicationContext(), R.dimen.ds80));
            this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
            this.mTabHost.setOnPageChangeListener(this);
            this.mTabHost.q();
            if (this.mTabHost.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.mTabHost.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            }
            initTabSpec();
            if (this.isHost) {
                this.mTabHost.getTabWrapper().setVisibility(8);
            }
            this.mTabHost.setCurrentTab(this.mCurrTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserPermissionMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            showProgressBar();
            this.mModel.x(0L);
        }
    }

    private void showConfirmShareToGroupDialog(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{shareFromGameCenterMsgData, Long.valueOf(j), str}) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(1);
            Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getContext());
            game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
            aVar.setContentView(game2GroupShareDialogView);
            aVar.setPositiveButton(R.string.share, new a(this, j, shareFromGameCenterMsgData, game2GroupShareDialogView));
            aVar.setNegativeButton(R.string.cancel, new b(this, game2GroupShareDialogView));
            aVar.create(getPageContext()).show();
        }
    }

    public int getCurrentPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCurrTabIndex == 0 ? 0 : 1 : invokeV.intValue;
    }

    public List<GroupInfoData> getGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.groups : (List) invokeV.objValue;
    }

    public boolean getIsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isHost : invokeV.booleanValue;
    }

    public PersonGroupModel getMyGroupModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mModel : (PersonGroupModel) invokeV.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSex : invokeV.intValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mUid : (String) invokeV.objValue;
    }

    public String getUtype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mUtype : (String) invokeV.objValue;
    }

    public List<GroupInfoData> getcommonGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.groups : (List) invokeV.objValue;
    }

    public boolean isCommonGroup(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
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
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mSearchGroup, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mCreateGroup, R.drawable.icon_pure_topbar_establish44_svg, R.color.CAM_X0105, null);
            this.mTabHost.p(i2);
            SkinManager.setBackgroundResource(this.mTabHost, R.color.common_color_10173);
            if (this.mPersonGroupAdapter != null) {
                int i3 = this.isHost ? 1 : 2;
                for (int i4 = 0; i4 < i3; i4++) {
                    Fragment item = this.mPersonGroupAdapter.getItem(i4);
                    if (item != null && (item instanceof BaseFragment)) {
                        ((BaseFragment) item).changeSkinType(i2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
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
                int i2 = this.mSex;
                if (i2 == 1) {
                    this.mUtype = getPageContext().getContext().getString(R.string.he);
                } else if (i2 != 2) {
                    this.mUtype = getPageContext().getContext().getString(R.string.ta);
                } else {
                    this.mUtype = getPageContext().getContext().getString(R.string.she);
                }
            }
            if (this.mModel == null) {
                if (!this.isHost) {
                    this.mModel = new PersonGroupModel(this, d.a.c.e.m.b.f(this.mUid, 0L));
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
                registerListener(new c(this, CmdConfigHttp.SET_PRIVATE_CMD));
                return;
            }
            registerListener(103008, new d(this, 0));
        }
    }

    public boolean onGroupSelected(GroupInfoData groupInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, groupInfoData)) == null) {
            if (groupInfoData == null || this.requestCode != 23003) {
                return false;
            }
            if (2 == this.fromWhere) {
                showConfirmShareToGroupDialog(d.a.r0.y.a.d().e(), groupInfoData.getGroupId(), groupInfoData.getName());
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
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || i2 < 0 || i2 >= 2 || i2 == this.mCurrTabIndex) {
            return;
        }
        this.mCurrTabIndex = i2;
        if (this.isHost || this.mTypes[i2] != 1) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getContext(), "common_group", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkApplication.getInst().getSkinType());
            if (this.mModel == null) {
                this.mModel = new PersonGroupModel(this);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            bundle.putInt("CurrTabIndex", this.mCurrTabIndex);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
        }
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.commonGroups = list;
        }
    }

    public void setGroups(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.groups = list;
        }
    }

    public void updateTabTitle(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) || this.isHost || this.mPersonGroupAdapter == null) {
            return;
        }
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.g(0).f12347b;
        if (i2 <= 0) {
            fragmentTabIndicator.setText(getPageContext().getContext().getString(R.string.person_group_no_personal_title));
        } else {
            fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(R.string.person_group_personal), Integer.valueOf(i2)));
        }
        FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.g(1).f12347b;
        if (i3 <= 0) {
            fragmentTabIndicator2.setText(getPageContext().getContext().getString(R.string.commongroup));
        } else {
            fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(R.string.person_group_common), Integer.valueOf(i3)));
        }
    }
}
