package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecommendForumInfo;
/* loaded from: classes12.dex */
public class ItemHeaderView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f45027e;

    /* renamed from: f  reason: collision with root package name */
    public BarImageView f45028f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45029g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45030h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f45031i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45032j;

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
        init(context);
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f45027e = context;
            LayoutInflater.from(context).inflate(R.layout.forum_detail_header, (ViewGroup) this, true);
            setVisibility(8);
            this.f45028f = (BarImageView) findViewById(R.id.h_forum_portrait);
            this.f45029g = (TextView) findViewById(R.id.h_forum_name);
            this.f45030h = (TextView) findViewById(R.id.forum_authen);
            this.f45031i = (TextView) findViewById(R.id.h_fans_num);
            this.f45032j = (TextView) findViewById(R.id.h_thread_num);
            this.f45028f.setPlaceHolder(1);
        }
    }

    public void onChangeSkinType(ForumDetailActivity forumDetailActivity, int i2) {
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
        this.f45029g.setText(recommendForumInfo.forum_name);
        if (z) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_v);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.f45029g.setCompoundDrawables(null, null, bitmapDrawable, null);
            TextView textView = this.f45029g;
            Context context = this.f45027e;
            textView.setCompoundDrawablePadding(n.d(context, context.getResources().getDimension(R.dimen.ds4)));
            this.f45030h.setText(recommendForumInfo.authen);
            this.f45030h.setVisibility(0);
        } else {
            this.f45029g.setCompoundDrawables(null, null, null, null);
            this.f45030h.setVisibility(8);
        }
        this.f45031i.setText(StringHelper.numberUniformFormat(recommendForumInfo.member_count.intValue()));
        this.f45032j.setText(StringHelper.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
        int d2 = n.d(this.f45027e, 80.0f);
        this.f45028f.startLoad(recommendForumInfo.avatar, 10, d2, d2, false);
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
        init(context);
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
        init(context);
    }
}
