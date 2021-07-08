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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.x.b.d;
import d.a.p0.x.b.f;
/* loaded from: classes4.dex */
public class NewAnounceLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public float f14445h;

    /* renamed from: i  reason: collision with root package name */
    public Context f14446i;
    public View j;
    public TextView k;
    public View l;
    public TextView m;
    public TextView n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewAnounceLayout f14447e;

        public a(NewAnounceLayout newAnounceLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAnounceLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14447e = newAnounceLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_ANNOUNCE_AREA).eventStat();
                d dVar = this.f14447e.f14444g;
                if (dVar == null || dVar.k() == 0 || TextUtils.isEmpty(this.f14447e.f14444g.b()) || this.f14447e.f14444g.f() == 2) {
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f14447e.f14446i);
                pbActivityConfig.createNormalCfg(this.f14447e.f14444g.k() + "", (String) null, (String) null, true);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            View findViewById = findViewById(R.id.announce_content);
            this.j = findViewById;
            findViewById.setOnClickListener(this.o);
            this.k = (TextView) findViewById(R.id.first_line_tv);
            this.l = findViewById(R.id.second_content);
            this.m = (TextView) findViewById(R.id.second_line_tv);
            this.n = (TextView) findViewById(R.id.announce_tail);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14446i = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setGravity(17);
            setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.new_announce_layout, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f14444g == null) {
            return;
        }
        if (this.f14442e != d.a.p0.x.e.a.f66172c) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205, i2);
        } else {
            View view = this.j;
            if (view != null) {
                view.setBackgroundColor(0);
            }
        }
        if (TextUtils.isEmpty(this.f14444g.b())) {
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i2);
        } else {
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
        }
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0304, 1, i2);
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                this.l.setVisibility(0);
                int lineEnd = new StaticLayout(str, this.k.getPaint(), (int) this.f14445h, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
                String substring = str.substring(0, lineEnd);
                if (lineEnd >= str.length()) {
                    this.l.setVisibility(8);
                    this.k.setText(substring);
                    return;
                }
                String substring2 = str.substring(lineEnd, str.length());
                if (new StaticLayout(substring2, this.m.getPaint(), (int) this.f14445h, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                }
                this.l.setVisibility(0);
                this.k.setText(substring);
                this.m.setText(substring2);
                return;
            }
            this.l.setVisibility(8);
            this.k.setText(getResources().getString(R.string.empty_announce));
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            if (this.f14443f != null && this.f14444g != null && this.f14442e >= 0) {
                this.f14445h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
                if (this.f14442e == d.a.p0.x.e.a.f66171b) {
                    this.f14445h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds116) * 2);
                }
                if (this.f14442e == d.a.p0.x.e.a.f66173d) {
                    this.f14445h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds96) * 2);
                }
                if (this.f14442e == d.a.p0.x.e.a.f66172c) {
                    this.f14445h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds86) * 2);
                    this.j.setPadding(0, 0, 0, 0);
                    this.k.setPadding(0, 0, 0, 0);
                    this.m.setPadding(0, 0, 0, 0);
                    this.n.setPadding(0, 0, 0, 0);
                }
                e(this.f14444g.b());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        c();
    }
}
