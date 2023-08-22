package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BannerImage;
import tbclient.RecomTopicList;
/* loaded from: classes5.dex */
public class cz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ArrayList<ThreadData> b;
    public k15 c;
    public l25 d;
    public d88 e;
    @Nullable
    public String f;
    public dc9 g;

    public cz7() {
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
        this.a = true;
    }

    public k15 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (k15) invokeV.objValue;
    }

    public l25 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (l25) invokeV.objValue;
    }

    public d88 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (d88) invokeV.objValue;
    }

    public dc9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (dc9) invokeV.objValue;
    }

    public ArrayList<ThreadData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public void g(JSONObject jSONObject) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            boolean z = false;
            if (optJSONArray != null) {
                this.b = new ArrayList<>(optJSONArray.length());
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.isFromFeedTab = true;
                        threadData.isFromLocal = "local".equals(this.f);
                        threadData.parserJson(jSONObject2);
                        threadData.insertItemToTitleOrAbstractText();
                        this.b.add(threadData);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_list");
            if (optJSONArray2 != null) {
                this.c = new k15();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject != null) {
                        BannerImage.Builder builder = new BannerImage.Builder();
                        builder.ahead_url = optJSONObject.optString("ahead_url");
                        builder.img_url = optJSONObject.optString(BigdayActivityConfig.IMG_URL);
                        builder.title = optJSONObject.optString("title");
                        arrayList.add(builder.build(true));
                    }
                }
                this.c.parserProtobuf(arrayList);
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("grid");
            if (optJSONArray3 != null && optJSONArray3.length() >= 4) {
                this.d = new l25();
                ArrayList arrayList2 = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i4);
                    if (optJSONObject2 != null) {
                        BannerImage.Builder builder2 = new BannerImage.Builder();
                        builder2.ahead_url = optJSONObject2.optString("ahead_url");
                        builder2.img_url = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                        builder2.title = optJSONObject2.optString("title");
                        arrayList2.add(builder2.build(true));
                    }
                }
                this.d.parserProtobuf(arrayList2);
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("module_list");
            JSONArray jSONArray = null;
            int i5 = 0;
            while (true) {
                if (i5 < optJSONArray4.length()) {
                    JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i5);
                    if ("hot_topic".equals(optJSONObject3.optString("type"))) {
                        jSONArray = optJSONObject3.optJSONArray("hot_topic");
                        i = optJSONObject3.optInt(CriusAttrConstants.POSITION);
                        break;
                    }
                    i5++;
                } else {
                    i = 0;
                    break;
                }
            }
            if (jSONArray != null && jSONArray.length() >= 4) {
                ArrayList arrayList3 = new ArrayList();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject optJSONObject4 = jSONArray.optJSONObject(i6);
                    if (optJSONObject4 != null && i6 < 6) {
                        RecomTopicList.Builder builder3 = new RecomTopicList.Builder();
                        builder3.topic_id = Long.valueOf(JavaTypesHelper.toLong(optJSONObject4.optString("topic_id"), 0L));
                        builder3.topic_name = optJSONObject4.optString("topic_name");
                        builder3.topic_desc = optJSONObject4.optString("topic_desc");
                        builder3.tag = Integer.valueOf(optJSONObject4.optInt("tag"));
                        builder3.topic_pic = optJSONObject4.optString("topic_pic");
                        builder3.type = Integer.valueOf(optJSONObject4.optInt("type"));
                        builder3.discuss_num = Long.valueOf(JavaTypesHelper.toLong(optJSONObject4.optString("discuss_num"), 0L));
                        arrayList3.add(builder3.build(true));
                    }
                    d88 d88Var = new d88();
                    this.e = d88Var;
                    d88Var.floorPosition = i;
                    d88Var.parserProtobuf(arrayList3);
                }
            }
            if (jSONObject.optInt("has_more", 1) == 1) {
                z = true;
            }
            this.a = z;
            JSONObject optJSONObject5 = jSONObject.optJSONObject("nearby_person");
            if (optJSONObject5 != null) {
                dc9 dc9Var = new dc9();
                this.g = dc9Var;
                dc9Var.a(optJSONObject5);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f = str;
        }
    }
}
