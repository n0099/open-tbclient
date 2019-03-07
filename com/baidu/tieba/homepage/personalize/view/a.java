package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.e;
/* loaded from: classes4.dex */
public class a extends e {
    private c fNW;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a ro() {
        this.fNW = new c(this.mContext, this.Zo);
        return this.fNW;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.fNW != null) {
            this.fNW.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.fNW != null) {
            this.fNW.onResume();
        }
    }
}
