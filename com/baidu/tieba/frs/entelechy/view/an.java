package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.r;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class an extends ao {
    private VoteView caS;

    public an(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(r.g.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(r.g.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.caS = (VoteView) findViewById;
            this.caS.setWidth(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds560));
            this.caS.setProgressBarHeight(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20));
            this.caS.setDescTextColorResId(r.d.cp_cont_b);
            this.caS.setProgressBarTopMargin(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds8));
            this.caS.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.caU.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void ik(int i) {
        if (this.caS != null) {
            this.caS.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void l(bk bkVar) {
        if (bkVar != null && bkVar.rG() != null) {
            long longValue = bkVar.rG().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = bkVar.rG().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        db dbVar = new db();
                        dbVar.ec(true);
                        dbVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(dbVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.caS.setBoallotsForListView(linkedList);
                    this.caS.onChangeSkinType(getSkinType());
                    this.caS.setVisibility(0);
                    return;
                }
                this.caS.setVisibility(8);
            }
        }
    }
}
