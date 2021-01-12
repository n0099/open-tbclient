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
/* loaded from: classes7.dex */
public class VoteAreaLayout extends CardBasicLayout {
    private TextView fkl;
    private RoundAndShadowLinearLayout inv;
    private View inw;
    private TrapezoidButton inx;
    private TextView iny;
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
        tC();
    }

    private void tC() {
        this.inv = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.inv.setRadius(l.getDimens(this.mContext, R.dimen.tbds8));
        this.fkl = (TextView) findViewById(R.id.vote_num);
        this.inx = (TrapezoidButton) findViewById(R.id.vote_button);
        this.iny = (TextView) findViewById(R.id.vote_button_tv);
        this.inw = findViewById(R.id.button_container);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, final f fVar) {
        super.setData(i, fVar);
        if (this.ijz == null || this.inn == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fkl.setText(at.numFormatOverWan(this.inn.cpS()) + "票");
        this.iny.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.VoteAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((VoteAreaLayout.this.mContext instanceof Activity) && bg.checkUpIsLogin(VoteAreaLayout.this.mContext)) {
                    new aq("c13441").bsu();
                    if (VoteAreaLayout.this.inn != null && fVar != null && fVar.cqf() != null) {
                        if (fVar.cqf().cqb()) {
                            if (fVar.getFid() != 0 && fVar.getUniqueId() != null) {
                                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.inn.getUid(), fVar.getFid(), VoteAreaLayout.this.inn.getTid(), 1);
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
        if (this.inn.cpU()) {
            this.iny.setEnabled(false);
        } else {
            this.iny.setEnabled(true);
        }
    }

    public void uo(int i) {
        ao.setViewTextColor(this.fkl, R.color.CAM_X0303, 1, i);
        ao.a(this.inw, R.color.CAM_X0303, 0.2f, i);
        ao.setViewTextColor(this.iny, R.color.CAM_X0101, 1, i);
        ao.setBackgroundResource(this.iny, R.drawable.bar_select_bg_gradient, i);
    }
}
