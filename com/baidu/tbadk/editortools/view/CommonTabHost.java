package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.a {
    private EditorTools acX;
    private int acY;
    private int akf;
    private int bHL;
    private ArrayList<com.baidu.tbadk.editortools.view.a> eTF;
    private a fCC;
    private CommonTabContentView fCN;
    private CommonTabWidgetView fCO;
    private boolean isInited;
    private int mBgColor;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void c(com.baidu.tbadk.editortools.view.a aVar);

        void onLoadFail();

        void preLoad();
    }

    public CommonTabHost(Context context) {
        super(context);
        this.eTF = new ArrayList<>();
        this.bHL = -1;
        this.akf = -1;
        this.acY = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fCC = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.fCO.reset();
                CommonTabHost.this.fCO.setDatas(CommonTabHost.this.eTF);
                int size = CommonTabHost.this.eTF.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bCe = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eTF.get(i)).bCe();
                    if (bCe != null) {
                        z = true;
                        CommonTabHost.this.c(bCe);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.fCO.setVisibility(8);
                }
                if (CommonTabHost.this.bHL >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bHL);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void preLoad() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void onLoadFail() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eTF = new ArrayList<>();
        this.bHL = -1;
        this.akf = -1;
        this.acY = 0;
        this.mBgColor = R.color.common_color_10255;
        this.fCC = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.fCO.reset();
                CommonTabHost.this.fCO.setDatas(CommonTabHost.this.eTF);
                int size = CommonTabHost.this.eTF.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b bCe = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.eTF.get(i)).bCe();
                    if (bCe != null) {
                        z = true;
                        CommonTabHost.this.c(bCe);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.fCO.setVisibility(8);
                }
                if (CommonTabHost.this.bHL >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.bHL);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void preLoad() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void onLoadFail() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.isInited = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.fCC);
        aVar.setEditorTools(this.acX);
        this.eTF.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.fCN = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.fCO = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.fCO.setOnTabSelectedListener(this);
        this.fCO.setEditorTools(this.acX);
        setOrientation(1);
        this.akf = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.CAM_X0201);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.akf) {
            this.akf = skinType;
            onChangeSkinType(this.akf);
        }
        if (i != 8 && i != 4 && !this.isInited) {
            this.isInited = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eTF.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.fCO.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.fCO.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.eTF.size()) {
            this.fCN.a(this.eTF.get(i));
            this.fCO.setCurrentTab(i);
            this.bHL = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void rd(int i) {
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

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, this.mBgColor, i);
        this.fCO.onChangeSkinType(i);
        this.fCN.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eTF.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
        if (this.eTF != null && this.eTF.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.eTF.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.acX);
            }
        }
        if (this.fCO != null) {
            this.fCO.setEditorTools(this.acX);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    public void init() {
    }

    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.eTF.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
