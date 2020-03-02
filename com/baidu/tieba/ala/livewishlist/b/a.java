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
    public long ejb;
    public TbImageView foC;
    public TextView foD;
    public boolean foH;
    public TextView foI;
    public TextView foJ;
    public HeadImageView foK;
    public HeadImageView foL;
    public HeadImageView foM;
    public TextView foN;
    public TextView foO;
    public TextView foP;
    public AlaLiveWishListData foQ;
    public c foR;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.foI = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.foC = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.foJ = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.foD = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.foK = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.foL = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.foM = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.foN = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.foO = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.foP = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.foQ = alaLiveWishListData;
    }

    public void jS(boolean z) {
        this.foH = z;
    }

    public void db(long j) {
        this.ejb = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.foR = cVar;
        if (cVar != null) {
            this.foI.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.foC.setDefaultBgResource(a.f.icon_live_gift_default);
            this.foC.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.foC.setAutoChangeStyle(false);
            this.foC.startLoad(cVar.ezx, 10, false);
            this.mProgress.setMax(cVar.ezz);
            this.mProgress.setProgress(cVar.ezy);
            this.foK.setIsRound(true);
            this.foL.setIsRound(true);
            this.foM.setIsRound(true);
            k.a(this.foK, TextUtils.isEmpty(cVar.ezA) ? "null" : cVar.ezA, true, false);
            k.a(this.foL, TextUtils.isEmpty(cVar.ezB) ? "null" : cVar.ezB, true, false);
            k.a(this.foM, TextUtils.isEmpty(cVar.ezC) ? "null" : cVar.ezC, true, false);
            this.foJ.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.foQ != null) {
                this.foD.setText(this.foQ.process_num + "/" + this.foQ.finish_num);
                this.mProgress.setMax(this.foQ.finish_num);
                this.mProgress.setProgress(this.foQ.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.foN.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.rt * 1000;
            if (this.ejb <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.ejb * 1000);
            }
            if (this.foQ != null) {
                cVar.ezy = this.foQ.process_num;
                cVar.ezz = this.foQ.finish_num;
            }
            if (this.foH) {
                this.foP.setVisibility(8);
                this.foO.setVisibility(0);
                if (cVar.ezy >= cVar.ezz) {
                    if (j <= 0) {
                        this.foP.setVisibility(0);
                        this.foO.setVisibility(8);
                        this.foP.setText(a.i.ala_go_wish_overdue);
                    }
                    this.foP.setVisibility(0);
                    this.foO.setVisibility(8);
                    this.foP.setText(a.i.ala_go_wish_success);
                    this.foN.setVisibility(8);
                    return;
                }
                this.foP.setVisibility(8);
                this.foO.setVisibility(0);
                if (j <= 0) {
                    this.foP.setVisibility(0);
                    this.foO.setVisibility(8);
                    this.foP.setText(a.i.ala_go_wish_overdue);
                    this.foN.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.foP.setVisibility(0);
            this.foO.setVisibility(8);
            if (cVar.ezy >= cVar.ezz) {
                if (j <= 0) {
                    this.foP.setVisibility(0);
                    this.foO.setVisibility(8);
                    this.foP.setText(a.i.ala_go_wish_overdue);
                    this.foN.setVisibility(8);
                }
                this.foP.setText(a.i.ala_go_wish_success);
                this.foN.setVisibility(8);
                return;
            }
            this.foP.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.foP.setVisibility(0);
                this.foO.setVisibility(8);
                this.foP.setText(a.i.ala_go_wish_overdue);
                this.foN.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.foN.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.foN.setVisibility(0);
                a.this.foN.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.f.a.df(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.foN.setVisibility(8);
                a.this.foP.setVisibility(0);
                a.this.foO.setVisibility(8);
                a.this.foP.setText(a.i.ala_go_wish_overdue);
                cVar.rt = 0L;
            }
        }.start());
    }
}
