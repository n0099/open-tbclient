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
    LinkedList<g> aYm;

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(LinkedList<g> linkedList) {
        this.aYm = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher fM(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.aYm.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aYm != null) {
            return this.aYm.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        fU(4);
        fV(2);
        a(new a.InterfaceC0169a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0169a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher fM = h.this.fM(i);
                if (fM.getLayoutParams() == null) {
                    fM.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return fM;
            }
        });
        Nd().c(this);
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
        if (this.aYm != null) {
            this.aYm.clear();
        }
        this.aYm = null;
    }
}
