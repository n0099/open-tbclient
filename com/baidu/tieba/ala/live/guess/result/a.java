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
    private ab hfI;
    private DecimalFormat hgV;
    private String hgW;
    private List<o.c> hgX;
    private List<o.b> hgY;
    private String hgZ;
    private String hha;
    private String hhb;
    private boolean hhc;
    private RelativeSizeSpan hhd;
    private ForegroundColorSpan hhe;
    private Context mContext;
    private b hgM = null;
    private float hgN = 0.0f;
    private float hgO = 0.0f;
    private int hgP = 0;
    private float hgQ = 0.0f;
    private int hgR = 0;
    private double hgS = 0.0d;
    private int hgT = 0;
    private boolean hgU = false;
    private boolean isUseDoubleTicket = false;
    private int mAnswerType = 2;

    public void a(Context context, e eVar) {
        this.mContext = context;
        this.hgM = eVar;
    }

    public void a(o oVar, ab abVar) {
        b(oVar, abVar);
        bXE();
        bXF();
        if (oVar.By()) {
            bXH();
        } else {
            bXG();
        }
    }

    private void b(o oVar, ab abVar) {
        this.hfI = abVar;
        o.a BA = oVar.BA();
        if (BA != null) {
            this.hgQ = BA.BI();
            if (Math.abs(this.hgQ) <= 1.0E-6d) {
                this.hgQ = 0.0f;
            }
            this.hgN = (float) BA.BF();
            this.hgO = (float) BA.BG();
            this.hgW = BA.BJ();
            this.hgR = BA.getAnswer();
            this.hgS = BA.BH();
            this.hgP = BA.BK();
            this.hgT = BA.BN();
            this.hhb = BA.BL();
            this.hhc = oVar.By();
            if (BA.BM() == 0) {
                this.mAnswerType = 0;
            } else if (BA.BM() == 1) {
                this.mAnswerType = 1;
            } else if (BA.BM() == 2) {
                this.mAnswerType = 2;
            }
            if (oVar.By()) {
                this.hgY = oVar.BD();
                return;
            }
            this.isUseDoubleTicket = BA.BO();
            this.hgX = oVar.BE();
            this.hgZ = oVar.BB();
            this.hha = oVar.BC();
        }
    }

    private void bXE() {
        this.hgM.f(bXI());
        StringBuilder sb = new StringBuilder();
        sb.append(this.hgP).append("人瓜分").append((int) this.hgQ).append("元");
        this.hgM.a(sb);
        this.hgM.Hd(this.hgW);
        if (this.mAnswerType == 1) {
            this.hgM.uI(a.e.ala_guess_result_success);
            if (this.hhc) {
                this.hgM.g(nv(false));
                this.hgM.h(nv(true));
            } else if (this.isUseDoubleTicket) {
                this.hgM.g(nv(false));
                this.hgM.h(nv(true));
            }
            c.nx(this.hhc);
        } else if (this.mAnswerType == 0) {
            this.hgM.uI(a.e.ala_guess_result_failure);
            c.ny(this.hhc);
        } else if (this.mAnswerType == 2) {
            this.hgM.uI(a.e.ala_guess_result_miss);
            c.nz(this.hhc);
        }
    }

    private void bXF() {
        if (!TextUtils.isEmpty(this.hhb) && this.hhb.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] split = this.hhb.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            this.hgM.He(split[0]);
            this.hgM.Hf(split[1]);
        }
        if (this.hgR == 0) {
            this.hgU = false;
        } else {
            this.hgU = true;
        }
        this.hgM.nw(this.hgU);
        int i = (int) (this.hgS * 100.0d);
        int i2 = 100 - i;
        if (this.hgU) {
            this.hgM.bI(i, i2);
        } else {
            this.hgM.bI(i2, i);
        }
    }

    private void bXG() {
        if (this.mAnswerType == 1 && this.isUseDoubleTicket) {
            this.hgM.uJ(2);
        } else {
            this.hgM.uJ(1);
        }
        long j = 0;
        if (this.hfI != null && this.hfI.mLiveInfo != null) {
            j = this.hfI.mLiveInfo.room_id;
        }
        String str = this.hgZ + "?room_id=" + j;
        if (this.hgX != null && this.hgX.size() > 0 && this.hgX.get(0) != null) {
            this.hgM.a(this.hgX.get(0), false, str);
            return;
        }
        this.hgM.u(false, str);
    }

    private void bXH() {
        if (this.mAnswerType == 1 && this.hgT > 1) {
            this.hgM.uJ(4);
            this.hgM.uK(this.hgT);
        } else {
            this.hgM.uJ(5);
        }
        this.hgM.k(this.hgR, this.hgY);
    }

    private SpannableStringBuilder nv(boolean z) {
        String ax;
        if (this.hgV == null) {
            this.hgV = new DecimalFormat("0.00");
        }
        if (z) {
            ax = ax(this.hgO);
        } else {
            ax = ax(this.hgN);
        }
        String str = ax + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.hhe = new ForegroundColorSpan(this.mContext.getResources().getColor(z ? a.c.ala_guess_result_text_color : a.c.ala_guess_bg_double_average_money_color));
        int length = str.length() - 1;
        spannableStringBuilder.setSpan(this.hhe, 0, length, 34);
        this.hhd = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.hhd, 0, length, 34);
        return spannableStringBuilder;
    }

    private SpannableStringBuilder bXI() {
        if (this.hgV == null) {
            this.hgV = new DecimalFormat("0.00");
        }
        String ax = ax(this.hgN);
        int length = "人均".length();
        String str = "人均" + ax + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.hhe = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bg_double_average_money_color));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.hhe, length, length2, 34);
        this.hhd = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.hhd, length, length2, 34);
        return spannableStringBuilder;
    }

    private String ax(float f) {
        String str = f + "";
        if (Math.abs(f) <= 1.0E-6d) {
            return "0";
        }
        if (!com.baidu.tieba.ala.live.guess.c.b.Hg(str) && com.baidu.tieba.ala.live.guess.c.b.isDecimal(str)) {
            return this.hgV.format(f);
        }
        return ((int) f) + "";
    }
}
