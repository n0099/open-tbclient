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
public class ap6 extends ro6 implements IVideoData {
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
    public int f1090T;

    @Override // com.baidu.tieba.ro6
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622914, "Lcom/baidu/tieba/ap6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622914, "Lcom/baidu/tieba/ap6;");
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

    @Override // com.baidu.tieba.w05
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

    @Override // com.baidu.tieba.ro6, com.baidu.tieba.w05
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

    public ap6(ThreadData threadData) {
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
        this.f1090T = 0;
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
            StatisticItem n = n(Y, true);
            if (n != null) {
                if (i != -1) {
                    n.param(TiebaStatic.Params.CLICK_LOCATE, i);
                }
                if (getThreadData() != null) {
                    ThreadData threadData2 = getThreadData();
                    if (threadData2.getBaijiahaoData() != null) {
                        n.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                        n.param(TiebaStatic.Params.OBJ_PARAM6, threadData2.getBaijiahaoData().oriUgcVid);
                    }
                    n.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData2));
                }
            }
            return n;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StatisticItem n = n(b0, true);
            if (n != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    n.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    n.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                n.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData));
            }
            return n;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ro6
    public StatisticItem f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StatisticItem n = n(W, true);
            if (n != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    n.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    n.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                n.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData));
            }
            return n;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ro6
    public StatisticItem t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StatisticItem n = n(Y, true);
            if (getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    n.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    n.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                n.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData));
                n.param("nid", threadData.getNid());
            }
            return n;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem K(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, threadData)) == null) {
            StatisticItem n = n(V, true);
            if (n != null && getThreadData() != null) {
                ThreadData threadData2 = getThreadData();
                if (threadData2.getBaijiahaoData() != null) {
                    n.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                    n.param(TiebaStatic.Params.OBJ_PARAM6, threadData2.getBaijiahaoData().oriUgcVid);
                    if (threadData2.isAlaLiveUser()) {
                        n.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        n.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                }
                if (threadData2.getAuthor() != null && threadData2.getAuthor().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData2.getAuthor().getAlaInfo());
                    if (threadData2.getAuthor().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(n, threadData2.getAuthor().getAlaInfo().mYyExtData);
                    }
                    n.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                }
                n.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData2));
            }
            return n;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ro6
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

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.bn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return zo6.r0;
            }
            if (this.B) {
                if (this.n) {
                    return ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER;
                }
                return threadData.getType();
            } else if (this.m) {
                return zo6.E0;
            } else {
                if (this.s) {
                    return U;
                }
                if (this.A) {
                    return zo6.L0;
                }
                if (this.y) {
                    return zo6.N0;
                }
                if (this.x) {
                    return zo6.M0;
                }
                if (this.n) {
                    return zo6.F0;
                }
                if (this.u) {
                    return zo6.O0;
                }
                if (this.v) {
                    return zo6.P0;
                }
                if (this.w) {
                    return zo6.Q0;
                }
                if (this.z) {
                    return zo6.R0;
                }
                return U;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ro6
    public StatisticItem r() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = 1;
            StatisticItem n = n(X, true);
            if (n != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getTopAgreePost() != null && (threadData.getTopAgreePost().e0() != null || threadData.getTopAgreePost().w0() != null)) {
                    i = 1;
                } else {
                    i = 0;
                }
                n.param("obj_name", i);
                if (threadData.getAuthor() != null) {
                    n.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
                if (threadData.getBaijiahaoData() != null) {
                    n.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    n.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                n.param(TiebaStatic.Params.OBJ_PARAM5, M(threadData));
                if (threadData.isAlaLiveUser()) {
                    n.param(TiebaStatic.Params.OBJ_TO, 2);
                } else {
                    n.param(TiebaStatic.Params.OBJ_TO, 1);
                }
                if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo());
                    if (threadData.getAuthor().getAlaInfo().live_status != 1 && threadData.getAuthor().getAlaInfo().friendRoomStatus != 2) {
                        i2 = 2;
                    }
                    if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(n, threadData.getAuthor().getAlaInfo().mYyExtData);
                    }
                    n.param(TiebaStatic.Params.OBJ_PARAM7, i2);
                    n.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                }
            }
            return n;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
