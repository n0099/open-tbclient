package com.baidu.tieba.im.biz.aibot.navbarslice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.impersonal.databinding.SliceAibotNavbarBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/navbarslice/NavBarSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "()V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SliceAibotNavbarBinding;", "hide", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "show", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NavBarSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SliceAibotNavbarBinding j;

    /* loaded from: classes6.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavBarSlice a;

        public a(NavBarSlice navBarSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navBarSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navBarSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.F().getActivity()) != null) {
                activity.finish();
            }
        }
    }

    public NavBarSlice() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SliceAibotNavbarBinding sliceAibotNavbarBinding = this.j;
            if (sliceAibotNavbarBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                sliceAibotNavbarBinding = null;
            }
            sliceAibotNavbarBinding.b.setVisibility(8);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SliceAibotNavbarBinding sliceAibotNavbarBinding = this.j;
            if (sliceAibotNavbarBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                sliceAibotNavbarBinding = null;
            }
            sliceAibotNavbarBinding.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View P(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            SliceAibotNavbarBinding it = SliceAibotNavbarBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.j = it;
            NavigationBar root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…nding = it\n        }.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void V(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.V(view2, bundle);
            SliceAibotNavbarBinding sliceAibotNavbarBinding = this.j;
            if (sliceAibotNavbarBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                sliceAibotNavbarBinding = null;
            }
            sliceAibotNavbarBinding.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        }
    }
}
