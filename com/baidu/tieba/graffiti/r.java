package com.baidu.tieba.graffiti;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class r {
    public static void a(Context context, ImageView imageView, int i, com.baidu.adp.lib.g.d dVar) {
        if (imageView != null && context != null) {
            aq.c(imageView, i);
            imageView.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, w.a.graffiti_animation_scale_up);
            if (dVar != null) {
                loadAnimation.setAnimationListener(dVar);
            } else {
                loadAnimation.setAnimationListener(new s(imageView));
            }
            imageView.startAnimation(loadAnimation);
        }
    }

    public static void a(Context context, ImageView imageView, int i) {
        a(context, imageView, i, null);
    }

    public static void agD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}
