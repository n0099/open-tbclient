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
    LinkedList<l> bqb;

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<l> linkedList) {
        this.bqb = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e hK(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.bqb.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.bqb != null) {
            return this.bqb.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        hT(4);
        hU(2);
        a(new a.InterfaceC0082a() { // from class: com.baidu.tbadk.editortools.n.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0082a
            public View getView(int i, View view, ViewGroup viewGroup) {
                e hK = n.this.hK(i);
                if (hK.getLayoutParams() == null) {
                    hK.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return hK;
            }
        });
        Ly().c(this);
        a(new CommonTabContentView.c() { // from class: com.baidu.tbadk.editortools.n.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
            public void a(View view, int i, long j) {
                if ((view instanceof e) && n.this.axN != null) {
                    n.this.axN.bh(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.bqb != null) {
            this.bqb.clear();
        }
        this.bqb = null;
    }
}
