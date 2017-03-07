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
    private int Lk;
    private j Ll;
    private int aBB;
    private CommonTabContentView aBJ;
    private CommonTabWidgetView aBK;
    private boolean aBL;
    private a aBw;
    private ArrayList<b> aaY;
    private int amL;
    private int ayz;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DW();

        void DX();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.aaY = new ArrayList<>();
        this.aBB = -1;
        this.amL = -1;
        this.Lk = 0;
        this.ayz = w.e.common_color_10255;
        this.aBw = new d(this);
        this.aBL = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.aBw);
        bVar.setEditorTools(this.Ll);
        this.aaY.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_host, (ViewGroup) this, true);
        this.aBJ = (CommonTabContentView) findViewById(w.h.common_tab_content);
        this.aBK = (CommonTabWidgetView) findViewById(w.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(w.h.common_progress);
        this.aBK.setOnTabSelectedListener(this);
        this.aBK.setEditorTools(this.Ll);
        setOrientation(1);
        this.amL = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(w.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.amL) {
            this.amL = skinType;
            onChangeSkinType(this.amL);
        }
        if (i != 8 && i != 4 && !this.aBL) {
            this.aBL = true;
            Iterator<b> it = this.aaY.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0041b c0041b) {
        this.aBK.c(c0041b);
    }

    public void setShowDelete(boolean z) {
        this.aBK.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aaY.size()) {
            this.aBJ.a(this.aaY.get(i));
            this.aBK.setCurrentTab(i);
            this.aBB = i;
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
        aq.e(this, this.ayz, i);
        this.aBK.onChangeSkinType(i);
        this.aBJ.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.aaY.iterator();
        while (it.hasNext()) {
            it.next().CZ();
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Ll = jVar;
        if (this.aaY != null && this.aaY.size() != 0) {
            Iterator<b> it = this.aaY.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Ll);
            }
        }
        if (this.aBK != null) {
            this.aBK.setEditorTools(this.Ll);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ll != null) {
            this.Ll.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Lk = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Lk;
    }

    public void init() {
    }

    public void ml() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.aaY.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayz = i;
    }
}
