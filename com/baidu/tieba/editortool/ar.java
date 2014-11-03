package com.baidu.tieba.editortool;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ar extends LinearLayout implements av {
    private int RH;
    private int RO;
    private ArrayList<an> aeE;
    private at arM;
    private PrivilegeTabContentView arS;
    private PrivilegeTabWidgetView arT;
    private Context mContext;
    private ProgressBar mProgressBar;

    public ar(Context context) {
        super(context);
        this.aeE = new ArrayList<>();
        this.RO = -1;
        this.RH = -1;
        this.arM = new as(this);
        init(context);
    }

    private void Cy() {
        this.aeE.clear();
        this.aeE.add(new a(this.arM));
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.privilege_tab_host, this, true);
        this.arS = (PrivilegeTabContentView) findViewById(com.baidu.tieba.v.privilege_tab_content);
        this.arT = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.v.privilege_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.privilege_progress);
        this.arT.setOnTabSelectedListener(this);
        setOrientation(1);
        this.RH = TbadkApplication.m251getInst().getSkinType();
        onChangeSkinType(this.RH);
        setup();
    }

    private void setup() {
        Cy();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType != this.RH) {
            this.RH = skinType;
            onChangeSkinType(this.RH);
        }
        if (i != 8 && i != 4) {
            Iterator<an> it = this.aeE.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ap apVar) {
        this.arT.c(apVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aeE.size()) {
            this.arS.a(this.aeE.get(i));
            this.arT.setShowDelete(true);
            this.arT.setCurrentTab(i);
            this.RO = i;
        }
    }

    @Override // com.baidu.tieba.editortool.av
    public void cH(int i) {
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

    public void onChangeSkinType(int i) {
        this.arT.onChangeSkinType(i);
        this.arS.onChangeSkinType(i);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        Iterator<an> it = this.aeE.iterator();
        while (it.hasNext()) {
            it.next().b(wVar);
        }
        this.arS.setOnDataSelected(wVar);
        this.arT.setOnDataSelected(wVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<an> it = this.aeE.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }
}
