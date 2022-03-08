package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.a.d.f.p.n;
import c.a.q0.r.v.c;
import c.a.r0.d1.r2.l;
import c.a.r0.d1.r2.m;
import c.a.r0.y3.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsLikeShareDialogView extends ConstraintLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f42473e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f42474f;

    /* renamed from: g  reason: collision with root package name */
    public ConstraintLayout f42475g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f42476h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f42477i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42478j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public View o;
    public LinearLayout p;
    public ImageView q;
    public LinearLayout r;
    public ImageView s;
    public LinearLayout t;
    public ImageView u;
    public LinearLayout v;
    public ImageView w;
    public ImageView x;
    public View y;
    public l z;

    /* loaded from: classes5.dex */
    public class a implements l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsLikeShareDialogView a;

        public a(FrsLikeShareDialogView frsLikeShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsLikeShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsLikeShareDialogView;
        }

        @Override // c.a.r0.d1.r2.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f42476h == null) {
                return;
            }
            this.a.f42476h.clearCornerFlag();
            this.a.f42476h.setRadiusById(R.string.J_X02);
        }

        @Override // c.a.r0.d1.r2.l.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f42476h == null) {
                return;
            }
            this.a.f42476h.setConrers(3);
            this.a.f42476h.setRadiusById(R.string.J_X14);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsLikeShareDialogView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.n.setImageBitmap((Bitmap) runTask.getData());
    }

    public void bind(TbPageContext tbPageContext, y yVar, ForumData forumData) {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, yVar, forumData) == null) || yVar == null || forumData == null || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        this.f42473e = tbPageContext;
        this.f42474f = forumData;
        this.f42477i.setBorderColor(SkinManager.getColor(0, (int) R.color.CAM_X0402));
        this.f42477i.setBorderWidth(n.f(getContext(), R.dimen.tbds6));
        this.f42477i.setUrl(currentAccountInfo.getAvatar());
        this.f42477i.startLoad(currentAccountInfo.getAvatar(), 12, false);
        this.f42478j.setText(StringHelper.cutChineseAndEnglishWithEmoji(currentAccountInfo.getAccountNameShow(), 12, "..."));
        TextView textView = this.k;
        textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.f42474f.getName() + getContext().getString(R.string.core_bar), 16, "..."));
        this.l.setText(getContext().getString(R.string.frs_like_become_forum_member, yVar.k()));
        String h2 = yVar.h();
        int length = !TextUtils.isEmpty(h2) ? h2.length() : 0;
        SpannableString spannableString = new SpannableString(getContext().getString(R.string.frs_like_get_level_title, h2));
        int i2 = length + 2;
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(0, (int) R.color.CAM_X0304)), 2, i2, 17);
        spannableString.setSpan(new StyleSpan(1), 2, i2, 17);
        this.m.setText(spannableString);
        b(c.a.r0.d1.r2.n.c(this.f42474f) + "&source=focusbar");
        l lVar = new l(this.f42473e, getContext(), this.f42475g, new a(this));
        this.z = lVar;
        lVar.h(forumData);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_like_share_dialog_layout, this);
            this.f42475g = (ConstraintLayout) findViewById(R.id.frs_like_share_canvas);
            this.f42476h = (TbImageView) findViewById(R.id.frs_like_share_top_img);
            this.f42477i = (HeadImageView) findViewById(R.id.frs_like_share_avatar);
            this.f42478j = (TextView) findViewById(R.id.frs_like_share_username);
            this.k = (TextView) findViewById(R.id.frs_like_share_forum_name);
            this.l = (TextView) findViewById(R.id.frs_like_share_member_count);
            this.m = (TextView) findViewById(R.id.frs_like_share_level_title);
            this.n = (ImageView) findViewById(R.id.frs_like_share_qrcode);
            this.o = findViewById(R.id.frs_like_share_bottom_bg);
            this.p = (LinearLayout) findViewById(R.id.frs_like_share_wechat);
            this.q = (ImageView) findViewById(R.id.frs_like_share_wechat_iv);
            this.r = (LinearLayout) findViewById(R.id.frs_like_share_circle);
            this.s = (ImageView) findViewById(R.id.frs_like_share_circle_iv);
            this.t = (LinearLayout) findViewById(R.id.frs_like_share_qq);
            this.u = (ImageView) findViewById(R.id.frs_like_share_qq_iv);
            this.v = (LinearLayout) findViewById(R.id.frs_like_share_download);
            this.w = (ImageView) findViewById(R.id.frs_like_share_download_iv);
            this.x = (ImageView) findViewById(R.id.frs_like_share_close);
            this.y = findViewById(R.id.frs_like_share_mask_cover);
            e();
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c d2 = c.d(this.o);
            d2.n(R.string.J_X17);
            d2.g(SkinManager.getColor(0, (int) R.color.CAM_X0204));
            this.q.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.icon_mask_share_wechat40_svg, SvgManager.SvgResourceStateType.NORMAL));
            this.s.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.icon_mask_share_circle40_svg, SvgManager.SvgResourceStateType.NORMAL));
            this.u.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.icon_mask_share_qq40_svg, SvgManager.SvgResourceStateType.NORMAL));
            this.w.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.icon_mask_frs_private_share_download40_svg, SvgManager.SvgResourceStateType.NORMAL));
            this.p.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.v.setOnClickListener(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f42477i.setAutoChangeStyle(false);
            this.f42477i.setUseNightOrDarkMask(false);
            this.f42476h.setAutoChangeStyle(false);
            this.f42476h.setUseNightOrDarkMask(false);
            this.f42476h.setRadiusById(R.string.J_X14);
            this.f42476h.setConrers(3);
            this.f42476h.setIsBitmapPic(true);
            SkinManager.setImageResource(this.f42476h, R.drawable.img_frs_share, 0);
            c d2 = c.d(this.y);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0501);
        }
    }

    public final void f(int i2) {
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int i3 = 3;
            if (i2 == 3) {
                i3 = 4;
            } else if (i2 != 2) {
                i3 = i2 == 8 ? 9 : i2 == -1 ? 17 : -1;
            }
            if (i3 == -1 || (forumData = this.f42474f) == null) {
                return;
            }
            m.b(forumData.getId(), i3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view == this.v) {
                l lVar2 = this.z;
                if (lVar2 != null) {
                    lVar2.c();
                }
                f(-1);
                return;
            }
            if (view == this.p) {
                i2 = 3;
            } else if (view == this.r) {
                i2 = 2;
            } else {
                i2 = view == this.t ? 8 : -1;
            }
            if (i2 != -1 && (lVar = this.z) != null) {
                lVar.j(i2);
            }
            f(i2);
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.x.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsLikeShareDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLikeShareDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c(context);
    }
}
