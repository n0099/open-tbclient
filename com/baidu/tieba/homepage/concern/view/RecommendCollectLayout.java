package com.baidu.tieba.homepage.concern.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a17;
import com.baidu.tieba.homepage.concern.adapter.ContentCollectListAdapter;
import com.baidu.tieba.rw4;
import com.baidu.tieba.tx;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class RecommendCollectLayout extends RelativeLayout implements tx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public ContentCollectListAdapter b;
    public BdRecyclerView c;
    public ImageView d;
    public EMTextView e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendCollectLayout(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0799, (ViewGroup) this, true);
            int g = yi.g(getContext(), R.dimen.M_W_X004);
            setPadding(g, 0, g, 0);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.c = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f090698);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f09069e);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cf6);
            this.b = new ContentCollectListAdapter(this.a);
            this.c.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.c.setAdapter(this.b);
        }
    }

    @Override // com.baidu.tieba.tx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            rw4 d = rw4.d(this.e);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X07);
            d.v(R.color.CAM_X0105);
            setBackground(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08029b, (WebPManager.ResourceStateType) null));
            ContentCollectListAdapter contentCollectListAdapter = this.b;
            if (contentCollectListAdapter != null) {
                contentCollectListAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setData(a17 a17Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a17Var) != null) || a17Var == null) {
            return;
        }
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            if (a17Var.c() > 0) {
                marginLayoutParams.topMargin = yi.g(getContext(), R.dimen.M_H_X001);
            } else {
                marginLayoutParams.topMargin = 0;
            }
            setLayoutParams(marginLayoutParams);
        }
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a2, SkinManager.getColor(R.color.CAM_X0306), null);
        pureDrawable.setBounds(0, 0, yi.g(getContext(), R.dimen.tbds96), yi.g(getContext(), R.dimen.T_X07));
        this.e.setCompoundDrawables(pureDrawable, null, null, null);
        this.e.setCompoundDrawablePadding(yi.g(getContext(), R.dimen.M_W_X001));
        this.e.setText(a17Var.getTitle());
        this.d.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080823, true));
        this.b.i(a17Var.getDataList());
        this.b.j(this.f);
        this.b.notifyDataSetChanged();
    }

    public void setSourceForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f = i;
        }
    }
}
