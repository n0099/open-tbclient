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
    private TextView aju;
    private View.OnClickListener fii;
    private BazhuHeadView hTV;
    private LinearLayout hTW;
    private TextView hTX;
    private ImageView hTY;
    private TextView hTZ;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.hUb != null && CandidateInfoLayout.this.hUb.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.hUb.getUid();
                    if ((CandidateInfoLayout.this.getContext() instanceof Activity) && CandidateInfoLayout.this.hUb.cnd() != 2) {
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
        this.hTV = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hTV.getHeadView() != null) {
            this.hTV.getHeadView().setIsRound(true);
        }
        this.hTW = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.aju = (TextView) findViewById(R.id.user_name);
        this.hTX = (TextView) findViewById(R.id.vote_id);
        this.hTZ = (TextView) findViewById(R.id.agree_post_reply_num);
        this.hTY = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.hQm == null || this.hUb == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.hUq) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.hTV.setLayoutParams(layoutParams);
            this.hTV.op(true);
            this.hTV.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.hTV.setPendantView(R.drawable.icon_crown);
            this.aju.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.hTV.setLayoutParams(layoutParams);
            this.hTW.setLayoutParams(layoutParams2);
        } else {
            this.hTV.op(false);
        }
        this.hTV.Cq(this.hUb.getPortrait());
        this.hTV.setOnClickListener(this.fii);
        this.aju.setText(at.cutChineseAndEnglishWithSuffix(this.hUb.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hUb.cmZ());
        if (this.hUb.cnd() == 2) {
            this.hTX.setVisibility(8);
        } else {
            this.hTX.setVisibility(0);
            if (this.hUb.cmY() < 1000) {
                String str2 = "0000" + this.hUb.cmY();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.hUb.cmY();
            }
            this.hTX.setText("NO." + str);
        }
        this.hTZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), at.dB(this.hUb.cmX()), at.dB(this.hUb.getThread_num()), at.dB(this.hUb.getPost_num())));
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hTY, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uE(int i) {
        ap.setViewTextColor(this.aju, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hTX, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hTZ, R.color.cp_cont_d, 1, i);
        if (this.hUb != null) {
            setGrade(this.hUb.cmZ());
        }
    }
}
