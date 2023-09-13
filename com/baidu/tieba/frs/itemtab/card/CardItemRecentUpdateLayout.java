package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.MultiLineEllipsizeTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.va5;
import com.baidu.tieba.vx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecentUpdate;
/* loaded from: classes5.dex */
public class CardItemRecentUpdateLayout extends LinearLayout implements vx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public View d;
    public FrameLayout e;
    public MultiLineEllipsizeTextView f;
    public EMTextView g;
    public String h;
    public boolean i;

    /* loaded from: classes5.dex */
    public class a implements MultiLineEllipsizeTextView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemRecentUpdateLayout a;

        public a(CardItemRecentUpdateLayout cardItemRecentUpdateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecentUpdateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemRecentUpdateLayout;
        }

        @Override // com.baidu.tbadk.core.view.MultiLineEllipsizeTextView.a
        public void a(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            EMTextView eMTextView = this.a.g;
            if (!z && !this.a.i) {
                i = 8;
            } else {
                i = 0;
            }
            eMTextView.setVisibility(i);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemRecentUpdateLayout a;

        public b(CardItemRecentUpdateLayout cardItemRecentUpdateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecentUpdateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemRecentUpdateLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CardItemRecentUpdateLayout cardItemRecentUpdateLayout = this.a;
                cardItemRecentUpdateLayout.i = !cardItemRecentUpdateLayout.i;
                if (!this.a.i) {
                    this.a.g.setText(R.string.obfuscated_res_0x7f0f06ed);
                    this.a.f.setMaxLines(3);
                    return;
                }
                this.a.g.setText(R.string.obfuscated_res_0x7f0f0760);
                this.a.f.setMaxLines(Integer.MAX_VALUE);
                this.a.f.setText(this.a.h);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new va5(10)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecentUpdateLayout(Context context) {
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
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecentUpdateLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecentUpdateLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        f(context);
    }

    public void setData(RecentUpdate recentUpdate) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recentUpdate) != null) || recentUpdate == null) {
            return;
        }
        String str = recentUpdate.log;
        this.h = str;
        this.f.setText(str);
        this.b.setText(recentUpdate.version);
        this.c.setText(recentUpdate.update_time);
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01ce, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0911da);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0911db);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0911d7);
            this.d = findViewById(R.id.obfuscated_res_0x7f0911d9);
            this.e = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0911d8);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView = new MultiLineEllipsizeTextView(context);
            this.f = multiLineEllipsizeTextView;
            multiLineEllipsizeTextView.setMaxLines(3);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView2 = this.f;
            multiLineEllipsizeTextView2.setIconWidthForLastLine((int) multiLineEllipsizeTextView2.getPaint().measureText(String.valueOf(getResources().getText(R.string.obfuscated_res_0x7f0f06ed))));
            EMManager.from(this.f).setTextSize(R.dimen.T_X06).setTextLinePadding(R.dimen.M_T_X002);
            this.f.setPadding(BdUtilHelper.getDimens(context, R.dimen.M_W_X005), 0, 0, BdUtilHelper.getDimens(context, R.dimen.M_H_X005));
            this.e.addView(this.f, new LinearLayout.LayoutParams(-1, -2));
            this.f.setOnTextMeasuredCallback(new a(this));
            EMTextView eMTextView = new EMTextView(context);
            this.g = eMTextView;
            eMTextView.setText(R.string.obfuscated_res_0x7f0f06ed);
            EMManager.from(this.f).setTextSize(R.dimen.T_X06);
            this.g.setPadding(BdUtilHelper.getDimens(context, R.dimen.M_W_X005), BdUtilHelper.getDimens(context, R.dimen.M_H_X005), 0, BdUtilHelper.getDimens(context, R.dimen.M_H_X005));
            this.g.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            this.e.addView(this.g, layoutParams);
            this.g.setOnClickListener(new b(this));
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.a).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.b).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.c).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.f).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.g).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0304);
            EMManager.from(this.d).setBackGroundColor(R.color.CAM_X0111);
        }
    }
}
