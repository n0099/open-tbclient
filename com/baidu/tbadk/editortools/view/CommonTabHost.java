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
    private EditorTools TU;
    private int TV;
    private ArrayList<com.baidu.tbadk.editortools.view.a> aIn;
    private boolean aKG;
    private int bpM;
    private int cdL;
    private int crL;
    private a cuQ;
    private CommonTabContentView cvb;
    private CommonTabWidgetView cvc;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void ath();

        void ati();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.aIn = new ArrayList<>();
        this.bpM = -1;
        this.cdL = -1;
        this.TV = 0;
        this.crL = R.color.common_color_10255;
        this.cuQ = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.cvc.reset();
                CommonTabHost.this.cvc.setDatas(CommonTabHost.this.aIn);
                int size = CommonTabHost.this.aIn.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b ata = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aIn.get(i)).ata();
                    if (ata != null) {
                        z = true;
                        CommonTabHost.this.c(ata);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.cvc.setVisibility(8);
                }
                if (CommonTabHost.this.bpM >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bpM);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void ath() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void ati() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aKG = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIn = new ArrayList<>();
        this.bpM = -1;
        this.cdL = -1;
        this.TV = 0;
        this.crL = R.color.common_color_10255;
        this.cuQ = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.cvc.reset();
                CommonTabHost.this.cvc.setDatas(CommonTabHost.this.aIn);
                int size = CommonTabHost.this.aIn.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b ata = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aIn.get(i)).ata();
                    if (ata != null) {
                        z = true;
                        CommonTabHost.this.c(ata);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.cvc.setVisibility(8);
                }
                if (CommonTabHost.this.bpM >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bpM);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void ath() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void ati() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aKG = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.cuQ);
        aVar.setEditorTools(this.TU);
        this.aIn.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.cvb = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.cvc = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.cvc.setOnTabSelectedListener(this);
        this.cvc.setEditorTools(this.TU);
        setOrientation(1);
        this.cdL = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.cdL) {
            this.cdL = skinType;
            onChangeSkinType(this.cdL);
        }
        if (i != 8 && i != 4 && !this.aKG) {
            this.aKG = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aIn.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.cvc.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.cvc.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aIn.size()) {
            this.cvb.a(this.aIn.get(i));
            this.cvc.setCurrentTab(i);
            this.bpM = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void kA(int i) {
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
        am.h(this, this.crL, i);
        this.cvc.onChangeSkinType(i);
        this.cvb.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aIn.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
        if (this.aIn != null && this.aIn.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aIn.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.TU);
            }
        }
        if (this.cvc != null) {
            this.cvc.setEditorTools(this.TU);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    public void init() {
    }

    public void qk() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aIn.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.crL = i;
    }
}
