package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.BazhuHeadView;
/* loaded from: classes6.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView MK;
    private View.OnClickListener dmY;
    private BazhuHeadView fDm;
    private LinearLayout fDn;
    private TextView fDo;
    private ImageView fDp;
    private TextView fDq;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmY = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.fDs != null && CandidateInfoLayout.this.fDs.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.fDs.getUid();
                    if (CandidateInfoLayout.this.getContext() instanceof Activity) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(CandidateInfoLayout.this.getContext()).createNormalConfig(uid, uid == j, false)));
                    }
                }
            }
        };
        initUI();
    }

    protected void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(80);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.candidate_info_layout, (ViewGroup) this, true);
        nb();
    }

    private void nb() {
        this.fDm = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.fDm.getHeadView() != null) {
            this.fDm.getHeadView().setIsRound(true);
        }
        this.fDn = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.MK = (TextView) findViewById(R.id.user_name);
        this.fDo = (TextView) findViewById(R.id.vote_id);
        this.fDq = (TextView) findViewById(R.id.agree_post_reply_num);
        this.fDp = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.fzH == null || this.fDs == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.fDI) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.fDm.setLayoutParams(layoutParams);
            this.fDm.ke(true);
            this.fDm.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.fDm.setPendantView(R.drawable.icon_crown);
            this.MK.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.fDm.setLayoutParams(layoutParams);
            this.fDn.setLayoutParams(layoutParams2);
        } else {
            this.fDm.ke(false);
        }
        this.fDm.tD(this.fDs.getPortrait());
        this.fDm.setOnClickListener(this.dmY);
        this.MK.setText(aq.cutChineseAndEnglishWithSuffix(this.fDs.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.fDs.bsp());
        if (this.fDs.bso() < 1000) {
            String str2 = "0000" + this.fDs.bso();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.fDs.bso();
        }
        this.fDo.setText("NO." + str);
        this.fDq.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), aq.bB(this.fDs.bsn()), aq.bB(this.fDs.getPost_num()), aq.bB(this.fDs.getThread_num())));
    }

    public void setGrade(int i) {
        am.setImageResource(this.fDp, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void oU(int i) {
        am.setViewTextColor(this.MK, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fDo, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fDq, R.color.cp_cont_d, 1, i);
        if (this.fDs != null) {
            setGrade(this.fDs.bsp());
        }
    }
}
