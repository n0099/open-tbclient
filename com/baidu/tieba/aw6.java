package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.TiebaFieldsInfo;
import tbclient.User;
/* loaded from: classes5.dex */
public class aw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final long b;
    public int c;
    public View d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public IrregularImageView m;
    public TextView n;
    public RelativeLayout o;
    public ImageView p;
    public TextView q;
    public ImageOverlayView r;
    public ImageView s;
    public ImageView t;
    public String u;
    public View v;
    public cw6 w;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw6 a;

        public a(aw6 aw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b > 0) {
                    StatisticItem statisticItem = new StatisticItem("c13671");
                    statisticItem.param("fid", this.a.b);
                    TiebaStatic.log(statisticItem);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.d.getContext());
                hotUserRankActivityConfig.setCategory(this.a.u);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw6 a;

        public b(aw6 aw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == this.a.v.getId() && this.a.w != null && this.a.w.c != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.d.getContext(), this.a.w.c.getUserId(), this.a.w.c.getName_show())));
                if (!TextUtils.isEmpty(this.a.a)) {
                    StatisticItem statisticItem = new StatisticItem("c13659");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("resource_id", this.a.w.a);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.w.c.rankNum);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13683");
                statisticItem2.param("uid", this.a.w.c.getUserId());
                statisticItem2.param("fid", this.a.b);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    public aw6(View view2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 3;
        this.x = new b(this);
        this.d = view2;
        this.a = str;
        this.b = j;
        View findViewById = view2.findViewById(R.id.top_container);
        this.v = findViewById;
        findViewById.setOnClickListener(this.x);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e48);
        this.e = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092659);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e42);
        this.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910fe);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910fd);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910e5);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091119);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091118);
        IrregularImageView irregularImageView = (IrregularImageView) view2.findViewById(R.id.obfuscated_res_0x7f091128);
        this.m = irregularImageView;
        irregularImageView.setErrorRes(R.drawable.obfuscated_res_0x7f081213);
        this.h.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f08140f, 1, false));
        this.i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f08140b, 1, false));
        this.j.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f08140d, 1, false));
        this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f08140c, 1, false));
        this.l.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f08140e, 1, false));
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b3);
        this.n = textView2;
        textView2.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0a3c));
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090fb6);
        this.o = relativeLayout;
        relativeLayout.setOnClickListener(new a(this));
        this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fb8);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fb9);
        this.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fba);
        this.r = (ImageOverlayView) view2.findViewById(R.id.obfuscated_res_0x7f090fbb);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.r.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.r.setStrokeStyle(1);
        this.r.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.r.setLoadImageType(12);
        this.s = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fb7);
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            int count = ListUtils.getCount(list);
            if (count == 0) {
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(0);
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
            if (count < 3) {
                int i = 3 - count;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams.rightMargin = dimensionPixelOffset - (i * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
                this.t.setLayoutParams(layoutParams);
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.c != i) {
            this.c = i;
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.p, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.t, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.s, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            this.r.d();
        }
    }

    public BdUniqueId h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext().getUniqueId();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeL.objValue;
    }

    public final List<String> i(List<User> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (User user : list) {
                if (user != null) {
                    arrayList.add(user.portrait);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void k(cw6 cw6Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, cw6Var, z) == null) {
            this.w = cw6Var;
            if (cw6Var == null) {
                return;
            }
            this.e.setText(cw6Var.a);
            if (cw6Var.c != null) {
                String str = cw6Var.b;
                if (ns5.e(str) > 10) {
                    str = ns5.m(cw6Var.b, 10) + "...";
                }
                this.f.setText(String.format(this.d.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0a3f), str));
            }
            if (cw6Var.d == 0) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(String.format(this.d.getContext().getString(R.string.obfuscated_res_0x7f0f0a3b), StringHelper.getDateStringMdChinease(cw6Var.d * 1000)));
            }
            this.m.setImage(cw6Var.e, h(this.d.getContext()), R.drawable.obfuscated_res_0x7f080f99);
            TiebaFieldsInfo tiebaFieldsInfo = cw6Var.f;
            if (tiebaFieldsInfo != null && !z && !TextUtils.isEmpty(tiebaFieldsInfo.tieba_name)) {
                this.o.setVisibility(0);
                this.q.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), cw6Var.f.tieba_name));
                List<String> i = i(cw6Var.f.user_rank);
                this.r.setData(i);
                g(i);
                this.u = cw6Var.f.tieba_name;
                if (this.b > 0) {
                    StatisticItem statisticItem = new StatisticItem("c13670");
                    statisticItem.param("fid", this.b);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            this.o.setVisibility(8);
        }
    }
}
