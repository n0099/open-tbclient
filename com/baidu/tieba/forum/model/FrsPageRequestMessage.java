package com.baidu.tieba.forum.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.tieba.ks5;
import com.baidu.tieba.nb7;
import com.baidu.tieba.nea;
import com.baidu.tieba.ps5;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.x58;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.AdParam;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b:\n\u0002\u0010\u0006\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~H\u0014J\b\u0010\u007f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u001a\u0010*\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\u001a\u00100\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001a\u00103\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010%\"\u0004\b5\u0010'R\u001a\u00106\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR\u001a\u00109\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\r\"\u0004\b;\u0010\u000fR\u001a\u0010<\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR\u001a\u0010?\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR\u001a\u0010B\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\tR\u001a\u0010E\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\tR\u001a\u0010H\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\u001a\u0010K\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010%\"\u0004\bM\u0010'R\u001a\u0010N\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\u001a\u0010Q\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\u001a\u0010T\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000fR\u001a\u0010W\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\r\"\u0004\bY\u0010\u000fR\u001a\u0010Z\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\r\"\u0004\b\\\u0010\u000fR\u001a\u0010]\u001a\u00020^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\r\"\u0004\be\u0010\u000fR\u001a\u0010f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\r\"\u0004\bh\u0010\u000fR\u001a\u0010i\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\r\"\u0004\bk\u0010\u000fR\u001a\u0010l\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\r\"\u0004\bn\u0010\u000fR\u001a\u0010o\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0007\"\u0004\bq\u0010\tR\u001a\u0010r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0007\"\u0004\bt\u0010\tR\u001a\u0010u\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\r\"\u0004\bw\u0010\u000fR\u001a\u0010x\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0007\"\u0004\bz\u0010\t¨\u0006\u0080\u0001"}, d2 = {"Lcom/baidu/tieba/forum/model/FrsPageRequestMessage;", "Lcom/baidu/adp/framework/message/NetMessage;", "Lcom/baidu/tieba/feed/model/IGetFeedLoadType;", "()V", "adFloorInfo", "", "getAdFloorInfo", "()Ljava/lang/String;", "setAdFloorInfo", "(Ljava/lang/String;)V", ReplyMeActivityConfig.KEY_FROM, "", "getCallFrom", "()I", "setCallFrom", "(I)V", "categoryId", "getCategoryId", "setCategoryId", "chatroomNewMsg", "getChatroomNewMsg", "setChatroomNewMsg", "cid", "getCid", "setCid", "ctime", "getCtime", "setCtime", "dataSize", "getDataSize", "setDataSize", "defaultSortType", "getDefaultSortType", "setDefaultSortType", "hotThreadId", "", "getHotThreadId", "()J", "setHotThreadId", "(J)V", "isDefaultNavTab", "setDefaultNavTab", "isGood", "setGood", "isNewFrs", "setNewFrs", "isSelection", "setSelection", TiebaStatic.Params.H5_FORUM_NAME, "getKw", "setKw", "lastClickTid", "getLastClickTid", "setLastClickTid", "lastIds", "getLastIds", "setLastIds", "loadCount", "getLoadCount", "setLoadCount", "loadType", "getLoadType", "setLoadType", "netError", "getNetError", "setNetError", "objLocate", "getObjLocate", "setObjLocate", "objSource", "getObjSource", "setObjSource", "pn", "getPn", "setPn", "pushTid", "getPushTid", "setPushTid", "qType", "getQType", "setQType", "refreshCount", "getRefreshCount", "setRefreshCount", "requestTimes", "getRequestTimes", "setRequestTimes", "rn", "getRn", "setRn", "rnNeed", "getRnNeed", "setRnNeed", "scrDip", "", "getScrDip", "()D", "setScrDip", "(D)V", "scrH", "getScrH", "setScrH", "scrW", "getScrW", "setScrW", "sortType", "getSortType", "setSortType", "stParam", "getStParam", "setStParam", "stType", "getStType", "setStType", "upSchema", "getUpSchema", "setUpSchema", "withGroup", "getWithGroup", "setWithGroup", "yuelaoLocate", "getYuelaoLocate", "setYuelaoLocate", HttpClientWrap.c, "", "isShortConnection", "", "getFeedLoadType", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsPageRequestMessage extends NetMessage implements nb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adFloorInfo;
    public int callFrom;
    public int categoryId;
    public String chatroomNewMsg;
    public int cid;
    public int ctime;
    public int dataSize;
    public int defaultSortType;
    public long hotThreadId;
    public int isDefaultNavTab;
    public int isGood;
    public int isNewFrs;
    public int isSelection;
    public String kw;
    public long lastClickTid;
    public String lastIds;
    public int loadCount;
    public int loadType;
    public int netError;
    public String objLocate;
    public String objSource;
    public int pn;
    public long pushTid;
    public int qType;
    public int refreshCount;
    public int requestTimes;
    public int rn;
    public int rnNeed;
    public double scrDip;
    public int scrH;
    public int scrW;
    public int sortType;
    public int stParam;
    public String stType;
    public String upSchema;
    public int withGroup;
    public String yuelaoLocate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPageRequestMessage() {
        super(CmdConfigHttp.FRS_HTTP_CMD, 301001);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.kw = "";
        this.stType = "";
        this.lastIds = "";
        this.yuelaoLocate = "";
        this.objLocate = "";
        this.objSource = "";
        this.upSchema = "";
        this.adFloorInfo = "";
        this.chatroomNewMsg = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.kw = this.kw;
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = Integer.valueOf(this.rn);
            builder.rn_need = Integer.valueOf(this.rnNeed);
            builder.with_group = Integer.valueOf(this.withGroup);
            builder.is_good = Integer.valueOf(this.isGood);
            builder.cid = Integer.valueOf(this.cid);
            builder.scr_w = Integer.valueOf(this.scrW);
            builder.scr_h = Integer.valueOf(this.scrH);
            builder.scr_dip = Double.valueOf(this.scrDip);
            builder.st_type = this.stType;
            builder.q_type = Integer.valueOf(this.qType);
            builder.st_param = Integer.valueOf(this.stParam);
            builder.ctime = Integer.valueOf(this.ctime);
            builder.data_size = Integer.valueOf(this.dataSize);
            builder.net_error = Integer.valueOf(this.netError);
            builder.lastids = this.lastIds;
            builder.category_id = Integer.valueOf(this.categoryId);
            builder.request_times = Integer.valueOf(this.requestTimes);
            builder.yuelaou_locate = this.yuelaoLocate;
            builder.sort_type = Integer.valueOf(this.sortType);
            builder.last_click_tid = Long.valueOf(this.lastClickTid);
            builder.app_pos = LocationCacheData.getInstance().createAppPosInfo();
            builder.load_type = Integer.valueOf(this.loadType);
            builder.obj_locate = this.objLocate;
            builder.obj_source = this.objSource;
            builder.is_selection = Integer.valueOf(this.isSelection);
            builder.call_from = Integer.valueOf(this.callFrom);
            builder.hot_thread_id = Long.valueOf(this.hotThreadId);
            String d = x58.e().d("frs_feed");
            builder.ad_bear_sid = d;
            builder.ad_bear_context = ks5.f(d, ks5.e());
            builder.ad_bear_sid_price = Double.valueOf(ks5.h());
            if (ks5.m(builder.ad_bear_sid)) {
                i = 1;
            } else {
                i = 0;
            }
            builder.has_ad_bear = i;
            AdParam.Builder builder2 = new AdParam.Builder();
            builder2.refresh_count = Integer.valueOf(this.refreshCount);
            builder2.load_count = Integer.valueOf(this.loadCount);
            String str = "";
            builder2.yoga_lib_version = "";
            builder.ad_param = builder2.build(false);
            builder.is_default_navtab = Integer.valueOf(this.isDefaultNavTab);
            if (this.loadType != 1) {
                str = nea.f().d("FRS");
            }
            builder.ad_context_list = str;
            builder.up_schema = this.upSchema;
            builder.default_sort_type = Integer.valueOf(this.defaultSortType);
            AdExtParam.a b = AdExtParam.a.b();
            b.e(this.adFloorInfo);
            builder.ad_ext_params = b.a();
            builder.app_transmit_data = ps5.b();
            builder.push_tid = Long.valueOf(this.pushTid);
            NetMessageHelper.bindCommonParamsToProtobufData(builder, true, false, true);
            builder.chatroom_new_msg = this.chatroomNewMsg;
            builder.is_newfrs = Integer.valueOf(this.isNewFrs);
            FrsPageReqIdl.Builder builder3 = new FrsPageReqIdl.Builder();
            builder3.data = builder.build(false);
            FrsPageReqIdl build = builder3.build(false);
            Intrinsics.checkNotNullExpressionValue(build, "idl.build(false)");
            return build;
        }
        return invokeZ.objValue;
    }

    public final String getAdFloorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.adFloorInfo;
        }
        return (String) invokeV.objValue;
    }

    public final int getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.callFrom;
        }
        return invokeV.intValue;
    }

    public final int getCategoryId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.categoryId;
        }
        return invokeV.intValue;
    }

    public final String getChatroomNewMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.chatroomNewMsg;
        }
        return (String) invokeV.objValue;
    }

    public final int getCid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.cid;
        }
        return invokeV.intValue;
    }

    public final int getCtime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.ctime;
        }
        return invokeV.intValue;
    }

    public final int getDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.dataSize;
        }
        return invokeV.intValue;
    }

    public final int getDefaultSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.defaultSortType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nb7
    public int getFeedLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.loadType;
            if (i != 1) {
                if (i == 2) {
                    return 2;
                }
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public final long getHotThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.hotThreadId;
        }
        return invokeV.longValue;
    }

    public final String getKw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.kw;
        }
        return (String) invokeV.objValue;
    }

    public final long getLastClickTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.lastClickTid;
        }
        return invokeV.longValue;
    }

    public final String getLastIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.lastIds;
        }
        return (String) invokeV.objValue;
    }

    public final int getLoadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.loadCount;
        }
        return invokeV.intValue;
    }

    public final int getLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.loadType;
        }
        return invokeV.intValue;
    }

    public final int getNetError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.netError;
        }
        return invokeV.intValue;
    }

    public final String getObjLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.objLocate;
        }
        return (String) invokeV.objValue;
    }

    public final String getObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.objSource;
        }
        return (String) invokeV.objValue;
    }

    public final int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.pn;
        }
        return invokeV.intValue;
    }

    public final long getPushTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.pushTid;
        }
        return invokeV.longValue;
    }

    public final int getQType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.qType;
        }
        return invokeV.intValue;
    }

    public final int getRefreshCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.refreshCount;
        }
        return invokeV.intValue;
    }

    public final int getRequestTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.requestTimes;
        }
        return invokeV.intValue;
    }

    public final int getRn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.rn;
        }
        return invokeV.intValue;
    }

    public final int getRnNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.rnNeed;
        }
        return invokeV.intValue;
    }

    public final double getScrDip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.scrDip;
        }
        return invokeV.doubleValue;
    }

    public final int getScrH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.scrH;
        }
        return invokeV.intValue;
    }

    public final int getScrW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.scrW;
        }
        return invokeV.intValue;
    }

    public final int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.sortType;
        }
        return invokeV.intValue;
    }

    public final int getStParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.stParam;
        }
        return invokeV.intValue;
    }

    public final String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.stType;
        }
        return (String) invokeV.objValue;
    }

    public final String getUpSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.upSchema;
        }
        return (String) invokeV.objValue;
    }

    public final int getWithGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.withGroup;
        }
        return invokeV.intValue;
    }

    public final String getYuelaoLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.yuelaoLocate;
        }
        return (String) invokeV.objValue;
    }

    public final int isDefaultNavTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.isDefaultNavTab;
        }
        return invokeV.intValue;
    }

    public final int isGood() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.isGood;
        }
        return invokeV.intValue;
    }

    public final int isNewFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.isNewFrs;
        }
        return invokeV.intValue;
    }

    public final int isSelection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.isSelection;
        }
        return invokeV.intValue;
    }

    public final void setAdFloorInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adFloorInfo = str;
        }
    }

    public final void setCallFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.callFrom = i;
        }
    }

    public final void setCategoryId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.categoryId = i;
        }
    }

    public final void setChatroomNewMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.chatroomNewMsg = str;
        }
    }

    public final void setCid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.cid = i;
        }
    }

    public final void setCtime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.ctime = i;
        }
    }

    public final void setDataSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.dataSize = i;
        }
    }

    public final void setDefaultNavTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.isDefaultNavTab = i;
        }
    }

    public final void setDefaultSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.defaultSortType = i;
        }
    }

    public final void setGood(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.isGood = i;
        }
    }

    public final void setHotThreadId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048625, this, j) == null) {
            this.hotThreadId = j;
        }
    }

    public final void setKw(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.kw = str;
        }
    }

    public final void setLastClickTid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            this.lastClickTid = j;
        }
    }

    public final void setLastIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lastIds = str;
        }
    }

    public final void setLoadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.loadCount = i;
        }
    }

    public final void setLoadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.loadType = i;
        }
    }

    public final void setNetError(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.netError = i;
        }
    }

    public final void setNewFrs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.isNewFrs = i;
        }
    }

    public final void setObjLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.objLocate = str;
        }
    }

    public final void setObjSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.objSource = str;
        }
    }

    public final void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.pn = i;
        }
    }

    public final void setPushTid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048636, this, j) == null) {
            this.pushTid = j;
        }
    }

    public final void setQType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            this.qType = i;
        }
    }

    public final void setRefreshCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.refreshCount = i;
        }
    }

    public final void setRequestTimes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.requestTimes = i;
        }
    }

    public final void setRn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.rn = i;
        }
    }

    public final void setRnNeed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.rnNeed = i;
        }
    }

    public final void setScrDip(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Double.valueOf(d)}) == null) {
            this.scrDip = d;
        }
    }

    public final void setScrH(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            this.scrH = i;
        }
    }

    public final void setScrW(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.scrW = i;
        }
    }

    public final void setSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            this.isSelection = i;
        }
    }

    public final void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            this.sortType = i;
        }
    }

    public final void setStParam(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.stParam = i;
        }
    }

    public final void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.stType = str;
        }
    }

    public final void setUpSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.upSchema = str;
        }
    }

    public final void setWithGroup(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i) == null) {
            this.withGroup = i;
        }
    }

    public final void setYuelaoLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.yuelaoLocate = str;
        }
    }
}
