package com.baidu.tieba.ala.poke.startanim;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.d.r;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.poke.startanim.PokeStartAnimView;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.v.b {
    private MediaMetadataRetriever bek;
    w bur;
    private CustomMessageListener hTl;
    private PokeStartAnimView hTm;
    String hTn;
    private boolean isShowing = false;
    String mOtherParams;
    private ViewGroup mParentView;

    @Override // com.baidu.live.v.b
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cov();
    }

    @Override // com.baidu.live.v.b
    public void b(w wVar, String str) {
        this.bur = wVar;
        this.mOtherParams = str;
        reset();
        cot();
    }

    @Override // com.baidu.live.v.b
    public void a(w wVar) {
        this.bur = wVar;
    }

    @Override // com.baidu.live.v.b
    public void IB() {
        cou();
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
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
            this.hTl = new CustomMessageListener(2913267) { // from class: com.baidu.tieba.ala.poke.startanim.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        a.this.hTn = (String) customResponsedMessage.getData();
                        if (!a.this.isShowing) {
                            a.this.startAnim();
                        }
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
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startAnim() {
        int i;
        int i2;
        int i3 = 0;
        this.isShowing = true;
        cov();
        this.hTm.setVisibility(0);
        String cox = c.cow().cox();
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
                    this.hTm.ca(realScreenWidth, TextUtils.isEmpty(cox) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                    this.hTm.Je(cox);
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
        this.hTm.ca(realScreenWidth2, TextUtils.isEmpty(cox) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
        this.hTm.Je(cox);
    }

    private void cov() {
        if (this.hTm == null) {
            this.hTm = new PokeStartAnimView(getContext());
        }
        if (bls().indexOfChild(this.hTm) < 0) {
            bls().addView(this.hTm, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hTm.setVisibility(8);
        this.hTm.setCallback(new PokeStartAnimView.a() { // from class: com.baidu.tieba.ala.poke.startanim.a.2
            @Override // com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hTm != null) {
                    a.this.isShowing = false;
                    a.this.hTm.setVisibility(8);
                    if (!a.this.hTn.isEmpty() && !a.this.bur.isHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(a.this.getContext(), a.this.bur, a.this.mOtherParams, a.this.hTn)));
                    }
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.hTm != null) {
            this.hTm.stopAnim();
            this.hTm.setVisibility(8);
        }
    }

    @Override // com.baidu.live.v.b
    public void release() {
        IB();
        if (this.bek != null) {
            this.bek.release();
            this.bek = null;
        }
        if (this.hTm != null) {
            this.hTm.setCallback(null);
            this.hTm.release();
        }
        if (this.hTm != null && (this.hTm.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hTm.getParent()).removeView(this.hTm);
        }
        this.mParentView = null;
    }
}
