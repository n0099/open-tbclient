package com.baidu.tieba.gift.myGiftList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import c.a.e.e.p.l;
import c.a.q0.s.f0.f;
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
/* loaded from: classes7.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsHost;
    public MyGiftListModel.b mLoadDataCallback;
    public MyGiftListModel mModel;
    public c.a.r0.b1.c.c mMyGiftListView;
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

    /* loaded from: classes7.dex */
    public class a implements MyGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyGiftListActivity f51999a;

        public a(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51999a = myGiftListActivity;
        }

        @Override // com.baidu.tieba.gift.myGiftList.MyGiftListModel.b
        public void a(int i2, String str, boolean z, c.a.r0.b1.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z), aVar}) == null) {
                this.f51999a.closeLoadingDialog();
                this.f51999a.mMyGiftListView.l().setVisibility(8);
                this.f51999a.mMyGiftListView.k();
                if (i2 == 0) {
                    this.f51999a.mMyGiftListView.r(aVar);
                    return;
                }
                this.f51999a.showToast(str);
                if (z) {
                    this.f51999a.mMyGiftListView.r(aVar);
                } else {
                    this.f51999a.mMyGiftListView.t(str, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyGiftListActivity f52000e;

        public b(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52000e = myGiftListActivity;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!l.D()) {
                    this.f52000e.mMyGiftListView.k();
                    this.f52000e.mMyGiftListView.t(this.f52000e.getString(R.string.neterror), true);
                    return;
                }
                c.a.q0.t.d.b.g0().n();
                this.f52000e.mModel.I(false);
                this.f52000e.mModel.loadData();
                c.a.q0.t.d.b.g0().d0(0);
                this.f52000e.mMyGiftListView.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyGiftListActivity f52001e;

        public c(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52001e = myGiftListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52001e.mIsHost) {
                return;
            }
            if (l.D()) {
                long uid = this.f52001e.mModel.getUid();
                if (uid == 0) {
                    return;
                }
                TiebaStatic.log("gift_list_btn");
                GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f52001e.getPageContext().getPageActivity(), uid, this.f52001e.username, this.f52001e.nameShow);
                giftTabActivityConfig.getIntent().putExtra("account_type", this.f52001e.userType);
                giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_GIFT_WALLS, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                this.f52001e.sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
                return;
            }
            this.f52001e.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyGiftListActivity f52002e;

        public d(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52002e = myGiftListActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f52002e.mModel.I(false);
                this.f52002e.mModel.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyGiftListActivity f52003a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MyGiftListActivity myGiftListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity, Integer.valueOf(i2)};
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
            this.f52003a = myGiftListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || this.f52003a.mIsHost || this.f52003a.mUserId != l.longValue()) {
                return;
            }
            this.f52003a.mModel.I(false);
            this.f52003a.mModel.loadData();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyGiftListActivity f52004e;

        public f(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52004e = myGiftListActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f52004e.mModel.E()) {
                    this.f52004e.mModel.I(true);
                    this.f52004e.mModel.loadData();
                    this.f52004e.mMyGiftListView.l().setVisibility(0);
                    return;
                }
                this.f52004e.mMyGiftListView.l().setVisibility(8);
            }
        }
    }

    public MyGiftListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            c.a.r0.b1.c.c cVar = new c.a.r0.b1.c.c(this, this.scrollToBottomListener, this.mIsHost);
            this.mMyGiftListView = cVar;
            cVar.s(new b(this));
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
            return this.sex == 2 ? getPageContext().getString(R.string.she) : getPageContext().getString(R.string.he);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mMyGiftListView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.q0.t.d.b.g0().n();
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
                this.mUserId = c.a.e.e.m.b.g(str, 0L);
            }
            MyGiftListModel myGiftListModel = new MyGiftListModel(getPageContext(), this.st_type);
            this.mModel = myGiftListModel;
            myGiftListModel.mUserType = this.userType;
            myGiftListModel.setUid(this.mUserId);
            this.mIsHost = this.mModel.C();
            this.mModel.G(this.mLoadDataCallback);
            initUI();
            registerListener(this.mSendGiftSucceedListener);
            this.mModel.I(false);
            if (l.D()) {
                this.mMyGiftListView.u();
            } else {
                this.mMyGiftListView.t(getString(R.string.neterror), true);
            }
            c.a.q0.t.d.b.g0().d0(0);
        }
    }
}
