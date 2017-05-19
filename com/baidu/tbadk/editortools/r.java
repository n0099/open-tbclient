package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.b {
    LinkedList<p> ayY;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<p> linkedList) {
        this.ayY = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e ey(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.ayY.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.ayY != null) {
            return this.ayY.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        eJ(4);
        eK(2);
        a(new s(this));
        Dw().c(this);
        a(new t(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void CC() {
        if (this.ayY != null) {
            this.ayY.clear();
        }
        this.ayY = null;
    }
}
