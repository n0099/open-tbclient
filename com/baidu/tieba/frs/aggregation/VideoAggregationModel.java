package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import c.a.d.a.f;
import c.a.t0.d1.s1.g;
import com.baidu.adp.base.BdBaseModel;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class VideoAggregationModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44844e;

    /* renamed from: f  reason: collision with root package name */
    public String f44845f;

    /* renamed from: g  reason: collision with root package name */
    public String f44846g;

    /* renamed from: h  reason: collision with root package name */
    public String f44847h;

    /* renamed from: i  reason: collision with root package name */
    public String f44848i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f44849j;

    /* renamed from: k  reason: collision with root package name */
    public c f44850k;
    public final HttpMessageListener l;
    public final HttpMessageListener m;

    /* loaded from: classes12.dex */
    public static class VideoAggregationResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<g> mDataList;
        public boolean mHasMore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoAggregationResponseMessage(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
                int statusCode = getStatusCode();
                int error = getError();
                if (statusCode == 200 && error == 0 && jSONObject != null) {
                    this.mHasMore = jSONObject.optInt("has_more") == 1;
                    String optString = jSONObject.optString("list");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    this.mDataList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        g gVar = new g();
                        gVar.q(jSONArray.optString(i3));
                        if (gVar.z != null) {
                            this.mDataList.add(gVar);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAggregationModel videoAggregationModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003360 || !(httpResponsedMessage instanceof VideoAggregationResponseMessage)) {
                    this.a.f44850k.a("error");
                    return;
                }
                this.a.f44849j = false;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    VideoAggregationResponseMessage videoAggregationResponseMessage = (VideoAggregationResponseMessage) httpResponsedMessage;
                    this.a.f44850k.b(videoAggregationResponseMessage.mDataList, this.a.f44844e == 1, videoAggregationResponseMessage.mHasMore);
                    return;
                }
                VideoAggregationModel.z(this.a);
                String errorString = httpResponsedMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
                }
                this.a.f44850k.a(errorString);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoAggregationModel videoAggregationModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003378 || !(httpResponsedMessage instanceof VideoAggregationResponseMessage)) {
                    this.a.f44850k.a("error");
                    return;
                }
                this.a.f44849j = false;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    VideoAggregationResponseMessage videoAggregationResponseMessage = (VideoAggregationResponseMessage) httpResponsedMessage;
                    this.a.f44850k.b(videoAggregationResponseMessage.mDataList, this.a.f44844e == 1, videoAggregationResponseMessage.mHasMore);
                    return;
                }
                VideoAggregationModel.z(this.a);
                String errorString = httpResponsedMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
                }
                this.a.f44850k.a(errorString);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void a(String str);

        void b(List<g> list, boolean z, boolean z2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this, CmdConfigHttp.CMD_VIDEO_AGGREGATION);
        this.m = new b(this, CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        this.f44850k = cVar;
        registerTask();
        this.l.setTag(getUniqueId());
        this.l.setSelfListener(true);
        this.m.setTag(getUniqueId());
        this.m.setSelfListener(true);
        registerListener(this.l);
        registerListener(this.m);
    }

    public static /* synthetic */ int z(VideoAggregationModel videoAggregationModel) {
        int i2 = videoAggregationModel.f44844e;
        videoAggregationModel.f44844e = i2 - 1;
        return i2;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f44844e = 0;
            loadData();
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f44845f = str;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f44848i = str;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f44847h = str;
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
            if (TextUtils.isEmpty(this.f44845f) || this.f44849j) {
                return false;
            }
            this.f44849j = true;
            if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.f44846g)) {
                httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_AGGREGATION);
                httpMessage.addParam("fid", this.f44845f);
            } else {
                httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
                httpMessage.addParam("tid", this.f44845f);
                httpMessage.addParam("st_type", this.f44847h);
                httpMessage.addParam("yuelaou_locate", this.f44848i);
            }
            int i2 = this.f44844e + 1;
            this.f44844e = i2;
            httpMessage.addParam("pn", i2);
            sendMessage(httpMessage);
            return true;
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

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f44846g = str;
        }
    }
}
