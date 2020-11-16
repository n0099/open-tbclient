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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
/* loaded from: classes20.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView eXP;
    private RoundAndShadowLinearLayout hUI;
    private View hUJ;
    private TrapezoidButton hUK;
    private TextView hUL;
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
        ul();
    }

    private void ul() {
        this.hUI = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.hUI.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.eXP = (TextView) findViewById(R.id.vote_num);
        this.hUK = (TrapezoidButton) findViewById(R.id.vote_button);
        this.hUL = (TextView) findViewById(R.id.vote_button_tv);
        this.hUJ = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.hQM == null || this.hUB == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eXP.setText(au.numFormatOverWan(this.hUB.cmC()) + "票");
        this.hUL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bh.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new ar("c13441").bqy();
                    if (VoteAreaLayout.this.hUB != null && fVar != null && fVar.cmP() != null) {
                        if (fVar.cmP().cmL()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.hUB.getUid(), fVar.getFid(), VoteAreaLayout.this.hUB.getTid(), 1);
                                commitVoteReqMsg.setTag(fVar.getUniqueId());
                                MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                                return;
                            }
                            return;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                    }
                }
            }
        });
        if (this.hUB.cmE()) {
            this.hUL.setEnabled(false);
        } else {
            this.hUL.setEnabled(true);
        }
    }

    public void vc(int i) {
        ap.setViewTextColor(this.eXP, R.color.CAM_X0303, 1, i);
        ap.a(this.hUJ, R.color.CAM_X0303, 0.2f, i);
        ap.setViewTextColor(this.hUL, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.hUL, R.drawable.bar_select_bg_gradient, i);
    }
}
