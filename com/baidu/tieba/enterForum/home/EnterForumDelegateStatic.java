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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static com.baidu.adp.lib.guide.c bsg;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Js() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aRL = new EnterForumFragment();
        cVar.type = 1;
        cVar.aRM = d.k.enter_forum;
        cVar.aRN = d.f.s_tabbar_icon_two_bg;
        cVar.aRS = com.baidu.tbadk.mainTab.c.aRR;
        cVar.kc = d.f.tabbar_enterforum_anim;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c Jt;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (Jt = enterForumDelegateStatic.Jt()) != null) {
                        Jt.aRL.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
        if (l.jT()) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2921341) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
                    if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), false) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                        e.im().post(new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2.1
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
        w.a(new v<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.v
            public Boolean doInBackground() {
                y yVar = new y();
                yVar.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
                yVar.o("uid", TbadkCoreApplication.getCurrentAccount());
                String yz = yVar.yz();
                if (yVar.za() && yVar.zb() == 0) {
                    try {
                        return Boolean.valueOf(new JSONObject(yz).optInt("live_bar_concerned", 0) == 1);
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
                    EnterForumDelegateStatic.y(activity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(final Activity activity) {
        if (bsg != null) {
            bsg.dismiss();
        }
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.5
            @Override // java.lang.Runnable
            public void run() {
                if (EnterForumDelegateStatic.bsg != null) {
                    EnterForumDelegateStatic.bsg.dismiss();
                }
            }
        };
        com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
        dVar.E(true);
        dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.6
            @Override // com.baidu.adp.lib.guide.d.a
            public void onShown() {
            }

            @Override // com.baidu.adp.lib.guide.d.a
            public void onDismiss() {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), true);
                com.baidu.adp.lib.guide.c unused = EnterForumDelegateStatic.bsg = null;
                handler.removeCallbacks(runnable);
            }
        });
        dVar.o(activity.getWindow().getDecorView()).X(20).F(false);
        dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7
            @Override // com.baidu.adp.lib.guide.b
            public View a(LayoutInflater layoutInflater) {
                BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(activity, d.i.enter_forum_ufan_tip, null);
                TextView textView = (TextView) bubbleLayout.findViewById(d.g.enter_forum_ufan_guide_tv);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EnterForumDelegateStatic.bsg.dismiss();
                    }
                });
                am.h(textView, d.C0142d.cp_cont_i);
                bubbleLayout.vf(am.getColor(d.C0142d.cp_link_tip_a_alpha95));
                return bubbleLayout;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int hw() {
                return 4;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int hx() {
                return 16;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getXOffset() {
                return l.ak(activity) > 0.0f ? (int) ((activity.getResources().getDimensionPixelSize(d.e.ds52) * 2) / l.ak(activity)) : activity.getResources().getDimensionPixelSize(d.e.ds52);
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getYOffset() {
                int dimensionPixelSize = activity.getResources().getDimensionPixelSize(d.e.ds46) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (UtilHelper.getVirtualBarHeight(activity) > 0 || MenuKeyUtils.hasSmartBar()) {
                    dimensionPixelSize -= l.e(activity, d.e.ds20);
                }
                if (l.ak(activity) > 0.0f) {
                    return (int) ((dimensionPixelSize * 3) / l.ak(activity));
                }
                return dimensionPixelSize;
            }
        });
        bsg = dVar.hy();
        bsg.k(activity);
        handler.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRx = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.i.maintab_bottom_indicator, (ViewGroup) null);
        return this.aRx;
    }
}
