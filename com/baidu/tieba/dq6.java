package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dq6 extends up6 implements IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId U;
    public static String V;
    public static String W;
    public static String X;
    public static String Y;
    public static String Z;
    public static String a0;
    public static String b0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public int f1091T;

    @Override // com.baidu.tieba.up6
    public boolean isVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947713248, "Lcom/baidu/tieba/dq6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947713248, "Lcom/baidu/tieba/dq6;");
                return;
            }
        }
        U = BdUniqueId.gen();
        V = "";
        W = "";
        X = "";
        Y = "";
        b0 = "";
    }

    @Override // com.baidu.tieba.b15
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return null;
            }
            return threadData.mRecomReason;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.up6, com.baidu.tieba.b15
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return null;
            }
            if (threadData.getResource() != 5) {
                this.a.setResource(1);
            }
            return this.a;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData != null && threadData.getThreadVideoInfo() != null && this.a.getThreadVideoInfo().video_url != null) {
                return this.a.getThreadVideoInfo().video_url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public dq6(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.R = false;
        this.S = true;
        this.f1091T = 0;
        this.a = threadData;
    }

    public int M(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) {
            if (threadData == null) {
                return 1;
            }
            if (!threadData.isBJHVideoDynamicThreadType() && !threadData.isBJHNormalThreadType()) {
                if (!threadData.isBJHArticleThreadType() && !threadData.isBJHVideoThreadType()) {
                    return 1;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static boolean L(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) {
            if (threadData == null || threadData.getThreadVideoInfo() == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public StatisticItem G(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            return H(threadData, -1);
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem H(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData, i)) == null) {
            StatisticItem o = o(Y, true);
            if (o != null) {
                if (i != -1) {
                    o.param(TiebaStatic.Params.CLICK_LOCATE, i);
                }
                if (getThreadData() != null) {
                    ThreadData threadData2 = getThreadData();
                    if (threadData2.getBaijiahaoData() != null) {
                        o.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                        o.param(TiebaStatic.Params.OBJ_PARAM6, threadData2.getBaijiahaoData().oriUgcVid);
                    }
                    o.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData2));
                }
            }
            return o;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StatisticItem o = o(b0, true);
            if (o != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    o.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    o.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                o.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData));
            }
            return o;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.up6
    public StatisticItem f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StatisticItem o = o(W, true);
            if (o != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    o.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    o.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                o.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData));
            }
            return o;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.up6
    public StatisticItem t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StatisticItem o = o(Y, true);
            if (getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    o.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    o.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                o.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData));
                o.param("nid", threadData.getNid());
            }
            return o;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem K(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, threadData)) == null) {
            StatisticItem o = o(V, true);
            if (o != null && getThreadData() != null) {
                ThreadData threadData2 = getThreadData();
                if (threadData2.getBaijiahaoData() != null) {
                    o.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                    o.param(TiebaStatic.Params.OBJ_PARAM6, threadData2.getBaijiahaoData().oriUgcVid);
                    if (threadData2.isAlaLiveUser()) {
                        o.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        o.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                }
                if (threadData2.getAuthor() != null && threadData2.getAuthor().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData2.getAuthor().getAlaInfo());
                    if (threadData2.getAuthor().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(o, threadData2.getAuthor().getAlaInfo().mYyExtData);
                    }
                    o.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                }
                o.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData2));
            }
            return o;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // com.baidu.tieba.up6
    public StatisticItem d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            ThreadData threadData = this.a;
            if (threadData != null) {
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("tid", this.a.getTid());
                int i = 2;
                if (this.a.isBJHVideoThreadType()) {
                    statisticItem.param("obj_type", 8);
                } else if (this.a.isBJHVideoDynamicThreadType()) {
                    statisticItem.param("obj_type", 9);
                } else if (this.a.isVideoThreadType()) {
                    statisticItem.param("obj_type", 2);
                }
                if (!v()) {
                    i = 1;
                }
                statisticItem.param("obj_param1", i);
                if (this.a.getAuthor() != null) {
                    statisticItem.param("obj_id", this.a.getAuthor().getUserId());
                }
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.cn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return cq6.r0;
            }
            if (this.B) {
                if (this.n) {
                    return ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER;
                }
                return threadData.getType();
            } else if (this.m) {
                return cq6.E0;
            } else {
                if (this.s) {
                    return U;
                }
                if (this.A) {
                    return cq6.L0;
                }
                if (this.y) {
                    return cq6.N0;
                }
                if (this.x) {
                    return cq6.M0;
                }
                if (this.n) {
                    return cq6.F0;
                }
                if (this.u) {
                    return cq6.O0;
                }
                if (this.v) {
                    return cq6.P0;
                }
                if (this.w) {
                    return cq6.Q0;
                }
                if (this.z) {
                    return cq6.R0;
                }
                return U;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.up6
    public StatisticItem s() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = 1;
            StatisticItem o = o(X, true);
            if (o != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getTopAgreePost() != null && (threadData.getTopAgreePost().f0() != null || threadData.getTopAgreePost().x0() != null)) {
                    i = 1;
                } else {
                    i = 0;
                }
                o.param("obj_name", i);
                if (threadData.getAuthor() != null) {
                    o.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
                if (threadData.getBaijiahaoData() != null) {
                    o.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    o.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                o.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData));
                if (threadData.isAlaLiveUser()) {
                    o.param(TiebaStatic.Params.OBJ_TO, 2);
                } else {
                    o.param(TiebaStatic.Params.OBJ_TO, 1);
                }
                if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo());
                    if (threadData.getAuthor().getAlaInfo().live_status != 1 && threadData.getAuthor().getAlaInfo().friendRoomStatus != 2) {
                        i2 = 2;
                    }
                    if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(o, threadData.getAuthor().getAlaInfo().mYyExtData);
                    }
                    o.param(TiebaStatic.Params.OBJ_PARAM7, i2);
                    o.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                }
            }
            return o;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
