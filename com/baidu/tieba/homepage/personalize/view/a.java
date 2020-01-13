package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes7.dex */
public class a extends g {
    private c hdz;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mK() {
        this.hdz = new c(this.mContext, this.Mk);
        return this.hdz;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hdz != null) {
            this.hdz.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hdz != null) {
            this.hdz.onResume();
        }
    }
}
