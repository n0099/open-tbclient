package com.baidu.tieba.im.chat.officialBar;

import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RequiresApi;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.im.message.chat.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class g extends BaseAdapter {
    private OfficialBarFeedMsglistAdapter.c kEh;
    private boolean kEi;
    private BdTypeListView kFZ;
    private TbPageContext<OfficialBarFeedActivity> pageContext;
    private List<com.baidu.tieba.im.message.chat.b> mList = null;
    private LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> kFY = null;

    public g(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        this.pageContext = tbPageContext;
        this.kEh = cVar;
        this.kFZ = bdTypeListView;
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.im.message.chat.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        b cUT = msgViewHolder.cUT();
        a.C0767a cXi = bVar.cXi();
        cXi.createTime = bVar.getCreateTime();
        cUT.a(this.pageContext.getPageActivity().getBaseContext(), cXi, bVar.cXj(), this.kFY == null ? null : this.kFY.get(cXi.kLC), bVar.cXk(), bVar.cXh(), i);
        ar arVar = new ar(this.kEi ? "c13865" : "c13863");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("tid", cXi.tid == null ? "" : cXi.tid);
        arVar.dR("fid", cXi.fid);
        TiebaStatic.log(arVar);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CO */
    public com.baidu.tieba.im.message.chat.b getItem(int i) {
        if (this.mList == null || this.mList.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar = null;
        if (view != null) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            b bVar = new b(this.pageContext, this.kEi);
            bVar.a(this.kEh);
            view2 = bVar.getConvertView();
            aVar = new a(bVar.getConvertView(), bVar);
            view2.setTag(aVar);
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, getItem(i), aVar);
    }

    public void setData(List<com.baidu.tieba.im.message.chat.b> list) {
        if (this.mList == null) {
            this.mList = new LinkedList();
        }
        this.mList.clear();
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    @RequiresApi(api = 16)
    public void b(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (this.kFY == null) {
            this.kFY = new LongSparseArray<>();
        }
        this.kFY.clear();
        for (int i = 0; i < longSparseArray.size(); i++) {
            this.kFY.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes7.dex */
    private class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public a(View view, b bVar) {
            super(view, bVar);
        }
    }

    public void sL(boolean z) {
        this.kEi = z;
    }
}
