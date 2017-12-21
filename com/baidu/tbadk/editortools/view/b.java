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
    private i IS;
    private int IT;
    private int aBO;
    private a aEQ;
    private int aEV;
    private CommonTabContentView aFd;
    private CommonTabWidgetView aFe;
    private boolean aFf;
    private ArrayList<com.baidu.tbadk.editortools.view.a> acu;
    private int apG;
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
        this.acu = new ArrayList<>();
        this.aEV = -1;
        this.apG = -1;
        this.IT = 0;
        this.aBO = d.C0095d.common_color_10255;
        this.aEQ = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aFe.reset();
                b.this.aFe.setDatas(b.this.acu);
                int size = b.this.acu.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Ef = ((com.baidu.tbadk.editortools.view.a) b.this.acu.get(i)).Ef();
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
                    b.this.aFe.setVisibility(8);
                }
                if (b.this.aEV >= 0) {
                    b.this.setCurrentTab(b.this.aEV);
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
        this.aFf = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aEQ);
        aVar.setEditorTools(this.IS);
        this.acu.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.aFd = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.aFe = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.aFe.setOnTabSelectedListener(this);
        this.aFe.setEditorTools(this.IS);
        setOrientation(1);
        this.apG = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0095d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apG) {
            this.apG = skinType;
            onChangeSkinType(this.apG);
        }
        if (i != 8 && i != 4 && !this.aFf) {
            this.aFf = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acu.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aFe.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aFe.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.acu.size()) {
            this.aFd.a(this.acu.get(i));
            this.aFe.setCurrentTab(i);
            this.aEV = i;
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
        aj.e(this, this.aBO, i);
        this.aFe.onChangeSkinType(i);
        this.aFd.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acu.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IS = iVar;
        if (this.acu != null && this.acu.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acu.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.IS);
            }
        }
        if (this.aFe != null) {
            this.aFe.setEditorTools(this.IS);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IT = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IT;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acu.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBO = i;
    }
}
