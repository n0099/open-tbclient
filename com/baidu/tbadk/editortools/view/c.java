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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int BV;
    private l BW;
    private ArrayList<b> SV;
    private int aeK;
    private int aqa;
    private a atk;
    private int atp;
    private CommonTabContentView atx;
    private CommonTabWidgetView aty;
    private boolean atz;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void CB();

        void CC();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.SV = new ArrayList<>();
        this.atp = -1;
        this.aeK = -1;
        this.BV = 0;
        this.aqa = u.d.common_color_10255;
        this.atk = new d(this);
        this.atz = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.atk);
        bVar.setEditorTools(this.BW);
        this.SV.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(u.h.common_tab_host, (ViewGroup) this, true);
        this.atx = (CommonTabContentView) findViewById(u.g.common_tab_content);
        this.aty = (CommonTabWidgetView) findViewById(u.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(u.g.common_progress);
        this.aty.setOnTabSelectedListener(this);
        this.aty.setEditorTools(this.BW);
        setOrientation(1);
        this.aeK = TbadkCoreApplication.m9getInst().getSkinType();
        setBackgroundColor(u.d.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aeK) {
            this.aeK = skinType;
            onChangeSkinType(this.aeK);
        }
        if (i != 8 && i != 4 && !this.atz) {
            this.atz = true;
            Iterator<b> it = this.SV.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0041b c0041b) {
        this.aty.c(c0041b);
    }

    public void setShowDelete(boolean z) {
        this.aty.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.SV.size()) {
            this.atx.a(this.SV.get(i));
            this.aty.setCurrentTab(i);
            this.atp = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eA(int i) {
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
        av.e(this, this.aqa, i);
        this.aty.onChangeSkinType(i);
        this.atx.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.SV.iterator();
        while (it.hasNext()) {
            it.next().Bz();
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.BW = lVar;
        if (this.SV != null && this.SV.size() != 0) {
            Iterator<b> it = this.SV.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.BW);
            }
        }
        if (this.aty != null) {
            this.aty.setEditorTools(this.BW);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BW != null) {
            this.BW.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BV = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BV;
    }

    public void init() {
    }

    public void kF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.SV.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aqa = i;
    }
}
