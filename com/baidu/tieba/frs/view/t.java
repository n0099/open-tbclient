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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.r;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class t {
    private final bm chF;
    private final Animation chG;
    private final Animation chH;
    private View chJ;
    private final av mRealTimeData;
    private final TbPageContext mTbPageContext;
    private int mState = 1;
    private Animation.AnimationListener chK = new u(this);
    private final a chI = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends Handler {
        private final WeakReference<t> chO;

        public a(t tVar) {
            this.chO = new WeakReference<>(tVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    t tVar = this.chO.get();
                    if (tVar != null) {
                        tVar.chJ.startAnimation(tVar.chH);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public t(av avVar, bm bmVar, TbPageContext tbPageContext) {
        this.mRealTimeData = avVar;
        this.chF = bmVar;
        this.mTbPageContext = tbPageContext;
        this.chG = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), r.a.realtime_gifview_rotate_out);
        this.chH = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), r.a.realtime_gifview_rotate);
    }

    public void show() {
        String icon = this.mRealTimeData.getIcon();
        com.baidu.adp.lib.g.c.eA().a(icon, 17, new v(this, icon), this.mTbPageContext.getUniqueId());
        this.chH.setAnimationListener(this.chK);
        this.chG.setAnimationListener(this.chK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.chI.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            long longValue = this.mRealTimeData.qK().longValue();
            ax axVar = new ax(str);
            if (!TextUtils.isEmpty(str2)) {
                axVar.ab("obj_type", str2);
            }
            axVar.ab("obj_id", String.valueOf(longValue));
            TiebaStatic.log(axVar);
        }
    }
}
