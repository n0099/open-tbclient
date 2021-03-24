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
import d.b.b.a.f;
import d.b.b.a.j;
import d.b.h0.r.s.a;
/* loaded from: classes3.dex */
public class XiaoyingUtil {
    public static final String PKG_NAME_VIDEO = "cn.jingling.motu.photowonder.plugin.mv";
    public static int showTime;

    /* loaded from: classes3.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f14001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f14002f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f14003g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f14004h;
        public final /* synthetic */ String i;

        public a(Context context, String str, int i, int i2, String str2) {
            this.f14001e = context;
            this.f14002f = str;
            this.f14003g = i;
            this.f14004h = i2;
            this.i = str2;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(this.f14001e, this.f14002f, this.f14003g, this.f14004h, this.i)));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {
        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f14005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f14006f;

        public c(Activity activity, TbPageContext tbPageContext) {
            this.f14005e = activity;
            this.f14006f = tbPageContext;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f14006f.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(this.f14005e, XiaoyingUtil.PKG_NAME_VIDEO)));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {
        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
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

    public static void setShowTime(int i) {
        showTime = i;
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(pageActivity);
        aVar.setMessage(str);
        aVar.setPositiveButton(str2, new c(pageActivity, tbPageContext));
        aVar.setNegativeButton(R.string.cancel, new d());
        aVar.create(tbPageContext).show();
    }

    public static void showStartPlayVideoDialog(Context context, String str, int i, int i2, String str2) {
        f<?> a2 = j.a(context);
        if (a2 == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(a2.getPageActivity());
        aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
        aVar.setPositiveButton(R.string.confirm, new a(context, str, i, i2, str2));
        aVar.setNegativeButton(R.string.cancel, new b());
        aVar.create(a2).show();
    }

    public static boolean showXiaoyingTool() {
        PluginNetConfigInfos.PluginConfig R;
        return (!TbadkCoreApplication.getInst().isXiaoyingAvaliable() || Build.VERSION.SDK_INT < 14 || (R = PluginPackageManager.O().R(PKG_NAME_VIDEO)) == null || TextUtils.isEmpty(R.display_name) || R.forbidden == 1 || d.b.b.h.j.g.d.k().h(PKG_NAME_VIDEO) == null) ? false : true;
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i, int i2, String str2) {
        startPlayXiaoyingVideo(context, str, i, i2, str2, true);
    }

    public static void startXiaoying(Context context) {
        if (context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MotuVideoConfig(context)));
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i, int i2, String str2, boolean z) {
        if (context == null || StringUtils.isNull(str)) {
            return;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(XiaoyingPlayerConfig.class)) {
            BdToast.c(context, context.getString(R.string.plugin_xiaoying_install_fail)).q();
        } else if (z && !d.b.b.e.p.j.z()) {
            BdToast.c(context, context.getString(R.string.neterror)).q();
        } else if (z) {
            if (d.b.b.e.p.j.H()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(context, str, i, i2, str2)));
                return;
            }
            showStartPlayVideoDialog(context, str, i, i2, str2);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(context, str, i, i2, str2)));
        }
    }

    public static void startXiaoying(Context context, boolean z, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        d.b.h0.r.d0.b.i().s(MotuVideoConfig.IS_SINGLE_GOD_USER, z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MotuVideoConfig(context, z || d.b.h0.r.d0.b.i().g("localvideo_open", false), str, str2, str3)));
    }
}
