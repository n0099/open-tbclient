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
    private static d fCY = null;
    private Activity fCZ;
    private Activity fDa;
    private c fDb;
    private boolean fDc;
    private View mFloatingView;
    private Runnable runnable;
    private WindowManager wm;
    private int mGravity = 85;
    private int cIc = 0;
    private int cId = 0;
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.k.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    d.this.fDc = true;
                    if (d.this.fCZ != null) {
                        d.this.fDa = d.this.fCZ;
                    }
                    d.this.la(true);
                    return;
                }
                d.this.fDc = false;
                if (d.this.fDa != null) {
                    d.this.fCZ = d.this.fDa;
                    d.this.fDa = null;
                    if (com.baidu.adp.base.b.kC().l(d.this.fCZ) != -1) {
                        d.this.init();
                        d.this.kZ(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener fDd = new CustomMessageListener(2921478) { // from class: com.baidu.tbadk.k.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (map = (Map) customResponsedMessage.getData()) != null) {
                String str = (String) map.get("lifeCycle");
                if ("BarBroadcastEdit".equals((String) map.get("name"))) {
                    if (("0".equals(str) || "1".equals(str)) && (d.this.fDb instanceof a)) {
                        d.this.la(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener eTp = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.k.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && d.this.mFloatingView != null && d.this.fDb != null) {
                d.this.fDb.btU();
            }
        }
    };

    public static d bCj() {
        if (fCY == null) {
            fCY = new d();
        }
        return fCY;
    }

    public boolean init() {
        if (this.fDb == null) {
            return false;
        }
        if (this.mFloatingView == null) {
            this.mFloatingView = this.fDb.getView();
            this.mFloatingView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.k.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int l;
                    int size;
                    if (d.this.fCZ != null && (l = com.baidu.adp.base.b.kC().l(d.this.fCZ)) != -1 && l < com.baidu.adp.base.b.kC().getSize() && (size = com.baidu.adp.base.b.kC().getSize() - l) >= 0) {
                        com.baidu.adp.base.b.kC().ab(size);
                    }
                    if (d.this.fDb != null) {
                        d.this.fDb.onClick();
                    }
                    d.this.la(false);
                }
            });
        } else if (this.mFloatingView.getParent() != null) {
            return false;
        }
        return true;
    }

    public void kZ(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = com.baidu.tieba.v.c.JX(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = this.cIc;
        layoutParams.y = this.cIc;
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
                        this.fCZ = com.baidu.adp.base.b.kC().currentActivity();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                MessageManager.getInstance().registerListener(this.mBackGroundSwitchListener);
                MessageManager.getInstance().registerListener(this.eTp);
                MessageManager.getInstance().registerListener(this.fDd);
            }
        } catch (SecurityException e) {
            this.wm = null;
            this.mFloatingView = null;
        }
    }

    public void la(boolean z) {
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
                if (!z && !this.fDc) {
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
        this.cIc = i2;
        this.cId = i3;
    }

    public void a(c cVar) {
        this.fDb = cVar;
    }

    public boolean bCk() {
        return (this.wm == null || this.mFloatingView == null || this.mFloatingView.getParent() == null) ? false : true;
    }

    public void onDestory() {
        la(false);
        this.fDa = null;
        this.fCZ = null;
        this.fDb = null;
        this.mFloatingView = null;
        fCY = null;
        if (this.runnable != null) {
            e.mB().removeCallbacks(this.runnable);
        }
    }
}
