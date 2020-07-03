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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
/* loaded from: classes8.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView ega;
    private RoundAndShadowLinearLayout gNr;
    private View gNs;
    private TrapezoidButton gNt;
    private TextView gNu;
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
        sq();
    }

    private void sq() {
        this.gNr = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.gNr.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.ega = (TextView) findViewById(R.id.vote_num);
        this.gNt = (TrapezoidButton) findViewById(R.id.vote_button);
        this.gNu = (TextView) findViewById(R.id.vote_button_tv);
        this.gNs = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.gJz == null || this.gNk == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.ega.setText(ar.numFormatOverWan(this.gNk.bNk()) + "票");
        this.gNu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && be.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new ao("c13441").aWN();
                    if (VoteAreaLayout.this.gNk != null && fVar != null && fVar.bNv() != null) {
                        if (fVar.bNv().bNs()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.gNk.getUid(), fVar.getFid(), VoteAreaLayout.this.gNk.getTid(), 1);
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
        if (this.gNk.bNm()) {
            this.gNu.setEnabled(false);
        } else {
            this.gNu.setEnabled(true);
        }
    }

    public void qJ(int i) {
        an.setViewTextColor(this.ega, R.color.cp_link_tip_b, 1, i);
        an.a(this.gNs, (int) R.color.cp_link_tip_b, 0.2f, i);
        an.setViewTextColor(this.gNu, R.color.cp_cont_a, 1, i);
        an.setBackgroundResource(this.gNu, R.drawable.bar_select_bg_gradient, i);
    }
}
