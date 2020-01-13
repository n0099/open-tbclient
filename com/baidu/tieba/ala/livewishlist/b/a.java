package com.baidu.tieba.ala.livewishlist.b;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.c;
/* loaded from: classes2.dex */
public class a {
    public long eeX;
    public TbImageView flY;
    public TextView flZ;
    public boolean fmd;
    public TextView fme;
    public TextView fmf;
    public HeadImageView fmg;
    public HeadImageView fmh;
    public HeadImageView fmi;
    public TextView fmj;
    public TextView fmk;
    public TextView fml;
    public AlaLiveWishListData fmm;
    public c fmn;
    public Context mContext;
    public ProgressBar mProgress;
    public View mRootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.fme = (TextView) this.mRootView.findViewById(a.g.rank_tv);
        this.flY = (TbImageView) this.mRootView.findViewById(a.g.gift_thumbnail);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(a.g.progess_bar);
        this.fmf = (TextView) this.mRootView.findViewById(a.g.punishment_tv);
        this.flZ = (TextView) this.mRootView.findViewById(a.g.wish_count_tv);
        this.fmg = (HeadImageView) this.mRootView.findViewById(a.g.one_financier_iv);
        this.fmh = (HeadImageView) this.mRootView.findViewById(a.g.two_financier_iv);
        this.fmi = (HeadImageView) this.mRootView.findViewById(a.g.three_financier_iv);
        this.fmj = (TextView) this.mRootView.findViewById(a.g.end_time_tv);
        this.fmk = (TextView) this.mRootView.findViewById(a.g.go_wish);
        this.fml = (TextView) this.mRootView.findViewById(a.g.go_wish_succ);
    }

    public void a(AlaLiveWishListData alaLiveWishListData) {
        this.fmm = alaLiveWishListData;
    }

    public void jQ(boolean z) {
        this.fmd = z;
    }

    public void cZ(long j) {
        this.eeX = j;
    }

    public void a(int i, SparseArray<CountDownTimer> sparseArray, c cVar) {
        long j;
        this.fmn = cVar;
        if (cVar != null) {
            this.fme.setText(String.format(this.mContext.getResources().getString(a.i.ala_wish_rank), Integer.valueOf(i + 1)));
            this.flY.setDefaultBgResource(a.f.icon_live_gift_default);
            this.flY.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.flY.setAutoChangeStyle(false);
            this.flY.startLoad(cVar.evl, 10, false);
            this.mProgress.setMax(cVar.evn);
            this.mProgress.setProgress(cVar.evm);
            this.fmg.setIsRound(true);
            this.fmh.setIsRound(true);
            this.fmi.setIsRound(true);
            k.a(this.fmg, TextUtils.isEmpty(cVar.evo) ? "null" : cVar.evo, true, false);
            k.a(this.fmh, TextUtils.isEmpty(cVar.evp) ? "null" : cVar.evp, true, false);
            k.a(this.fmi, TextUtils.isEmpty(cVar.evq) ? "null" : cVar.evq, true, false);
            this.fmf.setText(String.format("%s%s", this.mContext.getText(a.i.ala_wish_thank_mode), cVar.mDesc));
            if (this.fmm != null) {
                this.flZ.setText(this.fmm.process_num + "/" + this.fmm.finish_num);
                this.mProgress.setMax(this.fmm.finish_num);
                this.mProgress.setProgress(this.fmm.process_num);
            }
            CountDownTimer countDownTimer = sparseArray.get(this.fmj.hashCode());
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long j2 = cVar.rs * 1000;
            if (this.eeX <= 0) {
                j = j2 - System.currentTimeMillis();
            } else {
                j = j2 - (this.eeX * 1000);
            }
            if (this.fmm != null) {
                cVar.evm = this.fmm.process_num;
                cVar.evn = this.fmm.finish_num;
            }
            if (this.fmd) {
                this.fml.setVisibility(8);
                this.fmk.setVisibility(0);
                if (cVar.evm >= cVar.evn) {
                    if (j <= 0) {
                        this.fml.setVisibility(0);
                        this.fmk.setVisibility(8);
                        this.fml.setText(a.i.ala_go_wish_overdue);
                    }
                    this.fml.setVisibility(0);
                    this.fmk.setVisibility(8);
                    this.fml.setText(a.i.ala_go_wish_success);
                    this.fmj.setVisibility(8);
                    return;
                }
                this.fml.setVisibility(8);
                this.fmk.setVisibility(0);
                if (j <= 0) {
                    this.fml.setVisibility(0);
                    this.fmk.setVisibility(8);
                    this.fml.setText(a.i.ala_go_wish_overdue);
                    this.fmj.setVisibility(8);
                    return;
                }
                a(sparseArray, cVar, j);
                return;
            }
            this.fml.setVisibility(0);
            this.fmk.setVisibility(8);
            if (cVar.evm >= cVar.evn) {
                if (j <= 0) {
                    this.fml.setVisibility(0);
                    this.fmk.setVisibility(8);
                    this.fml.setText(a.i.ala_go_wish_overdue);
                    this.fmj.setVisibility(8);
                }
                this.fml.setText(a.i.ala_go_wish_success);
                this.fmj.setVisibility(8);
                return;
            }
            this.fml.setText(a.i.ala_go_wish_ing);
            if (j <= 0) {
                this.fml.setVisibility(0);
                this.fmk.setVisibility(8);
                this.fml.setText(a.i.ala_go_wish_overdue);
                this.fmj.setVisibility(8);
                return;
            }
            a(sparseArray, cVar, j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.livewishlist.b.a$1] */
    private void a(SparseArray<CountDownTimer> sparseArray, final c cVar, long j) {
        sparseArray.put(this.fmj.hashCode(), new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.livewishlist.b.a.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                a.this.fmj.setVisibility(0);
                a.this.fmj.setText(String.format("%s%s", a.this.mContext.getText(a.i.ala_wish_expire_time), com.baidu.tieba.ala.f.a.dd(j2)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.fmj.setVisibility(8);
                a.this.fml.setVisibility(0);
                a.this.fmk.setVisibility(8);
                a.this.fml.setText(a.i.ala_go_wish_overdue);
                cVar.rs = 0L;
            }
        }.start());
    }
}
