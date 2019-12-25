package com.baidu.tieba.ala.livewishlist.b;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.c;
/* loaded from: classes2.dex */
public class a {
    public long eeP;
    public TbImageView fiN;
    public TextView fiO;
    public boolean fiS;
    public TextView fiT;
    public TextView fiU;
    public HeadImageView fiV;
    public HeadImageView fiW;
    public HeadImageView fiX;
    public TextView fiY;
    public TextView fiZ;
    public TextView fja;
    public AlaLiveWishListData fjb;
    public c fjc;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.fiT = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.fiN = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.fiU = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.fiO = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.fiV = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.fiW = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.fiX = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.fiY = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.fiZ = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.fja = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.fjb = alaLiveWishListData;
    }

    public void jF(boolean z) {
        this.fiS = z;
    }

    public void cU(long j) {
        this.eeP = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.fjc = cVar;
        if (cVar != null) {
            this.fiT.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.fiN.setDefaultBgResource(a.f.icon_live_gift_default);
            this.fiN.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.fiN.setAutoChangeStyle(false);
            this.fiN.startLoad(cVar.eua, 10, false);
            this.mProgress.setMax(cVar.euc);
            this.mProgress.setProgress(cVar.eub);
            this.fiV.setIsRound(true);
            this.fiW.setIsRound(true);
            this.fiX.setIsRound(true);
            k.a(this.fiV, TextUtils.isEmpty(cVar.eud) ? "null" : cVar.eud, true, false);
            k.a(this.fiW, TextUtils.isEmpty(cVar.eue) ? "null" : cVar.eue, true, false);
            k.a(this.fiX, TextUtils.isEmpty(cVar.euf) ? "null" : cVar.euf, true, false);
            this.fiU.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.fjb != null) {
                this.fiO.setText(this.fjb.process_num + "/" + this.fjb.finish_num);
                this.mProgress.setMax(this.fjb.finish_num);
                this.mProgress.setProgress(this.fjb.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.fiY.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.rs * 1000;
            if (this.eeP <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.eeP * 1000);
            }
            if (this.fjb != null) {
                cVar.eub = this.fjb.process_num;
                cVar.euc = this.fjb.finish_num;
            }
            if (this.fiS) {
                this.fja.setVisibility(8);
                this.fiZ.setVisibility(0);
                if (cVar.eub >= cVar.euc) {
                    if (j <= 0) {
                        this.fja.setVisibility(0);
                        this.fiZ.setVisibility(8);
                        this.fja.setText(a.i.ala_go_wish_overdue);
                    }
                    this.fja.setVisibility(0);
                    this.fiZ.setVisibility(8);
                    this.fja.setText(a.i.ala_go_wish_success);
                    this.fiY.setVisibility(8);
                    return;
                }
                this.fja.setVisibility(8);
                this.fiZ.setVisibility(0);
                if (j <= 0) {
                    this.fja.setVisibility(0);
                    this.fiZ.setVisibility(8);
                    this.fja.setText(a.i.ala_go_wish_overdue);
                    this.fiY.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.fja.setVisibility(0);
            this.fiZ.setVisibility(8);
            if (cVar.eub >= cVar.euc) {
                if (j <= 0) {
                    this.fja.setVisibility(0);
                    this.fiZ.setVisibility(8);
                    this.fja.setText(a.i.ala_go_wish_overdue);
                    this.fiY.setVisibility(8);
                }
                this.fja.setText(a.i.ala_go_wish_success);
                this.fiY.setVisibility(8);
                return;
            }
            this.fja.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.fja.setVisibility(0);
                this.fiZ.setVisibility(8);
                this.fja.setText(a.i.ala_go_wish_overdue);
                this.fiY.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.fiY.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.fiY.setVisibility(0);
                a.this.fiY.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.f.a.cY(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.fiY.setVisibility(8);
                a.this.fja.setVisibility(0);
                a.this.fiZ.setVisibility(8);
                a.this.fja.setText(a.i.ala_go_wish_overdue);
                cVar.rs = 0L;
            }
        }.start());
    }
}
