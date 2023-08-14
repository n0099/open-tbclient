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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bi;
import com.baidu.tieba.card.ala.secondfloor.CommonSpaceItemDecoration;
import com.baidu.tieba.homepage.personalize.adapter.RecommendRecentForumListAdapter;
import com.baidu.tieba.u5a;
import com.baidu.tieba.vka;
import com.baidu.tieba.z38;
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
    public z38 h;
    public BdUniqueId i;
    public BdResourceCallback<BdImage> j;

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageRecentForumLayout a;

        public a(HomePageRecentForumLayout homePageRecentForumLayout) {
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
    public class b extends BdResourceCallback<BdImage> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((b) bdImage, str, i);
                if (bdImage != null) {
                    this.a.setBackground(bdImage.getAsBitmapDrawable());
                } else {
                    this.a.e(true);
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
        this.j = new b(this);
        this.a = tbPageContext;
        d();
    }

    public final void e(boolean z) {
        z38 z38Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!z && (z38Var = this.h) != null && z38Var.c() != null && !bi.isEmpty(vka.g(this.h.c()))) {
                BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResource(vka.g(this.h.c()), 45, this.j, this.i);
                if (bdImage != null) {
                    setBackground(bdImage.getAsBitmapDrawable());
                    return;
                }
                return;
            }
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.b != i && this.h != null) {
            this.f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_recent_forum_title, WebPManager.ResourceStateType.NORMAL));
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_arrow14_right_n, R.color.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            this.e.notifyDataSetChanged();
            EMManager.from(this.c).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X09);
            this.b = i;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d085b, (ViewGroup) this, true);
            this.c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f092742);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f00);
            this.g = (ImageView) findViewById(R.id.arrow_img);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f090beb);
            this.d = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            RecommendRecentForumListAdapter recommendRecentForumListAdapter = new RecommendRecentForumListAdapter(this.a);
            this.e = recommendRecentForumListAdapter;
            this.d.setAdapter(recommendRecentForumListAdapter);
            this.d.addItemDecoration(new CommonSpaceItemDecoration(0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X004), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X005)));
            this.c.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.d.addOnScrollListener(new a(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        z38 z38Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || view2 == null) {
            return;
        }
        if ((view2 == this.c || view2 == this.g) && (z38Var = this.h) != null && !TextUtils.isEmpty(z38Var.g())) {
            UrlManager.getInstance().dealOneLink(this.a, new String[]{this.h.g()});
            u5a.a().d(true);
        }
    }

    public void setData(z38 z38Var) {
        RecommendRecentForumListAdapter recommendRecentForumListAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, z38Var) == null) {
            if (z38Var != null && (recommendRecentForumListAdapter = this.e) != null) {
                this.h = z38Var;
                recommendRecentForumListAdapter.setData(z38Var.f());
                this.e.notifyDataSetChanged();
                if (!bi.isEmpty(this.h.g())) {
                    this.c.setVisibility(8);
                    this.g.setVisibility(8);
                } else {
                    this.c.setVisibility(8);
                    this.g.setVisibility(8);
                }
                if (this.d.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.d.getLayoutManager();
                    if (this.h.h()) {
                        if (z38Var.e() != Integer.MIN_VALUE && z38Var.d() != Integer.MIN_VALUE && !u5a.a().b()) {
                            linearLayoutManager.scrollToPositionWithOffset(z38Var.e(), z38Var.d());
                        }
                    } else {
                        linearLayoutManager.scrollToPosition(0);
                        u5a.a().e(false);
                    }
                }
                this.h.n(true);
                e(false);
                f(TbadkApplication.getInst().getSkinType());
                return;
            }
            ViewCommonUtil.setVisibility(this, 8);
        }
    }
}
