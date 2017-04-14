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
    private int KL;
    private j KM;
    private a aBM;
    private int aBR;
    private CommonTabContentView aBZ;
    private CommonTabWidgetView aCa;
    private boolean aCb;
    private ArrayList<b> abn;
    private int amZ;
    private int ayP;
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
        this.abn = new ArrayList<>();
        this.aBR = -1;
        this.amZ = -1;
        this.KL = 0;
        this.ayP = w.e.common_color_10255;
        this.aBM = new d(this);
        this.aCb = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.aBM);
        bVar.setEditorTools(this.KM);
        this.abn.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_host, (ViewGroup) this, true);
        this.aBZ = (CommonTabContentView) findViewById(w.h.common_tab_content);
        this.aCa = (CommonTabWidgetView) findViewById(w.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(w.h.common_progress);
        this.aCa.setOnTabSelectedListener(this);
        this.aCa.setEditorTools(this.KM);
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
        if (i != 8 && i != 4 && !this.aCb) {
            this.aCb = true;
            Iterator<b> it = this.abn.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0040b c0040b) {
        this.aCa.c(c0040b);
    }

    public void setShowDelete(boolean z) {
        this.aCa.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.abn.size()) {
            this.aBZ.a(this.abn.get(i));
            this.aCa.setCurrentTab(i);
            this.aBR = i;
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
        aq.e(this, this.ayP, i);
        this.aCa.onChangeSkinType(i);
        this.aBZ.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.abn.iterator();
        while (it.hasNext()) {
            it.next().Dx();
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.KM = jVar;
        if (this.abn != null && this.abn.size() != 0) {
            Iterator<b> it = this.abn.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.KM);
            }
        }
        if (this.aCa != null) {
            this.aCa.setEditorTools(this.KM);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KM != null) {
            this.KM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KL;
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
        Iterator<b> it = this.abn.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayP = i;
    }
}
