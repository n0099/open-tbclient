package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.t0.r1.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class MagicPostItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout authorInfoArea;
    public TextView authorName;
    public HeadImageView authorPhoto;
    public TextView commentText;
    public View contentDividerLine;
    public TextView contentText;
    public TextView moduleTheme;
    public TextView postTime;
    public View rootView;
    public int skinType;
    public View topDivilerLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicPostItemHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.skinType = 3;
        this.rootView = null;
        this.topDivilerLine = null;
        this.moduleTheme = null;
        this.authorInfoArea = null;
        this.authorPhoto = null;
        this.authorName = null;
        this.postTime = null;
        this.commentText = null;
        this.contentText = null;
        this.contentDividerLine = null;
        this.rootView = view;
        a(view);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        this.topDivilerLine = view.findViewById(e.top_divider_line);
        this.moduleTheme = (TextView) view.findViewById(e.magic_item_theme_title);
        this.authorInfoArea = (RelativeLayout) view.findViewById(e.magicpost_item_user_info_view);
        this.authorPhoto = (HeadImageView) view.findViewById(e.magic_item_photo);
        this.authorName = (TextView) view.findViewById(e.magic_item_username);
        this.postTime = (TextView) view.findViewById(e.magic_item_replytime);
        this.commentText = (TextView) view.findViewById(e.magic_item_comment_textview);
        this.contentText = (TextView) view.findViewById(e.magic_item_reply_content);
        this.contentDividerLine = view.findViewById(e.magic_item_divider_line);
    }
}
