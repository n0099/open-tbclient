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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools Tj;
    private int Tk;
    private int aMj;
    private a bbK;
    private CommonTabContentView bbV;
    private CommonTabWidgetView bbW;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ArrayList<com.baidu.tbadk.editortools.view.a> mData;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Nw();

        void Nx();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.mData = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aMj = -1;
        this.Tk = 0;
        this.mBgColor = e.d.common_color_10255;
        this.bbK = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.bbW.reset();
                CommonTabHost.this.bbW.setDatas(CommonTabHost.this.mData);
                int size = CommonTabHost.this.mData.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Nq = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.mData.get(i)).Nq();
                    if (Nq != null) {
                        z = true;
                        CommonTabHost.this.c(Nq);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.bbW.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void Nw() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void Nx() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mData = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aMj = -1;
        this.Tk = 0;
        this.mBgColor = e.d.common_color_10255;
        this.bbK = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.bbW.reset();
                CommonTabHost.this.bbW.setDatas(CommonTabHost.this.mData);
                int size = CommonTabHost.this.mData.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Nq = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.mData.get(i)).Nq();
                    if (Nq != null) {
                        z = true;
                        CommonTabHost.this.c(Nq);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.bbW.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void Nw() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void Nx() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.bbK);
        aVar.setEditorTools(this.Tj);
        this.mData.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(e.h.common_tab_host, (ViewGroup) this, true);
        this.bbV = (CommonTabContentView) findViewById(e.g.common_tab_content);
        this.bbW = (CommonTabWidgetView) findViewById(e.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(e.g.common_progress);
        this.bbW.setOnTabSelectedListener(this);
        this.bbW.setEditorTools(this.Tj);
        setOrientation(1);
        this.aMj = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(e.d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aMj) {
            this.aMj = skinType;
            onChangeSkinType(this.aMj);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.mData.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.bbW.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.bbW.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.mData.size()) {
            this.bbV.a(this.mData.get(i));
            this.bbW.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void fW(int i) {
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
        al.e(this, this.mBgColor, i);
        this.bbW.onChangeSkinType(i);
        this.bbV.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.mData.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
        if (this.mData != null && this.mData.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.mData.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Tj);
            }
        }
        if (this.bbW != null) {
            this.bbW.setEditorTools(this.Tj);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    public void init() {
    }

    public void pR() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.mData.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
