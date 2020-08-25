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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.BazhuHeadView;
/* loaded from: classes15.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView aiF;
    private View.OnClickListener eFC;
    private BazhuHeadView hfD;
    private LinearLayout hfE;
    private TextView hfF;
    private ImageView hfG;
    private TextView hfH;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.hfJ != null && CandidateInfoLayout.this.hfJ.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.hfJ.getUid();
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
        uf();
    }

    private void uf() {
        this.hfD = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hfD.getHeadView() != null) {
            this.hfD.getHeadView().setIsRound(true);
        }
        this.hfE = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.aiF = (TextView) findViewById(R.id.user_name);
        this.hfF = (TextView) findViewById(R.id.vote_id);
        this.hfH = (TextView) findViewById(R.id.agree_post_reply_num);
        this.hfG = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.hbV == null || this.hfJ == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.hfY) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.hfD.setLayoutParams(layoutParams);
            this.hfD.nb(true);
            this.hfD.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.hfD.setPendantView(R.drawable.icon_crown);
            this.aiF.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.hfD.setLayoutParams(layoutParams);
            this.hfE.setLayoutParams(layoutParams2);
        } else {
            this.hfD.nb(false);
        }
        this.hfD.AA(this.hfJ.getPortrait());
        this.hfD.setOnClickListener(this.eFC);
        this.aiF.setText(at.cutChineseAndEnglishWithSuffix(this.hfJ.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hfJ.caG());
        if (this.hfJ.caF() < 1000) {
            String str2 = "0000" + this.hfJ.caF();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.hfJ.caF();
        }
        this.hfF.setText("NO." + str);
        this.hfH.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), at.cU(this.hfJ.caE()), at.cU(this.hfJ.getThread_num()), at.cU(this.hfJ.getPost_num())));
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hfG, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void tl(int i) {
        ap.setViewTextColor(this.aiF, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hfF, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hfH, R.color.cp_cont_d, 1, i);
        if (this.hfJ != null) {
            setGrade(this.hfJ.caG());
        }
    }
}
