package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.dx;
import com.baidu.tieba.t;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ao extends ap {
    private VoteView bXH;

    public ao(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(t.g.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(t.g.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bXH = (VoteView) findViewById;
            this.bXH.setWidth(com.baidu.adp.lib.util.k.e(getContext(), t.e.ds560));
            this.bXH.setProgressBarHeight(com.baidu.adp.lib.util.k.e(getContext(), t.e.ds20));
            this.bXH.setDescTextColorResId(t.d.cp_cont_b);
            this.bXH.setProgressBarTopMargin(com.baidu.adp.lib.util.k.e(getContext(), t.e.ds8));
            this.bXH.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bXK.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.e(getContext(), t.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    protected void ig(int i) {
        if (this.bXH != null) {
            this.bXH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    protected void l(bg bgVar) {
        if (bgVar != null && bgVar.rs() != null) {
            long longValue = bgVar.rs().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = bgVar.rs().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        dx dxVar = new dx();
                        dxVar.dS(true);
                        dxVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(dxVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bXH.setBoallotsForListView(linkedList);
                    this.bXH.onChangeSkinType(getSkinType());
                    this.bXH.setVisibility(0);
                    return;
                }
                this.bXH.setVisibility(8);
            }
        }
    }
}
