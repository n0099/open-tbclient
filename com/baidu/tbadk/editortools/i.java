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
    LinkedList<h> fDI;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.fDI = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher sw(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.fDI.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.fDI != null) {
            return this.fDI.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setHorizontalSpacing(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
        setPaddingLeft(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        setPaddingRight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        setColumn(4);
        sI(2);
        a(new a.InterfaceC0595a() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0595a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher sw = i.this.sw(i);
                if (sw.getLayoutParams() == null) {
                    sw.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return sw;
            }
        });
        bFZ().c(this);
        a(new CommonTabContentView.b() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.b
            public void c(View view, int i, long j) {
                if (view.isEnabled() && (view instanceof DLauncher) && i.this.acZ != null) {
                    i.this.acZ.bP(view);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.fDI != null) {
            this.fDI.clear();
        }
        this.fDI = null;
    }
}
