package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.t;
/* loaded from: classes4.dex */
public class b extends t {
    private d fNX;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.t, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a ro() {
        this.fNX = new d(this.mContext, this.Zo);
        return this.fNX;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.fNX != null) {
            this.fNX.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.fNX != null) {
            this.fNX.onResume();
        }
    }
}
