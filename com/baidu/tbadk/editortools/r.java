package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.a {
    LinkedList<p> aoP;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<p> linkedList) {
        this.aoP = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e dV(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aoP.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aoP != null) {
            return this.aoP.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eg(4);
        eh(2);
        a(new s(this));
        BG().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void AJ() {
        if (this.aoP != null) {
            this.aoP.clear();
        }
        this.aoP = null;
    }
}
