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
    private int Lh;
    private k Li;
    private ArrayList<com.baidu.tbadk.editortools.view.a> YA;
    private int ahf;
    private int asc;
    private a auV;
    private int auZ;
    private CommonTabContentView avh;
    private CommonTabWidgetView avi;
    private boolean avj;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Cx();

        void Cy();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.YA = new ArrayList<>();
        this.auZ = -1;
        this.ahf = -1;
        this.Lh = 0;
        this.asc = n.d.editor_background;
        this.auV = new c(this);
        this.avj = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.auV);
        aVar.setEditorTools(this.Li);
        this.YA.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(n.h.common_tab_host, (ViewGroup) this, true);
        this.avh = (CommonTabContentView) findViewById(n.g.common_tab_content);
        this.avi = (CommonTabWidgetView) findViewById(n.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(n.g.common_progress);
        this.avi.setOnTabSelectedListener(this);
        this.avi.setEditorTools(this.Li);
        setOrientation(1);
        this.ahf = TbadkCoreApplication.m411getInst().getSkinType();
        setBackgroundColor(n.d.editor_background);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahf) {
            this.ahf = skinType;
            onChangeSkinType(this.ahf);
        }
        if (i != 8 && i != 4 && !this.avj) {
            this.avj = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.YA.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.avi.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.avi.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.YA.size()) {
            this.avh.a(this.YA.get(i));
            this.avi.setCurrentTab(i);
            this.auZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eq(int i) {
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
        as.d(this, this.asc, i);
        this.avi.onChangeSkinType(i);
        this.avh.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.YA.iterator();
        while (it.hasNext()) {
            it.next().Bw();
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.Li = kVar;
        if (this.YA != null && this.YA.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.YA.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Li);
            }
        }
        if (this.avi != null) {
            this.avi.setEditorTools(this.Li);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Li != null) {
            this.Li.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lh = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lh;
    }

    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ob() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.YA.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.asc = i;
    }
}
