package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.t;
/* loaded from: classes4.dex */
public class b extends t {
    private d gnn;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.t, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a lM() {
        this.gnn = new d(this.mContext, this.Hv);
        return this.gnn;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.gnn != null) {
            this.gnn.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.gnn != null) {
            this.gnn.onResume();
        }
    }
}
