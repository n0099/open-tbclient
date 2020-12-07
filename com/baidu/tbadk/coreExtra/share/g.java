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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
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
    private c fod;
    private d foe;
    private b foh;
    private final Context mContext;
    private String fof = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
    private String fog = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.fof;
    private b.a foi = new b.a() { // from class: com.baidu.tbadk.coreExtra.share.g.1
        @Override // com.baidu.tbadk.coreExtra.share.b.a
        public void d(ShareItem shareItem) {
            g.this.foe.a(g.this.a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
        }
    };

    public g(Context context, c cVar) {
        e eVar;
        this.fod = null;
        this.foe = null;
        this.mContext = context;
        this.fod = cVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, e.class);
        if (runTask.getData() != null && (eVar = (e) runTask.getData()) != null) {
            this.foe = eVar.a(this.mContext, this.fod);
        }
    }

    public static boolean eM(Context context) {
        return bAq();
    }

    public static boolean bAq() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String ec(String str, String str2) {
        return ao(str, "copy", str2);
    }

    public void e(ShareItem shareItem) {
        if (this.foe != null && shareItem != null) {
            if (StringUtils.isNull(shareItem.tid)) {
                shareItem.content = b(shareItem.content, 80, 20, shareItem.fnQ ? this.fof : "");
            }
            if (shareItem.canShareBySmartApp && !au.isEmpty(shareItem.fnT)) {
                shareItem.imageUri = Uri.parse(shareItem.fnT);
                this.foe.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            } else if (shareItem.canShareBySmartApp && au.isEmpty(shareItem.fnT) && !au.isEmpty(shareItem.tid) && !"0".equals(shareItem.tid)) {
                if (this.foh == null) {
                    this.foh = new b();
                    this.foh.a(this.foi);
                }
                this.foh.b(shareItem);
            } else {
                if (shareItem.typeShareToSmallApp == 4) {
                    if (this.foh == null) {
                        this.foh = new b();
                    }
                    this.foh.b(shareItem);
                }
                this.foe.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            }
        }
    }

    public void f(ShareItem shareItem) {
        if (this.foe != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 20, shareItem.fnQ ? this.fof : "");
            this.foe.a(a(shareItem, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE), 2, false);
        }
    }

    public void g(ShareItem shareItem) {
        if (this.foe != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.fnQ ? this.fof : "");
            this.foe.a(a(shareItem, LogConfig.LIVE_SHARE_QQ_FRIEND), 8, true);
        }
    }

    public void h(ShareItem shareItem) {
        if (this.foe != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.fnQ ? this.fof : "");
            this.foe.a(a(shareItem, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void i(ShareItem shareItem) {
        if (this.foe != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.fnQ ? this.fof : "");
            this.foe.a(a(shareItem, "tencent_weibo"), 5, true);
        }
    }

    public void j(ShareItem shareItem) {
        if (this.foe != null) {
            if (!a.E(TbadkApplication.getInst().getApplicationContext(), 6)) {
                BdToast.b(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.share_sina_weibo_not_install)).brB();
                return;
            }
            shareItem.content = b(shareItem.content, 140, 20, shareItem.fnQ ? this.fog : "");
            this.foe.a(a(shareItem, "sina_weibo"), 6, true);
        }
    }

    public void k(ShareItem shareItem) {
        if (this.foe != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.fnQ ? this.fof : "");
            this.foe.a(a(shareItem, "renren"), 7, true);
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
        if ((shareItem.imageUri == null || shareItem.imageUri.equals("")) && shareItem.bAk() == null) {
            String str2 = "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg";
            if (str.startsWith(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                str2 = "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg";
            }
            shareItem.imageUri = Uri.parse(str2);
        }
        if (shareItem.imageUri != null && !shareItem.imageUri.equals("")) {
            String uri = shareItem.imageUri.toString();
            if (!Di(uri) && !Dj(uri)) {
                shareItem.imageUri = Uri.parse("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
            } else {
                shareItem.imageUri = Uri.parse(uri);
                ed(uri, "sfc=" + str);
            }
        }
        if (shareItem.fnR) {
            shareItem.linkUrl = ao(shareItem.linkUrl, str, shareItem.tid);
            return shareItem;
        }
        return shareItem;
    }

    protected boolean Di(String str) {
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

    private static String ao(String str, String str2, String str3) {
        String md5;
        if (au.isEmpty(str)) {
            str = "http://tieba.baidu.com/";
        }
        String ed = ed(ed(ed(ed(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                md5 = s.toMd5(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                md5 = s.toMd5(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return ed(ed, "unique=" + md5);
        }
        return ed;
    }

    private static String ed(String str, String str2) {
        String str3 = ETAG.ITEM_SEPARATOR;
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean Dj(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bf.bua().UrlValidated(str)) {
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
