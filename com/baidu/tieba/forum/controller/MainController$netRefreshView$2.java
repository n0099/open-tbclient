package com.baidu.tieba.forum.controller;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bi7;
import com.baidu.tieba.fk5;
import com.baidu.tieba.forum.ForumLog;
import com.baidu.tieba.forum.controller.MainController;
import com.baidu.tieba.forum.controller.MainController$netRefreshView$2;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/tbadk/loading/NetRefreshView;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainController$netRefreshView$2 extends Lambda implements Function0<fk5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ MainController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainController$netRefreshView$2(MainController mainController) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = mainController;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m136invoke$lambda0(MainController this$0, View view2) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TbLog b = ForumLog.b.b();
            String str = this$0.c;
            b.i(str, "forum " + this$0.g + " network refresh view retry clicked");
            bi7.c(this$0.G()).B();
            this$0.E();
            bundle = this$0.f;
            if (bundle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(StateManager.KEY_STATE);
                bundle = null;
            }
            this$0.K(bundle);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final fk5 invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentActivity G = this.this$0.G();
            final MainController mainController = this.this$0;
            fk5 fk5Var = new fk5(G, new View.OnClickListener() { // from class: com.baidu.tieba.mg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MainController$netRefreshView$2.m136invoke$lambda0(MainController.this, view2);
                    }
                }
            });
            fk5Var.onChangeSkinType();
            SkinManager.setBackgroundColor(fk5Var.getView(), R.color.CAM_X0201);
            return fk5Var;
        }
        return (fk5) invokeV.objValue;
    }
}
