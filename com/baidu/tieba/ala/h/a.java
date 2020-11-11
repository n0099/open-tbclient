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
    private MediaMetadataRetriever bcu;
    private long fYr;
    private Set<Long> hJA;
    private CustomMessageListener hJy;
    private PkRankStartAnimView hJz;
    private ViewGroup mParentView;

    @Override // com.baidu.live.r.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        ckZ();
    }

    @Override // com.baidu.live.r.c
    public void aF(long j) {
        reset();
        this.fYr = j;
        ckX();
    }

    @Override // com.baidu.live.r.c
    public void Ht() {
        ckY();
        reset();
    }

    @Override // com.baidu.live.r.c
    public void release() {
        Ht();
        if (this.bcu != null) {
            this.bcu.release();
            this.bcu = null;
        }
        if (this.hJz != null) {
            this.hJz.setCallback(null);
            this.hJz.release();
        }
        if (this.hJz != null && (this.hJz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hJz.getParent()).removeView(this.hJz);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (biO() != null) {
            return biO().getContext();
        }
        return null;
    }

    private ViewGroup biO() {
        return this.mParentView;
    }

    private void ckX() {
        if (this.hJy == null) {
            this.hJy = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hJy);
    }

    private void ckY() {
        if (this.hJy != null) {
            MessageManager.getInstance().unRegisterListener(this.hJy);
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
            if (this.hJA == null) {
                this.hJA = new HashSet();
            }
            this.hJA.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            ckZ();
            this.hJz.setVisibility(0);
            String clb = c.cla().clb();
            if (TextUtils.isEmpty(clb)) {
                i = 0;
            } else {
                if (this.bcu == null) {
                    this.bcu = new MediaMetadataRetriever();
                }
                try {
                    this.bcu.setDataSource(clb);
                    i2 = Integer.valueOf(this.bcu.extractMetadata(18)).intValue();
                    try {
                        i3 = Integer.valueOf(this.bcu.extractMetadata(19)).intValue();
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = i2;
                        clb = null;
                        if (i > 0) {
                        }
                        clb = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.hJz.bX(realScreenWidth, TextUtils.isEmpty(clb) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                        this.hJz.setData(a2, a3);
                        this.hJz.IR(clb);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 0;
                }
            }
            if (i > 0 || i3 <= 0) {
                clb = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.hJz.bX(realScreenWidth2, TextUtils.isEmpty(clb) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
            this.hJz.setData(a2, a3);
            this.hJz.IR(clb);
        }
    }

    private void ckZ() {
        if (this.hJz == null) {
            this.hJz = new PkRankStartAnimView(getContext());
        }
        if (biO().indexOfChild(this.hJz) < 0) {
            biO().addView(this.hJz, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hJz.setVisibility(8);
        this.hJz.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hJz != null) {
                    a.this.hJz.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.fYr = 0L;
        if (this.hJA != null) {
            this.hJA.clear();
        }
        if (this.hJz != null) {
            this.hJz.stopAnim();
            this.hJz.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.fYr <= 0 || this.fYr != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.hJA == null || !this.hJA.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.bgP = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gAG = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gAF = spannableString;
        }
        return qVar;
    }
}
