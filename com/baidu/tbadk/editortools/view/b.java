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
    private int Ja;
    private i Jb;
    private int aAX;
    private a aDZ;
    private int aEe;
    private CommonTabContentView aEm;
    private CommonTabWidgetView aEn;
    private boolean aEo;
    private ArrayList<com.baidu.tbadk.editortools.view.a> acc;
    private int api;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DQ();

        void DR();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.acc = new ArrayList<>();
        this.aEe = -1;
        this.api = -1;
        this.Ja = 0;
        this.aAX = d.C0080d.common_color_10255;
        this.aDZ = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aEn.reset();
                b.this.aEn.setDatas(b.this.acc);
                int size = b.this.acc.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b DK = ((com.baidu.tbadk.editortools.view.a) b.this.acc.get(i)).DK();
                    if (DK != null) {
                        z = true;
                        b.this.c(DK);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aEn.setVisibility(8);
                }
                if (b.this.aEe >= 0) {
                    b.this.setCurrentTab(b.this.aEe);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void DQ() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void DR() {
                b.this.hideProgressBar();
            }
        };
        this.aEo = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aDZ);
        aVar.setEditorTools(this.Jb);
        this.acc.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.aEm = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.aEn = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.aEn.setOnTabSelectedListener(this);
        this.aEn.setEditorTools(this.Jb);
        setOrientation(1);
        this.api = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColor(d.C0080d.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.api) {
            this.api = skinType;
            onChangeSkinType(this.api);
        }
        if (i != 8 && i != 4 && !this.aEo) {
            this.aEo = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acc.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aEn.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aEn.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.acc.size()) {
            this.aEm.a(this.acc.get(i));
            this.aEn.setCurrentTab(i);
            this.aEe = i;
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
        aj.e(this, this.aAX, i);
        this.aEn.onChangeSkinType(i);
        this.aEm.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acc.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jb = iVar;
        if (this.acc != null && this.acc.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.acc.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Jb);
            }
        }
        if (this.aEn != null) {
            this.aEn.setEditorTools(this.Jb);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
    }

    public void init() {
    }

    public void lG() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.acc.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aAX = i;
    }
}
