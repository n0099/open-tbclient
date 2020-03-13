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
    private RoundAndShadowLinearLayout fGl;
    private View fGm;
    private TextView fGn;
    private TrapezoidButton fGo;
    private TextView fGp;
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
        ns();
    }

    private void ns() {
        this.fGl = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.fGl.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.fGn = (TextView) findViewById(R.id.vote_num);
        this.fGo = (TrapezoidButton) findViewById(R.id.vote_button);
        this.fGp = (TextView) findViewById(R.id.vote_button_tv);
        this.fGm = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.fCu == null || this.fGe == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fGn.setText(aq.numFormatOverWan(this.fGe.btX()) + "票");
        this.fGp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bc.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new an("c13441").aGz();
                    if (VoteAreaLayout.this.fGe != null && fVar != null && fVar.buj() != null) {
                        if (fVar.buj().bug()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.fGe.getUid(), fVar.getFid(), VoteAreaLayout.this.fGe.getTid(), 1);
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
        if (this.fGe.btZ()) {
            this.fGp.setEnabled(false);
        } else {
            this.fGp.setEnabled(true);
        }
    }

    public void pk(int i) {
        am.setViewTextColor(this.fGn, R.color.cp_link_tip_b, 1, i);
        am.a(this.fGm, (int) R.color.cp_link_tip_b, 0.2f, i);
        am.setViewTextColor(this.fGp, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.fGp, R.drawable.bar_select_bg_gradient, i);
    }
}
