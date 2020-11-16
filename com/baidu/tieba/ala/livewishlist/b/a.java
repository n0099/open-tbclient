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
    public long fZY;
    public TextView hxA;
    public TextView hxB;
    public HeadImageView hxC;
    public HeadImageView hxD;
    public HeadImageView hxE;
    public TextView hxF;
    public TextView hxG;
    public TextView hxH;
    public AlaLiveWishListData hxI;
    public d hxJ;
    public TbImageView hxu;
    public TextView hxv;
    public boolean hxz;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hxA = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hxu = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hxB = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hxv = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hxC = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hxD = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hxE = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hxF = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hxG = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hxH = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hxI = alaLiveWishListData;
    }

    public void nT(boolean z) {
        this.hxz = z;
    }

    public void fd(long j) {
        this.fZY = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hxJ = dVar;
        if (dVar != null) {
            this.hxA.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hxu.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hxu.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hxu.setAutoChangeStyle(false);
            this.hxu.startLoad(dVar.gzD, 10, false);
            this.mProgress.setMax(dVar.gzF);
            this.mProgress.setProgress(dVar.gzE);
            this.hxC.setIsRound(true);
            this.hxD.setIsRound(true);
            this.hxE.setIsRound(true);
            l.a(this.hxC, TextUtils.isEmpty(dVar.gzG) ? "null" : dVar.gzG, true, false);
            l.a(this.hxD, TextUtils.isEmpty(dVar.gzH) ? "null" : dVar.gzH, true, false);
            l.a(this.hxE, TextUtils.isEmpty(dVar.gzI) ? "null" : dVar.gzI, true, false);
            this.hxB.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hxI != null) {
                this.hxv.setText(this.hxI.process_num + "/" + this.hxI.finish_num);
                this.mProgress.setMax(this.hxI.finish_num);
                this.mProgress.setProgress(this.hxI.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hxF.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Ms * 1000;
            if (this.fZY <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.fZY * 1000);
            }
            if (this.hxI != null) {
                dVar.gzE = this.hxI.process_num;
                dVar.gzF = this.hxI.finish_num;
            }
            if (this.hxz) {
                this.hxH.setVisibility(8);
                this.hxG.setVisibility(0);
                if (dVar.gzE >= dVar.gzF) {
                    if (j <= 0) {
                        this.hxH.setVisibility(0);
                        this.hxG.setVisibility(8);
                        this.hxH.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hxH.setVisibility(0);
                    this.hxG.setVisibility(8);
                    this.hxH.setText(a.h.ala_go_wish_success);
                    this.hxF.setVisibility(8);
                    return;
                }
                this.hxH.setVisibility(8);
                this.hxG.setVisibility(0);
                if (j <= 0) {
                    this.hxH.setVisibility(0);
                    this.hxG.setVisibility(8);
                    this.hxH.setText(a.h.ala_go_wish_overdue);
                    this.hxF.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hxH.setVisibility(0);
            this.hxG.setVisibility(8);
            if (dVar.gzE >= dVar.gzF) {
                if (j <= 0) {
                    this.hxH.setVisibility(0);
                    this.hxG.setVisibility(8);
                    this.hxH.setText(a.h.ala_go_wish_overdue);
                    this.hxF.setVisibility(8);
                }
                this.hxH.setText(a.h.ala_go_wish_success);
                this.hxF.setVisibility(8);
                return;
            }
            this.hxH.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hxH.setVisibility(0);
                this.hxG.setVisibility(8);
                this.hxH.setText(a.h.ala_go_wish_overdue);
                this.hxF.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hxF.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hxF.setVisibility(0);
                a.this.hxF.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fk(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hxF.setVisibility(8);
                a.this.hxH.setVisibility(0);
                a.this.hxG.setVisibility(8);
                a.this.hxH.setText(a.h.ala_go_wish_overdue);
                dVar.Ms = 0L;
            }
        }.start());
    }
}
