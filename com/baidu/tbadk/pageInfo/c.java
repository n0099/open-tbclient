package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.g;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class c {
    public static b fs(Context context) {
        if (context != null) {
            g<?> J = j.J(context);
            if (J instanceof a) {
                return ((a) J).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag ft(Context context) {
        b fs = fs(context);
        if (fs == null) {
            return null;
        }
        return fs.bDx();
    }

    public static TbPageTag fu(Context context) {
        g<?> J;
        if (context == null || (J = j.J(context)) == null || J.getPageContext() == null || J.getPageContext().getPageActivity() == null) {
            return null;
        }
        return K(J.getPageContext().getPageActivity().getIntent());
    }

    public static TbPageTag K(Intent intent) {
        if (intent != null) {
            return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
        return null;
    }

    public static aq a(Context context, aq aqVar) {
        return (context == null || aqVar == null) ? aqVar : a(aqVar, fs(context));
    }

    public static aq b(Context context, aq aqVar) {
        return (context == null || aqVar == null) ? aqVar : b(aqVar, fs(context));
    }

    public static aq a(aq aqVar, b bVar) {
        return (bVar == null || aqVar == null) ? aqVar : a(aqVar, bVar.getPrePageTag(), bVar.bDx());
    }

    public static aq b(aq aqVar, b bVar) {
        return (bVar == null || aqVar == null) ? aqVar : b(aqVar, bVar.getPrePageTag(), bVar.bDx());
    }

    public static aq a(aq aqVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (aqVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                aqVar.dW("obj_tab", tbPageTag2.locatePage);
            }
            aqVar.an("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dW(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            return aqVar;
        }
        return aqVar;
    }

    public static aq b(aq aqVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (aqVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                aqVar.dW("obj_page", tbPageTag2.locatePage);
            }
            aqVar.an("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dW("obj_tab", tbPageTag.locatePage);
            return aqVar;
        }
        return aqVar;
    }

    public static aq a(aq aqVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || aqVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dW("obj_tab", tbPageTag.locatePage);
        }
        aqVar.an("sort_tab", tbPageTag.sortType);
        return aqVar;
    }

    private static aq c(Context context, aq aqVar) {
        if (context == null || aqVar == null) {
            return null;
        }
        TbPageTag fu = fu(context);
        if (fu != null) {
            if (!TextUtils.isEmpty(fu.locatePage)) {
                aqVar.dW("obj_tab", fu.locatePage);
            }
            aqVar.an("sort_tab", fu.sortType);
            return aqVar;
        }
        return aqVar;
    }

    public static aq a(Context context, bz bzVar, String str) {
        if (context == null || bzVar == null || StringUtils.isNull(str)) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dW("tid", bzVar.getId()).w("fid", bzVar.getFid()).an(IntentConfig.CARD_TYPE, bzVar.bpz()).dW(IntentConfig.NID, bzVar.blV());
        if (bzVar.getBaijiahaoData() != null && !at.isEmpty(bzVar.getBaijiahaoData().oriUgcVid)) {
            aqVar.dW("obj_param6", bzVar.getBaijiahaoData().oriUgcVid);
        }
        aqVar.dW("weight", bzVar.mRecomWeight).dW("ab_tag", bzVar.mRecomAbTag).dW("extra", bzVar.mRecomExtra).dW("obj_type", bzVar.eRS ? "2" : "1").dW("source", bzVar.mRecomSource);
        c(context, aqVar);
        return aqVar;
    }
}
