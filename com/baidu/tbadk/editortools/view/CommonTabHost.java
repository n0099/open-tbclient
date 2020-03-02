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
    private boolean bLE;
    private ArrayList<com.baidu.tbadk.editortools.view.a> cVR;
    private CommonTabContentView dzC;
    private CommonTabWidgetView dzD;
    private a dzr;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Sk();

        void aPD();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.cVR = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.Ni = -1;
        this.FP = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dzr = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dzD.reset();
                CommonTabHost.this.dzD.setDatas(CommonTabHost.this.cVR);
                int size = CommonTabHost.this.cVR.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aPy = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.cVR.get(i)).aPy();
                    if (aPy != null) {
                        z = true;
                        CommonTabHost.this.c(aPy);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dzD.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aPD() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void Sk() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bLE = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVR = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.Ni = -1;
        this.FP = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dzr = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dzD.reset();
                CommonTabHost.this.dzD.setDatas(CommonTabHost.this.cVR);
                int size = CommonTabHost.this.cVR.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aPy = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.cVR.get(i)).aPy();
                    if (aPy != null) {
                        z = true;
                        CommonTabHost.this.c(aPy);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dzD.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aPD() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void Sk() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bLE = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.dzr);
        aVar.setEditorTools(this.FO);
        this.cVR.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.dzC = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.dzD = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.dzD.setOnTabSelectedListener(this);
        this.dzD.setEditorTools(this.FO);
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
        if (i != 8 && i != 4 && !this.bLE) {
            this.bLE = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.cVR.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.dzD.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.dzD.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cVR.size()) {
            this.dzC.a(this.cVR.get(i));
            this.dzD.setCurrentTab(i);
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
        this.dzD.onChangeSkinType(i);
        this.dzC.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.cVR.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        if (this.cVR != null && this.cVR.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.cVR.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.FO);
            }
        }
        if (this.dzD != null) {
            this.dzD.setEditorTools(this.FO);
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.cVR.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
