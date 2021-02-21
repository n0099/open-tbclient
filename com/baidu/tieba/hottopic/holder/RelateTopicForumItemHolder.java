package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public View him;
    public TextView hmF;
    public TextView jRC;
    public TextView jRD;
    public BarImageView kwm;
    public TextView kwn;
    public TextView kwo;
    public TextView kwp;
    public TextView kwq;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.kwn = (TextView) view.findViewById(R.id.forum_name);
        this.kwm = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.kwp = (TextView) view.findViewById(R.id.member_num_label);
        this.kwo = (TextView) view.findViewById(R.id.post_num_label);
        this.jRD = (TextView) view.findViewById(R.id.member_num);
        this.jRC = (TextView) view.findViewById(R.id.post_num);
        this.hmF = (TextView) view.findViewById(R.id.forum_content);
        this.kwq = (TextView) view.findViewById(R.id.forum_add_love);
        this.him = view.findViewById(R.id.forum_item_divider);
    }
}
