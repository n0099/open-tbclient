package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.a;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.view.a {
    LinkedList<l> aBP;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<l> linkedList) {
        this.aBP = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eQ(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aBP.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aBP != null) {
            return this.aBP.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eZ(4);
        fa(2);
        a(new a.InterfaceC0056a() { // from class: com.baidu.tbadk.editortools.n.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0056a
            public View getView(int i, View view, ViewGroup viewGroup) {
                e eQ = n.this.eQ(i);
                if (eQ.getLayoutParams() == null) {
                    eQ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return eQ;
            }
        });
        Ei().c(this);
        a(new CommonTabContentView.c() { // from class: com.baidu.tbadk.editortools.n.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
            public void a(View view, int i, long j) {
                if ((view instanceof e) && n.this.IT != null) {
                    n.this.IT.L(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.aBP != null) {
            this.aBP.clear();
        }
        this.aBP = null;
    }
}
