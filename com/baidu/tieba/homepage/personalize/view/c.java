package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes16.dex */
public class c extends com.baidu.card.g {
    private f iQK;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a tC() {
        this.iQK = new f(this.mContext, this.ahH);
        this.iQK.setStageType("2001");
        return this.iQK;
    }

    @Override // com.baidu.card.as
    public void onPause() {
        super.onPause();
        if (this.iQK != null) {
            this.iQK.onPause();
        }
    }

    @Override // com.baidu.card.as
    public void onResume() {
        super.onResume();
        if (this.iQK != null) {
            this.iQK.onResume();
        }
    }
}
