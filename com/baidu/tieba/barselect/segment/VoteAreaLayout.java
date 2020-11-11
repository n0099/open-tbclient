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
/* loaded from: classes21.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView eYI;
    private RoundAndShadowLinearLayout hUi;
    private View hUj;
    private TrapezoidButton hUk;
    private TextView hUl;
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
        ul();
    }

    private void ul() {
        this.hUi = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.hUi.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.eYI = (TextView) findViewById(R.id.vote_num);
        this.hUk = (TrapezoidButton) findViewById(R.id.vote_button);
        this.hUl = (TextView) findViewById(R.id.vote_button_tv);
        this.hUj = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.hQm == null || this.hUb == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eYI.setText(at.numFormatOverWan(this.hUb.cna()) + "票");
        this.hUl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bg.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new aq("c13441").brk();
                    if (VoteAreaLayout.this.hUb != null && fVar != null && fVar.cnn() != null) {
                        if (fVar.cnn().cnj()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.hUb.getUid(), fVar.getFid(), VoteAreaLayout.this.hUb.getTid(), 1);
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
        if (this.hUb.cnc()) {
            this.hUl.setEnabled(false);
        } else {
            this.hUl.setEnabled(true);
        }
    }

    public void uE(int i) {
        ap.setViewTextColor(this.eYI, R.color.cp_link_tip_b, 1, i);
        ap.a(this.hUj, R.color.cp_link_tip_b, 0.2f, i);
        ap.setViewTextColor(this.hUl, R.color.cp_cont_a, 1, i);
        ap.setBackgroundResource(this.hUl, R.drawable.bar_select_bg_gradient, i);
    }
}
