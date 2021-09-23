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
import c.a.e.e.p.l;
import c.a.l.q;
import c.a.q0.s.u.c;
import c.a.r0.j3.i0.n;
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
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class CardItemInfoDownloadLayout extends FrameLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public static final String NO_ESTIMATE;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f51573e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f51574f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f51575g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f51576h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f51577i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f51578j;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoDownloadLayout f51579e;

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
            this.f51579e = cardItemInfoDownloadLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("rank_code", String.valueOf(this.f51579e.p));
                hashMap.put("rank_type", String.valueOf(this.f51579e.o));
                hashMap.put("home_tab_name", this.f51579e.s);
                hashMap.put("tab_id", String.valueOf(this.f51579e.r));
                hashMap.put("sort_type", this.f51579e.q);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(TbadkApplication.getInst().getApplicationContext(), "ItemRecommendList", hashMap)));
                this.f51579e.o(2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoDownloadLayout f51580e;

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
            this.f51580e = cardItemInfoDownloadLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = this.f51580e.f51576h.getWidth() <= 0 ? 0 : this.f51580e.f51576h.getWidth();
                if (width == 0) {
                    this.f51580e.f51573e.setPadding(CardItemInfoDownloadLayout.u, 0, CardItemInfoDownloadLayout.u, 0);
                    i2 = CardItemInfoDownloadLayout.u * 2;
                } else {
                    i2 = width + CardItemInfoDownloadLayout.u;
                }
                this.f51580e.k.setWidth(this.f51580e.f51573e.getWidth() - i2);
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
        NO_ESTIMATE = TbadkCoreApplication.getInst().getResources().getString(R.string.frs_evaluate_exception);
        u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005);
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
                EMTextView eMTextView = this.f51577i;
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
            this.f51576h.post(new b(this));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.frs_item_download_view, (ViewGroup) null);
            this.f51573e = viewGroup;
            viewGroup.setPadding(u, 0, 0, 0);
            this.f51574f = (LinearLayout) this.f51573e.findViewById(R.id.title_area);
            this.k = (EMTextView) this.f51573e.findViewById(R.id.item_name);
            this.f51575g = (LinearLayout) this.f51573e.findViewById(R.id.abstract_area);
            this.l = (EMTextView) this.f51573e.findViewById(R.id.item_score);
            RankStarView rankStarView = (RankStarView) this.f51573e.findViewById(R.id.item_rank_star);
            this.m = rankStarView;
            rankStarView.setStarSpacing(l.g(getContext(), R.dimen.M_W_X001));
            this.f51576h = (LinearLayout) this.f51573e.findViewById(R.id.hot_ranking_area);
            this.f51577i = (EMTextView) this.f51573e.findViewById(R.id.item_hot_ranking);
            this.f51578j = (ImageView) this.f51573e.findViewById(R.id.item_ranking_icon);
            this.f51576h.setOnClickListener(this.t);
            addView(this.f51573e, new FrameLayout.LayoutParams(-1, -2));
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003);
            setLayoutParams(marginLayoutParams);
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(6);
            bVar.m(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            c d2 = c.d(this.f51573e);
            d2.n(1);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            c d3 = c.d(this.k);
            d3.B(R.string.F_X02);
            d3.w(R.color.CAM_X0105);
            c.d(this.l).w(R.color.CAM_X0305);
            c.d(this.f51577i).w(R.color.CAM_X0311);
            WebPManager.setPureDrawable(this.f51578j, R.drawable.icon_pure_gamellist_right, R.color.CAM_X0311, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setBackgroundResource(this.f51576h, R.drawable.pic_bg_gamelistl);
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
                this.f51576h.setVisibility(0);
            } else {
                this.f51576h.setVisibility(8);
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
                d2.A(R.dimen.T_X06);
                d2.w(R.color.CAM_X0305);
                return;
            }
            c d3 = c.d(this.l);
            d3.A(R.dimen.T_X09);
            d3.w(R.color.CAM_X0109);
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
