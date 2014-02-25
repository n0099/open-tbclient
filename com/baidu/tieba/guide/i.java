package com.baidu.tieba.guide;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.util.cj;
/* loaded from: classes.dex */
class i implements cj {
    final /* synthetic */ h a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, String str) {
        this.a = hVar;
        this.b = str;
    }

    @Override // com.baidu.tieba.util.cj
    public boolean a(View view) {
        if (this.b.equals(view.getTag()) && (view instanceof TbImageView)) {
            ((TbImageView) view).invalidate();
            return false;
        }
        return false;
    }
}
