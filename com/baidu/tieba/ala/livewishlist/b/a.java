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
    public long fwM;
    public TbImageView gNA;
    public TextView gNB;
    public boolean gNF;
    public TextView gNG;
    public TextView gNH;
    public HeadImageView gNI;
    public HeadImageView gNJ;
    public HeadImageView gNK;
    public TextView gNL;
    public TextView gNM;
    public TextView gNN;
    public AlaLiveWishListData gNO;
    public d gNP;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gNG = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.gNA = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.gNH = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.gNB = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.gNI = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.gNJ = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.gNK = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.gNL = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.gNM = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.gNN = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.gNO = alaLiveWishListData;
    }

    public void mJ(boolean z) {
        this.gNF = z;
    }

    public void el(long j) {
        this.fwM = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.gNP = dVar;
        if (dVar != null) {
            this.gNG.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.gNA.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gNA.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gNA.setAutoChangeStyle(false);
            this.gNA.startLoad(dVar.fUs, 10, false);
            this.mProgress.setMax(dVar.fUu);
            this.mProgress.setProgress(dVar.fUt);
            this.gNI.setIsRound(true);
            this.gNJ.setIsRound(true);
            this.gNK.setIsRound(true);
            k.a(this.gNI, TextUtils.isEmpty(dVar.fUv) ? "null" : dVar.fUv, true, false);
            k.a(this.gNJ, TextUtils.isEmpty(dVar.fUw) ? "null" : dVar.fUw, true, false);
            k.a(this.gNK, TextUtils.isEmpty(dVar.fUx) ? "null" : dVar.fUx, true, false);
            this.gNH.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), dVar.mDesc));
            if (this.gNO != null) {
                this.gNB.setText(this.gNO.process_num + "/" + this.gNO.finish_num);
                this.mProgress.setMax(this.gNO.finish_num);
                this.mProgress.setProgress(this.gNO.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.gNL.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.LO * 1000;
            if (this.fwM <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.fwM * 1000);
            }
            if (this.gNO != null) {
                dVar.fUt = this.gNO.process_num;
                dVar.fUu = this.gNO.finish_num;
            }
            if (this.gNF) {
                this.gNN.setVisibility(8);
                this.gNM.setVisibility(0);
                if (dVar.fUt >= dVar.fUu) {
                    if (j <= 0) {
                        this.gNN.setVisibility(0);
                        this.gNM.setVisibility(8);
                        this.gNN.setText(a.i.ala_go_wish_overdue);
                    }
                    this.gNN.setVisibility(0);
                    this.gNM.setVisibility(8);
                    this.gNN.setText(a.i.ala_go_wish_success);
                    this.gNL.setVisibility(8);
                    return;
                }
                this.gNN.setVisibility(8);
                this.gNM.setVisibility(0);
                if (j <= 0) {
                    this.gNN.setVisibility(0);
                    this.gNM.setVisibility(8);
                    this.gNN.setText(a.i.ala_go_wish_overdue);
                    this.gNL.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.gNN.setVisibility(0);
            this.gNM.setVisibility(8);
            if (dVar.fUt >= dVar.fUu) {
                if (j <= 0) {
                    this.gNN.setVisibility(0);
                    this.gNM.setVisibility(8);
                    this.gNN.setText(a.i.ala_go_wish_overdue);
                    this.gNL.setVisibility(8);
                }
                this.gNN.setText(a.i.ala_go_wish_success);
                this.gNL.setVisibility(8);
                return;
            }
            this.gNN.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.gNN.setVisibility(0);
                this.gNM.setVisibility(8);
                this.gNN.setText(a.i.ala_go_wish_overdue);
                this.gNL.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.gNL.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.gNL.setVisibility(0);
                a.this.gNL.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.g.a.ep(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.gNL.setVisibility(8);
                a.this.gNN.setVisibility(0);
                a.this.gNM.setVisibility(8);
                a.this.gNN.setText(a.i.ala_go_wish_overdue);
                dVar.LO = 0L;
            }
        }.start());
    }
}
