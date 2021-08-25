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
import c.a.p0.s.q.c2;
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
/* loaded from: classes7.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49244e;

    /* renamed from: f  reason: collision with root package name */
    public View f49245f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f49246g;

    /* renamed from: h  reason: collision with root package name */
    public View f49247h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f49248i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f49249j;
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
            this.f49244e = context;
            this.r = AnimationUtils.loadAnimation(context, R.anim.video_cover_fade_out);
            View inflate = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
            this.f49245f = inflate;
            this.q = (FrameLayout) inflate.findViewById(R.id.fade_out_view_root);
            TbImageView tbImageView = (TbImageView) this.f49245f.findViewById(R.id.live_cover);
            this.f49246g = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f49246g.setAutoChangeStyle(false);
            View findViewById = this.f49245f.findViewById(R.id.head_root_view);
            this.f49247h = findViewById;
            findViewById.setBackgroundResource(R.drawable.round_host_header_bg_n);
            this.f49248i = (HeadImageView) this.f49245f.findViewById(R.id.hostheader_image);
            this.f49249j = (TextView) this.f49245f.findViewById(R.id.hostheader_name);
            this.k = (TextView) this.f49245f.findViewById(R.id.hostheader_id);
            this.f49248i.setIsRound(true);
            this.f49248i.setAutoChangeStyle(false);
            this.l = (TextView) this.f49245f.findViewById(R.id.tvSquareTitle);
            this.m = (TextView) this.f49245f.findViewById(R.id.tvLiveCount);
            this.n = (ImageView) this.f49245f.findViewById(R.id.image_video_play);
            NoActiveStopAlaPlayAnimationView noActiveStopAlaPlayAnimationView = (NoActiveStopAlaPlayAnimationView) this.f49245f.findViewById(R.id.ala_play);
            this.o = noActiveStopAlaPlayAnimationView;
            noActiveStopAlaPlayAnimationView.setFromSpecialForum(this.s);
            SkinManager.setImageResource(this.n, R.drawable.btn_icon_play_live_on_n);
            this.p = (ProgressBar) this.f49245f.findViewById(R.id.auto_video_loading_progress);
            onChangeSkin();
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f49249j, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.s) {
                this.o.stopPlayAnimation();
            }
            this.q.clearAnimation();
        }
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, c2Var) == null) || c2Var == null || c2Var.j1() == null || c2Var.J() == null) {
            return;
        }
        AlaInfoData j1 = c2Var.j1();
        this.f49246g.startLoad(j1.cover, 10, false);
        AlaUserInfoData alaUserInfoData = j1.user_info;
        if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
            this.f49247h.setVisibility(0);
            this.f49248i.startLoad(alaUserInfoData.portrait, 10, false);
            this.f49249j.setText(c2Var.J().getName_show());
            this.k.setText(String.format(this.f49244e.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
        } else {
            this.f49247h.setVisibility(8);
        }
        this.l.setText(c2Var.getTitle());
        this.m.setText(this.f49244e.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(j1.audience_count)));
        if (this.s) {
            return;
        }
        this.o.startPlayAnimation();
    }

    public void setFromSpecialForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.s = z;
            this.n.setVisibility(8);
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            this.o.setFromSpecialForum(this.s);
        }
    }

    public void startFadeAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.s) {
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                this.o.setVisibility(8);
            }
            this.q.startAnimation(this.r);
        }
    }

    public void startIconAnim() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.s) {
            return;
        }
        this.o.startPlayAnimation();
    }

    public void stopFadeAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q.clearAnimation();
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
