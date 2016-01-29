package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.view.a {
    LinkedList<r> atc;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<r> linkedList) {
        this.atc = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e ey(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.atc.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.atc != null) {
            return this.atc.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eI(4);
        eJ(2);
        a(new u(this));
        DM().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void CM() {
        if (this.atc != null) {
            this.atc.clear();
        }
        this.atc = null;
    }
}
