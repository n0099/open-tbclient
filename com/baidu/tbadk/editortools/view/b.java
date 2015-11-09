package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends f implements CommonTabWidgetView.a {
    private int KA;
    private j KB;
    private ArrayList<com.baidu.tbadk.editortools.view.a> Xk;
    private int aoI;
    private CommonTabContentView arC;
    private CommonTabWidgetView arD;
    private boolean arE;
    private int arf;
    private a arq;
    private int aru;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void BH();

        void BI();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.Xk = new ArrayList<>();
        this.aru = -1;
        this.arf = -1;
        this.KA = 0;
        this.aoI = i.c.editor_background;
        this.arq = new c(this);
        this.arE = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.arq);
        aVar.setEditorTools(this.KB);
        this.Xk.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.common_tab_host, (ViewGroup) this, true);
        this.arC = (CommonTabContentView) findViewById(i.f.common_tab_content);
        this.arD = (CommonTabWidgetView) findViewById(i.f.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(i.f.common_progress);
        this.arD.setOnTabSelectedListener(this);
        this.arD.setEditorTools(this.KB);
        setOrientation(1);
        this.arf = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(i.c.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.arf) {
            this.arf = skinType;
            onChangeSkinType(this.arf);
        }
        if (i != 8 && i != 4 && !this.arE) {
            this.arE = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xk.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.arD.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.arD.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Xk.size()) {
            this.arC.a(this.Xk.get(i));
            this.arD.setCurrentTab(i);
            this.aru = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void ei(int i) {
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

    @Override // com.baidu.tbadk.editortools.x
    public void onChangeSkinType(int i) {
        an.d(this, this.aoI, i);
        this.arD.onChangeSkinType(i);
        this.arC.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xk.iterator();
        while (it.hasNext()) {
            it.next().AJ();
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setEditorTools(j jVar) {
        this.KB = jVar;
        if (this.Xk != null && this.Xk.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xk.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.KB);
            }
        }
        if (this.arD != null) {
            this.arD.setEditorTools(this.KB);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KB != null) {
            this.KB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setToolId(int i) {
        this.KA = i;
    }

    @Override // com.baidu.tbadk.editortools.x
    public int getToolId() {
        return this.KA;
    }

    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.x
    public void ox() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xk.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aoI = i;
    }
}
