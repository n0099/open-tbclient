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
    private int aBh;
    private boolean aEA;
    private a aEl;
    private int aEq;
    private CommonTabContentView aEy;
    private CommonTabWidgetView aEz;
    private ArrayList<com.baidu.tbadk.editortools.view.a> abO;
    private int apS;
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
        this.aEq = -1;
        this.apS = -1;
        this.Jo = 0;
        this.aBh = d.e.common_color_10255;
        this.aEl = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aEz.reset();
                b.this.aEz.setDatas(b.this.abO);
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
                    b.this.aEz.setVisibility(8);
                }
                if (b.this.aEq >= 0) {
                    b.this.setCurrentTab(b.this.aEq);
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
        this.aEA = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aEl);
        aVar.setEditorTools(this.Jp);
        this.abO.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_host, (ViewGroup) this, true);
        this.aEy = (CommonTabContentView) findViewById(d.h.common_tab_content);
        this.aEz = (CommonTabWidgetView) findViewById(d.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.h.common_progress);
        this.aEz.setOnTabSelectedListener(this);
        this.aEz.setEditorTools(this.Jp);
        setOrientation(1);
        this.apS = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColor(d.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apS) {
            this.apS = skinType;
            onChangeSkinType(this.apS);
        }
        if (i != 8 && i != 4 && !this.aEA) {
            this.aEA = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abO.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aEz.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aEz.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.abO.size()) {
            this.aEy.a(this.abO.get(i));
            this.aEz.setCurrentTab(i);
            this.aEq = i;
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
        aj.e(this, this.aBh, i);
        this.aEz.onChangeSkinType(i);
        this.aEy.onChangeSkinType(i);
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
        if (this.aEz != null) {
            this.aEz.setEditorTools(this.Jp);
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
        this.aBh = i;
    }
}
