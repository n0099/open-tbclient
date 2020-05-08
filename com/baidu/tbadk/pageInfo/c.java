package com.baidu.tbadk.pageInfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class c {
    public static b dD(Context context) {
        if (context != null) {
            f<?> F = i.F(context);
            if (F instanceof a) {
                return ((a) F).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag dE(Context context) {
        b dD = dD(context);
        if (dD == null) {
            return null;
        }
        return dD.aZh();
    }

    public static TbPageTag dF(Context context) {
        f<?> F;
        if (context == null || (F = i.F(context)) == null || F.getPageContext() == null || F.getPageContext().getPageActivity() == null) {
            return null;
        }
        return K(F.getPageContext().getPageActivity().getIntent());
    }

    public static TbPageTag K(Intent intent) {
        if (intent != null) {
            return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
        return null;
    }

    public static an a(Context context, an anVar) {
        return (context == null || anVar == null) ? anVar : a(anVar, dD(context));
    }

    public static an a(an anVar, b bVar) {
        return (bVar == null || anVar == null) ? anVar : a(anVar, bVar.getPrePageTag(), bVar.aZh());
    }

    public static an a(an anVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (anVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                anVar.cI("obj_tab", tbPageTag2.locatePage);
            }
            anVar.af("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            anVar.cI(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            return anVar;
        }
        return anVar;
    }

    public static an a(an anVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || anVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            anVar.cI("obj_tab", tbPageTag.locatePage);
        }
        anVar.af("sort_tab", tbPageTag.sortType);
        return anVar;
    }

    private static an b(Context context, an anVar) {
        if (context == null || anVar == null) {
            return null;
        }
        TbPageTag dF = dF(context);
        if (dF != null) {
            if (!TextUtils.isEmpty(dF.locatePage)) {
                anVar.cI("obj_tab", dF.locatePage);
            }
            anVar.af("sort_tab", dF.sortType);
            return anVar;
        }
        return anVar;
    }

    public static an a(Context context, bj bjVar, String str) {
        if (context == null || bjVar == null || StringUtils.isNull(str)) {
            return null;
        }
        an anVar = new an(str);
        anVar.cI("tid", bjVar.getId()).t("fid", bjVar.getFid()).af("card_type", bjVar.aMB());
        anVar.cI(TableDefine.SessionColumns.COLUMN_WEIGHT, bjVar.mRecomWeight).cI(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag).cI("extra", bjVar.mRecomExtra).cI("source", bjVar.mRecomSource);
        b(context, anVar);
        return anVar;
    }
}
