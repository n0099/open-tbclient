package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static com.baidu.adp.lib.guide.c cYc;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c KD() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aVa = new EnterForumFragment();
        cVar.type = 1;
        cVar.awr = e.j.enter_forum;
        cVar.aws = e.f.s_tabbar_icon_two_bg;
        cVar.aVg = com.baidu.tbadk.mainTab.c.aVe;
        cVar.mt = e.f.tabbar_enterforum_anim;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c KE;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (KE = enterForumDelegateStatic.KE()) != null) {
                        KE.aVa.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
        if (l.la()) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2921341) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
                    if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), false) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                        com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EnterForumDelegateStatic.C((Activity) customResponsedMessage.getData());
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(final Activity activity) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) + 1);
        x.a(new w<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x();
                xVar.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
                xVar.u("uid", TbadkCoreApplication.getCurrentAccount());
                String zt = xVar.zt();
                if (xVar.zU() && xVar.zV() == 0) {
                    try {
                        return Boolean.valueOf(new JSONObject(zt).optInt("live_bar_concerned", 0) == 1);
                    } catch (JSONException e) {
                        return false;
                    }
                }
                return false;
            }
        }, new h<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    EnterForumDelegateStatic.D(activity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(final Activity activity) {
        if (cYc != null) {
            cYc.dismiss();
        }
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.5
            @Override // java.lang.Runnable
            public void run() {
                if (EnterForumDelegateStatic.cYc != null) {
                    EnterForumDelegateStatic.cYc.dismiss();
                }
            }
        };
        com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
        dVar.N(true);
        dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.6
            @Override // com.baidu.adp.lib.guide.d.a
            public void onShown() {
            }

            @Override // com.baidu.adp.lib.guide.d.a
            public void onDismiss() {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), true);
                com.baidu.adp.lib.guide.c unused = EnterForumDelegateStatic.cYc = null;
                handler.removeCallbacks(runnable);
            }
        });
        dVar.y(activity.getWindow().getDecorView()).af(20).O(false);
        dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7
            @Override // com.baidu.adp.lib.guide.b
            public View a(LayoutInflater layoutInflater) {
                BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(activity, e.h.enter_forum_ufan_tip, null);
                TextView textView = (TextView) bubbleLayout.findViewById(e.g.enter_forum_ufan_guide_tv);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EnterForumDelegateStatic.cYc.dismiss();
                    }
                });
                al.h(textView, e.d.cp_cont_i);
                bubbleLayout.vE(al.getColor(e.d.cp_link_tip_a_alpha95));
                return bubbleLayout;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int iC() {
                return 4;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int iD() {
                return 16;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getXOffset() {
                return l.aR(activity) > 0.0f ? (int) ((activity.getResources().getDimensionPixelSize(e.C0141e.ds52) * 2) / l.aR(activity)) : activity.getResources().getDimensionPixelSize(e.C0141e.ds52);
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getYOffset() {
                int dimensionPixelSize = activity.getResources().getDimensionPixelSize(e.C0141e.ds46) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (UtilHelper.getVirtualBarHeight(activity) > 0 || MenuKeyUtils.hasSmartBar()) {
                    dimensionPixelSize -= l.h(activity, e.C0141e.ds20);
                }
                if (l.aR(activity) > 0.0f) {
                    return (int) ((dimensionPixelSize * 3) / l.aR(activity));
                }
                return dimensionPixelSize;
            }
        });
        cYc = dVar.iE();
        cYc.n(activity);
        handler.postDelayed(runnable, 5000L);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bJ(Context context) {
        this.aUM = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(e.h.maintab_bottom_indicator, (ViewGroup) null);
        return this.aUM;
    }
}
