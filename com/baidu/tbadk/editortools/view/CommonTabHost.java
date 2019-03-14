package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools VN;
    private int VO;
    private ArrayList<com.baidu.tbadk.editortools.view.a> aFI;
    private boolean aIb;
    private int bUK;
    private int biS;
    private int cim;
    private CommonTabContentView clA;
    private CommonTabWidgetView clB;
    private a clp;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void ana();

        void anb();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.aFI = new ArrayList<>();
        this.biS = -1;
        this.bUK = -1;
        this.VO = 0;
        this.cim = d.C0277d.common_color_10255;
        this.clp = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.clB.reset();
                CommonTabHost.this.clB.setDatas(CommonTabHost.this.aFI);
                int size = CommonTabHost.this.aFI.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b amU = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aFI.get(i)).amU();
                    if (amU != null) {
                        z = true;
                        CommonTabHost.this.c(amU);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.clB.setVisibility(8);
                }
                if (CommonTabHost.this.biS >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.biS);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void ana() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void anb() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aIb = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFI = new ArrayList<>();
        this.biS = -1;
        this.bUK = -1;
        this.VO = 0;
        this.cim = d.C0277d.common_color_10255;
        this.clp = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.clB.reset();
                CommonTabHost.this.clB.setDatas(CommonTabHost.this.aFI);
                int size = CommonTabHost.this.aFI.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b amU = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aFI.get(i)).amU();
                    if (amU != null) {
                        z = true;
                        CommonTabHost.this.c(amU);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.clB.setVisibility(8);
                }
                if (CommonTabHost.this.biS >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.biS);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void ana() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void anb() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aIb = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.clp);
        aVar.setEditorTools(this.VN);
        this.aFI.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.clA = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.clB = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.clB.setOnTabSelectedListener(this);
        this.clB.setEditorTools(this.VN);
        setOrientation(1);
        this.bUK = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0277d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bUK) {
            this.bUK = skinType;
            onChangeSkinType(this.bUK);
        }
        if (i != 8 && i != 4 && !this.aIb) {
            this.aIb = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFI.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.clB.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.clB.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aFI.size()) {
            this.clA.a(this.aFI.get(i));
            this.clB.setCurrentTab(i);
            this.biS = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void jH(int i) {
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

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.f(this, this.cim, i);
        this.clB.onChangeSkinType(i);
        this.clA.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFI.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
        if (this.aFI != null && this.aFI.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFI.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.VN);
            }
        }
        if (this.clB != null) {
            this.clB.setEditorTools(this.VN);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    public void init() {
    }

    public void qT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFI.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cim = i;
    }
}
