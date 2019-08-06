package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MoreDeskView extends CommonTabHost {
    private SparseIntArray csD;
    private boolean csE;
    LinkedList<g> csb;

    public MoreDeskView(Context context) {
        super(context);
        this.csD = new SparseIntArray();
        this.csE = true;
        setBackgroundColorId(R.color.cp_bg_line_d);
        setToolId(2);
    }

    public MoreDeskView(Context context, boolean z) {
        super(context);
        this.csD = new SparseIntArray();
        this.csE = true;
        setBackgroundColorId(R.color.cp_bg_line_d);
        setToolId(2);
        this.csE = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(LinkedList<g> linkedList) {
        this.csb = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.l
    public void init() {
        setShowDelete(false);
        h hVar = new h();
        hVar.k(this.csb);
        b(hVar);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            asm();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.csD.get(aVar.id));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        if (aVar.data == null) {
            intValue = 0;
        } else if (aVar.data instanceof String) {
            String str = (String) aVar.data;
            if (TextUtils.isEmpty(str)) {
                intValue = 0;
            } else {
                intValue = TextUtils.isEmpty(str.trim()) ? 1 : com.baidu.adp.lib.g.b.f(str, 1);
            }
        }
        this.csD.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void asm() {
        int i = 0;
        for (int i2 = 0; i2 < this.csD.size(); i2++) {
            i += this.csD.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.l
    public void qk() {
        super.qk();
    }
}
