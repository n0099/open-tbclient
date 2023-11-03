package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.bu;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PeiwanInfo;
/* loaded from: classes6.dex */
public class gd8 extends bi<nm6, ThreadCardViewHolder<nm6>> implements s16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public af8 c;
    public String d;
    public boolean e;
    public ui f;
    public xl6<nm6> g;

    /* loaded from: classes6.dex */
    public class a extends xl6<nm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd8 b;

        public a(gd8 gd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gd8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xl6
        /* renamed from: d */
        public void a(View view2, nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, nm6Var) == null) {
                pl6.b().d(true);
                q16.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && nm6Var != null && nm6Var.getThreadData() != null && !StringUtils.isNull(nm6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !wc8.b(JavaTypesHelper.toLong(nm6Var.getThreadData().getTid(), 0L))) {
                        wc8.a(JavaTypesHelper.toLong(nm6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(nm6Var.getThreadData().getTid(), 0L), nm6Var.u(), nm6Var.i(), nm6Var.h(), nm6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, nm6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.C(view2, nm6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd8 a;

        public b(gd8 gd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gd8Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (oiVar instanceof nm6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                nm6 nm6Var = (nm6) oiVar;
                nm6Var.f = 1;
                ThreadData threadData = nm6Var.a;
                if (threadData != null && threadData.getPeiwanInfo() != null && !TextUtils.isEmpty(nm6Var.a.getPeiwanInfo().scheme)) {
                    UrlManager.getInstance().dealOneLink(nm6Var.a.getPeiwanInfo().scheme);
                    gd8.y(nm6Var.a);
                    return;
                }
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), nm6Var);
                }
                ThreadCardUtils.jumpToPB((bw4) nm6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().q(new mu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.g = new a(this);
        this.b = tbPageContext;
        z();
    }

    public void D(af8 af8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, af8Var) == null) {
            this.c = af8Var;
        }
    }

    public void E(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uiVar) == null) {
            this.f = uiVar;
        }
    }

    @Override // com.baidu.tieba.s16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d = str;
        }
    }

    public static void y(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) == null) && threadData != null && threadData.getPeiwanInfo() != null) {
            PeiwanInfo peiwanInfo = threadData.getPeiwanInfo();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOME_PEI_WAN_CARD_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_locate", String.valueOf(threadData.floorPosition));
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, peiwanInfo.room_id.longValue());
            if (threadData.isFromNet) {
                str = "1";
            } else {
                str = "0";
            }
            statisticItem.addParam("obj_param1", str);
            statisticItem.eventStat();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.b.getPageActivity(), false);
            qt qtVar = new qt(this.b.getPageActivity());
            qtVar.setFrom("index");
            qtVar.u(this.e);
            bVar.n(qtVar);
            bu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.f);
            k.t(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nm6 nm6Var, ThreadCardViewHolder<nm6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nm6Var, threadCardViewHolder})) == null) {
            if (nm6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && nm6Var.a != null) {
                nm6Var.A(nm6Var.position + 1);
                nm6Var.a.statFloor = nm6Var.h();
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.e(nm6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.g);
                pl6.b().a(nm6Var.s());
                q16.c().a(nm6Var.s());
                ff8.p(nm6Var.a, this.a, nm6Var.h());
                ff8.o(nm6Var.a, nm6Var.i(), nm6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C(View view2, nm6 nm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, nm6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(nm6Var.N());
                    q16.c().i("page_recommend", "clk_", nm6Var.N());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(nm6Var.N());
                    q16.c().i("page_recommend", "clk_", nm6Var.N());
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(nm6Var.f());
                    q16.c().i("page_recommend", "clk_", nm6Var.f());
                    i = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        ff8.c(nm6Var.a, nm6Var.i(), nm6Var.h(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(nm6Var.J());
                            q16.c().i("page_recommend", "clk_", nm6Var.J());
                            ff8.c(nm6Var.a, nm6Var.i(), nm6Var.h(), 2);
                        } else {
                            i = 0;
                        }
                    } else {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    }
                    i = 5;
                }
                i = 2;
            } else {
                TiebaStatic.log(nm6Var.q());
                q16.c().i("page_recommend", "clk_", nm6Var.q());
                ff8.c(nm6Var.a, nm6Var.i(), nm6Var.h(), 1);
                i = 1;
            }
            if (i != 0) {
                ff8.d(nm6Var.a, this.a, nm6Var.h(), i);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            nm6.f1138T = "c10705";
            nm6.U = "c10730";
            nm6.V = "c10731";
            nm6.W = "c10704";
            nm6.X = "c10755";
            nm6.Y = "c10710";
            nm6.Z = "c10736";
            nm6.a0 = "c10737";
            nm6.b0 = "c10711";
            nm6.c0 = "c10758";
            nm6.d0 = "c10757";
        }
    }
}
