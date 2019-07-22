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
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.BazhuHeadView;
/* loaded from: classes3.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView XL;
    private View.OnClickListener clU;
    private ImageView eyA;
    private TextView eyB;
    private BazhuHeadView eyx;
    private LinearLayout eyy;
    private TextView eyz;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.eyD != null && CandidateInfoLayout.this.eyD.getUid() != 0) {
                    long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.eyD.getUid();
                    if (CandidateInfoLayout.this.getContext() instanceof Activity) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(CandidateInfoLayout.this.getContext()).createNormalConfig(uid, uid == c, false)));
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
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.candidate_info_layout, (ViewGroup) this, true);
        qX();
    }

    private void qX() {
        this.eyx = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eyx.getHeadView() != null) {
            this.eyx.getHeadView().setIsRound(true);
        }
        this.eyy = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.XL = (TextView) findViewById(R.id.user_name);
        this.eyz = (TextView) findViewById(R.id.vote_id);
        this.eyB = (TextView) findViewById(R.id.agree_post_reply_num);
        this.eyA = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.euM == null || this.eyD == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.eyT) {
            int g = l.g(this.mContext, R.dimen.tbds191);
            int g2 = l.g(this.mContext, R.dimen.tbds157);
            int g3 = l.g(this.mContext, R.dimen.tbds6);
            int g4 = l.g(this.mContext, R.dimen.tbds24);
            int g5 = l.g(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g);
            layoutParams.setMargins(layoutParams.leftMargin - g3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.eyx.setLayoutParams(layoutParams);
            this.eyx.iw(true);
            this.eyx.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.eyx.setPendantView(R.drawable.icon_crown);
            this.XL.setTextSize(0, l.g(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(g5, g4, layoutParams2.rightMargin, g3);
            this.eyx.setLayoutParams(layoutParams);
            this.eyy.setLayoutParams(layoutParams2);
        } else {
            this.eyx.iw(false);
        }
        this.eyx.oO(this.eyD.getPortrait());
        this.eyx.setOnClickListener(this.clU);
        this.XL.setText(aq.j(this.eyD.aYE(), 14, "..."));
        setGrade(this.eyD.aYB());
        if (this.eyD.aYA() < 1000) {
            String str2 = "0000" + this.eyD.aYA();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.eyD.aYA();
        }
        this.eyz.setText("NO." + str);
        this.eyB.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), aq.aP(this.eyD.aYz()), aq.aP(this.eyD.getPost_num()), aq.aP(this.eyD.getThread_num())));
    }

    public void setGrade(int i) {
        am.c(this.eyA, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nz(int i) {
        am.d(this.XL, R.color.cp_cont_b, 1, i);
        am.d(this.eyz, R.color.cp_cont_d, 1, i);
        am.d(this.eyB, R.color.cp_cont_d, 1, i);
        if (this.eyD != null) {
            setGrade(this.eyD.aYB());
        }
    }
}
