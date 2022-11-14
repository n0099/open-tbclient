package com.baidu.tieba;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterChangeView;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterForumView;
import com.baidu.tieba.jv4;
import com.baidu.tieba.zy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ag6 implements View.OnClickListener, zf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public az4 c;
    public RelativeLayout d;
    public NoNetworkView e;
    public PbListView f;
    public View g;
    public RelativeLayout h;
    public TextView i;
    public ImageView j;
    public sf6 k;
    public EmotionCenterForumView l;
    public EmotionCenterChangeView m;
    public tf6 n;
    public EmotionCenterData o;
    public xf6 p;
    public LinearLayout q;
    public ImageView r;
    public TextView s;
    public Animation t;
    public boolean u;
    public int v;
    public String w;
    public ia5 x;

    /* loaded from: classes3.dex */
    public class a implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    public ag6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = true;
        this.v = 0;
        this.w = "";
        this.a = tbPageContext;
        this.d = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02d8, (ViewGroup) null);
        this.e = new NoNetworkView(tbPageContext.getPageActivity());
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.e.setVisibility(8);
        }
        this.d.addView(this.e);
        BdTypeListView bdTypeListView = (BdTypeListView) this.d.findViewById(R.id.obfuscated_res_0x7f0908ad);
        this.b = bdTypeListView;
        bdTypeListView.setDivider(null);
        az4 az4Var = new az4(this.a);
        this.c = az4Var;
        az4Var.b0(bdUniqueId);
        this.b.setPullRefresh(this.c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f = pbListView;
        pbListView.a();
        sf6 sf6Var = new sf6(this.a);
        this.k = sf6Var;
        sf6Var.c().setVisibility(8);
        EmotionCenterForumView emotionCenterForumView = new EmotionCenterForumView(this.a);
        this.l = emotionCenterForumView;
        emotionCenterForumView.setVisibility(8);
        this.n = new tf6(this.a, this.b);
        EmotionCenterChangeView emotionCenterChangeView = new EmotionCenterChangeView(this.a);
        this.m = emotionCenterChangeView;
        emotionCenterChangeView.setVisibility(8);
        this.b.addHeaderView(this.k.c());
        this.b.addHeaderView(this.l);
        this.b.addHeaderView(this.m);
        this.g = this.d.findViewById(R.id.obfuscated_res_0x7f0908ab);
        this.h = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0908ab);
        this.i = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090115);
        this.j = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090e4a);
        this.g.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0908f3);
        this.q = linearLayout;
        linearLayout.setClickable(false);
        this.q.setOnClickListener(this);
        this.q.setVisibility(8);
        this.r = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0924d2);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090117);
        t();
    }

    @Override // com.baidu.tieba.zf6
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageActivity(), 25021)));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.z();
        }
    }

    public void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (imageView = this.r) != null) {
            imageView.clearAnimation();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public ViewGroup i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public EmotionCenterChangeView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.m;
        }
        return (EmotionCenterChangeView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.b.setNextPage(null);
        }
    }

    public void l() {
        ia5 ia5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (ia5Var = this.x) != null) {
            ia5Var.dettachView(this.d);
            this.x = null;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            xf6 xf6Var = this.p;
            if (xf6Var != null) {
                xf6Var.dismiss();
            }
            e();
            this.q.setVisibility(8);
            this.g.setVisibility(0);
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (pbListView = this.f) != null) {
            if (pbListView.b().getParent() == null) {
                this.b.setNextPage(this.f);
            }
            this.f.Q();
            this.f.S();
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (tbPageContext = this.a) != null && this.d != null) {
            ia5 ia5Var = new ia5(tbPageContext.getPageActivity());
            this.x = ia5Var;
            ia5Var.attachView(this.d, false);
            this.x.onChangeSkinType();
        }
    }

    public void v() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (imageView = this.r) != null) {
            imageView.startAnimation(g());
        }
    }

    @Override // com.baidu.tieba.zf6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.v == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageActivity(), true, 25021)));
            } else if (!TextUtils.isEmpty(this.w)) {
                jv4 jv4Var = new jv4(this.a.getPageActivity());
                jv4Var.setMessage(this.w);
                jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0440, new a(this));
                jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new b(this));
                jv4Var.create(this.a).show();
            }
        }
    }

    public void c(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emotionCenterData) != null) || emotionCenterData == null) {
            return;
        }
        this.o = emotionCenterData;
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                vf6 vf6Var = new vf6();
                vf6Var.a = emotionPackageData;
                arrayList.add(vf6Var);
            }
            this.n.a(arrayList);
        }
        this.n.c();
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.t == null) {
                this.t = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.obfuscated_res_0x7f010108);
                this.t.setInterpolator(new LinearInterpolator());
                this.t.setFillAfter(true);
            }
            return this.t;
        }
        return (Animation) invokeV.objValue;
    }

    public void u() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (pbListView = this.f) != null) {
            if (pbListView.b().getParent() == null) {
                this.b.setNextPage(this.f);
            }
            this.f.E(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1c));
            this.f.f();
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f.q(R.color.CAM_X0204);
            this.f.d(i);
            this.c.H(i);
            this.n.c();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.e.d(this.a, i);
            EmotionCenterForumView emotionCenterForumView = this.l;
            if (emotionCenterForumView != null) {
                emotionCenterForumView.b(i);
            }
            RelativeLayout relativeLayout = this.h;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, R.color.cp_bg_line_d_alpha90, i);
            }
            TextView textView = this.i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            if (this.q != null) {
                SkinManager.setBackgroundColor(this.h, R.color.cp_bg_line_d_alpha90, i);
            }
            ImageView imageView2 = this.r;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void o(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, emotionCenterData) != null) || emotionCenterData == null) {
            return;
        }
        l();
        if (ListUtils.isEmpty(this.m.getDataList())) {
            this.m.d();
            this.m.setVisibility(0);
        }
        this.o = emotionCenterData;
        if (this.u) {
            this.v = xg.e(emotionCenterData.is_bazhu, 0);
            this.w = emotionCenterData.bazhu_message;
            this.u = false;
        }
        if (emotionCenterData.banner != null) {
            this.k.c().setVisibility(0);
            this.k.f(this.a.getUniqueId());
            this.k.e(new wf6(emotionCenterData.banner));
            this.k.g();
        }
        if (emotionCenterData.forum != null) {
            this.l.setVisibility(0);
            this.l.setData(emotionCenterData.forum);
        }
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new uf6());
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                vf6 vf6Var = new vf6();
                vf6Var.a = emotionPackageData;
                arrayList.add(vf6Var);
            }
            this.n.d(arrayList);
        }
        this.n.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            boolean z = false;
            if (view2 == this.g) {
                if (this.o == null) {
                    return;
                }
                if (this.v != 0) {
                    if (this.p == null) {
                        xf6 xf6Var = new xf6(this.a.getPageActivity(), this.v);
                        this.p = xf6Var;
                        xf6Var.d(this);
                    }
                    this.p.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.a.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.p.showAtLocation(this.d, 81, 0, this.a.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                a();
            } else if (view2 == this.q) {
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = this.a.getPageActivity();
                if (this.v == 1) {
                    z = true;
                }
                messageManager.sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(pageActivity, z, 25021)));
            }
        }
    }

    public void p(zy4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.c.f(gVar);
        }
    }

    public void q(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pVar) == null) {
            this.b.setOnSrollToBottomListener(pVar);
        }
    }

    public void x(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, emotionPackageData) != null) || emotionPackageData == null) {
            return;
        }
        EmotionCenterChangeView emotionCenterChangeView = this.m;
        if (emotionCenterChangeView != null) {
            emotionCenterChangeView.f(emotionPackageData);
        }
        tf6 tf6Var = this.n;
        if (tf6Var != null) {
            tf6Var.e(emotionPackageData);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            xf6 xf6Var = this.p;
            if (xf6Var != null) {
                xf6Var.dismiss();
            }
            v();
            this.q.setVisibility(0);
            this.g.setVisibility(8);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0201);
            SkinManager.setImageResource(this.r, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0302);
            this.s.setText(R.string.obfuscated_res_0x7f0f0587);
            this.q.setClickable(false);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            xf6 xf6Var = this.p;
            if (xf6Var != null) {
                xf6Var.dismiss();
            }
            e();
            this.q.setVisibility(0);
            this.g.setVisibility(8);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0201);
            SkinManager.setImageResource(this.r, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.s, (int) R.color.common_color_10037);
            this.s.setText(R.string.obfuscated_res_0x7f0f0560);
            this.q.setClickable(true);
        }
    }
}
