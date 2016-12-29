package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int EL;
    private j EM;
    private ArrayList<b> Wv;
    private int aib;
    private int atZ;
    private a awX;
    private int axc;
    private CommonTabContentView axk;
    private CommonTabWidgetView axl;
    private boolean axm;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DI();

        void DJ();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.Wv = new ArrayList<>();
        this.axc = -1;
        this.aib = -1;
        this.EL = 0;
        this.atZ = r.d.common_color_10255;
        this.awX = new d(this);
        this.axm = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.awX);
        bVar.setEditorTools(this.EM);
        this.Wv.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.common_tab_host, (ViewGroup) this, true);
        this.axk = (CommonTabContentView) findViewById(r.g.common_tab_content);
        this.axl = (CommonTabWidgetView) findViewById(r.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(r.g.common_progress);
        this.axl.setOnTabSelectedListener(this);
        this.axl.setEditorTools(this.EM);
        setOrientation(1);
        this.aib = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(r.d.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aib) {
            this.aib = skinType;
            onChangeSkinType(this.aib);
        }
        if (i != 8 && i != 4 && !this.axm) {
            this.axm = true;
            Iterator<b> it = this.Wv.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0042b c0042b) {
        this.axl.c(c0042b);
    }

    public void setShowDelete(boolean z) {
        this.axl.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Wv.size()) {
            this.axk.a(this.Wv.get(i));
            this.axl.setCurrentTab(i);
            this.axc = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eR(int i) {
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
        ar.e(this, this.atZ, i);
        this.axl.onChangeSkinType(i);
        this.axk.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.Wv.iterator();
        while (it.hasNext()) {
            it.next().CL();
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.EM = jVar;
        if (this.Wv != null && this.Wv.size() != 0) {
            Iterator<b> it = this.Wv.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.EM);
            }
        }
        if (this.axl != null) {
            this.axl.setEditorTools(this.EM);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EM != null) {
            this.EM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.EL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.EL;
    }

    public void init() {
    }

    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.Wv.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.atZ = i;
    }
}
