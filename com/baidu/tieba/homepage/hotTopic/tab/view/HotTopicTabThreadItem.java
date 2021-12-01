package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import c.a.d.f.p.l;
import c.a.q0.n.f;
import c.a.r0.n1.f.a.e.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45278e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f45279f;

    /* renamed from: g  reason: collision with root package name */
    public View f45280g;

    /* renamed from: h  reason: collision with root package name */
    public View f45281h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f45282i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45283j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f45284k;
    public TextView l;
    public TextView m;
    public View n;
    public e o;
    public f<e> p;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabThreadItem f45285e;

        public a(HotTopicTabThreadItem hotTopicTabThreadItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabThreadItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45285e = hotTopicTabThreadItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45285e.o == null || this.f45285e.o.f20374j == null) {
                return;
            }
            if (this.f45285e.p != null) {
                this.f45285e.p.a(view, this.f45285e.o, this.f45285e.o.f20369e, this.f45285e.o.f20369e);
            }
            ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) this.f45285e.o.f20374j, view.getContext(), 2, false, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabThreadItem(Context context) {
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
        this.f45278e = 3;
        d();
    }

    public void bindData(e eVar) {
        e eVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
            return;
        }
        this.o = eVar;
        if (TextUtils.isEmpty(eVar.f20372h)) {
            this.f45279f.setVisibility(8);
            this.f45280g.setVisibility(8);
            this.f45281h.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.addRule(8, 0);
            layoutParams.addRule(3, R.id.titleView);
            this.m.setLayoutParams(layoutParams);
        } else {
            this.f45279f.startLoad(eVar.f20372h, 10, false);
            this.f45279f.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.addRule(8, R.id.coverView);
            layoutParams2.addRule(3, 0);
            this.m.setLayoutParams(layoutParams2);
            if (eVar.f20373i > 0) {
                this.f45281h.setVisibility(0);
                this.f45280g.setVisibility(0);
                this.f45283j.setText(StringUtils.translateSecondsToString(eVar.f20373i));
            } else {
                this.f45281h.setVisibility(8);
                this.f45280g.setVisibility(8);
            }
        }
        this.l.setText(eVar.f20370f);
        int i2 = eVar.f20371g;
        if (i2 < 1000) {
            i2 = 1000;
        }
        String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
        TextView textView = this.m;
        textView.setText(textView.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, numberUniformFormatExtraWithRoundInt));
        this.f45284k.setText(String.valueOf(eVar.f20369e));
        c();
        f<e> fVar = this.p;
        if (fVar == null || (eVar2 = this.o) == null) {
            return;
        }
        int i3 = eVar2.f20369e;
        fVar.c(this, eVar2, i3, i3);
    }

    public final void c() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.o) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(eVar.f20369e);
        Drawable background = this.m.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(indexTextColorRes));
        background.setAlpha(40);
        this.m.setBackgroundDrawable(background);
        SkinManager.setViewTextColor(this.m, indexTextColorRes);
        Drawable background2 = this.f45284k.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.f45284k.setBackgroundDrawable(background2);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
            this.f45279f = (TbImageView) findViewById(R.id.coverView);
            this.f45280g = findViewById(R.id.coverGradientMask);
            this.f45281h = findViewById(R.id.videoTimeContainer);
            this.f45282i = (ImageView) findViewById(R.id.videoPlayIcon);
            this.f45283j = (TextView) findViewById(R.id.videoPlayTime);
            this.f45284k = (TextView) findViewById(R.id.indexView);
            this.l = (TextView) findViewById(R.id.titleView);
            this.m = (TextView) findViewById(R.id.tagView);
            this.f45279f.setPlaceHolder(2);
            this.f45279f.setRadius(l.f(getContext(), R.dimen.tbds10));
            this.f45279f.setConrers(15);
            View findViewById = findViewById(R.id.rootLayout);
            this.n = findViewById;
            findViewById.setOnClickListener(new a(this));
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f45278e == i2) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f45284k, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f45283j, R.color.CAM_X0101);
        this.f45282i.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        c();
        this.f45278e = i2;
    }

    public void setOnItemCoverListener(f<e> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.p = fVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f45278e = 3;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f45278e = 3;
        d();
    }
}
