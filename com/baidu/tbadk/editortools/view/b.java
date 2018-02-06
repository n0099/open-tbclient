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
    private ArrayList<com.baidu.tbadk.editortools.view.a> aSi;
    private i axP;
    private int axQ;
    private int bfL;
    private int bso;
    private CommonTabContentView bvA;
    private CommonTabWidgetView bvB;
    private boolean bvC;
    private a bvn;
    private int bvs;
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
        this.aSi = new ArrayList<>();
        this.bvs = -1;
        this.bfL = -1;
        this.axQ = 0;
        this.bso = d.C0140d.common_color_10255;
        this.bvn = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.bvB.reset();
                b.this.bvB.setDatas(b.this.aSi);
                int size = b.this.aSi.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Mc = ((com.baidu.tbadk.editortools.view.a) b.this.aSi.get(i)).Mc();
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
                    b.this.bvB.setVisibility(8);
                }
                if (b.this.bvs >= 0) {
                    b.this.setCurrentTab(b.this.bvs);
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
        this.bvC = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.bvn);
        aVar.setEditorTools(this.axP);
        this.aSi.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.bvA = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.bvB = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.bvB.setOnTabSelectedListener(this);
        this.bvB.setEditorTools(this.axP);
        setOrientation(1);
        this.bfL = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0140d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bfL) {
            this.bfL = skinType;
            onChangeSkinType(this.bfL);
        }
        if (i != 8 && i != 4 && !this.bvC) {
            this.bvC = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aSi.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.bvB.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.bvB.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aSi.size()) {
            this.bvA.a(this.aSi.get(i));
            this.bvB.setCurrentTab(i);
            this.bvs = i;
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
        aj.g(this, this.bso, i);
        this.bvB.onChangeSkinType(i);
        this.bvA.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aSi.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axP = iVar;
        if (this.aSi != null && this.aSi.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aSi.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.axP);
            }
        }
        if (this.bvB != null) {
            this.bvB.setEditorTools(this.axP);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aSi.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bso = i;
    }
}
