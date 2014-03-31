package com.baidu.tieba.guide;

import android.view.View;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class i implements bp {
    final /* synthetic */ h a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, String str) {
        this.a = hVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public final boolean a(View view) {
        if (this.b.equals(view.getTag()) && (view instanceof TbImageView)) {
            ((TbImageView) view).invalidate();
            return false;
        }
        return false;
    }
}
