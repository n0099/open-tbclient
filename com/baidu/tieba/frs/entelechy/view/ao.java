package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.dx;
import com.baidu.tieba.r;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ao extends ap {
    private VoteView bXC;

    public ao(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(r.g.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(r.g.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bXC = (VoteView) findViewById;
            this.bXC.setWidth(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds560));
            this.bXC.setProgressBarHeight(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20));
            this.bXC.setDescTextColorResId(r.d.cp_cont_b);
            this.bXC.setProgressBarTopMargin(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds8));
            this.bXC.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bXF.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    protected void ik(int i) {
        if (this.bXC != null) {
            this.bXC.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    protected void m(bi biVar) {
        if (biVar != null && biVar.rE() != null) {
            long longValue = biVar.rE().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = biVar.rE().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        dx dxVar = new dx();
                        dxVar.dT(true);
                        dxVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(dxVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bXC.setBoallotsForListView(linkedList);
                    this.bXC.onChangeSkinType(getSkinType());
                    this.bXC.setVisibility(0);
                    return;
                }
                this.bXC.setVisibility(8);
            }
        }
    }
}
