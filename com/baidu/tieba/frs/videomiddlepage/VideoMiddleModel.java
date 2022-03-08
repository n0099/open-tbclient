package com.baidu.tieba.frs.videomiddlepage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.q0.c1.i;
import c.a.r0.d1.j1.g;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class VideoMiddleModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f42433e;

    /* renamed from: f  reason: collision with root package name */
    public String f42434f;

    /* renamed from: g  reason: collision with root package name */
    public String f42435g;

    /* renamed from: h  reason: collision with root package name */
    public String f42436h;

    /* renamed from: i  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f42437i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f42438j;
    public b k;
    public String l;
    public String m;
    public final HttpMessageListener n;

    /* loaded from: classes5.dex */
    public static class VideoMiddleDataResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<BaseCardInfo> mDataList;
        public boolean mHasMore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoMiddleDataResponseMessage(int i2) {
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

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddleModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoMiddleModel videoMiddleModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddleModel, Integer.valueOf(i2)};
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
            this.a = videoMiddleModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003378 || !(httpResponsedMessage instanceof VideoMiddleDataResponseMessage)) {
                    if (this.a.k != null) {
                        this.a.k.a("error");
                        return;
                    }
                    return;
                }
                this.a.f42438j = false;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    TbSingleton.getInstance().clearVideoRecord();
                    if (this.a.k != null) {
                        VideoMiddleDataResponseMessage videoMiddleDataResponseMessage = (VideoMiddleDataResponseMessage) httpResponsedMessage;
                        this.a.k.b(videoMiddleDataResponseMessage.mDataList, videoMiddleDataResponseMessage.mHasMore);
                        return;
                    }
                    return;
                }
                VideoMiddleModel.y(this.a);
                String errorString = httpResponsedMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
                }
                if (this.a.k != null) {
                    this.a.k.a(errorString);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);

        void b(List<BaseCardInfo> list, boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddleModel(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
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
        this.m = "client_other";
        this.n = new a(this, CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        this.k = bVar;
        registerTask();
        this.n.setTag(getUniqueId());
        this.n.setSelfListener(true);
        registerListener(this.n);
    }

    public static /* synthetic */ int y(VideoMiddleModel videoMiddleModel) {
        int i2 = videoMiddleModel.f42433e;
        videoMiddleModel.f42433e = i2 - 1;
        return i2;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42433e : invokeV.intValue;
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f42434f = str;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f42436h = str;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f42435g = str;
        }
    }

    public void E(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoSerializeVideoThreadInfo) == null) {
            this.f42437i = videoSerializeVideoThreadInfo;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        BaijiahaoData baijiahaoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f42438j) {
                return false;
            }
            this.f42438j = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
            httpMessage.addParam("tid", this.f42434f);
            httpMessage.addParam("st_type", this.f42435g);
            httpMessage.addParam("yuelaou_locate", this.f42436h);
            int i2 = this.f42433e + 1;
            this.f42433e = i2;
            httpMessage.addParam("pn", i2);
            httpMessage.addParam("user_view_data", z());
            if ("frs".equals(this.l)) {
                this.m = "client_frs";
            } else if ("index".equals(this.l)) {
                this.m = "client_index";
            } else {
                this.m = "client_other";
            }
            httpMessage.addParam(IntentConfig.CALL_FROM, this.m);
            this.m = "client_index";
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.f42437i;
            if (videoSerializeVideoThreadInfo != null && (baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData) != null) {
                httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
                httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.f42437i.mBaijiahaoData.oriUgcType);
                httpMessage.addParam("ori_ugc_vid", this.f42437i.mBaijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_tid", this.f42437i.mBaijiahaoData.oriUgcTid);
            }
            httpMessage.addParam("app_transmit_data", i.a());
            sendMessage(httpMessage);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/getVideoMidPage");
            tbHttpMessageTask.setResponsedClass(VideoMiddleDataResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
        }
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            LinkedList<c.a.q0.g.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
            if (videoRecordList != null) {
                try {
                    if (videoRecordList.size() > 0) {
                        Iterator<c.a.q0.g.a> it = videoRecordList.iterator();
                        while (it.hasNext()) {
                            c.a.q0.g.a next = it.next();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tid", next.a());
                            jSONObject.put("duration", next.b());
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
