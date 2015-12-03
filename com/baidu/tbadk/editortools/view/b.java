package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends f implements CommonTabWidgetView.a {
    private int KR;
    private k KS;
    private ArrayList<com.baidu.tbadk.editortools.view.a> XX;
    private int afY;
    private int aqy;
    private CommonTabContentView atD;
    private CommonTabWidgetView atE;
    private boolean atF;
    private a atr;
    private int atv;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void CI();

        void CJ();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.XX = new ArrayList<>();
        this.atv = -1;
        this.afY = -1;
        this.KR = 0;
        this.aqy = n.c.editor_background;
        this.atr = new c(this);
        this.atF = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.atr);
        aVar.setEditorTools(this.KS);
        this.XX.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(n.g.common_tab_host, (ViewGroup) this, true);
        this.atD = (CommonTabContentView) findViewById(n.f.common_tab_content);
        this.atE = (CommonTabWidgetView) findViewById(n.f.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(n.f.common_progress);
        this.atE.setOnTabSelectedListener(this);
        this.atE.setEditorTools(this.KS);
        setOrientation(1);
        this.afY = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(n.c.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.afY) {
            this.afY = skinType;
            onChangeSkinType(this.afY);
        }
        if (i != 8 && i != 4 && !this.atF) {
            this.atF = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.XX.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.atE.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.atE.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.XX.size()) {
            this.atD.a(this.XX.get(i));
            this.atE.setCurrentTab(i);
            this.atv = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void ew(int i) {
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
        as.d(this, this.aqy, i);
        this.atE.onChangeSkinType(i);
        this.atD.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.XX.iterator();
        while (it.hasNext()) {
            it.next().BH();
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.KS = kVar;
        if (this.XX != null && this.XX.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.XX.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.KS);
            }
        }
        if (this.atE != null) {
            this.atE.setEditorTools(this.KS);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KS != null) {
            this.KS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.KR = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.KR;
    }

    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.XX.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aqy = i;
    }
}
