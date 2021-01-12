package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.editortools.view.a {
    LinkedList<h> fza;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.fza = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher qQ(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.fza.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.fza != null) {
            return this.fza.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setHorizontalSpacing(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
        setPaddingLeft(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        setPaddingRight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        setColumn(4);
        rc(2);
        a(new a.InterfaceC0578a() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0578a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher qQ = i.this.qQ(i);
                if (qQ.getLayoutParams() == null) {
                    qQ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return qQ;
            }
        });
        bCh().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void c(View view, int i, long j) {
                if (view.isEnabled() && (view instanceof DLauncher) && i.this.acX != null) {
                    i.this.acX.bP(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.fza != null) {
            this.fza.clear();
        }
        this.fza = null;
    }
}
