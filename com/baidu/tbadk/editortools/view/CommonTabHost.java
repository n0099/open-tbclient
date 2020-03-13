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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools FO;
    private int FP;
    private int Ni;
    private boolean bLF;
    private ArrayList<com.baidu.tbadk.editortools.view.a> cVS;
    private a dzE;
    private CommonTabContentView dzP;
    private CommonTabWidgetView dzQ;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Sk();

        void aPE();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.cVS = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.Ni = -1;
        this.FP = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dzE = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dzQ.reset();
                CommonTabHost.this.dzQ.setDatas(CommonTabHost.this.cVS);
                int size = CommonTabHost.this.cVS.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aPz = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.cVS.get(i)).aPz();
                    if (aPz != null) {
                        z = true;
                        CommonTabHost.this.c(aPz);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dzQ.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aPE() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void Sk() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bLF = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVS = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.Ni = -1;
        this.FP = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dzE = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dzQ.reset();
                CommonTabHost.this.dzQ.setDatas(CommonTabHost.this.cVS);
                int size = CommonTabHost.this.cVS.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aPz = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.cVS.get(i)).aPz();
                    if (aPz != null) {
                        z = true;
                        CommonTabHost.this.c(aPz);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dzQ.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aPE() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void Sk() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bLF = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.dzE);
        aVar.setEditorTools(this.FO);
        this.cVS.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.dzP = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.dzQ = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.dzQ.setOnTabSelectedListener(this);
        this.dzQ.setEditorTools(this.FO);
        setOrientation(1);
        this.Ni = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.Ni) {
            this.Ni = skinType;
            onChangeSkinType(this.Ni);
        }
        if (i != 8 && i != 4 && !this.bLF) {
            this.bLF = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.cVS.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.dzQ.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.dzQ.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cVS.size()) {
            this.dzP.a(this.cVS.get(i));
            this.dzQ.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void mA(int i) {
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

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.mBgColor, i);
        this.dzQ.onChangeSkinType(i);
        this.dzP.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.cVS.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        if (this.cVS != null && this.cVS.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.cVS.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.FO);
            }
        }
        if (this.dzQ != null) {
            this.dzQ.setEditorTools(this.FO);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    public void init() {
    }

    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.cVS.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
