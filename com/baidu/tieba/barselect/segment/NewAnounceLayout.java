package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tieba.R;
import com.baidu.tieba.fi6;
import com.baidu.tieba.wh6;
import com.baidu.tieba.xi;
import com.baidu.tieba.yh6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NewAnounceLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float d;
    public Context e;
    public View f;
    public TextView g;
    public View h;
    public TextView i;
    public TextView j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewAnounceLayout a;

        public a(NewAnounceLayout newAnounceLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAnounceLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAnounceLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_ANNOUNCE_AREA).eventStat();
                wh6 wh6Var = this.a.c;
                if (wh6Var != null && wh6Var.k() != 0 && !TextUtils.isEmpty(this.a.c.b()) && this.a.c.f() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.e);
                    pbActivityConfig.createNormalCfg(this.a.c.k() + "", (String) null, (String) null, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewAnounceLayout(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
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
        this.k = new a(this);
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f090291);
            this.f = findViewById;
            findViewById.setOnClickListener(this.k);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090b0a);
            this.h = findViewById(R.id.obfuscated_res_0x7f0920d7);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0920e3);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f090293);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setGravity(17);
            setMinimumHeight(xi.g(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d06d7, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.c == null) {
            return;
        }
        if (this.a != fi6.c) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205, i);
        } else {
            View view2 = this.f;
            if (view2 != null) {
                view2.setBackgroundColor(0);
            }
        }
        if (TextUtils.isEmpty(this.c.b())) {
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0109, 1, i);
        } else {
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
        }
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0304, 1, i);
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                this.h.setVisibility(0);
                int lineEnd = new StaticLayout(str, this.g.getPaint(), (int) this.d, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
                String substring = str.substring(0, lineEnd);
                if (lineEnd >= str.length()) {
                    this.h.setVisibility(8);
                    this.g.setText(substring);
                    return;
                }
                String substring2 = str.substring(lineEnd, str.length());
                if (new StaticLayout(substring2, this.i.getPaint(), (int) this.d, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
                    this.j.setVisibility(8);
                } else {
                    this.j.setVisibility(0);
                }
                this.h.setVisibility(0);
                this.g.setText(substring);
                this.i.setText(substring2);
                return;
            }
            this.h.setVisibility(8);
            this.g.setText(getResources().getString(R.string.empty_announce));
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, yh6 yh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, yh6Var) == null) {
            super.setData(i, yh6Var);
            if (this.b != null && this.c != null && this.a >= 0) {
                this.d = xi.t((Activity) getContext()).widthPixels - (xi.g(getContext(), R.dimen.tbds70) * 2);
                if (this.a == fi6.b) {
                    this.d = xi.t((Activity) getContext()).widthPixels - (xi.g(getContext(), R.dimen.tbds116) * 2);
                }
                if (this.a == fi6.d) {
                    this.d = xi.t((Activity) getContext()).widthPixels - (xi.g(getContext(), R.dimen.tbds96) * 2);
                }
                if (this.a == fi6.c) {
                    this.d = xi.t((Activity) getContext()).widthPixels - (xi.g(getContext(), R.dimen.tbds86) * 2);
                    this.f.setPadding(0, 0, 0, 0);
                    this.g.setPadding(0, 0, 0, 0);
                    this.i.setPadding(0, 0, 0, 0);
                    this.j.setPadding(0, 0, 0, 0);
                }
                e(this.c.b());
                return;
            }
            setVisibility(8);
        }
    }
}
