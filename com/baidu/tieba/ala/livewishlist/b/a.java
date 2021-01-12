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
/* loaded from: classes10.dex */
public class a {
    public long goc;
    public boolean hOA;
    public TextView hOB;
    public TextView hOC;
    public HeadImageView hOD;
    public HeadImageView hOE;
    public HeadImageView hOF;
    public TextView hOG;
    public TextView hOH;
    public TextView hOI;
    public AlaLiveWishListData hOJ;
    public d hOK;
    public TbImageView hOv;
    public TextView hOw;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hOB = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hOv = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hOC = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hOw = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hOD = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hOE = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hOF = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hOG = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hOH = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hOI = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hOJ = alaLiveWishListData;
    }

    public void oJ(boolean z) {
        this.hOA = z;
    }

    public void fH(long j) {
        this.goc = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hOK = dVar;
        if (dVar != null) {
            this.hOB.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hOv.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hOv.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hOv.setAutoChangeStyle(false);
            this.hOv.startLoad(dVar.gPH, 10, false);
            this.mProgress.setMax(dVar.gPJ);
            this.mProgress.setProgress(dVar.gPI);
            this.hOD.setIsRound(true);
            this.hOE.setIsRound(true);
            this.hOF.setIsRound(true);
            m.a(this.hOD, TextUtils.isEmpty(dVar.gPK) ? "null" : dVar.gPK, true, false);
            m.a(this.hOE, TextUtils.isEmpty(dVar.gPL) ? "null" : dVar.gPL, true, false);
            m.a(this.hOF, TextUtils.isEmpty(dVar.gPM) ? "null" : dVar.gPM, true, false);
            this.hOC.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hOJ != null) {
                this.hOw.setText(this.hOJ.process_num + "/" + this.hOJ.finish_num);
                this.mProgress.setMax(this.hOJ.finish_num);
                this.mProgress.setProgress(this.hOJ.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hOG.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.MJ * 1000;
            if (this.goc <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.goc * 1000);
            }
            if (this.hOJ != null) {
                dVar.gPI = this.hOJ.process_num;
                dVar.gPJ = this.hOJ.finish_num;
            }
            if (this.hOA) {
                this.hOI.setVisibility(8);
                this.hOH.setVisibility(0);
                if (dVar.gPI >= dVar.gPJ) {
                    if (j <= 0) {
                        this.hOI.setVisibility(0);
                        this.hOH.setVisibility(8);
                        this.hOI.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hOI.setVisibility(0);
                    this.hOH.setVisibility(8);
                    this.hOI.setText(a.h.ala_go_wish_success);
                    this.hOG.setVisibility(8);
                    return;
                }
                this.hOI.setVisibility(8);
                this.hOH.setVisibility(0);
                if (j <= 0) {
                    this.hOI.setVisibility(0);
                    this.hOH.setVisibility(8);
                    this.hOI.setText(a.h.ala_go_wish_overdue);
                    this.hOG.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hOI.setVisibility(0);
            this.hOH.setVisibility(8);
            if (dVar.gPI >= dVar.gPJ) {
                if (j <= 0) {
                    this.hOI.setVisibility(0);
                    this.hOH.setVisibility(8);
                    this.hOI.setText(a.h.ala_go_wish_overdue);
                    this.hOG.setVisibility(8);
                }
                this.hOI.setText(a.h.ala_go_wish_success);
                this.hOG.setVisibility(8);
                return;
            }
            this.hOI.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hOI.setVisibility(0);
                this.hOH.setVisibility(8);
                this.hOI.setText(a.h.ala_go_wish_overdue);
                this.hOG.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hOG.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hOG.setVisibility(0);
                a.this.hOG.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fO(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hOG.setVisibility(8);
                a.this.hOI.setVisibility(0);
                a.this.hOH.setVisibility(8);
                a.this.hOI.setText(a.h.ala_go_wish_overdue);
                dVar.MJ = 0L;
            }
        }.start());
    }
}
