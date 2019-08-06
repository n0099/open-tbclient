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
    private View.OnClickListener cmb;
    private BazhuHeadView eyE;
    private LinearLayout eyF;
    private TextView eyG;
    private ImageView eyH;
    private TextView eyI;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmb = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.eyK != null && CandidateInfoLayout.this.eyK.getUid() != 0) {
                    long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.eyK.getUid();
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
        this.eyE = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eyE.getHeadView() != null) {
            this.eyE.getHeadView().setIsRound(true);
        }
        this.eyF = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.XL = (TextView) findViewById(R.id.user_name);
        this.eyG = (TextView) findViewById(R.id.vote_id);
        this.eyI = (TextView) findViewById(R.id.agree_post_reply_num);
        this.eyH = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.euT == null || this.eyK == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.eza) {
            int g = l.g(this.mContext, R.dimen.tbds191);
            int g2 = l.g(this.mContext, R.dimen.tbds157);
            int g3 = l.g(this.mContext, R.dimen.tbds6);
            int g4 = l.g(this.mContext, R.dimen.tbds24);
            int g5 = l.g(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g);
            layoutParams.setMargins(layoutParams.leftMargin - g3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.eyE.setLayoutParams(layoutParams);
            this.eyE.iw(true);
            this.eyE.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.eyE.setPendantView(R.drawable.icon_crown);
            this.XL.setTextSize(0, l.g(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(g5, g4, layoutParams2.rightMargin, g3);
            this.eyE.setLayoutParams(layoutParams);
            this.eyF.setLayoutParams(layoutParams2);
        } else {
            this.eyE.iw(false);
        }
        this.eyE.oO(this.eyK.getPortrait());
        this.eyE.setOnClickListener(this.cmb);
        this.XL.setText(aq.j(this.eyK.aYG(), 14, "..."));
        setGrade(this.eyK.aYD());
        if (this.eyK.aYC() < 1000) {
            String str2 = "0000" + this.eyK.aYC();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.eyK.aYC();
        }
        this.eyG.setText("NO." + str);
        this.eyI.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), aq.aP(this.eyK.aYB()), aq.aP(this.eyK.getPost_num()), aq.aP(this.eyK.getThread_num())));
    }

    public void setGrade(int i) {
        am.c(this.eyH, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nA(int i) {
        am.d(this.XL, R.color.cp_cont_b, 1, i);
        am.d(this.eyG, R.color.cp_cont_d, 1, i);
        am.d(this.eyI, R.color.cp_cont_d, 1, i);
        if (this.eyK != null) {
            setGrade(this.eyK.aYD());
        }
    }
}
