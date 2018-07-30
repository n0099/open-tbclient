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
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static com.baidu.adp.lib.guide.c cSo;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Jn() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aRL = new EnterForumFragment();
        cVar.type = 1;
        cVar.aRM = d.j.enter_forum;
        cVar.aRN = d.f.s_tabbar_icon_two_bg;
        cVar.aRS = com.baidu.tbadk.mainTab.c.aRR;
        cVar.jT = d.f.tabbar_enterforum_anim;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c Jo;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (Jo = enterForumDelegateStatic.Jo()) != null) {
                        Jo.aRL.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
        if (l.jU()) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2921341) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
                    if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), false) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                        e.in().post(new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EnterForumDelegateStatic.B((Activity) customResponsedMessage.getData());
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B(final Activity activity) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) + 1);
        v.a(new u<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                y yVar = new y();
                yVar.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
                yVar.o("uid", TbadkCoreApplication.getCurrentAccount());
                String yq = yVar.yq();
                if (yVar.yR() && yVar.yS() == 0) {
                    try {
                        return Boolean.valueOf(new JSONObject(yq).optInt("live_bar_concerned", 0) == 1);
                    } catch (JSONException e) {
                        return false;
                    }
                }
                return false;
            }
        }, new g<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    EnterForumDelegateStatic.C(activity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(final Activity activity) {
        if (cSo != null) {
            cSo.dismiss();
        }
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.5
            @Override // java.lang.Runnable
            public void run() {
                if (EnterForumDelegateStatic.cSo != null) {
                    EnterForumDelegateStatic.cSo.dismiss();
                }
            }
        };
        com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
        dVar.D(true);
        dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.6
            @Override // com.baidu.adp.lib.guide.d.a
            public void onShown() {
            }

            @Override // com.baidu.adp.lib.guide.d.a
            public void onDismiss() {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), true);
                com.baidu.adp.lib.guide.c unused = EnterForumDelegateStatic.cSo = null;
                handler.removeCallbacks(runnable);
            }
        });
        dVar.o(activity.getWindow().getDecorView()).X(20).E(false);
        dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7
            @Override // com.baidu.adp.lib.guide.b
            public View a(LayoutInflater layoutInflater) {
                BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(activity, d.h.enter_forum_ufan_tip, null);
                TextView textView = (TextView) bubbleLayout.findViewById(d.g.enter_forum_ufan_guide_tv);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EnterForumDelegateStatic.cSo.dismiss();
                    }
                });
                am.h(textView, d.C0140d.cp_cont_i);
                bubbleLayout.ve(am.getColor(d.C0140d.cp_link_tip_a_alpha95));
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
                    dimensionPixelSize -= l.f(activity, d.e.ds20);
                }
                if (l.ak(activity) > 0.0f) {
                    return (int) ((dimensionPixelSize * 3) / l.ak(activity));
                }
                return dimensionPixelSize;
            }
        });
        cSo = dVar.hy();
        cSo.k(activity);
        handler.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator be(Context context) {
        this.aRx = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        return this.aRx;
    }
}
