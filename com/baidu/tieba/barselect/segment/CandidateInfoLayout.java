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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.BazhuHeadView;
/* loaded from: classes8.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView ala;
    private BazhuHeadView irP;
    private LinearLayout irQ;
    private TextView irR;
    private ImageView irS;
    private TextView irT;
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
                if (CandidateInfoLayout.this.irV != null && CandidateInfoLayout.this.irV.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.irV.getUid();
                    if ((CandidateInfoLayout.this.getContext() instanceof Activity) && CandidateInfoLayout.this.irV.ctM() != 2) {
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
        tN();
    }

    private void tN() {
        this.irP = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.irP.getHeadView() != null) {
            this.irP.getHeadView().setIsRound(true);
        }
        this.irQ = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.ala = (TextView) findViewById(R.id.user_name);
        this.irR = (TextView) findViewById(R.id.vote_id);
        this.irT = (TextView) findViewById(R.id.agree_post_reply_num);
        this.irS = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.ioi == null || this.irV == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.isk) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.irP.setLayoutParams(layoutParams);
            this.irP.pm(true);
            this.irP.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.irP.setPendantView(R.drawable.icon_crown);
            this.ala.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.irP.setLayoutParams(layoutParams);
            this.irQ.setLayoutParams(layoutParams2);
        } else {
            this.irP.pm(false);
        }
        this.irP.Cv(this.irV.getPortrait());
        this.irP.setOnClickListener(this.onClickListener);
        this.ala.setText(at.cutChineseAndEnglishWithSuffix(this.irV.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.irV.ctI());
        if (this.irV.ctM() == 2) {
            this.irR.setVisibility(8);
        } else {
            this.irR.setVisibility(0);
            if (this.irV.ctH() < 1000) {
                String str2 = "0000" + this.irV.ctH();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.irV.ctH();
            }
            this.irR.setText("NO." + str);
        }
        this.irT.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), at.ea(this.irV.ctG()), at.ea(this.irV.getThread_num()), at.ea(this.irV.getPost_num())));
    }

    public void setGrade(int i) {
        ao.setImageResource(this.irS, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void vU(int i) {
        ao.setViewTextColor(this.ala, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.irR, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.irT, R.color.CAM_X0109, 1, i);
        if (this.irV != null) {
            setGrade(this.irV.ctI());
        }
    }
}
