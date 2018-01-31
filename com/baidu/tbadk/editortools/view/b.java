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
    private ArrayList<com.baidu.tbadk.editortools.view.a> aQJ;
    private i axQ;
    private int axR;
    private int bdS;
    private int bqb;
    private a bta;
    private int btf;
    private CommonTabContentView bto;
    private CommonTabWidgetView btp;
    private boolean btq;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void LC();

        void LD();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public b(Context context) {
        super(context);
        this.aQJ = new ArrayList<>();
        this.btf = -1;
        this.bdS = -1;
        this.axR = 0;
        this.bqb = d.C0108d.common_color_10255;
        this.bta = new a() { // from class: com.baidu.tbadk.editortools.view.b.1
            @Override // com.baidu.tbadk.editortools.view.b.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                b.this.hideProgressBar();
                b.this.btp.reset();
                b.this.btp.setDatas(b.this.aQJ);
                int size = b.this.aQJ.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b Lw = ((com.baidu.tbadk.editortools.view.a) b.this.aQJ.get(i)).Lw();
                    if (Lw != null) {
                        z = true;
                        b.this.c(Lw);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    b.this.btp.setVisibility(8);
                }
                if (b.this.btf >= 0) {
                    b.this.setCurrentTab(b.this.btf);
                } else {
                    b.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void LC() {
                b.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.b.a
            public void LD() {
                b.this.hideProgressBar();
            }
        };
        this.btq = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.bta);
        aVar.setEditorTools(this.axQ);
        this.aQJ.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_host, (ViewGroup) this, true);
        this.bto = (CommonTabContentView) findViewById(d.g.common_tab_content);
        this.btp = (CommonTabWidgetView) findViewById(d.g.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(d.g.common_progress);
        this.btp.setOnTabSelectedListener(this);
        this.btp.setEditorTools(this.axQ);
        setOrientation(1);
        this.bdS = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(d.C0108d.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bdS) {
            this.bdS = skinType;
            onChangeSkinType(this.bdS);
        }
        if (i != 8 && i != 4 && !this.btq) {
            this.btq = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQJ.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.btp.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.btp.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aQJ.size()) {
            this.bto.a(this.aQJ.get(i));
            this.btp.setCurrentTab(i);
            this.btf = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void hV(int i) {
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
        aj.g(this, this.bqb, i);
        this.btp.onChangeSkinType(i);
        this.bto.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQJ.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axQ = iVar;
        if (this.aQJ != null && this.aQJ.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQJ.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.axQ);
            }
        }
        if (this.btp != null) {
            this.btp.setEditorTools(this.axQ);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axQ != null) {
            this.axQ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axR = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axR;
    }

    public void init() {
    }

    public void ti() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.aQJ.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bqb = i;
    }
}
