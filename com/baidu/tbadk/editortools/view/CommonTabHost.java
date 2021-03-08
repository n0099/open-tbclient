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
    private EditorTools ael;
    private int aem;
    private int aln;
    private int bMV;
    private ArrayList<com.baidu.tbadk.editortools.view.a> eXu;
    private a fGn;
    private CommonTabContentView fGy;
    private CommonTabWidgetView fGz;
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
        this.eXu = new ArrayList<>();
        this.bMV = -1;
        this.aln = -1;
        this.aem = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fGn = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.fGz.reset();
                CommonTabHost.this.fGz.setDatas(CommonTabHost.this.eXu);
                int size = CommonTabHost.this.eXu.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bCz = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eXu.get(i)).bCz();
                    if (bCz != null) {
                        z = true;
                        CommonTabHost.this.c(bCz);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.fGz.setVisibility(8);
                }
                if (CommonTabHost.this.bMV >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bMV);
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
        this.eXu = new ArrayList<>();
        this.bMV = -1;
        this.aln = -1;
        this.aem = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fGn = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.fGz.reset();
                CommonTabHost.this.fGz.setDatas(CommonTabHost.this.eXu);
                int size = CommonTabHost.this.eXu.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bCz = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eXu.get(i)).bCz();
                    if (bCz != null) {
                        z = true;
                        CommonTabHost.this.c(bCz);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.fGz.setVisibility(8);
                }
                if (CommonTabHost.this.bMV >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bMV);
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
        aVar.a(this.fGn);
        aVar.setEditorTools(this.ael);
        this.eXu.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.fGy = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.fGz = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.fGz.setOnTabSelectedListener(this);
        this.fGz.setEditorTools(this.ael);
        setOrientation(1);
        this.aln = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.CAM_X0201);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aln) {
            this.aln = skinType;
            onChangeSkinType(this.aln);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eXu.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.fGz.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.fGz.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.eXu.size()) {
            this.fGy.a(this.eXu.get(i));
            this.fGz.setCurrentTab(i);
            this.bMV = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void rj(int i) {
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
        this.fGz.onChangeSkinType(i);
        this.fGy.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eXu.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
        if (this.eXu != null && this.eXu.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eXu.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.ael);
            }
        }
        if (this.fGz != null) {
            this.fGz.setEditorTools(this.ael);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aem = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aem;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eXu.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
