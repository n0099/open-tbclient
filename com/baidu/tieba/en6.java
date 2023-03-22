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
/* loaded from: classes4.dex */
public class en6 {
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
    public gn6 w;
    public View.OnClickListener x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ en6 a;

        public a(en6 en6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {en6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = en6Var;
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

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ en6 a;

        public b(en6 en6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {en6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = en6Var;
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

    public en6(View view2, String str, long j) {
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
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cf4);
        this.e = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924a3);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cee);
        this.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09104a);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091049);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091031);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091064);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091063);
        IrregularImageView irregularImageView = (IrregularImageView) view2.findViewById(R.id.obfuscated_res_0x7f091073);
        this.m = irregularImageView;
        irregularImageView.setErrorRes(R.drawable.obfuscated_res_0x7f080ff5);
        this.h.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0811cf, 1, false));
        this.i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0811cb, 1, false));
        this.j.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0811cd, 1, false));
        this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0811cc, 1, false));
        this.l.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0811ce, 1, false));
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092310);
        this.n = textView2;
        textView2.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0954));
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f19);
        this.o = relativeLayout;
        relativeLayout.setOnClickListener(new a(this));
        this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f1b);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f1c);
        this.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f1d);
        this.r = (ImageOverlayView) view2.findViewById(R.id.obfuscated_res_0x7f090f1e);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.r.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.r.setStrokeStyle(1);
        this.r.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.r.setLoadImageType(12);
        this.s = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f1a);
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

    public void k(gn6 gn6Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, gn6Var, z) == null) {
            this.w = gn6Var;
            if (gn6Var == null) {
                return;
            }
            this.e.setText(gn6Var.a);
            if (gn6Var.c != null) {
                String str = gn6Var.b;
                if (dq5.f(str) > 10) {
                    str = dq5.n(gn6Var.b, 10) + StringHelper.STRING_MORE;
                }
                this.f.setText(String.format(this.d.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0957), str));
            }
            if (gn6Var.d == 0) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(String.format(this.d.getContext().getString(R.string.obfuscated_res_0x7f0f0953), StringHelper.getDateStringMdChinease(gn6Var.d * 1000)));
            }
            this.m.setImage(gn6Var.e, h(this.d.getContext()), R.drawable.obfuscated_res_0x7f080dd6);
            TiebaFieldsInfo tiebaFieldsInfo = gn6Var.f;
            if (tiebaFieldsInfo != null && !z && !TextUtils.isEmpty(tiebaFieldsInfo.tieba_name)) {
                this.o.setVisibility(0);
                this.q.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), gn6Var.f.tieba_name));
                List<String> i = i(gn6Var.f.user_rank);
                this.r.setData(i);
                g(i);
                this.u = gn6Var.f.tieba_name;
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
