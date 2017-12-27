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
    private ArrayList<com.baidu.tbadk.editortools.view.a> aQH;
    private i axO;
    private int axP;
    private int bdE;
    private int bpJ;
    private a bsI;
    private int bsN;
    private CommonTabContentView bsV;
    private CommonTabWidgetView bsW;
    private boolean bsX;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void LM();

        void LN();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.aQH = new ArrayList<>();
        this.bsN = -1;
        this.bdE = -1;
        this.axP = 0;
        this.bpJ = d.C0108d.common_color_10255;
        this.bsI = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.bsW.reset();
                b.this.bsW.setDatas(b.this.aQH);
                int size = b.this.aQH.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b LG = ((com.baidu.tbadk.editortools.view.a) b.this.aQH.get(i)).LG();
                    if (LG != null) {
                        z = true;
                        b.this.c(LG);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.bsW.setVisibility(8);
                }
                if (b.this.bsN >= 0) {
                    b.this.setCurrentTab(b.this.bsN);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void LM() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void LN() {
                b.this.hideProgressBar();
            }
        };
        this.bsX = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.bsI);
        aVar.setEditorTools(this.axO);
        this.aQH.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.bsV = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.bsW = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.bsW.setOnTabSelectedListener(this);
        this.bsW.setEditorTools(this.axO);
        setOrientation(1);
        this.bdE = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0108d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bdE) {
            this.bdE = skinType;
            onChangeSkinType(this.bdE);
        }
        if (i != 8 && i != 4 && !this.bsX) {
            this.bsX = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQH.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.bsW.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.bsW.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aQH.size()) {
            this.bsV.a(this.aQH.get(i));
            this.bsW.setCurrentTab(i);
            this.bsN = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void hZ(int i) {
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
        aj.g(this, this.bpJ, i);
        this.bsW.onChangeSkinType(i);
        this.bsV.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQH.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axO = iVar;
        if (this.aQH != null && this.aQH.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQH.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.axO);
            }
        }
        if (this.bsW != null) {
            this.bsW.setEditorTools(this.axO);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axP = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axP;
    }

    public void init() {
    }

    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQH.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bpJ = i;
    }
}
