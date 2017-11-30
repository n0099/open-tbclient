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
    private i IT;
    private int IU;
    private int aBG;
    private a aEI;
    private int aEN;
    private CommonTabContentView aEV;
    private CommonTabWidgetView aEW;
    private boolean aEX;
    private ArrayList<com.baidu.tbadk.editortools.view.a> acx;
    private int apA;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Ek();

        void El();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.acx = new ArrayList<>();
        this.aEN = -1;
        this.apA = -1;
        this.IU = 0;
        this.aBG = d.C0082d.common_color_10255;
        this.aEI = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aEW.reset();
                b.this.aEW.setDatas(b.this.acx);
                int size = b.this.acx.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Ee = ((com.baidu.tbadk.editortools.view.a) b.this.acx.get(i)).Ee();
                    if (Ee != null) {
                        z = true;
                        b.this.c(Ee);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aEW.setVisibility(8);
                }
                if (b.this.aEN >= 0) {
                    b.this.setCurrentTab(b.this.aEN);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Ek() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void El() {
                b.this.hideProgressBar();
            }
        };
        this.aEX = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aEI);
        aVar.setEditorTools(this.IT);
        this.acx.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.aEV = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.aEW = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.aEW.setOnTabSelectedListener(this);
        this.aEW.setEditorTools(this.IT);
        setOrientation(1);
        this.apA = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0082d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apA) {
            this.apA = skinType;
            onChangeSkinType(this.apA);
        }
        if (i != 8 && i != 4 && !this.aEX) {
            this.aEX = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acx.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aEW.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aEW.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.acx.size()) {
            this.aEV.a(this.acx.get(i));
            this.aEW.setCurrentTab(i);
            this.aEN = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void fb(int i) {
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
        aj.e(this, this.aBG, i);
        this.aEW.onChangeSkinType(i);
        this.aEV.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acx.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IT = iVar;
        if (this.acx != null && this.acx.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acx.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.IT);
            }
        }
        if (this.aEW != null) {
            this.aEW.setEditorTools(this.IT);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IU = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IU;
    }

    public void init() {
    }

    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acx.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBG = i;
    }
}
