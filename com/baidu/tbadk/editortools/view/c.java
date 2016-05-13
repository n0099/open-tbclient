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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends g implements CommonTabWidgetView.a {
    private int BU;
    private l BV;
    private ArrayList<b> SE;
    private int aej;
    private int apk;
    private CommonTabContentView asH;
    private CommonTabWidgetView asI;
    private boolean asJ;
    private a asu;
    private int asz;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Ct();

        void Cu();

        void c(b bVar);
    }

    public c(Context context) {
        super(context);
        this.SE = new ArrayList<>();
        this.asz = -1;
        this.aej = -1;
        this.BU = 0;
        this.apk = t.d.editor_background;
        this.asu = new d(this);
        this.asJ = false;
        init(context);
    }

    public void b(b bVar) {
        bVar.a(this.asu);
        bVar.setEditorTools(this.BV);
        this.SE.add(bVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.common_tab_host, (ViewGroup) this, true);
        this.asH = (CommonTabContentView) findViewById(t.g.common_tab_content);
        this.asI = (CommonTabWidgetView) findViewById(t.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(t.g.common_progress);
        this.asI.setOnTabSelectedListener(this);
        this.asI.setEditorTools(this.BV);
        setOrientation(1);
        this.aej = TbadkCoreApplication.m11getInst().getSkinType();
        setBackgroundColor(t.d.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (skinType != this.aej) {
            this.aej = skinType;
            onChangeSkinType(this.aej);
        }
        if (i != 8 && i != 4 && !this.asJ) {
            this.asJ = true;
            Iterator<b> it = this.SE.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C0041b c0041b) {
        this.asI.c(c0041b);
    }

    public void setShowDelete(boolean z) {
        this.asI.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.SE.size()) {
            this.asH.a(this.SE.get(i));
            this.asI.setCurrentTab(i);
            this.asz = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void ev(int i) {
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
        at.e(this, this.apk, i);
        this.asI.onChangeSkinType(i);
        this.asH.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<b> it = this.SE.iterator();
        while (it.hasNext()) {
            it.next().Bq();
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.BV = lVar;
        if (this.SE != null && this.SE.size() != 0) {
            Iterator<b> it = this.SE.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.BV);
            }
        }
        if (this.asI != null) {
            this.asI.setEditorTools(this.BV);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BU = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BU;
    }

    public void init() {
    }

    public void kC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<b> it = this.SE.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.apk = i;
    }
}
