package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import c.a.s0.q1.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView content;
    public TextView forumAddLove;
    public BarImageView forumAvatar;
    public TextView forumName;
    public View line;
    public TextView memberNum;
    public TextView memberNumLable;
    public TextView postNum;
    public TextView postNumLable;
    public int skinType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateTopicForumItemHolder(View view) {
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
        this.forumName = (TextView) view.findViewById(e.forum_name);
        this.forumAvatar = (BarImageView) view.findViewById(e.forum_avatar);
        this.memberNumLable = (TextView) view.findViewById(e.member_num_label);
        this.postNumLable = (TextView) view.findViewById(e.post_num_label);
        this.memberNum = (TextView) view.findViewById(e.member_num);
        this.postNum = (TextView) view.findViewById(e.post_num);
        this.content = (TextView) view.findViewById(e.forum_content);
        this.forumAddLove = (TextView) view.findViewById(e.forum_add_love);
        this.line = view.findViewById(e.forum_item_divider);
    }
}
