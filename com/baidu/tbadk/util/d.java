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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private static boolean dGg = false;
    private final com.baidu.tbadk.h.e dBL;
    private ArrayList<WeakReference<Activity>> dGh;
    private ArrayList<WeakReference<Activity>> dGi;
    private int mSkinType;
    private final CustomMessageListener skinTypeChangeListener;

    private d() {
        this.dGh = new ArrayList<>();
        this.dGi = new ArrayList<>();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.util.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int skinType;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && d.this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                    d.this.mSkinType = skinType;
                    if (d.dGg) {
                        d.this.onChangeSkinType();
                    }
                }
            }
        };
        this.dBL = new com.baidu.tbadk.h.e() { // from class: com.baidu.tbadk.util.d.2
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                d.this.dGi.add(new WeakReference(activity));
            }

            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (d.dGg && d.this.c(d.this.af(activity))) {
                    d.this.dGh.add(new WeakReference(activity));
                }
            }

            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (d.dGg && d.this.d(d.this.af(activity))) {
                    Iterator it = d.this.dGh.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (activity != null && activity == weakReference.get()) {
                            d.this.dGh.remove(weakReference);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Iterator it = d.this.dGi.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != null && weakReference.get() == activity) {
                        d.this.dGi.remove(weakReference);
                        return;
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
    }

    public static final d aRP() {
        return a.dGk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d dGk = new d();
    }

    public void e(Application application) {
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.dBL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        FrameLayout af;
        Iterator<WeakReference<Activity>> it = this.dGh.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && next.get() != null && !next.get().isFinishing() && (af = af(next.get())) != null) {
                Object tag = af.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                if (tag instanceof ViewGroup) {
                    b((ViewGroup) tag, af.getContext());
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
                viewGroup = eg(frameLayout.getContext());
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
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.util.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.eh(view.getContext());
                    d.this.setShow(false);
                    d.this.aRQ();
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

    private ViewGroup eg(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_baiduboxapp_back_view, (ViewGroup) null);
        b(viewGroup, context);
        return viewGroup;
    }

    public void gZ(boolean z) {
        FrameLayout af;
        if (dGg && (af = af(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            try {
                Object tag = af.getTag(R.id.tag_scheme_baidu_box_app_back_view);
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
                        layoutParams2.bottomMargin = UtilHelper.getNavigationBarHeight(af.getContext()) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds442);
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
            am.setViewTextColor((TextView) viewGroup.findViewById(R.id.tv_back_shoubai_text), (int) R.color.cp_cont_a);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds424);
            com.baidu.tbadk.core.util.f.a.aGY().kB(0).kI(1).ag(dimens).ai(dimens).kC(R.color.topic_disagree_des_color).aQ(viewGroup);
            SvgManager.aGA().a((ImageView) viewGroup.findViewById(R.id.shoubai_back_icon), R.drawable.ic_icon_pure_list_arrow16_left_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGA().a((ImageView) viewGroup.findViewById(R.id.shoubai_logo_icon), R.drawable.ic_icon_mask_home_backbtn_logo_n_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout af(Activity activity) {
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

    public void setShow(boolean z) {
        if (dGg != z) {
            dGg = z;
            if (dGg) {
                Iterator<WeakReference<Activity>> it = this.dGi.iterator();
                while (it.hasNext()) {
                    WeakReference<Activity> next = it.next();
                    if (next.get() != null && !next.get().isFinishing()) {
                        Activity activity = next.get();
                        if (c(af(activity))) {
                            this.dGh.add(new WeakReference<>(activity));
                        }
                    }
                }
                return;
            }
            Iterator<WeakReference<Activity>> it2 = this.dGi.iterator();
            while (it2.hasNext()) {
                WeakReference<Activity> next2 = it2.next();
                if (next2.get() != null && !next2.get().isFinishing()) {
                    d(af(next2.get()));
                }
            }
            this.dGh.clear();
        }
    }

    public void aRQ() {
        BackBaiduBoxViewEvent backBaiduBoxViewEvent = new BackBaiduBoxViewEvent();
        backBaiduBoxViewEvent.isShow = dGg;
        com.baidu.tbadk.mutiprocess.g.publishEvent(backBaiduBoxViewEvent);
    }

    public void eh(Context context) {
        if (context != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://donothing"));
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    context.startActivity(intent);
                } else {
                    aRR();
                }
            } catch (Exception e) {
                aRR();
            }
        }
    }

    private void aRR() {
        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.not_install_baidu_box_app_tip);
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
