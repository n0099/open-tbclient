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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.BazhuHeadView;
/* loaded from: classes7.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView alr;
    private BazhuHeadView iuJ;
    private LinearLayout iuK;
    private TextView iuL;
    private ImageView iuM;
    private TextView iuN;
    private Context mContext;
    private View.OnClickListener onClickListener;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.iuP != null && CandidateInfoLayout.this.iuP.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.iuP.getUid();
                    if ((CandidateInfoLayout.this.getContext() instanceof Activity) && CandidateInfoLayout.this.iuP.crs() != 2) {
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
        tz();
    }

    private void tz() {
        this.iuJ = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.iuJ.getHeadView() != null) {
            this.iuJ.getHeadView().setIsRound(true);
        }
        this.iuK = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.alr = (TextView) findViewById(R.id.user_name);
        this.iuL = (TextView) findViewById(R.id.vote_id);
        this.iuN = (TextView) findViewById(R.id.agree_post_reply_num);
        this.iuM = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.ire == null || this.iuP == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.ive) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.iuJ.setLayoutParams(layoutParams);
            this.iuJ.ps(true);
            this.iuJ.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.iuJ.setPendantView(R.drawable.icon_crown);
            this.alr.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.iuJ.setLayoutParams(layoutParams);
            this.iuK.setLayoutParams(layoutParams2);
        } else {
            this.iuJ.ps(false);
        }
        this.iuJ.BH(this.iuP.getPortrait());
        this.iuJ.setOnClickListener(this.onClickListener);
        this.alr.setText(au.cutChineseAndEnglishWithSuffix(this.iuP.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.iuP.cro());
        if (this.iuP.crs() == 2) {
            this.iuL.setVisibility(8);
        } else {
            this.iuL.setVisibility(0);
            if (this.iuP.crn() < 1000) {
                String str2 = "0000" + this.iuP.crn();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.iuP.crn();
            }
            this.iuL.setText("NO." + str);
        }
        this.iuN.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), au.eg(this.iuP.crm()), au.eg(this.iuP.getThread_num()), au.eg(this.iuP.getPost_num())));
    }

    public void setGrade(int i) {
        ap.setImageResource(this.iuM, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uw(int i) {
        ap.setViewTextColor(this.alr, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.iuL, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.iuN, R.color.CAM_X0109, 1, i);
        if (this.iuP != null) {
            setGrade(this.iuP.cro());
        }
    }
}
