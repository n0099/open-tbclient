package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.forum.view.FrsAutoCarouselImageContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class LayoutAiSecondFloorBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final TbImage b;
    @NonNull
    public final LinearLayout c;
    @NonNull
    public final TbImage d;
    @NonNull
    public final TbImage e;
    @NonNull
    public final FrsAutoCarouselImageContainer f;

    public LayoutAiSecondFloorBinding(@NonNull View view2, @NonNull TbImage tbImage, @NonNull LinearLayout linearLayout, @NonNull TbImage tbImage2, @NonNull TbImage tbImage3, @NonNull FrsAutoCarouselImageContainer frsAutoCarouselImageContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbImage, linearLayout, tbImage2, tbImage3, frsAutoCarouselImageContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = tbImage;
        this.c = linearLayout;
        this.d = tbImage2;
        this.e = tbImage3;
        this.f = frsAutoCarouselImageContainer;
    }

    @NonNull
    public static LayoutAiSecondFloorBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f090463;
            TbImage tbImage = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f090463);
            if (tbImage != null) {
                i = R.id.obfuscated_res_0x7f090464;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090464);
                if (linearLayout != null) {
                    i = R.id.obfuscated_res_0x7f09046f;
                    TbImage tbImage2 = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f09046f);
                    if (tbImage2 != null) {
                        i = R.id.obfuscated_res_0x7f09047d;
                        TbImage tbImage3 = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f09047d);
                        if (tbImage3 != null) {
                            i = R.id.obfuscated_res_0x7f090690;
                            FrsAutoCarouselImageContainer frsAutoCarouselImageContainer = (FrsAutoCarouselImageContainer) view2.findViewById(R.id.obfuscated_res_0x7f090690);
                            if (frsAutoCarouselImageContainer != null) {
                                return new LayoutAiSecondFloorBinding(view2, tbImage, linearLayout, tbImage2, tbImage3, frsAutoCarouselImageContainer);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (LayoutAiSecondFloorBinding) invokeL.objValue;
    }

    @NonNull
    public static LayoutAiSecondFloorBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0539, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (LayoutAiSecondFloorBinding) invokeLL.objValue;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }
}
