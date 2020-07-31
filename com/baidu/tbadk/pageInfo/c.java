package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class c {
    public static b ea(Context context) {
        if (context != null) {
            f<?> F = i.F(context);
            if (F instanceof a) {
                return ((a) F).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag eb(Context context) {
        b ea = ea(context);
        if (ea == null) {
            return null;
        }
        return ea.blj();
    }

    public static TbPageTag ec(Context context) {
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

    public static ap a(Context context, ap apVar) {
        return (context == null || apVar == null) ? apVar : a(apVar, ea(context));
    }

    public static ap b(Context context, ap apVar) {
        return (context == null || apVar == null) ? apVar : b(apVar, ea(context));
    }

    public static ap a(ap apVar, b bVar) {
        return (bVar == null || apVar == null) ? apVar : a(apVar, bVar.getPrePageTag(), bVar.blj());
    }

    public static ap b(ap apVar, b bVar) {
        return (bVar == null || apVar == null) ? apVar : b(apVar, bVar.getPrePageTag(), bVar.blj());
    }

    public static ap a(ap apVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (apVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                apVar.dn("obj_tab", tbPageTag2.locatePage);
            }
            apVar.ah("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            apVar.dn(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            return apVar;
        }
        return apVar;
    }

    public static ap b(ap apVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (apVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                apVar.dn("obj_page", tbPageTag2.locatePage);
            }
            apVar.ah("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            apVar.dn("obj_tab", tbPageTag.locatePage);
            return apVar;
        }
        return apVar;
    }

    public static ap a(ap apVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || apVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            apVar.dn("obj_tab", tbPageTag.locatePage);
        }
        apVar.ah("sort_tab", tbPageTag.sortType);
        return apVar;
    }

    private static ap c(Context context, ap apVar) {
        if (context == null || apVar == null) {
            return null;
        }
        TbPageTag ec = ec(context);
        if (ec != null) {
            if (!TextUtils.isEmpty(ec.locatePage)) {
                apVar.dn("obj_tab", ec.locatePage);
            }
            apVar.ah("sort_tab", ec.sortType);
            return apVar;
        }
        return apVar;
    }

    public static ap a(Context context, bv bvVar, String str) {
        if (context == null || bvVar == null || StringUtils.isNull(str)) {
            return null;
        }
        ap apVar = new ap(str);
        apVar.dn("tid", bvVar.getId()).t("fid", bvVar.getFid()).ah(IntentConfig.CARD_TYPE, bvVar.aYk()).dn("nid", bvVar.getNid());
        if (bvVar.getBaijiahaoData() != null && !as.isEmpty(bvVar.getBaijiahaoData().oriUgcVid)) {
            apVar.dn("obj_param6", bvVar.getBaijiahaoData().oriUgcVid);
        }
        apVar.dn("weight", bvVar.mRecomWeight).dn("ab_tag", bvVar.mRecomAbTag).dn("extra", bvVar.mRecomExtra).dn("source", bvVar.mRecomSource);
        c(context, apVar);
        return apVar;
    }
}
