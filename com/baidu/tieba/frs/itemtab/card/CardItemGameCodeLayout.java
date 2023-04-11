package com.baidu.tieba.frs.itemtab.card;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeListDialog;
import com.baidu.tieba.ii;
import com.baidu.tieba.ix;
import com.baidu.tieba.ld7;
import com.baidu.tieba.q25;
import com.baidu.tieba.v55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GameCodeList;
/* loaded from: classes4.dex */
public class CardItemGameCodeLayout extends RelativeLayout implements ix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public GameCodeListDialog e;
    public int f;
    public List<GameCodeList> g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemGameCodeLayout a;

        public a(CardItemGameCodeLayout cardItemGameCodeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemGameCodeLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemGameCodeLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !ListUtils.isEmpty(this.a.g)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new v55(14)));
                if (this.a.e == null) {
                    this.a.e = new GameCodeListDialog(view2.getContext());
                }
                this.a.e.setData(this.a.g);
                this.a.e.f((ViewGroup) ((Activity) view2.getContext()).findViewById(16908290));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemGameCodeLayout(Context context) {
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
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemGameCodeLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemGameCodeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            setPadding(ii.g(context, R.dimen.M_W_X006), ii.g(context, R.dimen.M_H_X005), ii.g(context, R.dimen.M_W_X006), ii.g(context, R.dimen.M_H_X005));
            ImageView imageView = new ImageView(context);
            this.a = imageView;
            imageView.setId(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ii.g(context, R.dimen.tbds62), ii.g(context, R.dimen.tbds62));
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            this.a.setLayoutParams(layoutParams);
            addView(this.a);
            this.b = new TextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.setMargins(ii.g(context, R.dimen.tbds23), 0, 0, 0);
            layoutParams2.addRule(1, this.a.getId());
            layoutParams2.addRule(15);
            this.b.setLayoutParams(layoutParams2);
            this.b.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0773));
            addView(this.b);
            ImageView imageView2 = new ImageView(context);
            this.d = imageView2;
            imageView2.setId(2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ii.g(context, R.dimen.tbds42), ii.g(context, R.dimen.tbds42));
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            this.d.setLayoutParams(layoutParams3);
            addView(this.d);
            this.c = new TextView(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams4.addRule(0, this.d.getId());
            layoutParams4.addRule(15);
            this.c.setLayoutParams(layoutParams4);
            addView(this.c);
            setOnClickListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.ix
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            q25 d = q25.d(this.b);
            d.w(R.color.CAM_X0105);
            d.B(R.dimen.T_X07);
            q25 d2 = q25.d(this.c);
            d2.w(R.color.CAM_X0107);
            d2.B(R.dimen.T_X08);
            q25 d3 = q25.d(this);
            d3.o(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
            WebPManager.setMaskDrawable(this.a, R.drawable.obfuscated_res_0x7f08083a, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.d, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            GameCodeListDialog gameCodeListDialog = this.e;
            if (gameCodeListDialog != null) {
                gameCodeListDialog.d();
            }
        }
    }

    public void setData(ld7 ld7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ld7Var) != null) || ld7Var == null) {
            return;
        }
        this.f = ld7Var.d();
        this.g = ld7Var.c();
        if (this.f != 0) {
            this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d1), Integer.valueOf(this.f)));
        } else {
            this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15d6));
        }
    }
}
