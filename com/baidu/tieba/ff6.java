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
/* loaded from: classes4.dex */
public class ff6 extends dh6<gf6, FrsMemberHeaderViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LikeModel l;
    public int m;
    public int n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff6 a;

        public a(ff6 ff6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    Cdo item = this.a.getItem(((Integer) tag).intValue());
                    if (item instanceof gf6) {
                        gf6 gf6Var = (gf6) item;
                        if (view2.getId() == R.id.obfuscated_res_0x7f0912fe) {
                            if (ViewHelper.checkUpIsLogin(this.a.c.getPageActivity())) {
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.c.showToast(R.string.obfuscated_res_0x7f0f0c59);
                                    return;
                                }
                                String a = gf6Var.a();
                                this.a.l.Q(gf6Var.b(), a);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0924b3) {
                            String a2 = gf6Var.a();
                            this.a.c.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(this.a.mContext, gf6Var.b(), a2)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff6 a;

        public b(ff6 ff6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff6Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof km8) || this.a.l.getErrorCode() != 0) {
                    if (AntiHelper.m(this.a.l.getErrorCode(), this.a.l.getErrorString())) {
                        AntiHelper.u(this.a.c.getPageActivity(), this.a.l.getErrorString());
                        return;
                    } else {
                        this.a.c.showToast(this.a.l.getErrorString());
                        return;
                    }
                }
                km8 km8Var = (km8) obj;
                km8Var.x(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, km8Var));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ff6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final int[] M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i <= 3 ? new int[]{-8331843, -10499102} : i <= 9 ? new int[]{-10499102, -154262} : i <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    public final void N() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.c) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.l = likeModel;
        likeModel.setLoadDataCallBack(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: O */
    public FrsMemberHeaderViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (this.l == null) {
                N();
            }
            return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d02bb, (ViewGroup) null), this.o);
        }
        return (FrsMemberHeaderViewHolder) invokeL.objValue;
    }

    public View P(int i, View view2, ViewGroup viewGroup, gf6 gf6Var, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gf6Var, frsMemberHeaderViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, gf6Var, frsMemberHeaderViewHolder);
            if (gf6Var != null && gf6Var.c() != null) {
                int parseColor = Color.parseColor("#56cfa1");
                int color = SkinManager.getColor(R.color.CAM_X0109);
                km8 c = gf6Var.c();
                if (TbadkCoreApplication.isLogin()) {
                    if (c.m() == 1) {
                        frsMemberHeaderViewHolder.a.setVisibility(8);
                        frsMemberHeaderViewHolder.b.setVisibility(0);
                        frsMemberHeaderViewHolder.b.setText(R.string.obfuscated_res_0x7f0f0b73);
                        SkinManager.setImageResource(frsMemberHeaderViewHolder.c, BitmapHelper.getSmallGradeResourceIdNew(c.l()));
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
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.k, R.drawable.obfuscated_res_0x7f080587);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.l, R.color.CAM_X0204);
                if (this.m != c.l() || this.n != c.c()) {
                    this.m = c.l();
                    this.n = c.c();
                    frsMemberHeaderViewHolder.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, M(this.m)));
                    int c2 = c.c();
                    this.n = c2;
                    if (c2 > c.i()) {
                        this.n = c.i();
                    }
                    float i2 = c.i() != 0 ? this.n / c.i() : 0.0f;
                    if (i2 > 0.999f) {
                        i2 = 1.0f;
                    }
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, i2, 1.0f, 1.0f);
                    scaleAnimation.setFillAfter(true);
                    scaleAnimation.setDuration(1000L);
                    ml8.c((TbPageContextSupport) this.c.getPageActivity(), frsMemberHeaderViewHolder.k, scaleAnimation, null);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.dh6, com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        P(i, view2, viewGroup, (gf6) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view2;
    }
}
