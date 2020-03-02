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
/* loaded from: classes8.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView Nl;
    private View.OnClickListener dri;
    private BazhuHeadView fFL;
    private LinearLayout fFM;
    private TextView fFN;
    private ImageView fFO;
    private TextView fFP;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dri = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.fFR != null && CandidateInfoLayout.this.fFR.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.fFR.getUid();
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
        ns();
    }

    private void ns() {
        this.fFL = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.fFL.getHeadView() != null) {
            this.fFL.getHeadView().setIsRound(true);
        }
        this.fFM = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.Nl = (TextView) findViewById(R.id.user_name);
        this.fFN = (TextView) findViewById(R.id.vote_id);
        this.fFP = (TextView) findViewById(R.id.agree_post_reply_num);
        this.fFO = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.fCh == null || this.fFR == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.fGh) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.fFL.setLayoutParams(layoutParams);
            this.fFL.kg(true);
            this.fFL.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.fFL.setPendantView(R.drawable.icon_crown);
            this.Nl.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.fFL.setLayoutParams(layoutParams);
            this.fFM.setLayoutParams(layoutParams2);
        } else {
            this.fFL.kg(false);
        }
        this.fFL.tT(this.fFR.getPortrait());
        this.fFL.setOnClickListener(this.dri);
        this.Nl.setText(aq.cutChineseAndEnglishWithSuffix(this.fFR.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.fFR.btV());
        if (this.fFR.btU() < 1000) {
            String str2 = "0000" + this.fFR.btU();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.fFR.btU();
        }
        this.fFN.setText("NO." + str);
        this.fFP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), aq.bF(this.fFR.btT()), aq.bF(this.fFR.getPost_num()), aq.bF(this.fFR.getThread_num())));
    }

    public void setGrade(int i) {
        am.setImageResource(this.fFO, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void pk(int i) {
        am.setViewTextColor(this.Nl, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fFN, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fFP, R.color.cp_cont_d, 1, i);
        if (this.fFR != null) {
            setGrade(this.fFR.btV());
        }
    }
}
