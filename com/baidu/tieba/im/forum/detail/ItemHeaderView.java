package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
public class ItemHeaderView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public BarImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemHeaderView(Context context) {
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
        a(context);
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemHeaderView(Context context, AttributeSet attributeSet, int i) {
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
        a(context);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02f9, (ViewGroup) this, true);
            setVisibility(8);
            this.b = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090eeb);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090eea);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090bb7);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090ee9);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090eec);
            this.b.setPlaceHolder(1);
        }
    }

    public void b(ForumDetailActivity forumDetailActivity, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumDetailActivity, i) == null) {
            BDLayoutMode layoutMode = forumDetailActivity.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            forumDetailActivity.getLayoutMode().onModeChanged(this);
        }
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendForumInfo) != null) || recommendForumInfo == null) {
            return;
        }
        boolean z = true;
        if (recommendForumInfo.forum_type.intValue() != 1) {
            z = false;
        }
        this.c.setText(recommendForumInfo.forum_name);
        if (z) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_v);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.c.setCompoundDrawables(null, null, bitmapDrawable, null);
            TextView textView = this.c;
            Context context = this.a;
            textView.setCompoundDrawablePadding(BdUtilHelper.dip2px(context, context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070224)));
            this.d.setText(recommendForumInfo.authen);
            this.d.setVisibility(0);
        } else {
            this.c.setCompoundDrawables(null, null, null, null);
            this.d.setVisibility(8);
        }
        this.e.setText(StringHelper.numberUniformFormat(recommendForumInfo.member_count.intValue()));
        this.f.setText(StringHelper.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
        int dip2px = BdUtilHelper.dip2px(this.a, 80.0f);
        this.b.startLoad(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
        setVisibility(0);
    }
}
