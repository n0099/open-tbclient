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
/* loaded from: classes8.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private RoundAndShadowLinearLayout gAF;
    private View gAG;
    private TextView gAH;
    private TrapezoidButton gAI;
    private TextView gAJ;
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
        rV();
    }

    private void rV() {
        this.gAF = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.gAF.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.gAH = (TextView) findViewById(R.id.vote_num);
        this.gAI = (TrapezoidButton) findViewById(R.id.vote_button);
        this.gAJ = (TextView) findViewById(R.id.vote_button_tv);
        this.gAG = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.gwL == null || this.gAy == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.gAH.setText(aq.numFormatOverWan(this.gAy.bKf()) + "票");
        this.gAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bc.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new an("c13441").aUT();
                    if (VoteAreaLayout.this.gAy != null && fVar != null && fVar.bKq() != null) {
                        if (fVar.bKq().bKn()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.gAy.getUid(), fVar.getFid(), VoteAreaLayout.this.gAy.getTid(), 1);
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
        if (this.gAy.bKh()) {
            this.gAJ.setEnabled(false);
        } else {
            this.gAJ.setEnabled(true);
        }
    }

    public void qk(int i) {
        am.setViewTextColor(this.gAH, R.color.cp_link_tip_b, 1, i);
        am.a(this.gAG, (int) R.color.cp_link_tip_b, 0.2f, i);
        am.setViewTextColor(this.gAJ, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.gAJ, R.drawable.bar_select_bg_gradient, i);
    }
}
