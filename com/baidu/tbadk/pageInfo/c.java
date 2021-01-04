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
    public static b fu(Context context) {
        if (context != null) {
            g<?> J = j.J(context);
            if (J instanceof a) {
                return ((a) J).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag fv(Context context) {
        b fu = fu(context);
        if (fu == null) {
            return null;
        }
        return fu.bHp();
    }

    public static TbPageTag fw(Context context) {
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
        return (context == null || aqVar == null) ? aqVar : a(aqVar, fu(context));
    }

    public static aq b(Context context, aq aqVar) {
        return (context == null || aqVar == null) ? aqVar : b(aqVar, fu(context));
    }

    public static aq a(aq aqVar, b bVar) {
        return (bVar == null || aqVar == null) ? aqVar : a(aqVar, bVar.getPrePageTag(), bVar.bHp());
    }

    public static aq b(aq aqVar, b bVar) {
        return (bVar == null || aqVar == null) ? aqVar : b(aqVar, bVar.getPrePageTag(), bVar.bHp());
    }

    public static aq a(aq aqVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (aqVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                aqVar.dX("obj_tab", tbPageTag2.locatePage);
            }
            aqVar.an("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dX(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
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
                aqVar.dX("obj_page", tbPageTag2.locatePage);
            }
            aqVar.an("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dX("obj_tab", tbPageTag.locatePage);
            return aqVar;
        }
        return aqVar;
    }

    public static aq a(aq aqVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || aqVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            aqVar.dX("obj_tab", tbPageTag.locatePage);
        }
        aqVar.an("sort_tab", tbPageTag.sortType);
        return aqVar;
    }

    private static aq c(Context context, aq aqVar) {
        if (context == null || aqVar == null) {
            return null;
        }
        TbPageTag fw = fw(context);
        if (fw != null) {
            if (!TextUtils.isEmpty(fw.locatePage)) {
                aqVar.dX("obj_tab", fw.locatePage);
            }
            aqVar.an("sort_tab", fw.sortType);
            return aqVar;
        }
        return aqVar;
    }

    public static aq a(Context context, bz bzVar, String str) {
        if (context == null || bzVar == null || StringUtils.isNull(str)) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dX("tid", bzVar.getId()).w("fid", bzVar.getFid()).an(IntentConfig.CARD_TYPE, bzVar.bts()).dX(IntentConfig.NID, bzVar.bpO());
        if (bzVar.getBaijiahaoData() != null && !at.isEmpty(bzVar.getBaijiahaoData().oriUgcVid)) {
            aqVar.dX("obj_param6", bzVar.getBaijiahaoData().oriUgcVid);
        }
        aqVar.dX("weight", bzVar.mRecomWeight).dX("ab_tag", bzVar.mRecomAbTag).dX("extra", bzVar.mRecomExtra).dX("obj_type", bzVar.eWD ? "2" : "1").dX("source", bzVar.mRecomSource);
        c(context, aqVar);
        return aqVar;
    }
}
