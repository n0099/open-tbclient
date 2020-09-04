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
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.d;
/* loaded from: classes7.dex */
public class a {
    public long fwQ;
    public TbImageView gNE;
    public TextView gNF;
    public boolean gNJ;
    public TextView gNK;
    public TextView gNL;
    public HeadImageView gNM;
    public HeadImageView gNN;
    public HeadImageView gNO;
    public TextView gNP;
    public TextView gNQ;
    public TextView gNR;
    public AlaLiveWishListData gNS;
    public d gNT;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gNK = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.gNE = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.gNL = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.gNF = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.gNM = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.gNN = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.gNO = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.gNP = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.gNQ = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.gNR = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.gNS = alaLiveWishListData;
    }

    public void mL(boolean z) {
        this.gNJ = z;
    }

    public void el(long j) {
        this.fwQ = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.gNT = dVar;
        if (dVar != null) {
            this.gNK.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.gNE.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gNE.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gNE.setAutoChangeStyle(false);
            this.gNE.startLoad(dVar.fUw, 10, false);
            this.mProgress.setMax(dVar.fUy);
            this.mProgress.setProgress(dVar.fUx);
            this.gNM.setIsRound(true);
            this.gNN.setIsRound(true);
            this.gNO.setIsRound(true);
            k.a(this.gNM, TextUtils.isEmpty(dVar.fUz) ? "null" : dVar.fUz, true, false);
            k.a(this.gNN, TextUtils.isEmpty(dVar.fUA) ? "null" : dVar.fUA, true, false);
            k.a(this.gNO, TextUtils.isEmpty(dVar.fUB) ? "null" : dVar.fUB, true, false);
            this.gNL.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), dVar.mDesc));
            if (this.gNS != null) {
                this.gNF.setText(this.gNS.process_num + "/" + this.gNS.finish_num);
                this.mProgress.setMax(this.gNS.finish_num);
                this.mProgress.setProgress(this.gNS.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.gNP.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.LO * 1000;
            if (this.fwQ <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.fwQ * 1000);
            }
            if (this.gNS != null) {
                dVar.fUx = this.gNS.process_num;
                dVar.fUy = this.gNS.finish_num;
            }
            if (this.gNJ) {
                this.gNR.setVisibility(8);
                this.gNQ.setVisibility(0);
                if (dVar.fUx >= dVar.fUy) {
                    if (j <= 0) {
                        this.gNR.setVisibility(0);
                        this.gNQ.setVisibility(8);
                        this.gNR.setText(a.i.ala_go_wish_overdue);
                    }
                    this.gNR.setVisibility(0);
                    this.gNQ.setVisibility(8);
                    this.gNR.setText(a.i.ala_go_wish_success);
                    this.gNP.setVisibility(8);
                    return;
                }
                this.gNR.setVisibility(8);
                this.gNQ.setVisibility(0);
                if (j <= 0) {
                    this.gNR.setVisibility(0);
                    this.gNQ.setVisibility(8);
                    this.gNR.setText(a.i.ala_go_wish_overdue);
                    this.gNP.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.gNR.setVisibility(0);
            this.gNQ.setVisibility(8);
            if (dVar.fUx >= dVar.fUy) {
                if (j <= 0) {
                    this.gNR.setVisibility(0);
                    this.gNQ.setVisibility(8);
                    this.gNR.setText(a.i.ala_go_wish_overdue);
                    this.gNP.setVisibility(8);
                }
                this.gNR.setText(a.i.ala_go_wish_success);
                this.gNP.setVisibility(8);
                return;
            }
            this.gNR.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.gNR.setVisibility(0);
                this.gNQ.setVisibility(8);
                this.gNR.setText(a.i.ala_go_wish_overdue);
                this.gNP.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.gNP.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.gNP.setVisibility(0);
                a.this.gNP.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.g.a.ep(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.gNP.setVisibility(8);
                a.this.gNR.setVisibility(0);
                a.this.gNQ.setVisibility(8);
                a.this.gNR.setText(a.i.ala_go_wish_overdue);
                dVar.LO = 0L;
            }
        }.start());
    }
}
