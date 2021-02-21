package com.baidu.tieba.ala.h;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.data.PkUserInfoData;
import com.baidu.tieba.ala.data.q;
import com.baidu.tieba.ala.view.PkRankStartAnimView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class i implements com.baidu.live.t.d {
    private MediaMetadataRetriever bem;
    private long goZ;
    private CustomMessageListener ifM;
    private PkRankStartAnimView ihb;
    private Set<Long> ihc;
    private ViewGroup mParentView;

    @Override // com.baidu.live.t.d
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        coB();
    }

    @Override // com.baidu.live.t.d
    public void bh(long j) {
        reset();
        this.goZ = j;
        coz();
    }

    @Override // com.baidu.live.t.d
    public void Fy() {
        coA();
        reset();
    }

    @Override // com.baidu.live.t.d
    public void release() {
        Fy();
        if (this.bem != null) {
            this.bem.release();
            this.bem = null;
        }
        if (this.ihb != null) {
            this.ihb.setCallback(null);
            this.ihb.release();
        }
        if (this.ihb != null && (this.ihb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ihb.getParent()).removeView(this.ihb);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bkq() != null) {
            return bkq().getContext();
        }
        return null;
    }

    private ViewGroup bkq() {
        return this.mParentView;
    }

    private void coz() {
        if (this.ifM == null) {
            this.ifM = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        i.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ifM);
    }

    private void coA() {
        if (this.ifM != null) {
            MessageManager.getInstance().unRegisterListener(this.ifM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PkInfoData pkInfoData) {
        int i;
        int i2;
        int i3;
        if (c(pkInfoData)) {
            if (this.ihc == null) {
                this.ihc = new HashSet();
            }
            this.ihc.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            coB();
            this.ihb.setVisibility(0);
            String coE = k.coX().coE();
            if (TextUtils.isEmpty(coE)) {
                i = 0;
                i2 = 0;
            } else {
                if (this.bem == null) {
                    this.bem = new MediaMetadataRetriever();
                }
                try {
                    this.bem.setDataSource(coE);
                    i3 = Integer.valueOf(this.bem.extractMetadata(18)).intValue();
                    try {
                        i = Integer.valueOf(this.bem.extractMetadata(19)).intValue();
                        i2 = i3;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = 0;
                        i2 = i3;
                        coE = null;
                        if (i2 > 0) {
                        }
                        coE = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.ihb.bX(realScreenWidth, TextUtils.isEmpty(coE) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                        this.ihb.setData(a2, a3);
                        this.ihb.Iv(coE);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i3 = 0;
                }
            }
            if (i2 > 0 || i <= 0) {
                coE = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.ihb.bX(realScreenWidth2, TextUtils.isEmpty(coE) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
            this.ihb.setData(a2, a3);
            this.ihb.Iv(coE);
        }
    }

    private void coB() {
        if (this.ihb == null) {
            this.ihb = new PkRankStartAnimView(getContext());
        }
        if (bkq().indexOfChild(this.ihb) < 0) {
            bkq().addView(this.ihb, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ihb.setVisibility(8);
        this.ihb.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.i.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void coC() {
                if (i.this.ihb != null) {
                    i.this.ihb.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.goZ = 0L;
        if (this.ihc != null) {
            this.ihc.clear();
        }
        if (this.ihb != null) {
            this.ihb.stopAnim();
            this.ihb.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.goZ <= 0 || this.goZ != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.ihc == null || !this.ihc.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.aVj = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gTr = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gTq = spannableString;
        }
        return qVar;
    }
}
