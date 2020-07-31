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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
/* loaded from: classes15.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView emk;
    private RoundAndShadowLinearLayout gSX;
    private View gSY;
    private TrapezoidButton gSZ;
    private TextView gTa;
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
        ss();
    }

    private void ss() {
        this.gSX = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.gSX.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.emk = (TextView) findViewById(R.id.vote_num);
        this.gSZ = (TrapezoidButton) findViewById(R.id.vote_button);
        this.gTa = (TextView) findViewById(R.id.vote_button_tv);
        this.gSY = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.gPf == null || this.gSQ == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.emk.setText(as.numFormatOverWan(this.gSQ.bQw()) + "票");
        this.gTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bf.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new ap("c13441").baO();
                    if (VoteAreaLayout.this.gSQ != null && fVar != null && fVar.bQH() != null) {
                        if (fVar.bQH().bQE()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.gSQ.getUid(), fVar.getFid(), VoteAreaLayout.this.gSQ.getTid(), 1);
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
        if (this.gSQ.bQy()) {
            this.gTa.setEnabled(false);
        } else {
            this.gTa.setEnabled(true);
        }
    }

    public void qZ(int i) {
        ao.setViewTextColor(this.emk, R.color.cp_link_tip_b, 1, i);
        ao.a(this.gSY, R.color.cp_link_tip_b, 0.2f, i);
        ao.setViewTextColor(this.gTa, R.color.cp_cont_a, 1, i);
        ao.setBackgroundResource(this.gTa, R.drawable.bar_select_bg_gradient, i);
    }
}
