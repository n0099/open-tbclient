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
    public long gik;
    public TbImageView hGZ;
    public TextView hHa;
    public boolean hHe;
    public TextView hHf;
    public TextView hHg;
    public HeadImageView hHh;
    public HeadImageView hHi;
    public HeadImageView hHj;
    public TextView hHk;
    public TextView hHl;
    public TextView hHm;
    public AlaLiveWishListData hHn;
    public d hHo;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hHf = (TextView) this.mRootView.findViewById(a.f.rank_tv);
        this.hGZ = (TbImageView) this.mRootView.findViewById(a.f.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.f.progess_bar);
        this.hHg = (TextView) this.mRootView.findViewById(a.f.punishment_tv);
        this.hHa = (TextView) this.mRootView.findViewById(a.f.wish_count_tv);
        this.hHh = (HeadImageView) this.mRootView.findViewById(a.f.one_financier_iv);
        this.hHi = (HeadImageView) this.mRootView.findViewById(a.f.two_financier_iv);
        this.hHj = (HeadImageView) this.mRootView.findViewById(a.f.three_financier_iv);
        this.hHk = (TextView) this.mRootView.findViewById(a.f.end_time_tv);
        this.hHl = (TextView) this.mRootView.findViewById(a.f.go_wish);
        this.hHm = (TextView) this.mRootView.findViewById(a.f.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hHn = alaLiveWishListData;
    }

    public void oo(boolean z) {
        this.hHe = z;
    }

    public void fH(long j) {
        this.gik = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hHo = dVar;
        if (dVar != null) {
            this.hHf.setText(String.format(this.mContext.getResources().getString(a.h.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hGZ.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hGZ.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hGZ.setAutoChangeStyle(false);
            this.hGZ.startLoad(dVar.gIz, 10, false);
            this.mProgress.setMax(dVar.gIB);
            this.mProgress.setProgress(dVar.gIA);
            this.hHh.setIsRound(true);
            this.hHi.setIsRound(true);
            this.hHj.setIsRound(true);
            l.a(this.hHh, TextUtils.isEmpty(dVar.gIC) ? "null" : dVar.gIC, true, false);
            l.a(this.hHi, TextUtils.isEmpty(dVar.gID) ? "null" : dVar.gID, true, false);
            l.a(this.hHj, TextUtils.isEmpty(dVar.gIE) ? "null" : dVar.gIE, true, false);
            this.hHg.setText(String.format("%s%s", this.mContext.getText(a.h.ala_wish_thank_mode), dVar.mDesc));
            if (this.hHn != null) {
                this.hHa.setText(this.hHn.process_num + "/" + this.hHn.finish_num);
                this.mProgress.setMax(this.hHn.finish_num);
                this.mProgress.setProgress(this.hHn.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hHk.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Nn * 1000;
            if (this.gik <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.gik * 1000);
            }
            if (this.hHn != null) {
                dVar.gIA = this.hHn.process_num;
                dVar.gIB = this.hHn.finish_num;
            }
            if (this.hHe) {
                this.hHm.setVisibility(8);
                this.hHl.setVisibility(0);
                if (dVar.gIA >= dVar.gIB) {
                    if (j <= 0) {
                        this.hHm.setVisibility(0);
                        this.hHl.setVisibility(8);
                        this.hHm.setText(a.h.ala_go_wish_overdue);
                    }
                    this.hHm.setVisibility(0);
                    this.hHl.setVisibility(8);
                    this.hHm.setText(a.h.ala_go_wish_success);
                    this.hHk.setVisibility(8);
                    return;
                }
                this.hHm.setVisibility(8);
                this.hHl.setVisibility(0);
                if (j <= 0) {
                    this.hHm.setVisibility(0);
                    this.hHl.setVisibility(8);
                    this.hHm.setText(a.h.ala_go_wish_overdue);
                    this.hHk.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hHm.setVisibility(0);
            this.hHl.setVisibility(8);
            if (dVar.gIA >= dVar.gIB) {
                if (j <= 0) {
                    this.hHm.setVisibility(0);
                    this.hHl.setVisibility(8);
                    this.hHm.setText(a.h.ala_go_wish_overdue);
                    this.hHk.setVisibility(8);
                }
                this.hHm.setText(a.h.ala_go_wish_success);
                this.hHk.setVisibility(8);
                return;
            }
            this.hHm.setText(a.h.ala_go_wish_ing);
            if (j <= 0) {
                this.hHm.setVisibility(0);
                this.hHl.setVisibility(8);
                this.hHm.setText(a.h.ala_go_wish_overdue);
                this.hHk.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hHk.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hHk.setVisibility(0);
                a.this.hHk.setText(String.format("%s%s", a.this.mContext.getText(a.h.ala_wish_expire_time), com.baidu.tieba.ala.i.a.fO(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hHk.setVisibility(8);
                a.this.hHm.setVisibility(0);
                a.this.hHl.setVisibility(8);
                a.this.hHm.setText(a.h.ala_go_wish_overdue);
                dVar.Nn = 0L;
            }
        }.start());
    }
}
