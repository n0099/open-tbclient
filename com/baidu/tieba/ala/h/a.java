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
import com.baidu.tieba.ala.data.o;
import com.baidu.tieba.ala.view.PkRankStartAnimView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.p.c {
    private MediaMetadataRetriever aWt;
    private long fxY;
    private CustomMessageListener hcE;
    private PkRankStartAnimView hcF;
    private Set<Long> hcG;
    private ViewGroup mParentView;

    @Override // com.baidu.live.p.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cbZ();
    }

    @Override // com.baidu.live.p.c
    public void aq(long j) {
        reset();
        this.fxY = j;
        cbX();
    }

    @Override // com.baidu.live.p.c
    public void FB() {
        cbY();
        reset();
    }

    @Override // com.baidu.live.p.c
    public void release() {
        FB();
        if (this.aWt != null) {
            this.aWt.release();
            this.aWt = null;
        }
        if (this.hcF != null) {
            this.hcF.setCallback(null);
            this.hcF.release();
        }
        if (this.hcF != null && (this.hcF.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hcF.getParent()).removeView(this.hcF);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bbN() != null) {
            return bbN().getContext();
        }
        return null;
    }

    private ViewGroup bbN() {
        return this.mParentView;
    }

    private void cbX() {
        if (this.hcE == null) {
            this.hcE = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hcE);
    }

    private void cbY() {
        if (this.hcE != null) {
            MessageManager.getInstance().unRegisterListener(this.hcE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PkInfoData pkInfoData) {
        int i;
        int i2;
        int i3 = 0;
        if (c(pkInfoData)) {
            if (this.hcG == null) {
                this.hcG = new HashSet();
            }
            this.hcG.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            o a = a(pkInfoData.myPkData);
            o a2 = a(pkInfoData.otherPkData);
            cbZ();
            this.hcF.setVisibility(0);
            String ccb = c.cca().ccb();
            if (TextUtils.isEmpty(ccb)) {
                i = 0;
            } else {
                if (this.aWt == null) {
                    this.aWt = new MediaMetadataRetriever();
                }
                try {
                    this.aWt.setDataSource(ccb);
                    i2 = Integer.valueOf(this.aWt.extractMetadata(18)).intValue();
                    try {
                        i3 = Integer.valueOf(this.aWt.extractMetadata(19)).intValue();
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = i2;
                        ccb = null;
                        if (i > 0) {
                        }
                        ccb = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.hcF.bT(realScreenWidth, TextUtils.isEmpty(ccb) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                        this.hcF.setData(a, a2);
                        this.hcF.Ho(ccb);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 0;
                }
            }
            if (i > 0 || i3 <= 0) {
                ccb = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.hcF.bT(realScreenWidth2, TextUtils.isEmpty(ccb) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
            this.hcF.setData(a, a2);
            this.hcF.Ho(ccb);
        }
    }

    private void cbZ() {
        if (this.hcF == null) {
            this.hcF = new PkRankStartAnimView(getContext());
        }
        if (bbN().indexOfChild(this.hcF) < 0) {
            bbN().addView(this.hcF, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hcF.setVisibility(8);
        this.hcF.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hcF != null) {
                    a.this.hcF.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.fxY = 0L;
        if (this.hcG != null) {
            this.hcG.clear();
        }
        if (this.hcF != null) {
            this.hcF.stopAnim();
            this.hcF.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.fxY <= 0 || this.fxY != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.hcG == null || !this.hcG.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private o a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        o oVar = new o();
        oVar.baJ = pkUserInfoData.bdPortrait;
        oVar.nickname = pkUserInfoData.userNickName;
        oVar.fYt = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            oVar.fYs = spannableString;
        }
        return oVar;
    }
}
