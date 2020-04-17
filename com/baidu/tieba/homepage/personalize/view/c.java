package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes9.dex */
public class c extends com.baidu.card.g {
    private e hQX;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        this.hQX = new e(this.mContext, this.afy);
        return this.hQX;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hQX != null) {
            this.hQX.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hQX != null) {
            this.hQX.onResume();
        }
    }
}
