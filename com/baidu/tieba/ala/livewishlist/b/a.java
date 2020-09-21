package com.baidu.tieba.ala.livewishlist.b;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.data.d;
/* loaded from: classes4.dex */
public class a {
    public long fAb;
    public TbImageView gQU;
    public TextView gQV;
    public boolean gQZ;
    public TextView gRa;
    public TextView gRb;
    public HeadImageView gRc;
    public HeadImageView gRd;
    public HeadImageView gRe;
    public TextView gRf;
    public TextView gRg;
    public TextView gRh;
    public AlaLiveWishListData gRi;
    public d gRj;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gRa = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.gQU = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.gRb = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.gQV = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.gRc = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.gRd = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.gRe = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.gRf = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.gRg = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.gRh = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.gRi = alaLiveWishListData;
    }

    public void mP(boolean z) {
        this.gQZ = z;
    }

    public void eo(long j) {
        this.fAb = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.gRj = dVar;
        if (dVar != null) {
            this.gRa.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.gQU.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gQU.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gQU.setAutoChangeStyle(false);
            this.gQU.startLoad(dVar.fXL, 10, false);
            this.mProgress.setMax(dVar.fXN);
            this.mProgress.setProgress(dVar.fXM);
            this.gRc.setIsRound(true);
            this.gRd.setIsRound(true);
            this.gRe.setIsRound(true);
            l.a(this.gRc, TextUtils.isEmpty(dVar.fXO) ? "null" : dVar.fXO, true, false);
            l.a(this.gRd, TextUtils.isEmpty(dVar.fXP) ? "null" : dVar.fXP, true, false);
            l.a(this.gRe, TextUtils.isEmpty(dVar.fXQ) ? "null" : dVar.fXQ, true, false);
            this.gRb.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), dVar.mDesc));
            if (this.gRi != null) {
                this.gQV.setText(this.gRi.process_num + "/" + this.gRi.finish_num);
                this.mProgress.setMax(this.gRi.finish_num);
                this.mProgress.setProgress(this.gRi.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.gRf.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Mb * 1000;
            if (this.fAb <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.fAb * 1000);
            }
            if (this.gRi != null) {
                dVar.fXM = this.gRi.process_num;
                dVar.fXN = this.gRi.finish_num;
            }
            if (this.gQZ) {
                this.gRh.setVisibility(8);
                this.gRg.setVisibility(0);
                if (dVar.fXM >= dVar.fXN) {
                    if (j <= 0) {
                        this.gRh.setVisibility(0);
                        this.gRg.setVisibility(8);
                        this.gRh.setText(a.i.ala_go_wish_overdue);
                    }
                    this.gRh.setVisibility(0);
                    this.gRg.setVisibility(8);
                    this.gRh.setText(a.i.ala_go_wish_success);
                    this.gRf.setVisibility(8);
                    return;
                }
                this.gRh.setVisibility(8);
                this.gRg.setVisibility(0);
                if (j <= 0) {
                    this.gRh.setVisibility(0);
                    this.gRg.setVisibility(8);
                    this.gRh.setText(a.i.ala_go_wish_overdue);
                    this.gRf.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.gRh.setVisibility(0);
            this.gRg.setVisibility(8);
            if (dVar.fXM >= dVar.fXN) {
                if (j <= 0) {
                    this.gRh.setVisibility(0);
                    this.gRg.setVisibility(8);
                    this.gRh.setText(a.i.ala_go_wish_overdue);
                    this.gRf.setVisibility(8);
                }
                this.gRh.setText(a.i.ala_go_wish_success);
                this.gRf.setVisibility(8);
                return;
            }
            this.gRh.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.gRh.setVisibility(0);
                this.gRg.setVisibility(8);
                this.gRh.setText(a.i.ala_go_wish_overdue);
                this.gRf.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.gRf.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.gRf.setVisibility(0);
                a.this.gRf.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.i.a.ew(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.gRf.setVisibility(8);
                a.this.gRh.setVisibility(0);
                a.this.gRg.setVisibility(8);
                a.this.gRh.setText(a.i.ala_go_wish_overdue);
                dVar.Mb = 0L;
            }
        }.start());
    }
}
