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
    private EditorTools TT;
    private int TU;
    private ArrayList<com.baidu.tbadk.editortools.view.a> aIL;
    private boolean aLe;
    private int bqk;
    private int ceL;
    private int csN;
    private a cvT;
    private CommonTabContentView cwe;
    private CommonTabWidgetView cwf;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void atv();

        void atw();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.aIL = new ArrayList<>();
        this.bqk = -1;
        this.ceL = -1;
        this.TU = 0;
        this.csN = R.color.common_color_10255;
        this.cvT = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.cwf.reset();
                CommonTabHost.this.cwf.setDatas(CommonTabHost.this.aIL);
                int size = CommonTabHost.this.aIL.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b ato = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aIL.get(i)).ato();
                    if (ato != null) {
                        z = true;
                        CommonTabHost.this.c(ato);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.cwf.setVisibility(8);
                }
                if (CommonTabHost.this.bqk >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bqk);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void atv() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void atw() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aLe = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIL = new ArrayList<>();
        this.bqk = -1;
        this.ceL = -1;
        this.TU = 0;
        this.csN = R.color.common_color_10255;
        this.cvT = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.cwf.reset();
                CommonTabHost.this.cwf.setDatas(CommonTabHost.this.aIL);
                int size = CommonTabHost.this.aIL.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b ato = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aIL.get(i)).ato();
                    if (ato != null) {
                        z = true;
                        CommonTabHost.this.c(ato);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.cwf.setVisibility(8);
                }
                if (CommonTabHost.this.bqk >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bqk);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void atv() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void atw() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aLe = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.cvT);
        aVar.setEditorTools(this.TT);
        this.aIL.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.cwe = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.cwf = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.cwf.setOnTabSelectedListener(this);
        this.cwf.setEditorTools(this.TT);
        setOrientation(1);
        this.ceL = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ceL) {
            this.ceL = skinType;
            onChangeSkinType(this.ceL);
        }
        if (i != 8 && i != 4 && !this.aLe) {
            this.aLe = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aIL.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.cwf.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.cwf.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aIL.size()) {
            this.cwe.a(this.aIL.get(i));
            this.cwf.setCurrentTab(i);
            this.bqk = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void kE(int i) {
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
        am.h(this, this.csN, i);
        this.cwf.onChangeSkinType(i);
        this.cwe.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aIL.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
        if (this.aIL != null && this.aIL.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aIL.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.TT);
            }
        }
        if (this.cwf != null) {
            this.cwf.setEditorTools(this.TT);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
    }

    public void init() {
    }

    public void ql() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aIL.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.csN = i;
    }
}
