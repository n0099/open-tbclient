package com.baidu.tieba.frs.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.baidu.adp.widget.ImageView.BdRoundedImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class FrsGroupCardLayoutBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final RecyclerView b;
    @NonNull
    public final BdRoundedImageView c;
    @NonNull
    public final ImageView d;
    @NonNull
    public final RelativeLayout e;
    @NonNull
    public final TextView f;
    @NonNull
    public final ImageView g;
    @NonNull
    public final LinearLayout h;
    @NonNull
    public final TextView i;
    @NonNull
    public final RelativeLayout j;

    public FrsGroupCardLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull BdRoundedImageView bdRoundedImageView, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relativeLayout, recyclerView, bdRoundedImageView, imageView, relativeLayout2, textView, imageView2, linearLayout, textView2, relativeLayout3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = relativeLayout;
        this.b = recyclerView;
        this.c = bdRoundedImageView;
        this.d = imageView;
        this.e = relativeLayout2;
        this.f = textView;
        this.g = imageView2;
        this.h = linearLayout;
        this.i = textView2;
        this.j = relativeLayout3;
    }

    @NonNull
    public static FrsGroupCardLayoutBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f090dc9;
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090dc9);
            if (recyclerView != null) {
                i = R.id.obfuscated_res_0x7f090e14;
                BdRoundedImageView bdRoundedImageView = (BdRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e14);
                if (bdRoundedImageView != null) {
                    i = R.id.obfuscated_res_0x7f090e1a;
                    ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e1a);
                    if (imageView != null) {
                        i = R.id.obfuscated_res_0x7f090e1c;
                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e1c);
                        if (relativeLayout != null) {
                            i = R.id.obfuscated_res_0x7f090e25;
                            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e25);
                            if (textView != null) {
                                i = R.id.obfuscated_res_0x7f091640;
                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091640);
                                if (imageView2 != null) {
                                    i = R.id.obfuscated_res_0x7f091641;
                                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091641);
                                    if (linearLayout != null) {
                                        i = R.id.obfuscated_res_0x7f091654;
                                        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091654);
                                        if (textView2 != null) {
                                            RelativeLayout relativeLayout2 = (RelativeLayout) view2;
                                            return new FrsGroupCardLayoutBinding(relativeLayout2, recyclerView, bdRoundedImageView, imageView, relativeLayout, textView, imageView2, linearLayout, textView2, relativeLayout2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (FrsGroupCardLayoutBinding) invokeL.objValue;
    }

    @NonNull
    public static FrsGroupCardLayoutBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0317, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FrsGroupCardLayoutBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (RelativeLayout) invokeV.objValue;
    }
}
