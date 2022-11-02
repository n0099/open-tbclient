package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.pushdialog.PushDialogVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes4.dex */
public class ie8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PushDialogActivity a;
    public Drawable b;
    public View c;
    public View d;
    public EditorScrollView e;
    public TbImageView f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public TbRichTextView j;
    public PushDialogVideoView k;
    public ClickableHeaderImageView l;
    public TextView m;
    public TextView n;
    public CommonUserLikeButton o;
    public View p;
    public TextView q;
    public im5 r;
    public long s;
    public rm5 t;
    public boolean u;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ie8 a;

        public a(ie8 ie8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ie8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ie8Var;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.u) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 1).param("tid", this.a.a.z1()));
                this.a.u = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ie8 a;

        public b(ie8 ie8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ie8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ie8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.a.y1() != null) {
                this.a.a.y1().d();
            }
        }
    }

    public ie8(PushDialogActivity pushDialogActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pushDialogActivity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.a = pushDialogActivity;
        pushDialogActivity.setContentView(i);
        this.d = d(R.id.obfuscated_res_0x7f091cc8);
        this.c = d(R.id.obfuscated_res_0x7f0907f0);
        EditorScrollView editorScrollView = (EditorScrollView) d(R.id.obfuscated_res_0x7f091b4f);
        this.e = editorScrollView;
        editorScrollView.setOverScrollMode(2);
        this.e.setListener(new a(this));
        if (this.c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            int j = xi.j(this.a);
            layoutParams.height = j / 2;
            layoutParams.topMargin = (int) (j * 0.22f);
            this.c.postInvalidate();
        }
        if (xi.C()) {
            Drawable a2 = hw8.a();
            this.b = a2;
            if (a2 != null && this.a.getWindow() != null) {
                this.a.getWindow().setBackgroundDrawable(this.b);
            }
        }
        View d = d(R.id.obfuscated_res_0x7f091b4d);
        this.p = d;
        d.setOnClickListener(this);
        this.q = (TextView) d(R.id.obfuscated_res_0x7f09069f);
        TbImageView tbImageView = (TbImageView) d(R.id.obfuscated_res_0x7f091b51);
        this.f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081833);
        this.f.setAutoChangeStyle(false);
        this.g = (TextView) d(R.id.obfuscated_res_0x7f091b52);
        this.i = (TextView) d(R.id.obfuscated_res_0x7f091b50);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) d(R.id.obfuscated_res_0x7f091b54);
        this.l = clickableHeaderImageView;
        clickableHeaderImageView.setBorderSurroundContent(true);
        this.l.setIsRound(true);
        this.l.setEnabled(false);
        this.l.setAutoChangeStyle(false);
        this.l.setBorderWidth(xi.g(this.a, R.dimen.tbds1));
        this.l.setBorderColor(ContextCompat.getColor(this.a, R.color.black_alpha15));
        this.r = new im5();
        TbRichTextView tbRichTextView = (TbRichTextView) d(R.id.obfuscated_res_0x7f091b4e);
        this.j = tbRichTextView;
        tbRichTextView.setTextColor(ContextCompat.getColor(this.a, R.color.CAM_X0107));
        this.r.s(xi.g(this.a, R.dimen.tbds38));
        this.r.v(xi.g(this.a, R.dimen.tbds42));
        this.r.j(xi.g(this.a, R.dimen.tbds23));
        this.r.o(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.r.i(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.j.setLayoutStrategy(this.r);
        PushDialogVideoView pushDialogVideoView = (PushDialogVideoView) d(R.id.obfuscated_res_0x7f091b57);
        this.k = pushDialogVideoView;
        pushDialogVideoView.setPageContext(this.a.getPageContext());
        this.m = (TextView) d(R.id.obfuscated_res_0x7f091b56);
        this.n = (TextView) d(R.id.obfuscated_res_0x7f091b53);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) d(R.id.obfuscated_res_0x7f091b55);
        this.o = commonUserLikeButton;
        commonUserLikeButton.setAfterOnClickListener(this);
        ImageView imageView = (ImageView) d(R.id.obfuscated_res_0x7f0907d2);
        this.h = imageView;
        imageView.setOnClickListener(this);
    }

    public final View d(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.a.findViewById(i);
        }
        return (View) invokeI.objValue;
    }

    public void e() {
        PushDialogVideoView pushDialogVideoView;
        rm5 rm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pushDialogVideoView = this.k) != null) {
            pushDialogVideoView.setNetworkChange();
            if (BdNetTypeUtil.isMobileNet() && this.k.y() && (rm5Var = this.t) != null && rm5Var.c() > 0 && this.t.b() > 0) {
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                double c = ((this.t.c() * (1.0f - ((this.k.getCurrentPosition() * 1.0f) / (this.t.b() * 1000)))) * 1.0f) / 1048576.0f;
                if (c >= 0.1d) {
                    xi.P(this.a.getPageContext().getPageActivity(), String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f98), decimalFormat.format(c)));
                }
            }
        }
    }

    public void f() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (pushDialogVideoView = this.k) != null) {
            pushDialogVideoView.A();
        }
    }

    public void g() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pushDialogVideoView = this.k) != null) {
            pushDialogVideoView.B();
        }
    }

    public void h() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (pushDialogVideoView = this.k) != null) {
            pushDialogVideoView.C();
        }
    }

    public void i(je8 je8Var) {
        boolean z;
        boolean z2;
        int g;
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, je8Var) != null) || je8Var == null) {
            return;
        }
        this.f.K(je8Var.a(), 17, false);
        this.g.setText(je8Var.b());
        if (je8Var.d() != null) {
            this.l.setData(je8Var.d());
            this.m.setText(je8Var.d().getName_show());
            if (je8Var.d().getGodUserData() != null && (!StringUtils.isNull(je8Var.d().getGodUserData().getForumName()) || !StringUtils.isNull(je8Var.d().getGodUserData().getIntro()))) {
                this.n.setText(je8Var.d().getGodUserData().getForumName() + "吧 " + je8Var.d().getGodIntro());
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(je8Var.d().getUserId())) {
                this.o.setVisibility(8);
            } else {
                new m05(this.a.getPageContext(), this.o).n(je8Var.d());
                this.o.g(0);
                this.o.setVisibility(0);
            }
            ke8 c = je8Var.c();
            if (c == null) {
                this.a.y1().d();
                this.a.finish();
                return;
            }
            if (c.a() != null && !ListUtils.isEmpty(c.a().B())) {
                z = false;
            } else {
                z = true;
            }
            if (StringUtils.isNull(c.d()) && z) {
                this.a.y1().d();
                this.a.finish();
                return;
            }
            if (c.a() != null) {
                Iterator<TbRichTextData> it = c.a().B().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        this.t = next.O();
                    }
                    if (this.t != null) {
                        break;
                    }
                }
            }
            this.s = c.c();
            if (this.t == null) {
                this.k.setVisibility(8);
                this.j.setVisibility(0);
                if (!BdNetTypeUtil.is4GNet() && !BdNetTypeUtil.isWifiNet()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.r.w(z2);
                if (z2) {
                    g = (xi.l(TbadkCoreApplication.getInst()) - (xi.g(this.a, R.dimen.tbds22) * 2)) - (xi.g(this.a, R.dimen.tbds44) * 2);
                    g2 = (int) (g * 1.618f);
                } else {
                    g = xi.g(this.a, R.dimen.tbds360);
                    g2 = xi.g(this.a, R.dimen.tbds202);
                }
                this.r.k(z2);
                this.r.q(g);
                this.r.p(g2);
                this.j.setText(c.a());
            } else {
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
                int l = xi.l(this.a) - xi.g(this.a, R.dimen.tbds132);
                layoutParams.width = l;
                layoutParams.height = (int) (l * 0.5625f);
                this.k.setLayoutParams(layoutParams);
                this.k.setTbRichTextVideoInfo(this.t);
                this.k.stopPlay();
                this.k.setThumbnail(this.t.d());
                this.k.setVideoUrl(this.t.e(), String.valueOf(this.s));
                this.k.E();
                uc8 uc8Var = new uc8();
                uc8Var.a = "15";
                uc8Var.c = String.valueOf(this.s);
                uc8Var.e = TbadkCoreApplication.getCurrentAccount();
                this.k.setVideoViewBusiness(uc8Var);
            }
            if (StringUtils.isNull(c.d())) {
                this.i.setVisibility(8);
            } else {
                this.i.setText(c.d());
                this.i.setVisibility(0);
            }
            this.q.setText(String.format(Locale.CHINA, this.a.getString(R.string.obfuscated_res_0x7f0f0343), Integer.valueOf(c.b())));
            if (!this.a.y1().c()) {
                this.a.y1().e();
                return;
            }
            return;
        }
        this.a.y1().d();
        this.a.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2 == this.h) {
                TiebaStatic.log(new StatisticItem("c13198").param("tid", this.a.z1()));
                zg.a().postDelayed(new b(this), 100L);
                this.a.finish();
            } else if (view2 == this.p) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 4).param("tid", this.a.z1()));
                if (this.s == 0) {
                    this.a.finish();
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(this.s + "", null, null)));
                this.a.y1().e();
                this.a.finish();
            } else if (view2 == this.o) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 3).param("tid", this.a.z1()));
            }
        }
    }
}
