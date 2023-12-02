package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.TbHeadImageAutoSwitchWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class AutoCarouselContainerViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final ImageView b;
    @NonNull
    public final FrameLayout c;
    @NonNull
    public final TextView d;
    @NonNull
    public final TbHeadImageAutoSwitchWrapper e;
    @NonNull
    public final HeadImageView f;

    public AutoCarouselContainerViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TbHeadImageAutoSwitchWrapper tbHeadImageAutoSwitchWrapper, @NonNull HeadImageView headImageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayout, imageView, frameLayout, textView, tbHeadImageAutoSwitchWrapper, headImageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = linearLayout;
        this.b = imageView;
        this.c = frameLayout;
        this.d = textView;
        this.e = tbHeadImageAutoSwitchWrapper;
        this.f = headImageView;
    }

    @NonNull
    public static AutoCarouselContainerViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f090f44;
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f44);
            if (imageView != null) {
                i = R.id.obfuscated_res_0x7f090f45;
                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f45);
                if (frameLayout != null) {
                    i = R.id.obfuscated_res_0x7f090f4c;
                    TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f4c);
                    if (textView != null) {
                        i = R.id.obfuscated_res_0x7f0910ff;
                        TbHeadImageAutoSwitchWrapper tbHeadImageAutoSwitchWrapper = (TbHeadImageAutoSwitchWrapper) view2.findViewById(R.id.obfuscated_res_0x7f0910ff);
                        if (tbHeadImageAutoSwitchWrapper != null) {
                            i = R.id.obfuscated_res_0x7f09231a;
                            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09231a);
                            if (headImageView != null) {
                                return new AutoCarouselContainerViewBinding((LinearLayout) view2, imageView, frameLayout, textView, tbHeadImageAutoSwitchWrapper, headImageView);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (AutoCarouselContainerViewBinding) invokeL.objValue;
    }

    @NonNull
    public static AutoCarouselContainerViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0136, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (AutoCarouselContainerViewBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (LinearLayout) invokeV.objValue;
    }
}
