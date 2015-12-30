package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tieba.n;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.editortools.view.b {
    private SparseIntArray asP;
    LinkedList<r> asj;

    public s(Context context) {
        super(context);
        this.asP = new SparseIntArray();
        setPadding(context.getResources().getDimensionPixelSize(n.e.ds34), 0, context.getResources().getDimensionPixelSize(n.e.ds34), 0);
        setBackgroundColorId(n.d.pb_editor_tool_view_bg);
        setToolId(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<r> linkedList) {
        this.asj = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.z
    public void init() {
        setShowDelete(false);
        t tVar = new t();
        tVar.i(this.asj);
        b(tVar);
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            Bv();
        }
    }

    private void c(a aVar) {
        int i;
        Integer valueOf = Integer.valueOf(this.asP.get(aVar.id));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        if (aVar.data == null) {
            i = intValue - 1;
        } else if (aVar.data instanceof String) {
            String str = (String) aVar.data;
            if (TextUtils.isEmpty(str)) {
                i = intValue - 1;
            } else {
                i = TextUtils.isEmpty(str.trim()) ? 1 : com.baidu.adp.lib.h.b.g(str, 1);
            }
        } else {
            i = intValue;
        }
        this.asP.put(aVar.id, i >= 0 ? i : 0);
    }

    private void Bv() {
        int i = 0;
        for (int i2 = 0; i2 < this.asP.size(); i2++) {
            i += this.asP.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }
}
