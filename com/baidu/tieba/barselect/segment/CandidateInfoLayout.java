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
/* loaded from: classes21.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView ajt;
    private View.OnClickListener eTU;
    private BazhuHeadView hBC;
    private LinearLayout hBD;
    private TextView hBE;
    private ImageView hBF;
    private TextView hBG;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.hBI != null && CandidateInfoLayout.this.hBI.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.hBI.getUid();
                    if ((CandidateInfoLayout.this.getContext() instanceof Activity) && CandidateInfoLayout.this.hBI.chu() != 2) {
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
        ul();
    }

    private void ul() {
        this.hBC = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hBC.getHeadView() != null) {
            this.hBC.getHeadView().setIsRound(true);
        }
        this.hBD = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.ajt = (TextView) findViewById(R.id.user_name);
        this.hBE = (TextView) findViewById(R.id.vote_id);
        this.hBG = (TextView) findViewById(R.id.agree_post_reply_num);
        this.hBF = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.hxT == null || this.hBI == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.hBX) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.hBC.setLayoutParams(layoutParams);
            this.hBC.nO(true);
            this.hBC.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.hBC.setPendantView(R.drawable.icon_crown);
            this.ajt.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.hBC.setLayoutParams(layoutParams);
            this.hBD.setLayoutParams(layoutParams2);
        } else {
            this.hBC.nO(false);
        }
        this.hBC.BJ(this.hBI.getPortrait());
        this.hBC.setOnClickListener(this.eTU);
        this.ajt.setText(at.cutChineseAndEnglishWithSuffix(this.hBI.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hBI.chq());
        if (this.hBI.chu() == 2) {
            this.hBE.setVisibility(8);
        } else {
            this.hBE.setVisibility(0);
            if (this.hBI.chp() < 1000) {
                String str2 = "0000" + this.hBI.chp();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.hBI.chp();
            }
            this.hBE.setText("NO." + str);
        }
        this.hBG.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), at.dd(this.hBI.cho()), at.dd(this.hBI.getThread_num()), at.dd(this.hBI.getPost_num())));
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hBF, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uc(int i) {
        ap.setViewTextColor(this.ajt, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hBE, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hBG, R.color.cp_cont_d, 1, i);
        if (this.hBI != null) {
            setGrade(this.hBI.chq());
        }
    }
}
