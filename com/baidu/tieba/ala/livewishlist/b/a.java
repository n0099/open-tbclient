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
    public long gas;
    public TbImageView hxN;
    public TextView hxO;
    public boolean hxS;
    public TextView hxT;
    public TextView hxU;
    public HeadImageView hxV;
    public HeadImageView hxW;
    public HeadImageView hxX;
    public TextView hxY;
    public TextView hxZ;
    public TextView hya;
    public AlaLiveWishListData hyb;
    public d hyc;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hxT = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hxN = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hxU = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hxO = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hxV = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hxW = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hxX = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hxY = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hxZ = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hya = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hyb = alaLiveWishListData;
    }

    public void nS(boolean z) {
        this.hxS = z;
    }

    public void fd(long j) {
        this.gas = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hyc = dVar;
        if (dVar != null) {
            this.hxT.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hxN.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hxN.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hxN.setAutoChangeStyle(false);
            this.hxN.startLoad(dVar.gzW, 10, false);
            this.mProgress.setMax(dVar.gzY);
            this.mProgress.setProgress(dVar.gzX);
            this.hxV.setIsRound(true);
            this.hxW.setIsRound(true);
            this.hxX.setIsRound(true);
            l.a(this.hxV, TextUtils.isEmpty(dVar.gzZ) ? "null" : dVar.gzZ, true, false);
            l.a(this.hxW, TextUtils.isEmpty(dVar.gAa) ? "null" : dVar.gAa, true, false);
            l.a(this.hxX, TextUtils.isEmpty(dVar.gAb) ? "null" : dVar.gAb, true, false);
            this.hxU.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hyb != null) {
                this.hxO.setText(this.hyb.process_num + "/" + this.hyb.finish_num);
                this.mProgress.setMax(this.hyb.finish_num);
                this.mProgress.setProgress(this.hyb.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hxY.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Ms * 1000;
            if (this.gas <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.gas * 1000);
            }
            if (this.hyb != null) {
                dVar.gzX = this.hyb.process_num;
                dVar.gzY = this.hyb.finish_num;
            }
            if (this.hxS) {
                this.hya.setVisibility(8);
                this.hxZ.setVisibility(0);
                if (dVar.gzX >= dVar.gzY) {
                    if (j <= 0) {
                        this.hya.setVisibility(0);
                        this.hxZ.setVisibility(8);
                        this.hya.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hya.setVisibility(0);
                    this.hxZ.setVisibility(8);
                    this.hya.setText(a.h.ala_go_wish_success);
                    this.hxY.setVisibility(8);
                    return;
                }
                this.hya.setVisibility(8);
                this.hxZ.setVisibility(0);
                if (j <= 0) {
                    this.hya.setVisibility(0);
                    this.hxZ.setVisibility(8);
                    this.hya.setText(a.h.ala_go_wish_overdue);
                    this.hxY.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hya.setVisibility(0);
            this.hxZ.setVisibility(8);
            if (dVar.gzX >= dVar.gzY) {
                if (j <= 0) {
                    this.hya.setVisibility(0);
                    this.hxZ.setVisibility(8);
                    this.hya.setText(a.h.ala_go_wish_overdue);
                    this.hxY.setVisibility(8);
                }
                this.hya.setText(a.h.ala_go_wish_success);
                this.hxY.setVisibility(8);
                return;
            }
            this.hya.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hya.setVisibility(0);
                this.hxZ.setVisibility(8);
                this.hya.setText(a.h.ala_go_wish_overdue);
                this.hxY.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hxY.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hxY.setVisibility(0);
                a.this.hxY.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fk(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hxY.setVisibility(8);
                a.this.hya.setVisibility(0);
                a.this.hxZ.setVisibility(8);
                a.this.hya.setText(a.h.ala_go_wish_overdue);
                dVar.Ms = 0L;
            }
        }.start());
    }
}
