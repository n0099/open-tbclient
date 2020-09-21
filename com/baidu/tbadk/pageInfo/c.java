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
    public static b el(Context context) {
        if (context != null) {
            f<?> H = i.H(context);
            if (H instanceof a) {
                return ((a) H).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag em(Context context) {
        b el = el(context);
        if (el == null) {
            return null;
        }
        return el.bvb();
    }

    public static TbPageTag en(Context context) {
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
        return (context == null || aqVar == null) ? aqVar : a(aqVar, el(context));
    }

    public static aq b(Context context, aq aqVar) {
        return (context == null || aqVar == null) ? aqVar : b(aqVar, el(context));
    }

    public static aq a(aq aqVar, b bVar) {
        return (bVar == null || aqVar == null) ? aqVar : a(aqVar, bVar.getPrePageTag(), bVar.bvb());
    }

    public static aq b(aq aqVar, b bVar) {
        return (bVar == null || aqVar == null) ? aqVar : b(aqVar, bVar.getPrePageTag(), bVar.bvb());
    }

    public static aq a(aq aqVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (aqVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                aqVar.dF("obj_tab", tbPageTag2.locatePage);
            }
            aqVar.ai("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dF(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
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
                aqVar.dF("obj_page", tbPageTag2.locatePage);
            }
            aqVar.ai("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dF("obj_tab", tbPageTag.locatePage);
            return aqVar;
        }
        return aqVar;
    }

    public static aq a(aq aqVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || aqVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dF("obj_tab", tbPageTag.locatePage);
        }
        aqVar.ai("sort_tab", tbPageTag.sortType);
        return aqVar;
    }

    private static aq c(Context context, aq aqVar) {
        if (context == null || aqVar == null) {
            return null;
        }
        TbPageTag en = en(context);
        if (en != null) {
            if (!TextUtils.isEmpty(en.locatePage)) {
                aqVar.dF("obj_tab", en.locatePage);
            }
            aqVar.ai("sort_tab", en.sortType);
            return aqVar;
        }
        return aqVar;
    }

    public static aq a(Context context, bw bwVar, String str) {
        if (context == null || bwVar == null || StringUtils.isNull(str)) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dF("tid", bwVar.getId()).u("fid", bwVar.getFid()).ai(IntentConfig.CARD_TYPE, bwVar.bhx()).dF("nid", bwVar.getNid());
        if (bwVar.getBaijiahaoData() != null && !at.isEmpty(bwVar.getBaijiahaoData().oriUgcVid)) {
            aqVar.dF("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
        }
        aqVar.dF("weight", bwVar.mRecomWeight).dF("ab_tag", bwVar.mRecomAbTag).dF("extra", bwVar.mRecomExtra).dF("source", bwVar.mRecomSource);
        c(context, aqVar);
        return aqVar;
    }
}
