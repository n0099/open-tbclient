package com.baidu.tieba.graffiti;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g {
    public static void a(Context context, final ImageView imageView, int i, com.baidu.adp.lib.g.d dVar) {
        if (imageView != null && context != null) {
            ai.c(imageView, i);
            imageView.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, d.a.graffiti_animation_scale_up);
            if (dVar != null) {
                loadAnimation.setAnimationListener(dVar);
            } else {
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tieba.graffiti.g.1
                    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        imageView.setImageResource(0);
                        imageView.setBackgroundResource(0);
                        imageView.setVisibility(8);
                    }
                });
            }
            imageView.startAnimation(loadAnimation);
        }
    }

    public static void a(Context context, ImageView imageView, int i) {
        a(context, imageView, i, null);
    }

    public static void amA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}
