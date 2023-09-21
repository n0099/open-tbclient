package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ChooseThreadList;
import tbclient.ChooseTimeList;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes5.dex */
public class ev8 implements IResponseData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<FeedData> a;
    public ArrayList<cw8> b;
    public ArrayList<cw8> c;
    public e35 d;
    public cv8 e;

    public ev8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        ArrayList<cw8> arrayList = new ArrayList<>();
        this.b = arrayList;
        arrayList.add(new cw8(1, "全部时间", 0L));
        ArrayList<cw8> arrayList2 = new ArrayList<>();
        this.c = arrayList2;
        arrayList2.add(new cw8(0, "全部贴子", 0L));
        this.d = new e35();
        this.e = new cv8();
    }

    public ArrayList<FeedData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public e35 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (e35) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
                if (optJSONArray == null) {
                    optJSONArray = jSONObject.optJSONArray("at_list");
                }
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        FeedData feedData = new FeedData();
                        feedData.parserJson(optJSONArray.optJSONObject(i));
                        this.a.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && ListUtils.getCount(feedData.getPraiseList()) == 0) {
                            this.a.remove(feedData);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("choose_time_list");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                        this.b.add(new cw8(1, jSONObject2.optString("title"), jSONObject2.optLong("time")));
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("choose_thread_list");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                        this.b.add(new cw8(0, jSONObject3.optString("title"), jSONObject3.optLong("tid")));
                    }
                }
                this.e.a(jSONObject.optJSONObject("message"));
                this.d.i(jSONObject.optJSONObject("page"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && (message instanceof ReplyMeResIdl)) {
            DataRes dataRes = ((ReplyMeResIdl) message).data;
            try {
                List<ReplyList> list = dataRes.reply_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        FeedData feedData = new FeedData();
                        feedData.parserProtoBuf(list.get(i));
                        this.a.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && ListUtils.getCount(feedData.getPraiseList()) == 0) {
                            this.a.remove(feedData);
                        }
                    }
                }
                List<ChooseTimeList> list2 = dataRes.choose_time_list;
                if (list2 != null && list2.size() > 0) {
                    for (ChooseTimeList chooseTimeList : list2) {
                        this.b.add(new cw8(1, chooseTimeList.title, chooseTimeList.time.longValue()));
                    }
                }
                List<ChooseThreadList> list3 = dataRes.choose_thread_list;
                if (list3 != null && list3.size() > 0) {
                    for (ChooseThreadList chooseThreadList : list3) {
                        this.c.add(new cw8(0, chooseThreadList.title, chooseThreadList.tid.longValue()));
                    }
                }
                this.d.j(dataRes.page);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
