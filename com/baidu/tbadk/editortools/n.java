package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.a;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.view.a {
    LinkedList<l> bsx;

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<l> linkedList) {
        this.bsx = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e hJ(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.bsx.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.bsx != null) {
            return this.bsx.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        hR(4);
        hS(2);
        a(new a.InterfaceC0106a() { // from class: com.baidu.tbadk.editortools.n.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0106a
            public View getView(int i, View view, ViewGroup viewGroup) {
                e hJ = n.this.hJ(i);
                if (hJ.getLayoutParams() == null) {
                    hJ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return hJ;
            }
        });
        Mg().c(this);
        a(new CommonTabContentView.c() { // from class: com.baidu.tbadk.editortools.n.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
            public void a(View view, int i, long j) {
                if ((view instanceof e) && n.this.axP != null) {
                    n.this.axP.bh(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.bsx != null) {
            this.bsx.clear();
        }
        this.bsx = null;
    }
}
