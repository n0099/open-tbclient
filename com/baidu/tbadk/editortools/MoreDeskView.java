package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MoreDeskView extends CommonTabHost {
    private SparseIntArray fmZ;
    LinkedList<h> fmy;
    private boolean fna;

    public MoreDeskView(Context context) {
        super(context);
        this.fmZ = new SparseIntArray();
        this.fna = true;
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
    }

    public MoreDeskView(Context context, boolean z) {
        super(context);
        this.fmZ = new SparseIntArray();
        this.fna = true;
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
        this.fna = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.fmy = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void init() {
        setShowDelete(false);
        i iVar = new i();
        iVar.g(this.fmy);
        b(iVar);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            bzb();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.fmZ.get(aVar.id));
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        if (aVar.data == null) {
            intValue = 0;
        } else if (aVar.data instanceof String) {
            String str = (String) aVar.data;
            if (TextUtils.isEmpty(str)) {
                intValue = 0;
            } else {
                intValue = TextUtils.isEmpty(str.trim()) ? 1 : com.baidu.adp.lib.f.b.toInt(str, 1);
            }
        }
        this.fmZ.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void bzb() {
        int i = 0;
        for (int i2 = 0; i2 < this.fmZ.size(); i2++) {
            i += this.fmZ.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, " "));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void display() {
        super.display();
    }
}
