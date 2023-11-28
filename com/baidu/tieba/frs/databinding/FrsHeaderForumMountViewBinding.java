package com.baidu.tieba.frs.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class FrsHeaderForumMountViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final TbImageView b;
    @NonNull
    public final TextView c;
    @NonNull
    public final TextView d;
    @NonNull
    public final TbImageAutoSwitch e;
    @NonNull
    public final GifView f;
    @NonNull
    public final TextView g;
    @NonNull
    public final View h;
    @NonNull
    public final RelativeLayout i;
    @NonNull
    public final TextView j;
    @NonNull
    public final RelativeLayout k;

    public FrsHeaderForumMountViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull TbImageView tbImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TbImageAutoSwitch tbImageAutoSwitch, @NonNull GifView gifView, @NonNull TextView textView3, @NonNull View view2, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView4, @NonNull RelativeLayout relativeLayout3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {relativeLayout, tbImageView, textView, textView2, tbImageAutoSwitch, gifView, textView3, view2, relativeLayout2, textView4, relativeLayout3};
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
        this.b = tbImageView;
        this.c = textView;
        this.d = textView2;
        this.e = tbImageAutoSwitch;
        this.f = gifView;
        this.g = textView3;
        this.h = view2;
        this.i = relativeLayout2;
        this.j = textView4;
        this.k = relativeLayout3;
    }

    @NonNull
    public static FrsHeaderForumMountViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f09187c;
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09187c);
            if (tbImageView != null) {
                i = R.id.obfuscated_res_0x7f09187d;
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09187d);
                if (textView != null) {
                    i = R.id.obfuscated_res_0x7f09187e;
                    TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09187e);
                    if (textView2 != null) {
                        i = R.id.obfuscated_res_0x7f09187f;
                        TbImageAutoSwitch tbImageAutoSwitch = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f09187f);
                        if (tbImageAutoSwitch != null) {
                            i = R.id.obfuscated_res_0x7f091880;
                            GifView gifView = (GifView) view2.findViewById(R.id.obfuscated_res_0x7f091880);
                            if (gifView != null) {
                                i = R.id.obfuscated_res_0x7f091881;
                                TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091881);
                                if (textView3 != null) {
                                    i = R.id.obfuscated_res_0x7f091882;
                                    View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091882);
                                    if (findViewById != null) {
                                        i = R.id.obfuscated_res_0x7f091883;
                                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091883);
                                        if (relativeLayout != null) {
                                            i = R.id.obfuscated_res_0x7f091884;
                                            TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091884);
                                            if (textView4 != null) {
                                                RelativeLayout relativeLayout2 = (RelativeLayout) view2;
                                                return new FrsHeaderForumMountViewBinding(relativeLayout2, tbImageView, textView, textView2, tbImageAutoSwitch, gifView, textView3, findViewById, relativeLayout, textView4, relativeLayout2);
                                            }
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
        return (FrsHeaderForumMountViewBinding) invokeL.objValue;
    }

    @NonNull
    public static FrsHeaderForumMountViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d038f, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FrsHeaderForumMountViewBinding) invokeLLZ.objValue;
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
