package com.baidu.tieba.guide;

import android.view.View;
import com.baidu.tbadk.core.util.bt;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class j implements bt {
    final /* synthetic */ i a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.a = iVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.bt
    public boolean a(View view) {
        if (this.b.equals(view.getTag()) && (view instanceof TbImageView)) {
            ((TbImageView) view).invalidate();
            return false;
        }
        return false;
    }
}
