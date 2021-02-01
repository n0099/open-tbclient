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
    String ifA;
    private CustomMessageListener ify;
    private PokeStartAnimView ifz;
    private boolean isShowing = false;
    String mOtherParams;
    private ViewGroup mParentView;

    @Override // com.baidu.live.v.b
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cou();
    }

    @Override // com.baidu.live.v.b
    public void b(ab abVar, String str) {
        this.bxN = abVar;
        this.mOtherParams = str;
        reset();
        cos();
    }

    @Override // com.baidu.live.v.b
    public void a(ab abVar) {
        this.bxN = abVar;
    }

    @Override // com.baidu.live.v.b
    public void Fy() {
        cot();
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

    private void cos() {
        if (this.ify == null) {
            this.ify = new CustomMessageListener(2913267) { // from class: com.baidu.tieba.ala.poke.startanim.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        a.this.ifA = (String) customResponsedMessage.getData();
                        if (!a.this.isShowing) {
                            a.this.startAnim();
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ify);
    }

    private void cot() {
        if (this.ify != null) {
            MessageManager.getInstance().unRegisterListener(this.ify);
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
        cou();
        this.ifz.setVisibility(0);
        String cox = c.cow().cox();
        if (TextUtils.isEmpty(cox)) {
            i = 0;
            i2 = 0;
        } else {
            if (this.bem == null) {
                this.bem = new MediaMetadataRetriever();
            }
            try {
                this.bem.setDataSource(cox);
                i3 = Integer.valueOf(this.bem.extractMetadata(18)).intValue();
                try {
                    i = Integer.valueOf(this.bem.extractMetadata(19)).intValue();
                    i2 = i3;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    i = 0;
                    i2 = i3;
                    cox = null;
                    if (i2 > 0) {
                    }
                    cox = null;
                    int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                    this.ifz.bW(realScreenWidth, TextUtils.isEmpty(cox) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    this.ifz.Iu(cox);
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
        }
        if (i2 > 0 || i <= 0) {
            cox = null;
        }
        int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
        this.ifz.bW(realScreenWidth2, TextUtils.isEmpty(cox) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        this.ifz.Iu(cox);
    }

    private void cou() {
        if (this.ifz == null) {
            this.ifz = new PokeStartAnimView(getContext());
        }
        if (bkq().indexOfChild(this.ifz) < 0) {
            bkq().addView(this.ifz, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ifz.setVisibility(8);
        this.ifz.setCallback(new PokeStartAnimView.a() { // from class: com.baidu.tieba.ala.poke.startanim.a.2
            @Override // com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.a
            public void cov() {
                if (a.this.ifz != null) {
                    a.this.isShowing = false;
                    a.this.ifz.setVisibility(8);
                    if (!a.this.ifA.isEmpty() && !a.this.bxN.isHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(a.this.getContext(), a.this.bxN, a.this.mOtherParams, a.this.ifA)));
                    }
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.ifz != null) {
            this.ifz.stopAnim();
            this.ifz.setVisibility(8);
        }
    }

    @Override // com.baidu.live.v.b
    public void release() {
        Fy();
        if (this.bem != null) {
            this.bem.release();
            this.bem = null;
        }
        if (this.ifz != null) {
            this.ifz.setCallback(null);
            this.ifz.release();
        }
        if (this.ifz != null && (this.ifz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ifz.getParent()).removeView(this.ifz);
        }
        this.mParentView = null;
    }
}
