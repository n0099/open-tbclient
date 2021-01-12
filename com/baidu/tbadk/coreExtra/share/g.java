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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.share.b;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class g {
    private c fte;
    private d ftf;
    private b fti;
    private final Context mContext;
    private String ftg = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
    private String fth = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.ftg;
    private b.a ftj = new b.a() { // from class: com.baidu.tbadk.coreExtra.share.g.1
        @Override // com.baidu.tbadk.coreExtra.share.b.a
        public void d(ShareItem shareItem) {
            g.this.ftf.a(g.this.a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
        }
    };

    public g(Context context, c cVar) {
        e eVar;
        this.fte = null;
        this.ftf = null;
        this.mContext = context;
        this.fte = cVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, e.class);
        if (runTask.getData() != null && (eVar = (e) runTask.getData()) != null) {
            this.ftf = eVar.a(this.mContext, this.fte);
        }
    }

    public static boolean fg(Context context) {
        return byR();
    }

    public static boolean byR() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String ea(String str, String str2) {
        return aq(str, "copy", str2);
    }

    public void e(ShareItem shareItem) {
        if (this.ftf != null && shareItem != null) {
            if (StringUtils.isNull(shareItem.tid)) {
                shareItem.content = b(shareItem.content, 80, 20, shareItem.fsR ? this.ftg : "");
            }
            if (shareItem.canShareBySmartApp && !at.isEmpty(shareItem.fsU)) {
                shareItem.imageUri = Uri.parse(shareItem.fsU);
                this.ftf.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            } else if (shareItem.canShareBySmartApp && at.isEmpty(shareItem.fsU) && !at.isEmpty(shareItem.tid) && !"0".equals(shareItem.tid)) {
                if (this.fti == null) {
                    this.fti = new b();
                    this.fti.a(this.ftj);
                }
                this.fti.b(shareItem);
            } else {
                if (shareItem.typeShareToSmallApp == 4) {
                    if (this.fti == null) {
                        this.fti = new b();
                    }
                    this.fti.b(shareItem);
                }
                this.ftf.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            }
        }
    }

    public void f(ShareItem shareItem) {
        if (this.ftf != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 20, shareItem.fsR ? this.ftg : "");
            this.ftf.a(a(shareItem, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE), 2, false);
        }
    }

    public void g(ShareItem shareItem) {
        if (this.ftf != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.fsR ? this.ftg : "");
            this.ftf.a(a(shareItem, LogConfig.LIVE_SHARE_QQ_FRIEND), 8, true);
        }
    }

    public void h(ShareItem shareItem) {
        if (this.ftf != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.fsR ? this.ftg : "");
            this.ftf.a(a(shareItem, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void i(ShareItem shareItem) {
        if (this.ftf != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.fsR ? this.ftg : "");
            this.ftf.a(a(shareItem, "tencent_weibo"), 5, true);
        }
    }

    public void j(ShareItem shareItem) {
        if (this.ftf != null) {
            if (!a.F(TbadkApplication.getInst().getApplicationContext(), 6)) {
                BdToast.b(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.share_sina_weibo_not_install)).bqk();
                return;
            }
            shareItem.content = b(shareItem.content, 140, 20, shareItem.fsR ? this.fth : "");
            this.ftf.a(a(shareItem, "sina_weibo"), 6, true);
        }
    }

    public void k(ShareItem shareItem) {
        if (this.ftf != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.fsR ? this.ftg : "");
            this.ftf.a(a(shareItem, "renren"), 7, true);
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
        if ((shareItem.imageUri == null || shareItem.imageUri.equals("")) && shareItem.byL() == null) {
            String str2 = "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg";
            if (str.startsWith(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                str2 = "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg";
            }
            shareItem.imageUri = Uri.parse(str2);
        }
        if (shareItem.imageUri != null && !shareItem.imageUri.equals("")) {
            String uri = shareItem.imageUri.toString();
            if (!BU(uri) && !BV(uri)) {
                shareItem.imageUri = Uri.parse("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
            } else {
                shareItem.imageUri = Uri.parse(uri);
                eb(uri, "sfc=" + str);
            }
        }
        if (shareItem.fsS) {
            shareItem.linkUrl = aq(shareItem.linkUrl, str, shareItem.tid);
            return shareItem;
        }
        return shareItem;
    }

    protected boolean BU(String str) {
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

    private static String aq(String str, String str2, String str3) {
        String md5;
        if (at.isEmpty(str)) {
            str = "http://tieba.baidu.com/";
        }
        String eb = eb(eb(eb(eb(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                md5 = s.toMd5(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                md5 = s.toMd5(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return eb(eb, "unique=" + md5);
        }
        return eb;
    }

    private static String eb(String str, String str2) {
        String str3 = ETAG.ITEM_SEPARATOR;
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean BV(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (be.bsB().UrlValidated(str)) {
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
