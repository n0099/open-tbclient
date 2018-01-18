package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.editortools.view.b {
    private SparseIntArray bqC;
    private boolean bqD;
    LinkedList<l> bqb;

    public m(Context context) {
        super(context);
        this.bqC = new SparseIntArray();
        this.bqD = true;
        setBackgroundColorId(d.C0107d.cp_bg_line_d);
        setToolId(2);
    }

    public m(Context context, boolean z) {
        super(context);
        this.bqC = new SparseIntArray();
        this.bqD = true;
        setBackgroundColorId(d.C0107d.cp_bg_line_d);
        setToolId(2);
        this.bqD = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<l> linkedList) {
        this.bqb = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.s
    public void init() {
        setShowDelete(false);
        n nVar = new n();
        nVar.j(this.bqb);
        b(nVar);
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            KF();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.bqC.get(aVar.id));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        if (aVar.data == null) {
            intValue = 0;
        } else if (aVar.data instanceof String) {
            String str = (String) aVar.data;
            if (TextUtils.isEmpty(str)) {
                intValue = 0;
            } else {
                intValue = TextUtils.isEmpty(str.trim()) ? 1 : com.baidu.adp.lib.g.b.h(str, 1);
            }
        }
        this.bqC.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void KF() {
        int i = 0;
        for (int i2 = 0; i2 < this.bqC.size(); i2++) {
            i += this.bqC.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.s
    public void th() {
        super.th();
    }
}
