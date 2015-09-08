package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tieba.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends com.baidu.tbadk.editortools.view.b {
    private SparseIntArray aqG;
    LinkedList<p> aqj;

    public q(Context context) {
        super(context);
        this.aqG = new SparseIntArray();
        setPadding(context.getResources().getDimensionPixelSize(i.d.ds34), 0, context.getResources().getDimensionPixelSize(i.d.ds34), 0);
        setBackgroundColorId(i.c.pb_editor_tool_view_bg);
        setToolId(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<p> linkedList) {
        this.aqj = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.w
    public void init() {
        setShowDelete(false);
        r rVar = new r();
        rVar.i(this.aqj);
        b(rVar);
    }

    @Override // com.baidu.tbadk.editortools.view.b, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            AS();
        }
    }

    private void c(a aVar) {
        int i;
        Integer valueOf = Integer.valueOf(this.aqG.get(aVar.id));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        if (aVar.data == null) {
            i = intValue - 1;
        } else if (aVar.data instanceof String) {
            String str = (String) aVar.data;
            if (TextUtils.isEmpty(str)) {
                i = intValue - 1;
            } else {
                i = TextUtils.isEmpty(str.trim()) ? 1 : com.baidu.adp.lib.g.b.g(str, 1);
            }
        } else {
            i = intValue;
        }
        this.aqG.put(aVar.id, i >= 0 ? i : 0);
    }

    private void AS() {
        int i = 0;
        for (int i2 = 0; i2 < this.aqG.size(); i2++) {
            i += this.aqG.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }
}
