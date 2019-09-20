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
    LinkedList<g> csW;

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(LinkedList<g> linkedList) {
        this.csW = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher ku(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.csW.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.csW != null) {
            return this.csW.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        kC(4);
        kD(2);
        a(new a.InterfaceC0263a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0263a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher ku = h.this.ku(i);
                if (ku.getLayoutParams() == null) {
                    ku.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return ku;
            }
        });
        att().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void c(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.TT != null) {
                    h.this.TT.bd(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.csW != null) {
            this.csW.clear();
        }
        this.csW = null;
    }
}
