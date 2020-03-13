package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes9.dex */
public class a extends g {
    private c hfN;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        this.hfN = new c(this.mContext, this.MK);
        return this.hfN;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hfN != null) {
            this.hfN.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hfN != null) {
            this.hfN.onResume();
        }
    }
}
