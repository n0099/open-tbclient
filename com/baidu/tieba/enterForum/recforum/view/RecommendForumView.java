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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.repackage.b66;
import com.repackage.c66;
import com.repackage.g66;
import com.repackage.hd7;
import com.repackage.ng;
import com.repackage.pi;
import com.repackage.vr4;
import com.repackage.z56;
import java.util.ArrayList;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class RecommendForumView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public RecommendForumInfoView b;
    public BdTypeRecyclerView c;
    public b66 d;
    public TbPageContext e;
    public z56 f;
    public g66 g;

    /* loaded from: classes3.dex */
    public class a implements g66.a {
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

        @Override // com.repackage.g66.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.b.setLike(false);
                this.a.d.F(false);
            }
        }

        @Override // com.repackage.g66.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            }
        }

        @Override // com.repackage.g66.a
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.a.b.setLike(true);
                this.a.d.F(true);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.d == null) {
                return;
            }
            this.a.m(null);
            TiebaStatic.log(new StatisticItem("c14585").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.d.i()).param("obj_locate", 1));
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b.d()) {
                    if (this.a.d != null) {
                        String k = this.a.d.k();
                        String i = this.a.d.i();
                        if (!TextUtils.isEmpty(k) && !TextUtils.isEmpty(i)) {
                            this.a.g.f(k, i);
                        }
                    }
                } else if (this.a.d != null) {
                    String k2 = this.a.d.k();
                    String i2 = this.a.d.i();
                    if (!TextUtils.isEmpty(k2) && !TextUtils.isEmpty(i2)) {
                        this.a.g.e(k2, i2);
                    }
                }
                TiebaStatic.log(new StatisticItem("c14586").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.d != null ? this.a.d.i() : "").param("obj_param1", this.a.b.d() ? 2 : 1));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                        this.a.d.I(findViewByPosition.getLeft());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    int f = pi.f(this.a, R.dimen.M_W_X004);
                    if (childLayoutPosition == state.getItemCount() - 1) {
                        rect.set(f, 0, f, 0);
                    } else {
                        rect.set(f, 0, 0, 0);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements z56.b {
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

        @Override // com.repackage.z56.b
        public void a(c66 c66Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, c66Var) == null) || c66Var == null) {
                return;
            }
            this.a.m(c66Var.c());
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
                b2 = hd7.b("#2BB8FF");
                b3 = hd7.b("#2BB8FF");
            } else {
                b2 = hd7.b(themeElement.common_color);
                b3 = hd7.b(themeElement.common_color);
            }
            if (themeElement2 == null) {
                i = hd7.b("#249BD6");
                b4 = hd7.b("#246CD6");
            } else {
                int b6 = hd7.b(themeElement2.common_color);
                b4 = hd7.b(themeElement2.common_color);
                i = b6;
            }
            if (themeElement3 == null) {
                i2 = hd7.b("#249BD6");
                b5 = hd7.b("#246CD6");
            } else {
                int b7 = hd7.b(themeElement3.common_color);
                b5 = hd7.b(themeElement3.common_color);
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
            RecommendForumInfoView recommendForumInfoView = this.b;
            if (recommendForumInfoView == null || recommendForumInfoView.getLikeButton() == null) {
                return;
            }
            this.b.getLikeButton().setOnClickListener(new c(this));
            this.c.addOnScrollListener(new d(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g66 g66Var = new g66();
            this.g = g66Var;
            g66Var.h(this.e);
            this.g.g(new a(this));
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(0);
            this.c.setLayoutManager(linearLayoutManager);
            this.c.addItemDecoration(new e(this, context));
            z56 z56Var = new z56(context);
            this.f = z56Var;
            z56Var.d(new f(this));
            this.c.a(this.f.b());
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0732, this);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            setOrientation(1);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09069f);
            this.b = (RecommendForumInfoView) findViewById(R.id.obfuscated_res_0x7f091a73);
            this.c = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f092058);
        }
    }

    public final void m(String str) {
        b66 b66Var;
        ThemeColorInfo themeColorInfo;
        Rect forumNameVisibleRect;
        Rect barVisibleRect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (b66Var = this.d) == null) {
            return;
        }
        String k = b66Var.k();
        if (TextUtils.isEmpty(k)) {
            return;
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(k, "");
        if (UbsABTestHelper.isEnterFrsNoAnmi()) {
            createNormalCfg.getIntent().putExtra("transition_type", 0);
        } else {
            createNormalCfg.getIntent().putExtra("transition_type", 2);
            RecommendForumInfoView recommendForumInfoView = this.b;
            if (recommendForumInfoView != null && (barVisibleRect = recommendForumInfoView.getBarVisibleRect()) != null) {
                createNormalCfg.getIntent().putExtra("info_forum_image_rect", barVisibleRect);
            }
            RecommendForumInfoView recommendForumInfoView2 = this.b;
            if (recommendForumInfoView2 != null && (forumNameVisibleRect = recommendForumInfoView2.getForumNameVisibleRect()) != null) {
                createNormalCfg.getIntent().putExtra("info_forum_name_rect", forumNameVisibleRect);
            }
            if (!TextUtils.isEmpty(this.d.g())) {
                createNormalCfg.getIntent().putExtra("info_forum_image_url", this.d.g());
            }
            if (!TextUtils.isEmpty(this.d.k())) {
                createNormalCfg.getIntent().putExtra("info_forum_name_text", this.d.k());
            }
            if (this.d.s() != null) {
                String a2 = this.d.s().a();
                if (!TextUtils.isEmpty(a2) && (themeColorInfo = (ThemeColorInfo) new Gson().fromJson(a2, (Class<Object>) ThemeColorInfo.class)) != null) {
                    createNormalCfg.getIntent().putExtra("info_forum_head_background_color", f(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark));
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            long g = ng.g(str, 0L);
            if (g > 0) {
                createNormalCfg.setFakeThreadId(g);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            vr4.d(this.a).f(R.color.CAM_X0201);
            this.b.e();
        }
    }

    public void setData(b66 b66Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b66Var) == null) || b66Var == null) {
            return;
        }
        this.d = b66Var;
        this.b.setData(b66Var.g(), b66Var.k(), ng.e(b66Var.m(), 0), ng.e(b66Var.u(), 0), b66Var.x());
        if (!ListUtils.isEmpty(b66Var.t())) {
            this.c.setData(b66Var.t());
            if (this.c.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.c.getLayoutManager();
                if (b66Var.getPosition() != Integer.MIN_VALUE && b66Var.o() != Integer.MIN_VALUE) {
                    linearLayoutManager.scrollToPositionWithOffset(b66Var.getPosition(), b66Var.o());
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
            this.e = tbPageContext;
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
