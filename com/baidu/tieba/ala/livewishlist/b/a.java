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
    public long eJq;
    public TbImageView fTK;
    public TextView fTL;
    public boolean fTP;
    public TextView fTQ;
    public TextView fTR;
    public HeadImageView fTS;
    public HeadImageView fTT;
    public HeadImageView fTU;
    public TextView fTV;
    public TextView fTW;
    public TextView fTX;
    public AlaLiveWishListData fTY;
    public c fTZ;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.fTQ = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.fTK = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.fTR = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.fTL = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.fTS = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.fTT = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.fTU = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.fTV = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.fTW = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.fTX = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.fTY = alaLiveWishListData;
    }

    public void kY(boolean z) {
        this.fTP = z;
    }

    public void dJ(long j) {
        this.eJq = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.fTZ = cVar;
        if (cVar != null) {
            this.fTQ.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.fTK.setDefaultBgResource(a.f.icon_live_gift_default);
            this.fTK.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.fTK.setAutoChangeStyle(false);
            this.fTK.startLoad(cVar.feA, 10, false);
            this.mProgress.setMax(cVar.feC);
            this.mProgress.setProgress(cVar.feB);
            this.fTS.setIsRound(true);
            this.fTT.setIsRound(true);
            this.fTU.setIsRound(true);
            k.a(this.fTS, TextUtils.isEmpty(cVar.feD) ? "null" : cVar.feD, true, false);
            k.a(this.fTT, TextUtils.isEmpty(cVar.feE) ? "null" : cVar.feE, true, false);
            k.a(this.fTU, TextUtils.isEmpty(cVar.feF) ? "null" : cVar.feF, true, false);
            this.fTR.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.fTY != null) {
                this.fTL.setText(this.fTY.process_num + "/" + this.fTY.finish_num);
                this.mProgress.setMax(this.fTY.finish_num);
                this.mProgress.setProgress(this.fTY.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.fTV.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.Kt * 1000;
            if (this.eJq <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.eJq * 1000);
            }
            if (this.fTY != null) {
                cVar.feB = this.fTY.process_num;
                cVar.feC = this.fTY.finish_num;
            }
            if (this.fTP) {
                this.fTX.setVisibility(8);
                this.fTW.setVisibility(0);
                if (cVar.feB >= cVar.feC) {
                    if (j <= 0) {
                        this.fTX.setVisibility(0);
                        this.fTW.setVisibility(8);
                        this.fTX.setText(a.i.ala_go_wish_overdue);
                    }
                    this.fTX.setVisibility(0);
                    this.fTW.setVisibility(8);
                    this.fTX.setText(a.i.ala_go_wish_success);
                    this.fTV.setVisibility(8);
                    return;
                }
                this.fTX.setVisibility(8);
                this.fTW.setVisibility(0);
                if (j <= 0) {
                    this.fTX.setVisibility(0);
                    this.fTW.setVisibility(8);
                    this.fTX.setText(a.i.ala_go_wish_overdue);
                    this.fTV.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.fTX.setVisibility(0);
            this.fTW.setVisibility(8);
            if (cVar.feB >= cVar.feC) {
                if (j <= 0) {
                    this.fTX.setVisibility(0);
                    this.fTW.setVisibility(8);
                    this.fTX.setText(a.i.ala_go_wish_overdue);
                    this.fTV.setVisibility(8);
                }
                this.fTX.setText(a.i.ala_go_wish_success);
                this.fTV.setVisibility(8);
                return;
            }
            this.fTX.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.fTX.setVisibility(0);
                this.fTW.setVisibility(8);
                this.fTX.setText(a.i.ala_go_wish_overdue);
                this.fTV.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.fTV.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.fTV.setVisibility(0);
                a.this.fTV.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.g.a.dN(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.fTV.setVisibility(8);
                a.this.fTX.setVisibility(0);
                a.this.fTW.setVisibility(8);
                a.this.fTX.setText(a.i.ala_go_wish_overdue);
                cVar.Kt = 0L;
            }
        }.start());
    }
}
