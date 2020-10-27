package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.a;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.editortools.view.a {
    LinkedList<h> fhw;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.fhw = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher rb(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.fhw.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.fhw != null) {
            return this.fhw.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        rn(2);
        a(new a.InterfaceC0580a() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0580a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher rb = i.this.rb(i);
                if (rb.getLayoutParams() == null) {
                    rb.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return rb;
            }
        });
        byp().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void b(View view, int i, long j) {
                if (view.isEnabled() && (view instanceof DLauncher) && i.this.abk != null) {
                    i.this.abk.bw(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.fhw != null) {
            this.fhw.clear();
        }
        this.fhw = null;
    }
}
