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
    protected int RD = TbadkApplication.m251getInst().getSkinType();
    protected View Xi;
    protected TextView bHA;
    protected TextView bHB;
    protected HeadImageView bHC;
    protected View bHD;
    protected f bHE;
    protected TextView bHz;
    protected boolean mIsFromCDN;
    private int position;

    protected abstract void abC();

    protected abstract void abD();

    protected abstract int abE();

    public a(View view) {
        this.Xi = view;
        view.setTag(this);
    }

    public void refresh() {
        a(this.bHE, this.position, this.mIsFromCDN);
    }

    public void a(f fVar, int i, boolean z) {
        if (!fVar.bHp) {
            com.baidu.tbadk.distribute.a.ra().a(this.Xi.getContext(), fVar.abw(), "show", "pb", fVar.bHq, fVar.threadId);
            com.baidu.tbadk.distribute.a.ra().a(fVar.abw(), fVar.bHq, fVar.threadId, "PB", "show");
            fVar.bHp = true;
        }
        if (fVar != null) {
            com.baidu.tbadk.distribute.a.QI = fVar.aAt;
        }
        this.bHE = fVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.Xi.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abB() {
        if (this.bHE != null && this.bHE.jF()) {
            boolean cV = com.baidu.tbadk.download.b.rh().cV(this.bHE.abk());
            boolean cW = com.baidu.tbadk.download.b.rh().cW(this.bHE.abk());
            if (cV) {
                this.bHE.hf(1);
            } else if (cW) {
                this.bHE.hf(2);
            } else {
                this.bHE.hf(0);
            }
            if (this.bHE.abt()) {
                switch (this.bHE.abs()) {
                    case 0:
                        abC();
                        this.bHz.setText(abE());
                        this.bHz.setOnClickListener(d.aby());
                        this.Xi.setOnClickListener(com.baidu.tieba.d.b.a.abx());
                        this.bHz.setEnabled(true);
                        return;
                    case 1:
                        abD();
                        this.bHz.setText(y.downloading2);
                        this.bHz.setOnClickListener(null);
                        this.Xi.setOnClickListener(null);
                        this.bHz.setEnabled(false);
                        return;
                    case 2:
                        abC();
                        this.bHz.setText(y.downloaded_install);
                        this.bHz.setOnClickListener(d.aby());
                        this.Xi.setOnClickListener(com.baidu.tieba.d.b.a.abx());
                        this.bHz.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.bHE.abu()) {
                abC();
                this.bHz.setText(y.view);
                this.bHz.setOnClickListener(g.abz());
                this.Xi.setOnClickListener(h.abA());
            }
        }
    }

    public View getRootView() {
        return this.Xi;
    }

    public int getPosition() {
        return this.position;
    }

    public f abF() {
        return this.bHE;
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
