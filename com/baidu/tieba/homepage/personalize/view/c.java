package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes9.dex */
public class c extends com.baidu.card.g {
    private e ifN;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.am
    protected com.baidu.tieba.play.operableVideoView.a ry() {
        this.ifN = new e(this.mContext, this.afX);
        return this.ifN;
    }

    @Override // com.baidu.card.am
    public void onPause() {
        super.onPause();
        if (this.ifN != null) {
            this.ifN.onPause();
        }
    }

    @Override // com.baidu.card.am
    public void onResume() {
        super.onResume();
        if (this.ifN != null) {
            this.ifN.onResume();
        }
    }
}
