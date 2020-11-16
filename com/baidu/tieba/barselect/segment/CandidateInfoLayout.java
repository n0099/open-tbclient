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
/* loaded from: classes20.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView ajz;
    private View.OnClickListener fhp;
    private BazhuHeadView hUv;
    private LinearLayout hUw;
    private TextView hUx;
    private ImageView hUy;
    private TextView hUz;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.hUB != null && CandidateInfoLayout.this.hUB.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.hUB.getUid();
                    if ((CandidateInfoLayout.this.getContext() instanceof Activity) && CandidateInfoLayout.this.hUB.cmF() != 2) {
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
        this.hUv = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hUv.getHeadView() != null) {
            this.hUv.getHeadView().setIsRound(true);
        }
        this.hUw = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.ajz = (TextView) findViewById(R.id.user_name);
        this.hUx = (TextView) findViewById(R.id.vote_id);
        this.hUz = (TextView) findViewById(R.id.agree_post_reply_num);
        this.hUy = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.hQM == null || this.hUB == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.hUQ) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.hUv.setLayoutParams(layoutParams);
            this.hUv.or(true);
            this.hUv.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.hUv.setPendantView(R.drawable.icon_crown);
            this.ajz.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.hUv.setLayoutParams(layoutParams);
            this.hUw.setLayoutParams(layoutParams2);
        } else {
            this.hUv.or(false);
        }
        this.hUv.BP(this.hUB.getPortrait());
        this.hUv.setOnClickListener(this.fhp);
        this.ajz.setText(au.cutChineseAndEnglishWithSuffix(this.hUB.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hUB.cmB());
        if (this.hUB.cmF() == 2) {
            this.hUx.setVisibility(8);
        } else {
            this.hUx.setVisibility(0);
            if (this.hUB.cmA() < 1000) {
                String str2 = "0000" + this.hUB.cmA();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.hUB.cmA();
            }
            this.hUx.setText("NO." + str);
        }
        this.hUz.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), au.dB(this.hUB.cmz()), au.dB(this.hUB.getThread_num()), au.dB(this.hUB.getPost_num())));
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hUy, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void vc(int i) {
        ap.setViewTextColor(this.ajz, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.hUx, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.hUz, R.color.CAM_X0109, 1, i);
        if (this.hUB != null) {
            setGrade(this.hUB.cmB());
        }
    }
}
