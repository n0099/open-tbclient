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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.w.b {
    private MediaMetadataRetriever bbg;
    x buq;
    private CustomMessageListener iba;
    private PokeStartAnimView ibb;
    String ibc;
    private boolean isShowing = false;
    String mOtherParams;
    private ViewGroup mParentView;

    @Override // com.baidu.live.w.b
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cnw();
    }

    @Override // com.baidu.live.w.b
    public void b(x xVar, String str) {
        this.buq = xVar;
        this.mOtherParams = str;
        reset();
        cnu();
    }

    @Override // com.baidu.live.w.b
    public void a(x xVar) {
        this.buq = xVar;
    }

    @Override // com.baidu.live.w.b
    public void Ei() {
        cnv();
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
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
            this.iba = new CustomMessageListener(2913267) { // from class: com.baidu.tieba.ala.poke.startanim.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        a.this.ibc = (String) customResponsedMessage.getData();
                        if (!a.this.isShowing) {
                            a.this.startAnim();
                        }
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
        cnw();
        this.ibb.setVisibility(0);
        String cnz = c.cny().cnz();
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
                    this.ibb.bZ(realScreenWidth, TextUtils.isEmpty(cnz) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    this.ibb.HQ(cnz);
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
        this.ibb.bZ(realScreenWidth2, TextUtils.isEmpty(cnz) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        this.ibb.HQ(cnz);
    }

    private void cnw() {
        if (this.ibb == null) {
            this.ibb = new PokeStartAnimView(getContext());
        }
        if (bjX().indexOfChild(this.ibb) < 0) {
            bjX().addView(this.ibb, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ibb.setVisibility(8);
        this.ibb.setCallback(new PokeStartAnimView.a() { // from class: com.baidu.tieba.ala.poke.startanim.a.2
            @Override // com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.a
            public void cnx() {
                if (a.this.ibb != null) {
                    a.this.isShowing = false;
                    a.this.ibb.setVisibility(8);
                    if (!a.this.ibc.isEmpty() && !a.this.buq.isHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(a.this.getContext(), a.this.buq, a.this.mOtherParams, a.this.ibc)));
                    }
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.ibb != null) {
            this.ibb.stopAnim();
            this.ibb.setVisibility(8);
        }
    }

    @Override // com.baidu.live.w.b
    public void release() {
        Ei();
        if (this.bbg != null) {
            this.bbg.release();
            this.bbg = null;
        }
        if (this.ibb != null) {
            this.ibb.setCallback(null);
            this.ibb.release();
        }
        if (this.ibb != null && (this.ibb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ibb.getParent()).removeView(this.ibb);
        }
        this.mParentView = null;
    }
}
