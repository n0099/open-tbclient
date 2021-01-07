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
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.poke.startanim.PokeStartAnimView;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.w.b {
    private MediaMetadataRetriever bfW;
    x bzc;
    private CustomMessageListener ifL;
    private PokeStartAnimView ifM;
    String ifN;
    private boolean isShowing = false;
    String mOtherParams;
    private ViewGroup mParentView;

    @Override // com.baidu.live.w.b
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cro();
    }

    @Override // com.baidu.live.w.b
    public void b(x xVar, String str) {
        this.bzc = xVar;
        this.mOtherParams = str;
        reset();
        crm();
    }

    @Override // com.baidu.live.w.b
    public void a(x xVar) {
        this.bzc = xVar;
    }

    @Override // com.baidu.live.w.b
    public void Id() {
        crn();
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        if (bnR() != null) {
            return bnR().getContext();
        }
        return null;
    }

    private ViewGroup bnR() {
        return this.mParentView;
    }

    private void crm() {
        if (this.ifL == null) {
            this.ifL = new CustomMessageListener(2913267) { // from class: com.baidu.tieba.ala.poke.startanim.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        a.this.ifN = (String) customResponsedMessage.getData();
                        if (!a.this.isShowing) {
                            a.this.startAnim();
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ifL);
    }

    private void crn() {
        if (this.ifL != null) {
            MessageManager.getInstance().unRegisterListener(this.ifL);
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
        cro();
        this.ifM.setVisibility(0);
        String crr = c.crq().crr();
        if (TextUtils.isEmpty(crr)) {
            i = 0;
            i2 = 0;
        } else {
            if (this.bfW == null) {
                this.bfW = new MediaMetadataRetriever();
            }
            try {
                this.bfW.setDataSource(crr);
                i3 = Integer.valueOf(this.bfW.extractMetadata(18)).intValue();
                try {
                    i = Integer.valueOf(this.bfW.extractMetadata(19)).intValue();
                    i2 = i3;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    i = 0;
                    i2 = i3;
                    crr = null;
                    if (i2 > 0) {
                    }
                    crr = null;
                    int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                    this.ifM.bZ(realScreenWidth, TextUtils.isEmpty(crr) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    this.ifM.Jb(crr);
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
        }
        if (i2 > 0 || i <= 0) {
            crr = null;
        }
        int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
        this.ifM.bZ(realScreenWidth2, TextUtils.isEmpty(crr) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        this.ifM.Jb(crr);
    }

    private void cro() {
        if (this.ifM == null) {
            this.ifM = new PokeStartAnimView(getContext());
        }
        if (bnR().indexOfChild(this.ifM) < 0) {
            bnR().addView(this.ifM, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ifM.setVisibility(8);
        this.ifM.setCallback(new PokeStartAnimView.a() { // from class: com.baidu.tieba.ala.poke.startanim.a.2
            @Override // com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.a
            public void crp() {
                if (a.this.ifM != null) {
                    a.this.isShowing = false;
                    a.this.ifM.setVisibility(8);
                    if (!a.this.ifN.isEmpty() && !a.this.bzc.isHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(a.this.getContext(), a.this.bzc, a.this.mOtherParams, a.this.ifN)));
                    }
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.ifM != null) {
            this.ifM.stopAnim();
            this.ifM.setVisibility(8);
        }
    }

    @Override // com.baidu.live.w.b
    public void release() {
        Id();
        if (this.bfW != null) {
            this.bfW.release();
            this.bfW = null;
        }
        if (this.ifM != null) {
            this.ifM.setCallback(null);
            this.ifM.release();
        }
        if (this.ifM != null && (this.ifM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ifM.getParent()).removeView(this.ifM);
        }
        this.mParentView = null;
    }
}
