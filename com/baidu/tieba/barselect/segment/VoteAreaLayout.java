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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
/* loaded from: classes3.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private RoundAndShadowLinearLayout etL;
    private View etM;
    private TextView etN;
    private TrapezoidButton etO;
    private TextView etP;
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
        qA();
    }

    private void qA() {
        this.etL = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.etL.setRadius(l.g(this.mContext, R.dimen.tbds8));
        this.etN = (TextView) findViewById(R.id.vote_num);
        this.etO = (TrapezoidButton) findViewById(R.id.vote_button);
        this.etP = (TextView) findViewById(R.id.vote_button_tv);
        this.etM = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.epO == null || this.etE == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.etN.setText(ap.aN(this.etE.aWG()) + "票");
        this.etP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bc.cE(VoteAreaLayout.this.mContext)) {
                    new am("c13441").aif();
                    if (VoteAreaLayout.this.etE != null && fVar != null && fVar.aWT() != null) {
                        if (fVar.aWT().aWQ()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.etE.getUid(), fVar.getFid(), VoteAreaLayout.this.etE.getTid(), 1);
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
        if (this.etE.aWJ()) {
            this.etP.setEnabled(false);
        } else {
            this.etP.setEnabled(true);
        }
    }

    public void nq(int i) {
        al.c(this.etN, R.color.cp_link_tip_b, 1, i);
        al.a(this.etM, (int) R.color.cp_link_tip_b, 0.2f, i);
        al.c(this.etP, R.color.cp_btn_a, 1, i);
        al.g(this.etP, R.drawable.bar_select_bg_gradient, i);
    }
}
