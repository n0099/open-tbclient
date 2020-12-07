package com.baidu.tbadk.k;

import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.R;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static d fxY = null;
    private Activity fxZ;
    private Activity fya;
    private c fyb;
    private boolean fyc;
    private View mFloatingView;
    private Runnable runnable;
    private WindowManager wm;
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.k.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    d.this.fyc = true;
                    if (d.this.fxZ != null) {
                        d.this.fya = d.this.fxZ;
                    }
                    d.this.kI(true);
                    return;
                }
                d.this.fyc = false;
                if (d.this.fya != null) {
                    d.this.fxZ = d.this.fya;
                    d.this.fya = null;
                    if (com.baidu.adp.base.a.lg().m(d.this.fxZ) != -1) {
                        d.this.init();
                        d.this.kH(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener fyd = new CustomMessageListener(2921478) { // from class: com.baidu.tbadk.k.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (map = (Map) customResponsedMessage.getData()) != null) {
                String str = (String) map.get("lifeCycle");
                if ("BarBroadcastEdit".equals((String) map.get("name"))) {
                    if (("0".equals(str) || "1".equals(str)) && (d.this.fyb instanceof a)) {
                        d.this.kI(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.k.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && d.this.mFloatingView != null && d.this.fyb != null) {
                d.this.fyb.bvs();
            }
        }
    };

    public static d bDH() {
        if (fxY == null) {
            fxY = new d();
        }
        return fxY;
    }

    public boolean init() {
        if (this.fyb == null) {
            return false;
        }
        if (this.mFloatingView == null) {
            this.mFloatingView = this.fyb.getView();
            this.mFloatingView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.k.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int m;
                    int size;
                    if (d.this.fxZ != null && (m = com.baidu.adp.base.a.lg().m(d.this.fxZ)) != -1 && m < com.baidu.adp.base.a.lg().getSize() && (size = com.baidu.adp.base.a.lg().getSize() - m) >= 0) {
                        com.baidu.adp.base.a.lg().ab(size);
                    }
                    if (d.this.fyb != null) {
                        d.this.fyb.onClick();
                    }
                    d.this.kI(false);
                }
            });
        } else if (this.mFloatingView.getParent() != null) {
            return false;
        }
        return true;
    }

    public void kH(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = com.baidu.tieba.w.c.LQ(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 85;
        if (this.wm == null) {
            this.wm = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                this.wm = null;
                this.mFloatingView = null;
            } else if (init()) {
                if (this.mFloatingView != null && this.mFloatingView.getParent() == null) {
                    this.wm.addView(this.mFloatingView, layoutParams);
                    if (z) {
                        this.fxZ = com.baidu.adp.base.a.lg().currentActivity();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                MessageManager.getInstance().registerListener(this.mBackGroundSwitchListener);
                MessageManager.getInstance().registerListener(this.eOd);
                MessageManager.getInstance().registerListener(this.fyd);
            }
        } catch (SecurityException e) {
            this.wm = null;
            this.mFloatingView = null;
        }
    }

    public void kI(boolean z) {
        if (this.wm == null) {
            this.wm = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        if (this.mFloatingView != null && this.mFloatingView.getParent() != null) {
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    if (this.wm != null && this.mFloatingView != null) {
                        this.wm.removeView(this.mFloatingView);
                    }
                    this.wm = null;
                    this.mFloatingView = null;
                    return;
                }
                this.wm.removeView(this.mFloatingView);
                this.mFloatingView = null;
                this.wm = null;
                if (!z && !this.fyc) {
                    this.runnable = new Runnable() { // from class: com.baidu.tbadk.k.d.5
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 1));
                        }
                    };
                    e.mY().postDelayed(this.runnable, 300L);
                }
            } catch (SecurityException e) {
                this.wm = null;
                this.mFloatingView = null;
            }
        }
    }

    public void a(c cVar) {
        this.fyb = cVar;
    }

    public boolean bDI() {
        return (this.wm == null || this.mFloatingView == null || this.mFloatingView.getParent() == null) ? false : true;
    }

    public void onDestory() {
        kI(false);
        this.fya = null;
        this.fxZ = null;
        this.fyb = null;
        this.mFloatingView = null;
        fxY = null;
        if (this.runnable != null) {
            e.mY().removeCallbacks(this.runnable);
        }
    }
}
