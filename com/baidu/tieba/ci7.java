package com.baidu.tieba;

import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.widget.TbBottomSheetView;
import com.baidu.tieba.forum.widget.ViewExtentionsKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes5.dex */
public final class ci7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity a;
    public final ActivityForumBinding b;
    public en7 c;
    public final a d;

    /* loaded from: classes5.dex */
    public static final class a implements dp7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final /* synthetic */ ci7 b;

        public a(ci7 ci7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci7Var;
        }

        @Override // com.baidu.tieba.dp7
        public Boolean a(MotionEvent e) {
            InterceptResult invokeL;
            bi7 bi7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                int action = e.getAction();
                ai7 ai7Var = null;
                if (action != 0) {
                    if (action == 2) {
                        if (e.getRawY() - this.a > 5.0f) {
                            return b();
                        }
                        if (e.getRawY() - this.a >= -5.0f) {
                            return null;
                        }
                        Boolean b = b();
                        if (Intrinsics.areEqual(b, Boolean.TRUE)) {
                            FragmentActivity fragmentActivity = this.b.a;
                            if (fragmentActivity instanceof ai7) {
                                ai7Var = (ai7) fragmentActivity;
                            }
                            if (ai7Var != null && (bi7Var = (bi7) ai7Var.j2(Reflection.getOrCreateKotlinClass(bi7.class))) != null) {
                                bi7Var.t();
                            }
                        }
                        return b;
                    }
                } else {
                    this.a = e.getRawY();
                }
                return null;
            }
            return (Boolean) invokeL.objValue;
        }

        public final Boolean b() {
            InterceptResult invokeV;
            en7 en7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                en7 en7Var2 = this.b.c;
                if (en7Var2 != null) {
                    en7Var2.G();
                }
                TbBottomSheetView tbBottomSheetView = this.b.b.t;
                Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
                LinearLayout linearLayout = this.b.b.h;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
                if (!ViewExtentionsKt.f(tbBottomSheetView, linearLayout) || (en7Var = this.b.c) == null) {
                    return null;
                }
                return Boolean.valueOf(en7Var.c());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public ci7(FragmentActivity activity, ActivityForumBinding binding, en7 en7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, binding, en7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.a = activity;
        this.b = binding;
        this.c = en7Var;
        this.d = new a(this);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.m.H(this.d);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.m.K(this.d);
        }
    }
}
