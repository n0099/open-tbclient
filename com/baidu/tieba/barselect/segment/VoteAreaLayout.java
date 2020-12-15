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
/* loaded from: classes21.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView ffm;
    private RoundAndShadowLinearLayout ifH;
    private View ifI;
    private TrapezoidButton ifJ;
    private TextView ifK;
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
        uo();
    }

    private void uo() {
        this.ifH = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.ifH.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.ffm = (TextView) findViewById(R.id.vote_num);
        this.ifJ = (TrapezoidButton) findViewById(R.id.vote_button);
        this.ifK = (TextView) findViewById(R.id.vote_button_tv);
        this.ifI = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.ibI == null || this.ifA == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.ffm.setText(au.numFormatOverWan(this.ifA.cqQ()) + "票");
        this.ifK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bh.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new ar("c13441").btT();
                    if (VoteAreaLayout.this.ifA != null && fVar != null && fVar.crd() != null) {
                        if (fVar.crd().cqZ()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.ifA.getUid(), fVar.getFid(), VoteAreaLayout.this.ifA.getTid(), 1);
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
        if (this.ifA.cqS()) {
            this.ifK.setEnabled(false);
        } else {
            this.ifK.setEnabled(true);
        }
    }

    public void vJ(int i) {
        ap.setViewTextColor(this.ffm, R.color.CAM_X0303, 1, i);
        ap.a(this.ifI, R.color.CAM_X0303, 0.2f, i);
        ap.setViewTextColor(this.ifK, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.ifK, R.drawable.bar_select_bg_gradient, i);
    }
}
