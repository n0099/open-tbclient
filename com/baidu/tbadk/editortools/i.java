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
    LinkedList<h> fnq;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.fnq = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher rl(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.fnq.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.fnq != null) {
            return this.fnq.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        rx(2);
        a(new a.InterfaceC0592a() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0592a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher rl = i.this.rl(i);
                if (rl.getLayoutParams() == null) {
                    rl.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return rl;
            }
        });
        bAO().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void c(View view, int i, long j) {
                if (view.isEnabled() && (view instanceof DLauncher) && i.this.abk != null) {
                    i.this.abk.bA(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.fnq != null) {
            this.fnq.clear();
        }
        this.fnq = null;
    }
}
