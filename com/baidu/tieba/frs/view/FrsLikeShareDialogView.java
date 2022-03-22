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
import c.a.o0.r.v.c;
import c.a.p0.a4.y;
import c.a.p0.f1.r2.l;
import c.a.p0.f1.r2.m;
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
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public ForumData f32937b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintLayout f32938c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f32939d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f32940e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32941f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32942g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f32943h;
    public TextView i;
    public ImageView j;
    public View k;
    public LinearLayout l;
    public ImageView m;
    public LinearLayout n;
    public ImageView o;
    public LinearLayout p;
    public ImageView q;
    public LinearLayout r;
    public ImageView s;
    public ImageView t;
    public View u;
    public l v;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsLikeShareDialogView;
        }

        @Override // c.a.p0.f1.r2.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f32939d == null) {
                return;
            }
            this.a.f32939d.s();
            this.a.f32939d.setRadiusById(R.string.J_X02);
        }

        @Override // c.a.p0.f1.r2.l.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f32939d == null) {
                return;
            }
            this.a.f32939d.setConrers(3);
            this.a.f32939d.setRadiusById(R.string.J_X14);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b(TbPageContext tbPageContext, y yVar, ForumData forumData) {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, tbPageContext, yVar, forumData) == null) || yVar == null || forumData == null || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        this.a = tbPageContext;
        this.f32937b = forumData;
        this.f32940e.setBorderColor(SkinManager.getColor(0, (int) R.color.CAM_X0402));
        this.f32940e.setBorderWidth(n.f(getContext(), R.dimen.tbds6));
        this.f32940e.setUrl(currentAccountInfo.getAvatar());
        this.f32940e.J(currentAccountInfo.getAvatar(), 12, false);
        this.f32941f.setText(StringHelper.cutChineseAndEnglishWithEmoji(currentAccountInfo.getAccountNameShow(), 12, StringHelper.STRING_MORE));
        TextView textView = this.f32942g;
        textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.f32937b.getName() + getContext().getString(R.string.obfuscated_res_0x7f0f043c), 16, StringHelper.STRING_MORE));
        this.f32943h.setText(getContext().getString(R.string.obfuscated_res_0x7f0f06fd, yVar.k()));
        String h2 = yVar.h();
        int length = !TextUtils.isEmpty(h2) ? h2.length() : 0;
        SpannableString spannableString = new SpannableString(getContext().getString(R.string.obfuscated_res_0x7f0f06ff, h2));
        int i = length + 2;
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(0, (int) R.color.CAM_X0304)), 2, i, 17);
        spannableString.setSpan(new StyleSpan(1), 2, i, 17);
        this.i.setText(spannableString);
        c(c.a.p0.f1.r2.n.c(this.f32937b) + "&source=focusbar");
        l lVar = new l(this.a, getContext(), this.f32938c, new a(this));
        this.v = lVar;
        lVar.h(forumData);
    }

    public final void c(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.j.setImageBitmap((Bitmap) runTask.getData());
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d033a, this);
            this.f32938c = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090b5e);
            this.f32939d = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090b6f);
            this.f32940e = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090b5c);
            this.f32941f = (TextView) findViewById(R.id.obfuscated_res_0x7f090b70);
            this.f32942g = (TextView) findViewById(R.id.obfuscated_res_0x7f090b64);
            this.f32943h = (TextView) findViewById(R.id.obfuscated_res_0x7f090b6a);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090b66);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b6d);
            this.k = findViewById(R.id.obfuscated_res_0x7f090b5d);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b71);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b72);
            this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b5f);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b60);
            this.p = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b6b);
            this.q = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b6c);
            this.r = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b62);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b63);
            this.t = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b61);
            this.u = findViewById(R.id.obfuscated_res_0x7f090b69);
            f();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c d2 = c.d(this.k);
            d2.n(R.string.J_X17);
            d2.g(SkinManager.getColor(0, (int) R.color.CAM_X0204));
            this.m.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f080823, SvgManager.SvgResourceStateType.NORMAL));
            this.o.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f08081f, SvgManager.SvgResourceStateType.NORMAL));
            this.q.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f080820, SvgManager.SvgResourceStateType.NORMAL));
            this.s.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f0807de, SvgManager.SvgResourceStateType.NORMAL));
            this.l.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.r.setOnClickListener(this);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f32940e.setAutoChangeStyle(false);
            this.f32940e.setUseNightOrDarkMask(false);
            this.f32939d.setAutoChangeStyle(false);
            this.f32939d.setUseNightOrDarkMask(false);
            this.f32939d.setRadiusById(R.string.J_X14);
            this.f32939d.setConrers(3);
            this.f32939d.setIsBitmapPic(true);
            SkinManager.setImageResource(this.f32939d, R.drawable.obfuscated_res_0x7f080b7b, 0);
            c d2 = c.d(this.u);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0501);
        }
    }

    public final void g(int i) {
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            int i2 = 3;
            if (i == 3) {
                i2 = 4;
            } else if (i != 2) {
                i2 = i == 8 ? 9 : i == -1 ? 17 : -1;
            }
            if (i2 == -1 || (forumData = this.f32937b) == null) {
                return;
            }
            m.b(forumData.getId(), i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view == this.r) {
                l lVar2 = this.v;
                if (lVar2 != null) {
                    lVar2.c();
                }
                g(-1);
                return;
            }
            if (view == this.l) {
                i = 3;
            } else if (view == this.n) {
                i = 2;
            } else {
                i = view == this.p ? 8 : -1;
            }
            if (i != -1 && (lVar = this.v) != null) {
                lVar.j(i);
            }
            g(i);
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.t.setOnClickListener(onClickListener);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLikeShareDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        d(context);
    }
}
