package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class c {
    public static b dU(Context context) {
        if (context != null) {
            f<?> F = i.F(context);
            if (F instanceof a) {
                return ((a) F).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag dV(Context context) {
        b dU = dU(context);
        if (dU == null) {
            return null;
        }
        return dU.bfs();
    }

    public static TbPageTag dW(Context context) {
        f<?> F;
        if (context == null || (F = i.F(context)) == null || F.getPageContext() == null || F.getPageContext().getPageActivity() == null) {
            return null;
        }
        return H(F.getPageContext().getPageActivity().getIntent());
    }

    public static TbPageTag H(Intent intent) {
        if (intent != null) {
            return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
        return null;
    }

    public static an a(Context context, an anVar) {
        return (context == null || anVar == null) ? anVar : a(anVar, dU(context));
    }

    public static an b(Context context, an anVar) {
        return (context == null || anVar == null) ? anVar : b(anVar, dU(context));
    }

    public static an a(an anVar, b bVar) {
        return (bVar == null || anVar == null) ? anVar : a(anVar, bVar.getPrePageTag(), bVar.bfs());
    }

    public static an b(an anVar, b bVar) {
        return (bVar == null || anVar == null) ? anVar : b(anVar, bVar.getPrePageTag(), bVar.bfs());
    }

    public static an a(an anVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (anVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                anVar.dh("obj_tab", tbPageTag2.locatePage);
            }
            anVar.ag("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            anVar.dh(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            return anVar;
        }
        return anVar;
    }

    public static an b(an anVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (anVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                anVar.dh("obj_page", tbPageTag2.locatePage);
            }
            anVar.ag("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            anVar.dh("obj_tab", tbPageTag.locatePage);
            return anVar;
        }
        return anVar;
    }

    public static an a(an anVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || anVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            anVar.dh("obj_tab", tbPageTag.locatePage);
        }
        anVar.ag("sort_tab", tbPageTag.sortType);
        return anVar;
    }

    private static an c(Context context, an anVar) {
        if (context == null || anVar == null) {
            return null;
        }
        TbPageTag dW = dW(context);
        if (dW != null) {
            if (!TextUtils.isEmpty(dW.locatePage)) {
                anVar.dh("obj_tab", dW.locatePage);
            }
            anVar.ag("sort_tab", dW.sortType);
            return anVar;
        }
        return anVar;
    }

    public static an a(Context context, bk bkVar, String str) {
        if (context == null || bkVar == null || StringUtils.isNull(str)) {
            return null;
        }
        an anVar = new an(str);
        anVar.dh("tid", bkVar.getId()).s("fid", bkVar.getFid()).ag(IntentConfig.CARD_TYPE, bkVar.aSA()).dh("nid", bkVar.getNid());
        if (bkVar.getBaijiahaoData() != null && !aq.isEmpty(bkVar.getBaijiahaoData().oriUgcVid)) {
            anVar.dh("obj_param6", bkVar.getBaijiahaoData().oriUgcVid);
        }
        anVar.dh("weight", bkVar.mRecomWeight).dh("ab_tag", bkVar.mRecomAbTag).dh("extra", bkVar.mRecomExtra).dh("source", bkVar.mRecomSource);
        c(context, anVar);
        return anVar;
    }
}
