package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.b {
    LinkedList<p> atn;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<p> linkedList) {
        this.atn = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eE(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.atn.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.atn != null) {
            return this.atn.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eP(4);
        eQ(2);
        a(new s(this));
        DB().c(this);
        a(new t(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void CG() {
        if (this.atn != null) {
            this.atn.clear();
        }
        this.atn = null;
    }
}
