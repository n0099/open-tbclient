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
/* loaded from: classes3.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private RoundAndShadowLinearLayout eAA;
    private View eAB;
    private TextView eAC;
    private TrapezoidButton eAD;
    private TextView eAE;
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
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_area_layout, (ViewGroup) this, true);
        qY();
    }

    private void qY() {
        this.eAA = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.eAA.setRadius(l.g(this.mContext, R.dimen.tbds8));
        this.eAC = (TextView) findViewById(R.id.vote_num);
        this.eAD = (TrapezoidButton) findViewById(R.id.vote_button);
        this.eAE = (TextView) findViewById(R.id.vote_button_tv);
        this.eAB = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.ewD == null || this.eAt == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eAC.setText(aq.aO(this.eAt.aZi()) + "票");
        this.eAE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bc.cF(VoteAreaLayout.this.mContext)) {
                    new an("c13441").ajq();
                    if (VoteAreaLayout.this.eAt != null && fVar != null && fVar.aZv() != null) {
                        if (fVar.aZv().aZs()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.eAt.getUid(), fVar.getFid(), VoteAreaLayout.this.eAt.getTid(), 1);
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
        if (this.eAt.aZl()) {
            this.eAE.setEnabled(false);
        } else {
            this.eAE.setEnabled(true);
        }
    }

    public void nE(int i) {
        am.d(this.eAC, R.color.cp_link_tip_b, 1, i);
        am.a(this.eAB, (int) R.color.cp_link_tip_b, 0.2f, i);
        am.d(this.eAE, R.color.cp_cont_a, 1, i);
        am.g(this.eAE, R.drawable.bar_select_bg_gradient, i);
    }
}
