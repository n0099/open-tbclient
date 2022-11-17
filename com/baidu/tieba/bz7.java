package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bz7 {
    public static /* synthetic */ Interceptable $ic;
    public static TbHttpMessageTask g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public final BdUniDispatchSchemeController.b f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947662346, "Lcom/baidu/tieba/bz7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947662346, "Lcom/baidu/tieba/bz7;");
        }
    }

    /* loaded from: classes3.dex */
    public class a implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz7 a;

        public a(bz7 bz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bz7Var;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_TID) instanceof String) {
                this.a.a = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID) instanceof String) {
                this.a.b = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                this.a.c = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                this.a.d = xg.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                this.a.e = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
        }
    }

    public bz7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new a(this);
    }

    public final String f(String str, boolean z, int i, String str2, String str3, int i2, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), str2, str3, Integer.valueOf(i2), str4})) == null) {
            if (str == null || str.equals("0")) {
                str = g(str2, str3, i2, str4);
            }
            if (z) {
                str = str + "_host";
            }
            if (i == 1) {
                str = str + "_rev";
            } else if (i == 2) {
                str = str + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return str + TbadkCoreApplication.getCurrentAccount();
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public final String g(String str, String str2, int i, String str3) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i, str3)) == null) {
            String str4 = "";
            if (str != null) {
                str4 = "" + str;
            }
            if (str2 != null) {
                str4 = str4 + str2;
            }
            String str5 = str4 + i;
            if (str3 != null) {
                return str5 + str3;
            }
            return str5;
        }
        return (String) invokeLLIL.objValue;
    }

    public HashMap<String, Object> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (str.startsWith("//")) {
                str = str.substring(2);
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            String[] split = str.split("[&]");
            if (split.length == 0) {
                return null;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b5 A[Catch: Exception -> 0x0284, TryCatch #0 {Exception -> 0x0284, blocks: (B:53:0x010c, B:55:0x0110, B:58:0x011a, B:62:0x0185, B:69:0x01b5, B:71:0x01cb, B:73:0x01fd, B:75:0x0209, B:77:0x022c, B:79:0x0236, B:86:0x024d, B:82:0x0241, B:74:0x0205, B:70:0x01bd), top: B:95:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01bd A[Catch: Exception -> 0x0284, TryCatch #0 {Exception -> 0x0284, blocks: (B:53:0x010c, B:55:0x0110, B:58:0x011a, B:62:0x0185, B:69:0x01b5, B:71:0x01cb, B:73:0x01fd, B:75:0x0209, B:77:0x022c, B:79:0x0236, B:86:0x024d, B:82:0x0241, B:74:0x0205, B:70:0x01bd), top: B:95:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fd A[Catch: Exception -> 0x0284, TryCatch #0 {Exception -> 0x0284, blocks: (B:53:0x010c, B:55:0x0110, B:58:0x011a, B:62:0x0185, B:69:0x01b5, B:71:0x01cb, B:73:0x01fd, B:75:0x0209, B:77:0x022c, B:79:0x0236, B:86:0x024d, B:82:0x0241, B:74:0x0205, B:70:0x01bd), top: B:95:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0205 A[Catch: Exception -> 0x0284, TryCatch #0 {Exception -> 0x0284, blocks: (B:53:0x010c, B:55:0x0110, B:58:0x011a, B:62:0x0185, B:69:0x01b5, B:71:0x01cb, B:73:0x01fd, B:75:0x0209, B:77:0x022c, B:79:0x0236, B:86:0x024d, B:82:0x0241, B:74:0x0205, B:70:0x01bd), top: B:95:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022c A[Catch: Exception -> 0x0284, TryCatch #0 {Exception -> 0x0284, blocks: (B:53:0x010c, B:55:0x0110, B:58:0x011a, B:62:0x0185, B:69:0x01b5, B:71:0x01cb, B:73:0x01fd, B:75:0x0209, B:77:0x022c, B:79:0x0236, B:86:0x024d, B:82:0x0241, B:74:0x0205, B:70:0x01bd), top: B:95:0x010c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(String str) {
        int i;
        int i2;
        PbPageRequestMessage pbPageRequestMessage;
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !TextUtils.isEmpty(str)) {
            if ((str.contains("tbpb") || str.contains(PbModel.UNIDISPATCH_PB)) && !"tbpb://tieba.baidu.com".equals(str)) {
                Uri parse = Uri.parse(str);
                if (BdUniDispatchSchemeController.isUniScheme(parse)) {
                    BdUniDispatchSchemeController.getInstance().parsePbScheme(parse, this.f);
                } else if (StringUtils.isNull(this.a)) {
                    if (!StringUtils.isNull(str) && str.startsWith("tbpb://")) {
                        String decode = Uri.decode(parse.getEncodedPath());
                        if (StringUtils.isNull(decode)) {
                            return;
                        }
                        h(decode);
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                        httpMessage.addParam("call_url", str);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    if (StringUtils.isNull(this.a)) {
                        this.a = parse.getQueryParameter("thread_id");
                    }
                    if (StringUtils.isNull(this.b)) {
                        this.b = parse.getQueryParameter("key_ori_ugc_nid");
                    }
                    if (StringUtils.isNull(this.c)) {
                        this.c = parse.getQueryParameter("key_ori_ugc_tid");
                    }
                    if (this.d == 0) {
                        this.d = xg.e(parse.getQueryParameter("key_ori_ugc_type"), 0);
                    }
                    if (StringUtils.isNull(this.e)) {
                        this.e = parse.getQueryParameter("key_ori_ugc_vid");
                    }
                }
                String queryParameter = parse.getQueryParameter("comment_sort_type");
                int i4 = -1;
                try {
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if ("0".equals(queryParameter)) {
                            i = 0;
                        } else if ("2".equals(queryParameter)) {
                            i = 2;
                        }
                        if (i < 0) {
                            i = qy4.k().l("key_pb_current_sort_type", 2);
                        }
                        i2 = i;
                        pbPageRequestMessage = new PbPageRequestMessage();
                        pbPageRequestMessage.setUpdateType(3);
                        pbPageRequestMessage.setIsReqAd(1);
                        pbPageRequestMessage.setLastids(b65.l);
                        if (this.a != null && this.a.length() != 0) {
                            pbPageRequestMessage.set_kz(xg.g(this.a, 0L));
                            pbPageRequestMessage.setFloorSortType(1);
                            pbPageRequestMessage.setFloor_rn(4);
                            pbPageRequestMessage.set_rn(15);
                            pbPageRequestMessage.set_with_floor(1);
                            pbPageRequestMessage.set_scr_w(Integer.valueOf(yi.l(TbadkCoreApplication.getInst().getApp())));
                            pbPageRequestMessage.set_scr_h(Integer.valueOf(yi.j(TbadkCoreApplication.getInst().getApp())));
                            pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                            if (!TbImageHelper.getInstance().isShowBigImage()) {
                                i3 = 2;
                            } else {
                                i3 = 1;
                            }
                            pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
                            pbPageRequestMessage.setSchemeUrl(str);
                            pbPageRequestMessage.set_r(Integer.valueOf(i2));
                            pbPageRequestMessage.set_thread_type(0);
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (i2 != 0 && i2 != 2) {
                                z = false;
                                if (!z) {
                                    pbPageRequestMessage.set_pn(1);
                                } else {
                                    pbPageRequestMessage.set_last(1);
                                    pbPageRequestMessage.set_pn(1);
                                }
                                pbPageRequestMessage.setIsFromMark(Boolean.FALSE);
                                pbPageRequestMessage.setCacheKey(f(this.a, false, i2, this.b, this.c, this.d, this.e));
                                pbPageRequestMessage.setObjParam1(String.valueOf(25));
                                pbPageRequestMessage.setIsSubPostDataReverse(false);
                                pbPageRequestMessage.setFromSmartFrs(0);
                                if (!UtilHelper.isUgcThreadType(this.d)) {
                                    pbPageRequestMessage.setForumId(String.valueOf(0));
                                } else {
                                    pbPageRequestMessage.setForumId(null);
                                }
                                pbPageRequestMessage.setNeedRepostRecommendForum(false);
                                pbPageRequestMessage.setFrom_push(0);
                                pbPageRequestMessage.setSourceType(1);
                                pbPageRequestMessage.setOriUgcNid(this.b);
                                pbPageRequestMessage.setOriUgcTid(this.c);
                                pbPageRequestMessage.setOriUgcType(this.d);
                                pbPageRequestMessage.setOriUgcVid(this.e);
                                if (pbPageRequestMessage.getPn() != null) {
                                    if (pbPageRequestMessage.getR().intValue() == 1) {
                                        if (pbPageRequestMessage.getPn().intValue() == 1) {
                                            pbPageRequestMessage.setAfterAdThreadCount(i4);
                                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                            pbPageRequestMessage.setReqFoldComment(false);
                                            pbPageRequestMessage.setTag(d80.d);
                                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.a);
                                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                            pbPageRequestMessage.setFromPbOptimize(true);
                                            int i5 = PbPageRequestMessage.requestTimes;
                                            PbPageRequestMessage.requestTimes = i5 + 1;
                                            pbPageRequestMessage.setRequestTimes(i5);
                                            d80.e(pbPageRequestMessage.getHttpMessage(), g);
                                            return;
                                        }
                                    } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                                        pbPageRequestMessage.setAfterAdThreadCount(i4);
                                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                        pbPageRequestMessage.setReqFoldComment(false);
                                        pbPageRequestMessage.setTag(d80.d);
                                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.a);
                                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                        pbPageRequestMessage.setFromPbOptimize(true);
                                        int i52 = PbPageRequestMessage.requestTimes;
                                        PbPageRequestMessage.requestTimes = i52 + 1;
                                        pbPageRequestMessage.setRequestTimes(i52);
                                        d80.e(pbPageRequestMessage.getHttpMessage(), g);
                                        return;
                                    }
                                }
                                i4 = 0;
                                pbPageRequestMessage.setAfterAdThreadCount(i4);
                                pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                pbPageRequestMessage.setReqFoldComment(false);
                                pbPageRequestMessage.setTag(d80.d);
                                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.a);
                                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                pbPageRequestMessage.setFromPbOptimize(true);
                                int i522 = PbPageRequestMessage.requestTimes;
                                PbPageRequestMessage.requestTimes = i522 + 1;
                                pbPageRequestMessage.setRequestTimes(i522);
                                d80.e(pbPageRequestMessage.getHttpMessage(), g);
                                return;
                            }
                            z = true;
                            if (!z) {
                            }
                            pbPageRequestMessage.setIsFromMark(Boolean.FALSE);
                            pbPageRequestMessage.setCacheKey(f(this.a, false, i2, this.b, this.c, this.d, this.e));
                            pbPageRequestMessage.setObjParam1(String.valueOf(25));
                            pbPageRequestMessage.setIsSubPostDataReverse(false);
                            pbPageRequestMessage.setFromSmartFrs(0);
                            if (!UtilHelper.isUgcThreadType(this.d)) {
                            }
                            pbPageRequestMessage.setNeedRepostRecommendForum(false);
                            pbPageRequestMessage.setFrom_push(0);
                            pbPageRequestMessage.setSourceType(1);
                            pbPageRequestMessage.setOriUgcNid(this.b);
                            pbPageRequestMessage.setOriUgcTid(this.c);
                            pbPageRequestMessage.setOriUgcType(this.d);
                            pbPageRequestMessage.setOriUgcVid(this.e);
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            i4 = 0;
                            pbPageRequestMessage.setAfterAdThreadCount(i4);
                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                            pbPageRequestMessage.setReqFoldComment(false);
                            pbPageRequestMessage.setTag(d80.d);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.a);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            pbPageRequestMessage.setFromPbOptimize(true);
                            int i5222 = PbPageRequestMessage.requestTimes;
                            PbPageRequestMessage.requestTimes = i5222 + 1;
                            pbPageRequestMessage.setRequestTimes(i5222);
                            d80.e(pbPageRequestMessage.getHttpMessage(), g);
                            return;
                        }
                        return;
                    }
                    if (this.a != null) {
                        pbPageRequestMessage.set_kz(xg.g(this.a, 0L));
                        pbPageRequestMessage.setFloorSortType(1);
                        pbPageRequestMessage.setFloor_rn(4);
                        pbPageRequestMessage.set_rn(15);
                        pbPageRequestMessage.set_with_floor(1);
                        pbPageRequestMessage.set_scr_w(Integer.valueOf(yi.l(TbadkCoreApplication.getInst().getApp())));
                        pbPageRequestMessage.set_scr_h(Integer.valueOf(yi.j(TbadkCoreApplication.getInst().getApp())));
                        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                        if (!TbImageHelper.getInstance().isShowBigImage()) {
                        }
                        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
                        pbPageRequestMessage.setSchemeUrl(str);
                        pbPageRequestMessage.set_r(Integer.valueOf(i2));
                        pbPageRequestMessage.set_thread_type(0);
                        pbPageRequestMessage.set_banner(1);
                        pbPageRequestMessage.set_back(0);
                        if (i2 != 0) {
                            z = false;
                            if (!z) {
                            }
                            pbPageRequestMessage.setIsFromMark(Boolean.FALSE);
                            pbPageRequestMessage.setCacheKey(f(this.a, false, i2, this.b, this.c, this.d, this.e));
                            pbPageRequestMessage.setObjParam1(String.valueOf(25));
                            pbPageRequestMessage.setIsSubPostDataReverse(false);
                            pbPageRequestMessage.setFromSmartFrs(0);
                            if (!UtilHelper.isUgcThreadType(this.d)) {
                            }
                            pbPageRequestMessage.setNeedRepostRecommendForum(false);
                            pbPageRequestMessage.setFrom_push(0);
                            pbPageRequestMessage.setSourceType(1);
                            pbPageRequestMessage.setOriUgcNid(this.b);
                            pbPageRequestMessage.setOriUgcTid(this.c);
                            pbPageRequestMessage.setOriUgcType(this.d);
                            pbPageRequestMessage.setOriUgcVid(this.e);
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            i4 = 0;
                            pbPageRequestMessage.setAfterAdThreadCount(i4);
                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                            pbPageRequestMessage.setReqFoldComment(false);
                            pbPageRequestMessage.setTag(d80.d);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.a);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            pbPageRequestMessage.setFromPbOptimize(true);
                            int i52222 = PbPageRequestMessage.requestTimes;
                            PbPageRequestMessage.requestTimes = i52222 + 1;
                            pbPageRequestMessage.setRequestTimes(i52222);
                            d80.e(pbPageRequestMessage.getHttpMessage(), g);
                            return;
                        }
                        z = true;
                        if (!z) {
                        }
                        pbPageRequestMessage.setIsFromMark(Boolean.FALSE);
                        pbPageRequestMessage.setCacheKey(f(this.a, false, i2, this.b, this.c, this.d, this.e));
                        pbPageRequestMessage.setObjParam1(String.valueOf(25));
                        pbPageRequestMessage.setIsSubPostDataReverse(false);
                        pbPageRequestMessage.setFromSmartFrs(0);
                        if (!UtilHelper.isUgcThreadType(this.d)) {
                        }
                        pbPageRequestMessage.setNeedRepostRecommendForum(false);
                        pbPageRequestMessage.setFrom_push(0);
                        pbPageRequestMessage.setSourceType(1);
                        pbPageRequestMessage.setOriUgcNid(this.b);
                        pbPageRequestMessage.setOriUgcTid(this.c);
                        pbPageRequestMessage.setOriUgcType(this.d);
                        pbPageRequestMessage.setOriUgcVid(this.e);
                        if (pbPageRequestMessage.getPn() != null) {
                        }
                        i4 = 0;
                        pbPageRequestMessage.setAfterAdThreadCount(i4);
                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                        pbPageRequestMessage.setReqFoldComment(false);
                        pbPageRequestMessage.setTag(d80.d);
                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.a);
                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                        pbPageRequestMessage.setFromPbOptimize(true);
                        int i522222 = PbPageRequestMessage.requestTimes;
                        PbPageRequestMessage.requestTimes = i522222 + 1;
                        pbPageRequestMessage.setRequestTimes(i522222);
                        d80.e(pbPageRequestMessage.getHttpMessage(), g);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return;
                }
                i = -1;
                if (i < 0) {
                }
                i2 = i;
                pbPageRequestMessage = new PbPageRequestMessage();
                pbPageRequestMessage.setUpdateType(3);
                pbPageRequestMessage.setIsReqAd(1);
                pbPageRequestMessage.setLastids(b65.l);
            }
        }
    }
}
