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
    LinkedList<g> aLk;

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<g> linkedList) {
        this.aLk = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher eN(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.aLk.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aLk != null) {
            return this.aLk.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eV(4);
        eW(2);
        a(new a.InterfaceC0113a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0113a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher eN = h.this.eN(i);
                if (eN.getLayoutParams() == null) {
                    eN.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return eN;
            }
        });
        Il().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void d(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.Qh != null) {
                    h.this.Qh.M(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.aLk != null) {
            this.aLk.clear();
        }
        this.aLk = null;
    }
}
