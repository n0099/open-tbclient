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
    LinkedList<l> aAM;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<l> linkedList) {
        this.aAM = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eD(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aAM.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aAM != null) {
            return this.aAM.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eO(4);
        eP(2);
        a(new a.InterfaceC0055a() { // from class: com.baidu.tbadk.editortools.n.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0055a
            public View getView(int i, View view, ViewGroup viewGroup) {
                e eD = n.this.eD(i);
                if (eD.getLayoutParams() == null) {
                    eD.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return eD;
            }
        });
        DW().c(this);
        a(new CommonTabContentView.c() { // from class: com.baidu.tbadk.editortools.n.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
            public void a(View view, int i, long j) {
                if ((view instanceof e) && n.this.JT != null) {
                    n.this.JT.F(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void Dd() {
        if (this.aAM != null) {
            this.aAM.clear();
        }
        this.aAM = null;
    }
}
