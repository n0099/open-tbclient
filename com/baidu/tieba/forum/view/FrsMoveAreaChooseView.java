package com.baidu.tieba.forum.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lj7;
import com.baidu.tieba.z67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
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
    public a h;
    public View.OnClickListener i;
    public String j;
    public int k;

    /* loaded from: classes6.dex */
    public interface a {
        void a(@NonNull z67 z67Var);
    }

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

    public int getMoveTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            z67 m = this.f.m();
            if (m != null) {
                return m.b();
            }
            return 1;
        }
        return invokeV.intValue;
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
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getTag() instanceof z67) {
                b();
            } else if (view2 == this.d) {
                if (this.a != null && getParent() != null && this.f.l() >= 0) {
                    boolean z = SharedPrefHelper.getInstance().getBoolean("key_frs_move_area_tip", true);
                    z67 m = this.f.m();
                    if (m != null) {
                        if (z) {
                            lj7.a(this.a, this.j, this.k, m, this.h);
                        } else if (this.h != null) {
                            view2.setTag("choose_done");
                            this.h.a(m);
                        }
                    }
                }
            } else if (view2 == this.g && this.i != null) {
                view2.setTag("cancel_view");
                this.i.onClick(view2);
            }
        }
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void setDoneListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.h = aVar;
        }
    }

    public void setData(List<z67> list, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, list, i, str) == null) {
            this.f.q(list, i);
            this.j = str;
            this.k = i;
            b();
        }
    }
}
