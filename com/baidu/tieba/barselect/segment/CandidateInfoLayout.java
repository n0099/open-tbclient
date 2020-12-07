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
/* loaded from: classes21.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView aky;
    private View.OnClickListener foP;
    private BazhuHeadView ifs;
    private LinearLayout ift;
    private TextView ifu;
    private ImageView ifv;
    private TextView ifw;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.ify != null && CandidateInfoLayout.this.ify.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.ify.getUid();
                    if ((CandidateInfoLayout.this.getContext() instanceof Activity) && CandidateInfoLayout.this.ify.cqS() != 2) {
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
        uo();
    }

    private void uo() {
        this.ifs = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.ifs.getHeadView() != null) {
            this.ifs.getHeadView().setIsRound(true);
        }
        this.ift = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.aky = (TextView) findViewById(R.id.user_name);
        this.ifu = (TextView) findViewById(R.id.vote_id);
        this.ifw = (TextView) findViewById(R.id.agree_post_reply_num);
        this.ifv = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.ibG == null || this.ify == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.ifN) {
            int dimens = l.getDimens(this.mContext, R.dimen.tbds191);
            int dimens2 = l.getDimens(this.mContext, R.dimen.tbds157);
            int dimens3 = l.getDimens(this.mContext, R.dimen.tbds6);
            int dimens4 = l.getDimens(this.mContext, R.dimen.tbds24);
            int dimens5 = l.getDimens(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
            layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.ifs.setLayoutParams(layoutParams);
            this.ifs.oN(true);
            this.ifs.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.ifs.setPendantView(R.drawable.icon_crown);
            this.aky.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
            this.ifs.setLayoutParams(layoutParams);
            this.ift.setLayoutParams(layoutParams2);
        } else {
            this.ifs.oN(false);
        }
        this.ifs.Cx(this.ify.getPortrait());
        this.ifs.setOnClickListener(this.foP);
        this.aky.setText(au.cutChineseAndEnglishWithSuffix(this.ify.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.ify.cqO());
        if (this.ify.cqS() == 2) {
            this.ifu.setVisibility(8);
        } else {
            this.ifu.setVisibility(0);
            if (this.ify.cqN() < 1000) {
                String str2 = "0000" + this.ify.cqN();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.ify.cqN();
            }
            this.ifu.setText("NO." + str);
        }
        this.ifw.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), au.ea(this.ify.cqM()), au.ea(this.ify.getThread_num()), au.ea(this.ify.getPost_num())));
    }

    public void setGrade(int i) {
        ap.setImageResource(this.ifv, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void vJ(int i) {
        ap.setViewTextColor(this.aky, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.ifu, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.ifw, R.color.CAM_X0109, 1, i);
        if (this.ify != null) {
            setGrade(this.ify.cqO());
        }
    }
}
