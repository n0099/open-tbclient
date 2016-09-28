package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tieba.r;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.view.c {
    LinkedList<s> atJ;
    private SparseIntArray auq;

    public t(Context context) {
        super(context);
        this.auq = new SparseIntArray();
        setBackgroundColorId(r.d.common_color_10255);
        setToolId(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<s> linkedList) {
        this.atJ = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.c, com.baidu.tbadk.editortools.ab
    public void init() {
        setShowDelete(false);
        u uVar = new u();
        uVar.h(this.atJ);
        b(uVar);
    }

    @Override // com.baidu.tbadk.editortools.view.c, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            CT();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.auq.get(aVar.id));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        if (aVar.data == null) {
            intValue = 0;
        } else if (aVar.data instanceof String) {
            String str = (String) aVar.data;
            if (TextUtils.isEmpty(str)) {
                intValue = 0;
            } else {
                intValue = TextUtils.isEmpty(str.trim()) ? 1 : com.baidu.adp.lib.h.b.g(str, 1);
            }
        }
        this.auq.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void CT() {
        int i = 0;
        for (int i2 = 0; i2 < this.auq.size(); i2++) {
            i += this.auq.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.c, com.baidu.tbadk.editortools.ab
    public void lw() {
        super.lw();
    }
}
