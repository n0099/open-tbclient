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
import com.baidu.tieba.gg;
import com.baidu.tieba.hi;
import com.baidu.tieba.n15;
import com.baidu.tieba.nn6;
import com.baidu.tieba.pn6;
import com.baidu.tieba.qn6;
import com.baidu.tieba.un6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class RecommendForumView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public RecommendForumInfoView b;
    public BdTypeRecyclerView c;
    public pn6 d;
    public TbPageContext e;
    public nn6 f;
    public un6 g;

    /* loaded from: classes4.dex */
    public class a implements un6.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumView a;

        @Override // com.baidu.tieba.un6.a
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

        @Override // com.baidu.tieba.un6.a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.a.b.setLike(true);
                this.a.d.y(true);
            }
        }

        @Override // com.baidu.tieba.un6.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.b.setLike(false);
                this.a.d.y(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            TiebaStatic.log(new StatisticItem("c14585").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.d.h()).param("obj_locate", 1));
        }
    }

    /* loaded from: classes4.dex */
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
                        String i2 = this.a.d.i();
                        String h = this.a.d.h();
                        if (!TextUtils.isEmpty(i2) && !TextUtils.isEmpty(h)) {
                            this.a.g.f(i2, h);
                        }
                    }
                } else if (this.a.d != null) {
                    String i3 = this.a.d.i();
                    String h2 = this.a.d.h();
                    if (!TextUtils.isEmpty(i3) && !TextUtils.isEmpty(h2)) {
                        this.a.g.e(i3, h2);
                    }
                }
                StatisticItem param = new StatisticItem("c14586").param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.a.d != null) {
                    str = this.a.d.h();
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

    /* loaded from: classes4.dex */
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
                        this.a.d.D(findViewByPosition.getLeft());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    int g = hi.g(this.a, R.dimen.M_W_X004);
                    if (childLayoutPosition == state.getItemCount() - 1) {
                        rect.set(g, 0, g, 0);
                    } else {
                        rect.set(g, 0, 0, 0);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements nn6.b {
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

        @Override // com.baidu.tieba.nn6.b
        public void a(qn6 qn6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, qn6Var) != null) || qn6Var == null) {
                return;
            }
            this.a.l(qn6Var.c());
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
            nn6 nn6Var = new nn6(context);
            this.f = nn6Var;
            nn6Var.d(new f(this));
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
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d07da, this);
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
            un6 un6Var = new un6();
            this.g = un6Var;
            un6Var.h(this.e);
            this.g.g(new a(this));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09076e);
            this.b = (RecommendForumInfoView) findViewById(R.id.obfuscated_res_0x7f091d3c);
            this.c = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f09239e);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            n15.d(this.a).f(R.color.CAM_X0201);
            this.b.e();
        }
    }

    public final void l(String str) {
        pn6 pn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (pn6Var = this.d) == null) {
            return;
        }
        String i = pn6Var.i();
        if (!TextUtils.isEmpty(i)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(i, "");
            createNormalCfg.getIntent().putExtra("transition_type", 0);
            if (!TextUtils.isEmpty(str)) {
                long g = gg.g(str, 0L);
                if (g > 0) {
                    createNormalCfg.setFakeThreadId(g);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        }
    }

    public void setData(pn6 pn6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pn6Var) != null) || pn6Var == null) {
            return;
        }
        this.d = pn6Var;
        this.b.setData(pn6Var.g(), pn6Var.i(), gg.e(pn6Var.k(), 0), gg.e(pn6Var.p(), 0), pn6Var.r());
        if (!ListUtils.isEmpty(pn6Var.o())) {
            this.c.setData(pn6Var.o());
            if (this.c.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.c.getLayoutManager();
                if (pn6Var.getPosition() != Integer.MIN_VALUE && pn6Var.m() != Integer.MIN_VALUE) {
                    linearLayoutManager.scrollToPositionWithOffset(pn6Var.getPosition(), pn6Var.m());
                } else {
                    linearLayoutManager.scrollToPosition(0);
                }
            }
        }
        m();
    }
}
