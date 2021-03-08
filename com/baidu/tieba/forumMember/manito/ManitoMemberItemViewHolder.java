package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes7.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {
    public View dividerLine;
    public TextView eoT;
    public GodHeadImageView jdZ;
    public TextView jea;
    public TextView jeb;
    public int mSkinType;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.jdZ = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.jdZ.setShapeType(0);
        this.jdZ.setShowType(1);
        this.jdZ.setRadius(14);
        this.eoT = (TextView) view.findViewById(R.id.item_manito_name);
        this.jea = (TextView) view.findViewById(R.id.item_manito_intro);
        this.jeb = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
