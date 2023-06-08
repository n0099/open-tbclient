package com.baidu.tieba;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.forumMember.member.FrsMemberHeaderViewHolder;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ib7 extends id7<jb7, FrsMemberHeaderViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LikeModel l;
    public int m;
    public int n;
    public View.OnClickListener o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib7 a;

        public a(ib7 ib7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag();
                if (!(tag instanceof Integer)) {
                    return;
                }
                vn item = this.a.getItem(((Integer) tag).intValue());
                if (!(item instanceof jb7)) {
                    return;
                }
                jb7 jb7Var = (jb7) item;
                if (view2.getId() == R.id.obfuscated_res_0x7f0914d0) {
                    if (!ViewHelper.checkUpIsLogin(this.a.c.getPageActivity())) {
                        return;
                    }
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.c.showToast(R.string.obfuscated_res_0x7f0f0def);
                        return;
                    }
                    String a = jb7Var.a();
                    this.a.l.m0(jb7Var.b(), a);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092769) {
                    String a2 = jb7Var.a();
                    this.a.c.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(this.a.mContext, jb7Var.b(), a2)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends j9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib7 a;

        public b(ib7 ib7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib7Var;
        }

        @Override // com.baidu.tieba.j9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if ((obj instanceof jx9) && this.a.l.getErrorCode() == 0) {
                    jx9 jx9Var = (jx9) obj;
                    jx9Var.y(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, jx9Var));
                } else if (AntiHelper.m(this.a.l.getErrorCode(), this.a.l.getErrorString())) {
                    AntiHelper.u(this.a.c.getPageActivity(), this.a.l.getErrorString());
                } else {
                    this.a.c.showToast(this.a.l.getErrorString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ib7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 0;
        this.n = 0;
        this.o = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: Q */
    public FrsMemberHeaderViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (this.l == null) {
                P();
            }
            return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d02f8, (ViewGroup) null), this.o);
        }
        return (FrsMemberHeaderViewHolder) invokeL.objValue;
    }

    public final int[] O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i <= 3) {
                return new int[]{-8331843, -10499102};
            }
            if (i <= 9) {
                return new int[]{-10499102, -154262};
            }
            if (i <= 15) {
                return new int[]{-154262, -148180};
            }
            return new int[]{-148180, -100818};
        }
        return (int[]) invokeI.objValue;
    }

    public final void P() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (tbPageContext = this.c) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.l = likeModel;
        likeModel.setLoadDataCallBack(new b(this));
    }

    public View R(int i, View view2, ViewGroup viewGroup, jb7 jb7Var, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        InterceptResult invokeCommon;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jb7Var, frsMemberHeaderViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) jb7Var, (jb7) frsMemberHeaderViewHolder);
            if (jb7Var != null && jb7Var.c() != null) {
                int parseColor = Color.parseColor("#56cfa1");
                int color = SkinManager.getColor(R.color.CAM_X0109);
                jx9 c = jb7Var.c();
                if (TbadkCoreApplication.isLogin()) {
                    if (c.n() == 1) {
                        frsMemberHeaderViewHolder.a.setVisibility(8);
                        frsMemberHeaderViewHolder.b.setVisibility(0);
                        frsMemberHeaderViewHolder.b.setText(R.string.obfuscated_res_0x7f0f0cf6);
                        SkinManager.setImageResource(frsMemberHeaderViewHolder.c, BitmapHelper.getSmallGradeResourceIdNew(c.m()));
                        if (StringUtils.isNull(c.h())) {
                            frsMemberHeaderViewHolder.d.setVisibility(8);
                        } else {
                            frsMemberHeaderViewHolder.d.setText(c.h());
                            frsMemberHeaderViewHolder.d.setVisibility(0);
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        SpannableString spannableString = new SpannableString(c.c() + "");
                        spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                        SpannableString spannableString2 = new SpannableString("/" + c.i());
                        spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                        spannableStringBuilder.append((CharSequence) spannableString);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                        frsMemberHeaderViewHolder.g.setText(spannableStringBuilder);
                        frsMemberHeaderViewHolder.g.setVisibility(0);
                        frsMemberHeaderViewHolder.k.setVisibility(0);
                        frsMemberHeaderViewHolder.l.setVisibility(0);
                    } else {
                        frsMemberHeaderViewHolder.a.setVisibility(0);
                        frsMemberHeaderViewHolder.b.setVisibility(8);
                        frsMemberHeaderViewHolder.c.setVisibility(8);
                        frsMemberHeaderViewHolder.d.setVisibility(8);
                        frsMemberHeaderViewHolder.g.setVisibility(8);
                        frsMemberHeaderViewHolder.k.setVisibility(8);
                        frsMemberHeaderViewHolder.l.setVisibility(8);
                    }
                } else {
                    frsMemberHeaderViewHolder.a.setVisibility(8);
                    frsMemberHeaderViewHolder.b.setVisibility(8);
                    frsMemberHeaderViewHolder.c.setVisibility(8);
                    frsMemberHeaderViewHolder.d.setVisibility(8);
                    frsMemberHeaderViewHolder.g.setVisibility(8);
                    frsMemberHeaderViewHolder.k.setVisibility(8);
                    frsMemberHeaderViewHolder.l.setVisibility(8);
                }
                frsMemberHeaderViewHolder.a.setTag(Integer.valueOf(i));
                frsMemberHeaderViewHolder.d.setTag(Integer.valueOf(i));
                frsMemberHeaderViewHolder.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.h, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.e, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.i, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.a, R.drawable.frs_btn_like);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.a, R.color.white_alpha100, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.b, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.d, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.j, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.k, R.drawable.obfuscated_res_0x7f0806b8);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.l, R.color.CAM_X0204);
                if (this.m != c.m() || this.n != c.c()) {
                    this.m = c.m();
                    this.n = c.c();
                    frsMemberHeaderViewHolder.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, O(this.m)));
                    int c2 = c.c();
                    this.n = c2;
                    if (c2 > c.i()) {
                        this.n = c.i();
                    }
                    if (c.i() != 0) {
                        f = this.n / c.i();
                    } else {
                        f = 0.0f;
                    }
                    if (f > 0.999f) {
                        f = 1.0f;
                    }
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                    scaleAnimation.setFillAfter(true);
                    scaleAnimation.setDuration(1000L);
                    mw9.c((TbPageContextSupport) this.c.getPageActivity(), frsMemberHeaderViewHolder.k, scaleAnimation, null);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.id7, com.baidu.tieba.in
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        R(i, view2, viewGroup, (jb7) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view2;
    }
}
