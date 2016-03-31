package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.editortools.view.b {
    LinkedList<s> atB;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<s> linkedList) {
        this.atB = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eD(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.atB.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.atB != null) {
            return this.atB.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eN(4);
        eO(2);
        a(new v(this));
        Ex().c(this);
        a(new w(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void Dv() {
        if (this.atB != null) {
            this.atB.clear();
        }
        this.atB = null;
    }
}
