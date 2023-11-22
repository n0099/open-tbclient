package com.baidu.tieba;

import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.forum.model.FrsPageRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ck7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final FrsPageRequestMessage a(Bundle bundle) {
        InterceptResult invokeL;
        String str;
        boolean z;
        int i;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bundle)) == null) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString("name");
            String str2 = "";
            if (string == null) {
                string = "";
            }
            Uri uri = (Uri) bundle.getParcelable(IntentConfig.KEY_URI);
            String str3 = (uri == null || (str3 = uri.toString()) == null) ? "" : "";
            if (uri == null || (str = uri.getQueryParameter("name")) == null) {
                if (uri != null) {
                    str = uri.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
                } else {
                    str = null;
                }
            }
            if (string.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (str != null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    string = str.toString();
                }
            }
            FrsPageRequestMessage frsPageRequestMessage = new FrsPageRequestMessage();
            frsPageRequestMessage.setSortType(-1);
            frsPageRequestMessage.setDefaultSortType(0);
            frsPageRequestMessage.setPn(1);
            frsPageRequestMessage.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            frsPageRequestMessage.setHotThreadId(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            frsPageRequestMessage.setObjLocate("2");
            frsPageRequestMessage.setObjSource("-2");
            String urlEncode = qd.getUrlEncode(string);
            Intrinsics.checkNotNullExpressionValue(urlEncode, "getUrlEncode(forumName)");
            frsPageRequestMessage.setKw(urlEncode);
            frsPageRequestMessage.setWithGroup(1);
            frsPageRequestMessage.setCid(0);
            frsPageRequestMessage.setScrW(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            frsPageRequestMessage.setScrH(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            frsPageRequestMessage.setScrDip(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()));
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            frsPageRequestMessage.setQType(i);
            frsPageRequestMessage.setUpSchema(str3);
            String string2 = bundle.getString("yuelaou_locate");
            if (string2 == null) {
                string2 = "";
            }
            frsPageRequestMessage.setYuelaoLocate(string2);
            frsPageRequestMessage.setLastClickTid(JavaTypesHelper.toLong(xt5.a(), 0L));
            String string3 = bundle.getString("from");
            if (string3 != null) {
                str2 = string3;
            }
            frsPageRequestMessage.setStType(str2);
            frsPageRequestMessage.setDefaultNavTab(1);
            frsPageRequestMessage.setLoadType(1);
            if (ThreadData.isRecAppLoaded.get() && zca.m().b() != null) {
                frsPageRequestMessage.setRefreshCount(zca.m().b().d(string, false) + 1);
                frsPageRequestMessage.setLoadCount(zca.m().b().e(string, false));
            }
            frsPageRequestMessage.setNewFrs(1);
            return frsPageRequestMessage;
        }
        return (FrsPageRequestMessage) invokeL.objValue;
    }
}
