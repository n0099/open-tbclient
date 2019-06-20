package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes4.dex */
public class a extends com.baidu.card.e {
    private c geV;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        this.geV = new c(this.mContext, this.Xh);
        return this.geV;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.geV != null) {
            this.geV.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.geV != null) {
            this.geV.onResume();
        }
    }
}
