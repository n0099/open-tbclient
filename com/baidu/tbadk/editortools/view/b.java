package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends f implements CommonTabWidgetView.a {
    private int Ky;
    private j Kz;
    private ArrayList<com.baidu.tbadk.editortools.view.a> Xf;
    private int aoB;
    private int apR;
    private int apY;
    private a asI;
    private CommonTabContentView asO;
    private CommonTabWidgetView asP;
    private boolean asQ;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void BR();

        void BS();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.Xf = new ArrayList<>();
        this.apY = -1;
        this.apR = -1;
        this.Ky = 0;
        this.aoB = i.c.editor_background;
        this.asI = new c(this);
        this.asQ = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.asI);
        aVar.setEditorTools(this.Kz);
        this.Xf.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.common_tab_host, (ViewGroup) this, true);
        this.asO = (CommonTabContentView) findViewById(i.f.common_tab_content);
        this.asP = (CommonTabWidgetView) findViewById(i.f.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(i.f.common_progress);
        this.asP.setOnTabSelectedListener(this);
        this.asP.setEditorTools(this.Kz);
        setOrientation(1);
        this.apR = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(i.c.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.apR) {
            this.apR = skinType;
            onChangeSkinType(this.apR);
        }
        if (i != 8 && i != 4 && !this.asQ) {
            this.asQ = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xf.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.asP.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.asP.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Xf.size()) {
            this.asO.a(this.Xf.get(i));
            this.asP.setCurrentTab(i);
            this.apY = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void ea(int i) {
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

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        am.d(this, this.aoB, i);
        this.asP.onChangeSkinType(i);
        this.asO.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xf.iterator();
        while (it.hasNext()) {
            it.next().AG();
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.Kz = jVar;
        if (this.Xf != null && this.Xf.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xf.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Kz);
            }
        }
        if (this.asP != null) {
            this.asP.setEditorTools(this.Kz);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Ky = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Ky;
    }

    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xf.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aoB = i;
    }
}
