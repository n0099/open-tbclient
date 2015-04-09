package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    private final int Te;
    final /* synthetic */ EmotionTabHorizonScrollView aiR;

    private n(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
        this.aiR = emotionTabHorizonScrollView;
        this.Te = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, n nVar) {
        this(emotionTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        boolean z;
        TbImageView tbImageView3;
        TbImageView tbImageView4;
        if (view instanceof TbImageView) {
            TbImageView tbImageView5 = (TbImageView) view;
            tbImageView = this.aiR.aiP;
            if (tbImageView5 != tbImageView) {
                ((TbImageView) view).setForegroundColor(ba.getColor(com.baidu.tieba.s.transparent));
                tbImageView2 = this.aiR.aiP;
                if (tbImageView2 != null) {
                    z = this.aiR.aiQ;
                    if (!z) {
                        tbImageView4 = this.aiR.aiP;
                        tbImageView4.setForegroundColor(ba.getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color));
                    } else {
                        tbImageView3 = this.aiR.aiP;
                        tbImageView3.setForegroundColor(this.aiR.getResources().getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color));
                    }
                }
                this.aiR.aiP = (TbImageView) view;
            }
        }
        this.aiR.setCurrentTab(this.Te);
        sVar = this.aiR.aiG;
        sVar.dr(this.Te);
    }
}
