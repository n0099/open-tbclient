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
import com.baidu.tieba.ala.data.c;
/* loaded from: classes3.dex */
public class a {
    public long fgo;
    public TbImageView gvG;
    public TextView gvH;
    public boolean gvL;
    public TextView gvM;
    public TextView gvN;
    public HeadImageView gvO;
    public HeadImageView gvP;
    public HeadImageView gvQ;
    public TextView gvR;
    public TextView gvS;
    public TextView gvT;
    public AlaLiveWishListData gvU;
    public c gvV;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gvM = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.gvG = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.gvN = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.gvH = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.gvO = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.gvP = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.gvQ = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.gvR = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.gvS = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.gvT = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.gvU = alaLiveWishListData;
    }

    public void lD(boolean z) {
        this.gvL = z;
    }

    public void dN(long j) {
        this.fgo = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.gvV = cVar;
        if (cVar != null) {
            this.gvM.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.gvG.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gvG.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gvG.setAutoChangeStyle(false);
            this.gvG.startLoad(cVar.fDG, 10, false);
            this.mProgress.setMax(cVar.fDI);
            this.mProgress.setProgress(cVar.fDH);
            this.gvO.setIsRound(true);
            this.gvP.setIsRound(true);
            this.gvQ.setIsRound(true);
            k.a(this.gvO, TextUtils.isEmpty(cVar.fDJ) ? "null" : cVar.fDJ, true, false);
            k.a(this.gvP, TextUtils.isEmpty(cVar.fDK) ? "null" : cVar.fDK, true, false);
            k.a(this.gvQ, TextUtils.isEmpty(cVar.fDL) ? "null" : cVar.fDL, true, false);
            this.gvN.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.gvU != null) {
                this.gvH.setText(this.gvU.process_num + "/" + this.gvU.finish_num);
                this.mProgress.setMax(this.gvU.finish_num);
                this.mProgress.setProgress(this.gvU.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.gvR.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.Li * 1000;
            if (this.fgo <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.fgo * 1000);
            }
            if (this.gvU != null) {
                cVar.fDH = this.gvU.process_num;
                cVar.fDI = this.gvU.finish_num;
            }
            if (this.gvL) {
                this.gvT.setVisibility(8);
                this.gvS.setVisibility(0);
                if (cVar.fDH >= cVar.fDI) {
                    if (j <= 0) {
                        this.gvT.setVisibility(0);
                        this.gvS.setVisibility(8);
                        this.gvT.setText(a.i.ala_go_wish_overdue);
                    }
                    this.gvT.setVisibility(0);
                    this.gvS.setVisibility(8);
                    this.gvT.setText(a.i.ala_go_wish_success);
                    this.gvR.setVisibility(8);
                    return;
                }
                this.gvT.setVisibility(8);
                this.gvS.setVisibility(0);
                if (j <= 0) {
                    this.gvT.setVisibility(0);
                    this.gvS.setVisibility(8);
                    this.gvT.setText(a.i.ala_go_wish_overdue);
                    this.gvR.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.gvT.setVisibility(0);
            this.gvS.setVisibility(8);
            if (cVar.fDH >= cVar.fDI) {
                if (j <= 0) {
                    this.gvT.setVisibility(0);
                    this.gvS.setVisibility(8);
                    this.gvT.setText(a.i.ala_go_wish_overdue);
                    this.gvR.setVisibility(8);
                }
                this.gvT.setText(a.i.ala_go_wish_success);
                this.gvR.setVisibility(8);
                return;
            }
            this.gvT.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.gvT.setVisibility(0);
                this.gvS.setVisibility(8);
                this.gvT.setText(a.i.ala_go_wish_overdue);
                this.gvR.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.gvR.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.gvR.setVisibility(0);
                a.this.gvR.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.g.a.dR(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.gvR.setVisibility(8);
                a.this.gvT.setVisibility(0);
                a.this.gvS.setVisibility(8);
                a.this.gvT.setText(a.i.ala_go_wish_overdue);
                cVar.Li = 0L;
            }
        }.start());
    }
}
