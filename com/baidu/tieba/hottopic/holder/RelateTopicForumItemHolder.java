package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public TextView hmK;
    public View ibo;
    public TextView jOX;
    public TextView jOY;
    public TextView ksA;
    public BarImageView ksw;
    public TextView ksx;
    public TextView ksy;
    public TextView ksz;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.akW = 3;
        this.ksx = (TextView) view.findViewById(R.id.forum_name);
        this.ksw = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.ksz = (TextView) view.findViewById(R.id.member_num_label);
        this.ksy = (TextView) view.findViewById(R.id.post_num_label);
        this.jOY = (TextView) view.findViewById(R.id.member_num);
        this.jOX = (TextView) view.findViewById(R.id.post_num);
        this.hmK = (TextView) view.findViewById(R.id.forum_content);
        this.ksA = (TextView) view.findViewById(R.id.forum_add_love);
        this.ibo = view.findViewById(R.id.forum_item_divider);
    }
}
