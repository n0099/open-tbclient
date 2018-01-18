package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends d implements CommonTabWidgetView.a {
    private ArrayList<com.baidu.tbadk.editortools.view.a> aQG;
    private i axN;
    private int axO;
    private int bdK;
    private int bpS;
    private a bsR;
    private int bsW;
    private CommonTabContentView bte;
    private CommonTabWidgetView btf;
    private boolean btg;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void LA();

        void LB();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.aQG = new ArrayList<>();
        this.bsW = -1;
        this.bdK = -1;
        this.axO = 0;
        this.bpS = d.C0107d.common_color_10255;
        this.bsR = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.btf.reset();
                b.this.btf.setDatas(b.this.aQG);
                int size = b.this.aQG.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Lu = ((com.baidu.tbadk.editortools.view.a) b.this.aQG.get(i)).Lu();
                    if (Lu != null) {
                        z = true;
                        b.this.c(Lu);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.btf.setVisibility(8);
                }
                if (b.this.bsW >= 0) {
                    b.this.setCurrentTab(b.this.bsW);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void LA() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void LB() {
                b.this.hideProgressBar();
            }
        };
        this.btg = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.bsR);
        aVar.setEditorTools(this.axN);
        this.aQG.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.bte = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.btf = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.btf.setOnTabSelectedListener(this);
        this.btf.setEditorTools(this.axN);
        setOrientation(1);
        this.bdK = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0107d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bdK) {
            this.bdK = skinType;
            onChangeSkinType(this.bdK);
        }
        if (i != 8 && i != 4 && !this.btg) {
            this.btg = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQG.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.btf.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.btf.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aQG.size()) {
            this.bte.a(this.aQG.get(i));
            this.btf.setCurrentTab(i);
            this.bsW = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void hV(int i) {
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

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.g(this, this.bpS, i);
        this.btf.onChangeSkinType(i);
        this.bte.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQG.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axN = iVar;
        if (this.aQG != null && this.aQG.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQG.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.axN);
            }
        }
        if (this.btf != null) {
            this.btf.setEditorTools(this.axN);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axN != null) {
            this.axN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axO = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axO;
    }

    public void init() {
    }

    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQG.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bpS = i;
    }
}
