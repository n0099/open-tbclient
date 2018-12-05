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
    LinkedList<g> aYj;

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(LinkedList<g> linkedList) {
        this.aYj = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher fL(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.aYj.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aYj != null) {
            return this.aYj.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        fT(4);
        fU(2);
        a(new a.InterfaceC0169a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0169a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher fL = h.this.fL(i);
                if (fL.getLayoutParams() == null) {
                    fL.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return fL;
            }
        });
        Nc().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void a(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.Ta != null) {
                    h.this.Ta.aa(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.aYj != null) {
            this.aYj.clear();
        }
        this.aYj = null;
    }
}
