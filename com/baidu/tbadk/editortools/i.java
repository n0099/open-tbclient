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
    LinkedList<h> eZa;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.eZa = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher qQ(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.eZa.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.eZa != null) {
            return this.eZa.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        rc(2);
        a(new a.InterfaceC0566a() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0566a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher qQ = i.this.qQ(i);
                if (qQ.getLayoutParams() == null) {
                    qQ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return qQ;
            }
        });
        bww().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void b(View view, int i, long j) {
                if (view.isEnabled() && (view instanceof DLauncher) && i.this.abj != null) {
                    i.this.abj.bv(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.eZa != null) {
            this.eZa.clear();
        }
        this.eZa = null;
    }
}
