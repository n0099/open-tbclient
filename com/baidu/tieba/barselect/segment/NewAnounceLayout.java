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
import c.a.t0.c0.b.d;
import c.a.t0.c0.b.f;
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
/* loaded from: classes12.dex */
public class NewAnounceLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f42243e;

    /* renamed from: f  reason: collision with root package name */
    public Context f42244f;

    /* renamed from: g  reason: collision with root package name */
    public View f42245g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42246h;

    /* renamed from: i  reason: collision with root package name */
    public View f42247i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42248j;
    public TextView k;
    public View.OnClickListener l;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewAnounceLayout f42249e;

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
            this.f42249e = newAnounceLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_ANNOUNCE_AREA).eventStat();
                d dVar = this.f42249e.mElectionData;
                if (dVar == null || dVar.k() == 0 || TextUtils.isEmpty(this.f42249e.mElectionData.b()) || this.f42249e.mElectionData.f() == 2) {
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f42249e.f42244f);
                pbActivityConfig.createNormalCfg(this.f42249e.mElectionData.k() + "", (String) null, (String) null, true);
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
            this.f42245g = findViewById;
            findViewById.setOnClickListener(this.l);
            this.f42246h = (TextView) findViewById(R.id.first_line_tv);
            this.f42247i = findViewById(R.id.second_content);
            this.f42248j = (TextView) findViewById(R.id.second_line_tv);
            this.k = (TextView) findViewById(R.id.announce_tail);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                this.f42247i.setVisibility(0);
                int lineEnd = new StaticLayout(str, this.f42246h.getPaint(), (int) this.f42243e, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
                String substring = str.substring(0, lineEnd);
                if (lineEnd >= str.length()) {
                    this.f42247i.setVisibility(8);
                    this.f42246h.setText(substring);
                    return;
                }
                String substring2 = str.substring(lineEnd, str.length());
                if (new StaticLayout(substring2, this.f42248j.getPaint(), (int) this.f42243e, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
                    this.k.setVisibility(8);
                } else {
                    this.k.setVisibility(0);
                }
                this.f42247i.setVisibility(0);
                this.f42246h.setText(substring);
                this.f42248j.setText(substring2);
                return;
            }
            this.f42247i.setVisibility(8);
            this.f42246h.setText(getResources().getString(R.string.empty_announce));
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f42244f = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setGravity(17);
            setMinimumHeight(n.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.new_announce_layout, (ViewGroup) this, true);
            b();
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.mElectionData == null) {
            return;
        }
        if (this.status != c.a.t0.c0.e.a.f15308c) {
            SkinManager.setBackgroundColor(this.f42245g, R.color.CAM_X0205, i2);
        } else {
            View view = this.f42245g;
            if (view != null) {
                view.setBackgroundColor(0);
            }
        }
        if (TextUtils.isEmpty(this.mElectionData.b())) {
            SkinManager.setViewTextColor(this.f42246h, R.color.CAM_X0109, 1, i2);
        } else {
            SkinManager.setViewTextColor(this.f42246h, R.color.CAM_X0105, 1, i2);
        }
        SkinManager.setViewTextColor(this.f42248j, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0304, 1, i2);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            if (this.mData != null && this.mElectionData != null && this.status >= 0) {
                this.f42243e = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds70) * 2);
                if (this.status == c.a.t0.c0.e.a.f15307b) {
                    this.f42243e = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds116) * 2);
                }
                if (this.status == c.a.t0.c0.e.a.f15309d) {
                    this.f42243e = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds96) * 2);
                }
                if (this.status == c.a.t0.c0.e.a.f15308c) {
                    this.f42243e = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds86) * 2);
                    this.f42245g.setPadding(0, 0, 0, 0);
                    this.f42246h.setPadding(0, 0, 0, 0);
                    this.f42248j.setPadding(0, 0, 0, 0);
                    this.k.setPadding(0, 0, 0, 0);
                }
                c(this.mElectionData.b());
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
        this.l = new a(this);
        initUI();
    }
}
