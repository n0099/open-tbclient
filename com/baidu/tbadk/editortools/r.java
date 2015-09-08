package com.baidu.tbadk.editortools;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.view.a {
    LinkedList<p> aqj;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<p> linkedList) {
        this.aqj = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e dU(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aqj.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aqj != null) {
            return this.aqj.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eb(4);
        ea(2);
        a(new s(this));
        Cd().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void AT() {
        this.aqj.clear();
        this.aqj = null;
    }
}
