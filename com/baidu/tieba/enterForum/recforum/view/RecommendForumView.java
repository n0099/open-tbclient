package com.baidu.tieba.enterForum.recforum.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.bz6;
import com.baidu.tieba.cz6;
import com.baidu.tieba.ez6;
import com.baidu.tieba.o75;
import com.baidu.tieba.tg;
import com.baidu.tieba.vi;
import com.baidu.tieba.zy6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RecommendForumView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public RecommendForumInfoView b;
    public BdTypeRecyclerView c;
    public bz6 d;
    public TbPageContext e;
    public zy6 f;
    public ez6 g;

    /* loaded from: classes5.dex */
    public class a implements ez6.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumView a;

        @Override // com.baidu.tieba.ez6.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            }
        }

        public a(RecommendForumView recommendForumView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendForumView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendForumView;
        }

        @Override // com.baidu.tieba.ez6.a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.a.b.setLike(true);
                this.a.d.x(true);
            }
        }

        @Override // com.baidu.tieba.ez6.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.b.setLike(false);
                this.a.d.x(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumView a;

        public b(RecommendForumView recommendForumView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendForumView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendForumView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.d == null) {
                return;
            }
            this.a.l(null);
            TiebaStatic.log(new StatisticItem("c14585").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.d.f()).param("obj_locate", 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumView a;

        public c(RecommendForumView recommendForumView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendForumView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendForumView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b.d()) {
                    if (this.a.d != null) {
                        String h = this.a.d.h();
                        String f = this.a.d.f();
                        if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(f)) {
                            this.a.g.f(h, f);
                        }
                    }
                } else if (this.a.d != null) {
                    String h2 = this.a.d.h();
                    String f2 = this.a.d.f();
                    if (!TextUtils.isEmpty(h2) && !TextUtils.isEmpty(f2)) {
                        this.a.g.e(h2, f2);
                    }
                }
                StatisticItem param = new StatisticItem("c14586").param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.a.d != null) {
                    str = this.a.d.f();
                } else {
                    str = "";
                }
                StatisticItem param2 = param.param("fid", str);
                if (this.a.b.d()) {
                    i = 2;
                } else {
                    i = 1;
                }
                TiebaStatic.log(param2.param("obj_param1", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumView a;

        public d(RecommendForumView recommendForumView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendForumView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendForumView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (this.a.c.getLayoutManager() instanceof LinearLayoutManager) && this.a.d != null) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.a.c.getLayoutManager();
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    this.a.d.setPosition(findFirstVisibleItemPosition);
                    View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    if (findViewByPosition != null) {
                        this.a.d.A(findViewByPosition.getLeft());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ RecommendForumView b;

        public e(RecommendForumView recommendForumView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendForumView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recommendForumView;
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                super.getItemOffsets(rect, view2, recyclerView, state);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int childLayoutPosition = recyclerView.getChildLayoutPosition(view2);
                if (childLayoutPosition != -1 && (layoutManager instanceof LinearLayoutManager)) {
                    int g = vi.g(this.a, R.dimen.M_W_X004);
                    if (childLayoutPosition == state.getItemCount() - 1) {
                        rect.set(g, 0, g, 0);
                    } else {
                        rect.set(g, 0, 0, 0);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements zy6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumView a;

        public f(RecommendForumView recommendForumView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendForumView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendForumView;
        }

        @Override // com.baidu.tieba.zy6.b
        public void a(cz6 cz6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cz6Var) != null) || cz6Var == null) {
                return;
            }
            this.a.l(cz6Var.c());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendForumView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOnClickListener(new b(this));
            RecommendForumInfoView recommendForumInfoView = this.b;
            if (recommendForumInfoView != null && recommendForumInfoView.getLikeButton() != null) {
                this.b.getLikeButton().setOnClickListener(new c(this));
                this.c.addOnScrollListener(new d(this));
            }
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(0);
            this.c.setLayoutManager(linearLayoutManager);
            this.c.addItemDecoration(new e(this, context));
            zy6 zy6Var = new zy6(context);
            this.f = zy6Var;
            zy6Var.d(new f(this));
            this.c.addAdapters(this.f.b());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendForumView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendForumView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        f(context);
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            j(context);
            k();
            i(context);
            m();
            g(context);
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0821, this);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            setOrientation(1);
        }
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.e = tbPageContext;
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ez6 ez6Var = new ez6();
            this.g = ez6Var;
            ez6Var.h(this.e);
            this.g.g(new a(this));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09079d);
            this.b = (RecommendForumInfoView) findViewById(R.id.obfuscated_res_0x7f091dbd);
            this.c = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f092442);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o75.d(this.a).f(R.color.CAM_X0201);
            this.b.e();
        }
    }

    public final void l(String str) {
        bz6 bz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (bz6Var = this.d) == null) {
            return;
        }
        String h = bz6Var.h();
        if (!TextUtils.isEmpty(h)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(h, "");
            createNormalCfg.getIntent().putExtra("transition_type", 0);
            if (!TextUtils.isEmpty(str)) {
                long g = tg.g(str, 0L);
                if (g > 0) {
                    createNormalCfg.setFakeThreadId(g);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        }
    }

    public void setData(bz6 bz6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bz6Var) != null) || bz6Var == null) {
            return;
        }
        this.d = bz6Var;
        this.b.setData(bz6Var.e(), bz6Var.h(), tg.e(bz6Var.i(), 0), tg.e(bz6Var.m(), 0), bz6Var.n());
        if (!ListUtils.isEmpty(bz6Var.l())) {
            this.c.setData(bz6Var.l());
            if (this.c.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.c.getLayoutManager();
                if (bz6Var.getPosition() != Integer.MIN_VALUE && bz6Var.k() != Integer.MIN_VALUE) {
                    linearLayoutManager.scrollToPositionWithOffset(bz6Var.getPosition(), bz6Var.k());
                } else {
                    linearLayoutManager.scrollToPosition(0);
                }
            }
        }
        m();
    }
}
