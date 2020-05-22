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
    private EditorTools Zt;
    private int Zu;
    private int agt;
    private boolean cwk;
    private ArrayList<com.baidu.tbadk.editortools.view.a> dJp;
    private a enP;
    private CommonTabContentView eoa;
    private CommonTabWidgetView eob;
    private int mBgColor;
    private Context mContext;
    private int mCurrentIndex;
    private ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void adb();

        void beg();

        void c(com.baidu.tbadk.editortools.view.a aVar);
    }

    public CommonTabHost(Context context) {
        super(context);
        this.dJp = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.agt = -1;
        this.Zu = 0;
        this.mBgColor = R.color.common_color_10255;
        this.enP = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.eob.reset();
                CommonTabHost.this.eob.setDatas(CommonTabHost.this.dJp);
                int size = CommonTabHost.this.dJp.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b beb = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.dJp.get(i)).beb();
                    if (beb != null) {
                        z = true;
                        CommonTabHost.this.c(beb);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.eob.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void beg() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void adb() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.cwk = false;
        init(context);
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJp = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.agt = -1;
        this.Zu = 0;
        this.mBgColor = R.color.common_color_10255;
        this.enP = new a() { // from class: com.baidu.tbadk.editortools.view.CommonTabHost.1
            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void c(com.baidu.tbadk.editortools.view.a aVar) {
                boolean z;
                CommonTabHost.this.hideProgressBar();
                CommonTabHost.this.eob.reset();
                CommonTabHost.this.eob.setDatas(CommonTabHost.this.dJp);
                int size = CommonTabHost.this.dJp.size();
                int i = 0;
                boolean z2 = false;
                while (i < size) {
                    a.b beb = ((com.baidu.tbadk.editortools.view.a) CommonTabHost.this.dJp.get(i)).beb();
                    if (beb != null) {
                        z = true;
                        CommonTabHost.this.c(beb);
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
                if (!z2) {
                    CommonTabHost.this.eob.setVisibility(8);
                }
                if (CommonTabHost.this.mCurrentIndex >= 0) {
                    CommonTabHost.this.setCurrentTab(CommonTabHost.this.mCurrentIndex);
                } else {
                    CommonTabHost.this.setCurrentTab(0);
                }
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void beg() {
                CommonTabHost.this.showProgressBar();
            }

            @Override // com.baidu.tbadk.editortools.view.CommonTabHost.a
            public void adb() {
                CommonTabHost.this.hideProgressBar();
            }
        };
        this.cwk = false;
        init(context);
    }

    public void b(com.baidu.tbadk.editortools.view.a aVar) {
        aVar.a(this.enP);
        aVar.setEditorTools(this.Zt);
        this.dJp.add(aVar);
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.eoa = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.eob = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(R.id.common_progress);
        this.eob.setOnTabSelectedListener(this);
        this.eob.setEditorTools(this.Zt);
        setOrientation(1);
        this.agt = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.cp_bg_line_d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.agt) {
            this.agt = skinType;
            onChangeSkinType(this.agt);
        }
        if (i != 8 && i != 4 && !this.cwk) {
            this.cwk = true;
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.dJp.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        this.eob.c(bVar);
    }

    public void setShowDelete(boolean z) {
        this.eob.setShowDelete(z);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.dJp.size()) {
            this.eoa.a(this.dJp.get(i));
            this.eob.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.a
    public void np(int i) {
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

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.mBgColor, i);
        this.eob.onChangeSkinType(i);
        this.eoa.onChangeSkinType(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.dJp.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
        if (this.dJp != null && this.dJp.size() != 0) {
            Iterator<com.baidu.tbadk.editortools.view.a> it = this.dJp.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.Zt);
            }
        }
        if (this.eob != null) {
            this.eob.setEditorTools(this.Zt);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zu;
    }

    public void init() {
    }

    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    public void a(com.baidu.tbadk.editortools.a aVar) {
        Iterator<com.baidu.tbadk.editortools.view.a> it = this.dJp.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }
}
