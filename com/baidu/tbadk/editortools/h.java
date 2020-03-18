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
    LinkedList<g> dxb;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<g> linkedList) {
        this.dxb = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher ms(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.dxb.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.dxb != null) {
            return this.dxb.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        mA(4);
        mB(2);
        a(new a.InterfaceC0390a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0390a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher ms = h.this.ms(i);
                if (ms.getLayoutParams() == null) {
                    ms.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return ms;
            }
        });
        aPG().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void b(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.FO != null) {
                    h.this.FO.be(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.dxb != null) {
            this.dxb.clear();
        }
        this.dxb = null;
    }
}
