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
    private EditorTools Fv;
    private int Fw;
    private int MH;
    private boolean bHy;
    private ArrayList<com.baidu.tbadk.editortools.view.a> cRO;
    private a dvk;
    private CommonTabContentView dvv;
    private CommonTabWidgetView dvw;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void PU();

        void aNf();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.cRO = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.MH = -1;
        this.Fw = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dvk = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dvw.reset();
                CommonTabHost.this.dvw.setDatas(CommonTabHost.this.cRO);
                int size = CommonTabHost.this.cRO.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aNa = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.cRO.get(i)).aNa();
                    if (aNa != null) {
                        z = true;
                        CommonTabHost.this.c(aNa);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dvw.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aNf() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void PU() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bHy = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRO = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.MH = -1;
        this.Fw = 0;
        this.mBgColor = R.color.common_color_10255;
        this.dvk = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.dvw.reset();
                CommonTabHost.this.dvw.setDatas(CommonTabHost.this.cRO);
                int size = CommonTabHost.this.cRO.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b aNa = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.cRO.get(i)).aNa();
                    if (aNa != null) {
                        z = true;
                        CommonTabHost.this.c(aNa);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.dvw.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void aNf() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void PU() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bHy = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.dvk);
        aVar.setEditorTools(this.Fv);
        this.cRO.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.dvv = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.dvw = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.dvw.setOnTabSelectedListener(this);
        this.dvw.setEditorTools(this.Fv);
        setOrientation(1);
        this.MH = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.MH) {
            this.MH = skinType;
            onChangeSkinType(this.MH);
        }
        if (i != 8 && i != 4 && !this.bHy) {
            this.bHy = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.cRO.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.dvw.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.dvw.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cRO.size()) {
            this.dvv.a(this.cRO.get(i));
            this.dvw.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void mi(int i) {
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
        this.dvw.onChangeSkinType(i);
        this.dvv.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.cRO.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
        if (this.cRO != null && this.cRO.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.cRO.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Fv);
            }
        }
        if (this.dvw != null) {
            this.dvw.setEditorTools(this.Fv);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fw = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fw;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.cRO.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
