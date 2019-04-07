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
    LinkedList<g> cix;

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(LinkedList<g> linkedList) {
        this.cix = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher jw(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.cix.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.cix != null) {
            return this.cix.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        jE(4);
        jF(2);
        a(new a.InterfaceC0237a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0237a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher jw = h.this.jw(i);
                if (jw.getLayoutParams() == null) {
                    jw.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return jw;
            }
        });
        amV().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void c(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.VN != null) {
                    h.this.VN.aV(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.cix != null) {
            this.cix.clear();
        }
        this.cix = null;
    }
}
