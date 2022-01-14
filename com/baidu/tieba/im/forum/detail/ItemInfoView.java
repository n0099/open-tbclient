package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.x.p.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tbclient.PbContent;
import tbclient.RecommendForumInfo;
/* loaded from: classes12.dex */
public class ItemInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45014e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemInfoView(Context context) {
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

    public final SpannableStringBuilder a(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, str)) == null) {
            b bVar = new b();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + StringUtils.LF);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    if (pbContent.type.intValue() == 2) {
                        Bitmap cashBitmap = BitmapHelper.getCashBitmap(bVar.d(pbContent.text));
                        if (cashBitmap != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(cashBitmap);
                            bitmapDrawable.setBounds(0, 0, cashBitmap.getWidth(), cashBitmap.getHeight());
                            ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 0);
                            int length = spannableStringBuilder.length() - 1;
                            spannableStringBuilder.setSpan(imageSpan, length, length + 1, 33);
                        }
                    } else {
                        spannableStringBuilder.append((CharSequence) pbContent.text);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.forum_detail_info, (ViewGroup) this, true);
            setVisibility(8);
            this.f45014e = (TextView) findViewById(R.id.info_brief_content);
        }
    }

    public void onChangeSkinType(ForumDetailActivity forumDetailActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, forumDetailActivity, i2) == null) {
            SkinManager.setViewTextColor(this.f45014e, R.color.common_color_10177, 1);
            forumDetailActivity.getLayoutMode().k(i2 == 1);
            forumDetailActivity.getLayoutMode().j(this);
        }
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        List<PbContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, recommendForumInfo) == null) {
            if ((recommendForumInfo != null && (list = recommendForumInfo.content) != null && list.size() > 0) || (recommendForumInfo != null && !m.isEmpty(recommendForumInfo.slogan))) {
                this.f45014e.setText(a(recommendForumInfo.content, recommendForumInfo.slogan));
            } else {
                this.f45014e.setText(getResources().getString(R.string.forum_detail_info_no_brief));
            }
            setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemInfoView(Context context, AttributeSet attributeSet) {
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
}
