package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes.dex */
public abstract class ItemViewHolder extends TypeAdapter.ViewHolder {
    public int kst;
    public View.OnClickListener onClickListener;

    public abstract void a(c cVar);

    public abstract ItemViewHolder cI(View view);

    public abstract void onChangeSkinType(int i);

    public ItemViewHolder(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
