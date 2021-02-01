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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static d fFk = null;
    private Activity fFl;
    private Activity fFm;
    private c fFn;
    private boolean fFo;
    private View mFloatingView;
    private Runnable runnable;
    private WindowManager wm;
    private int mGravity = 85;
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.k.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    d.this.fFo = true;
                    if (d.this.fFl != null) {
                        d.this.fFm = d.this.fFl;
                    }
                    d.this.ld(true);
                    return;
                }
                d.this.fFo = false;
                if (d.this.fFm != null) {
                    d.this.fFl = d.this.fFm;
                    d.this.fFm = null;
                    if (com.baidu.adp.base.b.kB().l(d.this.fFl) != -1) {
                        d.this.init();
                        d.this.lc(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener fFp = new CustomMessageListener(2921478) { // from class: com.baidu.tbadk.k.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (map = (Map) customResponsedMessage.getData()) != null) {
                String str = (String) map.get("lifeCycle");
                if ("BarBroadcastEdit".equals((String) map.get("name"))) {
                    if (("0".equals(str) || "1".equals(str)) && (d.this.fFn instanceof a)) {
                        d.this.ld(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.k.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && d.this.mFloatingView != null && d.this.fFn != null) {
                d.this.fFn.buo();
            }
        }
    };

    public static d bCB() {
        if (fFk == null) {
            fFk = new d();
        }
        return fFk;
    }

    public boolean init() {
        if (this.fFn == null) {
            return false;
        }
        if (this.mFloatingView == null) {
            this.mFloatingView = this.fFn.getView();
            this.mFloatingView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.k.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int l;
                    int size;
                    if (d.this.fFl != null && (l = com.baidu.adp.base.b.kB().l(d.this.fFl)) != -1 && l < com.baidu.adp.base.b.kB().getSize() && (size = com.baidu.adp.base.b.kB().getSize() - l) >= 0) {
                        com.baidu.adp.base.b.kB().ab(size);
                    }
                    if (d.this.fFn != null) {
                        d.this.fFn.onClick();
                    }
                    d.this.ld(false);
                }
            });
        } else if (this.mFloatingView.getParent() != null) {
            return false;
        }
        return true;
    }

    public void lc(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = com.baidu.tieba.v.c.Kr(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = this.mOffsetX;
        layoutParams.y = this.mOffsetX;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = this.mGravity;
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
                        this.fFl = com.baidu.adp.base.b.kB().currentActivity();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                MessageManager.getInstance().registerListener(this.mBackGroundSwitchListener);
                MessageManager.getInstance().registerListener(this.eVF);
                MessageManager.getInstance().registerListener(this.fFp);
            }
        } catch (SecurityException e) {
            this.wm = null;
            this.mFloatingView = null;
        }
    }

    public void ld(boolean z) {
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
                if (!z && !this.fFo) {
                    this.runnable = new Runnable() { // from class: com.baidu.tbadk.k.d.5
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 1));
                        }
                    };
                    e.mA().postDelayed(this.runnable, 300L);
                }
            } catch (SecurityException e) {
                this.wm = null;
                this.mFloatingView = null;
            }
        }
    }

    public void C(int i, int i2, int i3) {
        this.mGravity = i;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
    }

    public void a(c cVar) {
        this.fFn = cVar;
    }

    public boolean bCC() {
        return (this.wm == null || this.mFloatingView == null || this.mFloatingView.getParent() == null) ? false : true;
    }

    public void onDestory() {
        ld(false);
        this.fFm = null;
        this.fFl = null;
        this.fFn = null;
        this.mFloatingView = null;
        fFk = null;
        if (this.runnable != null) {
            e.mA().removeCallbacks(this.runnable);
        }
    }
}
