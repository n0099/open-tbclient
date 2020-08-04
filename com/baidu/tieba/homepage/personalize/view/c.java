package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes16.dex */
public class c extends com.baidu.card.g {
    private f iBS;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rR() {
        this.iBS = new f(this.mContext, this.agz);
        return this.iBS;
    }

    @Override // com.baidu.card.ar
    public void onPause() {
        super.onPause();
        if (this.iBS != null) {
            this.iBS.onPause();
        }
    }

    @Override // com.baidu.card.ar
    public void onResume() {
        super.onResume();
        if (this.iBS != null) {
            this.iBS.onResume();
        }
    }
}
