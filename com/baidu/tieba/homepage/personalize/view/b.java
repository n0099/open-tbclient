package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.t;
/* loaded from: classes4.dex */
public class b extends t {
    private d geT;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.t, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        this.geT = new d(this.mContext, this.Xi);
        return this.geT;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.geT != null) {
            this.geT.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.geT != null) {
            this.geT.onResume();
        }
    }
}
