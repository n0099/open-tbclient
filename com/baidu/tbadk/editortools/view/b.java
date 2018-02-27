package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends d implements CommonTabWidgetView.a {
    private ArrayList<com.baidu.tbadk.editortools.view.a> aRX;
    private i axG;
    private int axH;
    private int bfz;
    private int bsb;
    private a bva;
    private int bvf;
    private CommonTabContentView bvn;
    private CommonTabWidgetView bvo;
    private boolean bvp;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void Mh();

        void Mi();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.aRX = new ArrayList<>();
        this.bvf = -1;
        this.bfz = -1;
        this.axH = 0;
        this.bsb = d.C0141d.common_color_10255;
        this.bva = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.bvo.reset();
                b.this.bvo.setDatas(b.this.aRX);
                int size = b.this.aRX.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Mb = ((com.baidu.tbadk.editortools.view.a) b.this.aRX.get(i)).Mb();
                    if (Mb != null) {
                        z = true;
                        b.this.c(Mb);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.bvo.setVisibility(8);
                }
                if (b.this.bvf >= 0) {
                    b.this.setCurrentTab(b.this.bvf);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Mh() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void Mi() {
                b.this.hideProgressBar();
            }
        };
        this.bvp = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.bva);
        aVar.setEditorTools(this.axG);
        this.aRX.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.bvn = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.bvo = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.bvo.setOnTabSelectedListener(this);
        this.bvo.setEditorTools(this.axG);
        setOrientation(1);
        this.bfz = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0141d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bfz) {
            this.bfz = skinType;
            onChangeSkinType(this.bfz);
        }
        if (i != 8 && i != 4 && !this.bvp) {
            this.bvp = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aRX.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.bvo.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.bvo.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aRX.size()) {
            this.bvn.a(this.aRX.get(i));
            this.bvo.setCurrentTab(i);
            this.bvf = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void hT(int i) {
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
        aj.g(this, this.bsb, i);
        this.bvo.onChangeSkinType(i);
        this.bvn.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aRX.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axG = iVar;
        if (this.aRX != null && this.aRX.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aRX.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.axG);
            }
        }
        if (this.bvo != null) {
            this.bvo.setEditorTools(this.axG);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axG != null) {
            this.axG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axH = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axH;
    }

    public void init() {
    }

    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aRX.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bsb = i;
    }
}
