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
    private int JT;
    private j JU;
    private a aBA;
    private int aBF;
    private CommonTabContentView aBN;
    private CommonTabWidgetView aBO;
    private boolean aBP;
    private ArrayList<b> aaI;
    private int ana;
    private int ayA;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Ds();

        void Dt();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.aaI = new ArrayList<>();
        this.aBF = -1;
        this.ana = -1;
        this.JT = 0;
        this.ayA = w.e.common_color_10255;
        this.aBA = new d(this);
        this.aBP = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.aBA);
        bVar.setEditorTools(this.JU);
        this.aaI.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_host, (ViewGroup) this, true);
        this.aBN = (CommonTabContentView) findViewById(w.h.common_tab_content);
        this.aBO = (CommonTabWidgetView) findViewById(w.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(w.h.common_progress);
        this.aBO.setOnTabSelectedListener(this);
        this.aBO.setEditorTools(this.JU);
        setOrientation(1);
        this.ana = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(w.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ana) {
            this.ana = skinType;
            onChangeSkinType(this.ana);
        }
        if (i != 8 && i != 4 && !this.aBP) {
            this.aBP = true;
            Iterator<b> it = this.aaI.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0044b c0044b) {
        this.aBO.c(c0044b);
    }

    public void setShowDelete(boolean z) {
        this.aBO.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aaI.size()) {
            this.aBN.a(this.aaI.get(i));
            this.aBO.setCurrentTab(i);
            this.aBF = i;
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

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.e(this, this.ayA, i);
        this.aBO.onChangeSkinType(i);
        this.aBN.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.aaI.iterator();
        while (it.hasNext()) {
            it.next().Cw();
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JU = jVar;
        if (this.aaI != null && this.aaI.size() != 0) {
            Iterator<b> it = this.aaI.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.JU);
            }
        }
        if (this.aBO != null) {
            this.aBO.setEditorTools(this.JU);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JT;
    }

    public void init() {
    }

    public void lO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.aaI.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayA = i;
    }
}
