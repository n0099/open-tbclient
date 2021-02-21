package com.baidu.tieba.ala.live.guess.result;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.baidu.live.data.ab;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.live.guess.view.e;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private ab hfW;
    private DecimalFormat hhj;
    private String hhk;
    private List<o.c> hhl;
    private List<o.b> hhm;
    private String hhn;
    private String hho;
    private String hhp;
    private boolean hhq;
    private RelativeSizeSpan hhr;
    private ForegroundColorSpan hhs;
    private Context mContext;
    private b hha = null;
    private float hhb = 0.0f;
    private float hhc = 0.0f;
    private int hhd = 0;
    private float hhe = 0.0f;
    private int hhf = 0;
    private double hhg = 0.0d;
    private int hhh = 0;
    private boolean hhi = false;
    private boolean isUseDoubleTicket = false;
    private int mAnswerType = 2;

    public void a(Context context, e eVar) {
        this.mContext = context;
        this.hha = eVar;
    }

    public void a(o oVar, ab abVar) {
        b(oVar, abVar);
        bXL();
        bXM();
        if (oVar.By()) {
            bXO();
        } else {
            bXN();
        }
    }

    private void b(o oVar, ab abVar) {
        this.hfW = abVar;
        o.a BA = oVar.BA();
        if (BA != null) {
            this.hhe = BA.BI();
            if (Math.abs(this.hhe) <= 1.0E-6d) {
                this.hhe = 0.0f;
            }
            this.hhb = (float) BA.BF();
            this.hhc = (float) BA.BG();
            this.hhk = BA.BJ();
            this.hhf = BA.getAnswer();
            this.hhg = BA.BH();
            this.hhd = BA.BK();
            this.hhh = BA.BN();
            this.hhp = BA.BL();
            this.hhq = oVar.By();
            if (BA.BM() == 0) {
                this.mAnswerType = 0;
            } else if (BA.BM() == 1) {
                this.mAnswerType = 1;
            } else if (BA.BM() == 2) {
                this.mAnswerType = 2;
            }
            if (oVar.By()) {
                this.hhm = oVar.BD();
                return;
            }
            this.isUseDoubleTicket = BA.BO();
            this.hhl = oVar.BE();
            this.hhn = oVar.BB();
            this.hho = oVar.BC();
        }
    }

    private void bXL() {
        this.hha.f(bXP());
        StringBuilder sb = new StringBuilder();
        sb.append(this.hhd).append("人瓜分").append((int) this.hhe).append("元");
        this.hha.a(sb);
        this.hha.He(this.hhk);
        if (this.mAnswerType == 1) {
            this.hha.uI(a.e.ala_guess_result_success);
            if (this.hhq) {
                this.hha.g(nv(false));
                this.hha.h(nv(true));
            } else if (this.isUseDoubleTicket) {
                this.hha.g(nv(false));
                this.hha.h(nv(true));
            }
            c.nx(this.hhq);
        } else if (this.mAnswerType == 0) {
            this.hha.uI(a.e.ala_guess_result_failure);
            c.ny(this.hhq);
        } else if (this.mAnswerType == 2) {
            this.hha.uI(a.e.ala_guess_result_miss);
            c.nz(this.hhq);
        }
    }

    private void bXM() {
        if (!TextUtils.isEmpty(this.hhp) && this.hhp.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] split = this.hhp.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            this.hha.Hf(split[0]);
            this.hha.Hg(split[1]);
        }
        if (this.hhf == 0) {
            this.hhi = false;
        } else {
            this.hhi = true;
        }
        this.hha.nw(this.hhi);
        int i = (int) (this.hhg * 100.0d);
        int i2 = 100 - i;
        if (this.hhi) {
            this.hha.bJ(i, i2);
        } else {
            this.hha.bJ(i2, i);
        }
    }

    private void bXN() {
        if (this.mAnswerType == 1 && this.isUseDoubleTicket) {
            this.hha.uJ(2);
        } else {
            this.hha.uJ(1);
        }
        long j = 0;
        if (this.hfW != null && this.hfW.mLiveInfo != null) {
            j = this.hfW.mLiveInfo.room_id;
        }
        String str = this.hhn + "?room_id=" + j;
        if (this.hhl != null && this.hhl.size() > 0 && this.hhl.get(0) != null) {
            this.hha.a(this.hhl.get(0), false, str);
            return;
        }
        this.hha.u(false, str);
    }

    private void bXO() {
        if (this.mAnswerType == 1 && this.hhh > 1) {
            this.hha.uJ(4);
            this.hha.uK(this.hhh);
        } else {
            this.hha.uJ(5);
        }
        this.hha.k(this.hhf, this.hhm);
    }

    private SpannableStringBuilder nv(boolean z) {
        String ax;
        if (this.hhj == null) {
            this.hhj = new DecimalFormat("0.00");
        }
        if (z) {
            ax = ax(this.hhc);
        } else {
            ax = ax(this.hhb);
        }
        String str = ax + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.hhs = new ForegroundColorSpan(this.mContext.getResources().getColor(z ? a.c.ala_guess_result_text_color : a.c.ala_guess_bg_double_average_money_color));
        int length = str.length() - 1;
        spannableStringBuilder.setSpan(this.hhs, 0, length, 34);
        this.hhr = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.hhr, 0, length, 34);
        return spannableStringBuilder;
    }

    private SpannableStringBuilder bXP() {
        if (this.hhj == null) {
            this.hhj = new DecimalFormat("0.00");
        }
        String ax = ax(this.hhb);
        int length = "人均".length();
        String str = "人均" + ax + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.hhs = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bg_double_average_money_color));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.hhs, length, length2, 34);
        this.hhr = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.hhr, length, length2, 34);
        return spannableStringBuilder;
    }

    private String ax(float f) {
        String str = f + "";
        if (Math.abs(f) <= 1.0E-6d) {
            return "0";
        }
        if (!com.baidu.tieba.ala.live.guess.c.b.Hh(str) && com.baidu.tieba.ala.live.guess.c.b.isDecimal(str)) {
            return this.hhj.format(f);
        }
        return ((int) f) + "";
    }
}
