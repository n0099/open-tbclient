package com.baidu.tieba.ala.personcenter.privilege.entereffect.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.gift.AlaDynamicGift;
import com.baidu.ala.gift.AlaDynamicGiftConfigInfo;
import com.baidu.ala.gift.AlaDynamicGiftZip;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kg;
import com.repackage.ro;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaEnterEffectData implements Serializable, ro {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALA_ENTER_EFFECT_DOWNLOADING = 102;
    public static final int ALA_ENTER_EFFECT_HAS_DOWNLOAD = 101;
    public static final int ALA_ENTER_EFFECT_NOT_DOWNLOAD = 100;
    public static final int ALA_ENTER_EFFECT_TYPE_GENERAL = 0;
    public static final int ALA_ENTER_EFFECT_TYPE_VEHICLE = 1;
    public static final BdUniqueId TYPE_ENTER_EFFECT_DATA;
    public transient /* synthetic */ FieldHolder $fh;
    public long begin_time;
    public int buy_staus;
    public int categoryType;
    public String color;
    public String content_first;
    public String content_last;
    public int downLoadStatus;
    public String effect_range_name;
    public String endColor;
    public long end_time;
    public AlaDynamicGift gift;
    public String icon_url;
    public String id;
    public boolean isOwn;
    public String name;
    public String nobilityName;
    public int nobilityType;
    public String obtain_way;
    public long price;
    public int propId;
    public String startColor;
    public String strokeColor;
    public String thumbnail_url;
    public String time;
    public int type;
    public int use_status;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2014255675, "Lcom/baidu/tieba/ala/personcenter/privilege/entereffect/data/AlaEnterEffectData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2014255675, "Lcom/baidu/tieba/ala/personcenter/privilege/entereffect/data/AlaEnterEffectData;");
                return;
            }
        }
        TYPE_ENTER_EFFECT_DATA = BdUniqueId.gen();
    }

    public AlaEnterEffectData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.ro
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TYPE_ENTER_EFFECT_DATA : (BdUniqueId) invokeV.objValue;
    }

    public boolean isUsing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.use_status == 1 : invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.id = jSONObject.optString("id");
        this.type = jSONObject.optInt("type");
        this.name = jSONObject.optString("name");
        this.use_status = jSONObject.optInt("use_status");
        this.isOwn = jSONObject.optInt("is_own") == 1;
        this.color = jSONObject.optString("color");
        this.startColor = jSONObject.optString("start_color");
        this.endColor = jSONObject.optString("end_color");
        this.strokeColor = jSONObject.optString("stroke_color");
        this.icon_url = jSONObject.optString("icon_url");
        this.content_first = jSONObject.optString("content_first");
        this.content_last = jSONObject.optString("content_last");
        this.effect_range_name = jSONObject.optString("effect_range_name");
        this.end_time = jSONObject.optLong("end_time");
        this.begin_time = jSONObject.optLong("begin_time");
        this.categoryType = jSONObject.optInt("effect_type");
        this.obtain_way = jSONObject.optString("obtain_way");
        JSONObject optJSONObject = jSONObject.optJSONObject("nobility_info");
        if (optJSONObject != null) {
            this.nobilityType = optJSONObject.optInt("nobility_type");
            this.nobilityName = optJSONObject.optString("nobility_type_name");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("props_info");
        if (optJSONObject2 != null) {
            this.propId = kg.e(optJSONObject2.optString("props_id"), 0);
            this.price = kg.g(optJSONObject2.optString("price"), 0L);
            this.time = optJSONObject2.optString("buy_cycle");
            this.buy_staus = optJSONObject2.optInt("buy_staus");
        }
        int i = this.type;
        if (i != 1) {
            if (i == 0) {
                this.thumbnail_url = this.icon_url;
                return;
            }
            return;
        }
        this.thumbnail_url = jSONObject.optString("thumbnail_url");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("gift");
        if (optJSONObject3 != null) {
            AlaDynamicGift alaDynamicGift = new AlaDynamicGift();
            this.gift = alaDynamicGift;
            alaDynamicGift.giftId = optJSONObject3.optString("gift_id");
            this.gift.giftName = optJSONObject3.optString("gift_name");
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("gift_zip");
            if (optJSONObject4 != null) {
                this.gift.giftZip = new AlaDynamicGiftZip();
                this.gift.giftZip.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject3.optJSONObject("config_info");
            if (optJSONObject5 != null) {
                this.gift.configInfo = new AlaDynamicGiftConfigInfo();
                this.gift.configInfo.parseJson(optJSONObject5);
            }
        }
    }
}
