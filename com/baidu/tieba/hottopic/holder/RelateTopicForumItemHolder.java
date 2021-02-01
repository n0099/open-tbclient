package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public View hhX;
    public TextView hmr;
    public TextView jRo;
    public TextView jRp;
    public BarImageView kvY;
    public TextView kvZ;
    public TextView kwa;
    public TextView kwb;
    public TextView kwc;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.kvZ = (TextView) view.findViewById(R.id.forum_name);
        this.kvY = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.kwb = (TextView) view.findViewById(R.id.member_num_label);
        this.kwa = (TextView) view.findViewById(R.id.post_num_label);
        this.jRp = (TextView) view.findViewById(R.id.member_num);
        this.jRo = (TextView) view.findViewById(R.id.post_num);
        this.hmr = (TextView) view.findViewById(R.id.forum_content);
        this.kwc = (TextView) view.findViewById(R.id.forum_add_love);
        this.hhX = view.findViewById(R.id.forum_item_divider);
    }
}
