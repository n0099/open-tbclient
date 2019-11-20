package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes4.dex */
public class a extends com.baidu.card.e {
    private c gmv;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a lM() {
        this.gmv = new c(this.mContext, this.GV);
        return this.gmv;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.gmv != null) {
            this.gmv.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.gmv != null) {
            this.gmv.onResume();
        }
    }
}
