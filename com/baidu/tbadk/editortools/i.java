package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.a;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class i extends com.baidu.tbadk.editortools.view.a {
    LinkedList<h> eKy;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.eKy = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher qf(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.eKy.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.eKy != null) {
            return this.eKy.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        qn(2);
        a(new a.InterfaceC0553a() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0553a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher qf = i.this.qf(i);
                if (qf.getLayoutParams() == null) {
                    qf.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return qf;
            }
        });
        bsH().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void b(View view, int i, long j) {
                if (view.isEnabled() && (view instanceof DLauncher) && i.this.aay != null) {
                    i.this.aay.bp(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.eKy != null) {
            this.eKy.clear();
        }
        this.eKy = null;
    }
}
