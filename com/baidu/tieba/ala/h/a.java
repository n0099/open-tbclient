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
/* loaded from: classes4.dex */
public class a implements com.baidu.live.r.c {
    private MediaMetadataRetriever baJ;
    private long fXY;
    private CustomMessageListener hJf;
    private PkRankStartAnimView hJg;
    private Set<Long> hJh;
    private ViewGroup mParentView;

    @Override // com.baidu.live.r.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cks();
    }

    @Override // com.baidu.live.r.c
    public void aF(long j) {
        reset();
        this.fXY = j;
        ckq();
    }

    @Override // com.baidu.live.r.c
    public void GK() {
        ckr();
        reset();
    }

    @Override // com.baidu.live.r.c
    public void release() {
        GK();
        if (this.baJ != null) {
            this.baJ.release();
            this.baJ = null;
        }
        if (this.hJg != null) {
            this.hJg.setCallback(null);
            this.hJg.release();
        }
        if (this.hJg != null && (this.hJg.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hJg.getParent()).removeView(this.hJg);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bii() != null) {
            return bii().getContext();
        }
        return null;
    }

    private ViewGroup bii() {
        return this.mParentView;
    }

    private void ckq() {
        if (this.hJf == null) {
            this.hJf = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hJf);
    }

    private void ckr() {
        if (this.hJf != null) {
            MessageManager.getInstance().unRegisterListener(this.hJf);
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
            if (this.hJh == null) {
                this.hJh = new HashSet();
            }
            this.hJh.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            cks();
            this.hJg.setVisibility(0);
            String cku = c.ckt().cku();
            if (TextUtils.isEmpty(cku)) {
                i = 0;
            } else {
                if (this.baJ == null) {
                    this.baJ = new MediaMetadataRetriever();
                }
                try {
                    this.baJ.setDataSource(cku);
                    i2 = Integer.valueOf(this.baJ.extractMetadata(18)).intValue();
                    try {
                        i3 = Integer.valueOf(this.baJ.extractMetadata(19)).intValue();
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = i2;
                        cku = null;
                        if (i > 0) {
                        }
                        cku = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.hJg.bX(realScreenWidth, TextUtils.isEmpty(cku) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                        this.hJg.setData(a2, a3);
                        this.hJg.Is(cku);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 0;
                }
            }
            if (i > 0 || i3 <= 0) {
                cku = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.hJg.bX(realScreenWidth2, TextUtils.isEmpty(cku) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
            this.hJg.setData(a2, a3);
            this.hJg.Is(cku);
        }
    }

    private void cks() {
        if (this.hJg == null) {
            this.hJg = new PkRankStartAnimView(getContext());
        }
        if (bii().indexOfChild(this.hJg) < 0) {
            bii().addView(this.hJg, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hJg.setVisibility(8);
        this.hJg.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hJg != null) {
                    a.this.hJg.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.fXY = 0L;
        if (this.hJh != null) {
            this.hJh.clear();
        }
        if (this.hJg != null) {
            this.hJg.stopAnim();
            this.hJg.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.fXY <= 0 || this.fXY != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.hJh == null || !this.hJh.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.bfc = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gAn = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gAm = spannableString;
        }
        return qVar;
    }
}
