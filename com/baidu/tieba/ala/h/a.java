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
public class a implements com.baidu.live.t.c {
    private MediaMetadataRetriever bek;
    private long ggl;
    private CustomMessageListener hTl;
    private PkRankStartAnimView hUl;
    private Set<Long> hUm;
    private ViewGroup mParentView;

    @Override // com.baidu.live.t.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cov();
    }

    @Override // com.baidu.live.t.c
    public void bd(long j) {
        reset();
        this.ggl = j;
        cot();
    }

    @Override // com.baidu.live.t.c
    public void IB() {
        cou();
        reset();
    }

    @Override // com.baidu.live.t.c
    public void release() {
        IB();
        if (this.bek != null) {
            this.bek.release();
            this.bek = null;
        }
        if (this.hUl != null) {
            this.hUl.setCallback(null);
            this.hUl.release();
        }
        if (this.hUl != null && (this.hUl.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hUl.getParent()).removeView(this.hUl);
        }
        this.mParentView = null;
    }

    private Context getContext() {
        if (bls() != null) {
            return bls().getContext();
        }
        return null;
    }

    private ViewGroup bls() {
        return this.mParentView;
    }

    private void cot() {
        if (this.hTl == null) {
            this.hTl = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hTl);
    }

    private void cou() {
        if (this.hTl != null) {
            MessageManager.getInstance().unRegisterListener(this.hTl);
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
            if (this.hUm == null) {
                this.hUm = new HashSet();
            }
            this.hUm.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            cov();
            this.hUl.setVisibility(0);
            String cox = c.coM().cox();
            if (TextUtils.isEmpty(cox)) {
                i = 0;
            } else {
                if (this.bek == null) {
                    this.bek = new MediaMetadataRetriever();
                }
                try {
                    this.bek.setDataSource(cox);
                    i2 = Integer.valueOf(this.bek.extractMetadata(18)).intValue();
                    try {
                        i3 = Integer.valueOf(this.bek.extractMetadata(19)).intValue();
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = i2;
                        cox = null;
                        if (i > 0) {
                        }
                        cox = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.hUl.ca(realScreenWidth, TextUtils.isEmpty(cox) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                        this.hUl.setData(a2, a3);
                        this.hUl.Je(cox);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 0;
                }
            }
            if (i > 0 || i3 <= 0) {
                cox = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.hUl.ca(realScreenWidth2, TextUtils.isEmpty(cox) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
            this.hUl.setData(a2, a3);
            this.hUl.Je(cox);
        }
    }

    private void cov() {
        if (this.hUl == null) {
            this.hUl = new PkRankStartAnimView(getContext());
        }
        if (bls().indexOfChild(this.hUl) < 0) {
            bls().addView(this.hUl, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hUl.setVisibility(8);
        this.hUl.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hUl != null) {
                    a.this.hUl.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.ggl = 0L;
        if (this.hUm != null) {
            this.hUm.clear();
        }
        if (this.hUl != null) {
            this.hUl.stopAnim();
            this.hUl.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.ggl <= 0 || this.ggl != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.hUm == null || !this.hUm.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.bjs = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gJm = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gJl = spannableString;
        }
        return qVar;
    }
}
