package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.share.a;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class f {
    private b efq;
    private c efr;
    private a efu;
    private final Context mContext;
    private String efs = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
    private String eft = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.efs;
    private a.InterfaceC0485a efv = new a.InterfaceC0485a() { // from class: com.baidu.tbadk.coreExtra.share.f.1
        @Override // com.baidu.tbadk.coreExtra.share.a.InterfaceC0485a
        public void d(ShareItem shareItem) {
            f.this.efr.a(f.this.a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
        }
    };

    public f(Context context, b bVar) {
        d dVar;
        this.efq = null;
        this.efr = null;
        this.mContext = context;
        this.efq = bVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, d.class);
        if (runTask.getData() != null && (dVar = (d) runTask.getData()) != null) {
            this.efr = dVar.a(this.mContext, this.efq);
        }
    }

    public static boolean dM(Context context) {
        return bbi();
    }

    public static boolean bbi() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String dn(String str, String str2) {
        return ac(str, "copy", str2);
    }

    public void e(ShareItem shareItem) {
        if (this.efr != null && shareItem != null) {
            if (StringUtils.isNull(shareItem.tid)) {
                shareItem.content = b(shareItem.content, 80, 20, shareItem.efh ? this.efs : "");
            }
            if (shareItem.canShareBySmartApp && !aq.isEmpty(shareItem.efk)) {
                shareItem.imageUri = Uri.parse(shareItem.efk);
                this.efr.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            } else if (shareItem.canShareBySmartApp && aq.isEmpty(shareItem.efk) && !aq.isEmpty(shareItem.tid) && !"0".equals(shareItem.tid)) {
                if (this.efu == null) {
                    this.efu = new a();
                    this.efu.a(this.efv);
                }
                this.efu.b(shareItem);
            } else {
                if (shareItem.typeShareToSmallApp == 4) {
                    if (this.efu == null) {
                        this.efu = new a();
                    }
                    this.efu.b(shareItem);
                }
                this.efr.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            }
        }
    }

    public void f(ShareItem shareItem) {
        if (this.efr != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 20, shareItem.efh ? this.efs : "");
            this.efr.a(a(shareItem, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE), 2, false);
        }
    }

    public void g(ShareItem shareItem) {
        if (this.efr != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.efh ? this.efs : "");
            this.efr.a(a(shareItem, LogConfig.LIVE_SHARE_QQ_FRIEND), 8, true);
        }
    }

    public void h(ShareItem shareItem) {
        if (this.efr != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.efh ? this.efs : "");
            this.efr.a(a(shareItem, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void i(ShareItem shareItem) {
        if (this.efr != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.efh ? this.efs : "");
            this.efr.a(a(shareItem, "tencent_weibo"), 5, true);
        }
    }

    public void j(ShareItem shareItem) {
        if (this.efr != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.efh ? this.eft : "");
            this.efr.a(a(shareItem, "sina_weibo"), 6, true);
        }
    }

    public void k(ShareItem shareItem) {
        if (this.efr != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.efh ? this.efs : "");
            this.efr.a(a(shareItem, "renren"), 7, true);
        }
    }

    private String b(String str, int i, int i2, String str2) {
        if (str != null) {
            int min = Math.min((i - str2.length()) - i2, str.length());
            if (min < str.length()) {
                return str.substring(0, min - 1) + (StringHelper.STRING_MORE + str2);
            }
            return str + str2;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem a(ShareItem shareItem, String str) {
        if (shareItem == null) {
            return null;
        }
        if ((shareItem.imageUri == null || shareItem.imageUri.equals("")) && shareItem.bbd() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            shareItem.imageUri = Uri.parse(str2);
        }
        if (shareItem.imageUri != null && !shareItem.imageUri.equals("")) {
            String uri = shareItem.imageUri.toString();
            if (!xw(uri) && !xx(uri)) {
                shareItem.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                shareItem.imageUri = Uri.parse(uri);
                m30do(uri, "sfc=" + str);
            }
        }
        if (shareItem.efi) {
            shareItem.linkUrl = ac(shareItem.linkUrl, str, shareItem.tid);
            return shareItem;
        }
        return shareItem;
    }

    protected boolean xw(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("file://")) {
            try {
                File file = new File(new URI(str));
                return file.isFile() && file.exists();
            } catch (URISyntaxException e) {
                return false;
            }
        }
        return false;
    }

    private static String ac(String str, String str2, String str3) {
        String md5;
        if (aq.isEmpty(str)) {
            str = "http://tieba.baidu.com/";
        }
        String m30do = m30do(m30do(m30do(m30do(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                md5 = s.toMd5(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                md5 = s.toMd5(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return m30do(m30do, "unique=" + md5);
        }
        return m30do;
    }

    /* renamed from: do  reason: not valid java name */
    private static String m30do(String str, String str2) {
        String str3 = ETAG.ITEM_SEPARATOR;
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean xx(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (ba.aVa().UrlValidated(str)) {
            if (split == null || split.length <= 0) {
                return true;
            }
            for (String str2 : split) {
                if (str2 != null && !str2.equals("") && (str.contains(str2) || str.contains(str2.toUpperCase()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
