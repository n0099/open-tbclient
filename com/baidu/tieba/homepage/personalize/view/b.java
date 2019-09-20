package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.t;
/* loaded from: classes4.dex */
public class b extends t {
    private d gnO;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.t, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qH() {
        this.gnO = new d(this.mContext, this.XB);
        return this.gnO;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.gnO != null) {
            this.gnO.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.gnO != null) {
            this.gnO.onResume();
        }
    }
}
