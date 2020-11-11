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
    private EditorTools abk;
    private int abl;
    private int ajq;
    private ArrayList<com.baidu.tbadk.editortools.view.a> eIM;
    private a fqP;
    private CommonTabContentView fra;
    private CommonTabWidgetView frb;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void auw();

        void bAQ();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.eIM = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.ajq = -1;
        this.abl = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fqP = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.frb.reset();
                CommonTabHost.this.frb.setDatas(CommonTabHost.this.eIM);
                int size = CommonTabHost.this.eIM.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bAL = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eIM.get(i)).bAL();
                    if (bAL != null) {
                        z = true;
                        CommonTabHost.this.c(bAL);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.frb.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void bAQ() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void auw() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eIM = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.ajq = -1;
        this.abl = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fqP = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.frb.reset();
                CommonTabHost.this.frb.setDatas(CommonTabHost.this.eIM);
                int size = CommonTabHost.this.eIM.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bAL = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eIM.get(i)).bAL();
                    if (bAL != null) {
                        z = true;
                        CommonTabHost.this.c(bAL);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.frb.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void bAQ() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void auw() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.fqP);
        aVar.setEditorTools(this.abk);
        this.eIM.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.fra = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.frb = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.frb.setOnTabSelectedListener(this);
        this.frb.setEditorTools(this.abk);
        setOrientation(1);
        this.ajq = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajq) {
            this.ajq = skinType;
            onChangeSkinType(this.ajq);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eIM.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.frb.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.frb.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.eIM.size()) {
            this.fra.a(this.eIM.get(i));
            this.frb.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void ry(int i) {
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
        this.frb.onChangeSkinType(i);
        this.fra.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eIM.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
        if (this.eIM != null && this.eIM.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eIM.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.abk);
            }
        }
        if (this.frb != null) {
            this.frb.setEditorTools(this.abk);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abl;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eIM.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
