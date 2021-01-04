package com.baidu.tieba.ala.floating.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.liveroom.e.b;
import com.baidu.live.liveroom.e.i;
/* loaded from: classes11.dex */
public final class FloatPermissionUtil {

    /* loaded from: classes11.dex */
    public interface a {
        void onResult(int i);
    }

    public static boolean Pm() {
        b Ps = i.Pq().Ps();
        return Ps == null || Ps.Pm();
    }

    public static boolean checkPermission(Context context) {
        return Pm();
    }

    public static void an(Activity activity) {
        if (!checkPermission(activity)) {
            new com.baidu.tieba.ala.floating.permission.a().a(activity, new a() { // from class: com.baidu.tieba.ala.floating.permission.FloatPermissionUtil.1
                @Override // com.baidu.tieba.ala.floating.permission.FloatPermissionUtil.a
                public void onResult(int i) {
                }
            }).show();
        }
    }

    public static void b(Activity activity, a aVar) {
        if (ao(activity)) {
            PermissionFragment.b(activity, aVar);
        } else if (aVar != null) {
            aVar.onResult(2);
        }
    }

    public static boolean ao(Activity activity) {
        return new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(new StringBuilder().append("package:").append(activity.getPackageName()).toString())).resolveActivity(activity.getPackageManager()) != null;
    }

    @SuppressLint({"ValidFragment"})
    /* loaded from: classes11.dex */
    public static class PermissionFragment extends Fragment {
        private static a gWv = null;

        public static void b(Activity activity, a aVar) {
            gWv = aVar;
            activity.getFragmentManager().beginTransaction().add(new PermissionFragment(), activity.getLocalClassName()).commitAllowingStateLoss();
        }

        @Override // android.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (Build.VERSION.SDK_INT < 23) {
                if (gWv != null) {
                    gWv.onResult(0);
                    return;
                }
                return;
            }
            Activity activity = getActivity();
            if (activity != null && FloatPermissionUtil.ao(activity)) {
                startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), Opcodes.IFNONNULL);
            }
        }

        @Override // android.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i == 199) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.floating.permission.FloatPermissionUtil.PermissionFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean checkPermission = FloatPermissionUtil.checkPermission(PermissionFragment.this.getActivity());
                        if (PermissionFragment.gWv != null) {
                            PermissionFragment.gWv.onResult(checkPermission ? 0 : 1);
                        }
                        if (PermissionFragment.this.getFragmentManager() != null) {
                            PermissionFragment.this.getFragmentManager().beginTransaction().remove(PermissionFragment.this).commitAllowingStateLoss();
                        }
                    }
                }, 500L);
            }
        }
    }
}
