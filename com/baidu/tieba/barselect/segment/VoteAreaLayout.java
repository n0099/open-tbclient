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
/* loaded from: classes7.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView foc;
    private RoundAndShadowLinearLayout iuW;
    private View iuX;
    private TrapezoidButton iuY;
    private TextView iuZ;
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
        tz();
    }

    private void tz() {
        this.iuW = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.iuW.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.foc = (TextView) findViewById(R.id.vote_num);
        this.iuY = (TrapezoidButton) findViewById(R.id.vote_button);
        this.iuZ = (TextView) findViewById(R.id.vote_button_tv);
        this.iuX = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.ire == null || this.iuP == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.foc.setText(au.numFormatOverWan(this.iuP.crp()) + "票");
        this.iuZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bh.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new ar("c13441").bsR();
                    if (VoteAreaLayout.this.iuP != null && fVar != null && fVar.crC() != null) {
                        if (fVar.crC().cry()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.iuP.getUid(), fVar.getFid(), VoteAreaLayout.this.iuP.getTid(), 1);
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
        if (this.iuP.crr()) {
            this.iuZ.setEnabled(false);
        } else {
            this.iuZ.setEnabled(true);
        }
    }

    public void uw(int i) {
        ap.setViewTextColor(this.foc, R.color.CAM_X0303, 1, i);
        ap.a(this.iuX, R.color.CAM_X0303, 0.2f, i);
        ap.setViewTextColor(this.iuZ, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.iuZ, R.drawable.bar_select_bg_gradient, i);
    }
}
