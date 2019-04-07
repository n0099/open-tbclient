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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools VN;
    private int VO;
    private ArrayList<com.baidu.tbadk.editortools.view.a> aFL;
    private boolean aIe;
    private int bUM;
    private int biV;
    private int cio;
    private CommonTabContentView clC;
    private CommonTabWidgetView clD;
    private a clr;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void amX();

        void amY();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.aFL = new ArrayList<>();
        this.biV = -1;
        this.bUM = -1;
        this.VO = 0;
        this.cio = d.C0277d.common_color_10255;
        this.clr = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.clD.reset();
                CommonTabHost.this.clD.setDatas(CommonTabHost.this.aFL);
                int size = CommonTabHost.this.aFL.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b amR = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aFL.get(i)).amR();
                    if (amR != null) {
                        z = true;
                        CommonTabHost.this.c(amR);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.clD.setVisibility(8);
                }
                if (CommonTabHost.this.biV >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.biV);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amX() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amY() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aIe = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFL = new ArrayList<>();
        this.biV = -1;
        this.bUM = -1;
        this.VO = 0;
        this.cio = d.C0277d.common_color_10255;
        this.clr = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.clD.reset();
                CommonTabHost.this.clD.setDatas(CommonTabHost.this.aFL);
                int size = CommonTabHost.this.aFL.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b amR = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.aFL.get(i)).amR();
                    if (amR != null) {
                        z = true;
                        CommonTabHost.this.c(amR);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.clD.setVisibility(8);
                }
                if (CommonTabHost.this.biV >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.biV);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amX() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void amY() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.aIe = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.clr);
        aVar.setEditorTools(this.VN);
        this.aFL.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.clC = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.clD = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.clD.setOnTabSelectedListener(this);
        this.clD.setEditorTools(this.VN);
        setOrientation(1);
        this.bUM = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0277d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bUM) {
            this.bUM = skinType;
            onChangeSkinType(this.bUM);
        }
        if (i != 8 && i != 4 && !this.aIe) {
            this.aIe = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFL.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.clD.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.clD.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aFL.size()) {
            this.clC.a(this.aFL.get(i));
            this.clD.setCurrentTab(i);
            this.biV = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void jG(int i) {
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
        al.f(this, this.cio, i);
        this.clD.onChangeSkinType(i);
        this.clC.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFL.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
        if (this.aFL != null && this.aFL.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFL.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.VN);
            }
        }
        if (this.clD != null) {
            this.clD.setEditorTools(this.VN);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    public void init() {
    }

    public void qT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aFL.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cio = i;
    }
}
