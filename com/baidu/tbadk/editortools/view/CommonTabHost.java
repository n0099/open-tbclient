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
    private EditorTools Zd;
    private int Ze;
    private int afW;
    private boolean ckG;
    private a dZE;
    private CommonTabContentView dZP;
    private CommonTabWidgetView dZQ;
    private ArrayList<com.baidu.tbadk.editortools.view.a> dvu;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void aXX();

        void aab();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.dvu = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.afW = -1;
        this.Ze = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dZE = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dZQ.reset();
                CommonTabHost.this.dZQ.setDatas(CommonTabHost.this.dvu);
                int size = CommonTabHost.this.dvu.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aXS = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.dvu.get(i)).aXS();
                    if (aXS != null) {
                        z = true;
                        CommonTabHost.this.c(aXS);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dZQ.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aXX() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aab() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.ckG = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvu = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.afW = -1;
        this.Ze = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dZE = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dZQ.reset();
                CommonTabHost.this.dZQ.setDatas(CommonTabHost.this.dvu);
                int size = CommonTabHost.this.dvu.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aXS = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.dvu.get(i)).aXS();
                    if (aXS != null) {
                        z = true;
                        CommonTabHost.this.c(aXS);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dZQ.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aXX() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aab() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.ckG = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.dZE);
        aVar.setEditorTools(this.Zd);
        this.dvu.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.dZP = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.dZQ = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.dZQ.setOnTabSelectedListener(this);
        this.dZQ.setEditorTools(this.Zd);
        setOrientation(1);
        this.afW = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.afW) {
            this.afW = skinType;
            onChangeSkinType(this.afW);
        }
        if (i != 8 && i != 4 && !this.ckG) {
            this.ckG = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.dvu.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.dZQ.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.dZQ.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.dvu.size()) {
            this.dZP.a(this.dvu.get(i));
            this.dZQ.setCurrentTab(i);
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
        this.dZQ.onChangeSkinType(i);
        this.dZP.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.dvu.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
        if (this.dvu != null && this.dvu.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.dvu.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Zd);
            }
        }
        if (this.dZQ != null) {
            this.dZQ.setEditorTools(this.Zd);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zd != null) {
            this.Zd.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Ze = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Ze;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.dvu.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
