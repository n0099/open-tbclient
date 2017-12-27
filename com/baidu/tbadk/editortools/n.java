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
    LinkedList<l> bpS;

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<l> linkedList) {
        this.bpS = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e hO(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.bpS.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.bpS != null) {
            return this.bpS.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        hX(4);
        hY(2);
        a(new a.InterfaceC0083a() { // from class: com.baidu.tbadk.editortools.n.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0083a
            public View getView(int i, View view, ViewGroup viewGroup) {
                e hO = n.this.hO(i);
                if (hO.getLayoutParams() == null) {
                    hO.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return hO;
            }
        });
        LK().c(this);
        a(new CommonTabContentView.c() { // from class: com.baidu.tbadk.editortools.n.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
            public void a(View view, int i, long j) {
                if ((view instanceof e) && n.this.axO != null) {
                    n.this.axO.bf(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.bpS != null) {
            this.bpS.clear();
        }
        this.bpS = null;
    }
}
