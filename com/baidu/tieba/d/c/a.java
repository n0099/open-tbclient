package com.baidu.tieba.d.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d.a.f;
import com.baidu.tieba.d.b.d;
import com.baidu.tieba.d.b.g;
import com.baidu.tieba.d.b.h;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public abstract class a {
    protected int RH = TbadkApplication.m251getInst().getSkinType();
    protected View Xm;
    protected TextView bHN;
    protected TextView bHO;
    protected TextView bHP;
    protected HeadImageView bHQ;
    protected View bHR;
    protected f bHS;
    protected boolean mIsFromCDN;
    private int position;

    protected abstract void abF();

    protected abstract void abG();

    protected abstract int abH();

    public a(View view) {
        this.Xm = view;
        view.setTag(this);
    }

    public void refresh() {
        a(this.bHS, this.position, this.mIsFromCDN);
    }

    public void a(f fVar, int i, boolean z) {
        if (!fVar.bHD) {
            com.baidu.tbadk.distribute.a.rc().a(this.Xm.getContext(), fVar.abz(), "show", "pb", fVar.bHE, fVar.threadId);
            com.baidu.tbadk.distribute.a.rc().a(fVar.abz(), fVar.bHE, fVar.threadId, "PB", "show");
            fVar.bHD = true;
        }
        if (fVar != null) {
            com.baidu.tbadk.distribute.a.QM = fVar.aAD;
        }
        this.bHS = fVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.Xm.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abE() {
        if (this.bHS != null && this.bHS.jF()) {
            boolean cV = com.baidu.tbadk.download.b.rj().cV(this.bHS.abn());
            boolean cW = com.baidu.tbadk.download.b.rj().cW(this.bHS.abn());
            if (cV) {
                this.bHS.hf(1);
            } else if (cW) {
                this.bHS.hf(2);
            } else {
                this.bHS.hf(0);
            }
            if (this.bHS.abw()) {
                switch (this.bHS.abv()) {
                    case 0:
                        abF();
                        this.bHN.setText(abH());
                        this.bHN.setOnClickListener(d.abB());
                        this.Xm.setOnClickListener(com.baidu.tieba.d.b.a.abA());
                        this.bHN.setEnabled(true);
                        return;
                    case 1:
                        abG();
                        this.bHN.setText(y.downloading2);
                        this.bHN.setOnClickListener(null);
                        this.Xm.setOnClickListener(null);
                        this.bHN.setEnabled(false);
                        return;
                    case 2:
                        abF();
                        this.bHN.setText(y.downloaded_install);
                        this.bHN.setOnClickListener(d.abB());
                        this.Xm.setOnClickListener(com.baidu.tieba.d.b.a.abA());
                        this.bHN.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.bHS.abx()) {
                abF();
                this.bHN.setText(y.view);
                this.bHN.setOnClickListener(g.abC());
                this.Xm.setOnClickListener(h.abD());
            }
        }
    }

    public View getRootView() {
        return this.Xm;
    }

    public int getPosition() {
        return this.position;
    }

    public f abI() {
        return this.bHS;
    }

    public String hj(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(" ", "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }
}
