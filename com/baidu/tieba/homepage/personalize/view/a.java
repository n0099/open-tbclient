package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes6.dex */
public class a extends g {
    private c gZX;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mK() {
        this.gZX = new c(this.mContext, this.Mf);
        return this.gZX;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.gZX != null) {
            this.gZX.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.gZX != null) {
            this.gZX.onResume();
        }
    }
}
