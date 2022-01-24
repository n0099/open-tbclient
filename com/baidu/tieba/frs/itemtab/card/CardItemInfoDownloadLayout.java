package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.l.q;
import c.a.s0.s.u.c;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.e1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import c.a.t0.x3.j0.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
import tbclient.Ranking;
import tbclient.RankingParam;
/* loaded from: classes12.dex */
public class CardItemInfoDownloadLayout extends FrameLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public static final String NO_ESTIMATE;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f43599e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f43600f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f43601g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f43602h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f43603i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f43604j;
    public EMTextView k;
    public EMTextView l;
    public RankStarView m;
    public Ranking n;
    public int o;
    public int p;
    public String q;
    public int r;
    public String s;
    public View.OnClickListener t;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoDownloadLayout f43605e;

        public a(CardItemInfoDownloadLayout cardItemInfoDownloadLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoDownloadLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43605e = cardItemInfoDownloadLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("rank_code", String.valueOf(this.f43605e.p));
                hashMap.put("rank_type", String.valueOf(this.f43605e.o));
                hashMap.put("home_tab_name", this.f43605e.s);
                hashMap.put("tab_id", String.valueOf(this.f43605e.r));
                hashMap.put("sort_type", this.f43605e.q);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(TbadkApplication.getInst().getApplicationContext(), "ItemRecommendList", hashMap)));
                this.f43605e.o(2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoDownloadLayout f43606e;

        public b(CardItemInfoDownloadLayout cardItemInfoDownloadLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoDownloadLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43606e = cardItemInfoDownloadLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = this.f43606e.f43602h.getWidth() <= 0 ? 0 : this.f43606e.f43602h.getWidth();
                if (width == 0) {
                    this.f43606e.f43599e.setPadding(CardItemInfoDownloadLayout.u, 0, CardItemInfoDownloadLayout.u, 0);
                    i2 = CardItemInfoDownloadLayout.u * 2;
                } else {
                    i2 = width + CardItemInfoDownloadLayout.u;
                }
                this.f43606e.k.setWidth(this.f43606e.f43599e.getWidth() - i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1762014652, "Lcom/baidu/tieba/frs/itemtab/card/CardItemInfoDownloadLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1762014652, "Lcom/baidu/tieba/frs/itemtab/card/CardItemInfoDownloadLayout;");
                return;
            }
        }
        NO_ESTIMATE = TbadkCoreApplication.getInst().getResources().getString(i1.frs_evaluate_exception);
        u = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X005);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoDownloadLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = new a(this);
        n();
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Ranking ranking = this.n;
            if (ranking != null && !StringUtils.isNull(ranking.name) && this.n.rank_num.intValue() > 0) {
                EMTextView eMTextView = this.f43603i;
                Ranking ranking2 = this.n;
                eMTextView.setText(String.format("%s NO.%d", ranking2.name, ranking2.rank_num));
                o(1);
                return;
            }
            setHotRankingAreaVisibility(false);
        }
    }

    public final void l(ItemInfo itemInfo) {
        double d2;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemInfo) == null) {
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null && (list = itemTable.item_point) != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null && "all".equals(itemPoint.time_intval)) {
                        d2 = itemPoint.point.doubleValue();
                        break;
                    }
                }
            }
            d2 = 0.0d;
            if (d2 > 0.0d && d2 <= 10.0d) {
                updateScoreView(true);
                setRankStarVisibility(true);
                this.m.setStarCount((int) (d2 / 2.0d));
                this.l.setText(String.valueOf(d2));
                return;
            }
            updateScoreView(false);
            this.l.setText(NO_ESTIMATE);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43602h.post(new b(this));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(g1.frs_item_download_view, (ViewGroup) null);
            this.f43599e = viewGroup;
            viewGroup.setPadding(u, 0, 0, 0);
            this.f43600f = (LinearLayout) this.f43599e.findViewById(f1.title_area);
            this.k = (EMTextView) this.f43599e.findViewById(f1.item_name);
            this.f43601g = (LinearLayout) this.f43599e.findViewById(f1.abstract_area);
            this.l = (EMTextView) this.f43599e.findViewById(f1.item_score);
            RankStarView rankStarView = (RankStarView) this.f43599e.findViewById(f1.item_rank_star);
            this.m = rankStarView;
            rankStarView.setStarSpacing(c.a.d.f.p.n.f(getContext(), d1.M_W_X001));
            this.f43602h = (LinearLayout) this.f43599e.findViewById(f1.hot_ranking_area);
            this.f43603i = (EMTextView) this.f43599e.findViewById(f1.item_hot_ranking);
            this.f43604j = (ImageView) this.f43599e.findViewById(f1.item_ranking_icon);
            this.f43602h.setOnClickListener(this.t);
            addView(this.f43599e, new FrameLayout.LayoutParams(-1, -2));
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), d1.M_H_X003);
            setLayoutParams(marginLayoutParams);
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            c.a.s0.s.k0.p.b bVar = new c.a.s0.s.k0.p.b(6);
            bVar.o(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            c d2 = c.d(this.f43599e);
            d2.m(1);
            d2.n(i1.J_X06);
            d2.f(c1.CAM_X0201);
            c d3 = c.d(this.k);
            d3.A(i1.F_X02);
            d3.v(c1.CAM_X0105);
            c.d(this.l).v(c1.CAM_X0305);
            c.d(this.f43603i).v(c1.CAM_X0311);
            WebPManager.setPureDrawable(this.f43604j, e1.icon_pure_gamellist_right, c1.CAM_X0311, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setBackgroundResource(this.f43602h, e1.pic_bg_gamelistl);
            this.m.onChangeSkinType(i2);
        }
    }

    public void setData(ItemInfo itemInfo) {
        RankingParam rankingParam;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, itemInfo) == null) || itemInfo == null) {
            return;
        }
        Ranking ranking = itemInfo.ranking;
        this.n = ranking;
        if (ranking != null && (rankingParam = ranking.ranking_param) != null) {
            this.p = rankingParam.rank_code.intValue();
            this.o = rankingParam.rank_type.intValue();
            this.q = rankingParam.sort_type;
            this.r = rankingParam.tab_id.intValue();
        }
        this.k.setText(itemInfo.name);
        this.s = itemInfo.template_name;
        l(itemInfo);
        k();
        m();
    }

    public void setHotRankingAreaVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.f43602h.setVisibility(0);
            } else {
                this.f43602h.setVisibility(8);
            }
        }
    }

    public void setRankStarVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
    }

    public void updateScoreView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                c d2 = c.d(this.l);
                d2.z(d1.T_X06);
                d2.v(c1.CAM_X0305);
                return;
            }
            c d3 = c.d(this.l);
            d3.z(d1.T_X09);
            d3.v(c1.CAM_X0109);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoDownloadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.t = new a(this);
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoDownloadLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.t = new a(this);
        n();
    }
}
