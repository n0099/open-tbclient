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
    LinkedList<g> cqG;

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(LinkedList<g> linkedList) {
        this.cqG = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher kk(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.cqG.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.cqG != null) {
            return this.cqG.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        ks(4);
        kt(2);
        a(new a.InterfaceC0252a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0252a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher kk = h.this.kk(i);
                if (kk.getLayoutParams() == null) {
                    kk.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return kk;
            }
        });
        arY().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void c(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.TA != null) {
                    h.this.TA.bb(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.cqG != null) {
            this.cqG.clear();
        }
        this.cqG = null;
    }
}
