package com.baidu.tieba.ala.livewishlist.b;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.c;
/* loaded from: classes3.dex */
public class a {
    public long eWd;
    public TbImageView giT;
    public TextView giU;
    public boolean giY;
    public TextView giZ;
    public TextView gja;
    public HeadImageView gjb;
    public HeadImageView gjc;
    public HeadImageView gjd;
    public TextView gje;
    public TextView gjf;
    public TextView gjg;
    public AlaLiveWishListData gjh;
    public c gji;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.giZ = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.giT = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.gja = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.giU = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.gjb = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.gjc = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.gjd = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.gje = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.gjf = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.gjg = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.gjh = alaLiveWishListData;
    }

    public void lv(boolean z) {
        this.giY = z;
    }

    public void dK(long j) {
        this.eWd = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.gji = cVar;
        if (cVar != null) {
            this.giZ.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.giT.setDefaultBgResource(a.f.icon_live_gift_default);
            this.giT.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.giT.setAutoChangeStyle(false);
            this.giT.startLoad(cVar.fsv, 10, false);
            this.mProgress.setMax(cVar.fsx);
            this.mProgress.setProgress(cVar.fsw);
            this.gjb.setIsRound(true);
            this.gjc.setIsRound(true);
            this.gjd.setIsRound(true);
            k.a(this.gjb, TextUtils.isEmpty(cVar.fsy) ? "null" : cVar.fsy, true, false);
            k.a(this.gjc, TextUtils.isEmpty(cVar.fsz) ? "null" : cVar.fsz, true, false);
            k.a(this.gjd, TextUtils.isEmpty(cVar.fsA) ? "null" : cVar.fsA, true, false);
            this.gja.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.gjh != null) {
                this.giU.setText(this.gjh.process_num + "/" + this.gjh.finish_num);
                this.mProgress.setMax(this.gjh.finish_num);
                this.mProgress.setProgress(this.gjh.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.gje.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.KI * 1000;
            if (this.eWd <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.eWd * 1000);
            }
            if (this.gjh != null) {
                cVar.fsw = this.gjh.process_num;
                cVar.fsx = this.gjh.finish_num;
            }
            if (this.giY) {
                this.gjg.setVisibility(8);
                this.gjf.setVisibility(0);
                if (cVar.fsw >= cVar.fsx) {
                    if (j <= 0) {
                        this.gjg.setVisibility(0);
                        this.gjf.setVisibility(8);
                        this.gjg.setText(a.i.ala_go_wish_overdue);
                    }
                    this.gjg.setVisibility(0);
                    this.gjf.setVisibility(8);
                    this.gjg.setText(a.i.ala_go_wish_success);
                    this.gje.setVisibility(8);
                    return;
                }
                this.gjg.setVisibility(8);
                this.gjf.setVisibility(0);
                if (j <= 0) {
                    this.gjg.setVisibility(0);
                    this.gjf.setVisibility(8);
                    this.gjg.setText(a.i.ala_go_wish_overdue);
                    this.gje.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.gjg.setVisibility(0);
            this.gjf.setVisibility(8);
            if (cVar.fsw >= cVar.fsx) {
                if (j <= 0) {
                    this.gjg.setVisibility(0);
                    this.gjf.setVisibility(8);
                    this.gjg.setText(a.i.ala_go_wish_overdue);
                    this.gje.setVisibility(8);
                }
                this.gjg.setText(a.i.ala_go_wish_success);
                this.gje.setVisibility(8);
                return;
            }
            this.gjg.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.gjg.setVisibility(0);
                this.gjf.setVisibility(8);
                this.gjg.setText(a.i.ala_go_wish_overdue);
                this.gje.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.gje.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.gje.setVisibility(0);
                a.this.gje.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.g.a.dO(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.gje.setVisibility(8);
                a.this.gjg.setVisibility(0);
                a.this.gjf.setVisibility(8);
                a.this.gjg.setText(a.i.ala_go_wish_overdue);
                cVar.KI = 0L;
            }
        }.start());
    }
}
