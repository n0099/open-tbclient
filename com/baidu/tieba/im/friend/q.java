package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.tieba.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof r)) {
            TbCheckBox tbCheckBox = ((r) tag).d;
            tbCheckBox.setChecked(!tbCheckBox.b());
        }
    }
}
