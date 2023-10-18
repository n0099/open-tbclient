package com.baidu.tieba.im.biz.aibot.navbarslice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.impersonal.databinding.SliceAibotNavbarBinding;
import com.baidu.tieba.va8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\tJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u001c\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/navbarslice/NavBarSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", "()V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SliceAibotNavbarBinding;", "mPageState", "", "addBackBtn", "", "hide", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSetChatDetail", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "onSetPageState", "state", "refreshPage", "", "onViewCreated", "view", "show", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NavBarSlice extends Slice implements va8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SliceAibotNavbarBinding j;
    public int k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1468964305, "Lcom/baidu/tieba/im/biz/aibot/navbarslice/NavBarSlice;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1468964305, "Lcom/baidu/tieba/im/biz/aibot/navbarslice/NavBarSlice;");
        }
    }

    @Override // com.baidu.tieba.va8
    public void J(AibotChatDetail chatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
        }
    }

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.M().getActivity()) != null) {
                activity.finish();
            }
        }
    }

    public NavBarSlice() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = -1;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SliceAibotNavbarBinding sliceAibotNavbarBinding = this.j;
            if (sliceAibotNavbarBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                sliceAibotNavbarBinding = null;
            }
            sliceAibotNavbarBinding.b.setVisibility(8);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SliceAibotNavbarBinding sliceAibotNavbarBinding = this.j;
            if (sliceAibotNavbarBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                sliceAibotNavbarBinding = null;
            }
            sliceAibotNavbarBinding.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.va8
    public void D1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.k == i) {
            return;
        }
        this.k = i;
        e0();
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            e0();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, inflater, container, bundle)) == null) {
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

    public final void e0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || -1 == this.k) {
            return;
        }
        ImageView imageView = new ImageView(M().getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(M().getContext(), R.dimen.tbds104), BdUtilHelper.getDimens(M().getContext(), R.dimen.tbds104));
        layoutParams.leftMargin = BdUtilHelper.getDimens(M().getContext(), R.dimen.M_W_X003);
        layoutParams.addRule(13);
        if (this.k == 1) {
            i = R.drawable.obfuscated_res_0x7f080d88;
        } else {
            i = R.drawable.obfuscated_res_0x7f080d89;
        }
        imageView.setImageResource(i);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        SliceAibotNavbarBinding sliceAibotNavbarBinding = this.j;
        if (sliceAibotNavbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            sliceAibotNavbarBinding = null;
        }
        sliceAibotNavbarBinding.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, imageView, new a(this));
    }
}
