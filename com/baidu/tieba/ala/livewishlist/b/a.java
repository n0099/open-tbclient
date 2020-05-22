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
    public long eVS;
    public TbImageView giI;
    public TextView giJ;
    public boolean giN;
    public TextView giO;
    public TextView giP;
    public HeadImageView giQ;
    public HeadImageView giR;
    public HeadImageView giS;
    public TextView giT;
    public TextView giU;
    public TextView giV;
    public AlaLiveWishListData giW;
    public c giX;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.giO = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.giI = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.giP = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.giJ = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.giQ = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.giR = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.giS = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.giT = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.giU = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.giV = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.giW = alaLiveWishListData;
    }

    public void lv(boolean z) {
        this.giN = z;
    }

    public void dK(long j) {
        this.eVS = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.giX = cVar;
        if (cVar != null) {
            this.giO.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.giI.setDefaultBgResource(a.f.icon_live_gift_default);
            this.giI.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.giI.setAutoChangeStyle(false);
            this.giI.startLoad(cVar.fsk, 10, false);
            this.mProgress.setMax(cVar.fsm);
            this.mProgress.setProgress(cVar.fsl);
            this.giQ.setIsRound(true);
            this.giR.setIsRound(true);
            this.giS.setIsRound(true);
            k.a(this.giQ, TextUtils.isEmpty(cVar.fsn) ? "null" : cVar.fsn, true, false);
            k.a(this.giR, TextUtils.isEmpty(cVar.fso) ? "null" : cVar.fso, true, false);
            k.a(this.giS, TextUtils.isEmpty(cVar.fsp) ? "null" : cVar.fsp, true, false);
            this.giP.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.giW != null) {
                this.giJ.setText(this.giW.process_num + "/" + this.giW.finish_num);
                this.mProgress.setMax(this.giW.finish_num);
                this.mProgress.setProgress(this.giW.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.giT.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.KI * 1000;
            if (this.eVS <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.eVS * 1000);
            }
            if (this.giW != null) {
                cVar.fsl = this.giW.process_num;
                cVar.fsm = this.giW.finish_num;
            }
            if (this.giN) {
                this.giV.setVisibility(8);
                this.giU.setVisibility(0);
                if (cVar.fsl >= cVar.fsm) {
                    if (j <= 0) {
                        this.giV.setVisibility(0);
                        this.giU.setVisibility(8);
                        this.giV.setText(a.i.ala_go_wish_overdue);
                    }
                    this.giV.setVisibility(0);
                    this.giU.setVisibility(8);
                    this.giV.setText(a.i.ala_go_wish_success);
                    this.giT.setVisibility(8);
                    return;
                }
                this.giV.setVisibility(8);
                this.giU.setVisibility(0);
                if (j <= 0) {
                    this.giV.setVisibility(0);
                    this.giU.setVisibility(8);
                    this.giV.setText(a.i.ala_go_wish_overdue);
                    this.giT.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.giV.setVisibility(0);
            this.giU.setVisibility(8);
            if (cVar.fsl >= cVar.fsm) {
                if (j <= 0) {
                    this.giV.setVisibility(0);
                    this.giU.setVisibility(8);
                    this.giV.setText(a.i.ala_go_wish_overdue);
                    this.giT.setVisibility(8);
                }
                this.giV.setText(a.i.ala_go_wish_success);
                this.giT.setVisibility(8);
                return;
            }
            this.giV.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.giV.setVisibility(0);
                this.giU.setVisibility(8);
                this.giV.setText(a.i.ala_go_wish_overdue);
                this.giT.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.giT.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.giT.setVisibility(0);
                a.this.giT.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.g.a.dO(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.giT.setVisibility(8);
                a.this.giV.setVisibility(0);
                a.this.giU.setVisibility(8);
                a.this.giV.setText(a.i.ala_go_wish_overdue);
                cVar.KI = 0L;
            }
        }.start());
    }
}
