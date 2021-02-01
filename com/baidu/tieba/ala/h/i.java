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
    private long goL;
    private CustomMessageListener ify;
    private PkRankStartAnimView igN;
    private Set<Long> igO;
    private ViewGroup mParentView;

    @Override // com.baidu.live.t.d
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cou();
    }

    @Override // com.baidu.live.t.d
    public void bh(long j) {
        reset();
        this.goL = j;
        cos();
    }

    @Override // com.baidu.live.t.d
    public void Fy() {
        cot();
        reset();
    }

    @Override // com.baidu.live.t.d
    public void release() {
        Fy();
        if (this.bem != null) {
            this.bem.release();
            this.bem = null;
        }
        if (this.igN != null) {
            this.igN.setCallback(null);
            this.igN.release();
        }
        if (this.igN != null && (this.igN.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.igN.getParent()).removeView(this.igN);
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

    private void cos() {
        if (this.ify == null) {
            this.ify = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        i.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ify);
    }

    private void cot() {
        if (this.ify != null) {
            MessageManager.getInstance().unRegisterListener(this.ify);
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
            if (this.igO == null) {
                this.igO = new HashSet();
            }
            this.igO.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            cou();
            this.igN.setVisibility(0);
            String cox = k.coQ().cox();
            if (TextUtils.isEmpty(cox)) {
                i = 0;
                i2 = 0;
            } else {
                if (this.bem == null) {
                    this.bem = new MediaMetadataRetriever();
                }
                try {
                    this.bem.setDataSource(cox);
                    i3 = Integer.valueOf(this.bem.extractMetadata(18)).intValue();
                    try {
                        i = Integer.valueOf(this.bem.extractMetadata(19)).intValue();
                        i2 = i3;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = 0;
                        i2 = i3;
                        cox = null;
                        if (i2 > 0) {
                        }
                        cox = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.igN.bW(realScreenWidth, TextUtils.isEmpty(cox) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                        this.igN.setData(a2, a3);
                        this.igN.Iu(cox);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i3 = 0;
                }
            }
            if (i2 > 0 || i <= 0) {
                cox = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.igN.bW(realScreenWidth2, TextUtils.isEmpty(cox) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
            this.igN.setData(a2, a3);
            this.igN.Iu(cox);
        }
    }

    private void cou() {
        if (this.igN == null) {
            this.igN = new PkRankStartAnimView(getContext());
        }
        if (bkq().indexOfChild(this.igN) < 0) {
            bkq().addView(this.igN, new ViewGroup.LayoutParams(-1, -1));
        }
        this.igN.setVisibility(8);
        this.igN.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.i.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void cov() {
                if (i.this.igN != null) {
                    i.this.igN.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.goL = 0L;
        if (this.igO != null) {
            this.igO.clear();
        }
        if (this.igN != null) {
            this.igN.stopAnim();
            this.igN.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.goL <= 0 || this.goL != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.igO == null || !this.igO.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.aVj = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gTd = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gTc = spannableString;
        }
        return qVar;
    }
}
