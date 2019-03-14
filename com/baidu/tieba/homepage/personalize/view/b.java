package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.t;
/* loaded from: classes4.dex */
public class b extends t {
    private d fNW;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.t, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a ro() {
        this.fNW = new d(this.mContext, this.Zp);
        return this.fNW;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.fNW != null) {
            this.fNW.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.fNW != null) {
            this.fNW.onResume();
        }
    }
}
