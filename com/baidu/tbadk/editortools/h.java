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
    LinkedList<g> eAa;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<g> linkedList) {
        this.eAa = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher nU(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.eAa.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.eAa != null) {
            return this.eAa.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        oc(2);
        a(new a.InterfaceC0507a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0507a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher nU = h.this.nU(i);
                if (nU.getLayoutParams() == null) {
                    nU.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return nU;
            }
        });
        bjV().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.h.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void b(View view, int i, long j) {
                if (view.isEnabled() && (view instanceof DLauncher) && h.this.ZS != null) {
                    h.this.ZS.bn(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.eAa != null) {
            this.eAa.clear();
        }
        this.eAa = null;
    }
}
