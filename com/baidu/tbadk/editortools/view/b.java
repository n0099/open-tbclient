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
    private i IR;
    private int IS;
    private int aBL;
    private a aEN;
    private int aES;
    private CommonTabContentView aFa;
    private CommonTabWidgetView aFb;
    private boolean aFc;
    private ArrayList<com.baidu.tbadk.editortools.view.a> acr;
    private int apD;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void El();

        void Em();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.acr = new ArrayList<>();
        this.aES = -1;
        this.apD = -1;
        this.IS = 0;
        this.aBL = d.C0096d.common_color_10255;
        this.aEN = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aFb.reset();
                b.this.aFb.setDatas(b.this.acr);
                int size = b.this.acr.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Ef = ((com.baidu.tbadk.editortools.view.a) b.this.acr.get(i)).Ef();
                    if (Ef != null) {
                        z = true;
                        b.this.c(Ef);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aFb.setVisibility(8);
                }
                if (b.this.aES >= 0) {
                    b.this.setCurrentTab(b.this.aES);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void El() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Em() {
                b.this.hideProgressBar();
            }
        };
        this.aFc = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aEN);
        aVar.setEditorTools(this.IR);
        this.acr.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.aFa = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.aFb = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.aFb.setOnTabSelectedListener(this);
        this.aFb.setEditorTools(this.IR);
        setOrientation(1);
        this.apD = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0096d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apD) {
            this.apD = skinType;
            onChangeSkinType(this.apD);
        }
        if (i != 8 && i != 4 && !this.aFc) {
            this.aFc = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acr.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aFb.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aFb.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.acr.size()) {
            this.aFa.a(this.acr.get(i));
            this.aFb.setCurrentTab(i);
            this.aES = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void fb(int i) {
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
        aj.e(this, this.aBL, i);
        this.aFb.onChangeSkinType(i);
        this.aFa.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acr.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IR = iVar;
        if (this.acr != null && this.acr.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acr.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.IR);
            }
        }
        if (this.aFb != null) {
            this.aFb.setEditorTools(this.IR);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IR != null) {
            this.IR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IS;
    }

    public void init() {
    }

    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acr.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBL = i;
    }
}
