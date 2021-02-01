package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes8.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {
    public View dividerLine;
    public TextView enq;
    public GodHeadImageView jcc;
    public TextView jcd;
    public TextView jce;
    public int mSkinType;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.jcc = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.jcc.setShapeType(0);
        this.jcc.setShowType(1);
        this.jcc.setRadius(14);
        this.enq = (TextView) view.findViewById(R.id.item_manito_name);
        this.jcd = (TextView) view.findViewById(R.id.item_manito_intro);
        this.jce = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
