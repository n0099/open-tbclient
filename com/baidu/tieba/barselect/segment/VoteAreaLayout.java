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
/* loaded from: classes15.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView ewj;
    private RoundAndShadowLinearLayout hfU;
    private View hfV;
    private TrapezoidButton hfW;
    private TextView hfX;
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
        uf();
    }

    private void uf() {
        this.hfU = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.hfU.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.ewj = (TextView) findViewById(R.id.vote_num);
        this.hfW = (TrapezoidButton) findViewById(R.id.vote_button);
        this.hfX = (TextView) findViewById(R.id.vote_button_tv);
        this.hfV = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.hbZ == null || this.hfN == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.ewj.setText(at.numFormatOverWan(this.hfN.caI()) + "票");
        this.hfX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bg.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new aq("c13441").bjn();
                    if (VoteAreaLayout.this.hfN != null && fVar != null && fVar.caT() != null) {
                        if (fVar.caT().caQ()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.hfN.getUid(), fVar.getFid(), VoteAreaLayout.this.hfN.getTid(), 1);
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
        if (this.hfN.caK()) {
            this.hfX.setEnabled(false);
        } else {
            this.hfX.setEnabled(true);
        }
    }

    public void tl(int i) {
        ap.setViewTextColor(this.ewj, R.color.cp_link_tip_b, 1, i);
        ap.a(this.hfV, R.color.cp_link_tip_b, 0.2f, i);
        ap.setViewTextColor(this.hfX, R.color.cp_cont_a, 1, i);
        ap.setBackgroundResource(this.hfX, R.drawable.bar_select_bg_gradient, i);
    }
}
