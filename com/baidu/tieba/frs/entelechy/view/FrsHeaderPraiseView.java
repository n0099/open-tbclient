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
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes7.dex */
public class FrsHeaderPraiseView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f50815e;

    /* renamed from: f  reason: collision with root package name */
    public View f50816f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50817g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f50818h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f50819i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AgreeBanner f50820e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsHeaderPraiseView f50821f;

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
            this.f50821f = frsHeaderPraiseView;
            this.f50820e = agreeBanner;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f50820e.url)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f50821f.getContext(), null, this.f50820e.url, true)));
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
            this.f50815e = findViewById(R.id.divider_top);
            this.f50816f = findViewById(R.id.divider_bottom);
            this.f50817g = (TextView) findViewById(R.id.frs_praise_title);
            this.f50818h = (FrameLayout) findViewById(R.id.frs_praise_portrait);
            ImageView imageView = (ImageView) findViewById(R.id.frs_praise_more);
            this.f50819i = imageView;
            SkinManager.setImageResource(imageView, R.drawable.icon_arrow_more_gray_n);
        }
    }

    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.home_thread_card_item_bg);
            SkinManager.setBackgroundColor(this.f50815e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f50816f, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f50817g, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f50819i, R.drawable.icon_arrow_more_gray_n);
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
            this.f50817g.setText(agreeBanner.text);
            List<SimpleUser> list = agreeBanner.top_agree_user;
            this.f50818h.removeAllViews();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                if (list.size() > 5) {
                    for (int i2 = 0; i2 < list.size() && i2 != 5; i2++) {
                        arrayList.add(list.get(i2));
                    }
                } else {
                    arrayList.addAll(list);
                }
                for (int size = arrayList.size() - 1; size >= 0 && this.f50818h.getChildCount() != 5; size--) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds40), getResources().getDimensionPixelSize(R.dimen.ds40));
                    HeadImageView headImageView = new HeadImageView(getContext());
                    headImageView.setDefaultResource(17170445);
                    headImageView.setDefaultBgResource(R.color.CAM_X0205);
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
                    headImageView.setBorderWidth(l.g(getContext(), R.dimen.ds2));
                    headImageView.startLoad(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                    if (size != arrayList.size() - 1) {
                        layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.ds8));
                    }
                    layoutParams.gravity = 5;
                    this.f50818h.addView(headImageView, layoutParams);
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
        LayoutInflater.from(context).inflate(R.layout.frs_header_extra_praise_layout, this);
        a();
    }
}
