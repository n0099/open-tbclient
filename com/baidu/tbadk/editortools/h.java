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
    LinkedList<g> aMg;

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(LinkedList<g> linkedList) {
        this.aMg = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher eO(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.aMg.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.aMg != null) {
            return this.aMg.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        eW(4);
        eX(2);
        a(new a.InterfaceC0114a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0114a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher eO = h.this.eO(i);
                if (eO.getLayoutParams() == null) {
                    eO.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return eO;
            }
        });
        ID().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void d(View view, int i, long j) {
                if ((view instanceof DLauncher) && h.this.Qj != null) {
                    h.this.Qj.N(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.aMg != null) {
            this.aMg.clear();
        }
        this.aMg = null;
    }
}
