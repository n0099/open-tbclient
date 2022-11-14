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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.pw4;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tx;
import com.baidu.tieba.wz4;
import com.baidu.tieba.yi;
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
/* loaded from: classes4.dex */
public class CardItemInfoDownloadLayout extends FrameLayout implements tx {
    public static /* synthetic */ Interceptable $ic;
    public static final String q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public LinearLayout b;
    public LinearLayout c;
    public LinearLayout d;
    public EMTextView e;
    public ImageView f;
    public EMTextView g;
    public EMTextView h;
    public RankStarView i;
    public Ranking j;
    public int k;
    public int l;
    public String m;
    public int n;
    public String o;
    public View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoDownloadLayout a;

        public a(CardItemInfoDownloadLayout cardItemInfoDownloadLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoDownloadLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemInfoDownloadLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("rank_code", String.valueOf(this.a.l));
                hashMap.put("rank_type", String.valueOf(this.a.k));
                hashMap.put("home_tab_name", this.a.o);
                hashMap.put(TiebaStatic.Params.TAB_ID, String.valueOf(this.a.n));
                hashMap.put("sort_type", this.a.m);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkApplication.getInst().getApplicationContext(), "ItemRecommendList", hashMap)));
                this.a.o(2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoDownloadLayout a;

        public b(CardItemInfoDownloadLayout cardItemInfoDownloadLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoDownloadLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemInfoDownloadLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            int width;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d.getWidth() <= 0) {
                    width = 0;
                } else {
                    width = this.a.d.getWidth();
                }
                if (width == 0) {
                    this.a.a.setPadding(CardItemInfoDownloadLayout.r, 0, CardItemInfoDownloadLayout.r, 0);
                    i = CardItemInfoDownloadLayout.r * 2;
                } else {
                    i = width + CardItemInfoDownloadLayout.r;
                }
                this.a.g.setWidth(this.a.a.getWidth() - i);
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
        q = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f06fb);
        r = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        n();
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                pw4 d = pw4.d(this.h);
                d.z(R.dimen.T_X06);
                d.v(R.color.CAM_X0305);
                return;
            }
            pw4 d2 = pw4.d(this.h);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0109);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoDownloadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        n();
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            wz4 wz4Var = new wz4(6);
            wz4Var.o(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, wz4Var));
        }
    }

    public void setHotRankingAreaVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void setRankStarVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.post(new b(this));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Ranking ranking = this.j;
            if (ranking != null && !StringUtils.isNull(ranking.name) && this.j.rank_num.intValue() > 0) {
                EMTextView eMTextView = this.e;
                Ranking ranking2 = this.j;
                eMTextView.setText(String.format("%s NO.%d", ranking2.name, ranking2.rank_num));
                o(1);
                return;
            }
            setHotRankingAreaVisibility(false);
        }
    }

    public final void l(ItemInfo itemInfo) {
        double d;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemInfo) == null) {
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null && (list = itemTable.item_point) != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null && "all".equals(itemPoint.time_intval)) {
                        d = itemPoint.point.doubleValue();
                        break;
                    }
                }
            }
            d = 0.0d;
            if (d > 0.0d && d <= 10.0d) {
                p(true);
                setRankStarVisibility(true);
                this.i.setStarCount((int) (d / 2.0d));
                this.h.setText(String.valueOf(d));
                return;
            }
            p(false);
            this.h.setText(q);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d032c, (ViewGroup) null);
            this.a = viewGroup;
            viewGroup.setPadding(r, 0, 0, 0);
            this.b = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09226b);
            this.g = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090feb);
            this.c = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09002a);
            this.h = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f091001);
            RankStarView rankStarView = (RankStarView) this.a.findViewById(R.id.obfuscated_res_0x7f090ff0);
            this.i = rankStarView;
            rankStarView.setStarSpacing(yi.g(getContext(), R.dimen.M_W_X001));
            this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090e00);
            this.e = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090fdd);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090ff2);
            this.d.setOnClickListener(this.p);
            addView(this.a, new FrameLayout.LayoutParams(-1, -2));
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003);
            setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.tx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            pw4 d = pw4.d(this.a);
            d.m(1);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            pw4 d2 = pw4.d(this.g);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            pw4.d(this.h).v(R.color.CAM_X0305);
            pw4.d(this.e).v(R.color.CAM_X0311);
            WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080976, R.color.CAM_X0311, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setBackgroundResource(this.d, R.drawable.pic_bg_gamelistl);
            this.i.e(i);
        }
    }

    public void setData(ItemInfo itemInfo) {
        RankingParam rankingParam;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, itemInfo) != null) || itemInfo == null) {
            return;
        }
        Ranking ranking = itemInfo.ranking;
        this.j = ranking;
        if (ranking != null && (rankingParam = ranking.ranking_param) != null) {
            this.l = rankingParam.rank_code.intValue();
            this.k = rankingParam.rank_type.intValue();
            this.m = rankingParam.sort_type;
            this.n = rankingParam.tab_id.intValue();
        }
        this.g.setText(itemInfo.name);
        this.o = itemInfo.template_name;
        l(itemInfo);
        k();
        m();
    }
}
