package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools Qg;
    private int Qh;
    private int aLX;
    private a aOT;
    private int aOY;
    private CommonTabContentView aPg;
    private CommonTabWidgetView aPh;
    private boolean aPi;
    private ArrayList<com.baidu.tbadk.editortools.view.a> alt;
    private int azI;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void IA();

        void IB();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.alt = new ArrayList<>();
        this.aOY = -1;
        this.azI = -1;
        this.Qh = 0;
        this.aLX = d.C0140d.common_color_10255;
        this.aOT = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aPh.reset();
                CommonTabHost.this.aPh.setDatas(CommonTabHost.this.alt);
                int size = CommonTabHost.this.alt.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Iu = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.alt.get(i)).Iu();
                    if (Iu != null) {
                        z = true;
                        CommonTabHost.this.c(Iu);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aPh.setVisibility(8);
                }
                if (CommonTabHost.this.aOY >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aOY);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void IA() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void IB() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aPi = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alt = new ArrayList<>();
        this.aOY = -1;
        this.azI = -1;
        this.Qh = 0;
        this.aLX = d.C0140d.common_color_10255;
        this.aOT = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aPh.reset();
                CommonTabHost.this.aPh.setDatas(CommonTabHost.this.alt);
                int size = CommonTabHost.this.alt.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Iu = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.alt.get(i)).Iu();
                    if (Iu != null) {
                        z = true;
                        CommonTabHost.this.c(Iu);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aPh.setVisibility(8);
                }
                if (CommonTabHost.this.aOY >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aOY);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void IA() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void IB() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aPi = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aOT);
        aVar.setEditorTools(this.Qg);
        this.alt.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.aPg = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.aPh = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.aPh.setOnTabSelectedListener(this);
        this.aPh.setEditorTools(this.Qg);
        setOrientation(1);
        this.azI = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0140d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.azI) {
            this.azI = skinType;
            onChangeSkinType(this.azI);
        }
        if (i != 8 && i != 4 && !this.aPi) {
            this.aPi = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.alt.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aPh.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aPh.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.alt.size()) {
            this.aPg.a(this.alt.get(i));
            this.aPh.setCurrentTab(i);
            this.aOY = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eZ(int i) {
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
        am.e(this, this.aLX, i);
        this.aPh.onChangeSkinType(i);
        this.aPg.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.alt.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
        if (this.alt != null && this.alt.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.alt.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Qg);
            }
        }
        if (this.aPh != null) {
            this.aPh.setEditorTools(this.Qg);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    public void init() {
    }

    public void oF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.alt.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aLX = i;
    }
}
