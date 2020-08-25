package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.RequiresApi;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class h extends BaseAdapter {
    private d.c jhn;
    private boolean jho;
    private BdTypeListView jjk;
    private TbPageContext<BaseActivity> pageContext;
    private List<com.baidu.tieba.im.message.chat.b> mList = null;
    private LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> jjj = null;

    public h(TbPageContext<BaseActivity> tbPageContext, BdTypeListView bdTypeListView, d.c cVar) {
        this.pageContext = tbPageContext;
        this.jhn = cVar;
        this.jjk = bdTypeListView;
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.im.message.chat.b bVar, e.a<b> aVar) {
        b cBS = aVar.cBS();
        a.C0719a cHk = bVar.cHk();
        cHk.createTime = bVar.getCreateTime();
        cBS.a(this.pageContext.getPageActivity().getBaseContext(), cHk, bVar.cHl(), this.jjj == null ? null : this.jjj.get(cHk.jwo), bVar.cHm(), bVar.cHj(), i);
        aq aqVar = new aq(this.jho ? "c13865" : "c13863");
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dD("tid", cHk.tid == null ? "" : cHk.tid);
        aqVar.dD("fid", cHk.fid);
        TiebaStatic.log(aqVar);
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
    /* renamed from: AO */
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
            b bVar = new b(this.pageContext, this.jho);
            bVar.a(this.jhn);
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
        if (this.jjj == null) {
            this.jjj = new LongSparseArray<>();
        }
        this.jjj.clear();
        for (int i = 0; i < longSparseArray.size(); i++) {
            this.jjj.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes20.dex */
    private class a extends e.a<b> {
        public a(View view, b bVar) {
            super(view, bVar);
        }
    }

    public void qn(boolean z) {
        this.jho = z;
    }
}
