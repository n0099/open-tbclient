package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.editortools.view.b {
    private SparseIntArray bsO;
    private boolean bsP;
    LinkedList<l> bsn;

    public m(Context context) {
        super(context);
        this.bsO = new SparseIntArray();
        this.bsP = true;
        setBackgroundColorId(d.C0141d.cp_bg_line_d);
        setToolId(2);
    }

    public m(Context context, boolean z) {
        super(context);
        this.bsO = new SparseIntArray();
        this.bsP = true;
        setBackgroundColorId(d.C0141d.cp_bg_line_d);
        setToolId(2);
        this.bsP = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<l> linkedList) {
        this.bsn = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.s
    public void init() {
        setShowDelete(false);
        n nVar = new n();
        nVar.j(this.bsn);
        b(nVar);
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            Ln();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.bsO.get(aVar.id));
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
        this.bsO.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void Ln() {
        int i = 0;
        for (int i2 = 0; i2 < this.bsO.size(); i2++) {
            i += this.bsO.valueAt(i2);
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
