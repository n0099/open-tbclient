package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    private final int TN;
    final /* synthetic */ EmotionTabHorizonScrollView ajQ;

    private n(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
        this.ajQ = emotionTabHorizonScrollView;
        this.TN = i;
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
            tbImageView = this.ajQ.ajO;
            if (tbImageView5 != tbImageView) {
                ((TbImageView) view).setForegroundColor(ay.getColor(com.baidu.tieba.n.transparent));
                tbImageView2 = this.ajQ.ajO;
                if (tbImageView2 != null) {
                    z = this.ajQ.ajP;
                    if (!z) {
                        tbImageView4 = this.ajQ.ajO;
                        tbImageView4.setForegroundColor(ay.getColor(com.baidu.tieba.n.emotion_tab_widget_foreground_color));
                    } else {
                        tbImageView3 = this.ajQ.ajO;
                        tbImageView3.setForegroundColor(this.ajQ.getResources().getColor(com.baidu.tieba.n.emotion_tab_widget_foreground_color));
                    }
                }
                this.ajQ.ajO = (TbImageView) view;
            }
        }
        this.ajQ.setCurrentTab(this.TN);
        sVar = this.ajQ.ajF;
        sVar.dA(this.TN);
    }
}
