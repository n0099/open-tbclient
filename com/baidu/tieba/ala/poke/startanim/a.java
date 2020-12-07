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
    private CustomMessageListener hTj;
    private PokeStartAnimView hTk;
    String hTl;
    private boolean isShowing = false;
    String mOtherParams;
    private ViewGroup mParentView;

    @Override // com.baidu.live.v.b
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cou();
    }

    @Override // com.baidu.live.v.b
    public void b(w wVar, String str) {
        this.bur = wVar;
        this.mOtherParams = str;
        reset();
        cos();
    }

    @Override // com.baidu.live.v.b
    public void a(w wVar) {
        this.bur = wVar;
    }

    @Override // com.baidu.live.v.b
    public void IB() {
        cot();
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

    private void cos() {
        if (this.hTj == null) {
            this.hTj = new CustomMessageListener(2913267) { // from class: com.baidu.tieba.ala.poke.startanim.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        a.this.hTl = (String) customResponsedMessage.getData();
                        if (!a.this.isShowing) {
                            a.this.startAnim();
                        }
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
        cou();
        this.hTk.setVisibility(0);
        String cow = c.cov().cow();
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
                    this.hTk.ca(realScreenWidth, TextUtils.isEmpty(cow) ? (realScreenWidth * i3) / (i / 2) : realScreenWidth);
                    this.hTk.Je(cow);
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
        this.hTk.ca(realScreenWidth2, TextUtils.isEmpty(cow) ? (realScreenWidth2 * i3) / (i / 2) : realScreenWidth2);
        this.hTk.Je(cow);
    }

    private void cou() {
        if (this.hTk == null) {
            this.hTk = new PokeStartAnimView(getContext());
        }
        if (bls().indexOfChild(this.hTk) < 0) {
            bls().addView(this.hTk, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hTk.setVisibility(8);
        this.hTk.setCallback(new PokeStartAnimView.a() { // from class: com.baidu.tieba.ala.poke.startanim.a.2
            @Override // com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.a
            public void onAnimEnd() {
                if (a.this.hTk != null) {
                    a.this.isShowing = false;
                    a.this.hTk.setVisibility(8);
                    if (!a.this.hTl.isEmpty() && !a.this.bur.isHost) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(a.this.getContext(), a.this.bur, a.this.mOtherParams, a.this.hTl)));
                    }
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.hTk != null) {
            this.hTk.stopAnim();
            this.hTk.setVisibility(8);
        }
    }

    @Override // com.baidu.live.v.b
    public void release() {
        IB();
        if (this.bek != null) {
            this.bek.release();
            this.bek = null;
        }
        if (this.hTk != null) {
            this.hTk.setCallback(null);
            this.hTk.release();
        }
        if (this.hTk != null && (this.hTk.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hTk.getParent()).removeView(this.hTk);
        }
        this.mParentView = null;
    }
}
