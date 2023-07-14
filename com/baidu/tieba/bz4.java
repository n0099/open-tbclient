package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bz4 extends bj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zy4 a;
    public boolean b;

    public bz4(zy4 mConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mConfig, "mConfig");
        this.a = mConfig;
    }

    @Override // com.baidu.tieba.bj5
    public void c(final dj5 editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editor) == null) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            if (!(editor instanceof az4)) {
                return;
            }
            final EditorTools b = editor.b();
            aj5 aj5Var = new aj5() { // from class: com.baidu.tieba.wy4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.aj5
                public final void B(zi5 zi5Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, zi5Var) == null) {
                        bz4.e(dj5.this, this, b, zi5Var);
                    }
                }
            };
            b.setActionListener(4, aj5Var);
            b.setActionListener(7, aj5Var);
            b.setActionListener(16, aj5Var);
            b.setActionListener(8, aj5Var);
        }
    }

    public static final void e(dj5 editor, bz4 this$0, EditorTools editorTools, zi5 zi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, editor, this$0, editorTools, zi5Var) == null) {
            Intrinsics.checkNotNullParameter(editor, "$editor");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            az4 az4Var = (az4) editor;
            if (az4Var.b() == null || zi5Var == null) {
                return;
            }
            int i = zi5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 7) {
                        if (i != 8 || !this$0.f(az4Var.getContext(), 12015)) {
                            return;
                        }
                        az4Var.l();
                        return;
                    }
                    az4Var.getContext().showToast((int) R.string.over_limit_tip);
                    this$0.b = true;
                    return;
                }
                if (this$0.b) {
                    az4Var.getContext().showToast((int) R.string.over_limit_tip);
                }
                if (!this$0.f(az4Var.getContext(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(az4Var.getContext().getPageActivity(), 12005, true);
                editorTools.setPadding(0, 0, 0, 0);
                if (az4Var.f() != null) {
                    SpanGroupManager f = az4Var.f();
                    Intrinsics.checkNotNull(f);
                    atListActivityConfig.setSelectedAtList(f.w());
                }
                atListActivityConfig.setFromTid(editorTools.getTid());
                atListActivityConfig.setFromFid(String.valueOf(editorTools.getFid()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("tid", editorTools.getTid());
                statisticItem.addParam("fid", editorTools.getFid());
                TiebaStatic.log(statisticItem);
                return;
            }
            Object obj = zi5Var.c;
            if (obj instanceof jl5) {
                if (obj != null) {
                    String str = ((jl5) obj).a;
                    Intrinsics.checkNotNullExpressionValue(str, "action.data as SubPbInputContentData).mContent");
                    az4Var.q(str);
                    Object obj2 = zi5Var.c;
                    if (obj2 != null) {
                        az4Var.r(((jl5) obj2).c);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.pb.SubPbInputContentData");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.pb.SubPbInputContentData");
                }
            }
            this$0.b = false;
        }
    }

    @Override // com.baidu.tieba.bj5
    public dj5 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            dj5 a = super.a(context);
            Intrinsics.checkNotNullExpressionValue(a, "super.build(context)");
            return a;
        }
        return (dj5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bj5
    public dj5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(10);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.transparent);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
            editorTools.setIsShowAllBg(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setHideBigEmotion(true);
            editorTools.setClearEbPadding(true);
            return new az4(editorTools);
        }
        return (dj5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bj5
    public void d(dj5 editor) {
        lj5 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editor) == null) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            EditorTools b = editor.b();
            if (this.a.f) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                b.h(arrayList);
                if (!this.a.g && (p = b.p(5)) != null) {
                    p.e(false);
                    p.f(false);
                    p.l = 2;
                }
            }
            if (this.a.h) {
                nj5 nj5Var = new nj5(b.getContext(), 7);
                nj5Var.i = false;
                b.d(nj5Var);
            }
            cz4 cz4Var = new cz4(b.getContext());
            cz4Var.g(this.a);
            b.d(cz4Var);
            b.f();
        }
    }

    public final boolean f(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, tbPageContext, i)) == null) {
            if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNull(tbPageContext);
            inst.login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
