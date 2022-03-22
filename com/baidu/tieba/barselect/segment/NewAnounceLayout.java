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
import c.a.d.f.p.n;
import c.a.p0.e0.b.d;
import c.a.p0.e0.b.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NewAnounceLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public float f31574d;

    /* renamed from: e  reason: collision with root package name */
    public Context f31575e;

    /* renamed from: f  reason: collision with root package name */
    public View f31576f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31577g;

    /* renamed from: h  reason: collision with root package name */
    public View f31578h;
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_ANNOUNCE_AREA).eventStat();
                d dVar = this.a.f31573c;
                if (dVar == null || dVar.k() == 0 || TextUtils.isEmpty(this.a.f31573c.b()) || this.a.f31573c.f() == 2) {
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.f31575e);
                pbActivityConfig.createNormalCfg(this.a.f31573c.k() + "", (String) null, (String) null, true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09026f);
            this.f31576f = findViewById;
            findViewById.setOnClickListener(this.k);
            this.f31577g = (TextView) findViewById(R.id.obfuscated_res_0x7f0909a5);
            this.f31578h = findViewById(R.id.obfuscated_res_0x7f091c54);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091c5c);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f090271);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31575e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setGravity(17);
            setMinimumHeight(n.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05f1, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.f31573c == null) {
            return;
        }
        if (this.a != c.a.p0.e0.e.a.f13758c) {
            SkinManager.setBackgroundColor(this.f31576f, R.color.CAM_X0205, i);
        } else {
            View view = this.f31576f;
            if (view != null) {
                view.setBackgroundColor(0);
            }
        }
        if (TextUtils.isEmpty(this.f31573c.b())) {
            SkinManager.setViewTextColor(this.f31577g, R.color.CAM_X0109, 1, i);
        } else {
            SkinManager.setViewTextColor(this.f31577g, R.color.CAM_X0105, 1, i);
        }
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0304, 1, i);
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                this.f31578h.setVisibility(0);
                int lineEnd = new StaticLayout(str, this.f31577g.getPaint(), (int) this.f31574d, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
                String substring = str.substring(0, lineEnd);
                if (lineEnd >= str.length()) {
                    this.f31578h.setVisibility(8);
                    this.f31577g.setText(substring);
                    return;
                }
                String substring2 = str.substring(lineEnd, str.length());
                if (new StaticLayout(substring2, this.i.getPaint(), (int) this.f31574d, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
                    this.j.setVisibility(8);
                } else {
                    this.j.setVisibility(0);
                }
                this.f31578h.setVisibility(0);
                this.f31577g.setText(substring);
                this.i.setText(substring2);
                return;
            }
            this.f31578h.setVisibility(8);
            this.f31577g.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0555));
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, fVar) == null) {
            super.setData(i, fVar);
            if (this.f31572b != null && this.f31573c != null && this.a >= 0) {
                this.f31574d = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds70) * 2);
                if (this.a == c.a.p0.e0.e.a.f13757b) {
                    this.f31574d = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds116) * 2);
                }
                if (this.a == c.a.p0.e0.e.a.f13759d) {
                    this.f31574d = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds96) * 2);
                }
                if (this.a == c.a.p0.e0.e.a.f13758c) {
                    this.f31574d = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds86) * 2);
                    this.f31576f.setPadding(0, 0, 0, 0);
                    this.f31577g.setPadding(0, 0, 0, 0);
                    this.i.setPadding(0, 0, 0, 0);
                    this.j.setPadding(0, 0, 0, 0);
                }
                e(this.f31573c.b());
                return;
            }
            setVisibility(8);
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
}
