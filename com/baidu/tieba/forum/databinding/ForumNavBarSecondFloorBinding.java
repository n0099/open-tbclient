package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ForumNavBarSecondFloorBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final TbImage b;
    @NonNull
    public final MessageRedDotView c;

    public ForumNavBarSecondFloorBinding(@NonNull FrameLayout frameLayout, @NonNull TbImage tbImage, @NonNull MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout, tbImage, messageRedDotView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frameLayout;
        this.b = tbImage;
        this.c = messageRedDotView;
    }

    @NonNull
    public static ForumNavBarSecondFloorBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f092227;
            TbImage tbImage = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f092227);
            if (tbImage != null) {
                i = R.id.obfuscated_res_0x7f092229;
                MessageRedDotView messageRedDotView = (MessageRedDotView) view2.findViewById(R.id.obfuscated_res_0x7f092229);
                if (messageRedDotView != null) {
                    return new ForumNavBarSecondFloorBinding((FrameLayout) view2, tbImage, messageRedDotView);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (ForumNavBarSecondFloorBinding) invokeL.objValue;
    }

    @NonNull
    public static ForumNavBarSecondFloorBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0322, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (ForumNavBarSecondFloorBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (FrameLayout) invokeV.objValue;
    }
}
