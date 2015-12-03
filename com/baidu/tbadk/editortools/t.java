package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.view.a {
    LinkedList<r> aqF;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<r> linkedList) {
        this.aqF = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e ej(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aqF.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aqF != null) {
            return this.aqF.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eu(4);
        ev(2);
        a(new u(this));
        CH().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void BH() {
        if (this.aqF != null) {
            this.aqF.clear();
        }
        this.aqF = null;
    }
}
