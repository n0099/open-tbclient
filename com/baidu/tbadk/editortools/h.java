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
    LinkedList<g> crU;

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(LinkedList<g> linkedList) {
        this.crU = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher kq(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.crU.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.crU != null) {
            return this.crU.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        ky(4);
        kz(2);
        a(new a.InterfaceC0254a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0254a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher kq = h.this.kq(i);
                if (kq.getLayoutParams() == null) {
                    kq.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return kq;
            }
        });
        atf().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void c(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.TU != null) {
                    h.this.TU.bd(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.crU != null) {
            this.crU.clear();
        }
        this.crU = null;
    }
}
