package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h45 extends b15 implements cn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public ThreadData t;
    public int u;
    public int v;

    public h45() {
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
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.u = 0;
        this.v = 0;
    }

    @Override // com.baidu.tieba.b15
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ThreadData threadData = this.t;
            if (threadData != null && (sparseArray = threadData.feedBackReasonMap) != null && sparseArray.size() > 0) {
                NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
                negativeFeedBackData.setTid(getThreadData().getTid());
                negativeFeedBackData.setFid(getThreadData().getFid());
                negativeFeedBackData.setNid(getThreadData().getNid());
                negativeFeedBackData.setFeedBackReasonMap(this.t.feedBackReasonMap);
                ThreadData threadData2 = this.t;
                negativeFeedBackData.feedBackExtraMap = threadData2.feedBackExtraMap;
                negativeFeedBackData.abTag = threadData2.mRecomAbTag;
                negativeFeedBackData.weight = threadData2.mRecomWeight;
                negativeFeedBackData.extra = threadData2.mRecomExtra;
                negativeFeedBackData.source = threadData2.mRecomSource;
                negativeFeedBackData.statFloor = threadData2.statFloor;
                negativeFeedBackData.cardType = threadData2.getRecomCardType();
                return negativeFeedBackData;
            }
            return null;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b15
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.t.mRecomReason;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b15
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.t;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.cn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ThreadData threadData = this.t;
            if (threadData == null) {
                return null;
            }
            if (threadData.getIsDailyThread()) {
                if (this.t.getThreadVideoInfo() != null) {
                    return ThreadData.TYPE_VIDEO;
                }
                return ThreadData.TYPE_NORMAL;
            }
            int is_top = this.t.getIs_top();
            ThreadData threadData2 = this.t;
            if (threadData2.threadType == 63) {
                return ThreadData.TYPE_SMART_APP_IMAGE;
            }
            if (threadData2.getThreadAlaInfo() != null && this.t.threadType == 60) {
                return ThreadData.TYPE_ALA_SHARE_THREAD;
            }
            if (this.t.getThreadAlaInfo() != null && ((i = this.t.threadType) == 49 || i == 69)) {
                return ThreadData.TYPE_VIDEO_ALA_ONLIVE;
            }
            ThreadData threadData3 = this.t;
            if (threadData3.threadType == 51) {
                return ThreadData.TYPE_ALA_LIVE_EMPTY;
            }
            if (is_top != 2 && is_top != 1) {
                if (threadData3.getThreadVideoInfo() != null && this.t.isInsertThread() && !this.t.isLiveInterviewLiveType()) {
                    return ThreadData.TYPE_INSERT_VIDEO;
                }
                ThreadData threadData4 = this.t;
                if (threadData4.isShareThread && (originalThreadInfo = threadData4.originalThreadData) != null) {
                    if (originalThreadInfo.x) {
                        if (originalThreadInfo.r != null) {
                            return ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD;
                        }
                        if (originalThreadInfo.i()) {
                            return ThreadData.TYPE_ARTICLE_SHARE_THREAD;
                        }
                        return ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD;
                    }
                    return ThreadData.TYPE_SHARE_THREAD;
                } else if (this.t.isInterviewLiveStyle()) {
                    if (ThreadData.isFRSExtraLoaded.get()) {
                        return ThreadData.TYPE_STAR_INTERVIEW;
                    }
                    return ThreadData.TYPE_NORMAL;
                } else if (this.t.isActInfo() && this.t.getActInfoType() == 1) {
                    if (ThreadData.isFRSExtraLoaded.get()) {
                        return ThreadData.TYPE_LOTTERY;
                    }
                    return ThreadData.TYPE_NORMAL;
                } else if (this.t.isLinkThread()) {
                    return ThreadData.TYPE_LINK;
                } else {
                    if (this.t.isTopicThread()) {
                        if (this.t.getHotTopicInfo() != null) {
                            return ThreadData.TYPE_FRS_HOTTOPIC_VIDEO;
                        }
                        return ThreadData.TYPE_FRS_HOTTOPIC;
                    }
                    rha rhaVar = this.t.funAdData;
                    if (rhaVar != null && rhaVar.h()) {
                        if (this.t.funAdData.i()) {
                            return AdvertAppInfo.H;
                        }
                        return AdvertAppInfo.I;
                    } else if (this.r) {
                        return ThreadData.TYPE_FORUM_HEADER;
                    } else {
                        if (this.a) {
                            return ThreadData.TYPE_USER_NORMAL;
                        }
                        if (this.b) {
                            return ThreadData.TYPE_CONTENT_TEXT_NORMAL;
                        }
                        if (this.c) {
                            return ThreadData.TYPE_CONTENT_SINGLE_H_NORMAL;
                        }
                        if (this.d) {
                            return ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL;
                        }
                        if (this.e) {
                            return ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL;
                        }
                        if (this.f) {
                            return ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL;
                        }
                        if (this.g) {
                            return ThreadData.TYPE_BOTTOM_NORMAL;
                        }
                        if (this.h) {
                            return ThreadData.TYPE_GODREPLY_NORMAL;
                        }
                        if (this.i) {
                            return ThreadData.TYPE_VIDEO;
                        }
                        if (this.j) {
                            return ThreadData.TYPE_FAKE_VIDEO;
                        }
                        if (this.t.isGodThread()) {
                            if (this.k) {
                                return ThreadData.TYPE_VIDEO_GOD;
                            }
                            return ThreadData.TYPE_GOD_NORMAL;
                        } else if (this.l) {
                            return ThreadData.TYPE_SMART_APP;
                        } else {
                            if (this.m) {
                                return ThreadData.TYPE_ENTER_FORUM;
                            }
                            if (this.n) {
                                return ThreadData.TYPE_ITEM;
                            }
                            if (this.o) {
                                return ThreadData.TYPE_VOTE;
                            }
                            if (this.p) {
                                return ThreadData.TYPE_SINGLE_LINK;
                            }
                            if (this.q) {
                                return ThreadData.TYPE_MULTI_LINK;
                            }
                            if (this.s) {
                                return ThreadData.TYPE_RECOMMEND_INFO;
                            }
                            return ThreadData.TYPE_NORMAL;
                        }
                    }
                }
            }
            return ThreadData.TYPE_TOP;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
