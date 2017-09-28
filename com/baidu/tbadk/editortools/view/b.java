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
    private int JF;
    private i JG;
    private int aAy;
    private a aDB;
    private int aDG;
    private CommonTabContentView aDO;
    private CommonTabWidgetView aDP;
    private boolean aDQ;
    private ArrayList<com.baidu.tbadk.editortools.view.a> abP;
    private int aoZ;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DH();

        void DI();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.abP = new ArrayList<>();
        this.aDG = -1;
        this.aoZ = -1;
        this.JF = 0;
        this.aAy = d.e.common_color_10255;
        this.aDB = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aDP.reset();
                b.this.aDP.setDatas(b.this.abP);
                int size = b.this.abP.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b DB = ((com.baidu.tbadk.editortools.view.a) b.this.abP.get(i)).DB();
                    if (DB != null) {
                        z = true;
                        b.this.c(DB);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aDP.setVisibility(8);
                }
                if (b.this.aDG >= 0) {
                    b.this.setCurrentTab(b.this.aDG);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void DH() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void DI() {
                b.this.hideProgressBar();
            }
        };
        this.aDQ = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aDB);
        aVar.setEditorTools(this.JG);
        this.abP.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_host, (ViewGroup) this, true);
        this.aDO = (CommonTabContentView) findViewById(d.h.common_tab_content);
        this.aDP = (CommonTabWidgetView) findViewById(d.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.h.common_progress);
        this.aDP.setOnTabSelectedListener(this);
        this.aDP.setEditorTools(this.JG);
        setOrientation(1);
        this.aoZ = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColor(d.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoZ) {
            this.aoZ = skinType;
            onChangeSkinType(this.aoZ);
        }
        if (i != 8 && i != 4 && !this.aDQ) {
            this.aDQ = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abP.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aDP.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aDP.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.abP.size()) {
            this.aDO.a(this.abP.get(i));
            this.aDP.setCurrentTab(i);
            this.aDG = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void fd(int i) {
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
        aj.e(this, this.aAy, i);
        this.aDP.onChangeSkinType(i);
        this.aDO.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.abP.iterator();
        while (it.hasNext()) {
            it.next().CK();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JG = iVar;
        if (this.abP != null && this.abP.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abP.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.JG);
            }
        }
        if (this.aDP != null) {
            this.aDP.setEditorTools(this.JG);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JG != null) {
            this.JG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JF = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JF;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.abP.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aAy = i;
    }
}
