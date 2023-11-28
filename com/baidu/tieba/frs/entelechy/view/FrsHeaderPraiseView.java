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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
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
/* loaded from: classes6.dex */
public class FrsHeaderPraiseView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public TextView c;
    public FrameLayout d;
    public ImageView e;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeBanner a;
        public final /* synthetic */ FrsHeaderPraiseView b;

        public a(FrsHeaderPraiseView frsHeaderPraiseView, AgreeBanner agreeBanner) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsHeaderPraiseView, agreeBanner};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsHeaderPraiseView;
            this.a = agreeBanner;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || TextUtils.isEmpty(this.a.url)) {
                return;
            }
            BrowserHelper.startWebActivity(this.b.getContext(), (String) null, this.a.url, true);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d038d, this);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = findViewById(R.id.divider_top);
            this.b = findViewById(R.id.divider_bottom);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090db1);
            this.d = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090db0);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090dae);
            this.e = imageView;
            SkinManager.setImageResource(imageView, R.drawable.icon_arrow_more_gray_n);
        }
    }

    public void setData(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, agreeBanner) == null) {
            if (agreeBanner == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.c.setText(agreeBanner.text);
            List<SimpleUser> list = agreeBanner.top_agree_user;
            this.d.removeAllViews();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                if (list.size() > 5) {
                    for (int i = 0; i < list.size() && i != 5; i++) {
                        arrayList.add(list.get(i));
                    }
                } else {
                    arrayList.addAll(list);
                }
                for (int size = arrayList.size() - 1; size >= 0 && this.d.getChildCount() != 5; size--) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225), getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225));
                    HeadImageView headImageView = new HeadImageView(getContext());
                    headImageView.setDefaultResource(17170445);
                    headImageView.setDefaultBgResource(R.color.CAM_X0205);
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
                    headImageView.setBorderWidth(BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701d4));
                    headImageView.startLoad(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                    if (size != arrayList.size() - 1) {
                        layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041c));
                    }
                    layoutParams.gravity = 5;
                    this.d.addView(headImageView, layoutParams);
                }
            }
            setOnClickListener(new a(this, agreeBanner));
        }
    }
}
