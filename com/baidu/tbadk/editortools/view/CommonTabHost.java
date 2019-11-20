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
    private EditorTools CJ;
    private int CK;
    private int apz;
    private ArrayList<com.baidu.tbadk.editortools.view.a> bbH;
    private boolean bdZ;
    private int cEf;
    private a cHl;
    private CommonTabContentView cHw;
    private CommonTabWidgetView cHx;
    private int csg;
    private Context mContext;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void avd();

        void ave();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.bbH = new ArrayList<>();
        this.apz = -1;
        this.csg = -1;
        this.CK = 0;
        this.cEf = R.color.common_color_10255;
        this.cHl = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.cHx.reset();
                CommonTabHost.this.cHx.setDatas(CommonTabHost.this.bbH);
                int size = CommonTabHost.this.bbH.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b auY = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.bbH.get(i)).auY();
                    if (auY != null) {
                        z = true;
                        CommonTabHost.this.c(auY);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.cHx.setVisibility(8);
                }
                if (CommonTabHost.this.apz >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.apz);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void avd() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void ave() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bdZ = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbH = new ArrayList<>();
        this.apz = -1;
        this.csg = -1;
        this.CK = 0;
        this.cEf = R.color.common_color_10255;
        this.cHl = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.cHx.reset();
                CommonTabHost.this.cHx.setDatas(CommonTabHost.this.bbH);
                int size = CommonTabHost.this.bbH.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b auY = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.bbH.get(i)).auY();
                    if (auY != null) {
                        z = true;
                        CommonTabHost.this.c(auY);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.cHx.setVisibility(8);
                }
                if (CommonTabHost.this.apz >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.apz);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void avd() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void ave() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.bdZ = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.cHl);
        aVar.setEditorTools(this.CJ);
        this.bbH.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.cHw = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.cHx = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.cHx.setOnTabSelectedListener(this);
        this.cHx.setEditorTools(this.CJ);
        setOrientation(1);
        this.csg = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.csg) {
            this.csg = skinType;
            onChangeSkinType(this.csg);
        }
        if (i != 8 && i != 4 && !this.bdZ) {
            this.bdZ = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.bbH.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.cHx.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.cHx.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bbH.size()) {
            this.cHw.a(this.bbH.get(i));
            this.cHx.setCurrentTab(i);
            this.apz = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void jV(int i) {
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
        am.setBackgroundColor(this, this.cEf, i);
        this.cHx.onChangeSkinType(i);
        this.cHw.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.bbH.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
        if (this.bbH != null && this.bbH.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.bbH.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.CJ);
            }
        }
        if (this.cHx != null) {
            this.cHx.setEditorTools(this.CJ);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.CK;
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
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.bbH.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cEf = i;
    }
}
