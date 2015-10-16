package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.a {
    LinkedList<p> aoK;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<p> linkedList) {
        this.aoK = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e dV(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aoK.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aoK != null) {
            return this.aoK.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        ec(4);
        eb(2);
        a(new s(this));
        BQ().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void AG() {
        if (this.aoK != null) {
            this.aoK.clear();
        }
        this.aoK = null;
    }
}
