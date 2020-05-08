package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes9.dex */
public class c extends com.baidu.card.g {
    private e hRd;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        this.hRd = new e(this.mContext, this.afB);
        return this.hRd;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hRd != null) {
            this.hRd.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hRd != null) {
            this.hRd.onResume();
        }
    }
}
