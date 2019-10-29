package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools Dl;
    private int Dm;
    private int apR;
    private ArrayList<com.baidu.tbadk.editortools.view.a> bbZ;
    private boolean bes;
    private int cEW;
    private a cIc;
    private CommonTabContentView cIn;
    private CommonTabWidgetView cIo;
    private int csX;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void avf();

        void avg();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.bbZ = new ArrayList<>();
        this.apR = -1;
        this.csX = -1;
        this.Dm = 0;
        this.cEW = R.color.common_color_10255;
        this.cIc = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.cIo.reset();
                CommonTabHost.this.cIo.setDatas(CommonTabHost.this.bbZ);
                int size = CommonTabHost.this.bbZ.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b ava = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.bbZ.get(i)).ava();
                    if (ava != null) {
                        z = true;
                        CommonTabHost.this.c(ava);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.cIo.setVisibility(8);
                }
                if (CommonTabHost.this.apR >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.apR);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void avf() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void avg() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bes = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbZ = new ArrayList<>();
        this.apR = -1;
        this.csX = -1;
        this.Dm = 0;
        this.cEW = R.color.common_color_10255;
        this.cIc = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.cIo.reset();
                CommonTabHost.this.cIo.setDatas(CommonTabHost.this.bbZ);
                int size = CommonTabHost.this.bbZ.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b ava = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.bbZ.get(i)).ava();
                    if (ava != null) {
                        z = true;
                        CommonTabHost.this.c(ava);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.cIo.setVisibility(8);
                }
                if (CommonTabHost.this.apR >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.apR);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void avf() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void avg() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bes = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.cIc);
        aVar.setEditorTools(this.Dl);
        this.bbZ.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.cIn = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.cIo = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.cIo.setOnTabSelectedListener(this);
        this.cIo.setEditorTools(this.Dl);
        setOrientation(1);
        this.csX = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.csX) {
            this.csX = skinType;
            onChangeSkinType(this.csX);
        }
        if (i != 8 && i != 4 && !this.bes) {
            this.bes = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.bbZ.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.cIo.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.cIo.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bbZ.size()) {
            this.cIn.a(this.bbZ.get(i));
            this.cIo.setCurrentTab(i);
            this.apR = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void jW(int i) {
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

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.cEW, i);
        this.cIo.onChangeSkinType(i);
        this.cIn.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.bbZ.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
        if (this.bbZ != null && this.bbZ.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.bbZ.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Dl);
            }
        }
        if (this.cIo != null) {
            this.cIo.setEditorTools(this.Dl);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Dm;
    }

    public void init() {
    }

    public void le() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.bbZ.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cEW = i;
    }
}
