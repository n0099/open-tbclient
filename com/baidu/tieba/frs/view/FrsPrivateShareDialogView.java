package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dr4;
import com.repackage.mq6;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.xd6;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public LinearLayout b;
    public LinearGradientView c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public BarImageView g;
    public HeadImageView h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public ImageView l;
    public RelativeLayout m;
    public ImageOverlayView n;
    public HeadImageView o;
    public TextView p;
    public TextView q;
    public FrsViewData r;
    public TbPageContext s;
    public dr4 t;
    public ForumActiveInfo u;
    public String v;
    public xd6 w;
    public xd6.e x;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsPrivateShareDialogView a;

        public a(FrsPrivateShareDialogView frsPrivateShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPrivateShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsPrivateShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.t != null && this.a.t.isShowing()) {
                this.a.t.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements xd6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsPrivateShareDialogView a;

        public b(FrsPrivateShareDialogView frsPrivateShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPrivateShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsPrivateShareDialogView;
        }

        @Override // com.repackage.xd6.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.g(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPrivateShareDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = new b(this);
        this.a = context;
    }

    public final void c(FrsViewData frsViewData) {
        ForumActiveInfo forumActiveInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frsViewData) == null) || frsViewData == null) {
            return;
        }
        if (frsViewData.getForum() != null) {
            this.e.setVisibility(0);
            TextView textView = this.e;
            textView.setText(frsViewData.getForum().getName() + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0443));
            this.v = frsViewData.getForum().getName();
        } else {
            this.e.setVisibility(8);
        }
        if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
            this.g.K(frsViewData.getForum().getImage_url(), 10, false);
        }
        if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
            this.h.K(frsViewData.getUserData().getPortrait(), 12, false);
        } else {
            this.h.K(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
        }
        if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
            this.p.setText(frsViewData.getUserData().getName_show());
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
        if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
            this.f.setText(frsViewData.getForumActiveInfo().forum_brief);
        } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
            this.f.setText(frsViewData.getForum().getSlogan());
        } else {
            this.f.setText(getResources().getString(R.string.obfuscated_res_0x7f0f071e));
        }
        if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
            this.q.setVisibility(0);
            this.q.setText(R.string.obfuscated_res_0x7f0f02eb);
        } else {
            this.q.setVisibility(8);
        }
        if (frsViewData.getForum() != null) {
            e(mq6.c(frsViewData.getForum()));
        }
        if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
            TextView textView2 = this.k;
            textView2.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.obfuscated_res_0x7f0f02d1));
        } else {
            this.k.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1549));
        }
        ArrayList arrayList = new ArrayList();
        if (frsViewData.userList != null) {
            for (int i = 0; i < frsViewData.userList.size() && !StringUtils.isNull(frsViewData.userList.get(i).portrait); i++) {
                arrayList.add(frsViewData.userList.get(i).portrait);
                if (arrayList.size() >= 5) {
                    break;
                }
            }
        }
        if (arrayList.size() > 0) {
            this.n.setData(arrayList);
            this.n.setVisibility(0);
            this.o.setVisibility(8);
        } else {
            this.n.setVisibility(8);
            this.o.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.o.K(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.o.K(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
        if (this.w == null || (forumActiveInfo = this.u) == null) {
            return;
        }
        this.w.q(ni.isEmpty(forumActiveInfo.forum_share_url) ? "http://tieba.baidu.com" : this.u.forum_share_url, this.v);
        this.w.r(1);
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext, dr4 dr4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsViewData, tbPageContext, dr4Var)) == null) {
            this.r = frsViewData;
            this.s = tbPageContext;
            this.t = dr4Var;
            this.u = frsViewData.getForumActiveInfo();
            f(this.a);
            c(frsViewData);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void e(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.l.setImageBitmap((Bitmap) runTask.getData());
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d034b, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090bc0);
            this.b = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_frs_private_dialog);
            RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090bca);
            this.m = relativeLayout;
            SkinManager.setBackgroundResource(relativeLayout, R.drawable.bg_frs_private_dialog);
            LinearGradientView linearGradientView = (LinearGradientView) this.b.findViewById(R.id.obfuscated_res_0x7f090bce);
            this.c = linearGradientView;
            linearGradientView.setCornerRadius(oi.f(context, R.dimen.tbds30));
            this.c.setRoundMode(3);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090bcd);
            this.d = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.d.setDefaultResource(R.drawable.obfuscated_res_0x7f080f07);
            this.d.setRadius(oi.f(this.s.getPageActivity(), R.dimen.tbds30));
            this.d.setConrers(3);
            h();
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090bc4);
            this.e = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            TextView textView2 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090bc1);
            this.f = textView2;
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0106);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090675);
            this.j = imageView;
            imageView.setOnClickListener(new a(this));
            SkinManager.setImageResource(this.j, R.drawable.icon_popup_shut_n);
            this.l = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090bc7);
            BarImageView barImageView = (BarImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090bc5);
            this.g = barImageView;
            barImageView.setShowOval(true);
            this.g.setStrokeWith(oi.f(this.s.getPageActivity(), R.dimen.tbds3));
            this.g.setStrokeColorResId(R.color.CAM_X0201);
            this.h = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091823);
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c03);
            this.h.setDefaultBgResource(R.color.CAM_X0205);
            this.h.setIsRound(true);
            this.h.setTag(null);
            SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f081226);
            TextView textView3 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090bc9);
            this.k = textView3;
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0106);
            if (this.w == null) {
                xd6 xd6Var = new xd6(this.s);
                this.w = xd6Var;
                xd6Var.o(this.b, this.m, null);
                this.w.s(this.x);
            }
            this.n = (ImageOverlayView) this.b.findViewById(R.id.obfuscated_res_0x7f090bbe);
            int f = oi.f(getContext(), R.dimen.tbds68);
            this.n.a(5, f, f, 0, 0, oi.f(getContext(), R.dimen.tbds16));
            this.n.setOrientation(true);
            this.n.setLoadImageType(12);
            this.n.d();
            HeadImageView headImageView = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090315);
            this.o = headImageView;
            headImageView.setDefaultBgResource(R.color.CAM_X0205);
            this.o.setIsRound(true);
            TextView textView4 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c02);
            this.p = textView4;
            SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0105);
            TextView textView5 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c03);
            this.q = textView5;
            SkinManager.setViewTextColor(textView5, (int) R.color.CAM_X0101);
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            TiebaStatic.log(new StatisticItem("c13385").param("fid", this.r.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i));
        }
    }

    public final void h() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        ThemeElement themeElement4;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (frsViewData = this.r) == null || (forum = frsViewData.getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null && (themeElement = themeColorInfo.day) != null && (themeElement2 = themeColorInfo.night) != null && (themeElement3 = themeColorInfo.dark) != null) {
            this.c.setGradientColor(themeElement.light_color, themeElement.dark_color, themeElement2.light_color, themeElement2.dark_color, themeElement3.light_color, themeElement3.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement4 = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement4 = themeColorInfo.night;
            } else {
                themeElement4 = themeColorInfo.day;
            }
            if (this.r.getStar() != null && !StringUtils.isNull(this.r.getStar().a())) {
                str = this.r.getStar().a();
            } else {
                str = themeElement4.pattern_image;
            }
            this.d.setVisibility(0);
            this.d.K(str, 10, false);
            return;
        }
        this.d.setVisibility(8);
        this.c.setDefaultGradientColor();
    }
}
