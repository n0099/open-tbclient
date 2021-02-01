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
/* loaded from: classes8.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView ajY;
    private BazhuHeadView isM;
    private LinearLayout isN;
    private TextView isO;
    private ImageView isP;
    private TextView isQ;
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
                if (CandidateInfoLayout.this.isS != null && CandidateInfoLayout.this.isS.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.isS.getUid();
                    if ((CandidateInfoLayout.this.getContext() instanceof Activity) && CandidateInfoLayout.this.isS.crf() != 2) {
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
        this.isM = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.isM.getHeadView() != null) {
            this.isM.getHeadView().setIsRound(true);
        }
        this.isN = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.ajY = (TextView) findViewById(R.id.user_name);
        this.isO = (TextView) findViewById(R.id.vote_id);
        this.isQ = (TextView) findViewById(R.id.agree_post_reply_num);
        this.isP = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.iph == null || this.isS == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.ith) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.isM.setLayoutParams(layoutParams);
            this.isM.ps(true);
            this.isM.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.isM.setPendantView(R.drawable.icon_crown);
            this.ajY.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.isM.setLayoutParams(layoutParams);
            this.isN.setLayoutParams(layoutParams2);
        } else {
            this.isM.ps(false);
        }
        this.isM.BA(this.isS.getPortrait());
        this.isM.setOnClickListener(this.onClickListener);
        this.ajY.setText(au.cutChineseAndEnglishWithSuffix(this.isS.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.isS.crb());
        if (this.isS.crf() == 2) {
            this.isO.setVisibility(8);
        } else {
            this.isO.setVisibility(0);
            if (this.isS.cra() < 1000) {
                String str2 = "0000" + this.isS.cra();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.isS.cra();
            }
            this.isO.setText("NO." + str);
        }
        this.isQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), au.eg(this.isS.cqZ()), au.eg(this.isS.getThread_num()), au.eg(this.isS.getPost_num())));
    }

    public void setGrade(int i) {
        ap.setImageResource(this.isP, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uu(int i) {
        ap.setViewTextColor(this.ajY, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.isO, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.isQ, R.color.CAM_X0109, 1, i);
        if (this.isS != null) {
            setGrade(this.isS.crb());
        }
    }
}
