package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {
    public int aln;
    public View hjV;
    public TextView hoo;
    public TextView jTl;
    public TextView jTm;
    public BarImageView kyo;
    public TextView kyp;
    public TextView kyq;
    public TextView kyr;
    public TextView kys;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.aln = 3;
        this.kyp = (TextView) view.findViewById(R.id.forum_name);
        this.kyo = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.kyr = (TextView) view.findViewById(R.id.member_num_label);
        this.kyq = (TextView) view.findViewById(R.id.post_num_label);
        this.jTm = (TextView) view.findViewById(R.id.member_num);
        this.jTl = (TextView) view.findViewById(R.id.post_num);
        this.hoo = (TextView) view.findViewById(R.id.forum_content);
        this.kys = (TextView) view.findViewById(R.id.forum_add_love);
        this.hjV = view.findViewById(R.id.forum_item_divider);
    }
}
