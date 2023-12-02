package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class TopCardItemViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final AgreeView b;
    @NonNull
    public final AutoDegradeTagView c;
    @NonNull
    public final ImageView d;
    @NonNull
    public final EMTextView e;
    @NonNull
    public final View f;
    @NonNull
    public final LinearLayout g;
    @NonNull
    public final TextView h;
    @NonNull
    public final TextView i;
    @NonNull
    public final RelativeLayout j;
    @NonNull
    public final RelativeLayout k;
    @NonNull
    public final HeadImageView l;

    public TopCardItemViewBinding(@NonNull View view2, @NonNull AgreeView agreeView, @NonNull AutoDegradeTagView autoDegradeTagView, @NonNull ImageView imageView, @NonNull EMTextView eMTextView, @NonNull View view3, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull HeadImageView headImageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {view2, agreeView, autoDegradeTagView, imageView, eMTextView, view3, linearLayout, textView, textView2, relativeLayout, relativeLayout2, headImageView};
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
        this.b = agreeView;
        this.c = autoDegradeTagView;
        this.d = imageView;
        this.e = eMTextView;
        this.f = view3;
        this.g = linearLayout;
        this.h = textView;
        this.i = textView2;
        this.j = relativeLayout;
        this.k = relativeLayout2;
        this.l = headImageView;
    }

    @NonNull
    public static TopCardItemViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.agree_and_disagreeview;
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.agree_and_disagreeview);
            if (agreeView != null) {
                i = R.id.obfuscated_res_0x7f090338;
                AutoDegradeTagView autoDegradeTagView = (AutoDegradeTagView) view2.findViewById(R.id.obfuscated_res_0x7f090338);
                if (autoDegradeTagView != null) {
                    i = R.id.comment_icon;
                    ImageView imageView = (ImageView) view2.findViewById(R.id.comment_icon);
                    if (imageView != null) {
                        i = R.id.comment_num;
                        EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.comment_num);
                        if (eMTextView != null) {
                            i = R.id.obfuscated_res_0x7f092367;
                            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092367);
                            if (findViewById != null) {
                                i = R.id.obfuscated_res_0x7f09273a;
                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09273a);
                                if (linearLayout != null) {
                                    i = R.id.obfuscated_res_0x7f09273b;
                                    TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09273b);
                                    if (textView != null) {
                                        i = R.id.obfuscated_res_0x7f09273d;
                                        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09273d);
                                        if (textView2 != null) {
                                            i = R.id.obfuscated_res_0x7f09273e;
                                            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09273e);
                                            if (relativeLayout != null) {
                                                i = R.id.obfuscated_res_0x7f09273f;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09273f);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.user_avatar;
                                                    HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.user_avatar);
                                                    if (headImageView != null) {
                                                        return new TopCardItemViewBinding(view2, agreeView, autoDegradeTagView, imageView, eMTextView, findViewById, linearLayout, textView, textView2, relativeLayout, relativeLayout2, headImageView);
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
        return (TopCardItemViewBinding) invokeL.objValue;
    }

    @NonNull
    public static TopCardItemViewBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09d8, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (TopCardItemViewBinding) invokeLL.objValue;
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
