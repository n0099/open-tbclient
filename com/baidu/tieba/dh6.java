package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.yg6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class dh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbPageContext<BaseFragmentActivity> b;
    public BdListView c;
    public yg6 d;
    public HeadImageView e;
    public TextView f;
    public TextView g;
    public TbImageView h;
    public RelativeLayout i;
    public ImageView j;
    public TextView k;
    public LinearLayout l;
    public AlaNetRefreshView m;
    public RelativeLayout n;
    public TextView o;
    public View p;
    public c q;
    public List<AlaLiveMarkData> r;
    public yg6.d s;

    /* loaded from: classes5.dex */
    public interface c {
        void a(ah6 ah6Var);
    }

    /* loaded from: classes5.dex */
    public class a extends qg<in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public a(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, inVar, str, i) == null) {
                super.onLoaded((a) inVar, str, i);
                if (inVar != null && inVar.p() != null) {
                    this.a.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.a.h.setImageBitmap(BitmapHelper.fastblur(inVar.p(), 15, 0.75f));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements yg6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public b(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // com.baidu.tieba.yg6.d
        public void a(ah6 ah6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ah6Var) == null) && this.a.q != null) {
                this.a.q.a(ah6Var);
            }
        }
    }

    public dh6(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new ArrayList();
        this.s = new b(this);
        this.b = tbPageContext;
        this.q = cVar;
        e();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alaNetRefreshView = this.m) != null) {
            alaNetRefreshView.dettachView(this.n);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00e5, (ViewGroup) null);
            this.a = inflate;
            inflate.setPadding(0, (int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275), 0, 0);
            this.e = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090226);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090227);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090224);
            this.h = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090223);
            this.n = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09022a);
            this.l = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090225);
            this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090228);
            this.j = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909dc);
            this.k = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909de);
            this.p = this.a.findViewById(R.id.obfuscated_res_0x7f09022b);
            this.c = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f090229);
            yg6 yg6Var = new yg6(this.b, this.s);
            this.d = yg6Var;
            this.c.setAdapter((ListAdapter) yg6Var);
            RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909e9);
            this.i = relativeLayout;
            this.c.setEmptyView(relativeLayout);
            this.e.setIsRound(true);
            this.e.setDefaultBgResource(R.color.transparent);
            this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h.setDefaultBgResource(R.color.transparent);
            this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f, (int) R.color.common_color_10310);
            SkinManager.setViewTextColor(this.g, (int) R.color.white_alpha70);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0106);
            this.j.setAlpha(1.0f);
            this.p.setBackgroundColor(this.b.getResources().getColor(R.color.black_alpha30));
        }
    }

    public void g(AlaUserInfoData alaUserInfoData, List<bh6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, alaUserInfoData, list) == null) {
            yg6 yg6Var = this.d;
            if (yg6Var != null && list != null) {
                yg6Var.d(list);
            }
            i(alaUserInfoData);
        }
    }

    public void h(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), onClickListener}) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new AlaNetRefreshView(tbPageContext.getPageActivity());
        }
        this.m.setImageResource(i);
        this.m.setNetFailTipText(this.b.getString(i2));
        this.m.onChangeSkinType();
        this.m.setIsShowRefreshButton(z);
        if (z) {
            this.m.setOnRefreshClickListener(onClickListener);
        }
        this.m.attachView(this.n);
    }

    public final void i(AlaUserInfoData alaUserInfoData) {
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, alaUserInfoData) == null) {
            if (alaUserInfoData != null) {
                String str = alaUserInfoData.user_nickname;
                String str2 = alaUserInfoData.user_name;
                if (str == null) {
                    if (str2 != null) {
                        str = str2;
                    } else {
                        str = TbadkCoreApplication.getCurrentAccountNameShow();
                    }
                }
                String str3 = alaUserInfoData.portrait;
                if (str3 == null) {
                    str3 = TbadkCoreApplication.getCurrentPortrait();
                }
                if (alaUserInfoData.mark_count == null) {
                    format = String.format(this.b.getString(R.string.obfuscated_res_0x7f0f021c), 0);
                } else {
                    format = String.format(this.b.getString(R.string.obfuscated_res_0x7f0f021c), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
                }
                j(str3, str, format);
                int dimension = (int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f070207);
                List<AlaLiveMarkData> list = this.r;
                if (list != null && list.size() > 0) {
                    this.r.clear();
                }
                LinearLayout linearLayout = this.l;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                    List<AlaLiveMarkData> list2 = alaUserInfoData.live_mark_info_new;
                    this.r = list2;
                    if (list2 != null) {
                        for (int i = 0; i < this.r.size(); i++) {
                            TbImageView tbImageView = new TbImageView(this.b.getPageActivity());
                            tbImageView.setDefaultBgResource(R.color.transparent);
                            tbImageView.N(this.r.get(i).mark_pic, 21, false);
                            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f07035d);
                            this.l.addView(tbImageView);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            j(TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountNameShow(), String.format(this.b.getString(R.string.obfuscated_res_0x7f0f021c), 0));
            List<AlaLiveMarkData> list3 = this.r;
            if (list3 != null && list3.size() > 0) {
                this.r.clear();
            }
            LinearLayout linearLayout2 = this.l;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
        }
    }

    public final void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            if (!StringUtils.isNull(str)) {
                this.e.N(str, 25, false);
                rg.h().m(str, 25, new a(this), null);
            } else {
                this.e.N(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
                this.h.N(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            }
            if (!StringUtils.isNull(str2)) {
                this.f.setText(str2);
            } else {
                this.f.setText("");
            }
            if (!StringUtils.isNull(str3)) {
                this.g.setText(str3);
            } else {
                this.g.setText("");
            }
        }
    }
}
