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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TbImageView c;
    public View d;
    public HeadImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public NoActiveStopAlaPlayAnimationView k;
    public ProgressBar l;
    public FrameLayout m;
    public Animation n;
    public boolean o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        a(context);
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
        this.o = false;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
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
        this.o = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            this.n = AnimationUtils.loadAnimation(context, R.anim.obfuscated_res_0x7f01014d);
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0670, this);
            this.b = inflate;
            this.m = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0909c1);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0913e8);
            this.c = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.c.setAutoChangeStyle(false);
            View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f090dbd);
            this.d = findViewById;
            findViewById.setBackgroundResource(R.drawable.obfuscated_res_0x7f081065);
            this.e = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090e44);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e45);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e43);
            this.e.setIsRound(true);
            this.e.setAutoChangeStyle(false);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092446);
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09243c);
            this.j = (ImageView) this.b.findViewById(R.id.image_video_play);
            NoActiveStopAlaPlayAnimationView noActiveStopAlaPlayAnimationView = (NoActiveStopAlaPlayAnimationView) this.b.findViewById(R.id.obfuscated_res_0x7f09022a);
            this.k = noActiveStopAlaPlayAnimationView;
            noActiveStopAlaPlayAnimationView.setFromSpecialForum(this.o);
            SkinManager.setImageResource(this.j, R.drawable.btn_icon_play_live_on_n);
            this.l = (ProgressBar) this.b.findViewById(R.id.auto_video_loading_progress);
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) && threadData != null && threadData.getThreadAlaInfo() != null && threadData.getAuthor() != null) {
            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
            this.c.K(threadAlaInfo.cover, 10, false);
            AlaUserInfoData alaUserInfoData = threadAlaInfo.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.d.setVisibility(0);
                this.e.K(alaUserInfoData.portrait, 10, false);
                this.f.setText(threadData.getAuthor().getName_show());
                this.g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f127f), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.d.setVisibility(8);
            }
            this.h.setText(threadData.getTitle());
            this.i.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1284, String.valueOf(threadAlaInfo.audience_count)));
            if (!this.o) {
                this.k.b();
            }
        }
    }

    public void setFromSpecialForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.o = z;
            this.j.setVisibility(8);
            this.l.setVisibility(8);
            this.k.setVisibility(8);
            this.k.setFromSpecialForum(this.o);
        }
    }
}
