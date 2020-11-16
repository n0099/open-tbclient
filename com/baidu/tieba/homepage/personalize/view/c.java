package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.h;
/* loaded from: classes21.dex */
public class c extends h {
    private d jHS;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.h, com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        this.jHS = new d(this.mContext, this.aiB);
        this.jHS.setStageType("2001");
        return this.jHS;
    }

    @Override // com.baidu.card.at
    public void onPause() {
        super.onPause();
        if (this.jHS != null) {
            this.jHS.onPause();
        }
    }

    @Override // com.baidu.card.at
    public void onResume() {
        super.onResume();
        if (this.jHS != null) {
            this.jHS.onResume();
        }
    }
}
