package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.x;
/* loaded from: classes7.dex */
public class b extends x {
    private d hdA;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.x, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mK() {
        this.hdA = new d(this.mContext, this.Mk);
        return this.hdA;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hdA != null) {
            this.hdA.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hdA != null) {
            this.hdA.onResume();
        }
    }
}
