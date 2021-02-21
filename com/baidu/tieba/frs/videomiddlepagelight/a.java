package com.baidu.tieba.frs.videomiddlepagelight;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.lego.card.view.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes2.dex */
public final class a {
    private final BdTypeRecyclerView iOj;
    private final List<com.baidu.adp.widget.ListView.a<?, ?>> jOi;
    private final b jOj;
    private final VideoMiddlePageViewModel jOk;
    private final TbPageContext<?> pageContext;

    public a(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        p.o(tbPageContext, "pageContext");
        p.o(bdTypeRecyclerView, "recyclerView");
        p.o(videoMiddlePageViewModel, "viewModel");
        this.pageContext = tbPageContext;
        this.iOj = bdTypeRecyclerView;
        this.jOk = videoMiddlePageViewModel;
        this.jOi = new ArrayList();
        TbPageContext<?> tbPageContext2 = this.pageContext;
        BdUniqueId bdUniqueId = g.job;
        p.n(bdUniqueId, "VideoAggregationData.TYPE_VIDEO_AGGREGATION");
        this.jOj = new b(tbPageContext2, bdUniqueId, this.jOk);
        this.jOi.add(this.jOj);
        this.iOj.addAdapters(this.jOi);
        MutableLiveData<Integer> cMV = this.jOk.cMV();
        Activity pageActivity = this.pageContext.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        cMV.observe((LifecycleOwner) pageActivity, new Observer<Integer>() { // from class: com.baidu.tieba.frs.videomiddlepagelight.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public final void onChanged(Integer num) {
                ArrayList value = a.this.cMB().cMR().getValue();
                if (value == null) {
                    value = new ArrayList();
                }
                p.n(value, "viewModel.videoDataList.value ?: mutableListOf()");
                a aVar = a.this;
                p.n(num, "pos");
                aVar.o(num.intValue(), value);
                a.this.cFV().getListAdapter().notifyDataSetChanged();
            }
        });
    }

    public final BdTypeRecyclerView cFV() {
        return this.iOj;
    }

    public final VideoMiddlePageViewModel cMB() {
        return this.jOk;
    }

    public final void setData(List<? extends BaseCardInfo> list) {
        p.o(list, "data");
        Integer value = this.jOk.cMV().getValue();
        if (value == null) {
            value = 0;
        }
        o(value.intValue(), list);
        this.iOj.setData(list);
    }

    public final void o(int i, List<? extends BaseCardInfo> list) {
        p.o(list, "dataList");
        if (i < list.size()) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                if (list.get(i2) instanceof i) {
                    BaseCardInfo baseCardInfo = list.get(i2);
                    if (baseCardInfo == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.lego.card.view.IPassAutoPlayData");
                    }
                    ((i) baseCardInfo).setAutoPlay(i2 == i);
                }
                i2++;
            }
        }
    }

    public final void cMC() {
        List<BaseCardInfo> value = this.jOk.cMR().getValue();
        if (value != null) {
            p.n(value, "viewModel.videoDataList.value ?: return");
            for (BaseCardInfo baseCardInfo : value) {
                if (baseCardInfo instanceof i) {
                    ((i) baseCardInfo).setAutoPlay(false);
                }
            }
            this.iOj.setData(value);
        }
    }

    public final void onDestroy() {
        this.jOj.onDestroy();
    }
}
