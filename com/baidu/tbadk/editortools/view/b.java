package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends d implements CommonTabWidgetView.a {
    private int Jo;
    private i Jp;
    private int aBe;
    private a aEi;
    private int aEn;
    private CommonTabContentView aEv;
    private CommonTabWidgetView aEw;
    private boolean aEx;
    private ArrayList<com.baidu.tbadk.editortools.view.a> abO;
    private int apQ;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Ed();

        void Ee();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.abO = new ArrayList<>();
        this.aEn = -1;
        this.apQ = -1;
        this.Jo = 0;
        this.aBe = d.e.common_color_10255;
        this.aEi = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aEw.reset();
                b.this.aEw.setDatas(b.this.abO);
                int size = b.this.abO.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b DX = ((com.baidu.tbadk.editortools.view.a) b.this.abO.get(i)).DX();
                    if (DX != null) {
                        z = true;
                        b.this.c(DX);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aEw.setVisibility(8);
                }
                if (b.this.aEn >= 0) {
                    b.this.setCurrentTab(b.this.aEn);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Ed() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Ee() {
                b.this.hideProgressBar();
            }
        };
        this.aEx = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aEi);
        aVar.setEditorTools(this.Jp);
        this.abO.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_host, (ViewGroup) this, true);
        this.aEv = (CommonTabContentView) findViewById(d.h.common_tab_content);
        this.aEw = (CommonTabWidgetView) findViewById(d.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.h.common_progress);
        this.aEw.setOnTabSelectedListener(this);
        this.aEw.setEditorTools(this.Jp);
        setOrientation(1);
        this.apQ = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColor(d.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apQ) {
            this.apQ = skinType;
            onChangeSkinType(this.apQ);
        }
        if (i != 8 && i != 4 && !this.aEx) {
            this.aEx = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abO.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aEw.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aEw.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.abO.size()) {
            this.aEv.a(this.abO.get(i));
            this.aEw.setCurrentTab(i);
            this.aEn = i;
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
        aj.e(this, this.aBe, i);
        this.aEw.onChangeSkinType(i);
        this.aEv.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.abO.iterator();
        while (it.hasNext()) {
            it.next().Dg();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jp = iVar;
        if (this.abO != null && this.abO.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abO.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Jp);
            }
        }
        if (this.aEw != null) {
            this.aEw.setEditorTools(this.Jp);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Jo = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Jo;
    }

    public void init() {
    }

    public void lK() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.abO.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBe = i;
    }
}
