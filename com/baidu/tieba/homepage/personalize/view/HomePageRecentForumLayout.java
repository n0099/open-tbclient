package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.secondfloor.CommonSpaceItemDecoration;
import com.baidu.tieba.di;
import com.baidu.tieba.h78;
import com.baidu.tieba.homepage.personalize.adapter.RecommendRecentForumListAdapter;
import com.baidu.tieba.homepagecore.data.ForumSignInResultRespondedMessage;
import com.baidu.tieba.jta;
import com.baidu.tieba.k7a;
import com.baidu.tieba.mu6;
import com.baidu.tieba.nu6;
import com.baidu.tieba.qu6;
import com.baidu.tieba.wa8;
import com.baidu.tieba.xa8;
import com.baidu.tieba.yda;
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
    public h78 h;
    public BdUniqueId i;
    public boolean j;
    public k7a k;
    public HttpMessageListener l;
    public BdResourceCallback<BdImage> m;

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
                    this.a.j = false;
                } else if (httpResponsedMessage.getError() != 0) {
                    this.a.j = false;
                } else {
                    this.a.j = false;
                    wa8 data = ((ForumSignInResultRespondedMessage) httpResponsedMessage).getData();
                    if (data != null) {
                        this.a.k(data);
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
                    this.a.h.m(findFirstVisibleItemPosition);
                    View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    if (findViewByPosition != null) {
                        this.a.h.l(findViewByPosition.getLeft());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends qu6<xa8> {
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
        @Override // com.baidu.tieba.qu6
        public void onEvent(@NonNull xa8 xa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xa8Var) == null) {
                this.b.i(xa8Var);
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
                    this.a.g(true);
                } else {
                    this.a.setBackground(bdImage.getAsBitmapDrawable());
                }
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
        this.j = false;
        this.l = new a(this, CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
        this.m = new d(this);
        this.a = tbPageContext;
        f();
    }

    public final void g(boolean z) {
        h78 h78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!z && (h78Var = this.h) != null && h78Var.c() != null && !di.isEmpty(jta.g(this.h.c()))) {
                BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResource(jta.g(this.h.c()), 45, this.m, this.i);
                if (bdImage != null) {
                    setBackground(bdImage.getAsBitmapDrawable());
                    return;
                }
                return;
            }
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.b != i && this.h != null) {
            this.f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_recent_forum_title, WebPManager.ResourceStateType.NORMAL));
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_arrow14_right_n, R.color.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            this.e.notifyDataSetChanged();
            EMManager.from(this.c).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X09);
            this.b = i;
        }
    }

    public void i(@NonNull xa8 xa8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, xa8Var) != null) || this.j) {
            return;
        }
        this.j = true;
        this.k.d(xa8Var.a(), this.i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            j();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0874, (ViewGroup) this, true);
            this.c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f092770);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f00);
            this.g = (ImageView) findViewById(R.id.arrow_img);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f090be7);
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

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nu6.b().a(new mu6(this.i, xa8.class), new c(this, xa8.class));
            this.l.setTag(this.i);
            this.l.setSelfListener(true);
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public final void k(wa8 wa8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, wa8Var) == null) && wa8Var != null && this.h != null && !ListUtils.isEmpty(wa8Var.a()) && !ListUtils.isEmpty(this.h.f())) {
            this.k.c(this.h.f(), wa8Var.a());
            this.e.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        h78 h78Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || view2 == null) {
            return;
        }
        if ((view2 == this.c || view2 == this.g) && (h78Var = this.h) != null && !TextUtils.isEmpty(h78Var.g())) {
            UrlManager.getInstance().dealOneLink(this.a, new String[]{this.h.g()});
            yda.a().e(true);
        }
    }

    public void setData(h78 h78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h78Var) == null) {
            if (h78Var != null && this.e != null) {
                if (this.k == null) {
                    this.k = new k7a();
                }
                this.h = h78Var;
                this.e.setData(h78Var.f());
                this.e.notifyDataSetChanged();
                if (!di.isEmpty(this.h.g())) {
                    this.c.setVisibility(8);
                    this.g.setVisibility(8);
                } else {
                    this.c.setVisibility(8);
                    this.g.setVisibility(8);
                }
                if (this.d.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.d.getLayoutManager();
                    if (this.h.h()) {
                        if (h78Var.e() != Integer.MIN_VALUE && h78Var.d() != Integer.MIN_VALUE && !yda.a().c()) {
                            linearLayoutManager.scrollToPositionWithOffset(h78Var.e(), h78Var.d());
                        }
                    } else {
                        linearLayoutManager.scrollToPosition(0);
                        yda.a().f(false);
                    }
                }
                this.h.o(true);
                g(false);
                h(TbadkApplication.getInst().getSkinType());
                return;
            }
            ViewCommonUtil.setVisibility(this, 8);
        }
    }
}
