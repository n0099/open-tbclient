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
    public TbImageView hSR;
    public TextView hSS;
    public boolean hSW;
    public TextView hSX;
    public TextView hSY;
    public HeadImageView hSZ;
    public HeadImageView hTa;
    public HeadImageView hTb;
    public TextView hTc;
    public TextView hTd;
    public TextView hTe;
    public AlaLiveWishListData hTf;
    public d hTg;
    public Context mContext;
    public long mCurrentTime;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hSX = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hSR = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hSY = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hSS = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hSZ = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hTa = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hTb = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hTc = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hTd = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hTe = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hTf = alaLiveWishListData;
    }

    public void oT(boolean z) {
        this.hSW = z;
    }

    public void fM(long j) {
        this.mCurrentTime = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hTg = dVar;
        if (dVar != null) {
            this.hSX.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hSR.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hSR.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hSR.setAutoChangeStyle(false);
            this.hSR.startLoad(dVar.gSq, 10, false);
            this.mProgress.setMax(dVar.gSs);
            this.mProgress.setProgress(dVar.gSr);
            this.hSZ.setIsRound(true);
            this.hTa.setIsRound(true);
            this.hTb.setIsRound(true);
            m.a(this.hSZ, TextUtils.isEmpty(dVar.gSt) ? "null" : dVar.gSt, true, false);
            m.a(this.hTa, TextUtils.isEmpty(dVar.gSu) ? "null" : dVar.gSu, true, false);
            m.a(this.hTb, TextUtils.isEmpty(dVar.gSv) ? "null" : dVar.gSv, true, false);
            this.hSY.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hTf != null) {
                this.hSS.setText(this.hTf.process_num + "/" + this.hTf.finish_num);
                this.mProgress.setMax(this.hTf.finish_num);
                this.mProgress.setProgress(this.hTf.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hTc.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.MH * 1000;
            if (this.mCurrentTime <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.mCurrentTime * 1000);
            }
            if (this.hTf != null) {
                dVar.gSr = this.hTf.process_num;
                dVar.gSs = this.hTf.finish_num;
            }
            if (this.hSW) {
                this.hTe.setVisibility(8);
                this.hTd.setVisibility(0);
                if (dVar.gSr >= dVar.gSs) {
                    if (j <= 0) {
                        this.hTe.setVisibility(0);
                        this.hTd.setVisibility(8);
                        this.hTe.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hTe.setVisibility(0);
                    this.hTd.setVisibility(8);
                    this.hTe.setText(a.h.ala_go_wish_success);
                    this.hTc.setVisibility(8);
                    return;
                }
                this.hTe.setVisibility(8);
                this.hTd.setVisibility(0);
                if (j <= 0) {
                    this.hTe.setVisibility(0);
                    this.hTd.setVisibility(8);
                    this.hTe.setText(a.h.ala_go_wish_overdue);
                    this.hTc.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hTe.setVisibility(0);
            this.hTd.setVisibility(8);
            if (dVar.gSr >= dVar.gSs) {
                if (j <= 0) {
                    this.hTe.setVisibility(0);
                    this.hTd.setVisibility(8);
                    this.hTe.setText(a.h.ala_go_wish_overdue);
                    this.hTc.setVisibility(8);
                }
                this.hTe.setText(a.h.ala_go_wish_success);
                this.hTc.setVisibility(8);
                return;
            }
            this.hTe.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hTe.setVisibility(0);
                this.hTd.setVisibility(8);
                this.hTe.setText(a.h.ala_go_wish_overdue);
                this.hTc.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hTc.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hTc.setVisibility(0);
                a.this.hTc.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fU(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hTc.setVisibility(8);
                a.this.hTe.setVisibility(0);
                a.this.hTd.setVisibility(8);
                a.this.hTe.setText(a.h.ala_go_wish_overdue);
                dVar.MH = 0L;
            }
        }.start());
    }
}
