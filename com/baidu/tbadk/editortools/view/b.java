package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
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
    private ArrayList<com.baidu.tbadk.editortools.view.a> Xn;
    private int aqb;
    private int arr;
    private int ary;
    private a aul;
    private CommonTabContentView aur;
    private CommonTabWidgetView aus;
    private boolean aut;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Ce();

        void Cf();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.Xn = new ArrayList<>();
        this.ary = -1;
        this.arr = -1;
        this.Ky = 0;
        this.aqb = i.c.editor_background;
        this.aul = new c(this);
        this.aut = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aul);
        aVar.setEditorTools(this.Kz);
        this.Xn.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.common_tab_host, (ViewGroup) this, true);
        this.aur = (CommonTabContentView) findViewById(i.f.common_tab_content);
        this.aus = (CommonTabWidgetView) findViewById(i.f.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(i.f.common_progress);
        this.aus.setOnTabSelectedListener(this);
        this.aus.setEditorTools(this.Kz);
        setOrientation(1);
        this.arr = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(i.c.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.arr) {
            this.arr = skinType;
            onChangeSkinType(this.arr);
        }
        if (i != 8 && i != 4 && !this.aut) {
            this.aut = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xn.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aus.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aus.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Xn.size()) {
            this.aur.a(this.Xn.get(i));
            this.aus.setCurrentTab(i);
            this.ary = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void dZ(int i) {
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
        al.d(this, this.aqb, i);
        this.aus.onChangeSkinType(i);
        this.aur.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xn.iterator();
        while (it.hasNext()) {
            it.next().AT();
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.Kz = jVar;
        if (this.Xn != null && this.Xn.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xn.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Kz);
            }
        }
        if (this.aus != null) {
            this.aus.setEditorTools(this.Kz);
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
    public void ov() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xn.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aqb = i;
    }
}
