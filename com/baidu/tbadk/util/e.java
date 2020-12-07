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
/* loaded from: classes.dex */
public class e {
    private static boolean dpw = false;
    private final com.baidu.tbadk.h.g fAt;
    private ArrayList<WeakReference<Activity>> fFr;
    private ArrayList<WeakReference<Activity>> fFs;
    private int mSkinType;
    private final CustomMessageListener skinTypeChangeListener;

    private e() {
        this.fFr = new ArrayList<>();
        this.fFs = new ArrayList<>();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.util.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int skinType;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && e.this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                    e.this.mSkinType = skinType;
                    if (e.dpw) {
                        e.this.onChangeSkinType();
                    }
                }
            }
        };
        this.fAt = new com.baidu.tbadk.h.g() { // from class: com.baidu.tbadk.util.e.2
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                e.this.fFs.add(new WeakReference(activity));
            }

            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (e.dpw && e.this.g(e.this.ai(activity))) {
                    e.this.fFr.add(new WeakReference(activity));
                }
            }

            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (e.dpw && e.this.h(e.this.ai(activity))) {
                    Iterator it = e.this.fFr.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (activity != null && activity == weakReference.get()) {
                            e.this.fFr.remove(weakReference);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Iterator it = e.this.fFs.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != null && weakReference.get() == activity) {
                        e.this.fFs.remove(weakReference);
                        return;
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
    }

    public static final e bGk() {
        return a.fFu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final e fFu = new e();
    }

    public void g(Application application) {
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.fAt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        FrameLayout ai;
        Iterator<WeakReference<Activity>> it = this.fFr.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && next.get() != null && !next.get().isFinishing() && (ai = ai(next.get())) != null) {
                Object tag = ai.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                if (tag instanceof ViewGroup) {
                    b((ViewGroup) tag, ai.getContext());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(FrameLayout frameLayout) {
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
                viewGroup = fc(frameLayout.getContext());
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
                    e.this.fd(view.getContext());
                    e.this.la(false);
                    e.this.bGl();
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
    public boolean h(FrameLayout frameLayout) {
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

    private ViewGroup fc(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_baiduboxapp_back_view, (ViewGroup) null);
        b(viewGroup, context);
        return viewGroup;
    }

    public void kZ(boolean z) {
        FrameLayout ai;
        if (dpw && (ai = ai(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            try {
                Object tag = ai.getTag(R.id.tag_scheme_baidu_box_app_back_view);
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
                        layoutParams2.bottomMargin = UtilHelper.getNavigationBarHeight(ai.getContext()) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds442);
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
            ap.setViewTextColor((TextView) viewGroup.findViewById(R.id.tv_back_shoubai_text), R.color.CAM_X0101);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds424);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ad(dimens).af(dimens).qg(R.color.topic_disagree_des_color).bq(viewGroup);
            SvgManager.btW().a((ImageView) viewGroup.findViewById(R.id.shoubai_back_icon), R.drawable.ic_icon_pure_list_arrow16_left_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a((ImageView) viewGroup.findViewById(R.id.shoubai_logo_icon), R.drawable.ic_icon_mask_home_backbtn_logo_n_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout ai(Activity activity) {
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

    public void la(boolean z) {
        if (dpw != z) {
            dpw = z;
            if (dpw) {
                Iterator<WeakReference<Activity>> it = this.fFs.iterator();
                while (it.hasNext()) {
                    WeakReference<Activity> next = it.next();
                    if (next.get() != null && !next.get().isFinishing()) {
                        Activity activity = next.get();
                        if (g(ai(activity))) {
                            this.fFr.add(new WeakReference<>(activity));
                        }
                    }
                }
                return;
            }
            Iterator<WeakReference<Activity>> it2 = this.fFs.iterator();
            while (it2.hasNext()) {
                WeakReference<Activity> next2 = it2.next();
                if (next2.get() != null && !next2.get().isFinishing()) {
                    h(ai(next2.get()));
                }
            }
            this.fFr.clear();
        }
    }

    public void bGl() {
        BackBaiduBoxViewEvent backBaiduBoxViewEvent = new BackBaiduBoxViewEvent();
        backBaiduBoxViewEvent.isShow = dpw;
        com.baidu.tbadk.mutiprocess.g.publishEvent(backBaiduBoxViewEvent);
    }

    public void fd(Context context) {
        if (context != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://donothing"));
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    context.startActivity(intent);
                } else {
                    bGm();
                }
            } catch (Exception e) {
                bGm();
            }
        }
    }

    private void bGm() {
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
