package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools JS;
    private int JT;
    private a aFB;
    private int aFG;
    private CommonTabContentView aFO;
    private CommonTabWidgetView aFP;
    private ArrayList<com.baidu.tbadk.editortools.view.a> adv;
    private int aqQ;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void EL();

        void EM();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.adv = new ArrayList<>();
        this.aFG = -1;
        this.aqQ = -1;
        this.JT = 0;
        this.mBgColor = d.C0126d.common_color_10255;
        this.aFB = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aFP.reset();
                CommonTabHost.this.aFP.setDatas(CommonTabHost.this.adv);
                int size = CommonTabHost.this.adv.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b EF = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.adv.get(i)).EF();
                    if (EF != null) {
                        z = true;
                        CommonTabHost.this.c(EF);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aFP.setVisibility(8);
                }
                if (CommonTabHost.this.aFG >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aFG);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void EL() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void EM() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adv = new ArrayList<>();
        this.aFG = -1;
        this.aqQ = -1;
        this.JT = 0;
        this.mBgColor = d.C0126d.common_color_10255;
        this.aFB = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aFP.reset();
                CommonTabHost.this.aFP.setDatas(CommonTabHost.this.adv);
                int size = CommonTabHost.this.adv.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b EF = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.adv.get(i)).EF();
                    if (EF != null) {
                        z = true;
                        CommonTabHost.this.c(EF);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aFP.setVisibility(8);
                }
                if (CommonTabHost.this.aFG >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aFG);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void EL() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void EM() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aFB);
        aVar.setEditorTools(this.JS);
        this.adv.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.i.common_tab_host, (ViewGroup) this, true);
        this.aFO = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.aFP = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.aFP.setOnTabSelectedListener(this);
        this.aFP.setEditorTools(this.JS);
        setOrientation(1);
        this.aqQ = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0126d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aqQ) {
            this.aqQ = skinType;
            onChangeSkinType(this.aqQ);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.adv.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aFP.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aFP.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.adv.size()) {
            this.aFO.a(this.adv.get(i));
            this.aFP.setCurrentTab(i);
            this.aFG = i;
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

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        ak.e(this, this.mBgColor, i);
        this.aFP.onChangeSkinType(i);
        this.aFO.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.adv.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
        if (this.adv != null && this.adv.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.adv.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.JS);
            }
        }
        if (this.aFP != null) {
            this.aFP.setEditorTools(this.JS);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JS != null) {
            this.JS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JT;
    }

    public void init() {
    }

    public void lN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.adv.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
