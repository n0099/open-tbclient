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
    private static d fHF = null;
    private Activity fHG;
    private Activity fHH;
    private c fHI;
    private boolean fHJ;
    private View mFloatingView;
    private Runnable runnable;
    private WindowManager wm;
    private int mGravity = 85;
    private int cMO = 0;
    private int cMP = 0;
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.k.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    d.this.fHJ = true;
                    if (d.this.fHG != null) {
                        d.this.fHH = d.this.fHG;
                    }
                    d.this.le(true);
                    return;
                }
                d.this.fHJ = false;
                if (d.this.fHH != null) {
                    d.this.fHG = d.this.fHH;
                    d.this.fHH = null;
                    if (com.baidu.adp.base.b.kC().l(d.this.fHG) != -1) {
                        d.this.init();
                        d.this.ld(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener fHK = new CustomMessageListener(2921478) { // from class: com.baidu.tbadk.k.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (map = (Map) customResponsedMessage.getData()) != null) {
                String str = (String) map.get("lifeCycle");
                if ("BarBroadcastEdit".equals((String) map.get("name"))) {
                    if (("0".equals(str) || "1".equals(str)) && (d.this.fHI instanceof a)) {
                        d.this.le(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener eYa = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.k.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && d.this.mFloatingView != null && d.this.fHI != null) {
                d.this.fHI.bxO();
            }
        }
    };

    public static d bGc() {
        if (fHF == null) {
            fHF = new d();
        }
        return fHF;
    }

    public boolean init() {
        if (this.fHI == null) {
            return false;
        }
        if (this.mFloatingView == null) {
            this.mFloatingView = this.fHI.getView();
            this.mFloatingView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.k.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int l;
                    int size;
                    if (d.this.fHG != null && (l = com.baidu.adp.base.b.kC().l(d.this.fHG)) != -1 && l < com.baidu.adp.base.b.kC().getSize() && (size = com.baidu.adp.base.b.kC().getSize() - l) >= 0) {
                        com.baidu.adp.base.b.kC().ab(size);
                    }
                    if (d.this.fHI != null) {
                        d.this.fHI.onClick();
                    }
                    d.this.le(false);
                }
            });
        } else if (this.mFloatingView.getParent() != null) {
            return false;
        }
        return true;
    }

    public void ld(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = com.baidu.tieba.v.c.LE(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = this.cMO;
        layoutParams.y = this.cMO;
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
                        this.fHG = com.baidu.adp.base.b.kC().currentActivity();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                MessageManager.getInstance().registerListener(this.mBackGroundSwitchListener);
                MessageManager.getInstance().registerListener(this.eYa);
                MessageManager.getInstance().registerListener(this.fHK);
            }
        } catch (SecurityException e) {
            this.wm = null;
            this.mFloatingView = null;
        }
    }

    public void le(boolean z) {
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
                if (!z && !this.fHJ) {
                    this.runnable = new Runnable() { // from class: com.baidu.tbadk.k.d.5
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 1));
                        }
                    };
                    e.mB().postDelayed(this.runnable, 300L);
                }
            } catch (SecurityException e) {
                this.wm = null;
                this.mFloatingView = null;
            }
        }
    }

    public void C(int i, int i2, int i3) {
        this.mGravity = i;
        this.cMO = i2;
        this.cMP = i3;
    }

    public void a(c cVar) {
        this.fHI = cVar;
    }

    public boolean bGd() {
        return (this.wm == null || this.mFloatingView == null || this.mFloatingView.getParent() == null) ? false : true;
    }

    public void onDestory() {
        le(false);
        this.fHH = null;
        this.fHG = null;
        this.fHI = null;
        this.mFloatingView = null;
        fHF = null;
        if (this.runnable != null) {
            e.mB().removeCallbacks(this.runnable);
        }
    }
}
