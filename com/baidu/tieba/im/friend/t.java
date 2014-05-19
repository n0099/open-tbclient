package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof w)) {
            TbCheckBox tbCheckBox = ((w) tag).d;
            tbCheckBox.setChecked(!tbCheckBox.b());
        }
    }
}
