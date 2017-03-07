package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.b {
    LinkedList<p> ayI;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<p> linkedList) {
        this.ayI = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e ez(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.ayI.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.ayI != null) {
            return this.ayI.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eK(4);
        eL(2);
        a(new s(this));
        DU().c(this);
        a(new t(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void CZ() {
        if (this.ayI != null) {
            this.ayI.clear();
        }
        this.ayI = null;
    }
}
