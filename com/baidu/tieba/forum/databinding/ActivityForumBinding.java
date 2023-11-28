package com.baidu.tieba.forum.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.angcyo.tablayout.DslTabLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.forum.view.BottomWebView;
import com.baidu.tieba.forum.view.FrsMultiDeleteBottomView;
import com.baidu.tieba.forum.view.FrsMultiMoveBottomView;
import com.baidu.tieba.forum.widget.TbBottomSheetView;
import com.baidu.tieba.forum.widget.TbLinkageScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ActivityForumBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final Space b;
    @NonNull
    public final FrameLayout c;
    @NonNull
    public final BottomWebView d;
    @NonNull
    public final FrameLayout e;
    @NonNull
    public final View f;
    @NonNull
    public final ImageView g;
    @NonNull
    public final LinearLayout h;
    @NonNull
    public final PublishProgressView i;
    @NonNull
    public final FrameLayout j;
    @NonNull
    public final OvalActionButton k;
    @NonNull
    public final FRSRefreshButton l;
    @NonNull
    public final TbLinkageScrollView m;
    @NonNull
    public final FrsMultiDeleteBottomView n;
    @NonNull
    public final FrsMultiMoveBottomView o;
    @NonNull
    public final NavigationBar p;
    @NonNull
    public final FrameLayout q;
    @NonNull
    public final FrameLayout r;
    @NonNull
    public final DslTabLayout s;
    @NonNull
    public final TbBottomSheetView t;
    @NonNull
    public final CustomViewPager u;

    public ActivityForumBinding(@NonNull FrameLayout frameLayout, @NonNull Space space, @NonNull FrameLayout frameLayout2, @NonNull BottomWebView bottomWebView, @NonNull FrameLayout frameLayout3, @NonNull View view2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull PublishProgressView publishProgressView, @NonNull FrameLayout frameLayout4, @NonNull OvalActionButton ovalActionButton, @NonNull FRSRefreshButton fRSRefreshButton, @NonNull TbLinkageScrollView tbLinkageScrollView, @NonNull FrsMultiDeleteBottomView frsMultiDeleteBottomView, @NonNull FrsMultiMoveBottomView frsMultiMoveBottomView, @NonNull NavigationBar navigationBar, @NonNull FrameLayout frameLayout5, @NonNull FrameLayout frameLayout6, @NonNull DslTabLayout dslTabLayout, @NonNull TbBottomSheetView tbBottomSheetView, @NonNull CustomViewPager customViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout, space, frameLayout2, bottomWebView, frameLayout3, view2, imageView, linearLayout, publishProgressView, frameLayout4, ovalActionButton, fRSRefreshButton, tbLinkageScrollView, frsMultiDeleteBottomView, frsMultiMoveBottomView, navigationBar, frameLayout5, frameLayout6, dslTabLayout, tbBottomSheetView, customViewPager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frameLayout;
        this.b = space;
        this.c = frameLayout2;
        this.d = bottomWebView;
        this.e = frameLayout3;
        this.f = view2;
        this.g = imageView;
        this.h = linearLayout;
        this.i = publishProgressView;
        this.j = frameLayout4;
        this.k = ovalActionButton;
        this.l = fRSRefreshButton;
        this.m = tbLinkageScrollView;
        this.n = frsMultiDeleteBottomView;
        this.o = frsMultiMoveBottomView;
        this.p = navigationBar;
        this.q = frameLayout5;
        this.r = frameLayout6;
        this.s = dslTabLayout;
        this.t = tbBottomSheetView;
        this.u = customViewPager;
    }

    @NonNull
    public static ActivityForumBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f090490;
            Space space = (Space) view2.findViewById(R.id.obfuscated_res_0x7f090490);
            if (space != null) {
                i = R.id.obfuscated_res_0x7f090492;
                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090492);
                if (frameLayout != null) {
                    i = R.id.obfuscated_res_0x7f0904c1;
                    BottomWebView bottomWebView = (BottomWebView) view2.findViewById(R.id.obfuscated_res_0x7f0904c1);
                    if (bottomWebView != null) {
                        i = R.id.obfuscated_res_0x7f090546;
                        FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090546);
                        if (frameLayout2 != null) {
                            i = R.id.obfuscated_res_0x7f090556;
                            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f090556);
                            if (findViewById != null) {
                                i = R.id.obfuscated_res_0x7f090812;
                                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090812);
                                if (imageView != null) {
                                    i = R.id.content_container;
                                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.content_container);
                                    if (linearLayout != null) {
                                        i = R.id.obfuscated_res_0x7f090c62;
                                        PublishProgressView publishProgressView = (PublishProgressView) view2.findViewById(R.id.obfuscated_res_0x7f090c62);
                                        if (publishProgressView != null) {
                                            i = R.id.obfuscated_res_0x7f090cf9;
                                            FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090cf9);
                                            if (frameLayout3 != null) {
                                                i = R.id.obfuscated_res_0x7f090dab;
                                                OvalActionButton ovalActionButton = (OvalActionButton) view2.findViewById(R.id.obfuscated_res_0x7f090dab);
                                                if (ovalActionButton != null) {
                                                    i = R.id.obfuscated_res_0x7f090dc8;
                                                    FRSRefreshButton fRSRefreshButton = (FRSRefreshButton) view2.findViewById(R.id.obfuscated_res_0x7f090dc8);
                                                    if (fRSRefreshButton != null) {
                                                        i = R.id.obfuscated_res_0x7f091605;
                                                        TbLinkageScrollView tbLinkageScrollView = (TbLinkageScrollView) view2.findViewById(R.id.obfuscated_res_0x7f091605);
                                                        if (tbLinkageScrollView != null) {
                                                            i = R.id.obfuscated_res_0x7f091910;
                                                            FrsMultiDeleteBottomView frsMultiDeleteBottomView = (FrsMultiDeleteBottomView) view2.findViewById(R.id.obfuscated_res_0x7f091910);
                                                            if (frsMultiDeleteBottomView != null) {
                                                                i = R.id.obfuscated_res_0x7f091911;
                                                                FrsMultiMoveBottomView frsMultiMoveBottomView = (FrsMultiMoveBottomView) view2.findViewById(R.id.obfuscated_res_0x7f091911);
                                                                if (frsMultiMoveBottomView != null) {
                                                                    i = R.id.obfuscated_res_0x7f0919aa;
                                                                    NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0919aa);
                                                                    if (navigationBar != null) {
                                                                        i = R.id.obfuscated_res_0x7f092072;
                                                                        FrameLayout frameLayout4 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092072);
                                                                        if (frameLayout4 != null) {
                                                                            FrameLayout frameLayout5 = (FrameLayout) view2;
                                                                            i = R.id.obfuscated_res_0x7f09246f;
                                                                            DslTabLayout dslTabLayout = (DslTabLayout) view2.findViewById(R.id.obfuscated_res_0x7f09246f);
                                                                            if (dslTabLayout != null) {
                                                                                i = R.id.obfuscated_res_0x7f092712;
                                                                                TbBottomSheetView tbBottomSheetView = (TbBottomSheetView) view2.findViewById(R.id.obfuscated_res_0x7f092712);
                                                                                if (tbBottomSheetView != null) {
                                                                                    i = R.id.obfuscated_res_0x7f092a61;
                                                                                    CustomViewPager customViewPager = (CustomViewPager) view2.findViewById(R.id.obfuscated_res_0x7f092a61);
                                                                                    if (customViewPager != null) {
                                                                                        return new ActivityForumBinding(frameLayout5, space, frameLayout, bottomWebView, frameLayout2, findViewById, imageView, linearLayout, publishProgressView, frameLayout3, ovalActionButton, fRSRefreshButton, tbLinkageScrollView, frsMultiDeleteBottomView, frsMultiMoveBottomView, navigationBar, frameLayout4, frameLayout5, dslTabLayout, tbBottomSheetView, customViewPager);
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
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (ActivityForumBinding) invokeL.objValue;
    }

    @NonNull
    public static ActivityForumBinding c(@NonNull LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, layoutInflater)) == null) {
            return d(layoutInflater, null, false);
        }
        return (ActivityForumBinding) invokeL.objValue;
    }

    @NonNull
    public static ActivityForumBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d003a, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (ActivityForumBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (FrameLayout) invokeV.objValue;
    }
}
