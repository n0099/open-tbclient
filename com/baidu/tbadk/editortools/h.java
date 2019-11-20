package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.a;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.view.a {
    LinkedList<g> cEo;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<g> linkedList) {
        this.cEo = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher jL(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.cEo.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.cEo != null) {
            return this.cEo.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        jT(4);
        jU(2);
        a(new a.InterfaceC0295a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0295a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher jL = h.this.jL(i);
                if (jL.getLayoutParams() == null) {
                    jL.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return jL;
            }
        });
        avb().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void d(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.CJ != null) {
                    h.this.CJ.bd(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.cEo != null) {
            this.cEo.clear();
        }
        this.cEo = null;
    }
}
