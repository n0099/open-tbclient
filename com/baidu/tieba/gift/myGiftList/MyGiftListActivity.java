package com.baidu.tieba.gift.myGiftList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cu4;
import com.repackage.dt6;
import com.repackage.ft6;
import com.repackage.mg;
import com.repackage.oi;
import com.repackage.wx4;
/* loaded from: classes3.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsHost;
    public MyGiftListModel.b mLoadDataCallback;
    public MyGiftListModel mModel;
    public ft6 mMyGiftListView;
    public NoNetworkView.b mNetworkChangeListener;
    public final CustomMessageListener mSendGiftSucceedListener;
    public long mUserId;
    public String nameShow;
    public BdListView.p scrollToBottomListener;
    public int sex;
    public String st_type;
    public String suid;
    public int userType;
    public String username;

    /* loaded from: classes3.dex */
    public class a implements MyGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public a(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // com.baidu.tieba.gift.myGiftList.MyGiftListModel.b
        public void a(int i, String str, boolean z, dt6 dt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), dt6Var}) == null) {
                this.a.closeLoadingDialog();
                this.a.mMyGiftListView.l().setVisibility(8);
                this.a.mMyGiftListView.k();
                if (i == 0) {
                    this.a.mMyGiftListView.s(dt6Var);
                    return;
                }
                this.a.showToast(str);
                if (z) {
                    this.a.mMyGiftListView.s(dt6Var);
                } else {
                    this.a.mMyGiftListView.u(str, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements cu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public b(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // com.repackage.cu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!oi.C()) {
                    this.a.mMyGiftListView.k();
                    this.a.mMyGiftListView.u(this.a.getString(R.string.obfuscated_res_0x7f0f0c17), true);
                    return;
                }
                wx4.g0().n();
                this.a.mModel.K(false);
                this.a.mModel.loadData();
                wx4.g0().d0(0);
                this.a.mMyGiftListView.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public c(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mIsHost) {
                return;
            }
            if (oi.C()) {
                long uid = this.a.mModel.getUid();
                if (uid == 0) {
                    return;
                }
                TiebaStatic.log("gift_list_btn");
                GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.a.getPageContext().getPageActivity(), uid, this.a.username, this.a.nameShow);
                giftTabActivityConfig.getIntent().putExtra("account_type", this.a.userType);
                giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_GIFT_WALLS, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                this.a.sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
                return;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public d(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.mModel.K(false);
                this.a.mModel.loadData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MyGiftListActivity myGiftListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || this.a.mIsHost || this.a.mUserId != l.longValue()) {
                return;
            }
            this.a.mModel.K(false);
            this.a.mModel.loadData();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public f(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.mModel.G()) {
                    this.a.mModel.K(true);
                    this.a.mModel.loadData();
                    this.a.mMyGiftListView.l().setVisibility(0);
                    return;
                }
                this.a.mMyGiftListView.l().setVisibility(8);
            }
        }
    }

    public MyGiftListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.suid = null;
        this.sex = 0;
        this.mUserId = 0L;
        this.mLoadDataCallback = new a(this);
        this.mNetworkChangeListener = new d(this);
        this.mSendGiftSucceedListener = new e(this, 2001232);
        this.scrollToBottomListener = new f(this);
    }

    private void addNetWorkChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mMyGiftListView.i(this.mNetworkChangeListener);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ft6 ft6Var = new ft6(this, this.scrollToBottomListener, this.mIsHost);
            this.mMyGiftListView = ft6Var;
            ft6Var.t(new b(this));
            addNetWorkChangeListener();
        }
    }

    public View.OnClickListener getSendGiftClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    public String getUserSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.sex == 2 ? getPageContext().getString(R.string.obfuscated_res_0x7f0f1157) : getPageContext().getString(R.string.obfuscated_res_0x7f0f0819);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.mMyGiftListView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            wx4.g0().n();
            Intent intent = getIntent();
            if (intent != null) {
                this.suid = intent.getStringExtra("id");
                this.st_type = intent.getStringExtra("st_type");
                this.sex = intent.getIntExtra("sex", 0);
                this.username = intent.getStringExtra("user_name");
                this.nameShow = intent.getStringExtra("name_show");
                this.userType = intent.getIntExtra("user_type", 0);
            }
            String str = this.suid;
            if (str != null) {
                this.mUserId = mg.g(str, 0L);
            }
            MyGiftListModel myGiftListModel = new MyGiftListModel(getPageContext(), this.st_type);
            this.mModel = myGiftListModel;
            myGiftListModel.mUserType = this.userType;
            myGiftListModel.setUid(this.mUserId);
            this.mIsHost = this.mModel.E();
            this.mModel.I(this.mLoadDataCallback);
            initUI();
            registerListener(this.mSendGiftSucceedListener);
            this.mModel.K(false);
            if (oi.C()) {
                this.mMyGiftListView.v();
            } else {
                this.mMyGiftListView.u(getString(R.string.obfuscated_res_0x7f0f0c17), true);
            }
            wx4.g0().d0(0);
        }
    }
}
