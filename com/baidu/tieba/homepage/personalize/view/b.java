package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.x;
/* loaded from: classes9.dex */
public class b extends x {
    private d hfC;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.x, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        this.hfC = new d(this.mContext, this.MK);
        return this.hfC;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hfC != null) {
            this.hfC.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hfC != null) {
            this.hfC.onResume();
        }
    }
}
