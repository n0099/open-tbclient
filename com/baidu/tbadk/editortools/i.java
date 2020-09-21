package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.a;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.editortools.view.a {
    LinkedList<h> eMT;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.eMT = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher qs(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.eMT.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.eMT != null) {
            return this.eMT.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        qE(2);
        a(new a.InterfaceC0549a() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0549a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher qs = i.this.qs(i);
                if (qs.getLayoutParams() == null) {
                    qs.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return qs;
            }
        });
        btM().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void b(View view, int i, long j) {
                if (view.isEnabled() && (view instanceof DLauncher) && i.this.aaS != null) {
                    i.this.aaS.br(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.eMT != null) {
            this.eMT.clear();
        }
        this.eMT = null;
    }
}
