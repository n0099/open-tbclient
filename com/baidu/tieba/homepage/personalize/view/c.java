package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes9.dex */
public class c extends com.baidu.card.g {
    private e igA;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.am
    protected com.baidu.tieba.play.operableVideoView.a ry() {
        this.igA = new e(this.mContext, this.afX);
        return this.igA;
    }

    @Override // com.baidu.card.am
    public void onPause() {
        super.onPause();
        if (this.igA != null) {
            this.igA.onPause();
        }
    }

    @Override // com.baidu.card.am
    public void onResume() {
        super.onResume();
        if (this.igA != null) {
            this.igA.onResume();
        }
    }
}
