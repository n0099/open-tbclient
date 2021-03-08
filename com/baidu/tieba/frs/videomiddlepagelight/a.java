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
    private final BdTypeRecyclerView iPS;
    private final List<com.baidu.adp.widget.ListView.a<?, ?>> jPR;
    private final b jPS;
    private final VideoMiddlePageViewModel jPT;
    private final TbPageContext<?> pageContext;

    public a(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        p.p(tbPageContext, "pageContext");
        p.p(bdTypeRecyclerView, "recyclerView");
        p.p(videoMiddlePageViewModel, "viewModel");
        this.pageContext = tbPageContext;
        this.iPS = bdTypeRecyclerView;
        this.jPT = videoMiddlePageViewModel;
        this.jPR = new ArrayList();
        TbPageContext<?> tbPageContext2 = this.pageContext;
        BdUniqueId bdUniqueId = g.jpK;
        p.o(bdUniqueId, "VideoAggregationData.TYPE_VIDEO_AGGREGATION");
        this.jPS = new b(tbPageContext2, bdUniqueId, this.jPT);
        this.jPR.add(this.jPS);
        this.iPS.addAdapters(this.jPR);
        MutableLiveData<Integer> cNb = this.jPT.cNb();
        Activity pageActivity = this.pageContext.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        cNb.observe((LifecycleOwner) pageActivity, new Observer<Integer>() { // from class: com.baidu.tieba.frs.videomiddlepagelight.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public final void onChanged(Integer num) {
                ArrayList value = a.this.cMH().cMX().getValue();
                if (value == null) {
                    value = new ArrayList();
                }
                p.o(value, "viewModel.videoDataList.value ?: mutableListOf()");
                a aVar = a.this;
                p.o(num, "pos");
                aVar.o(num.intValue(), value);
                a.this.cGb().getListAdapter().notifyDataSetChanged();
            }
        });
    }

    public final BdTypeRecyclerView cGb() {
        return this.iPS;
    }

    public final VideoMiddlePageViewModel cMH() {
        return this.jPT;
    }

    public final void setData(List<? extends BaseCardInfo> list) {
        p.p(list, "data");
        Integer value = this.jPT.cNb().getValue();
        if (value == null) {
            value = 0;
        }
        o(value.intValue(), list);
        this.iPS.setData(list);
    }

    public final void o(int i, List<? extends BaseCardInfo> list) {
        p.p(list, "dataList");
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

    public final void cMI() {
        List<BaseCardInfo> value = this.jPT.cMX().getValue();
        if (value != null) {
            p.o(value, "viewModel.videoDataList.value ?: return");
            for (BaseCardInfo baseCardInfo : value) {
                if (baseCardInfo instanceof i) {
                    ((i) baseCardInfo).setAutoPlay(false);
                }
            }
            this.iPS.setData(value);
        }
    }

    public final void onDestroy() {
        this.jPS.onDestroy();
    }
}
