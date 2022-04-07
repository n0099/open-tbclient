package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a66;
import com.repackage.d56;
import com.repackage.du4;
import com.repackage.e66;
import com.repackage.eu4;
import com.repackage.g45;
import com.repackage.h45;
import com.repackage.i66;
import com.repackage.j66;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.z56;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendView extends FrameLayout implements ForumTestView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public z56 c;
    public RecommendForumHeaderView d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public a66 g;
    public eu4 h;
    public g45 i;
    public h45 j;
    public e66 k;
    public d56 l;
    public FrameLayout m;
    public long n;
    public int o;
    public int p;
    public List<j66> q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public RecyclerView.OnScrollListener t;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendView recommendView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView, Integer.valueOf(i)};
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
            this.a = recommendView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.l == null) {
                return;
            }
            this.a.l.T(TbSingleton.getInstance().getHotSearch());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecommendView recommendView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView, Integer.valueOf(i)};
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
            this.a = recommendView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Long)) {
                Long l = (Long) customResponsedMessage.getData();
                if (this.a.k == null || l == null) {
                    return;
                }
                this.a.n = l.longValue();
                if (this.a.c != null) {
                    this.a.c.loadData();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ RecommendView c;

        public c(RecommendView recommendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = recommendView;
            this.a = -1;
            this.b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) || this.a == i || this.c.l == null) {
                return;
            }
            this.a = i;
            if (i == 1) {
                return;
            }
            this.c.d.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.b += i2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendView a;

        public d(RecommendView recommendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && mi.A() && this.a.c != null) {
                this.a.c.loadData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendView a;

        public e(RecommendView recommendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && mi.A() && this.a.c != null) {
                this.a.c.loadData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendView(TbPageContext<?> tbPageContext) {
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
        this.a = 3;
        this.r = new a(this, 2921396);
        this.s = new b(this, 2921383);
        this.t = new c(this);
        this.b = tbPageContext;
        this.o = UtilHelper.getStatusBarHeight() + oi.f(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.p = oi.f(tbPageContext.getPageActivity(), R.dimen.tbds114);
        j(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.s);
        tbPageContext.registerListener(this.r);
        m();
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.c
    public void a() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bdTypeRecyclerView = this.f) != null && !ListUtils.isEmpty(bdTypeRecyclerView.getData()) && this.f.getData().size() == 1 && (this.f.getData().get(0) instanceof i66)) {
            t();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.c
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            p(this.k, j);
        }
    }

    public void h() {
        g45 g45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (g45Var = this.i) == null) {
            return;
        }
        g45Var.dettachView(this);
        this.i = null;
    }

    public void i() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (h45Var = this.j) == null) {
            return;
        }
        h45Var.dettachView(this);
        this.j = null;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02de, (ViewGroup) this, true);
            setClipChildren(false);
            this.e = (BdSwipeRefreshLayout) findViewById(R.id.obfuscated_res_0x7f0908ea);
            eu4 eu4Var = new eu4(this.b);
            this.h = eu4Var;
            this.e.setProgressView(eu4Var);
            this.e.setClipChildren(false);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f0908e9);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setClipChildren(false);
            this.f.addOnScrollListener(this.t);
            this.g = new a66(this.b, this.f);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            marginLayoutParams.topMargin = this.o - getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.e.setLayoutParams(marginLayoutParams);
            RecommendForumHeaderView recommendForumHeaderView = new RecommendForumHeaderView(this.b);
            this.d = recommendForumHeaderView;
            recommendForumHeaderView.setOnSecectedListener(this);
            FrameLayout frameLayout = new FrameLayout(this.b.getPageActivity());
            frameLayout.addView(new View(this.b.getPageActivity()), new FrameLayout.LayoutParams(-1, this.p));
            this.m = frameLayout;
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g45 g45Var = this.i;
            if (g45Var != null) {
                return g45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            h45 h45Var = this.j;
            if (h45Var != null) {
                return h45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        eu4 eu4Var = this.h;
        if (eu4Var != null) {
            eu4Var.H(skinType);
        }
        g45 g45Var = this.i;
        if (g45Var != null) {
            g45Var.onChangeSkinType();
        }
        h45 h45Var = this.j;
        if (h45Var != null) {
            h45Var.onChangeSkinType();
        }
        a66 a66Var = this.g;
        if (a66Var != null) {
            a66Var.d();
        }
        RecommendForumHeaderView recommendForumHeaderView = this.d;
        if (recommendForumHeaderView != null) {
            recommendForumHeaderView.f();
        }
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.t);
            }
            u();
            h();
            i();
            RecommendForumHeaderView recommendForumHeaderView = this.d;
            if (recommendForumHeaderView != null) {
                recommendForumHeaderView.h();
            }
        }
    }

    public final void o(List<j66> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f.removeHeaderView(this.m);
            this.f.removeHeaderView(this.d);
            this.f.getHeaderViewsCount();
            this.f.s(this.d);
            this.q = list;
            this.d.setData(list);
            this.l.T(TbSingleton.getInstance().getHotSearch());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            n();
            super.onDetachedFromWindow();
        }
    }

    public final void p(e66 e66Var, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048587, this, e66Var, j) == null) || e66Var == null) {
            return;
        }
        this.g.e(e66Var.a(j, !ListUtils.isEmpty(this.q)));
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bdTypeRecyclerView = this.f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || k()) {
            return;
        }
        if (this.i == null) {
            this.i = new g45(getContext());
            this.i.i();
            this.i.s((getHeight() - oi.f(getContext(), R.dimen.tbds304)) / 2);
            this.i.onChangeSkinType();
        }
        this.i.attachView(this, z);
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || l()) {
            return;
        }
        if (this.j == null) {
            this.j = new h45(getContext(), new d(this));
            this.j.k(oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702ae));
        }
        this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f0f6a));
        this.j.i(R.drawable.new_pic_emotion_08);
        this.j.attachView(this, z);
        this.j.p();
        this.f.setVisibility(8);
    }

    public void setData(e66 e66Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, e66Var) == null) || e66Var == null) {
            return;
        }
        this.k = e66Var;
        if (ListUtils.isEmpty(e66Var.d()) && ListUtils.isEmpty(e66Var.b(true))) {
            t();
            return;
        }
        q();
        List<j66> f = e66Var.f(this.n);
        this.n = 0L;
        j66 j66Var = (j66) ListUtils.getItem(f, 1);
        if (j66Var == null) {
            j66Var = (j66) ListUtils.getItem(f, 0);
        }
        long j = j66Var != null ? j66Var.a : 0L;
        o(f);
        p(e66Var, j);
    }

    public void setListPullRefreshListener(du4.g gVar) {
        eu4 eu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) || (eu4Var = this.h) == null) {
            return;
        }
        eu4Var.f(gVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            a66 a66Var = this.g;
            if (a66Var != null) {
                a66Var.f(bdUniqueId);
            }
            eu4 eu4Var = this.h;
            if (eu4Var != null) {
                eu4Var.a0(bdUniqueId);
            }
            RecommendForumHeaderView recommendForumHeaderView = this.d;
            if (recommendForumHeaderView != null) {
                recommendForumHeaderView.setPageId(bdUniqueId);
            }
        }
    }

    public void setPresenter(z56 z56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, z56Var) == null) {
            this.c = z56Var;
        }
    }

    public void setTabViewController(d56 d56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, d56Var) == null) {
            this.l = d56Var;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.j == null) {
                this.j = new h45(getContext(), new e(this));
                this.j.k(oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702ae));
            }
            this.j.i(R.drawable.new_pic_emotion_08);
            this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f0f4a));
            this.j.attachView(this, false);
            this.j.p();
            this.f.setVisibility(8);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.e.setRefreshing(false);
        }
    }
}
