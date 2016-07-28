package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class t {
    private View bWB;
    private final bq bWx;
    private final Animation bWy;
    private final Animation bWz;
    private final ar mRealTimeData;
    private final TbPageContext mTbPageContext;
    private int mState = 1;
    private Animation.AnimationListener bWC = new u(this);
    private final a bWA = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends Handler {
        private final WeakReference<t> bWG;

        public a(t tVar) {
            this.bWG = new WeakReference<>(tVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    t tVar = this.bWG.get();
                    if (tVar != null) {
                        tVar.bWB.startAnimation(tVar.bWz);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public t(ar arVar, bq bqVar, TbPageContext tbPageContext) {
        this.mRealTimeData = arVar;
        this.bWx = bqVar;
        this.mTbPageContext = tbPageContext;
        this.bWy = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), u.a.realtime_gifview_rotate_out);
        this.bWz = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), u.a.realtime_gifview_rotate);
    }

    public void show() {
        String icon = this.mRealTimeData.getIcon();
        com.baidu.adp.lib.g.c.dF().a(icon, 17, new v(this, icon), this.mTbPageContext.getUniqueId());
        this.bWz.setAnimationListener(this.bWC);
        this.bWy.setAnimationListener(this.bWC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.bWA.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            long longValue = this.mRealTimeData.pv().longValue();
            ay ayVar = new ay(str);
            if (!TextUtils.isEmpty(str2)) {
                ayVar.ab("obj_type", str2);
            }
            ayVar.ab("obj_id", String.valueOf(longValue));
            TiebaStatic.log(ayVar);
        }
    }
}
