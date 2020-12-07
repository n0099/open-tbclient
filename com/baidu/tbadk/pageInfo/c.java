package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class c {
    public static b eY(Context context) {
        if (context != null) {
            f<?> I = i.I(context);
            if (I instanceof a) {
                return ((a) I).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag eZ(Context context) {
        b eY = eY(context);
        if (eY == null) {
            return null;
        }
        return eY.bEW();
    }

    public static TbPageTag fa(Context context) {
        f<?> I;
        if (context == null || (I = i.I(context)) == null || I.getPageContext() == null || I.getPageContext().getPageActivity() == null) {
            return null;
        }
        return J(I.getPageContext().getPageActivity().getIntent());
    }

    public static TbPageTag J(Intent intent) {
        if (intent != null) {
            return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
        return null;
    }

    public static ar a(Context context, ar arVar) {
        return (context == null || arVar == null) ? arVar : a(arVar, eY(context));
    }

    public static ar b(Context context, ar arVar) {
        return (context == null || arVar == null) ? arVar : b(arVar, eY(context));
    }

    public static ar a(ar arVar, b bVar) {
        return (bVar == null || arVar == null) ? arVar : a(arVar, bVar.getPrePageTag(), bVar.bEW());
    }

    public static ar b(ar arVar, b bVar) {
        return (bVar == null || arVar == null) ? arVar : b(arVar, bVar.getPrePageTag(), bVar.bEW());
    }

    public static ar a(ar arVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (arVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                arVar.dY("obj_tab", tbPageTag2.locatePage);
            }
            arVar.al("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            arVar.dY(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
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
                arVar.dY("obj_page", tbPageTag2.locatePage);
            }
            arVar.al("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            arVar.dY("obj_tab", tbPageTag.locatePage);
            return arVar;
        }
        return arVar;
    }

    public static ar a(ar arVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || arVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            arVar.dY("obj_tab", tbPageTag.locatePage);
        }
        arVar.al("sort_tab", tbPageTag.sortType);
        return arVar;
    }

    private static ar c(Context context, ar arVar) {
        if (context == null || arVar == null) {
            return null;
        }
        TbPageTag fa = fa(context);
        if (fa != null) {
            if (!TextUtils.isEmpty(fa.locatePage)) {
                arVar.dY("obj_tab", fa.locatePage);
            }
            arVar.al("sort_tab", fa.sortType);
            return arVar;
        }
        return arVar;
    }

    public static ar a(Context context, by byVar, String str) {
        if (context == null || byVar == null || StringUtils.isNull(str)) {
            return null;
        }
        ar arVar = new ar(str);
        arVar.dY("tid", byVar.getId()).w("fid", byVar.getFid()).al(IntentConfig.CARD_TYPE, byVar.bqQ()).dY("nid", byVar.getNid());
        if (byVar.getBaijiahaoData() != null && !au.isEmpty(byVar.getBaijiahaoData().oriUgcVid)) {
            arVar.dY("obj_param6", byVar.getBaijiahaoData().oriUgcVid);
        }
        arVar.dY("weight", byVar.mRecomWeight).dY("ab_tag", byVar.mRecomAbTag).dY("extra", byVar.mRecomExtra).dY("obj_type", byVar.eMG ? "2" : "1").dY("source", byVar.mRecomSource);
        c(context, arVar);
        return arVar;
    }
}
