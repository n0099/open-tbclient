package com.baidu.tieba.editortool;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ar extends LinearLayout implements av {
    private int RD;
    private int RK;
    private ArrayList<an> aew;
    private at arD;
    private PrivilegeTabContentView arJ;
    private PrivilegeTabWidgetView arK;
    private Context mContext;
    private ProgressBar mProgressBar;

    public ar(Context context) {
        super(context);
        this.aew = new ArrayList<>();
        this.RK = -1;
        this.RD = -1;
        this.arD = new as(this);
        init(context);
    }

    private void Cw() {
        this.aew.clear();
        this.aew.add(new a(this.arD));
    }

    private void init(Context context) {
        this.mContext = context;
        removeAllViews();
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.privilege_tab_host, this, true);
        this.arJ = (PrivilegeTabContentView) findViewById(com.baidu.tieba.v.privilege_tab_content);
        this.arK = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.v.privilege_tab_widget);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.privilege_progress);
        this.arK.setOnTabSelectedListener(this);
        setOrientation(1);
        this.RD = TbadkApplication.m251getInst().getSkinType();
        onChangeSkinType(this.RD);
        setup();
    }

    private void setup() {
        Cw();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType != this.RD) {
            this.RD = skinType;
            onChangeSkinType(this.RD);
        }
        if (i != 8 && i != 4) {
            Iterator<an> it = this.aew.iterator();
            while (it.hasNext()) {
                it.next().init(this.mContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ap apVar) {
        this.arK.c(apVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aew.size()) {
            this.arJ.a(this.aew.get(i));
            this.arK.setShowDelete(true);
            this.arK.setCurrentTab(i);
            this.RK = i;
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
        this.arK.onChangeSkinType(i);
        this.arJ.onChangeSkinType(i);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        Iterator<an> it = this.aew.iterator();
        while (it.hasNext()) {
            it.next().b(wVar);
        }
        this.arJ.setOnDataSelected(wVar);
        this.arK.setOnDataSelected(wVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<an> it = this.aew.iterator();
        while (it.hasNext()) {
            it.next().exit();
        }
    }
}
