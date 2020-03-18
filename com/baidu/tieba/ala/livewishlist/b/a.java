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
    public long ejE;
    public TextView fpA;
    public TextView fpB;
    public TextView fpC;
    public AlaLiveWishListData fpD;
    public c fpE;
    public TbImageView fpo;
    public TextView fpp;
    public boolean fpu;
    public TextView fpv;
    public TextView fpw;
    public HeadImageView fpx;
    public HeadImageView fpy;
    public HeadImageView fpz;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.fpv = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.fpo = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.fpw = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.fpp = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.fpx = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.fpy = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.fpz = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.fpA = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.fpB = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.fpC = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.fpD = alaLiveWishListData;
    }

    public void jU(boolean z) {
        this.fpu = z;
    }

    public void db(long j) {
        this.ejE = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.fpE = cVar;
        if (cVar != null) {
            this.fpv.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.fpo.setDefaultBgResource(a.f.icon_live_gift_default);
            this.fpo.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.fpo.setAutoChangeStyle(false);
            this.fpo.startLoad(cVar.eAg, 10, false);
            this.mProgress.setMax(cVar.eAi);
            this.mProgress.setProgress(cVar.eAh);
            this.fpx.setIsRound(true);
            this.fpy.setIsRound(true);
            this.fpz.setIsRound(true);
            k.a(this.fpx, TextUtils.isEmpty(cVar.eAj) ? "null" : cVar.eAj, true, false);
            k.a(this.fpy, TextUtils.isEmpty(cVar.eAk) ? "null" : cVar.eAk, true, false);
            k.a(this.fpz, TextUtils.isEmpty(cVar.eAl) ? "null" : cVar.eAl, true, false);
            this.fpw.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.fpD != null) {
                this.fpp.setText(this.fpD.process_num + "/" + this.fpD.finish_num);
                this.mProgress.setMax(this.fpD.finish_num);
                this.mProgress.setProgress(this.fpD.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.fpA.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.rt * 1000;
            if (this.ejE <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.ejE * 1000);
            }
            if (this.fpD != null) {
                cVar.eAh = this.fpD.process_num;
                cVar.eAi = this.fpD.finish_num;
            }
            if (this.fpu) {
                this.fpC.setVisibility(8);
                this.fpB.setVisibility(0);
                if (cVar.eAh >= cVar.eAi) {
                    if (j <= 0) {
                        this.fpC.setVisibility(0);
                        this.fpB.setVisibility(8);
                        this.fpC.setText(a.i.ala_go_wish_overdue);
                    }
                    this.fpC.setVisibility(0);
                    this.fpB.setVisibility(8);
                    this.fpC.setText(a.i.ala_go_wish_success);
                    this.fpA.setVisibility(8);
                    return;
                }
                this.fpC.setVisibility(8);
                this.fpB.setVisibility(0);
                if (j <= 0) {
                    this.fpC.setVisibility(0);
                    this.fpB.setVisibility(8);
                    this.fpC.setText(a.i.ala_go_wish_overdue);
                    this.fpA.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.fpC.setVisibility(0);
            this.fpB.setVisibility(8);
            if (cVar.eAh >= cVar.eAi) {
                if (j <= 0) {
                    this.fpC.setVisibility(0);
                    this.fpB.setVisibility(8);
                    this.fpC.setText(a.i.ala_go_wish_overdue);
                    this.fpA.setVisibility(8);
                }
                this.fpC.setText(a.i.ala_go_wish_success);
                this.fpA.setVisibility(8);
                return;
            }
            this.fpC.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.fpC.setVisibility(0);
                this.fpB.setVisibility(8);
                this.fpC.setText(a.i.ala_go_wish_overdue);
                this.fpA.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.fpA.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.fpA.setVisibility(0);
                a.this.fpA.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.f.a.df(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.fpA.setVisibility(8);
                a.this.fpC.setVisibility(0);
                a.this.fpB.setVisibility(8);
                a.this.fpC.setText(a.i.ala_go_wish_overdue);
                cVar.rt = 0L;
            }
        }.start());
    }
}
