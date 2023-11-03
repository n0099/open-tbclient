package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class FrsCopyLinkDialogViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final LinearLayout b;
    @NonNull
    public final TextView c;
    @NonNull
    public final TextView d;
    @NonNull
    public final ImageView e;
    @NonNull
    public final TextView f;

    public FrsCopyLinkDialogViewBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayout, linearLayout2, textView, textView2, imageView, textView3};
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
        this.b = linearLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = imageView;
        this.f = textView3;
    }

    @NonNull
    public static FrsCopyLinkDialogViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            LinearLayout linearLayout = (LinearLayout) view2;
            int i = R.id.obfuscated_res_0x7f090cc9;
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090cc9);
            if (textView != null) {
                i = R.id.obfuscated_res_0x7f090cca;
                TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090cca);
                if (textView2 != null) {
                    i = R.id.obfuscated_res_0x7f090ccb;
                    ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ccb);
                    if (imageView != null) {
                        i = R.id.obfuscated_res_0x7f090ccc;
                        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ccc);
                        if (textView3 != null) {
                            return new FrsCopyLinkDialogViewBinding(linearLayout, linearLayout, textView, textView2, imageView, textView3);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (FrsCopyLinkDialogViewBinding) invokeL.objValue;
    }

    @NonNull
    public static FrsCopyLinkDialogViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0369, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FrsCopyLinkDialogViewBinding) invokeLLZ.objValue;
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
