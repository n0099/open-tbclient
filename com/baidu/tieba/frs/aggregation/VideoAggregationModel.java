package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.ns7;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoAggregationModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public c g;
    public final HttpMessageListener h;
    public final HttpMessageListener i;

    /* loaded from: classes6.dex */
    public interface c {
        void a(String str);

        void b(List<ns7> list, boolean z, boolean z2);
    }

    /* loaded from: classes6.dex */
    public static class VideoAggregationResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String LIVE_CONFIG = "live_config";
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public LiveConfig liveConfig;
        public List<ns7> mDataList;
        public boolean mHasMore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoAggregationResponseMessage(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
                int statusCode = getStatusCode();
                int error = getError();
                if (statusCode == 200 && error == 0 && jSONObject != null) {
                    boolean z = true;
                    if (jSONObject.optInt("has_more") != 1) {
                        z = false;
                    }
                    this.mHasMore = z;
                    String optString = jSONObject.optString("list");
                    if (!TextUtils.isEmpty(optString)) {
                        this.mDataList = new ArrayList();
                        JSONArray jSONArray = new JSONArray(optString);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            ns7 ns7Var = new ns7();
                            ns7Var.d(jSONArray.optString(i2));
                            if (ns7Var.n != null) {
                                this.mDataList.add(ns7Var);
                            }
                        }
                    }
                    if (jSONObject.has("live_config")) {
                        this.liveConfig = (LiveConfig) DataExt.toEntity(jSONObject.getString("live_config"), LiveConfig.class);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAggregationModel videoAggregationModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAggregationModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003360 && (httpResponsedMessage instanceof VideoAggregationResponseMessage)) {
                    boolean z = false;
                    this.a.f = false;
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        VideoAggregationResponseMessage videoAggregationResponseMessage = (VideoAggregationResponseMessage) httpResponsedMessage;
                        List<ns7> list = videoAggregationResponseMessage.mDataList;
                        if (this.a.a == 1) {
                            z = true;
                        }
                        this.a.g.b(list, z, videoAggregationResponseMessage.mHasMore);
                        return;
                    }
                    VideoAggregationModel.R(this.a);
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f06b4);
                    }
                    this.a.g.a(errorString);
                    return;
                }
                this.a.g.a("error");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoAggregationModel videoAggregationModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAggregationModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003378 && (httpResponsedMessage instanceof VideoAggregationResponseMessage)) {
                    boolean z = false;
                    this.a.f = false;
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        VideoAggregationResponseMessage videoAggregationResponseMessage = (VideoAggregationResponseMessage) httpResponsedMessage;
                        List<ns7> list = videoAggregationResponseMessage.mDataList;
                        if (this.a.a == 1) {
                            z = true;
                        }
                        this.a.g.b(list, z, videoAggregationResponseMessage.mHasMore);
                        return;
                    }
                    VideoAggregationModel.R(this.a);
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f06b4);
                    }
                    this.a.g.a(errorString);
                    return;
                }
                this.a.g.a("error");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoAggregationModel(TbPageContext tbPageContext, c cVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, CmdConfigHttp.CMD_VIDEO_AGGREGATION);
        this.i = new b(this, CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        this.g = cVar;
        registerTask();
        this.h.setTag(getUniqueId());
        this.h.setSelfListener(true);
        this.i.setTag(getUniqueId());
        this.i.setSelfListener(true);
        registerListener(this.h);
        registerListener(this.i);
    }

    public static /* synthetic */ int R(VideoAggregationModel videoAggregationModel) {
        int i = videoAggregationModel.a;
        videoAggregationModel.a = i - 1;
        return i;
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.b = str;
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.e = str;
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.c = str;
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = 0;
            loadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_AGGREGATION);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        HttpMessage httpMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!TextUtils.isEmpty(this.b) && !this.f) {
                this.f = true;
                if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.c)) {
                    httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_AGGREGATION);
                    httpMessage.addParam("fid", this.b);
                } else {
                    httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
                    httpMessage.addParam("tid", this.b);
                    httpMessage.addParam("st_type", this.d);
                    httpMessage.addParam("yuelaou_locate", this.e);
                }
                int i = this.a + 1;
                this.a = i;
                httpMessage.addParam("pn", i);
                sendMessage(httpMessage);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/frstab");
            tbHttpMessageTask.setResponsedClass(VideoAggregationResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/getVideoMidPage");
            tbHttpMessageTask2.setResponsedClass(VideoAggregationResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        }
    }
}
