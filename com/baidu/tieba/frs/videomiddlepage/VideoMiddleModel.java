package com.baidu.tieba.frs.videomiddlepage;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ce5;
import com.baidu.tieba.gi6;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.zl4;
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
/* loaded from: classes4.dex */
public class VideoMiddleModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public VideoSerializeVideoThreadInfo e;
    public boolean f;
    public String g;
    public String h;

    /* loaded from: classes4.dex */
    public static class VideoMiddleDataResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<BaseCardInfo> mDataList;
        public boolean mHasMore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoMiddleDataResponseMessage(int i) {
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
                    this.mHasMore = jSONObject.optInt("has_more") == 1;
                    String optString = jSONObject.optString("list");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    this.mDataList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        gi6 gi6Var = new gi6();
                        gi6Var.f(jSONArray.optString(i2));
                        if (gi6Var.n != null) {
                            this.mDataList.add(gi6Var);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f) {
                return false;
            }
            this.f = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
            httpMessage.addParam("tid", this.b);
            httpMessage.addParam("st_type", this.c);
            httpMessage.addParam("yuelaou_locate", this.d);
            int i = this.a + 1;
            this.a = i;
            httpMessage.addParam("pn", i);
            httpMessage.addParam("user_view_data", z());
            if ("frs".equals(this.g)) {
                this.h = "client_frs";
            } else if ("index".equals(this.g)) {
                this.h = "client_index";
            } else {
                this.h = "client_other";
            }
            httpMessage.addParam(IntentConfig.CALL_FROM, this.h);
            this.h = "client_index";
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.e;
            if (videoSerializeVideoThreadInfo != null && (baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData) != null) {
                httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
                httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.e.mBaijiahaoData.oriUgcType);
                httpMessage.addParam("ori_ugc_vid", this.e.mBaijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_tid", this.e.mBaijiahaoData.oriUgcTid);
            }
            httpMessage.addParam("app_transmit_data", ce5.a());
            sendMessage(httpMessage);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            LinkedList<zl4> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
            if (videoRecordList != null) {
                try {
                    if (videoRecordList.size() > 0) {
                        Iterator<zl4> it = videoRecordList.iterator();
                        while (it.hasNext()) {
                            zl4 next = it.next();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tid", next.a());
                            jSONObject.put("duration", next.b());
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
