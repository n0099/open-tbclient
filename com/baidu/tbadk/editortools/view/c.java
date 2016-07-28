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
    private int Cv;
    private l Cw;
    private ArrayList<b> TD;
    private int afy;
    private int aqP;
    private a atZ;
    private int aue;
    private CommonTabContentView aum;
    private CommonTabWidgetView aun;
    private boolean auo;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void CA();

        void CB();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.TD = new ArrayList<>();
        this.aue = -1;
        this.afy = -1;
        this.Cv = 0;
        this.aqP = u.d.common_color_10255;
        this.atZ = new d(this);
        this.auo = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.atZ);
        bVar.setEditorTools(this.Cw);
        this.TD.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(u.h.common_tab_host, (ViewGroup) this, true);
        this.aum = (CommonTabContentView) findViewById(u.g.common_tab_content);
        this.aun = (CommonTabWidgetView) findViewById(u.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(u.g.common_progress);
        this.aun.setOnTabSelectedListener(this);
        this.aun.setEditorTools(this.Cw);
        setOrientation(1);
        this.afy = TbadkCoreApplication.m10getInst().getSkinType();
        setBackgroundColor(u.d.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (skinType != this.afy) {
            this.afy = skinType;
            onChangeSkinType(this.afy);
        }
        if (i != 8 && i != 4 && !this.auo) {
            this.auo = true;
            Iterator<b> it = this.TD.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0042b c0042b) {
        this.aun.c(c0042b);
    }

    public void setShowDelete(boolean z) {
        this.aun.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.TD.size()) {
            this.aum.a(this.TD.get(i));
            this.aun.setCurrentTab(i);
            this.aue = i;
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
        av.e(this, this.aqP, i);
        this.aun.onChangeSkinType(i);
        this.aum.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.TD.iterator();
        while (it.hasNext()) {
            it.next().Bz();
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.Cw = lVar;
        if (this.TD != null && this.TD.size() != 0) {
            Iterator<b> it = this.TD.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Cw);
            }
        }
        if (this.aun != null) {
            this.aun.setEditorTools(this.Cw);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Cw != null) {
            this.Cw.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.Cv = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.Cv;
    }

    public void init() {
    }

    public void kB() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.TD.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aqP = i;
    }
}
