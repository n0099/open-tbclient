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
/* loaded from: classes8.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView fmD;
    private RoundAndShadowLinearLayout itn;
    private View ito;
    private TrapezoidButton itp;
    private TextView itq;
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
        this.itn = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.itn.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.fmD = (TextView) findViewById(R.id.vote_num);
        this.itp = (TrapezoidButton) findViewById(R.id.vote_button);
        this.itq = (TextView) findViewById(R.id.vote_button_tv);
        this.ito = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.ipv == null || this.itg == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fmD.setText(au.numFormatOverWan(this.itg.crj()) + "票");
        this.itq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bh.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new ar("c13441").bsO();
                    if (VoteAreaLayout.this.itg != null && fVar != null && fVar.crw() != null) {
                        if (fVar.crw().crs()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.itg.getUid(), fVar.getFid(), VoteAreaLayout.this.itg.getTid(), 1);
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
        if (this.itg.crl()) {
            this.itq.setEnabled(false);
        } else {
            this.itq.setEnabled(true);
        }
    }

    public void uu(int i) {
        ap.setViewTextColor(this.fmD, R.color.CAM_X0303, 1, i);
        ap.a(this.ito, R.color.CAM_X0303, 0.2f, i);
        ap.setViewTextColor(this.itq, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.itq, R.drawable.bar_select_bg_gradient, i);
    }
}
