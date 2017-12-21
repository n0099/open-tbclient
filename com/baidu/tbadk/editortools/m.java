package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.editortools.view.b {
    LinkedList<l> aBX;
    private SparseIntArray aCy;
    private boolean aCz;

    public m(Context context) {
        super(context);
        this.aCy = new SparseIntArray();
        this.aCz = true;
        setBackgroundColorId(d.C0095d.cp_bg_line_d);
        setToolId(2);
    }

    public m(Context context, boolean z) {
        super(context);
        this.aCy = new SparseIntArray();
        this.aCz = true;
        setBackgroundColorId(d.C0095d.cp_bg_line_d);
        setToolId(2);
        this.aCz = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<l> linkedList) {
        this.aBX = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.s
    public void init() {
        setShowDelete(false);
        n nVar = new n();
        nVar.i(this.aBX);
        b(nVar);
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            Dp();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.aCy.get(aVar.id));
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
        this.aCy.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void Dp() {
        int i = 0;
        for (int i2 = 0; i2 < this.aCy.size(); i2++) {
            i += this.aCy.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.s
    public void lE() {
        super.lE();
    }
}
