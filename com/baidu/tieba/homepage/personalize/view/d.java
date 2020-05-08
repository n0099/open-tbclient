package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.x;
/* loaded from: classes9.dex */
public class d extends x {
    private f hRe;

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.card.x, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        this.hRe = new f(this.mContext, this.afB);
        return this.hRe;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hRe != null) {
            this.hRe.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hRe != null) {
            this.hRe.onResume();
        }
    }
}
