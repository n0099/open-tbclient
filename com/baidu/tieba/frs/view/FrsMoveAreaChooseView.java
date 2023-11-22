package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.b58;
import com.baidu.tieba.gp7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03a5, this);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090d74);
            this.c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090d78);
            this.d = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090d76);
            this.g = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090d75);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090d77);
            this.e = recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            this.e.addItemDecoration(new GridSpacingItemDecoration(3, BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003), false));
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
            if (this.f.m() >= 0) {
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
            EMManager.from(this.b).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
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
                if (this.a != null && getParent() != null && this.f.m() >= 0) {
                    boolean z = SharedPrefHelper.getInstance().getBoolean("key_frs_move_area_tip", true);
                    List<FrsTabInfo> g = gp7.h().g();
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(g, this.f.l());
                    FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(g, this.f.m());
                    if (frsTabInfo != null && frsTabInfo2 != null) {
                        if (z) {
                            b58.a(this.a, frsTabInfo, frsTabInfo2);
                        } else {
                            gp7.h().m(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
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
