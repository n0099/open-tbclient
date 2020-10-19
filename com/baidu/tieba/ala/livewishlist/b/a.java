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
    public long fMk;
    public TbImageView hfR;
    public TextView hfS;
    public boolean hfW;
    public TextView hfX;
    public TextView hfY;
    public HeadImageView hfZ;
    public HeadImageView hga;
    public HeadImageView hgb;
    public TextView hgc;
    public TextView hgd;
    public TextView hge;
    public AlaLiveWishListData hgf;
    public d hgg;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.hfX = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.hfR = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.hfY = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.hfS = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.hfZ = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.hga = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.hgb = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.hgc = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.hgd = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.hge = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.hgf = alaLiveWishListData;
    }

    public void ns(boolean z) {
        this.hfW = z;
    }

    public void eF(long j) {
        this.fMk = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, d dVar) {
        long j;
        this.hgg = dVar;
        if (dVar != null) {
            this.hfX.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.hfR.setDefaultBgResource(a.f.icon_live_gift_default);
            this.hfR.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.hfR.setAutoChangeStyle(false);
            this.hfR.startLoad(dVar.gke, 10, false);
            this.mProgress.setMax(dVar.gkg);
            this.mProgress.setProgress(dVar.gkf);
            this.hfZ.setIsRound(true);
            this.hga.setIsRound(true);
            this.hgb.setIsRound(true);
            l.a(this.hfZ, TextUtils.isEmpty(dVar.gkh) ? "null" : dVar.gkh, true, false);
            l.a(this.hga, TextUtils.isEmpty(dVar.gki) ? "null" : dVar.gki, true, false);
            l.a(this.hgb, TextUtils.isEmpty(dVar.gkj) ? "null" : dVar.gkj, true, false);
            this.hfY.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), dVar.mDesc));
            if (this.hgf != null) {
                this.hfS.setText(this.hgf.process_num + "/" + this.hgf.finish_num);
                this.mProgress.setMax(this.hgf.finish_num);
                this.mProgress.setProgress(this.hgf.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.hgc.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = dVar.Mr * 1000;
            if (this.fMk <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.fMk * 1000);
            }
            if (this.hgf != null) {
                dVar.gkf = this.hgf.process_num;
                dVar.gkg = this.hgf.finish_num;
            }
            if (this.hfW) {
                this.hge.setVisibility(8);
                this.hgd.setVisibility(0);
                if (dVar.gkf >= dVar.gkg) {
                    if (j <= 0) {
                        this.hge.setVisibility(0);
                        this.hgd.setVisibility(8);
                        this.hge.setText(a.i.ala_go_wish_overdue);
                    }
                    this.hge.setVisibility(0);
                    this.hgd.setVisibility(8);
                    this.hge.setText(a.i.ala_go_wish_success);
                    this.hgc.setVisibility(8);
                    return;
                }
                this.hge.setVisibility(8);
                this.hgd.setVisibility(0);
                if (j <= 0) {
                    this.hge.setVisibility(0);
                    this.hgd.setVisibility(8);
                    this.hge.setText(a.i.ala_go_wish_overdue);
                    this.hgc.setVisibility(8);
                    return;
                }
                a(sparseArray, dVar, j);
                return;
            }
            this.hge.setVisibility(0);
            this.hgd.setVisibility(8);
            if (dVar.gkf >= dVar.gkg) {
                if (j <= 0) {
                    this.hge.setVisibility(0);
                    this.hgd.setVisibility(8);
                    this.hge.setText(a.i.ala_go_wish_overdue);
                    this.hgc.setVisibility(8);
                }
                this.hge.setText(a.i.ala_go_wish_success);
                this.hgc.setVisibility(8);
                return;
            }
            this.hge.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.hge.setVisibility(0);
                this.hgd.setVisibility(8);
                this.hge.setText(a.i.ala_go_wish_overdue);
                this.hgc.setVisibility(8);
                return;
            }
            a(sparseArray, dVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final d dVar, long j) {
        sparseArray.put(this.hgc.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.hgc.setVisibility(0);
                a.this.hgc.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.i.a.eN(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.hgc.setVisibility(8);
                a.this.hge.setVisibility(0);
                a.this.hgd.setVisibility(8);
                a.this.hge.setText(a.i.ala_go_wish_overdue);
                dVar.Mr = 0L;
            }
        }.start());
    }
}
