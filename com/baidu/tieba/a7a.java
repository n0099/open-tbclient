package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes3.dex */
public class a7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, ImageView imageView) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, view2, imageView) == null) && view2 != null && imageView != null) {
            view2.setVisibility(8);
            if (imageView.getTag() != null) {
                objectAnimator = (ObjectAnimator) imageView.getTag();
            } else {
                objectAnimator = null;
            }
            if (objectAnimator != null) {
                objectAnimator.cancel();
                imageView.setTag(null);
                RLog.debug("ObjectAnimatorUtils", "hideDialogLoading->oldRotateAnimator.cancel()");
            }
        }
    }

    public static void b(View view2, ImageView imageView) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, view2, imageView) == null) && view2 != null && imageView != null) {
            if (imageView.getTag() != null) {
                objectAnimator = (ObjectAnimator) imageView.getTag();
            } else {
                objectAnimator = null;
            }
            if (objectAnimator != null) {
                objectAnimator.cancel();
                imageView.setTag(null);
                RLog.debug("ObjectAnimatorUtils", "showDialogLoading->oldRotateAnimator.cancel()");
            }
            view2.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.start();
            imageView.setTag(ofFloat);
        }
    }
}
