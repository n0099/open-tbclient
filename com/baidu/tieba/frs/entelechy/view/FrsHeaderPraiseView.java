package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes12.dex */
public class FrsHeaderPraiseView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f43294e;

    /* renamed from: f  reason: collision with root package name */
    public View f43295f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43296g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f43297h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f43298i;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AgreeBanner f43299e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsHeaderPraiseView f43300f;

        public a(FrsHeaderPraiseView frsHeaderPraiseView, AgreeBanner agreeBanner) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsHeaderPraiseView, agreeBanner};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43300f = frsHeaderPraiseView;
            this.f43299e = agreeBanner;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f43299e.url)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f43300f.getContext(), null, this.f43299e.url, true)));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsHeaderPraiseView(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f43294e = findViewById(f1.divider_top);
            this.f43295f = findViewById(f1.divider_bottom);
            this.f43296g = (TextView) findViewById(f1.frs_praise_title);
            this.f43297h = (FrameLayout) findViewById(f1.frs_praise_portrait);
            ImageView imageView = (ImageView) findViewById(f1.frs_praise_more);
            this.f43298i = imageView;
            SkinManager.setImageResource(imageView, e1.icon_arrow_more_gray_n);
        }
    }

    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundResource(this, e1.home_thread_card_item_bg);
            SkinManager.setBackgroundColor(this.f43294e, c1.CAM_X0204);
            SkinManager.setBackgroundColor(this.f43295f, c1.CAM_X0205);
            SkinManager.setViewTextColor(this.f43296g, c1.CAM_X0105);
            SkinManager.setImageResource(this.f43298i, e1.icon_arrow_more_gray_n);
        }
    }

    public void setData(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, agreeBanner) == null) {
            if (agreeBanner == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f43296g.setText(agreeBanner.text);
            List<SimpleUser> list = agreeBanner.top_agree_user;
            this.f43297h.removeAllViews();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                if (list.size() > 5) {
                    for (int i2 = 0; i2 < list.size() && i2 != 5; i2++) {
                        arrayList.add(list.get(i2));
                    }
                } else {
                    arrayList.addAll(list);
                }
                for (int size = arrayList.size() - 1; size >= 0 && this.f43297h.getChildCount() != 5; size--) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(d1.ds40), getResources().getDimensionPixelSize(d1.ds40));
                    HeadImageView headImageView = new HeadImageView(getContext());
                    headImageView.setDefaultResource(17170445);
                    headImageView.setDefaultBgResource(c1.CAM_X0205);
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(SkinManager.getColor(c1.CAM_X0201));
                    headImageView.setBorderWidth(n.f(getContext(), d1.ds2));
                    headImageView.startLoad(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                    if (size != arrayList.size() - 1) {
                        layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(d1.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(d1.ds8));
                    }
                    layoutParams.gravity = 5;
                    this.f43297h.addView(headImageView, layoutParams);
                }
            }
            setOnClickListener(new a(this, agreeBanner));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        LayoutInflater.from(context).inflate(g1.frs_header_extra_praise_layout, this);
        a();
    }
}
