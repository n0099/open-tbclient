package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tieba.t;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.editortools.view.b {
    private SparseIntArray atI;
    LinkedList<r> atc;

    public s(Context context) {
        super(context);
        this.atI = new SparseIntArray();
        setPadding(context.getResources().getDimensionPixelSize(t.e.ds34), 0, context.getResources().getDimensionPixelSize(t.e.ds34), 0);
        setBackgroundColorId(t.d.pb_editor_tool_view_bg);
        setToolId(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<r> linkedList) {
        this.atc = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.z
    public void init() {
        setShowDelete(false);
        t tVar = new t();
        tVar.i(this.atc);
        b(tVar);
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            CL();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.atI.get(aVar.id));
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
        this.atI.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void CL() {
        int i = 0;
        for (int i2 = 0; i2 < this.atI.size(); i2++) {
            i += this.atI.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }
}
