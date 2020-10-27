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
public class a implements com.baidu.live.q.c {
    private MediaMetadataRetriever bbc;
    private long fSB;
    private CustomMessageListener hDB;
    private PkRankStartAnimView hDC;
    private Set<Long> hDD;
    private ViewGroup mParentView;

    @Override // com.baidu.live.q.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cix();
    }

    @Override // com.baidu.live.q.c
    public void at(long j) {
        reset();
        this.fSB = j;
        civ();
    }

    @Override // com.baidu.live.q.c
    public void GS() {
        ciw();
        reset();
    }

    @Override // com.baidu.live.q.c
    public void release() {
        GS();
        if (this.bbc != null) {
            this.bbc.release();
            this.bbc = null;
        }
        if (this.hDC != null) {
            this.hDC.setCallback(null);
            this.hDC.release();
        }
        if (this.hDC != null && (this.hDC.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hDC.getParent()).removeView(this.hDC);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bgo() != null) {
            return bgo().getContext();
        }
        return null;
    }

    private ViewGroup bgo() {
        return this.mParentView;
    }

    private void civ() {
        if (this.hDB == null) {
            this.hDB = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hDB);
    }

    private void ciw() {
        if (this.hDB != null) {
            MessageManager.getInstance().unRegisterListener(this.hDB);
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
            if (this.hDD == null) {
                this.hDD = new HashSet();
            }
            this.hDD.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            cix();
            this.hDC.setVisibility(0);
            String ciz = c.ciy().ciz();
            if (TextUtils.isEmpty(ciz)) {
                i = 0;
            } else {
                if (this.bbc == null) {
                    this.bbc = new MediaMetadataRetriever();
                }
                try {
                    this.bbc.setDataSource(ciz);
                    i2 = Integer.valueOf(this.bbc.extractMetadata(18)).intValue();
                    try {
                        i3 = Integer.valueOf(this.bbc.extractMetadata(19)).intValue();
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = i2;
                        ciz = null;
                        if (i > 0) {
                        }
                        ciz = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.hDC.bV(realScreenWidth, TextUtils.isEmpty(ciz) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                        this.hDC.setData(a2, a3);
                        this.hDC.IA(ciz);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 0;
                }
            }
            if (i > 0 || i3 <= 0) {
                ciz = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.hDC.bV(realScreenWidth2, TextUtils.isEmpty(ciz) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
            this.hDC.setData(a2, a3);
            this.hDC.IA(ciz);
        }
    }

    private void cix() {
        if (this.hDC == null) {
            this.hDC = new PkRankStartAnimView(getContext());
        }
        if (bgo().indexOfChild(this.hDC) < 0) {
            bgo().addView(this.hDC, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hDC.setVisibility(8);
        this.hDC.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hDC != null) {
                    a.this.hDC.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.fSB = 0L;
        if (this.hDD != null) {
            this.hDD.clear();
        }
        if (this.hDC != null) {
            this.hDC.stopAnim();
            this.hDC.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.fSB <= 0 || this.fSB != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.hDD == null || !this.hDD.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.bfv = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.guS = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.guR = spannableString;
        }
        return qVar;
    }
}
