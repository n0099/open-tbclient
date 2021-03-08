package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes2.dex */
public class b extends g {
    private c koB;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sU() {
        this.koB = new c(this.mContext, this.ahS);
        this.koB.setStageType("2001");
        return this.koB;
    }

    @Override // com.baidu.card.as
    public void onPause() {
        super.onPause();
        if (this.koB != null) {
            this.koB.onPause();
        }
    }

    @Override // com.baidu.card.as
    public void onResume() {
        super.onResume();
        if (this.koB != null) {
            this.koB.onResume();
        }
    }
}
