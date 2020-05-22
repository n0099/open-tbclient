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
    LinkedList<g> ekW;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<g> linkedList) {
        this.ekW = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher ng(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.ekW.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.ekW != null) {
            return this.ekW.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        no(2);
        a(new a.InterfaceC0489a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0489a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher ng = h.this.ng(i);
                if (ng.getLayoutParams() == null) {
                    ng.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return ng;
            }
        });
        bee().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void b(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.Zt != null) {
                    h.this.Zt.bg(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.ekW != null) {
            this.ekW.clear();
        }
        this.ekW = null;
    }
}
