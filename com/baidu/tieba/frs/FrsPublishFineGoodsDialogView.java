package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.c35;
import com.baidu.tieba.es7;
import com.baidu.tieba.f35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public Context b;
    public TextView c;
    public TextView d;
    public TextView e;
    public LocalBannerLayout f;
    public f35 g;

    /* loaded from: classes6.dex */
    public class a implements f35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsPublishFineGoodsDialogView a;

        @Override // com.baidu.tieba.f35
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }

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

        @Override // com.baidu.tieba.f35
        public void a(int i, c35 c35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, c35Var) == null) {
                this.a.c(i);
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
            LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
            this.a = linearLayout;
            this.c = (TextView) linearLayout.findViewById(R.id.frs_shop_guide_title);
            this.d = (TextView) this.a.findViewById(R.id.frs_shop_guide_content);
            this.f = (LocalBannerLayout) this.a.findViewById(R.id.banner_layout);
            TextView textView = (TextView) this.a.findViewById(R.id.to_next_tv);
            this.e = textView;
            textView.setText(R.string.forum_broadcast_major_history_known);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new es7(String.valueOf((int) R.drawable.pic_good_guide1)));
            arrayList.add(new es7(String.valueOf((int) R.drawable.pic_good_guide2)));
            arrayList.add(new es7(String.valueOf((int) R.drawable.pic_good_guide3)));
            this.f.setData(arrayList);
            this.f.setOnCoverViewCallback(this.g);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0302);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds30)).brRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds30)).tlRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds32)).trRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds32)).into(this.a);
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i != 0 && i != 3) {
                if (i == 1) {
                    this.c.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
                    this.d.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
                    return;
                } else if (i == 2) {
                    this.c.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
                    this.d.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
                    return;
                } else {
                    return;
                }
            }
            this.c.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.d.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) && onClickListener != null) {
            this.e.setOnClickListener(onClickListener);
        }
    }
}
