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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.hv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbContent;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class ItemInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemInfoView(Context context) {
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
    public ItemInfoView(Context context, AttributeSet attributeSet) {
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

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02c7, (ViewGroup) this, true);
            setVisibility(8);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09108e);
        }
    }

    public void b(ForumDetailActivity forumDetailActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumDetailActivity, i) == null) {
            boolean z = true;
            SkinManager.setViewTextColor(this.a, R.color.common_color_10177, 1);
            hv4 layoutMode = forumDetailActivity.getLayoutMode();
            if (i != 4) {
                z = false;
            }
            layoutMode.l(z);
            forumDetailActivity.getLayoutMode().k(this);
        }
    }

    public final SpannableStringBuilder c(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "\n");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = list.get(i);
                if (pbContent != null) {
                    if (pbContent.type.intValue() == 2) {
                        Bitmap b = TbFaceManager.i().b(pbContent.text);
                        if (b != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(b);
                            bitmapDrawable.setBounds(0, 0, b.getWidth(), b.getHeight());
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

    public void setData(RecommendForumInfo recommendForumInfo) {
        List<PbContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, recommendForumInfo) == null) {
            if ((recommendForumInfo != null && (list = recommendForumInfo.content) != null && list.size() > 0) || (recommendForumInfo != null && !hi.isEmpty(recommendForumInfo.slogan))) {
                this.a.setText(c(recommendForumInfo.content, recommendForumInfo.slogan));
            } else {
                this.a.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06c5));
            }
            setVisibility(0);
        }
    }
}
