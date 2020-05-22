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
    private TextView agw;
    private View.OnClickListener ege;
    private BazhuHeadView gAh;
    private LinearLayout gAi;
    private TextView gAj;
    private ImageView gAk;
    private TextView gAl;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.gAn != null && CandidateInfoLayout.this.gAn.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.gAn.getUid();
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
        rV();
    }

    private void rV() {
        this.gAh = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.gAh.getHeadView() != null) {
            this.gAh.getHeadView().setIsRound(true);
        }
        this.gAi = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.agw = (TextView) findViewById(R.id.user_name);
        this.gAj = (TextView) findViewById(R.id.vote_id);
        this.gAl = (TextView) findViewById(R.id.agree_post_reply_num);
        this.gAk = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.gwA == null || this.gAn == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.gAD) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.gAh.setLayoutParams(layoutParams);
            this.gAh.lK(true);
            this.gAh.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.gAh.setPendantView(R.drawable.icon_crown);
            this.agw.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.gAh.setLayoutParams(layoutParams);
            this.gAi.setLayoutParams(layoutParams2);
        } else {
            this.gAh.lK(false);
        }
        this.gAh.wQ(this.gAn.getPortrait());
        this.gAh.setOnClickListener(this.ege);
        this.agw.setText(aq.cutChineseAndEnglishWithSuffix(this.gAn.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.gAn.bKc());
        if (this.gAn.bKb() < 1000) {
            String str2 = "0000" + this.gAn.bKb();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.gAn.bKb();
        }
        this.gAj.setText("NO." + str);
        this.gAl.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), aq.co(this.gAn.bKa()), aq.co(this.gAn.getThread_num()), aq.co(this.gAn.getPost_num())));
    }

    public void setGrade(int i) {
        am.setImageResource(this.gAk, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void qi(int i) {
        am.setViewTextColor(this.agw, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gAj, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gAl, R.color.cp_cont_d, 1, i);
        if (this.gAn != null) {
            setGrade(this.gAn.bKc());
        }
    }
}
