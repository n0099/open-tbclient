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
    public long gsJ;
    public TbImageView hTb;
    public TextView hTc;
    public boolean hTg;
    public TextView hTh;
    public TextView hTi;
    public HeadImageView hTj;
    public HeadImageView hTk;
    public HeadImageView hTl;
    public TextView hTm;
    public TextView hTn;
    public TextView hTo;
    public AlaLiveWishListData hTp;
    public d hTq;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hTh = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hTb = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hTi = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hTc = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hTj = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hTk = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hTl = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hTm = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hTn = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hTo = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hTp = alaLiveWishListData;
    }

    public void oN(boolean z) {
        this.hTg = z;
    }

    public void fH(long j) {
        this.gsJ = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hTq = dVar;
        if (dVar != null) {
            this.hTh.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hTb.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hTb.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hTb.setAutoChangeStyle(false);
            this.hTb.startLoad(dVar.gUn, 10, false);
            this.mProgress.setMax(dVar.gUp);
            this.mProgress.setProgress(dVar.gUo);
            this.hTj.setIsRound(true);
            this.hTk.setIsRound(true);
            this.hTl.setIsRound(true);
            m.a(this.hTj, TextUtils.isEmpty(dVar.gUq) ? "null" : dVar.gUq, true, false);
            m.a(this.hTk, TextUtils.isEmpty(dVar.gUr) ? "null" : dVar.gUr, true, false);
            m.a(this.hTl, TextUtils.isEmpty(dVar.gUs) ? "null" : dVar.gUs, true, false);
            this.hTi.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hTp != null) {
                this.hTc.setText(this.hTp.process_num + "/" + this.hTp.finish_num);
                this.mProgress.setMax(this.hTp.finish_num);
                this.mProgress.setProgress(this.hTp.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hTm.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.MN * 1000;
            if (this.gsJ <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.gsJ * 1000);
            }
            if (this.hTp != null) {
                dVar.gUo = this.hTp.process_num;
                dVar.gUp = this.hTp.finish_num;
            }
            if (this.hTg) {
                this.hTo.setVisibility(8);
                this.hTn.setVisibility(0);
                if (dVar.gUo >= dVar.gUp) {
                    if (j <= 0) {
                        this.hTo.setVisibility(0);
                        this.hTn.setVisibility(8);
                        this.hTo.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hTo.setVisibility(0);
                    this.hTn.setVisibility(8);
                    this.hTo.setText(a.h.ala_go_wish_success);
                    this.hTm.setVisibility(8);
                    return;
                }
                this.hTo.setVisibility(8);
                this.hTn.setVisibility(0);
                if (j <= 0) {
                    this.hTo.setVisibility(0);
                    this.hTn.setVisibility(8);
                    this.hTo.setText(a.h.ala_go_wish_overdue);
                    this.hTm.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hTo.setVisibility(0);
            this.hTn.setVisibility(8);
            if (dVar.gUo >= dVar.gUp) {
                if (j <= 0) {
                    this.hTo.setVisibility(0);
                    this.hTn.setVisibility(8);
                    this.hTo.setText(a.h.ala_go_wish_overdue);
                    this.hTm.setVisibility(8);
                }
                this.hTo.setText(a.h.ala_go_wish_success);
                this.hTm.setVisibility(8);
                return;
            }
            this.hTo.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hTo.setVisibility(0);
                this.hTn.setVisibility(8);
                this.hTo.setText(a.h.ala_go_wish_overdue);
                this.hTm.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hTm.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hTm.setVisibility(0);
                a.this.hTm.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fO(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hTm.setVisibility(8);
                a.this.hTo.setVisibility(0);
                a.this.hTn.setVisibility(8);
                a.this.hTo.setText(a.h.ala_go_wish_overdue);
                dVar.MN = 0L;
            }
        }.start());
    }
}
