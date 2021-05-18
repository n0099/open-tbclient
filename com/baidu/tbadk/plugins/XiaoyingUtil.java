package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.j0.r.s.a;
/* loaded from: classes3.dex */
public class XiaoyingUtil {
    public static final String PKG_NAME_VIDEO = "cn.jingling.motu.photowonder.plugin.mv";
    public static int showTime;

    /* loaded from: classes3.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f13009e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f13010f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f13011g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f13012h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f13013i;

        public a(Context context, String str, int i2, int i3, String str2) {
            this.f13009e = context;
            this.f13010f = str;
            this.f13011g = i2;
            this.f13012h = i3;
            this.f13013i = str2;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(this.f13009e, this.f13010f, this.f13011g, this.f13012h, this.f13013i)));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {
        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f13014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f13015f;

        public c(Activity activity, TbPageContext tbPageContext) {
            this.f13014e = activity;
            this.f13015f = tbPageContext;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f13015f.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(this.f13014e, XiaoyingUtil.PKG_NAME_VIDEO)));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {
        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public static int getShowTime() {
        return showTime;
    }

    public static boolean isXiaoyingForbidden() {
        return PluginPackageManager.O().b0(PKG_NAME_VIDEO);
    }

    public static boolean isXiaoyingInstalled() {
        return PluginPackageManager.O().d0(PKG_NAME_VIDEO) && TbadkCoreApplication.getInst().appResponseToIntentClass(MotuVideoConfig.class);
    }

    public static void setShowTime(int i2) {
        showTime = i2;
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(pageActivity);
        aVar.setMessage(str);
        aVar.setPositiveButton(str2, new c(pageActivity, tbPageContext));
        aVar.setNegativeButton(R.string.cancel, new d());
        aVar.create(tbPageContext).show();
    }

    public static void showStartPlayVideoDialog(Context context, String str, int i2, int i3, String str2) {
        f<?> a2 = j.a(context);
        if (a2 == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(a2.getPageActivity());
        aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
        aVar.setPositiveButton(R.string.confirm, new a(context, str, i2, i3, str2));
        aVar.setNegativeButton(R.string.cancel, new b());
        aVar.create(a2).show();
    }

    public static boolean showXiaoyingTool() {
        PluginNetConfigInfos.PluginConfig R;
        return (!TbadkCoreApplication.getInst().isXiaoyingAvaliable() || Build.VERSION.SDK_INT < 14 || (R = PluginPackageManager.O().R(PKG_NAME_VIDEO)) == null || TextUtils.isEmpty(R.display_name) || R.forbidden == 1 || d.a.c.h.j.g.d.k().h(PKG_NAME_VIDEO) == null) ? false : true;
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i2, int i3, String str2) {
        startPlayXiaoyingVideo(context, str, i2, i3, str2, true);
    }

    public static void startXiaoying(Context context) {
        if (context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MotuVideoConfig(context)));
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i2, int i3, String str2, boolean z) {
        if (context == null || StringUtils.isNull(str)) {
            return;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(XiaoyingPlayerConfig.class)) {
            BdToast.c(context, context.getString(R.string.plugin_xiaoying_install_fail)).q();
        } else if (z && !d.a.c.e.p.j.z()) {
            BdToast.c(context, context.getString(R.string.neterror)).q();
        } else if (z) {
            if (d.a.c.e.p.j.H()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(context, str, i2, i3, str2)));
                return;
            }
            showStartPlayVideoDialog(context, str, i2, i3, str2);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(context, str, i2, i3, str2)));
        }
    }

    public static void startXiaoying(Context context, boolean z, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        d.a.j0.r.d0.b.j().t(MotuVideoConfig.IS_SINGLE_GOD_USER, z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MotuVideoConfig(context, z || d.a.j0.r.d0.b.j().g("localvideo_open", false), str, str2, str3)));
    }
}
