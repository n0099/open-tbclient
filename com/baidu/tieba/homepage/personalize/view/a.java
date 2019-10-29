package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes4.dex */
public class a extends com.baidu.card.e {
    private c gnm;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a lM() {
        this.gnm = new c(this.mContext, this.Hv);
        return this.gnm;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.gnm != null) {
            this.gnm.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.gnm != null) {
            this.gnm.onResume();
        }
    }
}
