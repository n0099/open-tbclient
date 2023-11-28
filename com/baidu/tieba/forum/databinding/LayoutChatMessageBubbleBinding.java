package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
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
public final class LayoutChatMessageBubbleBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final TbImageView b;
    @NonNull
    public final Space c;
    @NonNull
    public final EMTextView d;
    @NonNull
    public final TbImageView e;
    @NonNull
    public final View f;

    public LayoutChatMessageBubbleBinding(@NonNull View view2, @NonNull TbImageView tbImageView, @NonNull Space space, @NonNull EMTextView eMTextView, @NonNull TbImageView tbImageView2, @NonNull View view3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbImageView, space, eMTextView, tbImageView2, view3};
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
        this.c = space;
        this.d = eMTextView;
        this.e = tbImageView2;
        this.f = view3;
    }

    @NonNull
    public static LayoutChatMessageBubbleBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f0902fa;
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902fa);
            if (tbImageView != null) {
                i = R.id.obfuscated_res_0x7f0902ff;
                Space space = (Space) view2.findViewById(R.id.obfuscated_res_0x7f0902ff);
                if (space != null) {
                    i = R.id.obfuscated_res_0x7f090822;
                    EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090822);
                    if (eMTextView != null) {
                        i = R.id.obfuscated_res_0x7f0917bc;
                        TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917bc);
                        if (tbImageView2 != null) {
                            i = R.id.obfuscated_res_0x7f09206d;
                            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09206d);
                            if (findViewById != null) {
                                return new LayoutChatMessageBubbleBinding(view2, tbImageView, space, eMTextView, tbImageView2, findViewById);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (LayoutChatMessageBubbleBinding) invokeL.objValue;
    }

    @NonNull
    public static LayoutChatMessageBubbleBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0543, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (LayoutChatMessageBubbleBinding) invokeLL.objValue;
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
