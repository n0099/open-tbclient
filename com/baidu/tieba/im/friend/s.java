package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof v)) {
            TbCheckBox tbCheckBox = ((v) tag).d;
            tbCheckBox.setChecked(!tbCheckBox.b());
        }
    }
}
