package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes8.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {
    public View dividerLine;
    public TextView epX;
    public GodHeadImageView jbc;
    public TextView jbd;
    public TextView jbe;
    public int mSkinType;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.jbc = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.jbc.setShapeType(0);
        this.jbc.setShowType(1);
        this.jbc.setRadius(14);
        this.epX = (TextView) view.findViewById(R.id.item_manito_name);
        this.jbd = (TextView) view.findViewById(R.id.item_manito_intro);
        this.jbe = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
