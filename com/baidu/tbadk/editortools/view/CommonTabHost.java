package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools acZ;
    private int ada;
    private int akW;
    private int bMx;
    private ArrayList<com.baidu.tbadk.editortools.view.a> eYq;
    private a fHj;
    private CommonTabContentView fHu;
    private CommonTabWidgetView fHv;
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
        this.eYq = new ArrayList<>();
        this.bMx = -1;
        this.akW = -1;
        this.ada = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fHj = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.fHv.reset();
                CommonTabHost.this.fHv.setDatas(CommonTabHost.this.eYq);
                int size = CommonTabHost.this.eYq.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bFW = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eYq.get(i)).bFW();
                    if (bFW != null) {
                        z = true;
                        CommonTabHost.this.c(bFW);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.fHv.setVisibility(8);
                }
                if (CommonTabHost.this.bMx >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bMx);
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
        this.eYq = new ArrayList<>();
        this.bMx = -1;
        this.akW = -1;
        this.ada = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fHj = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.fHv.reset();
                CommonTabHost.this.fHv.setDatas(CommonTabHost.this.eYq);
                int size = CommonTabHost.this.eYq.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bFW = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eYq.get(i)).bFW();
                    if (bFW != null) {
                        z = true;
                        CommonTabHost.this.c(bFW);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.fHv.setVisibility(8);
                }
                if (CommonTabHost.this.bMx >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bMx);
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
        aVar.a(this.fHj);
        aVar.setEditorTools(this.acZ);
        this.eYq.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.fHu = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.fHv = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.fHv.setOnTabSelectedListener(this);
        this.fHv.setEditorTools(this.acZ);
        setOrientation(1);
        this.akW = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.CAM_X0201);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.akW) {
            this.akW = skinType;
            onChangeSkinType(this.akW);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eYq.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.fHv.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.fHv.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.eYq.size()) {
            this.fHu.a(this.eYq.get(i));
            this.fHv.setCurrentTab(i);
            this.bMx = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void sJ(int i) {
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
        ao.setBackgroundColor(this, this.mBgColor, i);
        this.fHv.onChangeSkinType(i);
        this.fHu.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eYq.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
        if (this.eYq != null && this.eYq.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eYq.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.acZ);
            }
        }
        if (this.fHv != null) {
            this.fHv.setEditorTools(this.acZ);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
    }

    public void init() {
    }

    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eYq.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
