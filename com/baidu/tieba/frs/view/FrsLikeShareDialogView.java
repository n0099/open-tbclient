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
import com.repackage.gs4;
import com.repackage.mi;
import com.repackage.np6;
import com.repackage.op6;
import com.repackage.pp6;
import com.repackage.zi8;
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
    public np6 v;

    /* loaded from: classes3.dex */
    public class a implements np6.b {
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

        @Override // com.repackage.np6.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null) {
                return;
            }
            this.a.d.t();
            this.a.d.setRadiusById(R.string.J_X02);
        }

        @Override // com.repackage.np6.b
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

    public void b(TbPageContext tbPageContext, zi8 zi8Var, ForumData forumData) {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, tbPageContext, zi8Var, forumData) == null) || zi8Var == null || forumData == null || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        this.a = tbPageContext;
        this.b = forumData;
        this.e.setBorderColor(SkinManager.getColor(0, (int) R.color.CAM_X0402));
        this.e.setBorderWidth(mi.f(getContext(), R.dimen.tbds6));
        this.e.setUrl(currentAccountInfo.getAvatar());
        this.e.K(currentAccountInfo.getAvatar(), 12, false);
        this.f.setText(StringHelper.cutChineseAndEnglishWithEmoji(currentAccountInfo.getAccountNameShow(), 12, StringHelper.STRING_MORE));
        TextView textView = this.g;
        textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.b.getName() + getContext().getString(R.string.obfuscated_res_0x7f0f044b), 16, StringHelper.STRING_MORE));
        this.h.setText(getContext().getString(R.string.obfuscated_res_0x7f0f070b, zi8Var.k()));
        String h = zi8Var.h();
        int length = !TextUtils.isEmpty(h) ? h.length() : 0;
        SpannableString spannableString = new SpannableString(getContext().getString(R.string.obfuscated_res_0x7f0f070d, h));
        int i = length + 2;
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(0, (int) R.color.CAM_X0304)), 2, i, 17);
        spannableString.setSpan(new StyleSpan(1), 2, i, 17);
        this.i.setText(spannableString);
        c(pp6.c(this.b) + "&source=focusbar");
        np6 np6Var = new np6(this.a, getContext(), this.c, new a(this));
        this.v = np6Var;
        np6Var.h(forumData);
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0332, this);
            this.c = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090b59);
            this.d = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090b6a);
            this.e = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090b57);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090b6b);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090b5f);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090b65);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090b61);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b68);
            this.k = findViewById(R.id.obfuscated_res_0x7f090b58);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b6c);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b6d);
            this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b5a);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b5b);
            this.p = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b66);
            this.q = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b67);
            this.r = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090b5d);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b5e);
            this.t = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b5c);
            this.u = findViewById(R.id.obfuscated_res_0x7f090b64);
            f();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gs4 d = gs4.d(this.k);
            d.n(R.string.J_X17);
            d.g(SkinManager.getColor(0, (int) R.color.CAM_X0204));
            this.m.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f080816, SvgManager.SvgResourceStateType.NORMAL));
            this.o.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f080812, SvgManager.SvgResourceStateType.NORMAL));
            this.q.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f080813, SvgManager.SvgResourceStateType.NORMAL));
            this.s.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.obfuscated_res_0x7f0807cc, SvgManager.SvgResourceStateType.NORMAL));
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
            SkinManager.setImageResource(this.d, R.drawable.obfuscated_res_0x7f080b9b, 0);
            gs4 d = gs4.d(this.u);
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
            op6.b(forumData.getId(), i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        np6 np6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2 == this.r) {
                np6 np6Var2 = this.v;
                if (np6Var2 != null) {
                    np6Var2.c();
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
            if (i != -1 && (np6Var = this.v) != null) {
                np6Var.j(i);
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
