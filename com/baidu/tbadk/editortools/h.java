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
    LinkedList<g> dwO;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<g> linkedList) {
        this.dwO = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher mq(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.dwO.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.dwO != null) {
            return this.dwO.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        my(4);
        mz(2);
        a(new a.InterfaceC0390a() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0390a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher mq = h.this.mq(i);
                if (mq.getLayoutParams() == null) {
                    mq.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return mq;
            }
        });
        aPC().c(this);
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
        if (this.dwO != null) {
            this.dwO.clear();
        }
        this.dwO = null;
    }
}
