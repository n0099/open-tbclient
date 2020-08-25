package com.baidu.tieba.ala.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private int fxp = -1;
    private List<com.baidu.tieba.ala.data.b> mDataList;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: so */
    public com.baidu.tieba.ala.data.b getItem(int i) {
        return (com.baidu.tieba.ala.data.b) ListUtils.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_choose_feedback_reason_item_layout, viewGroup, false);
            aVar2.fxq = (TextView) view.findViewById(a.g.id_feedback_content);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.data.b item = getItem(i);
        if (item != null) {
            aVar.fxq.setText(item.bIJ());
        }
        if (i == this.fxp) {
            aVar.fxq.setSelected(true);
        } else {
            aVar.fxq.setSelected(false);
        }
        return view;
    }

    public void setData(List<com.baidu.tieba.ala.data.b> list) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        if (list != null) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public int bDZ() {
        return this.fxp;
    }

    public void sp(int i) {
        this.fxp = i;
    }

    /* loaded from: classes7.dex */
    private class a {
        public TextView fxq;

        private a() {
        }
    }
}
