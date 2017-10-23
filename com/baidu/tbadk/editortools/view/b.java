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
    private int JG;
    private i JH;
    private int aAm;
    private CommonTabContentView aDB;
    private CommonTabWidgetView aDC;
    private boolean aDD;
    private a aDo;
    private int aDt;
    private ArrayList<com.baidu.tbadk.editortools.view.a> abD;
    private int aoN;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DB();

        void DC();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.abD = new ArrayList<>();
        this.aDt = -1;
        this.aoN = -1;
        this.JG = 0;
        this.aAm = d.e.common_color_10255;
        this.aDo = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aDC.reset();
                b.this.aDC.setDatas(b.this.abD);
                int size = b.this.abD.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Dv = ((com.baidu.tbadk.editortools.view.a) b.this.abD.get(i)).Dv();
                    if (Dv != null) {
                        z = true;
                        b.this.c(Dv);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aDC.setVisibility(8);
                }
                if (b.this.aDt >= 0) {
                    b.this.setCurrentTab(b.this.aDt);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void DB() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void DC() {
                b.this.hideProgressBar();
            }
        };
        this.aDD = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aDo);
        aVar.setEditorTools(this.JH);
        this.abD.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_host, (ViewGroup) this, true);
        this.aDB = (CommonTabContentView) findViewById(d.h.common_tab_content);
        this.aDC = (CommonTabWidgetView) findViewById(d.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.h.common_progress);
        this.aDC.setOnTabSelectedListener(this);
        this.aDC.setEditorTools(this.JH);
        setOrientation(1);
        this.aoN = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColor(d.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoN) {
            this.aoN = skinType;
            onChangeSkinType(this.aoN);
        }
        if (i != 8 && i != 4 && !this.aDD) {
            this.aDD = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abD.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aDC.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aDC.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.abD.size()) {
            this.aDB.a(this.abD.get(i));
            this.aDC.setCurrentTab(i);
            this.aDt = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void fc(int i) {
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
        aj.e(this, this.aAm, i);
        this.aDC.onChangeSkinType(i);
        this.aDB.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.abD.iterator();
        while (it.hasNext()) {
            it.next().CE();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JH = iVar;
        if (this.abD != null && this.abD.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abD.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.JH);
            }
        }
        if (this.aDC != null) {
            this.aDC.setEditorTools(this.JH);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JG = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JG;
    }

    public void init() {
    }

    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.abD.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aAm = i;
    }
}
