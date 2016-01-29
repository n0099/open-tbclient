package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends f implements CommonTabWidgetView.a {
    private int Lw;
    private k Lx;
    private ArrayList<com.baidu.tbadk.editortools.view.a> YX;
    private int ahU;
    private int asV;
    private a avN;
    private int avR;
    private CommonTabContentView avZ;
    private CommonTabWidgetView awa;
    private boolean awb;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DN();

        void DO();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.YX = new ArrayList<>();
        this.avR = -1;
        this.ahU = -1;
        this.Lw = 0;
        this.asV = t.d.editor_background;
        this.avN = new c(this);
        this.awb = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.avN);
        aVar.setEditorTools(this.Lx);
        this.YX.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.common_tab_host, (ViewGroup) this, true);
        this.avZ = (CommonTabContentView) findViewById(t.g.common_tab_content);
        this.awa = (CommonTabWidgetView) findViewById(t.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(t.g.common_progress);
        this.awa.setOnTabSelectedListener(this);
        this.awa.setEditorTools(this.Lx);
        setOrientation(1);
        this.ahU = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(t.d.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahU) {
            this.ahU = skinType;
            onChangeSkinType(this.ahU);
        }
        if (i != 8 && i != 4 && !this.awb) {
            this.awb = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.YX.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.awa.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.awa.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.YX.size()) {
            this.avZ.a(this.YX.get(i));
            this.awa.setCurrentTab(i);
            this.avR = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eK(int i) {
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

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        ar.d(this, this.asV, i);
        this.awa.onChangeSkinType(i);
        this.avZ.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.YX.iterator();
        while (it.hasNext()) {
            it.next().CM();
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.Lx = kVar;
        if (this.YX != null && this.YX.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.YX.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Lx);
            }
        }
        if (this.awa != null) {
            this.awa.setEditorTools(this.Lx);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lx != null) {
            this.Lx.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lw = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lw;
    }

    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.YX.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.asV = i;
    }
}
