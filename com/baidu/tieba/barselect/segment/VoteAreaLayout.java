package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
/* loaded from: classes6.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private View fDA;
    private TextView fDB;
    private TrapezoidButton fDC;
    private TextView fDD;
    private RoundAndShadowLinearLayout fDz;
    private Context mContext;

    public VoteAreaLayout(Context context) {
        this(context, null);
    }

    public VoteAreaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    protected void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(16);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_area_layout, (ViewGroup) this, true);
        nb();
    }

    private void nb() {
        this.fDz = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.fDz.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.fDB = (TextView) findViewById(R.id.vote_num);
        this.fDC = (TrapezoidButton) findViewById(R.id.vote_button);
        this.fDD = (TextView) findViewById(R.id.vote_button_tv);
        this.fDA = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.fzH == null || this.fDs == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fDB.setText(aq.numFormatOverWan(this.fDs.bsq()) + "票");
        this.fDD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bc.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new an("c13441").aEm();
                    if (VoteAreaLayout.this.fDs != null && fVar != null && fVar.bsC() != null) {
                        if (fVar.bsC().bsz()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.fDs.getUid(), fVar.getFid(), VoteAreaLayout.this.fDs.getTid(), 1);
                                commitVoteReqMsg.setTag(fVar.getUniqueId());
                                MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                                return;
                            }
                            return;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
                    }
                }
            }
        });
        if (this.fDs.bss()) {
            this.fDD.setEnabled(false);
        } else {
            this.fDD.setEnabled(true);
        }
    }

    public void oU(int i) {
        am.setViewTextColor(this.fDB, R.color.cp_link_tip_b, 1, i);
        am.a(this.fDA, (int) R.color.cp_link_tip_b, 0.2f, i);
        am.setViewTextColor(this.fDD, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.fDD, R.drawable.bar_select_bg_gradient, i);
    }
}
