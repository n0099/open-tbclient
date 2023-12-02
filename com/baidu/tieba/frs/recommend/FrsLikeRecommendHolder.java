package com.baidu.tieba.frs.recommend;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cva;
import com.baidu.tieba.view.SymbolEMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FrsLikeRecommendHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;
    public final BarImageView b;
    public final SymbolEMTextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d62);
        this.a = linearLayout;
        this.b = (BarImageView) linearLayout.findViewById(R.id.forum_head_image);
        this.c = (SymbolEMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5f);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5a);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c59);
        this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c4d);
        BarImageView barImageView = this.b;
        if (barImageView != null) {
            barImageView.setContentDescription(barImageView.getResources().getString(R.string.obfuscated_res_0x7f0f032c));
            this.b.setStrokeColorResId(R.color.CAM_X0401);
            BarImageView barImageView2 = this.b;
            barImageView2.setStrokeWith(BdUtilHelper.getDimens(barImageView2.getContext(), R.dimen.tbds3));
            this.b.setShowOval(true);
            this.b.setPlaceHolder(1);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void a(cva cvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cvaVar) == null) {
            BarImageView barImageView = this.b;
            if (barImageView != null) {
                barImageView.startLoad(cvaVar.b, 10, false);
            }
            SymbolEMTextView symbolEMTextView = this.c;
            if (symbolEMTextView != null) {
                symbolEMTextView.setText(cvaVar.c + this.c.getContext().getString(R.string.obfuscated_res_0x7f0f078f));
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(cvaVar.e);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setText(cvaVar.d);
            }
            TextView textView3 = this.f;
            if (textView3 != null) {
                if (cvaVar.f) {
                    textView3.setText(textView3.getContext().getString(R.string.obfuscated_res_0x7f0f077a));
                } else {
                    textView3.setText(textView3.getContext().getString(R.string.obfuscated_res_0x7f0f085f));
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = this.a;
            if (linearLayout != null) {
                EMManager.from(linearLayout).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0614);
            }
            SymbolEMTextView symbolEMTextView = this.c;
            if (symbolEMTextView != null) {
                EMManager.from(symbolEMTextView).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
            }
            TextView textView = this.e;
            if (textView != null) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0620);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                EMManager.from(textView2).setTextColor(R.color.CAM_X0620);
            }
            TextView textView3 = this.f;
            if (textView3 != null) {
                EMManager.from(textView3).setCorner(R.string.J_X01).setTextColor(R.color.CAM_X0105).setBackGroundColor(R.color.CAM_X0201);
            }
        }
    }

    public void c(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) && (textView = this.f) != null) {
            textView.setOnClickListener(onClickListener);
        }
    }
}
