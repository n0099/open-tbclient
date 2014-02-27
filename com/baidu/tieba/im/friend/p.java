package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.tieba.view.TbCheckBox;
/* loaded from: classes.dex */
final class p implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof s)) {
            TbCheckBox tbCheckBox = ((s) tag).d;
            tbCheckBox.setChecked(!tbCheckBox.a());
        }
    }
}
