package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br4;
import com.repackage.cb6;
import com.repackage.er4;
import com.repackage.li;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public Context b;
    public TextView c;
    public TextView d;
    public TextView e;
    public LocalBannerLayout f;
    public er4 g;

    /* loaded from: classes3.dex */
    public class a implements er4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsPublishFineGoodsDialogView a;

        public a(FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPublishFineGoodsDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsPublishFineGoodsDialogView;
        }

        @Override // com.repackage.er4
        public void a(int i, br4 br4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, br4Var) == null) {
                this.a.c(i);
            }
        }

        @Override // com.repackage.er4
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPublishFineGoodsDialogView(Context context) {
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
        this.g = new a(this);
        this.b = context;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d033d, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090aba);
            this.a = linearLayout;
            this.c = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090bab);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090baa);
            this.f = (LocalBannerLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090300);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09206a);
            this.e = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f065b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new cb6(String.valueOf((int) R.drawable.pic_good_guide1)));
            arrayList.add(new cb6(String.valueOf((int) R.drawable.pic_good_guide2)));
            arrayList.add(new cb6(String.valueOf((int) R.drawable.pic_good_guide3)));
            this.f.setData(arrayList);
            this.f.setOnCoverViewCallback(this.g);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0302);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(li.f(this.b, R.dimen.tbds30)).brRadius(li.f(this.b, R.dimen.tbds30)).tlRadius(li.f(this.b, R.dimen.tbds32)).trRadius(li.f(this.b, R.dimen.tbds32)).into(this.a);
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 0 || i == 3) {
                this.c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06f9));
                this.d.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06f8));
            } else if (i == 1) {
                this.c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06fb));
                this.d.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06fa));
            } else if (i == 2) {
                this.c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06fd));
                this.d.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06fc));
            }
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.e.setOnClickListener(onClickListener);
    }
}
