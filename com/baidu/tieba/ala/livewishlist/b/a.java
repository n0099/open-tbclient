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
    public long eja;
    public TbImageView foB;
    public TextView foC;
    public boolean foG;
    public TextView foH;
    public TextView foI;
    public HeadImageView foJ;
    public HeadImageView foK;
    public HeadImageView foL;
    public TextView foM;
    public TextView foN;
    public TextView foO;
    public AlaLiveWishListData foP;
    public c foQ;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.foH = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.foB = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.foI = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.foC = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.foJ = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.foK = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.foL = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.foM = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.foN = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.foO = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.foP = alaLiveWishListData;
    }

    public void jS(boolean z) {
        this.foG = z;
    }

    public void db(long j) {
        this.eja = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.foQ = cVar;
        if (cVar != null) {
            this.foH.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.foB.setDefaultBgResource(a.f.icon_live_gift_default);
            this.foB.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.foB.setAutoChangeStyle(false);
            this.foB.startLoad(cVar.ezw, 10, false);
            this.mProgress.setMax(cVar.ezy);
            this.mProgress.setProgress(cVar.ezx);
            this.foJ.setIsRound(true);
            this.foK.setIsRound(true);
            this.foL.setIsRound(true);
            k.a(this.foJ, TextUtils.isEmpty(cVar.ezz) ? "null" : cVar.ezz, true, false);
            k.a(this.foK, TextUtils.isEmpty(cVar.ezA) ? "null" : cVar.ezA, true, false);
            k.a(this.foL, TextUtils.isEmpty(cVar.ezB) ? "null" : cVar.ezB, true, false);
            this.foI.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.foP != null) {
                this.foC.setText(this.foP.process_num + "/" + this.foP.finish_num);
                this.mProgress.setMax(this.foP.finish_num);
                this.mProgress.setProgress(this.foP.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.foM.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.rt * 1000;
            if (this.eja <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.eja * 1000);
            }
            if (this.foP != null) {
                cVar.ezx = this.foP.process_num;
                cVar.ezy = this.foP.finish_num;
            }
            if (this.foG) {
                this.foO.setVisibility(8);
                this.foN.setVisibility(0);
                if (cVar.ezx >= cVar.ezy) {
                    if (j <= 0) {
                        this.foO.setVisibility(0);
                        this.foN.setVisibility(8);
                        this.foO.setText(a.i.ala_go_wish_overdue);
                    }
                    this.foO.setVisibility(0);
                    this.foN.setVisibility(8);
                    this.foO.setText(a.i.ala_go_wish_success);
                    this.foM.setVisibility(8);
                    return;
                }
                this.foO.setVisibility(8);
                this.foN.setVisibility(0);
                if (j <= 0) {
                    this.foO.setVisibility(0);
                    this.foN.setVisibility(8);
                    this.foO.setText(a.i.ala_go_wish_overdue);
                    this.foM.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.foO.setVisibility(0);
            this.foN.setVisibility(8);
            if (cVar.ezx >= cVar.ezy) {
                if (j <= 0) {
                    this.foO.setVisibility(0);
                    this.foN.setVisibility(8);
                    this.foO.setText(a.i.ala_go_wish_overdue);
                    this.foM.setVisibility(8);
                }
                this.foO.setText(a.i.ala_go_wish_success);
                this.foM.setVisibility(8);
                return;
            }
            this.foO.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.foO.setVisibility(0);
                this.foN.setVisibility(8);
                this.foO.setText(a.i.ala_go_wish_overdue);
                this.foM.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.foM.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.foM.setVisibility(0);
                a.this.foM.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.f.a.df(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.foM.setVisibility(8);
                a.this.foO.setVisibility(0);
                a.this.foN.setVisibility(8);
                a.this.foO.setText(a.i.ala_go_wish_overdue);
                cVar.rt = 0L;
            }
        }.start());
    }
}
