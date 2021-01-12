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
/* loaded from: classes7.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView akj;
    private BazhuHeadView inh;
    private LinearLayout ini;
    private TextView inj;
    private ImageView ink;
    private TextView inl;
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
                if (CandidateInfoLayout.this.inn != null && CandidateInfoLayout.this.inn.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.inn.getUid();
                    if ((CandidateInfoLayout.this.getContext() instanceof Activity) && CandidateInfoLayout.this.inn.cpV() != 2) {
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
        tC();
    }

    private void tC() {
        this.inh = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.inh.getHeadView() != null) {
            this.inh.getHeadView().setIsRound(true);
        }
        this.ini = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.akj = (TextView) findViewById(R.id.user_name);
        this.inj = (TextView) findViewById(R.id.vote_id);
        this.inl = (TextView) findViewById(R.id.agree_post_reply_num);
        this.ink = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.ijz == null || this.inn == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.inD) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.inh.setLayoutParams(layoutParams);
            this.inh.pi(true);
            this.inh.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.inh.setPendantView(R.drawable.icon_crown);
            this.akj.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.inh.setLayoutParams(layoutParams);
            this.ini.setLayoutParams(layoutParams2);
        } else {
            this.inh.pi(false);
        }
        this.inh.Bj(this.inn.getPortrait());
        this.inh.setOnClickListener(this.onClickListener);
        this.akj.setText(at.cutChineseAndEnglishWithSuffix(this.inn.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.inn.cpR());
        if (this.inn.cpV() == 2) {
            this.inj.setVisibility(8);
        } else {
            this.inj.setVisibility(0);
            if (this.inn.cpQ() < 1000) {
                String str2 = "0000" + this.inn.cpQ();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.inn.cpQ();
            }
            this.inj.setText("NO." + str);
        }
        this.inl.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), at.ea(this.inn.cpP()), at.ea(this.inn.getThread_num()), at.ea(this.inn.getPost_num())));
    }

    public void setGrade(int i) {
        ao.setImageResource(this.ink, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uo(int i) {
        ao.setViewTextColor(this.akj, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.inj, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.inl, R.color.CAM_X0109, 1, i);
        if (this.inn != null) {
            setGrade(this.inn.cpR());
        }
    }
}
