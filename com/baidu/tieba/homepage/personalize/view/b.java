package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.x;
/* loaded from: classes9.dex */
public class b extends x {
    private d hfA;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.x, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        this.hfA = new d(this.mContext, this.MK);
        return this.hfA;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hfA != null) {
            this.hfA.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hfA != null) {
            this.hfA.onResume();
        }
    }
}
