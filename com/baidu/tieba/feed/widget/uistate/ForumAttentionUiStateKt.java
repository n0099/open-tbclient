package com.baidu.tieba.feed.widget.uistate;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.f05;
import com.baidu.tieba.feed.widget.uistate.ForumAttentionUiStateKt;
import com.baidu.tieba.fra;
import com.baidu.tieba.h05;
import com.baidu.tieba.j05;
import com.baidu.tieba.pd7;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w4;
import com.baidu.tieba.ws;
import com.baidu.tieba.xb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u001c\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u001c\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\"$\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"DefaultOnAttentionClick", "Lkotlin/Function2;", "Lcom/baidu/tieba/feed/widget/uistate/ForumAttentionUiState;", "Lcom/baidu/tbadk/TbPageContext;", "", "handlerLikeForum", "state", "pageContext", "handlerUnLikeForum", "showUnLikePopupWindow", "lib-components_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ForumAttentionUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<pd7, TbPageContext<?>, Unit> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeModel a;
        public final /* synthetic */ TbPageContext<?> b;
        public final /* synthetic */ pd7 c;

        public a(LikeModel likeModel, TbPageContext<?> tbPageContext, pd7 pd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeModel, tbPageContext, pd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = likeModel;
            this.b = tbPageContext;
            this.c = pd7Var;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    BdUtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.getErrorCode() != 0) {
                        BdUtilHelper.showToast(this.b.getPageActivity(), this.a.getErrorString());
                    } else {
                        this.c.g().d(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements fra.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pd7 a;
        public final /* synthetic */ TbPageContext<?> b;

        public b(pd7 pd7Var, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd7Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pd7Var;
            this.b = tbPageContext;
        }

        @Override // com.baidu.tieba.fra.a
        public void a(String errorString, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, errorString, j) == null) {
                Intrinsics.checkNotNullParameter(errorString, "errorString");
                BdUtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.operation_failed));
            }
        }

        @Override // com.baidu.tieba.fra.a
        public void b(String forumName, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumName, j) == null) {
                Intrinsics.checkNotNullParameter(forumName, "forumName");
                this.a.g().d(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1422416788, "Lcom/baidu/tieba/feed/widget/uistate/ForumAttentionUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1422416788, "Lcom/baidu/tieba/feed/widget/uistate/ForumAttentionUiStateKt;");
                return;
            }
        }
        a = ForumAttentionUiStateKt$DefaultOnAttentionClick$1.INSTANCE;
    }

    public static final void h(h05 dialog, TbPageContext pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, dialog, pageContext) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            xb.a(dialog, pageContext.getPageActivity());
        }
    }

    public static final void d(pd7 pd7Var, TbPageContext<?> tbPageContext) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pd7Var, tbPageContext) == null) {
            if (pd7Var.g().b().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && pd7Var.g().a() > 0) {
                LikeModel likeModel = new LikeModel(tbPageContext);
                likeModel.setLoadDataCallBack(new a(likeModel, tbPageContext, pd7Var));
                likeModel.g0(pd7Var.g().b(), String.valueOf(pd7Var.g().a()));
            }
        }
    }

    public static final void e(pd7 pd7Var, TbPageContext<?> tbPageContext) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pd7Var, tbPageContext) == null) {
            if (pd7Var.g().b().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && pd7Var.g().a() > 0) {
                fra fraVar = new fra();
                fraVar.b(new b(pd7Var, tbPageContext));
                fraVar.c(pd7Var.g().b(), pd7Var.g().a());
            }
        }
    }

    public static final void f(final pd7 pd7Var, final TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, pd7Var, tbPageContext) == null) {
            j05 j05Var = new j05(tbPageContext.getPageActivity());
            j05Var.u(tbPageContext.getString(R.string.confirm_unlike_forum));
            ArrayList arrayList = new ArrayList();
            final h05 h05Var = new h05(tbPageContext, j05Var);
            f05 f05Var = new f05(tbPageContext.getString(R.string.obfuscated_res_0x7f0f04ca), j05Var);
            f05Var.n(new j05.e() { // from class: com.baidu.tieba.od7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.j05.e
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ForumAttentionUiStateKt.g(pd7.this, tbPageContext, h05Var);
                    }
                }
            });
            arrayList.add(f05Var);
            j05Var.p(new j05.c() { // from class: com.baidu.tieba.nd7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.j05.c
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ForumAttentionUiStateKt.h(h05.this, tbPageContext);
                    }
                }
            });
            j05Var.m(arrayList);
            h05Var.k(0.7f);
            xb.i(h05Var, tbPageContext.getPageActivity());
            ws.n(pd7Var.i(), pd7Var.f(), false);
        }
    }

    public static final void g(pd7 state, TbPageContext pageContext, h05 dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, state, pageContext, dialog) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            e(state, pageContext);
            xb.a(dialog, pageContext.getPageActivity());
            ws.n(state.i(), state.f(), true);
        }
    }
}
