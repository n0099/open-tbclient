package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.gp6;
import com.baidu.tieba.homepage.concern.view.ContentCollectView;
import com.baidu.tieba.homepage.concern.view.MatchCardView;
import com.baidu.tieba.ix5;
import com.baidu.tieba.jo6;
import com.baidu.tieba.l15;
import com.baidu.tieba.n56;
import com.baidu.tieba.s75;
import com.baidu.tieba.tw7;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ContentCollectListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<xn> b;
    public CornerType c;

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b();
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public final class ContentCollectViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ContentCollectView a;
        public ThreadData b;
        public gp6 c;
        public CornerType d;
        public final /* synthetic */ ContentCollectListAdapter e;

        /* loaded from: classes6.dex */
        public class a implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ContentCollectViewHolder a;

            public a(ContentCollectViewHolder contentCollectViewHolder, ContentCollectListAdapter contentCollectListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {contentCollectViewHolder, contentCollectListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = contentCollectViewHolder;
            }

            @Override // com.baidu.tieba.homepage.concern.adapter.ContentCollectListAdapter.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.b != null) {
                        ThreadCardUtils.jumpToPBCommentArea(this.a.b, this.a.e.a.getPageActivity(), 2, 0);
                    }
                    if (this.a.c != null) {
                        ContentCollectViewHolder contentCollectViewHolder = this.a;
                        contentCollectViewHolder.e.n(false, contentCollectViewHolder.c.q(), "clk_");
                        if (this.a.e.o()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                            statisticItem.param("obj_type", 2);
                            TiebaStatic.log(statisticItem);
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.homepage.concern.adapter.ContentCollectListAdapter.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.b != null) {
                        this.a.e.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.e.a.getPageActivity()).createNormalCfg(this.a.b.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR)));
                    }
                    if (this.a.c != null) {
                        ContentCollectViewHolder contentCollectViewHolder = this.a;
                        contentCollectViewHolder.e.n(false, contentCollectViewHolder.c.f(), "clk_");
                        if (this.a.e.o()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                            statisticItem.param("obj_type", 1);
                            TiebaStatic.log(statisticItem);
                        }
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentCollectViewHolder(ContentCollectListAdapter contentCollectListAdapter, ContentCollectView contentCollectView) {
            super(contentCollectView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, contentCollectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = contentCollectListAdapter;
            this.a = contentCollectView;
            contentCollectView.setCommonClickListener(new a(this, contentCollectListAdapter));
        }

        public void d(ThreadData threadData, gp6 gp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, gp6Var) == null) {
                this.b = threadData;
                this.c = gp6Var;
            }
        }

        public final void e(CornerType cornerType) {
            ContentCollectView contentCollectView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cornerType) == null) && (contentCollectView = this.a) != null && this.d != cornerType) {
                this.d = cornerType;
                if (cornerType == CornerType.ITEM) {
                    s75.d(contentCollectView).w(R.array.S_O_X002);
                    s75 d = s75.d(this.a);
                    d.o(R.string.J_X06);
                    d.f(R.color.CAM_X0205);
                } else if (cornerType == CornerType.FULL) {
                    s75.d(contentCollectView).w(R.array.obfuscated_res_0x7f030007);
                    s75 d2 = s75.d(this.a);
                    d2.o(R.string.J_X02);
                    d2.f(R.color.transparent);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class CoverCollectViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MatchCardView a;
        public CornerType b;
        public final /* synthetic */ ContentCollectListAdapter c;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tw7 a;
            public final /* synthetic */ CoverCollectViewHolder b;

            public a(CoverCollectViewHolder coverCollectViewHolder, tw7 tw7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {coverCollectViewHolder, tw7Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = coverCollectViewHolder;
                this.a = tw7Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.c.a != null && this.a.a() != null && this.a.a().topic_id.longValue() != 0) {
                    String valueOf = String.valueOf(this.a.a().topic_id);
                    if (NewWebHotTopicPageSwitch.isOn()) {
                        ix5.f(this.b.c.a, valueOf, null);
                    } else {
                        new HotTopicActivityConfig(view2.getContext()).createNormalConfig(valueOf, null, "1").start();
                    }
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                    statisticItem.param("obj_type", 1);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CoverCollectViewHolder(ContentCollectListAdapter contentCollectListAdapter, MatchCardView matchCardView) {
            super(matchCardView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, matchCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = contentCollectListAdapter;
            this.a = matchCardView;
        }

        public void b(tw7 tw7Var) {
            MatchCardView matchCardView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tw7Var) == null) && tw7Var != null && (matchCardView = this.a) != null) {
                matchCardView.setData(tw7Var);
                this.a.setOnClickListener(new a(this, tw7Var));
            }
        }

        public final void c(CornerType cornerType) {
            MatchCardView matchCardView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cornerType) == null) && (matchCardView = this.a) != null && this.b != cornerType) {
                this.b = cornerType;
                if (cornerType == CornerType.ITEM) {
                    s75.d(matchCardView).w(R.array.S_O_X002);
                    s75 d = s75.d(this.a);
                    d.o(R.string.J_X06);
                    d.f(R.color.CAM_X0205);
                } else if (cornerType == CornerType.FULL) {
                    s75.d(matchCardView).w(R.array.obfuscated_res_0x7f030007);
                    s75 d2 = s75.d(this.a);
                    d2.o(R.string.J_X02);
                    d2.f(R.color.transparent);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class CornerType {
        public static final /* synthetic */ CornerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CornerType FULL;
        public static final CornerType ITEM;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2108581978, "Lcom/baidu/tieba/homepage/concern/adapter/ContentCollectListAdapter$CornerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2108581978, "Lcom/baidu/tieba/homepage/concern/adapter/ContentCollectListAdapter$CornerType;");
                    return;
                }
            }
            FULL = new CornerType("FULL", 0);
            CornerType cornerType = new CornerType("ITEM", 1);
            ITEM = cornerType;
            $VALUES = new CornerType[]{FULL, cornerType};
        }

        public CornerType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CornerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CornerType) Enum.valueOf(CornerType.class, str);
            }
            return (CornerType) invokeL.objValue;
        }

        public static CornerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CornerType[]) $VALUES.clone();
            }
            return (CornerType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ gp6 b;
        public final /* synthetic */ ContentCollectListAdapter c;

        public a(ContentCollectListAdapter contentCollectListAdapter, ThreadData threadData, gp6 gp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectListAdapter, threadData, gp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = contentCollectListAdapter;
            this.a = threadData;
            this.b = gp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ThreadData threadData = this.a;
                if (threadData != null) {
                    ThreadCardUtils.jumpToPB((l15) threadData, (Context) this.c.a.getPageActivity(), 2, false);
                }
                gp6 gp6Var = this.b;
                if (gp6Var == null) {
                    return;
                }
                this.c.n(false, gp6Var.q(), "clk_");
                if (this.c.o()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                    statisticItem.param("obj_type", 2);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    public ContentCollectListAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = CornerType.ITEM;
        this.a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<xn> list = this.b;
            if (list != null && list.size() > i) {
                return this.b.get(i).getType().getId();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void p(CornerType cornerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cornerType) == null) {
            this.c = cornerType;
        }
    }

    public void q(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.b = list;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public final void n(boolean z, StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), statisticItem, str}) != null) || statisticItem == null) {
            return;
        }
        statisticItem.addParam("resource_id", 1);
        if (z) {
            jo6.b().a(statisticItem);
        } else {
            TiebaStatic.log(statisticItem);
        }
        if ("clk_".equals(str)) {
            jo6.b().d(true);
        }
        n56.c().i("page_recommend", str, statisticItem);
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isNotEmpty(this.b)) {
                for (xn xnVar : this.b) {
                    if (xnVar instanceof tw7) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        List<xn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, viewHolder, i) == null) && viewHolder != null && (list = this.b) != null && list.size() > i) {
            viewHolder.setIsRecyclable(false);
            xn xnVar = this.b.get(i);
            if ((xnVar instanceof tw7) && (viewHolder instanceof CoverCollectViewHolder)) {
                CoverCollectViewHolder coverCollectViewHolder = (CoverCollectViewHolder) viewHolder;
                coverCollectViewHolder.c(this.c);
                tw7 tw7Var = (tw7) xnVar;
                coverCollectViewHolder.b(tw7Var);
                if (!tw7Var.a) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_SHOW));
                    tw7Var.a = true;
                    return;
                }
                return;
            }
            ThreadData threadData = (ThreadData) this.b.get(i);
            if (threadData == null) {
                return;
            }
            ContentCollectViewHolder contentCollectViewHolder = (ContentCollectViewHolder) viewHolder;
            contentCollectViewHolder.e(this.c);
            contentCollectViewHolder.a.setData(threadData);
            gp6 gp6Var = new gp6();
            gp6Var.position = 0;
            gp6Var.a = threadData;
            gp6Var.position = i;
            n(true, gp6Var.s(), "show_");
            contentCollectViewHolder.d(threadData, gp6Var);
            contentCollectViewHolder.a.setOnClickListener(new a(this, threadData, gp6Var));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            if (i == tw7.c.getId()) {
                return new CoverCollectViewHolder(this, new MatchCardView(this.a));
            }
            return new ContentCollectViewHolder(this, new ContentCollectView(this.a));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
