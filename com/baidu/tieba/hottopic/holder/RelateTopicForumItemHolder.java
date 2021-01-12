package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public View hWH;
    public TextView hie;
    public TextView jKr;
    public TextView jKs;
    public BarImageView knR;
    public TextView knS;
    public TextView knT;
    public TextView knU;
    public TextView knV;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.akf = 3;
        this.knS = (TextView) view.findViewById(R.id.forum_name);
        this.knR = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.knU = (TextView) view.findViewById(R.id.member_num_label);
        this.knT = (TextView) view.findViewById(R.id.post_num_label);
        this.jKs = (TextView) view.findViewById(R.id.member_num);
        this.jKr = (TextView) view.findViewById(R.id.post_num);
        this.hie = (TextView) view.findViewById(R.id.forum_content);
        this.knV = (TextView) view.findViewById(R.id.forum_add_love);
        this.hWH = view.findViewById(R.id.forum_item_divider);
    }
}
