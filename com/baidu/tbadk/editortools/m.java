package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.editortools.view.b {
    private SparseIntArray aBS;
    LinkedList<l> aBr;

    public m(Context context) {
        super(context);
        this.aBS = new SparseIntArray();
        setBackgroundColorId(d.e.common_color_10255);
        setToolId(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<l> linkedList) {
        this.aBr = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.s
    public void init() {
        setShowDelete(false);
        n nVar = new n();
        nVar.i(this.aBr);
        b(nVar);
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            Df();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.aBS.get(aVar.id));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        if (aVar.data == null) {
            intValue = 0;
        } else if (aVar.data instanceof String) {
            String str = (String) aVar.data;
            if (TextUtils.isEmpty(str)) {
                intValue = 0;
            } else {
                intValue = TextUtils.isEmpty(str.trim()) ? 1 : com.baidu.adp.lib.g.b.g(str, 1);
            }
        }
        this.aBS.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void Df() {
        int i = 0;
        for (int i2 = 0; i2 < this.aBS.size(); i2++) {
            i += this.aBS.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.s
    public void lK() {
        super.lK();
    }
}
