package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class b36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext<?> tbPageContext, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, str, str2, str3) == null) && tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(tbPageContext.getPageActivity());
            } else if (str.equals(TbadkCoreApplication.getCurrentPortrait())) {
                BdToast.b(tbPageContext.getPageActivity(), tbPageContext.getPageActivity().getString(R.string.can_not_raise_self)).o();
            } else {
                try {
                    String str4 = "https://tieba.baidu.com/mo/q/hybrid-main-activity/worldcupPortrait?support_cache=1&thrown_flag_portrait=" + URLEncoder.encode(str, "utf-8");
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        str4 = str4 + "&figure_url=" + URLEncoder.encode(str2, "utf-8") + "&background_value=" + URLEncoder.encode(str3, "utf-8");
                    }
                    TbWebViewActivityConfig h = qx4.h(tbPageContext.getPageActivity(), "", str4, false, true, true);
                    h.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                    h.setTranslucentAutoClose(true);
                    h.setWebDialogName("WorldCupRaiseFlag");
                    h.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
