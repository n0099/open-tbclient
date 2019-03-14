package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MoreDeskView extends CommonTabHost {
    private SparseIntArray ciX;
    private boolean ciY;
    LinkedList<g> civ;

    public MoreDeskView(Context context) {
        super(context);
        this.ciX = new SparseIntArray();
        this.ciY = true;
        setBackgroundColorId(d.C0277d.cp_bg_line_d);
        setToolId(2);
    }

    public MoreDeskView(Context context, boolean z) {
        super(context);
        this.ciX = new SparseIntArray();
        this.ciY = true;
        setBackgroundColorId(d.C0277d.cp_bg_line_d);
        setToolId(2);
        this.ciY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(LinkedList<g> linkedList) {
        this.civ = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.l
    public void init() {
        setShowDelete(false);
        h hVar = new h();
        hVar.k(this.civ);
        b(hVar);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            ame();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.ciX.get(aVar.id));
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
        this.ciX.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void ame() {
        int i = 0;
        for (int i2 = 0; i2 < this.ciX.size(); i2++) {
            i += this.ciX.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.l
    public void qT() {
        super.qT();
    }
}
