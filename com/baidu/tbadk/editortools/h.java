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
    LinkedList<g> dWN;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<g> linkedList) {
        this.dWN = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher mE(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.dWN.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.dWN != null) {
            return this.dWN.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        mM(2);
        a(new a.InterfaceC0442a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0442a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher mE = h.this.mE(i);
                if (mE.getLayoutParams() == null) {
                    mE.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return mE;
            }
        });
        aXV().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void b(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.Zd != null) {
                    h.this.Zd.bf(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.dWN != null) {
            this.dWN.clear();
        }
        this.dWN = null;
    }
}
