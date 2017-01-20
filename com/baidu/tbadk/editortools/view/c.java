package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int DW;
    private j DX;
    private ArrayList<b> VL;
    private int ahp;
    private int ate;
    private a awb;
    private int awg;
    private CommonTabContentView awo;
    private CommonTabWidgetView awp;
    private boolean awq;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DD();

        void DE();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.VL = new ArrayList<>();
        this.awg = -1;
        this.ahp = -1;
        this.DW = 0;
        this.ate = r.e.common_color_10255;
        this.awb = new d(this);
        this.awq = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.awb);
        bVar.setEditorTools(this.DX);
        this.VL.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(r.j.common_tab_host, (ViewGroup) this, true);
        this.awo = (CommonTabContentView) findViewById(r.h.common_tab_content);
        this.awp = (CommonTabWidgetView) findViewById(r.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(r.h.common_progress);
        this.awp.setOnTabSelectedListener(this);
        this.awp.setEditorTools(this.DX);
        setOrientation(1);
        this.ahp = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(r.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ahp) {
            this.ahp = skinType;
            onChangeSkinType(this.ahp);
        }
        if (i != 8 && i != 4 && !this.awq) {
            this.awq = true;
            Iterator<b> it = this.VL.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0042b c0042b) {
        this.awp.c(c0042b);
    }

    public void setShowDelete(boolean z) {
        this.awp.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.VL.size()) {
            this.awo.a(this.VL.get(i));
            this.awp.setCurrentTab(i);
            this.awg = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eS(int i) {
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
        ap.e(this, this.ate, i);
        this.awp.onChangeSkinType(i);
        this.awo.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.VL.iterator();
        while (it.hasNext()) {
            it.next().CG();
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.DX = jVar;
        if (this.VL != null && this.VL.size() != 0) {
            Iterator<b> it = this.VL.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.DX);
            }
        }
        if (this.awp != null) {
            this.awp.setEditorTools(this.DX);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.DX != null) {
            this.DX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.DW = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.DW;
    }

    public void init() {
    }

    public void lr() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.VL.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ate = i;
    }
}
