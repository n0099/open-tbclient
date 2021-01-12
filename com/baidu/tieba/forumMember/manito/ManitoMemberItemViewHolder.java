package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes7.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {
    public View dividerLine;
    public TextView eli;
    public GodHeadImageView iWv;
    public TextView iWw;
    public TextView iWx;
    public int mSkinType;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.iWv = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.iWv.setShapeType(0);
        this.iWv.setShowType(1);
        this.iWv.setRadius(14);
        this.eli = (TextView) view.findViewById(R.id.item_manito_name);
        this.iWw = (TextView) view.findViewById(R.id.item_manito_intro);
        this.iWx = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
