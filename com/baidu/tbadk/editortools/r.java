package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.a {
    LinkedList<p> aoJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<p> linkedList) {
        this.aoJ = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e dV(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aoJ.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aoJ != null) {
            return this.aoJ.size();
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
        if (this.aoJ != null) {
            this.aoJ.clear();
        }
        this.aoJ = null;
    }
}
