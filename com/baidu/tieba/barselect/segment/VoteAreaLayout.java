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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
/* loaded from: classes3.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private RoundAndShadowLinearLayout eyR;
    private View eyS;
    private TextView eyT;
    private TrapezoidButton eyU;
    private TextView eyV;
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
        qX();
    }

    private void qX() {
        this.eyR = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.eyR.setRadius(l.g(this.mContext, R.dimen.tbds8));
        this.eyT = (TextView) findViewById(R.id.vote_num);
        this.eyU = (TrapezoidButton) findViewById(R.id.vote_button);
        this.eyV = (TextView) findViewById(R.id.vote_button_tv);
        this.eyS = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.euT == null || this.eyK == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eyT.setText(aq.aO(this.eyK.aYE()) + "票");
        this.eyV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bd.cF(VoteAreaLayout.this.mContext)) {
                    new an("c13441").ajk();
                    if (VoteAreaLayout.this.eyK != null && fVar != null && fVar.aYR() != null) {
                        if (fVar.aYR().aYO()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.eyK.getUid(), fVar.getFid(), VoteAreaLayout.this.eyK.getTid(), 1);
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
        if (this.eyK.aYH()) {
            this.eyV.setEnabled(false);
        } else {
            this.eyV.setEnabled(true);
        }
    }

    public void nA(int i) {
        am.d(this.eyT, R.color.cp_link_tip_b, 1, i);
        am.a(this.eyS, (int) R.color.cp_link_tip_b, 0.2f, i);
        am.d(this.eyV, R.color.cp_btn_a, 1, i);
        am.g(this.eyV, R.drawable.bar_select_bg_gradient, i);
    }
}
