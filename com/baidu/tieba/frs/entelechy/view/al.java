package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.r;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class al extends as {
    private VoteView bMH;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(r.h.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(r.h.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bMH = (VoteView) findViewById;
            this.bMH.setWidth(com.baidu.adp.lib.util.k.e(getContext(), r.f.ds560));
            this.bMH.setProgressBarHeight(com.baidu.adp.lib.util.k.e(getContext(), r.f.ds20));
            this.bMH.setDescTextColorResId(r.e.cp_cont_b);
            this.bMH.setProgressBarTopMargin(com.baidu.adp.lib.util.k.e(getContext(), r.f.ds8));
            this.bMH.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bMQ.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void ih(int i) {
        if (this.bMH != null) {
            this.bMH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void t(bh bhVar) {
        if (bhVar != null && bhVar.rm() != null) {
            long longValue = bhVar.rm().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = bhVar.rm().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        cx cxVar = new cx();
                        cxVar.dS(true);
                        cxVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(cxVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bMH.setBoallotsForListView(linkedList);
                    this.bMH.onChangeSkinType(getSkinType());
                    this.bMH.setVisibility(0);
                    return;
                }
                this.bMH.setVisibility(8);
            }
        }
    }
}
