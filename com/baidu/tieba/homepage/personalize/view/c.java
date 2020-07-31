package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes16.dex */
public class c extends com.baidu.card.g {
    private f iBQ;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rR() {
        this.iBQ = new f(this.mContext, this.agz);
        return this.iBQ;
    }

    @Override // com.baidu.card.ar
    public void onPause() {
        super.onPause();
        if (this.iBQ != null) {
            this.iBQ.onPause();
        }
    }

    @Override // com.baidu.card.ar
    public void onResume() {
        super.onResume();
        if (this.iBQ != null) {
            this.iBQ.onResume();
        }
    }
}
