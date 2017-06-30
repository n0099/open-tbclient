package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.b {
    LinkedList<p> azM;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<p> linkedList) {
        this.azM = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eB(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.azM.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.azM != null) {
            return this.azM.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eM(4);
        eN(2);
        a(new s(this));
        DK().c(this);
        a(new t(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void CR() {
        if (this.azM != null) {
            this.azM.clear();
        }
        this.azM = null;
    }
}
