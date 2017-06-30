package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements Animation.AnimationListener {
    final /* synthetic */ x this$0;
    private final /* synthetic */ View zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(x xVar, View view) {
        this.this$0 = xVar;
        this.zg = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        com.baidu.tieba.homepage.personalize.b.af afVar;
        com.baidu.tieba.homepage.personalize.b.af afVar2;
        List list;
        this.zg.setVisibility(8);
        afVar = this.this$0.cIz;
        if (afVar != null) {
            afVar2 = this.this$0.cIz;
            list = this.this$0.mDataList;
            afVar2.bg(new ArrayList(list));
        }
    }
}
