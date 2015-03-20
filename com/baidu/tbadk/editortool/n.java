package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    private final int Tc;
    final /* synthetic */ EmotionTabHorizonScrollView aiJ;

    private n(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
        this.aiJ = emotionTabHorizonScrollView;
        this.Tc = i;
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
            tbImageView = this.aiJ.aiH;
            if (tbImageView5 != tbImageView) {
                ((TbImageView) view).setForegroundColor(ba.getColor(com.baidu.tieba.s.transparent));
                tbImageView2 = this.aiJ.aiH;
                if (tbImageView2 != null) {
                    z = this.aiJ.aiI;
                    if (!z) {
                        tbImageView4 = this.aiJ.aiH;
                        tbImageView4.setForegroundColor(ba.getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color));
                    } else {
                        tbImageView3 = this.aiJ.aiH;
                        tbImageView3.setForegroundColor(this.aiJ.getResources().getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color));
                    }
                }
                this.aiJ.aiH = (TbImageView) view;
            }
        }
        this.aiJ.setCurrentTab(this.Tc);
        sVar = this.aiJ.aiy;
        sVar.dr(this.Tc);
    }
}
