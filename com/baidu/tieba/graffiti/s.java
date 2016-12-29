package com.baidu.tieba.graffiti;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s {
    public static void a(Context context, ImageView imageView, int i, com.baidu.adp.lib.h.d dVar) {
        if (imageView != null && context != null) {
            ar.c(imageView, i);
            imageView.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, r.a.graffiti_animation_scale_up);
            if (dVar != null) {
                loadAnimation.setAnimationListener(dVar);
            } else {
                loadAnimation.setAnimationListener(new t(imageView));
            }
            imageView.startAnimation(loadAnimation);
        }
    }

    public static void a(Context context, ImageView imageView, int i) {
        a(context, imageView, i, null);
    }

    public static void ags() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}
