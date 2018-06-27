package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MoreDeskView extends CommonTabHost {
    private SparseIntArray aMH;
    private boolean aMI;
    LinkedList<g> aMg;

    public MoreDeskView(Context context) {
        super(context);
        this.aMH = new SparseIntArray();
        this.aMI = true;
        setBackgroundColorId(d.C0142d.cp_bg_line_d);
        setToolId(2);
    }

    public MoreDeskView(Context context, boolean z) {
        super(context);
        this.aMH = new SparseIntArray();
        this.aMI = true;
        setBackgroundColorId(d.C0142d.cp_bg_line_d);
        setToolId(2);
        this.aMI = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<g> linkedList) {
        this.aMg = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.l
    public void init() {
        setShowDelete(false);
        h hVar = new h();
        hVar.j(this.aMg);
        b(hVar);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            HJ();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.aMH.get(aVar.id));
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
        this.aMH.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void HJ() {
        int i = 0;
        for (int i2 = 0; i2 < this.aMH.size(); i2++) {
            i += this.aMH.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.l
    public void oD() {
        super.oD();
    }
}
