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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools TA;
    private int TB;
    private ArrayList<com.baidu.tbadk.editortools.view.a> aHF;
    private boolean aJY;
    private int boZ;
    private int ccJ;
    private int cqx;
    private a ctB;
    private CommonTabContentView ctM;
    private CommonTabWidgetView ctN;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void asa();

        void asb();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.aHF = new ArrayList<>();
        this.boZ = -1;
        this.ccJ = -1;
        this.TB = 0;
        this.cqx = R.color.common_color_10255;
        this.ctB = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.ctN.reset();
                CommonTabHost.this.ctN.setDatas(CommonTabHost.this.aHF);
                int size = CommonTabHost.this.aHF.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b arU = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aHF.get(i)).arU();
                    if (arU != null) {
                        z = true;
                        CommonTabHost.this.c(arU);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.ctN.setVisibility(8);
                }
                if (CommonTabHost.this.boZ >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.boZ);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void asa() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void asb() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aJY = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHF = new ArrayList<>();
        this.boZ = -1;
        this.ccJ = -1;
        this.TB = 0;
        this.cqx = R.color.common_color_10255;
        this.ctB = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.ctN.reset();
                CommonTabHost.this.ctN.setDatas(CommonTabHost.this.aHF);
                int size = CommonTabHost.this.aHF.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b arU = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aHF.get(i)).arU();
                    if (arU != null) {
                        z = true;
                        CommonTabHost.this.c(arU);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.ctN.setVisibility(8);
                }
                if (CommonTabHost.this.boZ >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.boZ);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void asa() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void asb() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aJY = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.ctB);
        aVar.setEditorTools(this.TA);
        this.aHF.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.ctM = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.ctN = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.ctN.setOnTabSelectedListener(this);
        this.ctN.setEditorTools(this.TA);
        setOrientation(1);
        this.ccJ = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ccJ) {
            this.ccJ = skinType;
            onChangeSkinType(this.ccJ);
        }
        if (i != 8 && i != 4 && !this.aJY) {
            this.aJY = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aHF.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.ctN.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.ctN.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aHF.size()) {
            this.ctM.a(this.aHF.get(i));
            this.ctN.setCurrentTab(i);
            this.boZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void ku(int i) {
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
        al.h(this, this.cqx, i);
        this.ctN.onChangeSkinType(i);
        this.ctM.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aHF.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
        if (this.aHF != null && this.aHF.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aHF.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.TA);
            }
        }
        if (this.ctN != null) {
            this.ctN.setEditorTools(this.TA);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TB;
    }

    public void init() {
    }

    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aHF.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cqx = i;
    }
}
