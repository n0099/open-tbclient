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
    public long fUB;
    public TbImageView hrQ;
    public TextView hrR;
    public boolean hrV;
    public TextView hrW;
    public TextView hrX;
    public HeadImageView hrY;
    public HeadImageView hrZ;
    public HeadImageView hsa;
    public TextView hsb;
    public TextView hsc;
    public TextView hsd;
    public AlaLiveWishListData hse;
    public d hsf;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hrW = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.hrQ = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.hrX = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.hrR = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.hrY = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.hrZ = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.hsa = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.hsb = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.hsc = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.hsd = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hse = alaLiveWishListData;
    }

    public void nJ(boolean z) {
        this.hrV = z;
    }

    public void eH(long j) {
        this.fUB = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hsf = dVar;
        if (dVar != null) {
            this.hrW.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hrQ.setDefaultBgResource(a.f.icon_live_gift_default);
            this.hrQ.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.hrQ.setAutoChangeStyle(false);
            this.hrQ.startLoad(dVar.gui, 10, false);
            this.mProgress.setMax(dVar.guk);
            this.mProgress.setProgress(dVar.guj);
            this.hrY.setIsRound(true);
            this.hrZ.setIsRound(true);
            this.hsa.setIsRound(true);
            l.a(this.hrY, TextUtils.isEmpty(dVar.gul) ? "null" : dVar.gul, true, false);
            l.a(this.hrZ, TextUtils.isEmpty(dVar.gum) ? "null" : dVar.gum, true, false);
            l.a(this.hsa, TextUtils.isEmpty(dVar.gun) ? "null" : dVar.gun, true, false);
            this.hrX.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), dVar.mDesc));
            if (this.hse != null) {
                this.hrR.setText(this.hse.process_num + "/" + this.hse.finish_num);
                this.mProgress.setMax(this.hse.finish_num);
                this.mProgress.setProgress(this.hse.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hsb.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Ms * 1000;
            if (this.fUB <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.fUB * 1000);
            }
            if (this.hse != null) {
                dVar.guj = this.hse.process_num;
                dVar.guk = this.hse.finish_num;
            }
            if (this.hrV) {
                this.hsd.setVisibility(8);
                this.hsc.setVisibility(0);
                if (dVar.guj >= dVar.guk) {
                    if (j <= 0) {
                        this.hsd.setVisibility(0);
                        this.hsc.setVisibility(8);
                        this.hsd.setText(a.i.ala_go_wish_overdue);
                    }
                    this.hsd.setVisibility(0);
                    this.hsc.setVisibility(8);
                    this.hsd.setText(a.i.ala_go_wish_success);
                    this.hsb.setVisibility(8);
                    return;
                }
                this.hsd.setVisibility(8);
                this.hsc.setVisibility(0);
                if (j <= 0) {
                    this.hsd.setVisibility(0);
                    this.hsc.setVisibility(8);
                    this.hsd.setText(a.i.ala_go_wish_overdue);
                    this.hsb.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hsd.setVisibility(0);
            this.hsc.setVisibility(8);
            if (dVar.guj >= dVar.guk) {
                if (j <= 0) {
                    this.hsd.setVisibility(0);
                    this.hsc.setVisibility(8);
                    this.hsd.setText(a.i.ala_go_wish_overdue);
                    this.hsb.setVisibility(8);
                }
                this.hsd.setText(a.i.ala_go_wish_success);
                this.hsb.setVisibility(8);
                return;
            }
            this.hsd.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.hsd.setVisibility(0);
                this.hsc.setVisibility(8);
                this.hsd.setText(a.i.ala_go_wish_overdue);
                this.hsb.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hsb.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hsb.setVisibility(0);
                a.this.hsb.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.i.a.eO(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hsb.setVisibility(8);
                a.this.hsd.setVisibility(0);
                a.this.hsc.setVisibility(8);
                a.this.hsd.setText(a.i.ala_go_wish_overdue);
                dVar.Ms = 0L;
            }
        }.start());
    }
}
