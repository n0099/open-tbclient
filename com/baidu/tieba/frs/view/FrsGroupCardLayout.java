package com.baidu.tieba.frs.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.databinding.FrsGroupCardLayoutBinding;
import com.baidu.tieba.frs.view.FrsGroupCardLayout;
import com.baidu.tieba.i68;
import com.baidu.tieba.ix7;
import com.baidu.tieba.k68;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.FeedGroupInfo;
import tbclient.FrsPage.GroupFeedCard;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\fH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/frs/view/FrsGroupCardLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/baidu/tieba/frs/databinding/FrsGroupCardLayoutBinding;", "curData", "Ltbclient/FrsPage/GroupFeedCard;", "curFeedData", "Lcom/baidu/tieba/frs/entelechy/data/FrsGroupFeedData;", "curSkinType", "", "rvAdapter", "Lcom/baidu/tieba/frs/view/GroupAdapter;", "initView", "", "onSkinChanged", "setData", "feedData", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsGroupCardLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGroupCardLayoutBinding a;
    public GroupAdapter b;
    public int c;
    public GroupFeedCard d;
    public ix7 e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsGroupCardLayout(Context context) {
        this(context, null, 2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsGroupCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        b();
        this.c = 3;
    }

    public /* synthetic */ FrsGroupCardLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void c(Function1 tmp0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tmp0, view2) == null) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(view2);
        }
    }

    public static final void d(Function1 tmp0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, tmp0, view2) == null) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(view2);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrsGroupCardLayoutBinding c = FrsGroupCardLayoutBinding.c(LayoutInflater.from(getContext()), this, true);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
            this.a = c;
            GroupAdapter groupAdapter = null;
            if (c == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                c = null;
            }
            ViewGroup.LayoutParams layoutParams = c.j.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003);
            this.b = new GroupAdapter(null, 1, null);
            FrsGroupCardLayoutBinding frsGroupCardLayoutBinding = this.a;
            if (frsGroupCardLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsGroupCardLayoutBinding = null;
            }
            RecyclerView recyclerView = frsGroupCardLayoutBinding.b;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            GroupAdapter groupAdapter2 = this.b;
            if (groupAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
                groupAdapter2 = null;
            }
            recyclerView.setAdapter(groupAdapter2);
            final Function1<View, Unit> function1 = new Function1<View, Unit>(this) { // from class: com.baidu.tieba.frs.view.FrsGroupCardLayout$initView$clickListener$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsGroupCardLayout this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View v) {
                    ix7 ix7Var;
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                        Intrinsics.checkNotNullParameter(v, "v");
                        Object tag = v.getTag();
                        Context context = v.getContext();
                        boolean z = tag instanceof FeedGroupInfo;
                        if (z && (context instanceof TbPageContextSupport)) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) context).getPageContext(), new String[]{((FeedGroupInfo) tag).jump_url});
                        }
                        if (z) {
                            k68.a aVar = k68.a;
                            ix7Var = this.this$0.e;
                            if (ix7Var != null) {
                                str = ix7Var.e();
                            } else {
                                str = null;
                            }
                            aVar.d(str, ((FeedGroupInfo) tag).name);
                        }
                    }
                }
            };
            FrsGroupCardLayoutBinding frsGroupCardLayoutBinding2 = this.a;
            if (frsGroupCardLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsGroupCardLayoutBinding2 = null;
            }
            frsGroupCardLayoutBinding2.h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.t78
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        FrsGroupCardLayout.c(Function1.this, view2);
                    }
                }
            });
            GroupAdapter groupAdapter3 = this.b;
            if (groupAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
            } else {
                groupAdapter = groupAdapter3;
            }
            groupAdapter.p(new View.OnClickListener() { // from class: com.baidu.tieba.v78
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        FrsGroupCardLayout.d(Function1.this, view2);
                    }
                }
            });
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void e() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.c = skinType;
            FrsGroupCardLayoutBinding frsGroupCardLayoutBinding = this.a;
            if (frsGroupCardLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsGroupCardLayoutBinding = null;
            }
            EMManager.from(frsGroupCardLayoutBinding.j).setCardType(0).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(frsGroupCardLayoutBinding.f).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02);
            frsGroupCardLayoutBinding.h.setBackground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0806eb));
            EMManager.from(frsGroupCardLayoutBinding.i).setTextColor(R.color.CAM_X0304).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            WebPManager.setPureDrawable(frsGroupCardLayoutBinding.g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            frsGroupCardLayoutBinding.c.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0806e9));
            frsGroupCardLayoutBinding.d.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0806ea));
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(ix7 feedData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, feedData) == null) {
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            this.e = feedData;
            GroupAdapter groupAdapter = null;
            if (!Intrinsics.areEqual(this.d, feedData.d())) {
                GroupFeedCard d = feedData.d();
                FrsGroupCardLayoutBinding frsGroupCardLayoutBinding = this.a;
                if (frsGroupCardLayoutBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    frsGroupCardLayoutBinding = null;
                }
                frsGroupCardLayoutBinding.f.setText(d.card_title);
                if (d.group_list.size() == 1) {
                    FrsGroupCardLayoutBinding frsGroupCardLayoutBinding2 = this.a;
                    if (frsGroupCardLayoutBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsGroupCardLayoutBinding2 = null;
                    }
                    frsGroupCardLayoutBinding2.b.setVisibility(8);
                    FrsGroupCardLayoutBinding frsGroupCardLayoutBinding3 = this.a;
                    if (frsGroupCardLayoutBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsGroupCardLayoutBinding3 = null;
                    }
                    frsGroupCardLayoutBinding3.c.setAlpha(0.3f);
                    FrsGroupCardLayoutBinding frsGroupCardLayoutBinding4 = this.a;
                    if (frsGroupCardLayoutBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsGroupCardLayoutBinding4 = null;
                    }
                    frsGroupCardLayoutBinding4.h.setVisibility(0);
                    FrsGroupCardLayoutBinding frsGroupCardLayoutBinding5 = this.a;
                    if (frsGroupCardLayoutBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsGroupCardLayoutBinding5 = null;
                    }
                    frsGroupCardLayoutBinding5.h.setTag(d.group_list.get(0));
                } else {
                    FrsGroupCardLayoutBinding frsGroupCardLayoutBinding6 = this.a;
                    if (frsGroupCardLayoutBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsGroupCardLayoutBinding6 = null;
                    }
                    frsGroupCardLayoutBinding6.b.setVisibility(0);
                    FrsGroupCardLayoutBinding frsGroupCardLayoutBinding7 = this.a;
                    if (frsGroupCardLayoutBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsGroupCardLayoutBinding7 = null;
                    }
                    frsGroupCardLayoutBinding7.c.setAlpha(1.0f);
                    FrsGroupCardLayoutBinding frsGroupCardLayoutBinding8 = this.a;
                    if (frsGroupCardLayoutBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsGroupCardLayoutBinding8 = null;
                    }
                    frsGroupCardLayoutBinding8.h.setVisibility(8);
                    GroupAdapter groupAdapter2 = this.b;
                    if (groupAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
                        groupAdapter2 = null;
                    }
                    groupAdapter2.setList(d.group_list);
                }
                this.d = d;
                i68.a.f(feedData.e());
            }
            k68.a.e(feedData.e());
            GroupAdapter groupAdapter3 = this.b;
            if (groupAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
            } else {
                groupAdapter = groupAdapter3;
            }
            groupAdapter.notifyDataSetChanged();
            e();
        }
    }
}
