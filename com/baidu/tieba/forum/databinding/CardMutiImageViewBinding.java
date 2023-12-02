package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class CardMutiImageViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final TbImageView b;
    @NonNull
    public final TbImageView c;
    @NonNull
    public final TbImageView d;
    @NonNull
    public final TextView e;

    public CardMutiImageViewBinding(@NonNull View view2, @NonNull TbImageView tbImageView, @NonNull TbImageView tbImageView2, @NonNull TbImageView tbImageView3, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbImageView, tbImageView2, tbImageView3, textView};
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
        this.b = tbImageView;
        this.c = tbImageView2;
        this.d = tbImageView3;
        this.e = textView;
    }

    @NonNull
    public static CardMutiImageViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f091113;
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091113);
            if (tbImageView != null) {
                i = R.id.obfuscated_res_0x7f091121;
                TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091121);
                if (tbImageView2 != null) {
                    i = R.id.obfuscated_res_0x7f091123;
                    TbImageView tbImageView3 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091123);
                    if (tbImageView3 != null) {
                        i = R.id.obfuscated_res_0x7f09116a;
                        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09116a);
                        if (textView != null) {
                            return new CardMutiImageViewBinding(view2, tbImageView, tbImageView2, tbImageView3, textView);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (CardMutiImageViewBinding) invokeL.objValue;
    }

    @NonNull
    public static CardMutiImageViewBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d01dc, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (CardMutiImageViewBinding) invokeLL.objValue;
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
