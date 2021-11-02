package com.baidu.tieba.faceshop.forumpackage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class ForumEmotionVoteEntryView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48137e;

    /* renamed from: f  reason: collision with root package name */
    public int f48138f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f48139g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48140h;

    /* renamed from: i  reason: collision with root package name */
    public View f48141i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionVoteEntryView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.forum_emotion_vote_entry_view, this);
            this.f48139g = (LinearLayout) findViewById(R.id.forum_vote_avatars);
            this.f48137e = context.getResources().getDimensionPixelSize(R.dimen.ds40);
            this.f48138f = context.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f48140h = (TextView) findViewById(R.id.forum_emotion_vote_title);
            this.f48141i = findViewById(R.id.forum_vote_bottom_line);
        }
    }

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f48139g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f48140h, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f48141i, R.color.common_color_10312);
        }
    }

    public void setAvatarList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f48139g.removeAllViews();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    TbImageView tbImageView = new TbImageView(getContext());
                    tbImageView.setDrawerType(1);
                    tbImageView.setIsRound(true);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    int i2 = this.f48137e;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                    layoutParams.leftMargin = this.f48138f;
                    layoutParams.gravity = 17;
                    tbImageView.startLoad(str, 10, false);
                    this.f48139g.addView(tbImageView, layoutParams);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionVoteEntryView(Context context, AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionVoteEntryView(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
