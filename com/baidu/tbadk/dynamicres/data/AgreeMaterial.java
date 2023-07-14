package com.baidu.tbadk.dynamicres.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.e26;
import com.baidu.tieba.wg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AgreeMaterial extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Data doubleTapData;
    public Data longPressData;
    public Data singleTapData;
    public Data staticData;

    /* loaded from: classes4.dex */
    public static class Data extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String activityId;
        public boolean all;
        public String dayDirName;
        public String dayRes;
        public String endTime;
        public String fid;
        public String nightDirName;
        public String nightRes;
        public String startTime;
        public String tid;

        /* loaded from: classes4.dex */
        public class a implements e26.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Data a;

            public a(Data data) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {data};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = data;
            }

            @Override // com.baidu.tieba.e26.a
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.dayDirName = str;
                    } else {
                        this.a.dayDirName = null;
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements e26.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Data a;

            public b(Data data) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {data};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = data;
            }

            @Override // com.baidu.tieba.e26.a
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.nightDirName = str;
                    } else {
                        this.a.nightDirName = null;
                    }
                }
            }
        }

        public Data() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void V() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                W(this.dayRes, new a(this));
                W(this.nightRes, new b(this));
            }
        }

        public static Data Y(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                Data data = new Data();
                data.dayRes = jSONObject.optString("resource_day");
                data.nightRes = jSONObject.optString("resource_night");
                data.startTime = jSONObject.optString("start_time");
                data.endTime = jSONObject.optString("end_time");
                data.fid = jSONObject.optString("fid");
                data.tid = jSONObject.optString("tid");
                data.all = "1".equals(jSONObject.optString("all"));
                data.activityId = jSONObject.optString("activity_id");
                return data;
            }
            return (Data) invokeL.objValue;
        }

        public final void W(String str, e26.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) != null) || StringUtils.isNull(str)) {
                return;
            }
            new e26(TBLottieAnimationView.getAnimationPath(), str, aVar).execute(new Void[0]);
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
            if (com.baidu.tbadk.dynamicres.data.AgreeMaterial.W(r8.nightDirName + r9) == false) goto L35;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String X(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            StringBuilder sb;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3)) == null) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long g = wg.g(this.startTime, 0L);
                long g2 = wg.g(this.endTime, 0L);
                if (currentTimeMillis >= g && currentTimeMillis < g2 && !StringUtils.isNull(this.dayDirName)) {
                    if (AgreeMaterial.W(this.dayDirName + str)) {
                        boolean z = false;
                        boolean z2 = true;
                        if (!this.all) {
                            if (!StringUtils.isNull(str2) && !StringUtils.isNull(this.tid) && Arrays.asList(this.tid.split(",")).contains(str2)) {
                                z = true;
                            }
                            if (z || StringUtils.isNull(str3) || StringUtils.isNull(this.fid) || !Arrays.asList(this.fid.split(",")).contains(str3)) {
                                z2 = z;
                            }
                        }
                        if (z2) {
                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                            if (skinType == 4) {
                                if (!StringUtils.isNull(this.nightDirName)) {
                                }
                                return this.dayDirName + str;
                            }
                            if (skinType == 4) {
                                sb = new StringBuilder();
                                str4 = this.nightDirName;
                            } else {
                                sb = new StringBuilder();
                                str4 = this.dayDirName;
                            }
                            sb.append(str4);
                            sb.append(str);
                            return sb.toString();
                        }
                    }
                }
                return null;
            }
            return (String) invokeLLL.objValue;
        }
    }

    public AgreeMaterial() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = TBLottieAnimationView.getAnimationPath() + str;
            File file = new File(str2);
            if (file.exists()) {
                File file2 = new File(str2 + "/data.json");
                if (file2.exists() && file2.length() > 0) {
                    return true;
                }
                FileHelper.deleteFileOrDir(file.getParentFile());
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static AgreeMaterial X(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            AgreeMaterial agreeMaterial = new AgreeMaterial();
            agreeMaterial.staticData = Data.Y(jSONObject.optJSONObject("static"));
            agreeMaterial.singleTapData = Data.Y(jSONObject.optJSONObject("single_point"));
            agreeMaterial.doubleTapData = Data.Y(jSONObject.optJSONObject("double_click"));
            agreeMaterial.longPressData = Data.Y(jSONObject.optJSONObject(PraiseUBCHelper.UBC_TYPE_LONG_PRESS));
            return agreeMaterial;
        }
        return (AgreeMaterial) invokeL.objValue;
    }
}
