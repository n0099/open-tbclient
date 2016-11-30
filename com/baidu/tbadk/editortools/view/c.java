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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int EK;
    private l EL;
    private ArrayList<b> Xb;
    private int aiA;
    private int auu;
    private a axA;
    private int axF;
    private CommonTabContentView axN;
    private CommonTabWidgetView axO;
    private boolean axP;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Ea();

        void Eb();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.Xb = new ArrayList<>();
        this.axF = -1;
        this.aiA = -1;
        this.EK = 0;
        this.auu = r.d.common_color_10255;
        this.axA = new d(this);
        this.axP = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.axA);
        bVar.setEditorTools(this.EL);
        this.Xb.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.common_tab_host, (ViewGroup) this, true);
        this.axN = (CommonTabContentView) findViewById(r.g.common_tab_content);
        this.axO = (CommonTabWidgetView) findViewById(r.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(r.g.common_progress);
        this.axO.setOnTabSelectedListener(this);
        this.axO.setEditorTools(this.EL);
        setOrientation(1);
        this.aiA = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(r.d.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aiA) {
            this.aiA = skinType;
            onChangeSkinType(this.aiA);
        }
        if (i != 8 && i != 4 && !this.axP) {
            this.axP = true;
            Iterator<b> it = this.Xb.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0042b c0042b) {
        this.axO.c(c0042b);
    }

    public void setShowDelete(boolean z) {
        this.axO.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Xb.size()) {
            this.axN.a(this.Xb.get(i));
            this.axO.setCurrentTab(i);
            this.axF = i;
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
        at.e(this, this.auu, i);
        this.axO.onChangeSkinType(i);
        this.axN.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.Xb.iterator();
        while (it.hasNext()) {
            it.next().Dc();
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EL = lVar;
        if (this.Xb != null && this.Xb.size() != 0) {
            Iterator<b> it = this.Xb.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.EL);
            }
        }
        if (this.axO != null) {
            this.axO.setEditorTools(this.EL);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EK = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EK;
    }

    public void init() {
    }

    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.Xb.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.auu = i;
    }
}
