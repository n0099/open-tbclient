package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes4.dex */
public class a extends com.baidu.card.e {
    private c glW;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qG() {
        this.glW = new c(this.mContext, this.XC);
        return this.glW;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.glW != null) {
            this.glW.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.glW != null) {
            this.glW.onResume();
        }
    }
}
