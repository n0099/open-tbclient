package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.r;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class al extends as {
    private VoteView bGs;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(r.g.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(r.g.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bGs = (VoteView) findViewById;
            this.bGs.setWidth(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds560));
            this.bGs.setProgressBarHeight(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20));
            this.bGs.setDescTextColorResId(r.d.cp_cont_b);
            this.bGs.setProgressBarTopMargin(com.baidu.adp.lib.util.k.e(getContext(), r.e.ds8));
            this.bGs.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bGB.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void hu(int i) {
        if (this.bGs != null) {
            this.bGs.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void q(bg bgVar) {
        if (bgVar != null && bgVar.ru() != null) {
            long longValue = bgVar.ru().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = bgVar.ru().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        db dbVar = new db();
                        dbVar.dM(true);
                        dbVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(dbVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bGs.setBoallotsForListView(linkedList);
                    this.bGs.onChangeSkinType(getSkinType());
                    this.bGs.setVisibility(0);
                    return;
                }
                this.bGs.setVisibility(8);
            }
        }
    }
}
