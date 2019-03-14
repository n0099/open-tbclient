package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.e;
/* loaded from: classes4.dex */
public class a extends e {
    private c fNV;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a ro() {
        this.fNV = new c(this.mContext, this.Zp);
        return this.fNV;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.fNV != null) {
            this.fNV.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.fNV != null) {
            this.fNV.onResume();
        }
    }
}
