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
/* loaded from: classes5.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView ME;
    private View.OnClickListener dmK;
    private BazhuHeadView fAb;
    private LinearLayout fAc;
    private TextView fAd;
    private ImageView fAe;
    private TextView fAf;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.fAh != null && CandidateInfoLayout.this.fAh.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.fAh.getUid();
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
        na();
    }

    private void na() {
        this.fAb = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.fAb.getHeadView() != null) {
            this.fAb.getHeadView().setIsRound(true);
        }
        this.fAc = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.ME = (TextView) findViewById(R.id.user_name);
        this.fAd = (TextView) findViewById(R.id.vote_id);
        this.fAf = (TextView) findViewById(R.id.agree_post_reply_num);
        this.fAe = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.fww == null || this.fAh == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.fAx) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.fAb.setLayoutParams(layoutParams);
            this.fAb.jT(true);
            this.fAb.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.fAb.setPendantView(R.drawable.icon_crown);
            this.ME.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.fAb.setLayoutParams(layoutParams);
            this.fAc.setLayoutParams(layoutParams2);
        } else {
            this.fAb.jT(false);
        }
        this.fAb.tz(this.fAh.getPortrait());
        this.fAb.setOnClickListener(this.dmK);
        this.ME.setText(aq.cutChineseAndEnglishWithSuffix(this.fAh.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.fAh.brn());
        if (this.fAh.brm() < 1000) {
            String str2 = "0000" + this.fAh.brm();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.fAh.brm();
        }
        this.fAd.setText("NO." + str);
        this.fAf.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), aq.by(this.fAh.brl()), aq.by(this.fAh.getPost_num()), aq.by(this.fAh.getThread_num())));
    }

    public void setGrade(int i) {
        am.setImageResource(this.fAe, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void oT(int i) {
        am.setViewTextColor(this.ME, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fAd, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fAf, R.color.cp_cont_d, 1, i);
        if (this.fAh != null) {
            setGrade(this.fAh.brn());
        }
    }
}
