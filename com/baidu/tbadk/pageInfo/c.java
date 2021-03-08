package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.g;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class c {
    public static b fq(Context context) {
        if (context != null) {
            g<?> I = j.I(context);
            if (I instanceof a) {
                return ((a) I).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag fr(Context context) {
        b fq = fq(context);
        if (fq == null) {
            return null;
        }
        return fq.bDS();
    }

    public static TbPageTag fs(Context context) {
        g<?> I;
        if (context == null || (I = j.I(context)) == null || I.getPageContext() == null || I.getPageContext().getPageActivity() == null) {
            return null;
        }
        return K(I.getPageContext().getPageActivity().getIntent());
    }

    public static TbPageTag K(Intent intent) {
        if (intent != null) {
            return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
        return null;
    }

    public static ar a(Context context, ar arVar) {
        return (context == null || arVar == null) ? arVar : a(arVar, fq(context));
    }

    public static ar b(Context context, ar arVar) {
        return (context == null || arVar == null) ? arVar : b(arVar, fq(context));
    }

    public static ar a(ar arVar, b bVar) {
        return (bVar == null || arVar == null) ? arVar : a(arVar, bVar.getPrePageTag(), bVar.bDS());
    }

    public static ar b(ar arVar, b bVar) {
        return (bVar == null || arVar == null) ? arVar : b(arVar, bVar.getPrePageTag(), bVar.bDS());
    }

    public static ar a(ar arVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (arVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                arVar.dR("obj_tab", tbPageTag2.locatePage);
            }
            arVar.aq("sort_tab", tbPageTag2.sortType);
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
            arVar.aq("sort_tab", tbPageTag2.sortType);
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
        arVar.aq("sort_tab", tbPageTag.sortType);
        return arVar;
    }

    private static ar c(Context context, ar arVar) {
        if (context == null || arVar == null) {
            return null;
        }
        TbPageTag fs = fs(context);
        if (fs != null) {
            if (!TextUtils.isEmpty(fs.locatePage)) {
                arVar.dR("obj_tab", fs.locatePage);
            }
            arVar.aq("sort_tab", fs.sortType);
            return arVar;
        }
        return arVar;
    }

    public static ar a(Context context, cb cbVar, String str) {
        if (context == null || cbVar == null || StringUtils.isNull(str)) {
            return null;
        }
        ar arVar = new ar(str);
        arVar.dR("tid", cbVar.getId()).v("fid", cbVar.getFid()).aq(IntentConfig.CARD_TYPE, cbVar.bpT()).dR(IntentConfig.NID, cbVar.bmq());
        if (cbVar.getBaijiahaoData() != null && !au.isEmpty(cbVar.getBaijiahaoData().oriUgcVid)) {
            arVar.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
        }
        arVar.dR("weight", cbVar.mRecomWeight).dR("ab_tag", cbVar.mRecomAbTag).dR("extra", cbVar.mRecomExtra).dR("obj_type", cbVar.eVF ? "2" : "1").dR("source", cbVar.mRecomSource);
        c(context, arVar);
        return arVar;
    }
}
