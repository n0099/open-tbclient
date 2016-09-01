package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.editortools.view.b {
    LinkedList<s> auf;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<s> linkedList) {
        this.auf = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eA(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.auf.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.auf != null) {
            return this.auf.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eL(4);
        eM(2);
        a(new v(this));
        DT().c(this);
        a(new w(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void CU() {
        if (this.auf != null) {
            this.auf.clear();
        }
        this.auf = null;
    }
}
