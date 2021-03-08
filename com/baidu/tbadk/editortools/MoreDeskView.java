package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MoreDeskView extends CommonTabHost {
    LinkedList<h> fCO;
    private SparseIntArray fDp;
    private boolean fDq;

    public MoreDeskView(Context context) {
        super(context);
        this.fDp = new SparseIntArray();
        this.fDq = true;
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
    }

    public MoreDeskView(Context context, boolean z) {
        super(context);
        this.fDp = new SparseIntArray();
        this.fDq = true;
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
        this.fDq = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.fCO = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void init() {
        setShowDelete(false);
        i iVar = new i();
        iVar.g(this.fCO);
        b(iVar);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            bBy();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.fDp.get(aVar.id));
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
        this.fDp.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void bBy() {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i2;
            if (i3 >= this.fDp.size()) {
                break;
            }
            i2 = this.fDp.valueAt(i3) + i;
            i3++;
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
