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
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools acR;
    private int acS;
    private int ajU;
    private int bLv;
    private ArrayList<com.baidu.tbadk.editortools.view.a> eVV;
    private a fEO;
    private CommonTabContentView fEZ;
    private CommonTabWidgetView fFa;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void c(com.baidu.tbadk.editortools.view.a aVar);

        void onLoadFail();

        void preLoad();
    }

    public CommonTabHost(Context context) {
        super(context);
        this.eVV = new ArrayList<>();
        this.bLv = -1;
        this.ajU = -1;
        this.acS = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fEO = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.fFa.reset();
                CommonTabHost.this.fFa.setDatas(CommonTabHost.this.eVV);
                int size = CommonTabHost.this.eVV.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bCw = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eVV.get(i)).bCw();
                    if (bCw != null) {
                        z = true;
                        CommonTabHost.this.c(bCw);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.fFa.setVisibility(8);
                }
                if (CommonTabHost.this.bLv >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bLv);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void preLoad() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void onLoadFail() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eVV = new ArrayList<>();
        this.bLv = -1;
        this.ajU = -1;
        this.acS = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fEO = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.fFa.reset();
                CommonTabHost.this.fFa.setDatas(CommonTabHost.this.eVV);
                int size = CommonTabHost.this.eVV.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bCw = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eVV.get(i)).bCw();
                    if (bCw != null) {
                        z = true;
                        CommonTabHost.this.c(bCw);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.fFa.setVisibility(8);
                }
                if (CommonTabHost.this.bLv >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bLv);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void preLoad() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void onLoadFail() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.fEO);
        aVar.setEditorTools(this.acR);
        this.eVV.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.fEZ = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.fFa = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.fFa.setOnTabSelectedListener(this);
        this.fFa.setEditorTools(this.acR);
        setOrientation(1);
        this.ajU = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.CAM_X0201);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajU) {
            this.ajU = skinType;
            onChangeSkinType(this.ajU);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eVV.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.fFa.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.fFa.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.eVV.size()) {
            this.fEZ.a(this.eVV.get(i));
            this.fFa.setCurrentTab(i);
            this.bLv = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void ri(int i) {
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
        this.fFa.onChangeSkinType(i);
        this.fEZ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eVV.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
        if (this.eVV != null && this.eVV.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eVV.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.acR);
            }
        }
        if (this.fFa != null) {
            this.fFa.setEditorTools(this.acR);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eVV.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
