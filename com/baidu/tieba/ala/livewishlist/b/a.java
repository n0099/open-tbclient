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
/* loaded from: classes4.dex */
public class a {
    public long flq;
    public TbImageView gBd;
    public TextView gBe;
    public boolean gBi;
    public TextView gBj;
    public TextView gBk;
    public HeadImageView gBl;
    public HeadImageView gBm;
    public HeadImageView gBn;
    public TextView gBo;
    public TextView gBp;
    public TextView gBq;
    public AlaLiveWishListData gBr;
    public d gBs;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gBj = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.gBd = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.gBk = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.gBe = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.gBl = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.gBm = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.gBn = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.gBo = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.gBp = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.gBq = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.gBr = alaLiveWishListData;
    }

    public void mh(boolean z) {
        this.gBi = z;
    }

    public void ea(long j) {
        this.flq = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.gBs = dVar;
        if (dVar != null) {
            this.gBj.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.gBd.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gBd.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gBd.setAutoChangeStyle(false);
            this.gBd.startLoad(dVar.fJb, 10, false);
            this.mProgress.setMax(dVar.fJd);
            this.mProgress.setProgress(dVar.fJc);
            this.gBl.setIsRound(true);
            this.gBm.setIsRound(true);
            this.gBn.setIsRound(true);
            k.a(this.gBl, TextUtils.isEmpty(dVar.fJe) ? "null" : dVar.fJe, true, false);
            k.a(this.gBm, TextUtils.isEmpty(dVar.fJf) ? "null" : dVar.fJf, true, false);
            k.a(this.gBn, TextUtils.isEmpty(dVar.fJg) ? "null" : dVar.fJg, true, false);
            this.gBk.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), dVar.mDesc));
            if (this.gBr != null) {
                this.gBe.setText(this.gBr.process_num + "/" + this.gBr.finish_num);
                this.mProgress.setMax(this.gBr.finish_num);
                this.mProgress.setProgress(this.gBr.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.gBo.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Li * 1000;
            if (this.flq <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.flq * 1000);
            }
            if (this.gBr != null) {
                dVar.fJc = this.gBr.process_num;
                dVar.fJd = this.gBr.finish_num;
            }
            if (this.gBi) {
                this.gBq.setVisibility(8);
                this.gBp.setVisibility(0);
                if (dVar.fJc >= dVar.fJd) {
                    if (j <= 0) {
                        this.gBq.setVisibility(0);
                        this.gBp.setVisibility(8);
                        this.gBq.setText(a.i.ala_go_wish_overdue);
                    }
                    this.gBq.setVisibility(0);
                    this.gBp.setVisibility(8);
                    this.gBq.setText(a.i.ala_go_wish_success);
                    this.gBo.setVisibility(8);
                    return;
                }
                this.gBq.setVisibility(8);
                this.gBp.setVisibility(0);
                if (j <= 0) {
                    this.gBq.setVisibility(0);
                    this.gBp.setVisibility(8);
                    this.gBq.setText(a.i.ala_go_wish_overdue);
                    this.gBo.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.gBq.setVisibility(0);
            this.gBp.setVisibility(8);
            if (dVar.fJc >= dVar.fJd) {
                if (j <= 0) {
                    this.gBq.setVisibility(0);
                    this.gBp.setVisibility(8);
                    this.gBq.setText(a.i.ala_go_wish_overdue);
                    this.gBo.setVisibility(8);
                }
                this.gBq.setText(a.i.ala_go_wish_success);
                this.gBo.setVisibility(8);
                return;
            }
            this.gBq.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.gBq.setVisibility(0);
                this.gBp.setVisibility(8);
                this.gBq.setText(a.i.ala_go_wish_overdue);
                this.gBo.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.gBo.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.gBo.setVisibility(0);
                a.this.gBo.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.g.a.ee(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.gBo.setVisibility(8);
                a.this.gBq.setVisibility(0);
                a.this.gBp.setVisibility(8);
                a.this.gBq.setText(a.i.ala_go_wish_overdue);
                dVar.Li = 0L;
            }
        }.start());
    }
}
