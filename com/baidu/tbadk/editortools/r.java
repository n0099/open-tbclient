package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.a {
    LinkedList<p> aoy;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<p> linkedList) {
        this.aoy = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e dM(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aoy.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aoy != null) {
            return this.aoy.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        dT(4);
        dS(2);
        a(new s(this));
        BP().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void AG() {
        this.aoy.clear();
        this.aoy = null;
    }
}
