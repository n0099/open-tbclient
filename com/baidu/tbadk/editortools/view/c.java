package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int LD;
    private l LE;
    private ArrayList<b> Xq;
    private int aik;
    private int atu;
    private CommonTabContentView awG;
    private CommonTabWidgetView awH;
    private boolean awI;
    private a awt;
    private int awy;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void EA();

        void Ez();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.Xq = new ArrayList<>();
        this.awy = -1;
        this.aik = -1;
        this.LD = 0;
        this.atu = t.d.editor_background;
        this.awt = new d(this);
        this.awI = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.awt);
        bVar.setEditorTools(this.LE);
        this.Xq.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.common_tab_host, (ViewGroup) this, true);
        this.awG = (CommonTabContentView) findViewById(t.g.common_tab_content);
        this.awH = (CommonTabWidgetView) findViewById(t.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(t.g.common_progress);
        this.awH.setOnTabSelectedListener(this);
        this.awH.setEditorTools(this.LE);
        setOrientation(1);
        this.aik = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(t.d.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.aik) {
            this.aik = skinType;
            onChangeSkinType(this.aik);
        }
        if (i != 8 && i != 4 && !this.awI) {
            this.awI = true;
            Iterator<b> it = this.Xq.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0050b c0050b) {
        this.awH.c(c0050b);
    }

    public void setShowDelete(boolean z) {
        this.awH.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Xq.size()) {
            this.awG.a(this.Xq.get(i));
            this.awH.setCurrentTab(i);
            this.awy = i;
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

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        at.d(this, this.atu, i);
        this.awH.onChangeSkinType(i);
        this.awG.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.Xq.iterator();
        while (it.hasNext()) {
            it.next().Dv();
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.LE = lVar;
        if (this.Xq != null && this.Xq.size() != 0) {
            Iterator<b> it = this.Xq.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.LE);
            }
        }
        if (this.awH != null) {
            this.awH.setEditorTools(this.LE);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.LE != null) {
            this.LE.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.LD = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.LD;
    }

    public void init() {
    }

    public void op() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.Xq.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.atu = i;
    }
}
