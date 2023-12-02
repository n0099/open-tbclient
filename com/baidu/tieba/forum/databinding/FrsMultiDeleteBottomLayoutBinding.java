package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class FrsMultiDeleteBottomLayoutBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final View b;
    @NonNull
    public final TextView c;
    @NonNull
    public final TextView d;
    @NonNull
    public final RelativeLayout e;
    @NonNull
    public final TextView f;

    public FrsMultiDeleteBottomLayoutBinding(@NonNull View view2, @NonNull View view3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, view3, textView, textView2, relativeLayout, textView3};
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
        this.b = view3;
        this.c = textView;
        this.d = textView2;
        this.e = relativeLayout;
        this.f = textView3;
    }

    @NonNull
    public static FrsMultiDeleteBottomLayoutBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f09096a;
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09096a);
            if (findViewById != null) {
                i = R.id.multi_del_btn;
                TextView textView = (TextView) view2.findViewById(R.id.multi_del_btn);
                if (textView != null) {
                    i = R.id.multi_del_cancel_btn;
                    TextView textView2 = (TextView) view2.findViewById(R.id.multi_del_cancel_btn);
                    if (textView2 != null) {
                        i = R.id.obfuscated_res_0x7f091909;
                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091909);
                        if (relativeLayout != null) {
                            i = R.id.multi_del_forbidden_btn;
                            TextView textView3 = (TextView) view2.findViewById(R.id.multi_del_forbidden_btn);
                            if (textView3 != null) {
                                return new FrsMultiDeleteBottomLayoutBinding(view2, findViewById, textView, textView2, relativeLayout, textView3);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (FrsMultiDeleteBottomLayoutBinding) invokeL.objValue;
    }

    @NonNull
    public static FrsMultiDeleteBottomLayoutBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d03af, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (FrsMultiDeleteBottomLayoutBinding) invokeLL.objValue;
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
