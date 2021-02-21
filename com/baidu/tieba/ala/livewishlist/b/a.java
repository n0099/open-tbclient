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
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.data.d;
/* loaded from: classes11.dex */
public class a {
    public TbImageView hTf;
    public TextView hTg;
    public boolean hTk;
    public TextView hTl;
    public TextView hTm;
    public HeadImageView hTn;
    public HeadImageView hTo;
    public HeadImageView hTp;
    public TextView hTq;
    public TextView hTr;
    public TextView hTs;
    public AlaLiveWishListData hTt;
    public d hTu;
    public Context mContext;
    public long mCurrentTime;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hTl = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hTf = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hTm = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hTg = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hTn = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hTo = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hTp = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hTq = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hTr = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hTs = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hTt = alaLiveWishListData;
    }

    public void oT(boolean z) {
        this.hTk = z;
    }

    public void fM(long j) {
        this.mCurrentTime = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hTu = dVar;
        if (dVar != null) {
            this.hTl.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hTf.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hTf.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hTf.setAutoChangeStyle(false);
            this.hTf.startLoad(dVar.gSE, 10, false);
            this.mProgress.setMax(dVar.gSG);
            this.mProgress.setProgress(dVar.gSF);
            this.hTn.setIsRound(true);
            this.hTo.setIsRound(true);
            this.hTp.setIsRound(true);
            m.a(this.hTn, TextUtils.isEmpty(dVar.gSH) ? "null" : dVar.gSH, true, false);
            m.a(this.hTo, TextUtils.isEmpty(dVar.gSI) ? "null" : dVar.gSI, true, false);
            m.a(this.hTp, TextUtils.isEmpty(dVar.gSJ) ? "null" : dVar.gSJ, true, false);
            this.hTm.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hTt != null) {
                this.hTg.setText(this.hTt.process_num + "/" + this.hTt.finish_num);
                this.mProgress.setMax(this.hTt.finish_num);
                this.mProgress.setProgress(this.hTt.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hTq.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.MH * 1000;
            if (this.mCurrentTime <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.mCurrentTime * 1000);
            }
            if (this.hTt != null) {
                dVar.gSF = this.hTt.process_num;
                dVar.gSG = this.hTt.finish_num;
            }
            if (this.hTk) {
                this.hTs.setVisibility(8);
                this.hTr.setVisibility(0);
                if (dVar.gSF >= dVar.gSG) {
                    if (j <= 0) {
                        this.hTs.setVisibility(0);
                        this.hTr.setVisibility(8);
                        this.hTs.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hTs.setVisibility(0);
                    this.hTr.setVisibility(8);
                    this.hTs.setText(a.h.ala_go_wish_success);
                    this.hTq.setVisibility(8);
                    return;
                }
                this.hTs.setVisibility(8);
                this.hTr.setVisibility(0);
                if (j <= 0) {
                    this.hTs.setVisibility(0);
                    this.hTr.setVisibility(8);
                    this.hTs.setText(a.h.ala_go_wish_overdue);
                    this.hTq.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hTs.setVisibility(0);
            this.hTr.setVisibility(8);
            if (dVar.gSF >= dVar.gSG) {
                if (j <= 0) {
                    this.hTs.setVisibility(0);
                    this.hTr.setVisibility(8);
                    this.hTs.setText(a.h.ala_go_wish_overdue);
                    this.hTq.setVisibility(8);
                }
                this.hTs.setText(a.h.ala_go_wish_success);
                this.hTq.setVisibility(8);
                return;
            }
            this.hTs.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hTs.setVisibility(0);
                this.hTr.setVisibility(8);
                this.hTs.setText(a.h.ala_go_wish_overdue);
                this.hTq.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hTq.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hTq.setVisibility(0);
                a.this.hTq.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fU(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hTq.setVisibility(8);
                a.this.hTs.setVisibility(0);
                a.this.hTr.setVisibility(8);
                a.this.hTs.setText(a.h.ala_go_wish_overdue);
                dVar.MH = 0L;
            }
        }.start());
    }
}
