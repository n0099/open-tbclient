package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int EI;
    private l EJ;
    private ArrayList<b> WD;
    private int ahV;
    private int atA;
    private a awJ;
    private int awO;
    private CommonTabContentView awW;
    private CommonTabWidgetView awX;
    private boolean awY;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DV();

        void DW();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.WD = new ArrayList<>();
        this.awO = -1;
        this.ahV = -1;
        this.EI = 0;
        this.atA = r.d.common_color_10255;
        this.awJ = new d(this);
        this.awY = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.awJ);
        bVar.setEditorTools(this.EJ);
        this.WD.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.common_tab_host, (ViewGroup) this, true);
        this.awW = (CommonTabContentView) findViewById(r.g.common_tab_content);
        this.awX = (CommonTabWidgetView) findViewById(r.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(r.g.common_progress);
        this.awX.setOnTabSelectedListener(this);
        this.awX.setEditorTools(this.EJ);
        setOrientation(1);
        this.ahV = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(r.d.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ahV) {
            this.ahV = skinType;
            onChangeSkinType(this.ahV);
        }
        if (i != 8 && i != 4 && !this.awY) {
            this.awY = true;
            Iterator<b> it = this.WD.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0042b c0042b) {
        this.awX.c(c0042b);
    }

    public void setShowDelete(boolean z) {
        this.awX.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.WD.size()) {
            this.awW.a(this.WD.get(i));
            this.awX.setCurrentTab(i);
            this.awO = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eN(int i) {
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

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        av.e(this, this.atA, i);
        this.awX.onChangeSkinType(i);
        this.awW.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.WD.iterator();
        while (it.hasNext()) {
            it.next().CU();
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EJ = lVar;
        if (this.WD != null && this.WD.size() != 0) {
            Iterator<b> it = this.WD.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.EJ);
            }
        }
        if (this.awX != null) {
            this.awX.setEditorTools(this.EJ);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EI = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EI;
    }

    public void init() {
    }

    public void lw() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.WD.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.atA = i;
    }
}
