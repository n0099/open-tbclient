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
    public TbImageView hUO;
    public TextView hUP;
    public boolean hUT;
    public TextView hUU;
    public TextView hUV;
    public HeadImageView hUW;
    public HeadImageView hUX;
    public HeadImageView hUY;
    public TextView hUZ;
    public TextView hVa;
    public TextView hVb;
    public AlaLiveWishListData hVc;
    public d hVd;
    public Context mContext;
    public long mCurrentTime;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hUU = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hUO = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hUV = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hUP = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hUW = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hUX = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hUY = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hUZ = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hVa = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hVb = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hVc = alaLiveWishListData;
    }

    public void oT(boolean z) {
        this.hUT = z;
    }

    public void fM(long j) {
        this.mCurrentTime = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hVd = dVar;
        if (dVar != null) {
            this.hUU.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hUO.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hUO.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hUO.setAutoChangeStyle(false);
            this.hUO.startLoad(dVar.gUn, 10, false);
            this.mProgress.setMax(dVar.gUp);
            this.mProgress.setProgress(dVar.gUo);
            this.hUW.setIsRound(true);
            this.hUX.setIsRound(true);
            this.hUY.setIsRound(true);
            m.a(this.hUW, TextUtils.isEmpty(dVar.gUq) ? "null" : dVar.gUq, true, false);
            m.a(this.hUX, TextUtils.isEmpty(dVar.gUr) ? "null" : dVar.gUr, true, false);
            m.a(this.hUY, TextUtils.isEmpty(dVar.gUs) ? "null" : dVar.gUs, true, false);
            this.hUV.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hVc != null) {
                this.hUP.setText(this.hVc.process_num + "/" + this.hVc.finish_num);
                this.mProgress.setMax(this.hVc.finish_num);
                this.mProgress.setProgress(this.hVc.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hUZ.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Oh * 1000;
            if (this.mCurrentTime <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.mCurrentTime * 1000);
            }
            if (this.hVc != null) {
                dVar.gUo = this.hVc.process_num;
                dVar.gUp = this.hVc.finish_num;
            }
            if (this.hUT) {
                this.hVb.setVisibility(8);
                this.hVa.setVisibility(0);
                if (dVar.gUo >= dVar.gUp) {
                    if (j <= 0) {
                        this.hVb.setVisibility(0);
                        this.hVa.setVisibility(8);
                        this.hVb.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hVb.setVisibility(0);
                    this.hVa.setVisibility(8);
                    this.hVb.setText(a.h.ala_go_wish_success);
                    this.hUZ.setVisibility(8);
                    return;
                }
                this.hVb.setVisibility(8);
                this.hVa.setVisibility(0);
                if (j <= 0) {
                    this.hVb.setVisibility(0);
                    this.hVa.setVisibility(8);
                    this.hVb.setText(a.h.ala_go_wish_overdue);
                    this.hUZ.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hVb.setVisibility(0);
            this.hVa.setVisibility(8);
            if (dVar.gUo >= dVar.gUp) {
                if (j <= 0) {
                    this.hVb.setVisibility(0);
                    this.hVa.setVisibility(8);
                    this.hVb.setText(a.h.ala_go_wish_overdue);
                    this.hUZ.setVisibility(8);
                }
                this.hVb.setText(a.h.ala_go_wish_success);
                this.hUZ.setVisibility(8);
                return;
            }
            this.hVb.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hVb.setVisibility(0);
                this.hVa.setVisibility(8);
                this.hVb.setText(a.h.ala_go_wish_overdue);
                this.hUZ.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hUZ.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hUZ.setVisibility(0);
                a.this.hUZ.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fU(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hUZ.setVisibility(8);
                a.this.hVb.setVisibility(0);
                a.this.hVa.setVisibility(8);
                a.this.hVb.setText(a.h.ala_go_wish_overdue);
                dVar.Oh = 0L;
            }
        }.start());
    }
}
