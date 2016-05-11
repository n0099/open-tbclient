package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.editortools.view.b {
    LinkedList<s> apt;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<s> linkedList) {
        this.apt = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e ej(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.apt.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.apt != null) {
            return this.apt.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        et(4);
        eu(2);
        a(new v(this));
        Cq().c(this);
        a(new w(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void Bp() {
        if (this.apt != null) {
            this.apt.clear();
        }
        this.apt = null;
    }
}
