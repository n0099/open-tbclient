package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.forum.controller.AdVideoController;
import com.baidu.tieba.forum.controller.ForumBackFloatTipController;
import com.baidu.tieba.forum.controller.LinkageController;
import com.baidu.tieba.forum.controller.MainController;
import com.baidu.tieba.forum.controller.NavigationBarController;
import com.baidu.tieba.forum.controller.PushPermissionController;
import com.baidu.tieba.forum.controller.TimeoutController;
import com.baidu.tieba.forum.controller.TopController;
import com.baidu.tieba.forum.controller.VoicePlayController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes5.dex */
public final class ci7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final BdUniqueId a(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if (fragmentActivity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) fragmentActivity).getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeL.objValue;
    }

    public static final AdVideoController b(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        AdVideoController adVideoController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (adVideoController = (AdVideoController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(AdVideoController.class))) != null) {
                return adVideoController;
            }
            throw new IllegalStateException("AdVideoController must not be null!!!");
        }
        return (AdVideoController) invokeL.objValue;
    }

    public static final yh7 c(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        yh7 yh7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (yh7Var = (yh7) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(yh7.class))) != null) {
                return yh7Var;
            }
            throw new IllegalStateException("BottomController must not be null!!!");
        }
        return (yh7) invokeL.objValue;
    }

    public static final di7 d(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        di7 di7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (di7Var = (di7) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(di7.class))) != null) {
                return di7Var;
            }
            throw new IllegalStateException("FrsBottomTipController must not be null!!!");
        }
        return (di7) invokeL.objValue;
    }

    public static final ForumBackFloatTipController e(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        ForumBackFloatTipController forumBackFloatTipController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (forumBackFloatTipController = (ForumBackFloatTipController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(ForumBackFloatTipController.class))) != null) {
                return forumBackFloatTipController;
            }
            throw new IllegalStateException("ForumBackFloatTipController must not be null!!!");
        }
        return (ForumBackFloatTipController) invokeL.objValue;
    }

    public static final zh7 f(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        zh7 zh7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (zh7Var = (zh7) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(zh7.class))) != null) {
                return zh7Var;
            }
            throw new IllegalStateException("ForumDIalogController must not be null!!!");
        }
        return (zh7) invokeL.objValue;
    }

    public static final LinkageController g(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        LinkageController linkageController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (linkageController = (LinkageController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(LinkageController.class))) != null) {
                return linkageController;
            }
            throw new IllegalStateException("LinkageController must not be null!!!");
        }
        return (LinkageController) invokeL.objValue;
    }

    public static final gi7 h(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        gi7 gi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (gi7Var = (gi7) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(gi7.class))) != null) {
                return gi7Var;
            }
            throw new IllegalStateException("LinkageStatisticController must not be null!!!");
        }
        return (gi7) invokeL.objValue;
    }

    public static final MainController i(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        MainController mainController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (mainController = (MainController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(MainController.class))) != null) {
                return mainController;
            }
            throw new IllegalStateException("MainController must not be null!!!");
        }
        return (MainController) invokeL.objValue;
    }

    public static final NavigationBarController j(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        NavigationBarController navigationBarController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (navigationBarController = (NavigationBarController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(NavigationBarController.class))) != null) {
                return navigationBarController;
            }
            throw new IllegalStateException("NavigationBarController must not be null!!!");
        }
        return (NavigationBarController) invokeL.objValue;
    }

    public static final PushPermissionController k(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        PushPermissionController pushPermissionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (pushPermissionController = (PushPermissionController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(PushPermissionController.class))) != null) {
                return pushPermissionController;
            }
            throw new IllegalStateException("PushPermissionController must not be null!!!");
        }
        return (PushPermissionController) invokeL.objValue;
    }

    public static final TimeoutController l(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        TimeoutController timeoutController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (timeoutController = (TimeoutController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(TimeoutController.class))) != null) {
                return timeoutController;
            }
            throw new IllegalStateException("TimeoutController must not be null!!!");
        }
        return (TimeoutController) invokeL.objValue;
    }

    public static final TopController m(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        TopController topController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (topController = (TopController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(TopController.class))) != null) {
                return topController;
            }
            throw new IllegalStateException("TopController must not be null!!!");
        }
        return (TopController) invokeL.objValue;
    }

    public static final VoicePlayController n(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        VoicePlayController voicePlayController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof fi7) && (voicePlayController = (VoicePlayController) ((fi7) fragmentActivity).j2(Reflection.getOrCreateKotlinClass(VoicePlayController.class))) != null) {
                return voicePlayController;
            }
            throw new IllegalStateException("VoicePlayController must not be null!!!");
        }
        return (VoicePlayController) invokeL.objValue;
    }
}
