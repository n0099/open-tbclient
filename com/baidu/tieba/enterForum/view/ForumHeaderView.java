package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.o0.d.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ForumHeaderView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_ENTER_FORUM = 0;
    public static final int FROM_FORUM_SQUARE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f47779e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47780f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f47781g;

    /* renamed from: h  reason: collision with root package name */
    public c f47782h;

    /* renamed from: i  reason: collision with root package name */
    public int f47783i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumHeaderView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47783i = 0;
        init();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.layout_enterforum_search, (ViewGroup) this, true);
            this.f47779e = (LinearLayout) findViewById(R.id.search_container);
            this.f47780f = (TextView) findViewById(R.id.search_text);
            this.f47781g = (ImageView) findViewById(R.id.search_icon);
            setDescendantFocusability(262144);
            this.f47779e.setOnClickListener(this);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c cVar = this.f47782h;
            if (cVar != null && cVar.f21561a) {
                if (cVar.f21563c > 0) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47781g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
                    SkinManager.setViewTextColor(this.f47780f, R.color.white_alpha50);
                    SkinManager.setBackgroundResource(this.f47779e, R.drawable.enter_forum_search_ad_bg);
                    return;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47781g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.f47780f, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.f47779e, R.drawable.enter_forum_search_bg);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47781g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.f47780f, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f47779e, R.drawable.enter_forum_search_bg);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.eventStat(getContext(), "notlogin_8", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
            if (this.f47783i != 1) {
                TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
            } else {
                TiebaStatic.log(new StatisticItem("c13648").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(getContext())));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(l.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(l.g(getContext(), R.dimen.tbds114), 1073741824));
        }
    }

    public void setAdState(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f47782h = cVar;
            onChangeSkinType();
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f47783i = i2;
        }
    }

    public void setSearchHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f47780f.setText(str);
        }
    }

    public void updateMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f47779e.getLayoutParams();
            layoutParams.topMargin = i2;
            setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumHeaderView(Context context, AttributeSet attributeSet) {
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
        this.f47783i = 0;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumHeaderView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f47783i = 0;
        init();
    }
}
