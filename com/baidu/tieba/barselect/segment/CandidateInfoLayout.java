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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.BazhuHeadView;
/* loaded from: classes8.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView ahA;
    private View.OnClickListener eoP;
    private BazhuHeadView gNe;
    private LinearLayout gNf;
    private TextView gNg;
    private ImageView gNh;
    private TextView gNi;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.gNk != null && CandidateInfoLayout.this.gNk.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.gNk.getUid();
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
        sq();
    }

    private void sq() {
        this.gNe = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.gNe.getHeadView() != null) {
            this.gNe.getHeadView().setIsRound(true);
        }
        this.gNf = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.ahA = (TextView) findViewById(R.id.user_name);
        this.gNg = (TextView) findViewById(R.id.vote_id);
        this.gNi = (TextView) findViewById(R.id.agree_post_reply_num);
        this.gNh = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.gJz == null || this.gNk == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.gNz) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.gNe.setLayoutParams(layoutParams);
            this.gNe.lT(true);
            this.gNe.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.gNe.setPendantView(R.drawable.icon_crown);
            this.ahA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.gNe.setLayoutParams(layoutParams);
            this.gNf.setLayoutParams(layoutParams2);
        } else {
            this.gNe.lT(false);
        }
        this.gNe.xh(this.gNk.getPortrait());
        this.gNe.setOnClickListener(this.eoP);
        this.ahA.setText(ar.cutChineseAndEnglishWithSuffix(this.gNk.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.gNk.bNj());
        if (this.gNk.bNi() < 1000) {
            String str2 = "0000" + this.gNk.bNi();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.gNk.bNi();
        }
        this.gNg.setText("NO." + str);
        this.gNi.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), ar.cq(this.gNk.bNh()), ar.cq(this.gNk.getThread_num()), ar.cq(this.gNk.getPost_num())));
    }

    public void setGrade(int i) {
        an.setImageResource(this.gNh, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void qJ(int i) {
        an.setViewTextColor(this.ahA, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.gNg, R.color.cp_cont_d, 1, i);
        an.setViewTextColor(this.gNi, R.color.cp_cont_d, 1, i);
        if (this.gNk != null) {
            setGrade(this.gNk.bNj());
        }
    }
}
