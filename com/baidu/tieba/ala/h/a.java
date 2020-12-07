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
    private long ggj;
    private CustomMessageListener hTj;
    private PkRankStartAnimView hUj;
    private Set<Long> hUk;
    private ViewGroup mParentView;

    @Override // com.baidu.live.t.c
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cou();
    }

    @Override // com.baidu.live.t.c
    public void bd(long j) {
        reset();
        this.ggj = j;
        cos();
    }

    @Override // com.baidu.live.t.c
    public void IB() {
        cot();
        reset();
    }

    @Override // com.baidu.live.t.c
    public void release() {
        IB();
        if (this.bek != null) {
            this.bek.release();
            this.bek = null;
        }
        if (this.hUj != null) {
            this.hUj.setCallback(null);
            this.hUj.release();
        }
        if (this.hUj != null && (this.hUj.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hUj.getParent()).removeView(this.hUj);
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

    private void cos() {
        if (this.hTj == null) {
            this.hTj = new CustomMessageListener(2913231) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PkInfoData)) {
                        a.this.b((PkInfoData) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hTj);
    }

    private void cot() {
        if (this.hTj != null) {
            MessageManager.getInstance().unRegisterListener(this.hTj);
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
            if (this.hUk == null) {
                this.hUk = new HashSet();
            }
            this.hUk.add(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            q a2 = a(pkInfoData.myPkData);
            q a3 = a(pkInfoData.otherPkData);
            cou();
            this.hUj.setVisibility(0);
            String cow = c.coL().cow();
            if (TextUtils.isEmpty(cow)) {
                i = 0;
            } else {
                if (this.bek == null) {
                    this.bek = new MediaMetadataRetriever();
                }
                try {
                    this.bek.setDataSource(cow);
                    i2 = Integer.valueOf(this.bek.extractMetadata(18)).intValue();
                    try {
                        i3 = Integer.valueOf(this.bek.extractMetadata(19)).intValue();
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = i2;
                        cow = null;
                        if (i > 0) {
                        }
                        cow = null;
                        int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                        this.hUj.ca(realScreenWidth, TextUtils.isEmpty(cow) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                        this.hUj.setData(a2, a3);
                        this.hUj.Je(cow);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 0;
                }
            }
            if (i > 0 || i3 <= 0) {
                cow = null;
            }
            int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
            this.hUj.ca(realScreenWidth2, TextUtils.isEmpty(cow) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
            this.hUj.setData(a2, a3);
            this.hUj.Je(cow);
        }
    }

    private void cou() {
        if (this.hUj == null) {
            this.hUj = new PkRankStartAnimView(getContext());
        }
        if (bls().indexOfChild(this.hUj) < 0) {
            bls().addView(this.hUj, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hUj.setVisibility(8);
        this.hUj.setCallback(new PkRankStartAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hUj != null) {
                    a.this.hUj.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.ggj = 0L;
        if (this.hUk != null) {
            this.hUk.clear();
        }
        if (this.hUj != null) {
            this.hUj.stopAnim();
            this.hUj.setVisibility(8);
        }
    }

    private boolean c(PkInfoData pkInfoData) {
        if (getContext() == null || pkInfoData == null || pkInfoData.pkStatusInfoData == null || pkInfoData.pkStatusInfoData.pkID <= 0 || pkInfoData.myPkData == null || pkInfoData.otherPkData == null || this.ggj <= 0 || this.ggj != pkInfoData.myPkData.userID) {
            return false;
        }
        return this.hUk == null || !this.hUk.contains(Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
    }

    private q a(PkUserInfoData pkUserInfoData) {
        if (pkUserInfoData == null) {
            return null;
        }
        q qVar = new q();
        qVar.bjs = pkUserInfoData.bdPortrait;
        qVar.nickname = pkUserInfoData.userNickName;
        qVar.gJk = pkUserInfoData.divisionIcon;
        String str = pkUserInfoData.winningStreak > 1 ? pkUserInfoData.winningStreak + "连胜" : null;
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            spannableString.setSpan(new StyleSpan(3), 0, String.valueOf(pkUserInfoData.winningStreak).length(), 33);
            qVar.gJj = spannableString;
        }
        return qVar;
    }
}
