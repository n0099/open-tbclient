package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.forum.view.FrsSortSwitchButton;
import com.baidu.tieba.forum.widget.ForumTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class FragmentFrsFeedBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final FrameLayout b;
    @NonNull
    public final FrameLayout c;
    @NonNull
    public final FrameLayout d;
    @NonNull
    public final NestedScrollView e;
    @NonNull
    public final LinearLayout f;
    @NonNull
    public final BdRecyclerView g;
    @NonNull
    public final BdSwipeRefreshLayout h;
    @NonNull
    public final RelativeLayout i;
    @NonNull
    public final TextView j;
    @NonNull
    public final FrsSortSwitchButton k;
    @NonNull
    public final ForumTabLayout l;

    public FragmentFrsFeedBinding(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout, @NonNull BdRecyclerView bdRecyclerView, @NonNull BdSwipeRefreshLayout bdSwipeRefreshLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull FrsSortSwitchButton frsSortSwitchButton, @NonNull ForumTabLayout forumTabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {relativeLayout, frameLayout, frameLayout2, frameLayout3, nestedScrollView, linearLayout, bdRecyclerView, bdSwipeRefreshLayout, relativeLayout2, textView, frsSortSwitchButton, forumTabLayout};
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
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = frameLayout3;
        this.e = nestedScrollView;
        this.f = linearLayout;
        this.g = bdRecyclerView;
        this.h = bdSwipeRefreshLayout;
        this.i = relativeLayout2;
        this.j = textView;
        this.k = frsSortSwitchButton;
        this.l = forumTabLayout;
    }

    @NonNull
    public static FragmentFrsFeedBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f090b34;
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b34);
            if (frameLayout != null) {
                i = R.id.obfuscated_res_0x7f090dc9;
                FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dc9);
                if (frameLayout2 != null) {
                    i = R.id.obfuscated_res_0x7f090e0d;
                    FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e0d);
                    if (frameLayout3 != null) {
                        i = R.id.obfuscated_res_0x7f090e0e;
                        NestedScrollView nestedScrollView = (NestedScrollView) view2.findViewById(R.id.obfuscated_res_0x7f090e0e);
                        if (nestedScrollView != null) {
                            i = R.id.obfuscated_res_0x7f090f73;
                            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f73);
                            if (linearLayout != null) {
                                i = R.id.recycler_view;
                                BdRecyclerView bdRecyclerView = (BdRecyclerView) view2.findViewById(R.id.recycler_view);
                                if (bdRecyclerView != null) {
                                    i = R.id.refresh_layout;
                                    BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) view2.findViewById(R.id.refresh_layout);
                                    if (bdSwipeRefreshLayout != null) {
                                        i = R.id.obfuscated_res_0x7f09233b;
                                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09233b);
                                        if (relativeLayout != null) {
                                            i = R.id.obfuscated_res_0x7f09233c;
                                            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09233c);
                                            if (textView != null) {
                                                i = R.id.obfuscated_res_0x7f09233d;
                                                FrsSortSwitchButton frsSortSwitchButton = (FrsSortSwitchButton) view2.findViewById(R.id.obfuscated_res_0x7f09233d);
                                                if (frsSortSwitchButton != null) {
                                                    i = R.id.obfuscated_res_0x7f0923e8;
                                                    ForumTabLayout forumTabLayout = (ForumTabLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923e8);
                                                    if (forumTabLayout != null) {
                                                        return new FragmentFrsFeedBinding((RelativeLayout) view2, frameLayout, frameLayout2, frameLayout3, nestedScrollView, linearLayout, bdRecyclerView, bdSwipeRefreshLayout, relativeLayout, textView, frsSortSwitchButton, forumTabLayout);
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
        return (FragmentFrsFeedBinding) invokeL.objValue;
    }

    @NonNull
    public static FragmentFrsFeedBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0345, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FragmentFrsFeedBinding) invokeLLZ.objValue;
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
