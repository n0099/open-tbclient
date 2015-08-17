package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends f implements CommonTabWidgetView.a {
    private int Ky;
    private j Kz;
    private ArrayList<com.baidu.tbadk.editortools.view.a> Xe;
    private int aoq;
    private int apH;
    private int apO;
    private a asB;
    private CommonTabContentView asH;
    private CommonTabWidgetView asI;
    private boolean asJ;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void BQ();

        void BR();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.Xe = new ArrayList<>();
        this.apO = -1;
        this.apH = -1;
        this.Ky = 0;
        this.aoq = i.c.editor_background;
        this.asB = new c(this);
        this.asJ = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.asB);
        aVar.setEditorTools(this.Kz);
        this.Xe.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.common_tab_host, (ViewGroup) this, true);
        this.asH = (CommonTabContentView) findViewById(i.f.common_tab_content);
        this.asI = (CommonTabWidgetView) findViewById(i.f.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(i.f.common_progress);
        this.asI.setOnTabSelectedListener(this);
        this.asI.setEditorTools(this.Kz);
        setOrientation(1);
        this.apH = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(i.c.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.apH) {
            this.apH = skinType;
            onChangeSkinType(this.apH);
        }
        if (i != 8 && i != 4 && !this.asJ) {
            this.asJ = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xe.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.asI.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.asI.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Xe.size()) {
            this.asH.a(this.Xe.get(i));
            this.asI.setCurrentTab(i);
            this.apO = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void dR(int i) {
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

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        al.d(this, this.aoq, i);
        this.asI.onChangeSkinType(i);
        this.asH.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xe.iterator();
        while (it.hasNext()) {
            it.next().AG();
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.Kz = jVar;
        if (this.Xe != null && this.Xe.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xe.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Kz);
            }
        }
        if (this.asI != null) {
            this.asI.setEditorTools(this.Kz);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Ky = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Ky;
    }

    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void oy() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xe.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aoq = i;
    }
}
