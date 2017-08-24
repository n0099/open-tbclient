package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends d implements CommonTabWidgetView.a {
    private int Ls;
    private i Lt;
    private int aBV;
    private a aEU;
    private int aEZ;
    private CommonTabContentView aFh;
    private CommonTabWidgetView aFi;
    private boolean aFj;
    private ArrayList<com.baidu.tbadk.editortools.view.a> acH;
    private int aqm;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Eg();

        void Eh();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.acH = new ArrayList<>();
        this.aEZ = -1;
        this.aqm = -1;
        this.Ls = 0;
        this.aBV = d.e.common_color_10255;
        this.aEU = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aFi.reset();
                b.this.aFi.setDatas(b.this.acH);
                int size = b.this.acH.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Ea = ((com.baidu.tbadk.editortools.view.a) b.this.acH.get(i)).Ea();
                    if (Ea != null) {
                        z = true;
                        b.this.c(Ea);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aFi.setVisibility(8);
                }
                if (b.this.aEZ >= 0) {
                    b.this.setCurrentTab(b.this.aEZ);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Eg() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Eh() {
                b.this.hideProgressBar();
            }
        };
        this.aFj = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aEU);
        aVar.setEditorTools(this.Lt);
        this.acH.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_host, (ViewGroup) this, true);
        this.aFh = (CommonTabContentView) findViewById(d.h.common_tab_content);
        this.aFi = (CommonTabWidgetView) findViewById(d.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.h.common_progress);
        this.aFi.setOnTabSelectedListener(this);
        this.aFi.setEditorTools(this.Lt);
        setOrientation(1);
        this.aqm = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColor(d.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aqm) {
            this.aqm = skinType;
            onChangeSkinType(this.aqm);
        }
        if (i != 8 && i != 4 && !this.aFj) {
            this.aFj = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acH.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aFi.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aFi.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.acH.size()) {
            this.aFh.a(this.acH.get(i));
            this.aFi.setCurrentTab(i);
            this.aEZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eT(int i) {
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
        ai.e(this, this.aBV, i);
        this.aFi.onChangeSkinType(i);
        this.aFh.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acH.iterator();
        while (it.hasNext()) {
            it.next().Dl();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lt = iVar;
        if (this.acH != null && this.acH.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acH.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Lt);
            }
        }
        if (this.aFi != null) {
            this.aFi.setEditorTools(this.Lt);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ls = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ls;
    }

    public void init() {
    }

    public void lS() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acH.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBV = i;
    }
}
