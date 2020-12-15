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
    public long gim;
    public TbImageView hHb;
    public TextView hHc;
    public boolean hHg;
    public TextView hHh;
    public TextView hHi;
    public HeadImageView hHj;
    public HeadImageView hHk;
    public HeadImageView hHl;
    public TextView hHm;
    public TextView hHn;
    public TextView hHo;
    public AlaLiveWishListData hHp;
    public d hHq;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hHh = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hHb = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hHi = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hHc = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hHj = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hHk = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hHl = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hHm = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hHn = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hHo = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hHp = alaLiveWishListData;
    }

    public void oo(boolean z) {
        this.hHg = z;
    }

    public void fH(long j) {
        this.gim = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hHq = dVar;
        if (dVar != null) {
            this.hHh.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hHb.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hHb.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hHb.setAutoChangeStyle(false);
            this.hHb.startLoad(dVar.gIB, 10, false);
            this.mProgress.setMax(dVar.gID);
            this.mProgress.setProgress(dVar.gIC);
            this.hHj.setIsRound(true);
            this.hHk.setIsRound(true);
            this.hHl.setIsRound(true);
            l.a(this.hHj, TextUtils.isEmpty(dVar.gIE) ? "null" : dVar.gIE, true, false);
            l.a(this.hHk, TextUtils.isEmpty(dVar.gIF) ? "null" : dVar.gIF, true, false);
            l.a(this.hHl, TextUtils.isEmpty(dVar.gIG) ? "null" : dVar.gIG, true, false);
            this.hHi.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hHp != null) {
                this.hHc.setText(this.hHp.process_num + "/" + this.hHp.finish_num);
                this.mProgress.setMax(this.hHp.finish_num);
                this.mProgress.setProgress(this.hHp.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hHm.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Nn * 1000;
            if (this.gim <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.gim * 1000);
            }
            if (this.hHp != null) {
                dVar.gIC = this.hHp.process_num;
                dVar.gID = this.hHp.finish_num;
            }
            if (this.hHg) {
                this.hHo.setVisibility(8);
                this.hHn.setVisibility(0);
                if (dVar.gIC >= dVar.gID) {
                    if (j <= 0) {
                        this.hHo.setVisibility(0);
                        this.hHn.setVisibility(8);
                        this.hHo.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hHo.setVisibility(0);
                    this.hHn.setVisibility(8);
                    this.hHo.setText(a.h.ala_go_wish_success);
                    this.hHm.setVisibility(8);
                    return;
                }
                this.hHo.setVisibility(8);
                this.hHn.setVisibility(0);
                if (j <= 0) {
                    this.hHo.setVisibility(0);
                    this.hHn.setVisibility(8);
                    this.hHo.setText(a.h.ala_go_wish_overdue);
                    this.hHm.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hHo.setVisibility(0);
            this.hHn.setVisibility(8);
            if (dVar.gIC >= dVar.gID) {
                if (j <= 0) {
                    this.hHo.setVisibility(0);
                    this.hHn.setVisibility(8);
                    this.hHo.setText(a.h.ala_go_wish_overdue);
                    this.hHm.setVisibility(8);
                }
                this.hHo.setText(a.h.ala_go_wish_success);
                this.hHm.setVisibility(8);
                return;
            }
            this.hHo.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hHo.setVisibility(0);
                this.hHn.setVisibility(8);
                this.hHo.setText(a.h.ala_go_wish_overdue);
                this.hHm.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hHm.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hHm.setVisibility(0);
                a.this.hHm.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fO(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hHm.setVisibility(8);
                a.this.hHo.setVisibility(0);
                a.this.hHn.setVisibility(8);
                a.this.hHo.setText(a.h.ala_go_wish_overdue);
                dVar.Nn = 0L;
            }
        }.start());
    }
}
