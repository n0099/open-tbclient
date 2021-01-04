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
public class a implements com.baidu.live.u.c {
    private MediaMetadataRetriever bfW;
    private long gqJ;
    private CustomMessageListener ifL;
    private PkRankStartAnimView igL;
    private Set<Long> igM;
    private ViewGroup mParentView;

    @Override // com.baidu.live.u.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        crn();
    }

    @Override // com.baidu.live.u.c
    public void bd(long j) {
        reset();
        this.gqJ = j;
        crl();
    }

    @Override // com.baidu.live.u.c
    public void Id() {
        crm();
        reset();
    }

    @Override // com.baidu.live.u.c
    public void release() {
        Id();
        if (this.bfW != null) {
            this.bfW.release();
            this.bfW = null;
        }
        if (this.igL != null) {
            this.igL.setCallback(null);
            this.igL.release();
        }
        if (this.igL != null && (this.igL.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.igL.getParent()).removeView(this.igL);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bnQ() != null) {
            return bnQ().getContext();
        }
        return null;
    }

    private ViewGroup bnQ() {
        return this.mParentView;
    }

    private void crl() {
        if (this.ifL == null) {
            this.ifL = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ifL);
    }

    private void crm() {
        if (this.ifL != null) {
            MessageManager.getInstance().unRegisterListener(this.ifL);
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
            if (this.igM == null) {
                this.igM = new HashSet();
            }
            this.igM.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            crn();
            this.igL.setVisibility(0);
            String crq = c.crF().crq();
            if (TextUtils.isEmpty(crq)) {
                i = 0;
                i2 = 0;
            } else {
                if (this.bfW == null) {
                    this.bfW = new MediaMetadataRetriever();
                }
                try {
                    this.bfW.setDataSource(crq);
                    i3 = Integer.valueOf(this.bfW.extractMetadata(18)).intValue();
                    try {
                        i = Integer.valueOf(this.bfW.extractMetadata(19)).intValue();
                        i2 = i3;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = 0;
                        i2 = i3;
                        crq = null;
                        if (i2 > 0) {
                        }
                        crq = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.igL.bZ(realScreenWidth, TextUtils.isEmpty(crq) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                        this.igL.setData(a2, a3);
                        this.igL.Jc(crq);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i3 = 0;
                }
            }
            if (i2 > 0 || i <= 0) {
                crq = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.igL.bZ(realScreenWidth2, TextUtils.isEmpty(crq) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
            this.igL.setData(a2, a3);
            this.igL.Jc(crq);
        }
    }

    private void crn() {
        if (this.igL == null) {
            this.igL = new PkRankStartAnimView(getContext());
        }
        if (bnQ().indexOfChild(this.igL) < 0) {
            bnQ().addView(this.igL, new ViewGroup.LayoutParams(-1, -1));
        }
        this.igL.setVisibility(8);
        this.igL.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void cro() {
                if (a.this.igL != null) {
                    a.this.igL.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.gqJ = 0L;
        if (this.igM != null) {
            this.igM.clear();
        }
        if (this.igL != null) {
            this.igL.stopAnim();
            this.igL.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.gqJ <= 0 || this.gqJ != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.igM == null || !this.igM.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.aWS = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gUZ = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gUY = spannableString;
        }
        return qVar;
    }
}
