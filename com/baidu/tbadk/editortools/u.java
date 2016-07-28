package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.editortools.view.b {
    LinkedList<s> aqY;

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(LinkedList<s> linkedList) {
        this.aqY = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e em(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aqY.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public int getCount() {
        if (this.aqY != null) {
            return this.aqY.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void init(Context context) {
        ex(4);
        ey(2);
        a(new v(this));
        Cy().c(this);
        a(new w(this));
    }

    @Override // com.baidu.tbadk.editortools.view.b
    public void Bz() {
        if (this.aqY != null) {
            this.aqY.clear();
        }
        this.aqY = null;
    }
}
