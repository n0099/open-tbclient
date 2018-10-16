package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MoreDeskView extends CommonTabHost {
    LinkedList<g> aTW;
    private SparseIntArray aUx;
    private boolean aUy;

    public MoreDeskView(Context context) {
        super(context);
        this.aUx = new SparseIntArray();
        this.aUy = true;
        setBackgroundColorId(e.d.cp_bg_line_d);
        setToolId(2);
    }

    public MoreDeskView(Context context, boolean z) {
        super(context);
        this.aUx = new SparseIntArray();
        this.aUy = true;
        setBackgroundColorId(e.d.cp_bg_line_d);
        setToolId(2);
        this.aUy = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<g> linkedList) {
        this.aTW = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.l
    public void init() {
        setShowDelete(false);
        h hVar = new h();
        hVar.j(this.aTW);
        b(hVar);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            KS();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.aUx.get(aVar.id));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        if (aVar.data == null) {
            intValue = 0;
        } else if (aVar.data instanceof String) {
            String str = (String) aVar.data;
            if (TextUtils.isEmpty(str)) {
                intValue = 0;
            } else {
                intValue = TextUtils.isEmpty(str.trim()) ? 1 : com.baidu.adp.lib.g.b.l(str, 1);
            }
        }
        this.aUx.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void KS() {
        int i = 0;
        for (int i2 = 0; i2 < this.aUx.size(); i2++) {
            i += this.aUx.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.l
    public void pQ() {
        super.pQ();
    }
}
