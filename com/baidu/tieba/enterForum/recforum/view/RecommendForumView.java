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
import c.a.d.f.p.n;
import c.a.p0.w0.l.a.b;
import c.a.p0.w0.l.d.a;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes5.dex */
public class RecommendForumView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumInfoView f31914b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f31915c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.w0.l.b.b f31916d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f31917e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.w0.l.a.b f31918f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.w0.l.d.a f31919g;

    /* loaded from: classes5.dex */
    public class a implements a.InterfaceC1471a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumView a;

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

        @Override // c.a.p0.w0.l.d.a.InterfaceC1471a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.f31914b.setLike(false);
                this.a.f31916d.F(false);
            }
        }

        @Override // c.a.p0.w0.l.d.a.InterfaceC1471a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            }
        }

        @Override // c.a.p0.w0.l.d.a.InterfaceC1471a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.a.f31914b.setLike(true);
                this.a.f31916d.F(true);
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f31916d == null) {
                return;
            }
            this.a.m(null);
            TiebaStatic.log(new StatisticItem("c14585").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.f31916d.k()).param("obj_locate", 1));
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f31914b.d()) {
                    if (this.a.f31916d != null) {
                        String m = this.a.f31916d.m();
                        String k = this.a.f31916d.k();
                        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(k)) {
                            this.a.f31919g.f(m, k);
                        }
                    }
                } else if (this.a.f31916d != null) {
                    String m2 = this.a.f31916d.m();
                    String k2 = this.a.f31916d.k();
                    if (!TextUtils.isEmpty(m2) && !TextUtils.isEmpty(k2)) {
                        this.a.f31919g.e(m2, k2);
                    }
                }
                TiebaStatic.log(new StatisticItem("c14586").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.f31916d != null ? this.a.f31916d.k() : "").param("obj_param1", this.a.f31914b.d() ? 2 : 1));
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
                if (i == 0 && (this.a.f31915c.getLayoutManager() instanceof LinearLayoutManager) && this.a.f31916d != null) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.a.f31915c.getLayoutManager();
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    this.a.f31916d.setPosition(findFirstVisibleItemPosition);
                    View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    if (findViewByPosition != null) {
                        this.a.f31916d.I(findViewByPosition.getLeft());
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

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecommendForumView f31920b;

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
            this.f31920b = recommendForumView;
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
                super.getItemOffsets(rect, view, recyclerView, state);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
                if (childLayoutPosition != -1 && (layoutManager instanceof LinearLayoutManager)) {
                    if (childLayoutPosition == state.getItemCount() - 1) {
                        rect.set(0, 0, n.f(this.a, R.dimen.M_W_X004), 0);
                    } else {
                        rect.set(n.f(this.a, R.dimen.M_W_X004), 0, 0, 0);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements b.InterfaceC1470b {
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

        @Override // c.a.p0.w0.l.a.b.InterfaceC1470b
        public void a(c.a.p0.w0.l.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            this.a.m(cVar.e());
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

    public static ArrayList<Integer> f(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        InterceptResult invokeLLL;
        int b2;
        int b3;
        int b4;
        int i;
        int b5;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, themeElement, themeElement2, themeElement3)) == null) {
            if (themeElement == null) {
                b2 = c.a.p0.b2.o.k.b.b("#2BB8FF");
                b3 = c.a.p0.b2.o.k.b.b("#2BB8FF");
            } else {
                b2 = c.a.p0.b2.o.k.b.b(themeElement.common_color);
                b3 = c.a.p0.b2.o.k.b.b(themeElement.common_color);
            }
            if (themeElement2 == null) {
                i = c.a.p0.b2.o.k.b.b("#249BD6");
                b4 = c.a.p0.b2.o.k.b.b("#246CD6");
            } else {
                int b6 = c.a.p0.b2.o.k.b.b(themeElement2.common_color);
                b4 = c.a.p0.b2.o.k.b.b(themeElement2.common_color);
                i = b6;
            }
            if (themeElement3 == null) {
                i2 = c.a.p0.b2.o.k.b.b("#249BD6");
                b5 = c.a.p0.b2.o.k.b.b("#246CD6");
            } else {
                int b7 = c.a.p0.b2.o.k.b.b(themeElement3.common_color);
                b5 = c.a.p0.b2.o.k.b.b(themeElement3.common_color);
                i2 = b7;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(b2));
            arrayList.add(Integer.valueOf(b3));
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(b4));
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(b5));
            return arrayList;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            k(context);
            l();
            j(context);
            n();
            h(context);
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOnClickListener(new b(this));
            RecommendForumInfoView recommendForumInfoView = this.f31914b;
            if (recommendForumInfoView == null || recommendForumInfoView.getLikeButton() == null) {
                return;
            }
            this.f31914b.getLikeButton().setOnClickListener(new c(this));
            this.f31915c.addOnScrollListener(new d(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.w0.l.d.a aVar = new c.a.p0.w0.l.d.a();
            this.f31919g = aVar;
            aVar.h(this.f31917e);
            this.f31919g.g(new a(this));
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(0);
            this.f31915c.setLayoutManager(linearLayoutManager);
            this.f31915c.addItemDecoration(new e(this, context));
            c.a.p0.w0.l.a.b bVar = new c.a.p0.w0.l.a.b(context);
            this.f31918f = bVar;
            bVar.d(new f(this));
            this.f31915c.a(this.f31918f.b());
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d072b, this);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            setOrientation(1);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906c9);
            this.f31914b = (RecommendForumInfoView) findViewById(R.id.obfuscated_res_0x7f091a03);
            this.f31915c = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f091fc2);
        }
    }

    public final void m(String str) {
        c.a.p0.w0.l.b.b bVar;
        ThemeColorInfo themeColorInfo;
        Rect forumNameVisibleRect;
        Rect barVisibleRect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (bVar = this.f31916d) == null) {
            return;
        }
        String m = bVar.m();
        if (TextUtils.isEmpty(m)) {
            return;
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(m, "");
        createNormalCfg.getIntent().putExtra("transition_type", 2);
        RecommendForumInfoView recommendForumInfoView = this.f31914b;
        if (recommendForumInfoView != null && (barVisibleRect = recommendForumInfoView.getBarVisibleRect()) != null) {
            createNormalCfg.getIntent().putExtra("info_forum_image_rect", barVisibleRect);
        }
        RecommendForumInfoView recommendForumInfoView2 = this.f31914b;
        if (recommendForumInfoView2 != null && (forumNameVisibleRect = recommendForumInfoView2.getForumNameVisibleRect()) != null) {
            createNormalCfg.getIntent().putExtra("info_forum_name_rect", forumNameVisibleRect);
        }
        if (!TextUtils.isEmpty(this.f31916d.i())) {
            createNormalCfg.getIntent().putExtra("info_forum_image_url", this.f31916d.i());
        }
        if (!TextUtils.isEmpty(this.f31916d.m())) {
            createNormalCfg.getIntent().putExtra("info_forum_name_text", this.f31916d.m());
        }
        if (this.f31916d.s() != null) {
            String a2 = this.f31916d.s().a();
            if (!TextUtils.isEmpty(a2) && (themeColorInfo = (ThemeColorInfo) new Gson().fromJson(a2, (Class<Object>) ThemeColorInfo.class)) != null) {
                createNormalCfg.getIntent().putExtra("info_forum_head_background_color", f(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            long g2 = c.a.d.f.m.b.g(str, 0L);
            if (g2 > 0) {
                createNormalCfg.setFakeThreadId(g2);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.r.v.c.d(this.a).f(R.color.CAM_X0201);
            this.f31914b.e();
        }
    }

    public void setData(c.a.p0.w0.l.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f31916d = bVar;
        this.f31914b.setData(bVar.i(), bVar.m(), c.a.d.f.m.b.e(bVar.q(), 0), c.a.d.f.m.b.e(bVar.y(), 0), bVar.z());
        if (!ListUtils.isEmpty(bVar.v())) {
            this.f31915c.setData(bVar.v());
            if (this.f31915c.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f31915c.getLayoutManager();
                if (bVar.getPosition() != Integer.MIN_VALUE && bVar.r() != Integer.MIN_VALUE) {
                    linearLayoutManager.scrollToPositionWithOffset(bVar.getPosition(), bVar.r());
                } else {
                    linearLayoutManager.scrollToPosition(0);
                }
            }
        }
        n();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.f31917e = tbPageContext;
            i();
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
        g(context);
    }
}
