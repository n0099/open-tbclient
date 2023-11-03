package com.baidu.tieba.im.base.core.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.im.base.core.inputtool.utility.GroupChatKeyboardLayout;
import com.baidu.tieba.im.base.core.inputtool.utility.NoSlidingLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class FragmentInputToolBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final GroupChatKeyboardLayout b;
    @NonNull
    public final RelativeLayout c;
    @NonNull
    public final RelativeLayout d;
    @NonNull
    public final GroupChatRobotFloorView e;
    @NonNull
    public final NoSlidingLinearLayout f;
    @NonNull
    public final GroupChatUserReplyView g;
    @NonNull
    public final GroupChatUserReplyView h;

    public FragmentInputToolBinding(@NonNull RelativeLayout relativeLayout, @NonNull GroupChatKeyboardLayout groupChatKeyboardLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull GroupChatRobotFloorView groupChatRobotFloorView, @NonNull NoSlidingLinearLayout noSlidingLinearLayout, @NonNull GroupChatUserReplyView groupChatUserReplyView, @NonNull GroupChatUserReplyView groupChatUserReplyView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relativeLayout, groupChatKeyboardLayout, relativeLayout2, relativeLayout3, groupChatRobotFloorView, noSlidingLinearLayout, groupChatUserReplyView, groupChatUserReplyView2};
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
        this.b = groupChatKeyboardLayout;
        this.c = relativeLayout2;
        this.d = relativeLayout3;
        this.e = groupChatRobotFloorView;
        this.f = noSlidingLinearLayout;
        this.g = groupChatUserReplyView;
        this.h = groupChatUserReplyView2;
    }

    @NonNull
    public static FragmentInputToolBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f0904a5;
            GroupChatKeyboardLayout groupChatKeyboardLayout = (GroupChatKeyboardLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904a5);
            if (groupChatKeyboardLayout != null) {
                i = R.id.obfuscated_res_0x7f091184;
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091184);
                if (relativeLayout != null) {
                    i = R.id.obfuscated_res_0x7f09118c;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09118c);
                    if (relativeLayout2 != null) {
                        i = R.id.obfuscated_res_0x7f091fda;
                        GroupChatRobotFloorView groupChatRobotFloorView = (GroupChatRobotFloorView) view2.findViewById(R.id.obfuscated_res_0x7f091fda);
                        if (groupChatRobotFloorView != null) {
                            i = R.id.obfuscated_res_0x7f0922ae;
                            NoSlidingLinearLayout noSlidingLinearLayout = (NoSlidingLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0922ae);
                            if (noSlidingLinearLayout != null) {
                                i = R.id.obfuscated_res_0x7f0928a0;
                                GroupChatUserReplyView groupChatUserReplyView = (GroupChatUserReplyView) view2.findViewById(R.id.obfuscated_res_0x7f0928a0);
                                if (groupChatUserReplyView != null) {
                                    i = R.id.obfuscated_res_0x7f0928d2;
                                    GroupChatUserReplyView groupChatUserReplyView2 = (GroupChatUserReplyView) view2.findViewById(R.id.obfuscated_res_0x7f0928d2);
                                    if (groupChatUserReplyView2 != null) {
                                        return new FragmentInputToolBinding((RelativeLayout) view2, groupChatKeyboardLayout, relativeLayout, relativeLayout2, groupChatRobotFloorView, noSlidingLinearLayout, groupChatUserReplyView, groupChatUserReplyView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (FragmentInputToolBinding) invokeL.objValue;
    }

    @NonNull
    public static FragmentInputToolBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0340, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FragmentInputToolBinding) invokeLLZ.objValue;
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
