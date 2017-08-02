package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends d implements CommonTabWidgetView.a {
    private int JS;
    private i JT;
    private int aAC;
    private a aDC;
    private int aDH;
    private CommonTabContentView aDP;
    private CommonTabWidgetView aDQ;
    private boolean aDR;
    private ArrayList<com.baidu.tbadk.editortools.view.a> abi;
    private int aoR;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void DY();

        void DZ();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.abi = new ArrayList<>();
        this.aDH = -1;
        this.aoR = -1;
        this.JS = 0;
        this.aAC = d.e.common_color_10255;
        this.aDC = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.aDQ.reset();
                b.this.aDQ.setDatas(b.this.abi);
                int size = b.this.abi.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b DS = ((com.baidu.tbadk.editortools.view.a) b.this.abi.get(i)).DS();
                    if (DS != null) {
                        z = true;
                        b.this.c(DS);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.aDQ.setVisibility(8);
                }
                if (b.this.aDH >= 0) {
                    b.this.setCurrentTab(b.this.aDH);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void DY() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void DZ() {
                b.this.hideProgressBar();
            }
        };
        this.aDR = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.aDC);
        aVar.setEditorTools(this.JT);
        this.abi.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_host, (ViewGroup) this, true);
        this.aDP = (CommonTabContentView) findViewById(d.h.common_tab_content);
        this.aDQ = (CommonTabWidgetView) findViewById(d.h.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.h.common_progress);
        this.aDQ.setOnTabSelectedListener(this);
        this.aDQ.setEditorTools(this.JT);
        setOrientation(1);
        this.aoR = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColor(d.e.common_color_10255);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoR) {
            this.aoR = skinType;
            onChangeSkinType(this.aoR);
        }
        if (i != 8 && i != 4 && !this.aDR) {
            this.aDR = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abi.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.aDQ.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.aDQ.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.abi.size()) {
            this.aDP.a(this.abi.get(i));
            this.aDQ.setCurrentTab(i);
            this.aDH = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void eR(int i) {
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

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        ai.e(this, this.aAC, i);
        this.aDQ.onChangeSkinType(i);
        this.aDP.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.abi.iterator();
        while (it.hasNext()) {
            it.next().Dd();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JT = iVar;
        if (this.abi != null && this.abi.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.abi.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.JT);
            }
        }
        if (this.aDQ != null) {
            this.aDQ.setEditorTools(this.JT);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JS;
    }

    public void init() {
    }

    public void lJ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.abi.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aAC = i;
    }
}
