package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
/* loaded from: classes5.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f13916e;

    /* renamed from: f  reason: collision with root package name */
    public View f13917f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13918g;

    /* renamed from: h  reason: collision with root package name */
    public View f13919h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f13920i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public NoActiveStopAlaPlayAnimationView o;
    public ProgressBar p;
    public FrameLayout q;
    public Animation r;
    public boolean s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSquareLiveVideoMask(Context context) {
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
        this.s = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f13916e = context;
            this.r = AnimationUtils.loadAnimation(context, R.anim.video_cover_fade_out);
            View inflate = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
            this.f13917f = inflate;
            this.q = (FrameLayout) inflate.findViewById(R.id.fade_out_view_root);
            TbImageView tbImageView = (TbImageView) this.f13917f.findViewById(R.id.live_cover);
            this.f13918g = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f13918g.setAutoChangeStyle(false);
            View findViewById = this.f13917f.findViewById(R.id.head_root_view);
            this.f13919h = findViewById;
            findViewById.setBackgroundResource(R.drawable.round_host_header_bg_n);
            this.f13920i = (HeadImageView) this.f13917f.findViewById(R.id.hostheader_image);
            this.j = (TextView) this.f13917f.findViewById(R.id.hostheader_name);
            this.k = (TextView) this.f13917f.findViewById(R.id.hostheader_id);
            this.f13920i.setIsRound(true);
            this.f13920i.setAutoChangeStyle(false);
            this.l = (TextView) this.f13917f.findViewById(R.id.tvSquareTitle);
            this.m = (TextView) this.f13917f.findViewById(R.id.tvLiveCount);
            this.n = (ImageView) this.f13917f.findViewById(R.id.image_video_play);
            NoActiveStopAlaPlayAnimationView noActiveStopAlaPlayAnimationView = (NoActiveStopAlaPlayAnimationView) this.f13917f.findViewById(R.id.ala_play);
            this.o = noActiveStopAlaPlayAnimationView;
            noActiveStopAlaPlayAnimationView.setFromSpecialForum(this.s);
            SkinManager.setImageResource(this.n, R.drawable.btn_icon_play_live_on_n);
            this.p = (ProgressBar) this.f13917f.findViewById(R.id.auto_video_loading_progress);
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.s) {
                this.o.c();
            }
            this.q.clearAnimation();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.s) {
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                this.o.setVisibility(8);
            }
            this.q.startAnimation(this.r);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.s) {
            return;
        }
        this.o.b();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.q.clearAnimation();
        }
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, b2Var) == null) || b2Var == null || b2Var.g1() == null || b2Var.H() == null) {
            return;
        }
        AlaInfoData g1 = b2Var.g1();
        this.f13918g.M(g1.cover, 10, false);
        AlaUserInfoData alaUserInfoData = g1.user_info;
        if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
            this.f13919h.setVisibility(0);
            this.f13920i.M(alaUserInfoData.portrait, 10, false);
            this.j.setText(b2Var.H().getName_show());
            this.k.setText(String.format(this.f13916e.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
        } else {
            this.f13919h.setVisibility(8);
        }
        this.l.setText(b2Var.getTitle());
        this.m.setText(this.f13916e.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(g1.audience_count)));
        if (this.s) {
            return;
        }
        this.o.b();
    }

    public void setFromSpecialForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.s = z;
            this.n.setVisibility(8);
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            this.o.setFromSpecialForum(this.s);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
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
        this.s = false;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i2) {
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
        this.s = false;
        a(context);
    }
}
