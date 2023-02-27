package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b76 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public b c;
    public View d;
    public ThreadData e;
    public e36 f;
    public View.OnClickListener g;

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b76 a;

        public a(b76 b76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e != null && this.a.e.getAuthor() != null && !StringUtils.isNull(this.a.e.getAuthor().getUserId())) {
                long g = dh.g(this.a.e.getAuthor().getUserId(), 0L);
                if (g == dh.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    z = true;
                } else {
                    z = false;
                }
                d36.b().c();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.b.getPageActivity()).createNormalConfig(g, z, this.a.e.getAuthor().isBigV())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public TextView c;
        public TextView d;
        public RelativeLayout e;
        public ClickableHeaderImageView f;
        public TextView g;
        public TbImageView h;
        public RelativeLayout i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fec);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924e5);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924e4);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091db2);
            this.f = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fed);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924f2);
            this.i = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091db4);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924ee);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09151b);
            this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fee);
            this.l = view2.findViewById(R.id.obfuscated_res_0x7f091511);
            TextView textView = (TextView) view2.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view2.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07032c));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = (ej.l(view2.getContext()) - view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be)) / 2;
            this.o.leftMargin = (int) view2.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5);
            this.o.rightMargin = (int) view2.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5);
            this.n.bottomMargin = (int) view2.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070225);
            this.n.topMargin = (int) view2.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be);
            this.j.setTextSize(0, view2.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b3));
            layoutParams.height = layoutParams.width;
            this.i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.e.setLayoutParams(layoutParams);
        }
    }

    public b76(TbPageContext<?> tbPageContext) {
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
        this.a = 3;
        this.g = new a(this);
        this.b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00fa, (ViewGroup) null, false);
        this.d = inflate;
        this.c = new b(inflate);
        c().setOnClickListener(this);
        this.b.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public void g(e36 e36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e36Var) == null) {
            this.f = e36Var;
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public void d(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            if (threadData == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.e = threadData;
            this.c.b.setDrawerType(0);
            this.c.b.setBorderSurroundContent(true);
            this.c.b.setDrawBorder(true);
            this.c.b.K(this.e.getThreadAlaInfo().cover, 10, false);
            this.c.d.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0227, StringHelper.numberUniformFormatExtra(this.e.getThreadAlaInfo().audience_count)));
            this.c.f.setData(this.e);
            this.c.f.setIsRound(true);
            this.c.f.setBorderSurroundContent(true);
            this.c.j.setText(this.e.getTitle());
            if (this.e.getAuthor() != null) {
                String name_show = this.e.getAuthor().getName_show();
                if (fr5.f(name_show) > 10) {
                    name_show = fr5.n(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.c.g.setText(name_show);
            }
            this.c.l.setVisibility(0);
            this.c.c.setBackgroundResource(R.drawable.transparent_bg);
            this.c.c.setText(this.e.getThreadAlaInfo().label_name);
            this.c.c.setVisibility(0);
            if (this.e.getAuthor() != null && this.e.getAuthor().getAlaUserData() != null && !dj.isEmpty(this.e.getAuthor().getAlaUserData().great_anchor_icon)) {
                this.c.h.setVisibility(0);
                this.c.h.K(this.e.getAuthor().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.c.h.setVisibility(8);
            }
            this.c.g.setOnClickListener(this.g);
            e(this.b, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.a != i) {
            SkinManager.setBackgroundResource(this.c.e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.c.c, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.c.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.c.g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.c.j, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c.m, (int) R.color.CAM_X0101);
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ej.N(this.b.getPageActivity(), this.b.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            ThreadData threadData = this.e;
            if (threadData != null && threadData.getThreadAlaInfo() != null) {
                e36 e36Var = this.f;
                if (e36Var != null) {
                    e36Var.a(this.e);
                }
                d36.b().c();
                TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.e.getThreadAlaInfo().live_id));
            }
        }
    }
}
