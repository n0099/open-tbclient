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
    private RoundAndShadowLinearLayout glE;
    private View glF;
    private TextView glG;
    private TrapezoidButton glH;
    private TextView glI;
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
        rL();
    }

    private void rL() {
        this.glE = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.glE.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.glG = (TextView) findViewById(R.id.vote_num);
        this.glH = (TrapezoidButton) findViewById(R.id.vote_button);
        this.glI = (TextView) findViewById(R.id.vote_button_tv);
        this.glF = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.ghJ == null || this.glx == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.glG.setText(aq.numFormatOverWan(this.glx.bDM()) + "票");
        this.glI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bc.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new an("c13441").aOO();
                    if (VoteAreaLayout.this.glx != null && fVar != null && fVar.bDX() != null) {
                        if (fVar.bDX().bDU()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.glx.getUid(), fVar.getFid(), VoteAreaLayout.this.glx.getTid(), 1);
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
        if (this.glx.bDO()) {
            this.glI.setEnabled(false);
        } else {
            this.glI.setEnabled(true);
        }
    }

    public void pH(int i) {
        am.setViewTextColor(this.glG, R.color.cp_link_tip_b, 1, i);
        am.a(this.glF, (int) R.color.cp_link_tip_b, 0.2f, i);
        am.setViewTextColor(this.glI, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.glI, R.drawable.bar_select_bg_gradient, i);
    }
}
