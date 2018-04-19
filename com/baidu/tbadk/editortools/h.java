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
    LinkedList<g> aCN;

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<g> linkedList) {
        this.aCN = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher eI(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.aCN.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aCN != null) {
            return this.aCN.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eQ(4);
        eR(2);
        a(new a.InterfaceC0096a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0096a
            public View getView(int i, View view2, ViewGroup viewGroup) {
                DLauncher eI = h.this.eI(i);
                if (eI.getLayoutParams() == null) {
                    eI.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return eI;
            }
        });
        EJ().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void d(View view2, int i, long j) {
                if ((view2 instanceof DLauncher) && h.this.JS != null) {
                    h.this.JS.M(view2);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.aCN != null) {
            this.aCN.clear();
        }
        this.aCN = null;
    }
}
