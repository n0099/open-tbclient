package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final View b;
    public final ThreadAchievementShareInfo.ParamBean c;
    public TbImageView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;

    public dz4(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (paramBean = this.c) != null && paramBean.getVideo_info() != null && !TextUtils.isEmpty(this.c.getVideo_info().getThumbnail_url())) {
            this.d.N(this.c.getVideo_info().getThumbnail_url(), 10, false);
            this.i.setText(StringHelper.numFormatOverWanWithNegative(this.c.getAgree_num()));
            this.f.setText(StringHelper.numFormatOverWanWithNegative(this.c.getPost_num()));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = (TextView) this.b.findViewById(R.id.comment_num);
            this.g = (TextView) this.b.findViewById(R.id.comment_desc);
            this.h = (TextView) this.b.findViewById(R.id.praise_desc);
            TextView textView = (TextView) this.b.findViewById(R.id.praise_num);
            this.i = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.video_img);
            this.d = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setPlaceHolder(2);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.play_icon);
            this.e = imageView;
            imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
        }
    }
}
