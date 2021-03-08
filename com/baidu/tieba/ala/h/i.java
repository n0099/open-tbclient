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
/* loaded from: classes10.dex */
public class i implements com.baidu.live.t.d {
    private MediaMetadataRetriever bfP;
    private long gqI;
    private CustomMessageListener ihv;
    private PkRankStartAnimView iiK;
    private Set<Long> iiL;
    private ViewGroup mParentView;

    @Override // com.baidu.live.t.d
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        coH();
    }

    @Override // com.baidu.live.t.d
    public void bh(long j) {
        reset();
        this.gqI = j;
        coF();
    }

    @Override // com.baidu.live.t.d
    public void FB() {
        coG();
        reset();
    }

    @Override // com.baidu.live.t.d
    public void release() {
        FB();
        if (this.bfP != null) {
            this.bfP.release();
            this.bfP = null;
        }
        if (this.iiK != null) {
            this.iiK.setCallback(null);
            this.iiK.release();
        }
        if (this.iiK != null && (this.iiK.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.iiK.getParent()).removeView(this.iiK);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bks() != null) {
            return bks().getContext();
        }
        return null;
    }

    private ViewGroup bks() {
        return this.mParentView;
    }

    private void coF() {
        if (this.ihv == null) {
            this.ihv = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        i.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ihv);
    }

    private void coG() {
        if (this.ihv != null) {
            MessageManager.getInstance().unRegisterListener(this.ihv);
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
            if (this.iiL == null) {
                this.iiL = new HashSet();
            }
            this.iiL.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            coH();
            this.iiK.setVisibility(0);
            String coK = k.cpd().coK();
            if (TextUtils.isEmpty(coK)) {
                i = 0;
                i2 = 0;
            } else {
                if (this.bfP == null) {
                    this.bfP = new MediaMetadataRetriever();
                }
                try {
                    this.bfP.setDataSource(coK);
                    i3 = Integer.valueOf(this.bfP.extractMetadata(18)).intValue();
                    try {
                        i = Integer.valueOf(this.bfP.extractMetadata(19)).intValue();
                        i2 = i3;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = 0;
                        i2 = i3;
                        coK = null;
                        if (i2 > 0) {
                        }
                        coK = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.iiK.bX(realScreenWidth, TextUtils.isEmpty(coK) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                        this.iiK.setData(a2, a3);
                        this.iiK.IE(coK);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i3 = 0;
                }
            }
            if (i2 > 0 || i <= 0) {
                coK = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.iiK.bX(realScreenWidth2, TextUtils.isEmpty(coK) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
            this.iiK.setData(a2, a3);
            this.iiK.IE(coK);
        }
    }

    private void coH() {
        if (this.iiK == null) {
            this.iiK = new PkRankStartAnimView(getContext());
        }
        if (bks().indexOfChild(this.iiK) < 0) {
            bks().addView(this.iiK, new ViewGroup.LayoutParams(-1, -1));
        }
        this.iiK.setVisibility(8);
        this.iiK.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.i.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void coI() {
                if (i.this.iiK != null) {
                    i.this.iiK.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.gqI = 0L;
        if (this.iiL != null) {
            this.iiL.clear();
        }
        if (this.iiK != null) {
            this.iiK.stopAnim();
            this.iiK.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.gqI <= 0 || this.gqI != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.iiL == null || !this.iiL.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.aWJ = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gVa = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gUZ = spannableString;
        }
        return qVar;
    }
}
