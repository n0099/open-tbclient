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
    private EditorTools SY;
    private int SZ;
    private int aHp;
    private a aWJ;
    private int aWO;
    private CommonTabContentView aWW;
    private CommonTabWidgetView aWX;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private ArrayList<com.baidu.tbadk.editortools.view.a> mData;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void LO();

        void LP();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.mData = new ArrayList<>();
        this.aWO = -1;
        this.aHp = -1;
        this.SZ = 0;
        this.mBgColor = e.d.common_color_10255;
        this.aWJ = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aWX.reset();
                CommonTabHost.this.aWX.setDatas(CommonTabHost.this.mData);
                int size = CommonTabHost.this.mData.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b LI = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.mData.get(i)).LI();
                    if (LI != null) {
                        z = true;
                        CommonTabHost.this.c(LI);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aWX.setVisibility(8);
                }
                if (CommonTabHost.this.aWO >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aWO);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void LO() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void LP() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mData = new ArrayList<>();
        this.aWO = -1;
        this.aHp = -1;
        this.SZ = 0;
        this.mBgColor = e.d.common_color_10255;
        this.aWJ = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aWX.reset();
                CommonTabHost.this.aWX.setDatas(CommonTabHost.this.mData);
                int size = CommonTabHost.this.mData.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b LI = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.mData.get(i)).LI();
                    if (LI != null) {
                        z = true;
                        CommonTabHost.this.c(LI);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aWX.setVisibility(8);
                }
                if (CommonTabHost.this.aWO >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aWO);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void LO() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void LP() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aWJ);
        aVar.setEditorTools(this.SY);
        this.mData.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(e.h.common_tab_host, (ViewGroup) this, true);
        this.aWW = (CommonTabContentView) findViewById(e.g.common_tab_content);
        this.aWX = (CommonTabWidgetView) findViewById(e.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(e.g.common_progress);
        this.aWX.setOnTabSelectedListener(this);
        this.aWX.setEditorTools(this.SY);
        setOrientation(1);
        this.aHp = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(e.d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aHp) {
            this.aHp = skinType;
            onChangeSkinType(this.aHp);
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
        this.aWX.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aWX.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.mData.size()) {
            this.aWW.a(this.mData.get(i));
            this.aWX.setCurrentTab(i);
            this.aWO = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void ft(int i) {
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
        this.aWX.onChangeSkinType(i);
        this.aWW.onChangeSkinType(i);
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
        this.SY = editorTools;
        if (this.mData != null && this.mData.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.mData.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.SY);
            }
        }
        if (this.aWX != null) {
            this.aWX.setEditorTools(this.SY);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
    }

    public void init() {
    }

    public void pQ() {
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
