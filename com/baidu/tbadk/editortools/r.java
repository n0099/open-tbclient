package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.b {
    LinkedList<p> ayK;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<p> linkedList) {
        this.ayK = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e ez(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.ayK.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.ayK != null) {
            return this.ayK.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eK(4);
        eL(2);
        a(new s(this));
        Dq().c(this);
        a(new t(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void Cw() {
        if (this.ayK != null) {
            this.ayK.clear();
        }
        this.ayK = null;
    }
}
