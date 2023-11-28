package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class CardPicAndTextViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final TbImageView b;
    @NonNull
    public final TextView c;
    @NonNull
    public final EMTextView d;

    public CardPicAndTextViewBinding(@NonNull View view2, @NonNull TbImageView tbImageView, @NonNull TextView textView, @NonNull EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbImageView, textView, eMTextView};
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
        this.c = textView;
        this.d = eMTextView;
    }

    @NonNull
    public static CardPicAndTextViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.image_content;
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.image_content);
            if (tbImageView != null) {
                i = R.id.obfuscated_res_0x7f091169;
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091169);
                if (textView != null) {
                    i = R.id.obfuscated_res_0x7f09186f;
                    EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09186f);
                    if (eMTextView != null) {
                        return new CardPicAndTextViewBinding(view2, tbImageView, textView, eMTextView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (CardPicAndTextViewBinding) invokeL.objValue;
    }

    @NonNull
    public static CardPicAndTextViewBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d01e4, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (CardPicAndTextViewBinding) invokeLL.objValue;
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
