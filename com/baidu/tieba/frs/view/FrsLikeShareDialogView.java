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
import com.repackage.kp6;
import com.repackage.lp6;
import com.repackage.mp6;
import com.repackage.oh8;
import com.repackage.pi;
import com.repackage.vr4;
/* loaded from: classes3.dex */
public class FrsLikeShareDialogView extends ConstraintLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ForumData b;
    public ConstraintLayout c;
    public TbImageView d;
    public HeadImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
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
    public kp6 v;

    /* loaded from: classes3.dex */
    public class a implements kp6.b {
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

        @Override // com.repackage.kp6.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null) {
                return;
            }
            this.a.d.s();
            this.a.d.setRadiusById(R.string.J_X02);
        }

        @Override // com.repackage.kp6.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.d == null) {
                return;
            }
            this.a.d.setConrers(3);
            this.a.d.setRadiusById(R.string.J_X14);
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

    public void b(TbPageContext tbPageContext, oh8 oh8Var, ForumData forumData) {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, tbPageContext, oh8Var, forumData) == null) || oh8Var == null || forumData == null || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        this.a = tbPageContext;
        this.b = forumData;
        this.e.setBorderColor(SkinManager.getColor(0, (int) R.color.CAM_X0402));
        this.e.setBorderWidth(pi.f(getContext(), R.dimen.tbds6));
        this.e.setUrl(currentAccountInfo.getAvatar());
        this.e.J(currentAccountInfo.getAvatar(), 12, false);
        this.f.setText(StringHelper.cutChineseAndEnglishWithEmoji(currentAccountInfo.getAccountNameShow(), 12, StringHelper.STRING_MORE));
        TextView textView = this.g;
        textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.b.getName() + getContext().getString(R.string.obfuscated_res_0x7f0f0449), 16, StringHelper.STRING_MORE));
        this.h.setText(getContext().getString(R.string.obfuscated_res_0x7f0f070d, oh8Var.k()));
        String h = oh8Var.h();
        int length = !TextUtils.isEmpty(h) ? h.length() : 0;
        SpannableString spannableString = new SpannableString(getContext().getString(R.string.obfuscated_res_0x7f0f070f, h));
        int i = length + 2;
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(0, (int) R.color.CAM_X0304)), 2, i, 17);
        spannableString.setSpan(new StyleSpan(1), 2, i, 17);
        this.i.setText(spannableString);
        c(mp6.c(this.b) + "&source=focusbar");
        kp6 kp6Var = new kp6(this.a, getContext(), this.c, new a(this));
        this.v = kp6Var;
        kp6Var.h(forumData);
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d032b, this);
            this.c = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090b33);
            this.d = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090b44);
            this.e = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090b31);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090b45);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090b39);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090b3f);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090b3b);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b42);
            this.k = findViewById(R.id.obfuscated_res_0x7f090b32);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b46);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b47);
            this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b34);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b35);
            this.p = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b40);
            this.q = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b41);
            this.r = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b37);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b38);
            this.t = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b36);
            this.u = findViewById(R.id.obfuscated_res_0x7f090b3e);
            f();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vr4 d = vr4.d(this.k);
            d.n(R.string.J_X17);
            d.g(SkinManager.getColor(0, (int) R.color.CAM_X0204));
            this.m.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f080804, SvgManager.SvgResourceStateType.NORMAL));
            this.o.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f080800, SvgManager.SvgResourceStateType.NORMAL));
            this.q.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f080801, SvgManager.SvgResourceStateType.NORMAL));
            this.s.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f0807cb, SvgManager.SvgResourceStateType.NORMAL));
            this.l.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.r.setOnClickListener(this);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.setAutoChangeStyle(false);
            this.e.setUseNightOrDarkMask(false);
            this.d.setAutoChangeStyle(false);
            this.d.setUseNightOrDarkMask(false);
            this.d.setRadiusById(R.string.J_X14);
            this.d.setConrers(3);
            this.d.setIsBitmapPic(true);
            SkinManager.setImageResource(this.d, R.drawable.obfuscated_res_0x7f080ba1, 0);
            vr4 d = vr4.d(this.u);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0501);
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
            if (i2 == -1 || (forumData = this.b) == null) {
                return;
            }
            lp6.b(forumData.getId(), i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        kp6 kp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2 == this.r) {
                kp6 kp6Var2 = this.v;
                if (kp6Var2 != null) {
                    kp6Var2.c();
                }
                g(-1);
                return;
            }
            if (view2 == this.l) {
                i = 3;
            } else if (view2 == this.n) {
                i = 2;
            } else {
                i = view2 == this.p ? 8 : -1;
            }
            if (i != -1 && (kp6Var = this.v) != null) {
                kp6Var.j(i);
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
