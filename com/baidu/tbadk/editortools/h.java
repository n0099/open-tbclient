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
    LinkedList<g> cFf;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<g> linkedList) {
        this.cFf = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher jM(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.cFf.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.cFf != null) {
            return this.cFf.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        jU(4);
        jV(2);
        a(new a.InterfaceC0295a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0295a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher jM = h.this.jM(i);
                if (jM.getLayoutParams() == null) {
                    jM.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return jM;
            }
        });
        avd().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void d(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.Dl != null) {
                    h.this.Dl.bd(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.cFf != null) {
            this.cFf.clear();
        }
        this.cFf = null;
    }
}
