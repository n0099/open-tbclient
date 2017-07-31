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
    LinkedList<l> aCd;

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(LinkedList<l> linkedList) {
        this.aCd = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e eF(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (e) this.aCd.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aCd != null) {
            return this.aCd.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eQ(4);
        eR(2);
        a(new a.InterfaceC0055a() { // from class: com.baidu.tbadk.editortools.n.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0055a
            public View getView(int i, View view, ViewGroup viewGroup) {
                e eF = n.this.eF(i);
                if (eF.getLayoutParams() == null) {
                    eF.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return eF;
            }
        });
        Ee().c(this);
        a(new CommonTabContentView.c() { // from class: com.baidu.tbadk.editortools.n.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
            public void a(View view, int i, long j) {
                if ((view instanceof e) && n.this.Lr != null) {
                    n.this.Lr.F(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void Dl() {
        if (this.aCd != null) {
            this.aCd.clear();
        }
        this.aCd = null;
    }
}
