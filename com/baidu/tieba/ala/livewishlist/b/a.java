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
    public long eJv;
    public TbImageView fTP;
    public TextView fTQ;
    public boolean fTU;
    public TextView fTV;
    public TextView fTW;
    public HeadImageView fTX;
    public HeadImageView fTY;
    public HeadImageView fTZ;
    public TextView fUa;
    public TextView fUb;
    public TextView fUc;
    public AlaLiveWishListData fUd;
    public c fUe;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.fTV = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.fTP = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.fTW = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.fTQ = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.fTX = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.fTY = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.fTZ = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.fUa = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.fUb = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.fUc = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.fUd = alaLiveWishListData;
    }

    public void kY(boolean z) {
        this.fTU = z;
    }

    public void dJ(long j) {
        this.eJv = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.fUe = cVar;
        if (cVar != null) {
            this.fTV.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.fTP.setDefaultBgResource(a.f.icon_live_gift_default);
            this.fTP.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.fTP.setAutoChangeStyle(false);
            this.fTP.startLoad(cVar.feF, 10, false);
            this.mProgress.setMax(cVar.feH);
            this.mProgress.setProgress(cVar.feG);
            this.fTX.setIsRound(true);
            this.fTY.setIsRound(true);
            this.fTZ.setIsRound(true);
            k.a(this.fTX, TextUtils.isEmpty(cVar.feI) ? "null" : cVar.feI, true, false);
            k.a(this.fTY, TextUtils.isEmpty(cVar.feJ) ? "null" : cVar.feJ, true, false);
            k.a(this.fTZ, TextUtils.isEmpty(cVar.feK) ? "null" : cVar.feK, true, false);
            this.fTW.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.fUd != null) {
                this.fTQ.setText(this.fUd.process_num + "/" + this.fUd.finish_num);
                this.mProgress.setMax(this.fUd.finish_num);
                this.mProgress.setProgress(this.fUd.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.fUa.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.Kw * 1000;
            if (this.eJv <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.eJv * 1000);
            }
            if (this.fUd != null) {
                cVar.feG = this.fUd.process_num;
                cVar.feH = this.fUd.finish_num;
            }
            if (this.fTU) {
                this.fUc.setVisibility(8);
                this.fUb.setVisibility(0);
                if (cVar.feG >= cVar.feH) {
                    if (j <= 0) {
                        this.fUc.setVisibility(0);
                        this.fUb.setVisibility(8);
                        this.fUc.setText(a.i.ala_go_wish_overdue);
                    }
                    this.fUc.setVisibility(0);
                    this.fUb.setVisibility(8);
                    this.fUc.setText(a.i.ala_go_wish_success);
                    this.fUa.setVisibility(8);
                    return;
                }
                this.fUc.setVisibility(8);
                this.fUb.setVisibility(0);
                if (j <= 0) {
                    this.fUc.setVisibility(0);
                    this.fUb.setVisibility(8);
                    this.fUc.setText(a.i.ala_go_wish_overdue);
                    this.fUa.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.fUc.setVisibility(0);
            this.fUb.setVisibility(8);
            if (cVar.feG >= cVar.feH) {
                if (j <= 0) {
                    this.fUc.setVisibility(0);
                    this.fUb.setVisibility(8);
                    this.fUc.setText(a.i.ala_go_wish_overdue);
                    this.fUa.setVisibility(8);
                }
                this.fUc.setText(a.i.ala_go_wish_success);
                this.fUa.setVisibility(8);
                return;
            }
            this.fUc.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.fUc.setVisibility(0);
                this.fUb.setVisibility(8);
                this.fUc.setText(a.i.ala_go_wish_overdue);
                this.fUa.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.fUa.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.fUa.setVisibility(0);
                a.this.fUa.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.g.a.dN(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.fUa.setVisibility(8);
                a.this.fUc.setVisibility(0);
                a.this.fUb.setVisibility(8);
                a.this.fUc.setText(a.i.ala_go_wish_overdue);
                cVar.Kw = 0L;
            }
        }.start());
    }
}
