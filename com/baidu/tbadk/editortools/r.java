package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.b {
    LinkedList<p> aza;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<p> linkedList) {
        this.aza = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eC(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aza.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.aza != null) {
            return this.aza.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eN(4);
        eO(2);
        a(new s(this));
        Es().c(this);
        a(new t(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void Dx() {
        if (this.aza != null) {
            this.aza.clear();
        }
        this.aza = null;
    }
}
