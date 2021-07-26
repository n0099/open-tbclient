package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class ItemHeaderView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f17584e;

    /* renamed from: f  reason: collision with root package name */
    public BarImageView f17585f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17586g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17587h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17588i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemHeaderView(Context context) {
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

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f17584e = context;
            LayoutInflater.from(context).inflate(R.layout.forum_detail_header, (ViewGroup) this, true);
            setVisibility(8);
            this.f17585f = (BarImageView) findViewById(R.id.h_forum_portrait);
            this.f17586g = (TextView) findViewById(R.id.h_forum_name);
            this.f17587h = (TextView) findViewById(R.id.forum_authen);
            this.f17588i = (TextView) findViewById(R.id.h_fans_num);
            this.j = (TextView) findViewById(R.id.h_thread_num);
            this.f17585f.setPlaceHolder(1);
        }
    }

    public void b(ForumDetailActivity forumDetailActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumDetailActivity, i2) == null) {
            forumDetailActivity.getLayoutMode().k(i2 == 1);
            forumDetailActivity.getLayoutMode().j(this);
        }
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendForumInfo) == null) || recommendForumInfo == null) {
            return;
        }
        boolean z = recommendForumInfo.forum_type.intValue() == 1;
        this.f17586g.setText(recommendForumInfo.forum_name);
        if (z) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_v);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.f17586g.setCompoundDrawables(null, null, bitmapDrawable, null);
            TextView textView = this.f17586g;
            Context context = this.f17584e;
            textView.setCompoundDrawablePadding(l.e(context, context.getResources().getDimension(R.dimen.ds4)));
            this.f17587h.setText(recommendForumInfo.authen);
            this.f17587h.setVisibility(0);
        } else {
            this.f17586g.setCompoundDrawables(null, null, null, null);
            this.f17587h.setVisibility(8);
        }
        this.f17588i.setText(StringHelper.numberUniformFormat(recommendForumInfo.member_count.intValue()));
        this.j.setText(StringHelper.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
        int e2 = l.e(this.f17584e, 80.0f);
        this.f17585f.J(recommendForumInfo.avatar, 10, e2, e2, false);
        setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemHeaderView(Context context, AttributeSet attributeSet) {
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
    public ItemHeaderView(Context context, AttributeSet attributeSet, int i2) {
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
