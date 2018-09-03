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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools Qg;
    private int Qh;
    private int aLU;
    private a aOQ;
    private int aOV;
    private CommonTabContentView aPd;
    private CommonTabWidgetView aPe;
    private boolean aPf;
    private ArrayList<com.baidu.tbadk.editortools.view.a> als;
    private int azF;
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
        this.als = new ArrayList<>();
        this.aOV = -1;
        this.azF = -1;
        this.Qh = 0;
        this.aLU = f.d.common_color_10255;
        this.aOQ = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aPe.reset();
                CommonTabHost.this.aPe.setDatas(CommonTabHost.this.als);
                int size = CommonTabHost.this.als.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Iu = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.als.get(i)).Iu();
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
                    CommonTabHost.this.aPe.setVisibility(8);
                }
                if (CommonTabHost.this.aOV >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aOV);
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
        this.aPf = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.als = new ArrayList<>();
        this.aOV = -1;
        this.azF = -1;
        this.Qh = 0;
        this.aLU = f.d.common_color_10255;
        this.aOQ = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aPe.reset();
                CommonTabHost.this.aPe.setDatas(CommonTabHost.this.als);
                int size = CommonTabHost.this.als.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Iu = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.als.get(i)).Iu();
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
                    CommonTabHost.this.aPe.setVisibility(8);
                }
                if (CommonTabHost.this.aOV >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aOV);
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
        this.aPf = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aOQ);
        aVar.setEditorTools(this.Qg);
        this.als.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(f.h.common_tab_host, (ViewGroup) this, true);
        this.aPd = (CommonTabContentView) findViewById(f.g.common_tab_content);
        this.aPe = (CommonTabWidgetView) findViewById(f.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(f.g.common_progress);
        this.aPe.setOnTabSelectedListener(this);
        this.aPe.setEditorTools(this.Qg);
        setOrientation(1);
        this.azF = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(f.d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.azF) {
            this.azF = skinType;
            onChangeSkinType(this.azF);
        }
        if (i != 8 && i != 4 && !this.aPf) {
            this.aPf = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.als.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aPe.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aPe.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.als.size()) {
            this.aPd.a(this.als.get(i));
            this.aPe.setCurrentTab(i);
            this.aOV = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eY(int i) {
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
        am.e(this, this.aLU, i);
        this.aPe.onChangeSkinType(i);
        this.aPd.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.als.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
        if (this.als != null && this.als.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.als.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Qg);
            }
        }
        if (this.aPe != null) {
            this.aPe.setEditorTools(this.Qg);
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

    public void oC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.als.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aLU = i;
    }
}
