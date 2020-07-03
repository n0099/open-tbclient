package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class c {
    public static b dV(Context context) {
        if (context != null) {
            f<?> F = i.F(context);
            if (F instanceof a) {
                return ((a) F).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag dW(Context context) {
        b dV = dV(context);
        if (dV == null) {
            return null;
        }
        return dV.bhy();
    }

    public static TbPageTag dX(Context context) {
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

    public static ao a(Context context, ao aoVar) {
        return (context == null || aoVar == null) ? aoVar : a(aoVar, dV(context));
    }

    public static ao b(Context context, ao aoVar) {
        return (context == null || aoVar == null) ? aoVar : b(aoVar, dV(context));
    }

    public static ao a(ao aoVar, b bVar) {
        return (bVar == null || aoVar == null) ? aoVar : a(aoVar, bVar.getPrePageTag(), bVar.bhy());
    }

    public static ao b(ao aoVar, b bVar) {
        return (bVar == null || aoVar == null) ? aoVar : b(aoVar, bVar.getPrePageTag(), bVar.bhy());
    }

    public static ao a(ao aoVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (aoVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                aoVar.dk("obj_tab", tbPageTag2.locatePage);
            }
            aoVar.ag("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aoVar.dk(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            return aoVar;
        }
        return aoVar;
    }

    public static ao b(ao aoVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (aoVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                aoVar.dk("obj_page", tbPageTag2.locatePage);
            }
            aoVar.ag("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            aoVar.dk("obj_tab", tbPageTag.locatePage);
            return aoVar;
        }
        return aoVar;
    }

    public static ao a(ao aoVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || aoVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            aoVar.dk("obj_tab", tbPageTag.locatePage);
        }
        aoVar.ag("sort_tab", tbPageTag.sortType);
        return aoVar;
    }

    private static ao c(Context context, ao aoVar) {
        if (context == null || aoVar == null) {
            return null;
        }
        TbPageTag dX = dX(context);
        if (dX != null) {
            if (!TextUtils.isEmpty(dX.locatePage)) {
                aoVar.dk("obj_tab", dX.locatePage);
            }
            aoVar.ag("sort_tab", dX.sortType);
            return aoVar;
        }
        return aoVar;
    }

    public static ao a(Context context, bu buVar, String str) {
        if (context == null || buVar == null || StringUtils.isNull(str)) {
            return null;
        }
        ao aoVar = new ao(str);
        aoVar.dk("tid", buVar.getId()).s("fid", buVar.getFid()).ag(IntentConfig.CARD_TYPE, buVar.aUp()).dk("nid", buVar.getNid());
        if (buVar.getBaijiahaoData() != null && !ar.isEmpty(buVar.getBaijiahaoData().oriUgcVid)) {
            aoVar.dk("obj_param6", buVar.getBaijiahaoData().oriUgcVid);
        }
        aoVar.dk("weight", buVar.mRecomWeight).dk("ab_tag", buVar.mRecomAbTag).dk("extra", buVar.mRecomExtra).dk("source", buVar.mRecomSource);
        c(context, aoVar);
        return aoVar;
    }
}
