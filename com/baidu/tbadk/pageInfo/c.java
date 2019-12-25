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
    public static b dZ(Context context) {
        if (context != null) {
            f<?> aa = i.aa(context);
            if (aa instanceof a) {
                return ((a) aa).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag ea(Context context) {
        b dZ = dZ(context);
        if (dZ == null) {
            return null;
        }
        return dZ.aOj();
    }

    public static TbPageTag eb(Context context) {
        f<?> aa;
        if (context == null || (aa = i.aa(context)) == null || aa.getPageContext() == null || aa.getPageContext().getPageActivity() == null) {
            return null;
        }
        return Y(aa.getPageContext().getPageActivity().getIntent());
    }

    public static TbPageTag Y(Intent intent) {
        if (intent != null) {
            return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
        return null;
    }

    public static an a(Context context, an anVar) {
        return (context == null || anVar == null) ? anVar : a(anVar, dZ(context));
    }

    public static an a(an anVar, b bVar) {
        return (bVar == null || anVar == null) ? anVar : a(anVar, bVar.getPrePageTag(), bVar.aOj());
    }

    public static an a(an anVar, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (anVar == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                anVar.cp("obj_tab", tbPageTag2.locatePage);
            }
            anVar.Z("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            anVar.cp(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            return anVar;
        }
        return anVar;
    }

    public static an a(an anVar, TbPageTag tbPageTag) {
        if (tbPageTag == null || anVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            anVar.cp("obj_tab", tbPageTag.locatePage);
        }
        anVar.Z("sort_tab", tbPageTag.sortType);
        return anVar;
    }

    private static an b(Context context, an anVar) {
        if (context == null || anVar == null) {
            return null;
        }
        TbPageTag eb = eb(context);
        if (eb != null) {
            if (!TextUtils.isEmpty(eb.locatePage)) {
                anVar.cp("obj_tab", eb.locatePage);
            }
            anVar.Z("sort_tab", eb.sortType);
            return anVar;
        }
        return anVar;
    }

    public static an a(Context context, bj bjVar, String str) {
        if (context == null || bjVar == null || StringUtils.isNull(str)) {
            return null;
        }
        an anVar = new an(str);
        anVar.cp("tid", bjVar.getId()).s("fid", bjVar.getFid()).Z("card_type", bjVar.aBF());
        anVar.cp(TableDefine.SessionColumns.COLUMN_WEIGHT, bjVar.mRecomWeight).cp(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag).cp("extra", bjVar.mRecomExtra).cp("source", bjVar.mRecomSource);
        b(context, anVar);
        return anVar;
    }
}
