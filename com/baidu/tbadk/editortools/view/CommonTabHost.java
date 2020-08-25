package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools aay;
    private int aaz;
    private int aiB;
    private CommonTabContentView eNH;
    private CommonTabWidgetView eNI;
    private a eNw;
    private ArrayList<com.baidu.tbadk.editortools.view.a> efX;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes2.dex */
    public interface a {
        void amF();

        void bsJ();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.efX = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aiB = -1;
        this.aaz = 0;
        this.mBgColor = R.color.common_color_10255;
        this.eNw = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.eNI.reset();
                CommonTabHost.this.eNI.setDatas(CommonTabHost.this.efX);
                int size = CommonTabHost.this.efX.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bsE = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.efX.get(i)).bsE();
                    if (bsE != null) {
                        z = true;
                        CommonTabHost.this.c(bsE);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.eNI.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void bsJ() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amF() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efX = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aiB = -1;
        this.aaz = 0;
        this.mBgColor = R.color.common_color_10255;
        this.eNw = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.eNI.reset();
                CommonTabHost.this.eNI.setDatas(CommonTabHost.this.efX);
                int size = CommonTabHost.this.efX.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bsE = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.efX.get(i)).bsE();
                    if (bsE != null) {
                        z = true;
                        CommonTabHost.this.c(bsE);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.eNI.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void bsJ() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amF() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.eNw);
        aVar.setEditorTools(this.aay);
        this.efX.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.eNH = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.eNI = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.eNI.setOnTabSelectedListener(this);
        this.eNI.setEditorTools(this.aay);
        setOrientation(1);
        this.aiB = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aiB) {
            this.aiB = skinType;
            onChangeSkinType(this.aiB);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.efX.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.eNI.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.eNI.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.efX.size()) {
            this.eNH.a(this.efX.get(i));
            this.eNI.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void qo(int i) {
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

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.mBgColor, i);
        this.eNI.onChangeSkinType(i);
        this.eNH.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.efX.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
        if (this.efX != null && this.efX.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.efX.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.aay);
            }
        }
        if (this.eNI != null) {
            this.eNI.setEditorTools(this.aay);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaz;
    }

    public void init() {
    }

    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.efX.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
