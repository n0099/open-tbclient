package com.baidu.tbadk.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class e {
    private static boolean cHB = false;
    private final com.baidu.tbadk.h.g eQa;
    private ArrayList<WeakReference<Activity>> eUQ;
    private ArrayList<WeakReference<Activity>> eUR;
    private int mSkinType;
    private final CustomMessageListener skinTypeChangeListener;

    private e() {
        this.eUQ = new ArrayList<>();
        this.eUR = new ArrayList<>();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.util.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int skinType;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && e.this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                    e.this.mSkinType = skinType;
                    if (e.cHB) {
                        e.this.onChangeSkinType();
                    }
                }
            }
        };
        this.eQa = new com.baidu.tbadk.h.g() { // from class: com.baidu.tbadk.util.e.2
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                e.this.eUR.add(new WeakReference(activity));
            }

            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (e.cHB && e.this.c(e.this.ae(activity))) {
                    e.this.eUQ.add(new WeakReference(activity));
                }
            }

            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (e.cHB && e.this.d(e.this.ae(activity))) {
                    Iterator it = e.this.eUQ.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (activity != null && activity == weakReference.get()) {
                            e.this.eUQ.remove(weakReference);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Iterator it = e.this.eUR.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != null && weakReference.get() == activity) {
                        e.this.eUR.remove(weakReference);
                        return;
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
    }

    public static final e bvj() {
        return a.eUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final e eUT = new e();
    }

    public void f(Application application) {
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.eQa);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        FrameLayout ae;
        Iterator<WeakReference<Activity>> it = this.eUQ.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && next.get() != null && !next.get().isFinishing() && (ae = ae(next.get())) != null) {
                Object tag = ae.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                if (tag instanceof ViewGroup) {
                    b((ViewGroup) tag, ae.getContext());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return false;
        }
        try {
            Object tag = frameLayout.getTag(R.id.tag_scheme_baidu_box_app_back_view);
            ViewGroup viewGroup = tag instanceof ViewGroup ? (ViewGroup) tag : null;
            if (viewGroup != null && viewGroup.getParent() != null) {
                if (viewGroup.getParent() == frameLayout) {
                    return false;
                }
                frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, null);
                viewGroup = null;
            }
            if (viewGroup == null) {
                viewGroup = en(frameLayout.getContext());
            }
            if (viewGroup == null) {
                return false;
            }
            frameLayout.addView(viewGroup);
            frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, viewGroup);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds339), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89));
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds442) + UtilHelper.getNavigationBarHeight(frameLayout.getContext());
            viewGroup.setLayoutParams(layoutParams);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.util.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.eo(view.getContext());
                    e.this.jJ(false);
                    e.this.bvk();
                }
            };
            viewGroup.setClickable(true);
            viewGroup.setOnClickListener(onClickListener);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return false;
        }
        try {
            Object tag = frameLayout.getTag(R.id.tag_scheme_baidu_box_app_back_view);
            ViewGroup viewGroup = tag instanceof ViewGroup ? (ViewGroup) tag : null;
            if (viewGroup != null && viewGroup.getParent() != null && viewGroup.getParent() == frameLayout && isTokenValid(frameLayout) && isTokenValid(viewGroup)) {
                frameLayout.removeView(viewGroup);
                frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, null);
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    private ViewGroup en(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_baiduboxapp_back_view, (ViewGroup) null);
        b(viewGroup, context);
        return viewGroup;
    }

    public void jI(boolean z) {
        FrameLayout ae;
        if (cHB && (ae = ae(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            try {
                Object tag = ae.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                if (tag instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) tag;
                    if (z) {
                        viewGroup.bringToFront();
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds339), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                        layoutParams.gravity = 83;
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds207);
                        viewGroup.setLayoutParams(layoutParams);
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds339), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                        layoutParams2.gravity = 83;
                        layoutParams2.bottomMargin = UtilHelper.getNavigationBarHeight(ae.getContext()) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds442);
                        viewGroup.setLayoutParams(layoutParams2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void b(ViewGroup viewGroup, Context context) {
        if (viewGroup != null && context != null) {
            ap.setViewTextColor((TextView) viewGroup.findViewById(R.id.tv_back_shoubai_text), R.color.cp_cont_a);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds424);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).W(dimens).Y(dimens).of(R.color.topic_disagree_des_color).aZ(viewGroup);
            SvgManager.bjq().a((ImageView) viewGroup.findViewById(R.id.shoubai_back_icon), R.drawable.ic_icon_pure_list_arrow16_left_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a((ImageView) viewGroup.findViewById(R.id.shoubai_logo_icon), R.drawable.ic_icon_mask_home_backbtn_logo_n_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout ae(Activity activity) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    if (activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                        return null;
                    }
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof FrameLayout) {
                        return (FrameLayout) decorView;
                    }
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public void jJ(boolean z) {
        if (cHB != z) {
            cHB = z;
            if (cHB) {
                Iterator<WeakReference<Activity>> it = this.eUR.iterator();
                while (it.hasNext()) {
                    WeakReference<Activity> next = it.next();
                    if (next.get() != null && !next.get().isFinishing()) {
                        Activity activity = next.get();
                        if (c(ae(activity))) {
                            this.eUQ.add(new WeakReference<>(activity));
                        }
                    }
                }
                return;
            }
            Iterator<WeakReference<Activity>> it2 = this.eUR.iterator();
            while (it2.hasNext()) {
                WeakReference<Activity> next2 = it2.next();
                if (next2.get() != null && !next2.get().isFinishing()) {
                    d(ae(next2.get()));
                }
            }
            this.eUQ.clear();
        }
    }

    public void bvk() {
        BackBaiduBoxViewEvent backBaiduBoxViewEvent = new BackBaiduBoxViewEvent();
        backBaiduBoxViewEvent.isShow = cHB;
        com.baidu.tbadk.mutiprocess.g.publishEvent(backBaiduBoxViewEvent);
    }

    public void eo(Context context) {
        if (context != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://donothing"));
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    context.startActivity(intent);
                } else {
                    bvl();
                }
            } catch (Exception e) {
                bvl();
            }
        }
    }

    private void bvl() {
        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.not_install_baidu_box_app_tip);
    }

    private boolean isTokenValid(View view) {
        IBinder windowToken;
        if (view != null && (windowToken = view.getWindowToken()) != null) {
            try {
                if (windowToken.isBinderAlive()) {
                    if (windowToken.pingBinder()) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }
}
