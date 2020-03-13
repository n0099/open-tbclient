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
    public long ejo;
    public TbImageView foP;
    public TextView foQ;
    public boolean foU;
    public TextView foV;
    public TextView foW;
    public HeadImageView foX;
    public HeadImageView foY;
    public HeadImageView foZ;
    public TextView fpa;
    public TextView fpb;
    public TextView fpc;
    public AlaLiveWishListData fpd;
    public c fpe;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.foV = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.foP = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.foW = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.foQ = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.foX = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.foY = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.foZ = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.fpa = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.fpb = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.fpc = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.fpd = alaLiveWishListData;
    }

    public void jS(boolean z) {
        this.foU = z;
    }

    public void db(long j) {
        this.ejo = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.fpe = cVar;
        if (cVar != null) {
            this.foV.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.foP.setDefaultBgResource(a.f.icon_live_gift_default);
            this.foP.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.foP.setAutoChangeStyle(false);
            this.foP.startLoad(cVar.ezK, 10, false);
            this.mProgress.setMax(cVar.ezM);
            this.mProgress.setProgress(cVar.ezL);
            this.foX.setIsRound(true);
            this.foY.setIsRound(true);
            this.foZ.setIsRound(true);
            k.a(this.foX, TextUtils.isEmpty(cVar.ezN) ? "null" : cVar.ezN, true, false);
            k.a(this.foY, TextUtils.isEmpty(cVar.ezO) ? "null" : cVar.ezO, true, false);
            k.a(this.foZ, TextUtils.isEmpty(cVar.ezP) ? "null" : cVar.ezP, true, false);
            this.foW.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.fpd != null) {
                this.foQ.setText(this.fpd.process_num + "/" + this.fpd.finish_num);
                this.mProgress.setMax(this.fpd.finish_num);
                this.mProgress.setProgress(this.fpd.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.fpa.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.rt * 1000;
            if (this.ejo <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.ejo * 1000);
            }
            if (this.fpd != null) {
                cVar.ezL = this.fpd.process_num;
                cVar.ezM = this.fpd.finish_num;
            }
            if (this.foU) {
                this.fpc.setVisibility(8);
                this.fpb.setVisibility(0);
                if (cVar.ezL >= cVar.ezM) {
                    if (j <= 0) {
                        this.fpc.setVisibility(0);
                        this.fpb.setVisibility(8);
                        this.fpc.setText(a.i.ala_go_wish_overdue);
                    }
                    this.fpc.setVisibility(0);
                    this.fpb.setVisibility(8);
                    this.fpc.setText(a.i.ala_go_wish_success);
                    this.fpa.setVisibility(8);
                    return;
                }
                this.fpc.setVisibility(8);
                this.fpb.setVisibility(0);
                if (j <= 0) {
                    this.fpc.setVisibility(0);
                    this.fpb.setVisibility(8);
                    this.fpc.setText(a.i.ala_go_wish_overdue);
                    this.fpa.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.fpc.setVisibility(0);
            this.fpb.setVisibility(8);
            if (cVar.ezL >= cVar.ezM) {
                if (j <= 0) {
                    this.fpc.setVisibility(0);
                    this.fpb.setVisibility(8);
                    this.fpc.setText(a.i.ala_go_wish_overdue);
                    this.fpa.setVisibility(8);
                }
                this.fpc.setText(a.i.ala_go_wish_success);
                this.fpa.setVisibility(8);
                return;
            }
            this.fpc.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.fpc.setVisibility(0);
                this.fpb.setVisibility(8);
                this.fpc.setText(a.i.ala_go_wish_overdue);
                this.fpa.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.fpa.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.fpa.setVisibility(0);
                a.this.fpa.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.f.a.df(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.fpa.setVisibility(8);
                a.this.fpc.setVisibility(0);
                a.this.fpb.setVisibility(8);
                a.this.fpc.setText(a.i.ala_go_wish_overdue);
                cVar.rt = 0L;
            }
        }.start());
    }
}
