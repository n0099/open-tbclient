package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.r;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class u {
    private final ax bRW;
    private final Animation bRX;
    private final Animation bRY;
    private View bSa;
    private String forumId;
    private final av mRealTimeData;
    private final TbPageContext mTbPageContext;
    private int mState = 1;
    private Animation.AnimationListener bSb = new v(this);
    private final a bRZ = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends Handler {
        private final WeakReference<u> bSf;

        public a(u uVar) {
            this.bSf = new WeakReference<>(uVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    u uVar = this.bSf.get();
                    if (uVar != null) {
                        uVar.bSa.startAnimation(uVar.bRY);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public u(av avVar, ax axVar, TbPageContext tbPageContext, String str) {
        this.forumId = str;
        this.mRealTimeData = avVar;
        this.bRW = axVar;
        this.mTbPageContext = tbPageContext;
        this.bRX = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), r.a.realtime_gifview_rotate_out);
        this.bRY = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), r.a.realtime_gifview_rotate);
    }

    public void show() {
        String icon = this.mRealTimeData.getIcon();
        com.baidu.adp.lib.g.c.eA().a(icon, 17, new w(this, icon), this.mTbPageContext.getUniqueId());
        this.bRY.setAnimationListener(this.bSb);
        this.bRX.setAnimationListener(this.bSb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.bRZ.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            long longValue = this.mRealTimeData.qN().longValue();
            at atVar = new at(str);
            if (!TextUtils.isEmpty(str2)) {
                atVar.ab("obj_type", str2);
            }
            atVar.ab("obj_id", String.valueOf(longValue));
            TiebaStatic.log(atVar);
        }
    }
}
