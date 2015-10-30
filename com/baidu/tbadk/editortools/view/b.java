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
    private j KA;
    private int Kz;
    private ArrayList<com.baidu.tbadk.editortools.view.a> Xh;
    private int aoC;
    private int apS;
    private int apZ;
    private a asJ;
    private CommonTabContentView asP;
    private CommonTabWidgetView asQ;
    private boolean asR;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void BO();

        void BP();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.Xh = new ArrayList<>();
        this.apZ = -1;
        this.apS = -1;
        this.Kz = 0;
        this.aoC = i.c.editor_background;
        this.asJ = new c(this);
        this.asR = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.asJ);
        aVar.setEditorTools(this.KA);
        this.Xh.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.common_tab_host, (ViewGroup) this, true);
        this.asP = (CommonTabContentView) findViewById(i.f.common_tab_content);
        this.asQ = (CommonTabWidgetView) findViewById(i.f.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(i.f.common_progress);
        this.asQ.setOnTabSelectedListener(this);
        this.asQ.setEditorTools(this.KA);
        setOrientation(1);
        this.apS = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(i.c.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.apS) {
            this.apS = skinType;
            onChangeSkinType(this.apS);
        }
        if (i != 8 && i != 4 && !this.asR) {
            this.asR = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xh.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.asQ.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.asQ.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Xh.size()) {
            this.asP.a(this.Xh.get(i));
            this.asQ.setCurrentTab(i);
            this.apZ = i;
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
        an.d(this, this.aoC, i);
        this.asQ.onChangeSkinType(i);
        this.asP.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xh.iterator();
        while (it.hasNext()) {
            it.next().AD();
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.KA = jVar;
        if (this.Xh != null && this.Xh.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xh.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.KA);
            }
        }
        if (this.asQ != null) {
            this.asQ.setEditorTools(this.KA);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KA != null) {
            this.KA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Kz = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Kz;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.Xh.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aoC = i;
    }
}
