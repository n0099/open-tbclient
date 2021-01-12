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
public class a implements com.baidu.live.u.c {
    private MediaMetadataRetriever bbg;
    private long gmc;
    private CustomMessageListener iba;
    private PkRankStartAnimView ica;
    private Set<Long> icb;
    private ViewGroup mParentView;

    @Override // com.baidu.live.u.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cnw();
    }

    @Override // com.baidu.live.u.c
    public void bd(long j) {
        reset();
        this.gmc = j;
        cnu();
    }

    @Override // com.baidu.live.u.c
    public void Ei() {
        cnv();
        reset();
    }

    @Override // com.baidu.live.u.c
    public void release() {
        Ei();
        if (this.bbg != null) {
            this.bbg.release();
            this.bbg = null;
        }
        if (this.ica != null) {
            this.ica.setCallback(null);
            this.ica.release();
        }
        if (this.ica != null && (this.ica.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ica.getParent()).removeView(this.ica);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bjX() != null) {
            return bjX().getContext();
        }
        return null;
    }

    private ViewGroup bjX() {
        return this.mParentView;
    }

    private void cnu() {
        if (this.iba == null) {
            this.iba = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.iba);
    }

    private void cnv() {
        if (this.iba != null) {
            MessageManager.getInstance().unRegisterListener(this.iba);
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
            if (this.icb == null) {
                this.icb = new HashSet();
            }
            this.icb.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            cnw();
            this.ica.setVisibility(0);
            String cnz = c.cnO().cnz();
            if (TextUtils.isEmpty(cnz)) {
                i = 0;
                i2 = 0;
            } else {
                if (this.bbg == null) {
                    this.bbg = new MediaMetadataRetriever();
                }
                try {
                    this.bbg.setDataSource(cnz);
                    i3 = Integer.valueOf(this.bbg.extractMetadata(18)).intValue();
                    try {
                        i = Integer.valueOf(this.bbg.extractMetadata(19)).intValue();
                        i2 = i3;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = 0;
                        i2 = i3;
                        cnz = null;
                        if (i2 > 0) {
                        }
                        cnz = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.ica.bZ(realScreenWidth, TextUtils.isEmpty(cnz) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                        this.ica.setData(a2, a3);
                        this.ica.HQ(cnz);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i3 = 0;
                }
            }
            if (i2 > 0 || i <= 0) {
                cnz = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.ica.bZ(realScreenWidth2, TextUtils.isEmpty(cnz) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
            this.ica.setData(a2, a3);
            this.ica.HQ(cnz);
        }
    }

    private void cnw() {
        if (this.ica == null) {
            this.ica = new PkRankStartAnimView(getContext());
        }
        if (bjX().indexOfChild(this.ica) < 0) {
            bjX().addView(this.ica, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ica.setVisibility(8);
        this.ica.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void cnx() {
                if (a.this.ica != null) {
                    a.this.ica.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.gmc = 0L;
        if (this.icb != null) {
            this.icb.clear();
        }
        if (this.ica != null) {
            this.ica.stopAnim();
            this.ica.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.gmc <= 0 || this.gmc != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.icb == null || !this.icb.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.aSf = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gQt = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gQs = spannableString;
        }
        return qVar;
    }
}
