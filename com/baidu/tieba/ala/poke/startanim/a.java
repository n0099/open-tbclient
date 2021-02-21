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
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.poke.startanim.PokeStartAnimView;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.v.b {
    private MediaMetadataRetriever bem;
    ab bxN;
    private CustomMessageListener ifM;
    private PokeStartAnimView ifN;
    String ifO;
    private boolean isShowing = false;
    String mOtherParams;
    private ViewGroup mParentView;

    @Override // com.baidu.live.v.b
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        coB();
    }

    @Override // com.baidu.live.v.b
    public void b(ab abVar, String str) {
        this.bxN = abVar;
        this.mOtherParams = str;
        reset();
        coz();
    }

    @Override // com.baidu.live.v.b
    public void a(ab abVar) {
        this.bxN = abVar;
    }

    @Override // com.baidu.live.v.b
    public void Fy() {
        coA();
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        if (bkq() != null) {
            return bkq().getContext();
        }
        return null;
    }

    private ViewGroup bkq() {
        return this.mParentView;
    }

    private void coz() {
        if (this.ifM == null) {
            this.ifM = new CustomMessageListener(2913267) { // from class: com.baidu.tieba.ala.poke.startanim.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        a.this.ifO = (String) customResponsedMessage.getData();
                        if (!a.this.isShowing) {
                            a.this.startAnim();
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ifM);
    }

    private void coA() {
        if (this.ifM != null) {
            MessageManager.getInstance().unRegisterListener(this.ifM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startAnim() {
        int i;
        int i2;
        int i3;
        this.isShowing = true;
        coB();
        this.ifN.setVisibility(0);
        String coE = c.coD().coE();
        if (TextUtils.isEmpty(coE)) {
            i = 0;
            i2 = 0;
        } else {
            if (this.bem == null) {
                this.bem = new MediaMetadataRetriever();
            }
            try {
                this.bem.setDataSource(coE);
                i3 = Integer.valueOf(this.bem.extractMetadata(18)).intValue();
                try {
                    i = Integer.valueOf(this.bem.extractMetadata(19)).intValue();
                    i2 = i3;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    i = 0;
                    i2 = i3;
                    coE = null;
                    if (i2 > 0) {
                    }
                    coE = null;
                    int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                    this.ifN.bX(realScreenWidth, TextUtils.isEmpty(coE) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    this.ifN.Iv(coE);
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
        }
        if (i2 > 0 || i <= 0) {
            coE = null;
        }
        int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
        this.ifN.bX(realScreenWidth2, TextUtils.isEmpty(coE) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        this.ifN.Iv(coE);
    }

    private void coB() {
        if (this.ifN == null) {
            this.ifN = new PokeStartAnimView(getContext());
        }
        if (bkq().indexOfChild(this.ifN) < 0) {
            bkq().addView(this.ifN, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ifN.setVisibility(8);
        this.ifN.setCallback(new PokeStartAnimView.a() { // from class: com.baidu.tieba.ala.poke.startanim.a.2
            @Override // com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.a
            public void coC() {
                if (a.this.ifN != null) {
                    a.this.isShowing = false;
                    a.this.ifN.setVisibility(8);
                    if (!a.this.ifO.isEmpty() && !a.this.bxN.isHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(a.this.getContext(), a.this.bxN, a.this.mOtherParams, a.this.ifO)));
                    }
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.ifN != null) {
            this.ifN.stopAnim();
            this.ifN.setVisibility(8);
        }
    }

    @Override // com.baidu.live.v.b
    public void release() {
        Fy();
        if (this.bem != null) {
            this.bem.release();
            this.bem = null;
        }
        if (this.ifN != null) {
            this.ifN.setCallback(null);
            this.ifN.release();
        }
        if (this.ifN != null && (this.ifN.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ifN.getParent()).removeView(this.ifN);
        }
        this.mParentView = null;
    }
}
