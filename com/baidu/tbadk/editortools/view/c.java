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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int EI;
    private l EJ;
    private ArrayList<b> Wt;
    private int ait;
    private int atW;
    private a axg;
    private int axl;
    private CommonTabContentView axt;
    private CommonTabWidgetView axu;
    private boolean axv;
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
        this.Wt = new ArrayList<>();
        this.axl = -1;
        this.ait = -1;
        this.EI = 0;
        this.atW = t.d.common_color_10255;
        this.axg = new d(this);
        this.axv = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.axg);
        bVar.setEditorTools(this.EJ);
        this.Wt.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.common_tab_host, (ViewGroup) this, true);
        this.axt = (CommonTabContentView) findViewById(t.g.common_tab_content);
        this.axu = (CommonTabWidgetView) findViewById(t.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(t.g.common_progress);
        this.axu.setOnTabSelectedListener(this);
        this.axu.setEditorTools(this.EJ);
        setOrientation(1);
        this.ait = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(t.d.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ait) {
            this.ait = skinType;
            onChangeSkinType(this.ait);
        }
        if (i != 8 && i != 4 && !this.axv) {
            this.axv = true;
            Iterator<b> it = this.Wt.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0042b c0042b) {
        this.axu.c(c0042b);
    }

    public void setShowDelete(boolean z) {
        this.axu.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Wt.size()) {
            this.axt.a(this.Wt.get(i));
            this.axu.setCurrentTab(i);
            this.axl = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eO(int i) {
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
        av.e(this, this.atW, i);
        this.axu.onChangeSkinType(i);
        this.axt.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.Wt.iterator();
        while (it.hasNext()) {
            it.next().CU();
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EJ = lVar;
        if (this.Wt != null && this.Wt.size() != 0) {
            Iterator<b> it = this.Wt.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.EJ);
            }
        }
        if (this.axu != null) {
            this.axu.setEditorTools(this.EJ);
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
        Iterator<b> it = this.Wt.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.atW = i;
    }
}
