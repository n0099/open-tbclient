package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.u;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class aj extends ak {
    private VoteView bKF;

    public aj(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ak
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(u.g.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(u.g.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bKF = (VoteView) findViewById;
            this.bKF.setWidth(com.baidu.adp.lib.util.k.c(getContext(), u.e.ds560));
            this.bKF.setProgressBarHeight(com.baidu.adp.lib.util.k.c(getContext(), u.e.ds20));
            this.bKF.setDescTextColorResId(u.d.cp_cont_b);
            this.bKF.setProgressBarTopMargin(com.baidu.adp.lib.util.k.c(getContext(), u.e.ds8));
            this.bKF.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bKH.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ak
    protected void hD(int i) {
        if (this.bKF != null) {
            this.bKF.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ak
    protected void j(az azVar) {
        if (azVar != null && azVar.qF() != null) {
            long longValue = azVar.qF().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = azVar.qF().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        ec ecVar = new ec();
                        ecVar.dz(true);
                        ecVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(ecVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bKF.setBoallotsForListView(linkedList);
                    this.bKF.onChangeSkinType(getSkinType());
                    this.bKF.setVisibility(0);
                    return;
                }
                this.bKF.setVisibility(8);
            }
        }
    }
}
