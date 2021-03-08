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
/* loaded from: classes10.dex */
public class a {
    private ab hhF;
    private DecimalFormat hiT;
    private String hiU;
    private List<o.c> hiV;
    private List<o.b> hiW;
    private String hiX;
    private String hiY;
    private String hiZ;
    private boolean hja;
    private RelativeSizeSpan hjb;
    private ForegroundColorSpan hjc;
    private Context mContext;
    private b hiK = null;
    private float hiL = 0.0f;
    private float hiM = 0.0f;
    private int hiN = 0;
    private float hiO = 0.0f;
    private int hiP = 0;
    private double hiQ = 0.0d;
    private int hiR = 0;
    private boolean hiS = false;
    private boolean isUseDoubleTicket = false;
    private int mAnswerType = 2;

    public void a(Context context, e eVar) {
        this.mContext = context;
        this.hiK = eVar;
    }

    public void a(o oVar, ab abVar) {
        b(oVar, abVar);
        bXR();
        bXS();
        if (oVar.BB()) {
            bXU();
        } else {
            bXT();
        }
    }

    private void b(o oVar, ab abVar) {
        this.hhF = abVar;
        o.a BD = oVar.BD();
        if (BD != null) {
            this.hiO = BD.BL();
            if (Math.abs(this.hiO) <= 1.0E-6d) {
                this.hiO = 0.0f;
            }
            this.hiL = (float) BD.BI();
            this.hiM = (float) BD.BJ();
            this.hiU = BD.BM();
            this.hiP = BD.getAnswer();
            this.hiQ = BD.BK();
            this.hiN = BD.BN();
            this.hiR = BD.BQ();
            this.hiZ = BD.BO();
            this.hja = oVar.BB();
            if (BD.BP() == 0) {
                this.mAnswerType = 0;
            } else if (BD.BP() == 1) {
                this.mAnswerType = 1;
            } else if (BD.BP() == 2) {
                this.mAnswerType = 2;
            }
            if (oVar.BB()) {
                this.hiW = oVar.BG();
                return;
            }
            this.isUseDoubleTicket = BD.BR();
            this.hiV = oVar.BH();
            this.hiX = oVar.BE();
            this.hiY = oVar.BF();
        }
    }

    private void bXR() {
        this.hiK.f(bXV());
        StringBuilder sb = new StringBuilder();
        sb.append(this.hiN).append("人瓜分").append((int) this.hiO).append("元");
        this.hiK.a(sb);
        this.hiK.Hn(this.hiU);
        if (this.mAnswerType == 1) {
            this.hiK.uK(a.e.ala_guess_result_success);
            if (this.hja) {
                this.hiK.g(nv(false));
                this.hiK.h(nv(true));
            } else if (this.isUseDoubleTicket) {
                this.hiK.g(nv(false));
                this.hiK.h(nv(true));
            }
            c.nx(this.hja);
        } else if (this.mAnswerType == 0) {
            this.hiK.uK(a.e.ala_guess_result_failure);
            c.ny(this.hja);
        } else if (this.mAnswerType == 2) {
            this.hiK.uK(a.e.ala_guess_result_miss);
            c.nz(this.hja);
        }
    }

    private void bXS() {
        if (!TextUtils.isEmpty(this.hiZ) && this.hiZ.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] split = this.hiZ.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            this.hiK.Ho(split[0]);
            this.hiK.Hp(split[1]);
        }
        if (this.hiP == 0) {
            this.hiS = false;
        } else {
            this.hiS = true;
        }
        this.hiK.nw(this.hiS);
        int i = (int) (this.hiQ * 100.0d);
        int i2 = 100 - i;
        if (this.hiS) {
            this.hiK.bJ(i, i2);
        } else {
            this.hiK.bJ(i2, i);
        }
    }

    private void bXT() {
        if (this.mAnswerType == 1 && this.isUseDoubleTicket) {
            this.hiK.uL(2);
        } else {
            this.hiK.uL(1);
        }
        long j = 0;
        if (this.hhF != null && this.hhF.mLiveInfo != null) {
            j = this.hhF.mLiveInfo.room_id;
        }
        String str = this.hiX + "?room_id=" + j;
        if (this.hiV != null && this.hiV.size() > 0 && this.hiV.get(0) != null) {
            this.hiK.a(this.hiV.get(0), false, str);
            return;
        }
        this.hiK.u(false, str);
    }

    private void bXU() {
        if (this.mAnswerType == 1 && this.hiR > 1) {
            this.hiK.uL(4);
            this.hiK.uM(this.hiR);
        } else {
            this.hiK.uL(5);
        }
        this.hiK.k(this.hiP, this.hiW);
    }

    private SpannableStringBuilder nv(boolean z) {
        String aB;
        if (this.hiT == null) {
            this.hiT = new DecimalFormat("0.00");
        }
        if (z) {
            aB = aB(this.hiM);
        } else {
            aB = aB(this.hiL);
        }
        String str = aB + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.hjc = new ForegroundColorSpan(this.mContext.getResources().getColor(z ? a.c.ala_guess_result_text_color : a.c.ala_guess_bg_double_average_money_color));
        int length = str.length() - 1;
        spannableStringBuilder.setSpan(this.hjc, 0, length, 34);
        this.hjb = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.hjb, 0, length, 34);
        return spannableStringBuilder;
    }

    private SpannableStringBuilder bXV() {
        if (this.hiT == null) {
            this.hiT = new DecimalFormat("0.00");
        }
        String aB = aB(this.hiL);
        int length = "人均".length();
        String str = "人均" + aB + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.hjc = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bg_double_average_money_color));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.hjc, length, length2, 34);
        this.hjb = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.hjb, length, length2, 34);
        return spannableStringBuilder;
    }

    private String aB(float f) {
        String str = f + "";
        if (Math.abs(f) <= 1.0E-6d) {
            return "0";
        }
        if (!com.baidu.tieba.ala.live.guess.c.b.Hq(str) && com.baidu.tieba.ala.live.guess.c.b.isDecimal(str)) {
            return this.hiT.format(f);
        }
        return ((int) f) + "";
    }
}
