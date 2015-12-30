package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.view.a {
    LinkedList<r> asj;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<r> linkedList) {
        this.asj = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e ed(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.asj.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.asj != null) {
            return this.asj.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eo(4);
        ep(2);
        a(new u(this));
        Cw().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void Bw() {
        if (this.asj != null) {
            this.asj.clear();
        }
        this.asj = null;
    }
}
