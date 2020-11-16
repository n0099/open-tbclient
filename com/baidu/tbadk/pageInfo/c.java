package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
        return es.bBt();
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

    public static ar a(Context context, ar arVar) {
        return (context == null || arVar == null) ? arVar : a(arVar, es(context));
    }

    public static ar b(Context context, ar arVar) {
        return (context == null || arVar == null) ? arVar : b(arVar, es(context));
    }

    public static ar a(ar arVar, b bVar) {
        return (bVar == null || arVar == null) ? arVar : a(arVar, bVar.getPrePageTag(), bVar.bBt());
    }

    public static ar b(ar arVar, b bVar) {
        return (bVar == null || arVar == null) ? arVar : b(arVar, bVar.getPrePageTag(), bVar.bBt());
    }

    public static ar a(ar arVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (arVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                arVar.dR("obj_tab", tbPageTag2.locatePage);
            }
            arVar.ak("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            arVar.dR(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            return arVar;
        }
        return arVar;
    }

    public static ar b(ar arVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (arVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                arVar.dR("obj_page", tbPageTag2.locatePage);
            }
            arVar.ak("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            arVar.dR("obj_tab", tbPageTag.locatePage);
            return arVar;
        }
        return arVar;
    }

    public static ar a(ar arVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || arVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            arVar.dR("obj_tab", tbPageTag.locatePage);
        }
        arVar.ak("sort_tab", tbPageTag.sortType);
        return arVar;
    }

    private static ar c(Context context, ar arVar) {
        if (context == null || arVar == null) {
            return null;
        }
        TbPageTag eu = eu(context);
        if (eu != null) {
            if (!TextUtils.isEmpty(eu.locatePage)) {
                arVar.dR("obj_tab", eu.locatePage);
            }
            arVar.ak("sort_tab", eu.sortType);
            return arVar;
        }
        return arVar;
    }

    public static ar a(Context context, bx bxVar, String str) {
        if (context == null || bxVar == null || StringUtils.isNull(str)) {
            return null;
        }
        ar arVar = new ar(str);
        arVar.dR("tid", bxVar.getId()).w("fid", bxVar.getFid()).ak(IntentConfig.CARD_TYPE, bxVar.bnD()).dR("nid", bxVar.getNid());
        if (bxVar.getBaijiahaoData() != null && !au.isEmpty(bxVar.getBaijiahaoData().oriUgcVid)) {
            arVar.dR("obj_param6", bxVar.getBaijiahaoData().oriUgcVid);
        }
        arVar.dR("weight", bxVar.mRecomWeight).dR("ab_tag", bxVar.mRecomAbTag).dR("extra", bxVar.mRecomExtra).dR("source", bxVar.mRecomSource);
        c(context, arVar);
        return arVar;
    }
}
