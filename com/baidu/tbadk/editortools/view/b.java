package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends d implements CommonTabWidgetView.a {
    private int Lq;
    private i Lr;
    private int aBT;
    private a aES;
    private int aEX;
    private CommonTabContentView aFf;
    private CommonTabWidgetView aFg;
    private boolean aFh;
    private ArrayList<com.baidu.tbadk.editortools.view.a> acF;
    private int aql;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Eg();

        void Eh();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.acF = new ArrayList<>();
        this.aEX = -1;
        this.aql = -1;
        this.Lq = 0;
        this.aBT = d.e.common_color_10255;
        this.aES = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aFg.reset();
                b.this.aFg.setDatas(b.this.acF);
                int size = b.this.acF.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Ea = ((com.baidu.tbadk.editortools.view.a) b.this.acF.get(i)).Ea();
                    if (Ea != null) {
                        z = true;
                        b.this.c(Ea);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aFg.setVisibility(8);
                }
                if (b.this.aEX >= 0) {
                    b.this.setCurrentTab(b.this.aEX);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Eg() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Eh() {
                b.this.hideProgressBar();
            }
        };
        this.aFh = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aES);
        aVar.setEditorTools(this.Lr);
        this.acF.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_host, (ViewGroup) this, true);
        this.aFf = (CommonTabContentView) findViewById(d.h.common_tab_content);
        this.aFg = (CommonTabWidgetView) findViewById(d.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.h.common_progress);
        this.aFg.setOnTabSelectedListener(this);
        this.aFg.setEditorTools(this.Lr);
        setOrientation(1);
        this.aql = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColor(d.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aql) {
            this.aql = skinType;
            onChangeSkinType(this.aql);
        }
        if (i != 8 && i != 4 && !this.aFh) {
            this.aFh = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acF.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aFg.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aFg.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.acF.size()) {
            this.aFf.a(this.acF.get(i));
            this.aFg.setCurrentTab(i);
            this.aEX = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eT(int i) {
        setCurrentTab(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        ai.e(this, this.aBT, i);
        this.aFg.onChangeSkinType(i);
        this.aFf.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acF.iterator();
        while (it.hasNext()) {
            it.next().Dl();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lr = iVar;
        if (this.acF != null && this.acF.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acF.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Lr);
            }
        }
        if (this.aFg != null) {
            this.aFg.setEditorTools(this.Lr);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Lq = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Lq;
    }

    public void init() {
    }

    public void lT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acF.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBT = i;
    }
}
