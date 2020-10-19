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
    private MediaMetadataRetriever aZE;
    private long fKh;
    private CustomMessageListener hrH;
    private PkRankStartAnimView hrI;
    private Set<Long> hrJ;
    private ViewGroup mParentView;

    @Override // com.baidu.live.p.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cfv();
    }

    @Override // com.baidu.live.p.c
    public void ar(long j) {
        reset();
        this.fKh = j;
        cft();
    }

    @Override // com.baidu.live.p.c
    public void Gx() {
        cfu();
        reset();
    }

    @Override // com.baidu.live.p.c
    public void release() {
        Gx();
        if (this.aZE != null) {
            this.aZE.release();
            this.aZE = null;
        }
        if (this.hrI != null) {
            this.hrI.setCallback(null);
            this.hrI.release();
        }
        if (this.hrI != null && (this.hrI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hrI.getParent()).removeView(this.hrI);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bev() != null) {
            return bev().getContext();
        }
        return null;
    }

    private ViewGroup bev() {
        return this.mParentView;
    }

    private void cft() {
        if (this.hrH == null) {
            this.hrH = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hrH);
    }

    private void cfu() {
        if (this.hrH != null) {
            MessageManager.getInstance().unRegisterListener(this.hrH);
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
            if (this.hrJ == null) {
                this.hrJ = new HashSet();
            }
            this.hrJ.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            o a2 = a(pkInfoData.myPkData);
            o a3 = a(pkInfoData.otherPkData);
            cfv();
            this.hrI.setVisibility(0);
            String cfx = c.cfw().cfx();
            if (TextUtils.isEmpty(cfx)) {
                i = 0;
            } else {
                if (this.aZE == null) {
                    this.aZE = new MediaMetadataRetriever();
                }
                try {
                    this.aZE.setDataSource(cfx);
                    i2 = Integer.valueOf(this.aZE.extractMetadata(18)).intValue();
                    try {
                        i3 = Integer.valueOf(this.aZE.extractMetadata(19)).intValue();
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = i2;
                        cfx = null;
                        if (i > 0) {
                        }
                        cfx = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.hrI.bT(realScreenWidth, TextUtils.isEmpty(cfx) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                        this.hrI.setData(a2, a3);
                        this.hrI.Ib(cfx);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 0;
                }
            }
            if (i > 0 || i3 <= 0) {
                cfx = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.hrI.bT(realScreenWidth2, TextUtils.isEmpty(cfx) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
            this.hrI.setData(a2, a3);
            this.hrI.Ib(cfx);
        }
    }

    private void cfv() {
        if (this.hrI == null) {
            this.hrI = new PkRankStartAnimView(getContext());
        }
        if (bev().indexOfChild(this.hrI) < 0) {
            bev().addView(this.hrI, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hrI.setVisibility(8);
        this.hrI.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hrI != null) {
                    a.this.hrI.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.fKh = 0L;
        if (this.hrJ != null) {
            this.hrJ.clear();
        }
        if (this.hrI != null) {
            this.hrI.stopAnim();
            this.hrI.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.fKh <= 0 || this.fKh != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.hrJ == null || !this.hrJ.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private o a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        o oVar = new o();
        oVar.bed = pkUserInfoData.bdPortrait;
        oVar.nickname = pkUserInfoData.userNickName;
        oVar.gkL = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            oVar.gkK = spannableString;
        }
        return oVar;
    }
}
