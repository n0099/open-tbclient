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
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.j05;
import com.baidu.tieba.m47;
import com.baidu.tieba.qs6;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
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
    public j05 t;
    public ForumActiveInfo u;
    public String v;
    public qs6 w;
    public qs6.e x;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements qs6.e {
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

        @Override // com.baidu.tieba.qs6.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.g(i);
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

    public final void e(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.l.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            TiebaStatic.log(new StatisticItem("c13385").param("fid", this.r.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i));
        }
    }

    public final void c(FrsViewData frsViewData) {
        ForumActiveInfo forumActiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        if (frsViewData.getForum() != null) {
            this.e.setVisibility(0);
            TextView textView = this.e;
            textView.setText(frsViewData.getForum().getName() + this.a.getResources().getString(R.string.core_bar));
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
            this.f.setText(getResources().getString(R.string.frs_private_share_hint));
        }
        if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
            this.q.setVisibility(0);
            this.q.setText(R.string.bawu_member_bazhu_tip);
        } else {
            this.q.setVisibility(8);
        }
        if (frsViewData.getForum() != null) {
            e(m47.c(frsViewData.getForum()));
        }
        if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
            TextView textView2 = this.k;
            textView2.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
        } else {
            this.k.setText(getResources().getString(R.string.wait_for_you_join));
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
        if (this.w != null && (forumActiveInfo = this.u) != null) {
            if (dj.isEmpty(forumActiveInfo.forum_share_url)) {
                str = TbConfig.TIEBA_ADDRESS;
            } else {
                str = this.u.forum_share_url;
            }
            this.w.q(str, this.v);
            this.w.r(1);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d034a, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_share);
            this.b = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_frs_private_dialog);
            RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090c7d);
            this.m = relativeLayout;
            SkinManager.setBackgroundResource(relativeLayout, R.drawable.bg_frs_private_dialog);
            LinearGradientView linearGradientView = (LinearGradientView) this.b.findViewById(R.id.obfuscated_res_0x7f090c81);
            this.c = linearGradientView;
            linearGradientView.setCornerRadius(ej.g(context, R.dimen.tbds30));
            this.c.setRoundMode(3);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090c80);
            this.d = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.d.setDefaultResource(R.drawable.obfuscated_res_0x7f080fbb);
            this.d.setRadius(ej.g(this.s.getPageActivity(), R.dimen.tbds30));
            this.d.setConrers(3);
            h();
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c77);
            this.e = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            TextView textView2 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c74);
            this.f = textView2;
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0106);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.close_button);
            this.j = imageView;
            imageView.setOnClickListener(new a(this));
            SkinManager.setImageResource(this.j, R.drawable.icon_popup_shut_n);
            this.l = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090c7a);
            BarImageView barImageView = (BarImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090c78);
            this.g = barImageView;
            barImageView.setShowOval(true);
            this.g.setStrokeWith(ej.g(this.s.getPageActivity(), R.dimen.tbds3));
            this.g.setStrokeColorResId(R.color.CAM_X0201);
            this.h = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091ad3);
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090cb8);
            this.h.setDefaultBgResource(R.color.CAM_X0205);
            this.h.setIsRound(true);
            this.h.setTag(null);
            SkinManager.setBackgroundResource(this.i, R.drawable.username_text_bg);
            TextView textView3 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090c7c);
            this.k = textView3;
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0106);
            if (this.w == null) {
                qs6 qs6Var = new qs6(this.s);
                this.w = qs6Var;
                qs6Var.o(this.b, this.m, null);
                this.w.s(this.x);
            }
            this.n = (ImageOverlayView) this.b.findViewById(R.id.obfuscated_res_0x7f090c72);
            int g = ej.g(getContext(), R.dimen.tbds68);
            this.n.a(5, g, g, 0, 0, ej.g(getContext(), R.dimen.tbds16));
            this.n.setOrientation(true);
            this.n.setLoadImageType(12);
            this.n.d();
            HeadImageView headImageView = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090338);
            this.o = headImageView;
            headImageView.setDefaultBgResource(R.color.CAM_X0205);
            this.o.setIsRound(true);
            TextView textView4 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090cb7);
            this.p = textView4;
            SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0105);
            TextView textView5 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090cb8);
            this.q = textView5;
            SkinManager.setViewTextColor(textView5, (int) R.color.CAM_X0101);
        }
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext, j05 j05Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsViewData, tbPageContext, j05Var)) == null) {
            this.r = frsViewData;
            this.s = tbPageContext;
            this.t = j05Var;
            this.u = frsViewData.getForumActiveInfo();
            f(this.a);
            c(frsViewData);
            return true;
        }
        return invokeLLL.booleanValue;
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
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (frsViewData = this.r) == null || (forum = frsViewData.getForum()) == null) {
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
