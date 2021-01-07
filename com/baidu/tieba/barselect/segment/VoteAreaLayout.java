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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
/* loaded from: classes8.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView foU;
    private RoundAndShadowLinearLayout isc;
    private View isd;
    private TrapezoidButton ise;
    private TextView isf;
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
        tN();
    }

    private void tN() {
        this.isc = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.isc.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.foU = (TextView) findViewById(R.id.vote_num);
        this.ise = (TrapezoidButton) findViewById(R.id.vote_button);
        this.isf = (TextView) findViewById(R.id.vote_button_tv);
        this.isd = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.ioi == null || this.irV == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.foU.setText(at.numFormatOverWan(this.irV.ctK()) + "票");
        this.isf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bg.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new aq("c13441").bwo();
                    if (VoteAreaLayout.this.irV != null && fVar != null && fVar.ctX() != null) {
                        if (fVar.ctX().ctT()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.irV.getUid(), fVar.getFid(), VoteAreaLayout.this.irV.getTid(), 1);
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
        if (this.irV.ctM()) {
            this.isf.setEnabled(false);
        } else {
            this.isf.setEnabled(true);
        }
    }

    public void vU(int i) {
        ao.setViewTextColor(this.foU, R.color.CAM_X0303, 1, i);
        ao.a(this.isd, R.color.CAM_X0303, 0.2f, i);
        ao.setViewTextColor(this.isf, R.color.CAM_X0101, 1, i);
        ao.setBackgroundResource(this.isf, R.drawable.bar_select_bg_gradient, i);
    }
}
