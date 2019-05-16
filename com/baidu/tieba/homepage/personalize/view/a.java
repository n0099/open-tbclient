package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes4.dex */
public class a extends com.baidu.card.e {
    private c geS;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        this.geS = new c(this.mContext, this.Xi);
        return this.geS;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.geS != null) {
            this.geS.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.geS != null) {
            this.geS.onResume();
        }
    }
}
