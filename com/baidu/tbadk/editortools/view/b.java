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
    private ArrayList<com.baidu.tbadk.editortools.view.a> aRZ;
    private i axH;
    private int axI;
    private int bfC;
    private int bse;
    private a bvd;
    private int bvi;
    private CommonTabContentView bvq;
    private CommonTabWidgetView bvr;
    private boolean bvs;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Mi();

        void Mj();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.aRZ = new ArrayList<>();
        this.bvi = -1;
        this.bfC = -1;
        this.axI = 0;
        this.bse = d.C0141d.common_color_10255;
        this.bvd = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.bvr.reset();
                b.this.bvr.setDatas(b.this.aRZ);
                int size = b.this.aRZ.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Mc = ((com.baidu.tbadk.editortools.view.a) b.this.aRZ.get(i)).Mc();
                    if (Mc != null) {
                        z = true;
                        b.this.c(Mc);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.bvr.setVisibility(8);
                }
                if (b.this.bvi >= 0) {
                    b.this.setCurrentTab(b.this.bvi);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Mi() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Mj() {
                b.this.hideProgressBar();
            }
        };
        this.bvs = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.bvd);
        aVar.setEditorTools(this.axH);
        this.aRZ.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.bvq = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.bvr = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.bvr.setOnTabSelectedListener(this);
        this.bvr.setEditorTools(this.axH);
        setOrientation(1);
        this.bfC = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0141d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bfC) {
            this.bfC = skinType;
            onChangeSkinType(this.bfC);
        }
        if (i != 8 && i != 4 && !this.bvs) {
            this.bvs = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aRZ.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.bvr.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.bvr.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aRZ.size()) {
            this.bvq.a(this.aRZ.get(i));
            this.bvr.setCurrentTab(i);
            this.bvi = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void hT(int i) {
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
        aj.g(this, this.bse, i);
        this.bvr.onChangeSkinType(i);
        this.bvq.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aRZ.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axH = iVar;
        if (this.aRZ != null && this.aRZ.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aRZ.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.axH);
            }
        }
        if (this.bvr != null) {
            this.bvr.setEditorTools(this.axH);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axI;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aRZ.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bse = i;
    }
}
