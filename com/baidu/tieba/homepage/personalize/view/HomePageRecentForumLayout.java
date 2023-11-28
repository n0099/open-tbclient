package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.al8;
import com.baidu.tieba.ar6;
import com.baidu.tieba.bj;
import com.baidu.tieba.bl8;
import com.baidu.tieba.card.ala.secondfloor.CommonSpaceItemDecoration;
import com.baidu.tieba.homepage.personalize.adapter.RecommendRecentForumListAdapter;
import com.baidu.tieba.homepagecore.data.ForumSignInResultRespondedMessage;
import com.baidu.tieba.lh8;
import com.baidu.tieba.nqa;
import com.baidu.tieba.rd;
import com.baidu.tieba.wja;
import com.baidu.tieba.wq6;
import com.baidu.tieba.xq6;
import com.baidu.tieba.z5b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HomePageRecentForumLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    public int b;
    public EMTextView c;
    public BdRecyclerView d;
    public RecommendRecentForumListAdapter e;
    public ImageView f;
    public ImageView g;
    public lh8 h;
    public BdUniqueId i;
    @NonNull
    public bj j;
    public boolean k;
    public wja l;
    public HttpMessageListener m;
    public BdResourceCallback<BdImage> n;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageRecentForumLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HomePageRecentForumLayout homePageRecentForumLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageRecentForumLayout, Integer.valueOf(i)};
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
            this.a = homePageRecentForumLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003577 || !(httpResponsedMessage instanceof ForumSignInResultRespondedMessage)) {
                    this.a.k = false;
                } else if (httpResponsedMessage.getError() != 0) {
                    this.a.k = false;
                } else {
                    this.a.k = false;
                    al8 data = ((ForumSignInResultRespondedMessage) httpResponsedMessage).getData();
                    if (data != null) {
                        this.a.n(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageRecentForumLayout a;

        public b(HomePageRecentForumLayout homePageRecentForumLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageRecentForumLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageRecentForumLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (this.a.d.getLayoutManager() instanceof LinearLayoutManager) && this.a.h != null) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.a.d.getLayoutManager();
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    this.a.h.p(findFirstVisibleItemPosition);
                    View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    if (findViewByPosition != null) {
                        this.a.h.o(findViewByPosition.getLeft());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends ar6<bl8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageRecentForumLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HomePageRecentForumLayout homePageRecentForumLayout, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageRecentForumLayout, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homePageRecentForumLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(@NonNull bl8 bl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bl8Var) == null) {
                this.b.k(bl8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageRecentForumLayout a;

        public d(HomePageRecentForumLayout homePageRecentForumLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageRecentForumLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageRecentForumLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((d) bdImage, str, i);
                if (bdImage == null) {
                    this.a.h(true);
                } else {
                    this.a.setBackground(bdImage.getAsBitmapDrawable());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageRecentForumLayout a;

        public e(HomePageRecentForumLayout homePageRecentForumLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageRecentForumLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageRecentForumLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e != null) {
                this.a.e.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageRecentForumLayout(@NonNull TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.k = false;
        this.m = new a(this, CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
        this.n = new d(this);
        this.a = tbPageContext;
        g();
        this.j = new bj(this.d);
    }

    public final void h(boolean z) {
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!z && (lh8Var = this.h) != null && lh8Var.c() != null && !rd.isEmpty(z5b.g(this.h.c()))) {
                BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResource(z5b.g(this.h.c()), 45, this.n, this.i);
                if (bdImage != null) {
                    setBackground(bdImage.getAsBitmapDrawable());
                    return;
                }
                return;
            }
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.b != i && this.h != null) {
            this.f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_recent_forum_title, WebPManager.ResourceStateType.NORMAL));
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_arrow14_right_n, R.color.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            i();
            EMManager.from(this.c).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X09);
            this.b = i;
        }
    }

    public void k(@NonNull bl8 bl8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, bl8Var) != null) || this.k) {
            return;
        }
        this.k = true;
        this.l.d(bl8Var.a(), this.i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            l();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0895, (ViewGroup) this, true);
            this.c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f092849);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f7a);
            this.g = (ImageView) findViewById(R.id.arrow_img);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f090c4f);
            this.d = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            RecommendRecentForumListAdapter recommendRecentForumListAdapter = new RecommendRecentForumListAdapter(this.a);
            this.e = recommendRecentForumListAdapter;
            this.d.setAdapter(recommendRecentForumListAdapter);
            this.d.addItemDecoration(new CommonSpaceItemDecoration(0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X004), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X005)));
            this.c.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.d.addOnScrollListener(new b(this));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.e(new e(this));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            xq6.b().b(new wq6(this.i, bl8.class), new c(this, bl8.class));
            this.m.setTag(this.i);
            this.m.setSelfListener(true);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    public final void n(al8 al8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, al8Var) == null) && al8Var != null && this.h != null && !ListUtils.isEmpty(al8Var.a()) && !ListUtils.isEmpty(this.h.h())) {
            this.l.c(this.h, al8Var.a());
            i();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2 == this.c || view2 == this.g) {
            TiebaStatic.log(new StatisticItem("c15536").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
            UrlManager.getInstance().dealOneLink(this.a, new String[]{TbConfig.ONE_KEY_SIGN_PAGE_URL});
            nqa.c().h(true);
        }
    }

    public void setData(lh8 lh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lh8Var) == null) {
            if (lh8Var != null && this.e != null) {
                if (this.l == null) {
                    this.l = new wja();
                }
                this.h = lh8Var;
                this.e.setData(lh8Var.h());
                i();
                this.c.setVisibility(0);
                this.g.setVisibility(0);
                this.c.setText(getResources().getText(R.string.signallforum));
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_recent_forum_is_show");
                if (!SharedPrefHelper.getInstance().getBoolean(sharedPrefKeyWithAccount, false)) {
                    SharedPrefHelper.getInstance().putBoolean(sharedPrefKeyWithAccount, true);
                }
                TiebaStatic.log(new StatisticItem("c15537").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                if (this.d.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.d.getLayoutManager();
                    if (this.h.k()) {
                        if (lh8Var.e() != Integer.MIN_VALUE && lh8Var.d() != Integer.MIN_VALUE && !nqa.c().d()) {
                            linearLayoutManager.scrollToPositionWithOffset(lh8Var.e(), lh8Var.d());
                        }
                    } else {
                        linearLayoutManager.scrollToPosition(0);
                        nqa.c().i(false);
                    }
                }
                this.h.q(true);
                h(false);
                j(TbadkApplication.getInst().getSkinType());
                return;
            }
            ViewCommonUtil.setVisibility(this, 8);
        }
    }
}
