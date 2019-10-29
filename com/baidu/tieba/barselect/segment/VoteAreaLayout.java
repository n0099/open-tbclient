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
    private RoundAndShadowLinearLayout eJi;
    private View eJj;
    private TextView eJk;
    private TrapezoidButton eJl;
    private TextView eJm;
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
        md();
    }

    private void md() {
        this.eJi = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.eJi.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.eJk = (TextView) findViewById(R.id.vote_num);
        this.eJl = (TrapezoidButton) findViewById(R.id.vote_button);
        this.eJm = (TextView) findViewById(R.id.vote_button_tv);
        this.eJj = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.eFp == null || this.eJb == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eJk.setText(aq.numFormatOverWan(this.eJb.aZm()) + "票");
        this.eJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bc.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new an("c13441").amK();
                    if (VoteAreaLayout.this.eJb != null && fVar != null && fVar.aZy() != null) {
                        if (fVar.aZy().aZv()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.eJb.getUid(), fVar.getFid(), VoteAreaLayout.this.eJb.getTid(), 1);
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
        if (this.eJb.aZo()) {
            this.eJm.setEnabled(false);
        } else {
            this.eJm.setEnabled(true);
        }
    }

    public void mE(int i) {
        am.setViewTextColor(this.eJk, R.color.cp_link_tip_b, 1, i);
        am.a(this.eJj, R.color.cp_link_tip_b, 0.2f, i);
        am.setViewTextColor(this.eJm, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.eJm, R.drawable.bar_select_bg_gradient, i);
    }
}
