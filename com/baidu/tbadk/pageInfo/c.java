package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class c {
    public static b es(Context context) {
        if (context != null) {
            f<?> H = i.H(context);
            if (H instanceof a) {
                return ((a) H).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag et(Context context) {
        b es = es(context);
        if (es == null) {
            return null;
        }
        return es.bxL();
    }

    public static TbPageTag eu(Context context) {
        f<?> H;
        if (context == null || (H = i.H(context)) == null || H.getPageContext() == null || H.getPageContext().getPageActivity() == null) {
            return null;
        }
        return J(H.getPageContext().getPageActivity().getIntent());
    }

    public static TbPageTag J(Intent intent) {
        if (intent != null) {
            return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
        return null;
    }

    public static aq a(Context context, aq aqVar) {
        return (context == null || aqVar == null) ? aqVar : a(aqVar, es(context));
    }

    public static aq b(Context context, aq aqVar) {
        return (context == null || aqVar == null) ? aqVar : b(aqVar, es(context));
    }

    public static aq a(aq aqVar, b bVar) {
        return (bVar == null || aqVar == null) ? aqVar : a(aqVar, bVar.getPrePageTag(), bVar.bxL());
    }

    public static aq b(aq aqVar, b bVar) {
        return (bVar == null || aqVar == null) ? aqVar : b(aqVar, bVar.getPrePageTag(), bVar.bxL());
    }

    public static aq a(aq aqVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (aqVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                aqVar.dK("obj_tab", tbPageTag2.locatePage);
            }
            aqVar.aj("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dK(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
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
                aqVar.dK("obj_page", tbPageTag2.locatePage);
            }
            aqVar.aj("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dK("obj_tab", tbPageTag.locatePage);
            return aqVar;
        }
        return aqVar;
    }

    public static aq a(aq aqVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || aqVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dK("obj_tab", tbPageTag.locatePage);
        }
        aqVar.aj("sort_tab", tbPageTag.sortType);
        return aqVar;
    }

    private static aq c(Context context, aq aqVar) {
        if (context == null || aqVar == null) {
            return null;
        }
        TbPageTag eu = eu(context);
        if (eu != null) {
            if (!TextUtils.isEmpty(eu.locatePage)) {
                aqVar.dK("obj_tab", eu.locatePage);
            }
            aqVar.aj("sort_tab", eu.sortType);
            return aqVar;
        }
        return aqVar;
    }

    public static aq a(Context context, bw bwVar, String str) {
        if (context == null || bwVar == null || StringUtils.isNull(str)) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dK("tid", bwVar.getId()).u("fid", bwVar.getFid()).aj(IntentConfig.CARD_TYPE, bwVar.bkg()).dK("nid", bwVar.getNid());
        if (bwVar.getBaijiahaoData() != null && !at.isEmpty(bwVar.getBaijiahaoData().oriUgcVid)) {
            aqVar.dK("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
        }
        aqVar.dK("weight", bwVar.mRecomWeight).dK("ab_tag", bwVar.mRecomAbTag).dK("extra", bwVar.mRecomExtra).dK("source", bwVar.mRecomSource);
        c(context, aqVar);
        return aqVar;
    }
}
