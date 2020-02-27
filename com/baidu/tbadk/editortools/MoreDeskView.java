package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MoreDeskView extends CommonTabHost {
    LinkedList<g> dwA;
    private SparseIntArray dxa;
    private boolean dxb;

    public MoreDeskView(Context context) {
        super(context);
        this.dxa = new SparseIntArray();
        this.dxb = true;
        setBackgroundColorId(R.color.cp_bg_line_d);
        setToolId(2);
    }

    public MoreDeskView(Context context, boolean z) {
        super(context);
        this.dxa = new SparseIntArray();
        this.dxb = true;
        setBackgroundColorId(R.color.cp_bg_line_d);
        setToolId(2);
        this.dxb = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<g> linkedList) {
        this.dwA = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.m
    public void init() {
        setShowDelete(false);
        h hVar = new h();
        hVar.g(this.dwA);
        b(hVar);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        super.a(aVar);
        if (aVar != null && aVar.code == 2 && aVar.id != 5) {
            c(aVar);
            aOC();
        }
    }

    private void c(a aVar) {
        Integer valueOf = Integer.valueOf(this.dxa.get(aVar.id));
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
        this.dxa.put(aVar.id, intValue >= 0 ? intValue : 0);
    }

    private void aOC() {
        int i = 0;
        for (int i2 = 0; i2 < this.dxa.size(); i2++) {
            i += this.dxa.valueAt(i2);
        }
        if (i > 0) {
            b(new a(2, 2, HanziToPinyin.Token.SEPARATOR));
        } else {
            b(new a(2, 2, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.m
    public void display() {
        super.display();
    }
}
