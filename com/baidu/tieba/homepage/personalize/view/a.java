package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes9.dex */
public class a extends g {
    private c hfz;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        this.hfz = new c(this.mContext, this.MK);
        return this.hfz;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hfz != null) {
            this.hfz.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hfz != null) {
            this.hfz.onResume();
        }
    }
}
