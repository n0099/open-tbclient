package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.editortools.view.b {
    LinkedList<s> auD;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<s> linkedList) {
        this.auD = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eC(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.auD.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.auD != null) {
            return this.auD.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eN(4);
        eO(2);
        a(new v(this));
        DY().c(this);
        a(new w(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void Dc() {
        if (this.auD != null) {
            this.auD.clear();
        }
        this.auD = null;
    }
}
