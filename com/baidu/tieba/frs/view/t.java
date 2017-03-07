package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.frs.view.q;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    final /* synthetic */ q cfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.cfU = qVar;
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
        list = this.cfU.cfT;
        for (View view : list) {
            q.b bVar = (q.b) view.getTag();
            if (bVar != null) {
                int i = bVar.cfW;
            }
        }
        com.baidu.tbadk.core.sharedPref.b.uo().putLong("key_frs_videolive_last_popup_time", System.currentTimeMillis());
    }
}
