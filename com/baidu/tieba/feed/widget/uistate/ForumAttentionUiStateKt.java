package com.baidu.tieba.feed.widget.uistate;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.feed.widget.uistate.ForumAttentionUiStateKt;
import com.baidu.tieba.fs;
import com.baidu.tieba.g4;
import com.baidu.tieba.hb;
import com.baidu.tieba.nz4;
import com.baidu.tieba.pz4;
import com.baidu.tieba.r97;
import com.baidu.tieba.rz4;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.zda;
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
    public static final Function2<r97, TbPageContext<?>, Unit> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a extends g4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeModel a;
        public final /* synthetic */ TbPageContext<?> b;
        public final /* synthetic */ r97 c;

        public a(LikeModel likeModel, TbPageContext<?> tbPageContext, r97 r97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeModel, tbPageContext, r97Var};
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
            this.c = r97Var;
        }

        @Override // com.baidu.tieba.g4
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
                        this.c.f().d(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements zda.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r97 a;
        public final /* synthetic */ TbPageContext<?> b;

        public b(r97 r97Var, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r97Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r97Var;
            this.b = tbPageContext;
        }

        @Override // com.baidu.tieba.zda.a
        public void a(String errorString, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, errorString, j) == null) {
                Intrinsics.checkNotNullParameter(errorString, "errorString");
                BdUtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.operation_failed));
            }
        }

        @Override // com.baidu.tieba.zda.a
        public void b(String forumName, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumName, j) == null) {
                Intrinsics.checkNotNullParameter(forumName, "forumName");
                this.a.f().d(false);
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

    public static final void h(pz4 dialog, TbPageContext pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, dialog, pageContext) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            hb.a(dialog, pageContext.getPageActivity());
        }
    }

    public static final void d(r97 r97Var, TbPageContext<?> tbPageContext) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, r97Var, tbPageContext) == null) {
            if (r97Var.f().b().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && r97Var.f().a() > 0) {
                LikeModel likeModel = new LikeModel(tbPageContext);
                likeModel.setLoadDataCallBack(new a(likeModel, tbPageContext, r97Var));
                likeModel.f0(r97Var.f().b(), String.valueOf(r97Var.f().a()));
            }
        }
    }

    public static final void e(r97 r97Var, TbPageContext<?> tbPageContext) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, r97Var, tbPageContext) == null) {
            if (r97Var.f().b().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && r97Var.f().a() > 0) {
                zda zdaVar = new zda();
                zdaVar.b(new b(r97Var, tbPageContext));
                zdaVar.c(r97Var.f().b(), r97Var.f().a());
            }
        }
    }

    public static final void f(final r97 r97Var, final TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, r97Var, tbPageContext) == null) {
            rz4 rz4Var = new rz4(tbPageContext.getPageActivity());
            rz4Var.u(tbPageContext.getString(R.string.confirm_unlike_forum));
            ArrayList arrayList = new ArrayList();
            final pz4 pz4Var = new pz4(tbPageContext, rz4Var);
            nz4 nz4Var = new nz4(tbPageContext.getString(R.string.obfuscated_res_0x7f0f04c8), rz4Var);
            nz4Var.m(new rz4.e() { // from class: com.baidu.tieba.q97
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rz4.e
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ForumAttentionUiStateKt.g(r97.this, tbPageContext, pz4Var);
                    }
                }
            });
            arrayList.add(nz4Var);
            rz4Var.p(new rz4.c() { // from class: com.baidu.tieba.p97
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rz4.c
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ForumAttentionUiStateKt.h(pz4.this, tbPageContext);
                    }
                }
            });
            rz4Var.m(arrayList);
            pz4Var.k(0.7f);
            hb.i(pz4Var, tbPageContext.getPageActivity());
            fs.n(r97Var.h(), r97Var.e(), false);
        }
    }

    public static final void g(r97 state, TbPageContext pageContext, pz4 dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, state, pageContext, dialog) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            e(state, pageContext);
            hb.a(dialog, pageContext.getPageActivity());
            fs.n(state.h(), state.e(), true);
        }
    }
}
