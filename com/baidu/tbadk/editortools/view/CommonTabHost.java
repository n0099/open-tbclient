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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools Qj;
    private int Qk;
    private a aOU;
    private int aOZ;
    private CommonTabContentView aPh;
    private CommonTabWidgetView aPi;
    private ArrayList<com.baidu.tbadk.editortools.view.a> alT;
    private int azP;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void IF();

        void IG();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.alT = new ArrayList<>();
        this.aOZ = -1;
        this.azP = -1;
        this.Qk = 0;
        this.mBgColor = d.C0142d.common_color_10255;
        this.aOU = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aPi.reset();
                CommonTabHost.this.aPi.setDatas(CommonTabHost.this.alT);
                int size = CommonTabHost.this.alT.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Iz = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.alT.get(i)).Iz();
                    if (Iz != null) {
                        z = true;
                        CommonTabHost.this.c(Iz);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aPi.setVisibility(8);
                }
                if (CommonTabHost.this.aOZ >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aOZ);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void IF() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void IG() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alT = new ArrayList<>();
        this.aOZ = -1;
        this.azP = -1;
        this.Qk = 0;
        this.mBgColor = d.C0142d.common_color_10255;
        this.aOU = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.aPi.reset();
                CommonTabHost.this.aPi.setDatas(CommonTabHost.this.alT);
                int size = CommonTabHost.this.alT.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Iz = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.alT.get(i)).Iz();
                    if (Iz != null) {
                        z = true;
                        CommonTabHost.this.c(Iz);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.aPi.setVisibility(8);
                }
                if (CommonTabHost.this.aOZ >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.aOZ);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void IF() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void IG() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aOU);
        aVar.setEditorTools(this.Qj);
        this.alT.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.i.common_tab_host, (ViewGroup) this, true);
        this.aPh = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.aPi = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.aPi.setOnTabSelectedListener(this);
        this.aPi.setEditorTools(this.Qj);
        setOrientation(1);
        this.azP = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0142d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.azP) {
            this.azP = skinType;
            onChangeSkinType(this.azP);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.alT.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aPi.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aPi.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.alT.size()) {
            this.aPh.a(this.alT.get(i));
            this.aPi.setCurrentTab(i);
            this.aOZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eY(int i) {
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
        am.e(this, this.mBgColor, i);
        this.aPi.onChangeSkinType(i);
        this.aPh.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.alT.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
        if (this.alT != null && this.alT.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.alT.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Qj);
            }
        }
        if (this.aPi != null) {
            this.aPi.setEditorTools(this.Qj);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qk;
    }

    public void init() {
    }

    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.alT.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
