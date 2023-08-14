package com.baidu.tieba.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class MemberPayPrivilegeResultActivityBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final ImageView b;
    @NonNull
    public final TbImageView c;
    @NonNull
    public final TbImageView d;
    @NonNull
    public final RoundRelativeLayout e;
    @NonNull
    public final View f;
    @NonNull
    public final RelativeLayout g;
    @NonNull
    public final TbImageView h;
    @NonNull
    public final TbImageView i;
    @NonNull
    public final ImageView j;
    @NonNull
    public final TextView k;
    @NonNull
    public final EMTextView l;
    @NonNull
    public final TextView m;

    public MemberPayPrivilegeResultActivityBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TbImageView tbImageView, @NonNull TbImageView tbImageView2, @NonNull RoundRelativeLayout roundRelativeLayout, @NonNull View view2, @NonNull RelativeLayout relativeLayout2, @NonNull TbImageView tbImageView3, @NonNull TbImageView tbImageView4, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull EMTextView eMTextView, @NonNull TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {relativeLayout, imageView, tbImageView, tbImageView2, roundRelativeLayout, view2, relativeLayout2, tbImageView3, tbImageView4, imageView2, textView, eMTextView, textView2};
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
        this.b = imageView;
        this.c = tbImageView;
        this.d = tbImageView2;
        this.e = roundRelativeLayout;
        this.f = view2;
        this.g = relativeLayout2;
        this.h = tbImageView3;
        this.i = tbImageView4;
        this.j = imageView2;
        this.k = textView;
        this.l = eMTextView;
        this.m = textView2;
    }

    @NonNull
    public static MemberPayPrivilegeResultActivityBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f0904b8;
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0904b8);
            if (imageView != null) {
                i = R.id.obfuscated_res_0x7f0910e5;
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910e5);
                if (tbImageView != null) {
                    i = R.id.obfuscated_res_0x7f0910e6;
                    TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910e6);
                    if (tbImageView2 != null) {
                        i = R.id.main_container;
                        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) view2.findViewById(R.id.main_container);
                        if (roundRelativeLayout != null) {
                            i = R.id.obfuscated_res_0x7f09170d;
                            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09170d);
                            if (findViewById != null) {
                                i = R.id.navigation_bar;
                                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.navigation_bar);
                                if (relativeLayout != null) {
                                    i = R.id.obfuscated_res_0x7f0918d4;
                                    TbImageView tbImageView3 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918d4);
                                    if (tbImageView3 != null) {
                                        i = R.id.obfuscated_res_0x7f0925f8;
                                        TbImageView tbImageView4 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925f8);
                                        if (tbImageView4 != null) {
                                            i = R.id.obfuscated_res_0x7f092715;
                                            ImageView imageView2 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092715);
                                            if (imageView2 != null) {
                                                i = R.id.obfuscated_res_0x7f09272e;
                                                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09272e);
                                                if (textView != null) {
                                                    i = R.id.obfuscated_res_0x7f09272f;
                                                    EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09272f);
                                                    if (eMTextView != null) {
                                                        i = R.id.tv_title;
                                                        TextView textView2 = (TextView) view2.findViewById(R.id.tv_title);
                                                        if (textView2 != null) {
                                                            return new MemberPayPrivilegeResultActivityBinding((RelativeLayout) view2, imageView, tbImageView, tbImageView2, roundRelativeLayout, findViewById, relativeLayout, tbImageView3, tbImageView4, imageView2, textView, eMTextView, textView2);
                                                        }
                                                    }
                                                }
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
        return (MemberPayPrivilegeResultActivityBinding) invokeL.objValue;
    }

    @NonNull
    public static MemberPayPrivilegeResultActivityBinding c(@NonNull LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, layoutInflater)) == null) {
            return d(layoutInflater, null, false);
        }
        return (MemberPayPrivilegeResultActivityBinding) invokeL.objValue;
    }

    @NonNull
    public static MemberPayPrivilegeResultActivityBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0609, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (MemberPayPrivilegeResultActivityBinding) invokeLLZ.objValue;
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
