package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.frs.view.k;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ k cjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.cjV = kVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        List<View> list;
        list = this.cjV.cjU;
        for (View view : list) {
            k.b bVar = (k.b) view.getTag();
            if (bVar != null) {
                int i = bVar.cjX;
            }
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_frs_videolive_last_popup_time", System.currentTimeMillis());
    }
}
