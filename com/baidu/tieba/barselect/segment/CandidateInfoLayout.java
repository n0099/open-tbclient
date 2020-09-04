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
    private TextView aiH;
    private View.OnClickListener eFG;
    private BazhuHeadView hfH;
    private LinearLayout hfI;
    private TextView hfJ;
    private ImageView hfK;
    private TextView hfL;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.hfN != null && CandidateInfoLayout.this.hfN.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.hfN.getUid();
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
        this.hfH = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hfH.getHeadView() != null) {
            this.hfH.getHeadView().setIsRound(true);
        }
        this.hfI = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.aiH = (TextView) findViewById(R.id.user_name);
        this.hfJ = (TextView) findViewById(R.id.vote_id);
        this.hfL = (TextView) findViewById(R.id.agree_post_reply_num);
        this.hfK = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.hbZ == null || this.hfN == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.hgc) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.hfH.setLayoutParams(layoutParams);
            this.hfH.nd(true);
            this.hfH.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.hfH.setPendantView(R.drawable.icon_crown);
            this.aiH.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.hfH.setLayoutParams(layoutParams);
            this.hfI.setLayoutParams(layoutParams2);
        } else {
            this.hfH.nd(false);
        }
        this.hfH.AB(this.hfN.getPortrait());
        this.hfH.setOnClickListener(this.eFG);
        this.aiH.setText(at.cutChineseAndEnglishWithSuffix(this.hfN.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hfN.caH());
        if (this.hfN.caG() < 1000) {
            String str2 = "0000" + this.hfN.caG();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.hfN.caG();
        }
        this.hfJ.setText("NO." + str);
        this.hfL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), at.cU(this.hfN.caF()), at.cU(this.hfN.getThread_num()), at.cU(this.hfN.getPost_num())));
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hfK, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void tl(int i) {
        ap.setViewTextColor(this.aiH, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hfJ, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hfL, R.color.cp_cont_d, 1, i);
        if (this.hfN != null) {
            setGrade(this.hfN.caH());
        }
    }
}
