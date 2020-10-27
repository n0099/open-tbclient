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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
/* loaded from: classes21.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView eST;
    private RoundAndShadowLinearLayout hOl;
    private View hOm;
    private TrapezoidButton hOn;
    private TextView hOo;
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
        this.hOl = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.hOl.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.eST = (TextView) findViewById(R.id.vote_num);
        this.hOn = (TrapezoidButton) findViewById(R.id.vote_button);
        this.hOo = (TextView) findViewById(R.id.vote_button_tv);
        this.hOm = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.hKp == null || this.hOe == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eST.setText(at.numFormatOverWan(this.hOe.cky()) + "票");
        this.hOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bg.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new aq("c13441").boK();
                    if (VoteAreaLayout.this.hOe != null && fVar != null && fVar.ckL() != null) {
                        if (fVar.ckL().ckH()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.hOe.getUid(), fVar.getFid(), VoteAreaLayout.this.hOe.getTid(), 1);
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
        if (this.hOe.ckA()) {
            this.hOo.setEnabled(false);
        } else {
            this.hOo.setEnabled(true);
        }
    }

    public void uu(int i) {
        ap.setViewTextColor(this.eST, R.color.cp_link_tip_b, 1, i);
        ap.a(this.hOm, R.color.cp_link_tip_b, 0.2f, i);
        ap.setViewTextColor(this.hOo, R.color.cp_cont_a, 1, i);
        ap.setBackgroundResource(this.hOo, R.drawable.bar_select_bg_gradient, i);
    }
}
