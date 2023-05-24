package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.o65;
import com.baidu.tieba.p45;
import com.baidu.tieba.ri;
import com.baidu.tieba.t77;
import com.baidu.tieba.xm7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public RelativeLayout b;
    public EMTextView c;
    public EMTextView d;
    public RecyclerView e;
    public FrsMoveAreaChooseAdapter f;
    public EMTextView g;
    public View.OnClickListener h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMoveAreaChooseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.a = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setGravity(80);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0375, this);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090cef);
            this.c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090cf3);
            this.d = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090cf1);
            this.g = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090cf0);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090cf2);
            this.e = recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            this.e.addItemDecoration(new GridSpacingItemDecoration(3, ri.g(getContext(), R.dimen.M_W_X004), ri.g(getContext(), R.dimen.M_H_X003), false));
            FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter = new FrsMoveAreaChooseAdapter(this);
            this.f = frsMoveAreaChooseAdapter;
            this.e.setAdapter(frsMoveAreaChooseAdapter);
            this.b.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.g.setOnClickListener(this);
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f.l() >= 0) {
                this.d.setAlpha(1.0f);
            } else {
                this.d.setAlpha(0.5f);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0605);
            p45 d = p45.d(this.b);
            d.o(R.string.J_X14);
            d.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0304);
            b();
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2.getTag() instanceof Integer) {
                b();
            } else if (view2 == this.d) {
                if (this.a != null && getParent() != null && this.f.l() >= 0) {
                    boolean i = o65.m().i("key_frs_move_area_tip", true);
                    List<FrsTabInfo> g = t77.h().g();
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(g, this.f.k());
                    FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(g, this.f.l());
                    if (frsTabInfo != null && frsTabInfo2 != null) {
                        if (i) {
                            xm7.a(this.a, frsTabInfo, frsTabInfo2);
                        } else {
                            t77.h().m(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        }
                        if (this.h != null) {
                            view2.setTag("choose_done");
                            this.h.onClick(view2);
                        }
                    }
                }
            } else if (view2 == this.g && this.h != null) {
                view2.setTag("cancel_view");
                this.h.onClick(view2);
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.h = onClickListener;
            super.setOnClickListener(onClickListener);
        }
    }
}
