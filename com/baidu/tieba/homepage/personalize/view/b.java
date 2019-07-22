package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.t;
/* loaded from: classes4.dex */
public class b extends t {
    private d glh;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.t, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qG() {
        this.glh = new d(this.mContext, this.XC);
        return this.glh;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.glh != null) {
            this.glh.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.glh != null) {
            this.glh.onResume();
        }
    }
}
