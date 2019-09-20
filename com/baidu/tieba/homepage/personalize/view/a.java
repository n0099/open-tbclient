package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes4.dex */
public class a extends com.baidu.card.e {
    private c gnN;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qH() {
        this.gnN = new c(this.mContext, this.XB);
        return this.gnN;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.gnN != null) {
            this.gnN.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.gnN != null) {
            this.gnN.onResume();
        }
    }
}
