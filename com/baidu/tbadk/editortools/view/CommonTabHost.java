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
    private EditorTools ZS;
    private int ZT;
    private int aho;
    private ArrayList<com.baidu.tbadk.editortools.view.a> dWx;
    private a eCX;
    private CommonTabContentView eDi;
    private CommonTabWidgetView eDj;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void afy();

        void bjX();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.dWx = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aho = -1;
        this.ZT = 0;
        this.mBgColor = R.color.common_color_10255;
        this.eCX = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.eDj.reset();
                CommonTabHost.this.eDj.setDatas(CommonTabHost.this.dWx);
                int size = CommonTabHost.this.dWx.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bjS = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.dWx.get(i)).bjS();
                    if (bjS != null) {
                        z = true;
                        CommonTabHost.this.c(bjS);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.eDj.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void bjX() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void afy() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dWx = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aho = -1;
        this.ZT = 0;
        this.mBgColor = R.color.common_color_10255;
        this.eCX = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.eDj.reset();
                CommonTabHost.this.eDj.setDatas(CommonTabHost.this.dWx);
                int size = CommonTabHost.this.dWx.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bjS = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.dWx.get(i)).bjS();
                    if (bjS != null) {
                        z = true;
                        CommonTabHost.this.c(bjS);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.eDj.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void bjX() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void afy() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.eCX);
        aVar.setEditorTools(this.ZS);
        this.dWx.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.eDi = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.eDj = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.eDj.setOnTabSelectedListener(this);
        this.eDj.setEditorTools(this.ZS);
        setOrientation(1);
        this.aho = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aho) {
            this.aho = skinType;
            onChangeSkinType(this.aho);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.dWx.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.eDj.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.eDj.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.dWx.size()) {
            this.eDi.a(this.dWx.get(i));
            this.eDj.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void od(int i) {
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
        ao.setBackgroundColor(this, this.mBgColor, i);
        this.eDj.onChangeSkinType(i);
        this.eDi.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.dWx.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
        if (this.dWx != null && this.dWx.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.dWx.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.ZS);
            }
        }
        if (this.eDj != null) {
            this.eDj.setEditorTools(this.ZS);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.dWx.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
