package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.r0.w0.y;
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
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y A;
    public y.e B;

    /* renamed from: e  reason: collision with root package name */
    public Context f51754e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f51755f;

    /* renamed from: g  reason: collision with root package name */
    public LinearGradientView f51756g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f51757h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51758i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f51759j;
    public BarImageView k;
    public HeadImageView l;
    public TextView m;
    public ImageView n;
    public TextView o;
    public ImageView p;
    public RelativeLayout q;
    public ImageOverlayView r;
    public HeadImageView s;
    public TextView t;
    public TextView u;
    public FrsViewData v;
    public TbPageContext w;
    public c.a.q0.s.s.a x;
    public ForumActiveInfo y;
    public String z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsPrivateShareDialogView f51760e;

        public a(FrsPrivateShareDialogView frsPrivateShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPrivateShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51760e = frsPrivateShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f51760e.x != null && this.f51760e.x.isShowing()) {
                this.f51760e.x.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements y.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsPrivateShareDialogView f51761a;

        public b(FrsPrivateShareDialogView frsPrivateShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPrivateShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51761a = frsPrivateShareDialogView;
        }

        @Override // c.a.r0.w0.y.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f51761a.f(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = new b(this);
        this.f51754e = context;
    }

    public final void c(FrsViewData frsViewData) {
        ForumActiveInfo forumActiveInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frsViewData) == null) || frsViewData == null) {
            return;
        }
        if (frsViewData.getForum() != null) {
            this.f51758i.setVisibility(0);
            this.f51758i.setText(frsViewData.getForum().getName() + this.f51754e.getResources().getString(R.string.core_bar));
            this.z = frsViewData.getForum().getName();
        } else {
            this.f51758i.setVisibility(8);
        }
        if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
            this.k.startLoad(frsViewData.getForum().getImage_url(), 10, false);
        }
        if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
            this.l.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
        } else {
            this.l.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
        }
        if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
            this.t.setText(frsViewData.getUserData().getName_show());
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
            this.f51759j.setText(frsViewData.getForumActiveInfo().forum_brief);
        } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
            this.f51759j.setText(frsViewData.getForum().getSlogan());
        } else {
            this.f51759j.setText(getResources().getString(R.string.frs_private_share_hint));
        }
        if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
            this.u.setVisibility(0);
            this.u.setText(R.string.bawu_member_bazhu_tip);
        } else {
            this.u.setVisibility(8);
        }
        if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
            d(frsViewData.getForumActiveInfo().forum_share_url);
        } else if (frsViewData.getForum() != null) {
            ForumData forum = this.v.getForum();
            String encode = URLEncoder.encode(frsViewData.getForum().getName());
            d(!TextUtils.isEmpty(forum.forum_share_link) ? forum.forum_share_link + "?kw=" + encode + "&fr=sharewise" : TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=sharewise");
        }
        if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
            this.o.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
        } else {
            this.o.setText(getResources().getString(R.string.wait_for_you_join));
        }
        ArrayList arrayList = new ArrayList();
        if (frsViewData.userList != null) {
            for (int i2 = 0; i2 < frsViewData.userList.size() && !StringUtils.isNull(frsViewData.userList.get(i2).portrait); i2++) {
                arrayList.add(frsViewData.userList.get(i2).portrait);
                if (arrayList.size() >= 5) {
                    break;
                }
            }
        }
        if (arrayList.size() > 0) {
            this.r.setData(arrayList);
            this.r.setVisibility(0);
            this.s.setVisibility(8);
        } else {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.s.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.s.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
        }
        if (this.A == null || (forumActiveInfo = this.y) == null) {
            return;
        }
        this.A.q(k.isEmpty(forumActiveInfo.forum_share_url) ? "http://tieba.baidu.com" : this.y.forum_share_url, this.z);
        this.A.r(1);
    }

    public boolean configShareDialog(FrsViewData frsViewData, TbPageContext tbPageContext, c.a.q0.s.s.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsViewData, tbPageContext, aVar)) == null) {
            this.v = frsViewData;
            this.w = tbPageContext;
            this.x = aVar;
            this.y = frsViewData.getForumActiveInfo();
            e(this.f51754e);
            c(frsViewData);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void d(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.p.setImageBitmap((Bitmap) runTask.getData());
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_share);
            this.f51755f = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_frs_private_dialog);
            RelativeLayout relativeLayout = (RelativeLayout) this.f51755f.findViewById(R.id.frs_private_share_view);
            this.q = relativeLayout;
            SkinManager.setBackgroundResource(relativeLayout, R.drawable.bg_frs_private_dialog);
            LinearGradientView linearGradientView = (LinearGradientView) this.f51755f.findViewById(R.id.frs_private_top_gradient_bg);
            this.f51756g = linearGradientView;
            linearGradientView.setCornerRadius(l.g(context, R.dimen.tbds30));
            this.f51756g.setRoundMode(3);
            TbImageView tbImageView = (TbImageView) this.f51755f.findViewById(R.id.frs_private_top_bg_mask);
            this.f51757h = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f51757h.setDefaultResource(R.drawable.pic_frs_head_default);
            this.f51757h.setRadius(l.g(this.w.getPageActivity(), R.dimen.tbds30));
            this.f51757h.setConrers(3);
            g();
            TextView textView = (TextView) this.f51755f.findViewById(R.id.frs_private_share_name);
            this.f51758i = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            TextView textView2 = (TextView) this.f51755f.findViewById(R.id.frs_private_share_brief);
            this.f51759j = textView2;
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0106);
            ImageView imageView = (ImageView) this.f51755f.findViewById(R.id.close_button);
            this.n = imageView;
            imageView.setOnClickListener(new a(this));
            SkinManager.setImageResource(this.n, R.drawable.icon_popup_shut_n);
            this.p = (ImageView) this.f51755f.findViewById(R.id.frs_private_share_qrcode);
            BarImageView barImageView = (BarImageView) this.f51755f.findViewById(R.id.frs_private_share_portrait);
            this.k = barImageView;
            barImageView.setShowOval(true);
            this.k.setStrokeWith(l.g(this.w.getPageActivity(), R.dimen.tbds3));
            this.k.setStrokeColorResId(R.color.CAM_X0201);
            this.l = (HeadImageView) this.f51755f.findViewById(R.id.photo);
            this.m = (TextView) this.f51755f.findViewById(R.id.frs_user_name_identify);
            this.l.setDefaultBgResource(R.color.CAM_X0205);
            this.l.setIsRound(true);
            this.l.setTag(null);
            SkinManager.setBackgroundResource(this.m, R.drawable.username_text_bg);
            TextView textView3 = (TextView) this.f51755f.findViewById(R.id.frs_private_share_time);
            this.o = textView3;
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0106);
            if (this.A == null) {
                y yVar = new y(this.w);
                this.A = yVar;
                yVar.o(this.f51755f, this.q, null);
                this.A.s(this.B);
            }
            this.r = (ImageOverlayView) this.f51755f.findViewById(R.id.frs_private_overlayview);
            int g2 = l.g(getContext(), R.dimen.tbds68);
            this.r.init(5, g2, g2, 0, 0, l.g(getContext(), R.dimen.tbds16));
            this.r.setOrientation(true);
            this.r.setLoadImageType(12);
            this.r.onChangeSkinType();
            HeadImageView headImageView = (HeadImageView) this.f51755f.findViewById(R.id.bar_friend_icon);
            this.s = headImageView;
            headImageView.setDefaultBgResource(R.color.CAM_X0205);
            this.s.setIsRound(true);
            TextView textView4 = (TextView) this.f51755f.findViewById(R.id.frs_user_name);
            this.t = textView4;
            SkinManager.setViewTextColor(textView4, R.color.CAM_X0105);
            TextView textView5 = (TextView) this.f51755f.findViewById(R.id.frs_user_name_identify);
            this.u = textView5;
            SkinManager.setViewTextColor(textView5, R.color.CAM_X0101);
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13385").param("fid", this.v.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i2));
        }
    }

    public final void g() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        ThemeElement themeElement4;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (frsViewData = this.v) == null || (forum = frsViewData.getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null && (themeElement = themeColorInfo.day) != null && (themeElement2 = themeColorInfo.night) != null && (themeElement3 = themeColorInfo.dark) != null) {
            this.f51756g.setGradientColor(themeElement.light_color, themeElement.dark_color, themeElement2.light_color, themeElement2.dark_color, themeElement3.light_color, themeElement3.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement4 = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement4 = themeColorInfo.night;
            } else {
                themeElement4 = themeColorInfo.day;
            }
            if (this.v.getStar() != null && !StringUtils.isNull(this.v.getStar().a())) {
                str = this.v.getStar().a();
            } else {
                str = themeElement4.pattern_image;
            }
            this.f51757h.setVisibility(0);
            this.f51757h.startLoad(str, 10, false);
            return;
        }
        this.f51757h.setVisibility(8);
        this.f51756g.setDefaultGradientColor();
    }
}
