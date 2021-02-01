package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ManitoHeaderItemViewHolder extends TypeAdapter.ViewHolder {
    public int mSkinType;
    public TextView title;

    public ManitoHeaderItemViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.title = (TextView) view.findViewById(R.id.manito_header_title);
    }
}
