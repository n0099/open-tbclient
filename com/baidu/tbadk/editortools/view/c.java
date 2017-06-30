package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int JS;
    private j JT;
    private a aCD;
    private int aCI;
    private CommonTabContentView aCQ;
    private CommonTabWidgetView aCR;
    private boolean aCS;
    private ArrayList<b> aaJ;
    private int aoa;
    private int azC;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DM();

        void DN();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.aaJ = new ArrayList<>();
        this.aCI = -1;
        this.aoa = -1;
        this.JS = 0;
        this.azC = w.e.common_color_10255;
        this.aCD = new d(this);
        this.aCS = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.aCD);
        bVar.setEditorTools(this.JT);
        this.aaJ.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_host, (ViewGroup) this, true);
        this.aCQ = (CommonTabContentView) findViewById(w.h.common_tab_content);
        this.aCR = (CommonTabWidgetView) findViewById(w.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(w.h.common_progress);
        this.aCR.setOnTabSelectedListener(this);
        this.aCR.setEditorTools(this.JT);
        setOrientation(1);
        this.aoa = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(w.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aoa) {
            this.aoa = skinType;
            onChangeSkinType(this.aoa);
        }
        if (i != 8 && i != 4 && !this.aCS) {
            this.aCS = true;
            Iterator<b> it = this.aaJ.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0046b c0046b) {
        this.aCR.c(c0046b);
    }

    public void setShowDelete(boolean z) {
        this.aCR.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aaJ.size()) {
            this.aCQ.a(this.aaJ.get(i));
            this.aCR.setCurrentTab(i);
            this.aCI = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eP(int i) {
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
        as.e(this, this.azC, i);
        this.aCR.onChangeSkinType(i);
        this.aCQ.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.aaJ.iterator();
        while (it.hasNext()) {
            it.next().CR();
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JT = jVar;
        if (this.aaJ != null && this.aaJ.size() != 0) {
            Iterator<b> it = this.aaJ.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.JT);
            }
        }
        if (this.aCR != null) {
            this.aCR.setEditorTools(this.JT);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JS;
    }

    public void init() {
    }

    public void lM() {
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
        this.azC = i;
    }
}
