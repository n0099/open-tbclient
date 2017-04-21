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
    private int KN;
    private j KO;
    private a aBO;
    private int aBT;
    private CommonTabContentView aCb;
    private CommonTabWidgetView aCc;
    private boolean aCd;
    private ArrayList<b> abo;
    private int amZ;
    private int ayR;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Eu();

        void Ev();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.abo = new ArrayList<>();
        this.aBT = -1;
        this.amZ = -1;
        this.KN = 0;
        this.ayR = w.e.common_color_10255;
        this.aBO = new d(this);
        this.aCd = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.aBO);
        bVar.setEditorTools(this.KO);
        this.abo.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_host, (ViewGroup) this, true);
        this.aCb = (CommonTabContentView) findViewById(w.h.common_tab_content);
        this.aCc = (CommonTabWidgetView) findViewById(w.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(w.h.common_progress);
        this.aCc.setOnTabSelectedListener(this);
        this.aCc.setEditorTools(this.KO);
        setOrientation(1);
        this.amZ = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(w.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.amZ) {
            this.amZ = skinType;
            onChangeSkinType(this.amZ);
        }
        if (i != 8 && i != 4 && !this.aCd) {
            this.aCd = true;
            Iterator<b> it = this.abo.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0040b c0040b) {
        this.aCc.c(c0040b);
    }

    public void setShowDelete(boolean z) {
        this.aCc.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.abo.size()) {
            this.aCb.a(this.abo.get(i));
            this.aCc.setCurrentTab(i);
            this.aBT = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eQ(int i) {
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
        aq.e(this, this.ayR, i);
        this.aCc.onChangeSkinType(i);
        this.aCb.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.abo.iterator();
        while (it.hasNext()) {
            it.next().Dx();
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.KO = jVar;
        if (this.abo != null && this.abo.size() != 0) {
            Iterator<b> it = this.abo.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.KO);
            }
        }
        if (this.aCc != null) {
            this.aCc.setEditorTools(this.KO);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KO != null) {
            this.KO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KN = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KN;
    }

    public void init() {
    }

    public void mp() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.abo.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayR = i;
    }
}
