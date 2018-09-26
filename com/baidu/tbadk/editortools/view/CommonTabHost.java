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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools SG;
    private int SH;
    private int aCJ;
    private int aPm;
    private a aSi;
    private int aSn;
    private CommonTabContentView aSv;
    private CommonTabWidgetView aSw;
    private boolean aSx;
    private ArrayList<com.baidu.tbadk.editortools.view.a> anX;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void JQ();

        void JR();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.anX = new ArrayList<>();
        this.aSn = -1;
        this.aCJ = -1;
        this.SH = 0;
        this.aPm = e.d.common_color_10255;
        this.aSi = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aSw.reset();
                CommonTabHost.this.aSw.setDatas(CommonTabHost.this.anX);
                int size = CommonTabHost.this.anX.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b JK = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.anX.get(i)).JK();
                    if (JK != null) {
                        z = true;
                        CommonTabHost.this.c(JK);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aSw.setVisibility(8);
                }
                if (CommonTabHost.this.aSn >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aSn);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void JQ() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void JR() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aSx = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anX = new ArrayList<>();
        this.aSn = -1;
        this.aCJ = -1;
        this.SH = 0;
        this.aPm = e.d.common_color_10255;
        this.aSi = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aSw.reset();
                CommonTabHost.this.aSw.setDatas(CommonTabHost.this.anX);
                int size = CommonTabHost.this.anX.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b JK = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.anX.get(i)).JK();
                    if (JK != null) {
                        z = true;
                        CommonTabHost.this.c(JK);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aSw.setVisibility(8);
                }
                if (CommonTabHost.this.aSn >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aSn);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void JQ() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void JR() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aSx = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aSi);
        aVar.setEditorTools(this.SG);
        this.anX.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(e.h.common_tab_host, (ViewGroup) this, true);
        this.aSv = (CommonTabContentView) findViewById(e.g.common_tab_content);
        this.aSw = (CommonTabWidgetView) findViewById(e.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(e.g.common_progress);
        this.aSw.setOnTabSelectedListener(this);
        this.aSw.setEditorTools(this.SG);
        setOrientation(1);
        this.aCJ = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(e.d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aCJ) {
            this.aCJ = skinType;
            onChangeSkinType(this.aCJ);
        }
        if (i != 8 && i != 4 && !this.aSx) {
            this.aSx = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.anX.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aSw.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aSw.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.anX.size()) {
            this.aSv.a(this.anX.get(i));
            this.aSw.setCurrentTab(i);
            this.aSn = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void fk(int i) {
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
        al.e(this, this.aPm, i);
        this.aSw.onChangeSkinType(i);
        this.aSv.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.anX.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
        if (this.anX != null && this.anX.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.anX.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.SG);
            }
        }
        if (this.aSw != null) {
            this.aSw.setEditorTools(this.SG);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
    }

    public void init() {
    }

    public void pI() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.anX.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aPm = i;
    }
}
