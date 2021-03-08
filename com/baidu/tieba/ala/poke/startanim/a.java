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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.v.b {
    private MediaMetadataRetriever bfP;
    ab bzn;
    private CustomMessageListener ihv;
    private PokeStartAnimView ihw;
    String ihx;
    private boolean isShowing = false;
    String mOtherParams;
    private ViewGroup mParentView;

    @Override // com.baidu.live.v.b
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        coH();
    }

    @Override // com.baidu.live.v.b
    public void b(ab abVar, String str) {
        this.bzn = abVar;
        this.mOtherParams = str;
        reset();
        coF();
    }

    @Override // com.baidu.live.v.b
    public void a(ab abVar) {
        this.bzn = abVar;
    }

    @Override // com.baidu.live.v.b
    public void FB() {
        coG();
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        if (bks() != null) {
            return bks().getContext();
        }
        return null;
    }

    private ViewGroup bks() {
        return this.mParentView;
    }

    private void coF() {
        if (this.ihv == null) {
            this.ihv = new CustomMessageListener(2913267) { // from class: com.baidu.tieba.ala.poke.startanim.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        a.this.ihx = (String) customResponsedMessage.getData();
                        if (!a.this.isShowing) {
                            a.this.startAnim();
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ihv);
    }

    private void coG() {
        if (this.ihv != null) {
            MessageManager.getInstance().unRegisterListener(this.ihv);
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
        coH();
        this.ihw.setVisibility(0);
        String coK = c.coJ().coK();
        if (TextUtils.isEmpty(coK)) {
            i = 0;
            i2 = 0;
        } else {
            if (this.bfP == null) {
                this.bfP = new MediaMetadataRetriever();
            }
            try {
                this.bfP.setDataSource(coK);
                i3 = Integer.valueOf(this.bfP.extractMetadata(18)).intValue();
                try {
                    i = Integer.valueOf(this.bfP.extractMetadata(19)).intValue();
                    i2 = i3;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    i = 0;
                    i2 = i3;
                    coK = null;
                    if (i2 > 0) {
                    }
                    coK = null;
                    int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                    this.ihw.bX(realScreenWidth, TextUtils.isEmpty(coK) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    this.ihw.IE(coK);
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
        }
        if (i2 > 0 || i <= 0) {
            coK = null;
        }
        int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
        this.ihw.bX(realScreenWidth2, TextUtils.isEmpty(coK) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        this.ihw.IE(coK);
    }

    private void coH() {
        if (this.ihw == null) {
            this.ihw = new PokeStartAnimView(getContext());
        }
        if (bks().indexOfChild(this.ihw) < 0) {
            bks().addView(this.ihw, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ihw.setVisibility(8);
        this.ihw.setCallback(new PokeStartAnimView.a() { // from class: com.baidu.tieba.ala.poke.startanim.a.2
            @Override // com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.a
            public void coI() {
                if (a.this.ihw != null) {
                    a.this.isShowing = false;
                    a.this.ihw.setVisibility(8);
                    if (!a.this.ihx.isEmpty() && !a.this.bzn.isHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(a.this.getContext(), a.this.bzn, a.this.mOtherParams, a.this.ihx)));
                    }
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.ihw != null) {
            this.ihw.stopAnim();
            this.ihw.setVisibility(8);
        }
    }

    @Override // com.baidu.live.v.b
    public void release() {
        FB();
        if (this.bfP != null) {
            this.bfP.release();
            this.bfP = null;
        }
        if (this.ihw != null) {
            this.ihw.setCallback(null);
            this.ihw.release();
        }
        if (this.ihw != null && (this.ihw.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ihw.getParent()).removeView(this.ihw);
        }
        this.mParentView = null;
    }
}
