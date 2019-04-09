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
    private EditorTools VO;
    private int VP;
    private ArrayList<com.baidu.tbadk.editortools.view.a> aFM;
    private boolean aIf;
    private int bUN;
    private int biW;
    private int cip;
    private CommonTabContentView clD;
    private CommonTabWidgetView clE;
    private a cls;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void amX();

        void amY();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.aFM = new ArrayList<>();
        this.biW = -1;
        this.bUN = -1;
        this.VP = 0;
        this.cip = d.C0277d.common_color_10255;
        this.cls = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.clE.reset();
                CommonTabHost.this.clE.setDatas(CommonTabHost.this.aFM);
                int size = CommonTabHost.this.aFM.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b amR = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aFM.get(i)).amR();
                    if (amR != null) {
                        z = true;
                        CommonTabHost.this.c(amR);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.clE.setVisibility(8);
                }
                if (CommonTabHost.this.biW >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.biW);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amX() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amY() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aIf = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFM = new ArrayList<>();
        this.biW = -1;
        this.bUN = -1;
        this.VP = 0;
        this.cip = d.C0277d.common_color_10255;
        this.cls = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.clE.reset();
                CommonTabHost.this.clE.setDatas(CommonTabHost.this.aFM);
                int size = CommonTabHost.this.aFM.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b amR = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aFM.get(i)).amR();
                    if (amR != null) {
                        z = true;
                        CommonTabHost.this.c(amR);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.clE.setVisibility(8);
                }
                if (CommonTabHost.this.biW >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.biW);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amX() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amY() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aIf = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.cls);
        aVar.setEditorTools(this.VO);
        this.aFM.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.clD = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.clE = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.clE.setOnTabSelectedListener(this);
        this.clE.setEditorTools(this.VO);
        setOrientation(1);
        this.bUN = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0277d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bUN) {
            this.bUN = skinType;
            onChangeSkinType(this.bUN);
        }
        if (i != 8 && i != 4 && !this.aIf) {
            this.aIf = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFM.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.clE.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.clE.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aFM.size()) {
            this.clD.a(this.aFM.get(i));
            this.clE.setCurrentTab(i);
            this.biW = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void jG(int i) {
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
        al.f(this, this.cip, i);
        this.clE.onChangeSkinType(i);
        this.clD.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFM.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
        if (this.aFM != null && this.aFM.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFM.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.VO);
            }
        }
        if (this.clE != null) {
            this.clE.setEditorTools(this.VO);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFM.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cip = i;
    }
}
