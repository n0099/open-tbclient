package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hi6;
import com.baidu.tieba.ji6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VotedAreaLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context d;
    public TextView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VotedAreaLayout(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setMyRecordData(hi6 hi6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, hi6Var) == null) && hi6Var != null) {
            this.c = hi6Var;
            TextView textView = this.e;
            textView.setText(StringHelper.numFormatOverWan(this.c.m()) + "票");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VotedAreaLayout(Context context, AttributeSet attributeSet) {
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
        b();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = (TextView) findViewById(R.id.vote_num);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(17);
            setBackgroundResource(R.drawable.bar_select_bg_voted_area_layout);
            setMinimumHeight(BdUtilHelper.getDimens(getContext(), R.dimen.tbds62));
            setMinimumWidth(BdUtilHelper.getDimens(getContext(), R.dimen.tbds172));
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0a31, (ViewGroup) this, true);
            a();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
            SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_voted_area_layout, i);
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, ji6 ji6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, ji6Var) == null) {
            super.setData(i, ji6Var);
            if (this.b != null && this.c != null && this.a >= 0) {
                TextView textView = this.e;
                textView.setText(StringHelper.numFormatOverWan(this.c.m()) + "票");
                c(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            setVisibility(8);
        }
    }
}
