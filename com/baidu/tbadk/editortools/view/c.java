package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int Kf;
    private j Kg;
    private a aBN;
    private int aBS;
    private CommonTabContentView aCa;
    private CommonTabWidgetView aCb;
    private boolean aCc;
    private ArrayList<b> aaJ;
    private int ane;
    private int ayO;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Dy();

        void Dz();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.aaJ = new ArrayList<>();
        this.aBS = -1;
        this.ane = -1;
        this.Kf = 0;
        this.ayO = w.e.common_color_10255;
        this.aBN = new d(this);
        this.aCc = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.aBN);
        bVar.setEditorTools(this.Kg);
        this.aaJ.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_host, (ViewGroup) this, true);
        this.aCa = (CommonTabContentView) findViewById(w.h.common_tab_content);
        this.aCb = (CommonTabWidgetView) findViewById(w.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(w.h.common_progress);
        this.aCb.setOnTabSelectedListener(this);
        this.aCb.setEditorTools(this.Kg);
        setOrientation(1);
        this.ane = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(w.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ane) {
            this.ane = skinType;
            onChangeSkinType(this.ane);
        }
        if (i != 8 && i != 4 && !this.aCc) {
            this.aCc = true;
            Iterator<b> it = this.aaJ.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0044b c0044b) {
        this.aCb.c(c0044b);
    }

    public void setShowDelete(boolean z) {
        this.aCb.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aaJ.size()) {
            this.aCa.a(this.aaJ.get(i));
            this.aCb.setCurrentTab(i);
            this.aBS = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eM(int i) {
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

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.e(this, this.ayO, i);
        this.aCb.onChangeSkinType(i);
        this.aCa.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.aaJ.iterator();
        while (it.hasNext()) {
            it.next().CC();
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Kg = jVar;
        if (this.aaJ != null && this.aaJ.size() != 0) {
            Iterator<b> it = this.aaJ.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Kg);
            }
        }
        if (this.aCb != null) {
            this.aCb.setEditorTools(this.Kg);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
    }

    public void init() {
    }

    public void lW() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.aaJ.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayO = i;
    }
}
