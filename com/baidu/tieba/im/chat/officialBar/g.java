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
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    private OfficialBarFeedMsglistAdapter.c kCf;
    private boolean kCg;
    private BdTypeListView kDX;
    private TbPageContext<OfficialBarFeedActivity> pageContext;
    private List<com.baidu.tieba.im.message.chat.b> mList = null;
    private LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> kDW = null;

    public g(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        this.pageContext = tbPageContext;
        this.kCf = cVar;
        this.kDX = bdTypeListView;
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.im.message.chat.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        b cUM = msgViewHolder.cUM();
        a.C0761a cXb = bVar.cXb();
        cXb.createTime = bVar.getCreateTime();
        cUM.a(this.pageContext.getPageActivity().getBaseContext(), cXb, bVar.cXc(), this.kDW == null ? null : this.kDW.get(cXb.kJA), bVar.cXd(), bVar.cXa(), i);
        ar arVar = new ar(this.kCg ? "c13865" : "c13863");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("tid", cXb.tid == null ? "" : cXb.tid);
        arVar.dR("fid", cXb.fid);
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
    /* renamed from: CL */
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
            b bVar = new b(this.pageContext, this.kCg);
            bVar.a(this.kCf);
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
        if (this.kDW == null) {
            this.kDW = new LongSparseArray<>();
        }
        this.kDW.clear();
        for (int i = 0; i < longSparseArray.size(); i++) {
            this.kDW.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes8.dex */
    private class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public a(View view, b bVar) {
            super(view, bVar);
        }
    }

    public void sL(boolean z) {
        this.kCg = z;
    }
}
