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
    private RoundAndShadowLinearLayout isZ;
    private View ita;
    private TrapezoidButton itb;
    private TextView itc;
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
        this.isZ = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.isZ.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.fmD = (TextView) findViewById(R.id.vote_num);
        this.itb = (TrapezoidButton) findViewById(R.id.vote_button);
        this.itc = (TextView) findViewById(R.id.vote_button_tv);
        this.ita = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.iph == null || this.isS == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fmD.setText(au.numFormatOverWan(this.isS.crc()) + "票");
        this.itc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bh.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new ar("c13441").bsO();
                    if (VoteAreaLayout.this.isS != null && fVar != null && fVar.crp() != null) {
                        if (fVar.crp().crl()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.isS.getUid(), fVar.getFid(), VoteAreaLayout.this.isS.getTid(), 1);
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
        if (this.isS.cre()) {
            this.itc.setEnabled(false);
        } else {
            this.itc.setEnabled(true);
        }
    }

    public void uu(int i) {
        ap.setViewTextColor(this.fmD, R.color.CAM_X0303, 1, i);
        ap.a(this.ita, R.color.CAM_X0303, 0.2f, i);
        ap.setViewTextColor(this.itc, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.itc, R.drawable.bar_select_bg_gradient, i);
    }
}
