package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.r;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class u {
    private final au cmM;
    private final Animation cmN;
    private final Animation cmO;
    private View cmQ;
    private String forumId;
    private final ax mRealTimeData;
    private final TbPageContext mTbPageContext;
    private int mState = 1;
    private Animation.AnimationListener cmR = new v(this);
    private final a cmP = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends Handler {
        private final WeakReference<u> cmV;

        public a(u uVar) {
            this.cmV = new WeakReference<>(uVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    u uVar = this.cmV.get();
                    if (uVar != null) {
                        uVar.cmQ.startAnimation(uVar.cmO);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public u(ax axVar, au auVar, TbPageContext tbPageContext, String str) {
        this.forumId = str;
        this.mRealTimeData = axVar;
        this.cmM = auVar;
        this.mTbPageContext = tbPageContext;
        this.cmN = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), r.a.realtime_gifview_rotate_out);
        this.cmO = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), r.a.realtime_gifview_rotate);
    }

    public void show() {
        String icon = this.mRealTimeData.getIcon();
        com.baidu.adp.lib.g.c.eA().a(icon, 17, new w(this, icon), this.mTbPageContext.getUniqueId());
        this.cmO.setAnimationListener(this.cmR);
        this.cmN.setAnimationListener(this.cmR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.cmP.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            long longValue = this.mRealTimeData.qM().longValue();
            av avVar = new av(str);
            if (!TextUtils.isEmpty(str2)) {
                avVar.ab("obj_type", str2);
            }
            avVar.ab("obj_id", String.valueOf(longValue));
            TiebaStatic.log(avVar);
        }
    }
}
