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
    private EditorTools Za;
    private int Zb;
    private int afT;
    private boolean ckA;
    private CommonTabContentView dZK;
    private CommonTabWidgetView dZL;
    private a dZz;
    private ArrayList<com.baidu.tbadk.editortools.view.a> dvq;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void aXZ();

        void aac();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.dvq = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.afT = -1;
        this.Zb = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dZz = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dZL.reset();
                CommonTabHost.this.dZL.setDatas(CommonTabHost.this.dvq);
                int size = CommonTabHost.this.dvq.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aXU = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.dvq.get(i)).aXU();
                    if (aXU != null) {
                        z = true;
                        CommonTabHost.this.c(aXU);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dZL.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aXZ() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aac() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.ckA = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvq = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.afT = -1;
        this.Zb = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dZz = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dZL.reset();
                CommonTabHost.this.dZL.setDatas(CommonTabHost.this.dvq);
                int size = CommonTabHost.this.dvq.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aXU = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.dvq.get(i)).aXU();
                    if (aXU != null) {
                        z = true;
                        CommonTabHost.this.c(aXU);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dZL.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aXZ() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aac() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.ckA = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.dZz);
        aVar.setEditorTools(this.Za);
        this.dvq.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.dZK = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.dZL = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.dZL.setOnTabSelectedListener(this);
        this.dZL.setEditorTools(this.Za);
        setOrientation(1);
        this.afT = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.afT) {
            this.afT = skinType;
            onChangeSkinType(this.afT);
        }
        if (i != 8 && i != 4 && !this.ckA) {
            this.ckA = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.dvq.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.dZL.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.dZL.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.dvq.size()) {
            this.dZK.a(this.dvq.get(i));
            this.dZL.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void mN(int i) {
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
        this.dZL.onChangeSkinType(i);
        this.dZK.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.dvq.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
        if (this.dvq != null && this.dvq.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.dvq.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Za);
            }
        }
        if (this.dZL != null) {
            this.dZL.setEditorTools(this.Za);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Za != null) {
            this.Za.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zb = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zb;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.dvq.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
