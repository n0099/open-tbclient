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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.BazhuHeadView;
/* loaded from: classes3.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    private TextView Xq;
    private View.OnClickListener ckI;
    private TextView etA;
    private ImageView etB;
    private TextView etC;
    private BazhuHeadView ety;
    private LinearLayout etz;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckI = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.etE != null && CandidateInfoLayout.this.etE.getUid() != 0) {
                    long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.etE.getUid();
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
        qA();
    }

    private void qA() {
        this.ety = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.ety.getHeadView() != null) {
            this.ety.getHeadView().setIsRound(true);
        }
        this.etz = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.Xq = (TextView) findViewById(R.id.user_name);
        this.etA = (TextView) findViewById(R.id.vote_id);
        this.etC = (TextView) findViewById(R.id.agree_post_reply_num);
        this.etB = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.epO == null || this.etE == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.etU) {
            int g = l.g(this.mContext, R.dimen.tbds191);
            int g2 = l.g(this.mContext, R.dimen.tbds157);
            int g3 = l.g(this.mContext, R.dimen.tbds6);
            int g4 = l.g(this.mContext, R.dimen.tbds24);
            int g5 = l.g(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g);
            layoutParams.setMargins(layoutParams.leftMargin - g3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.ety.setLayoutParams(layoutParams);
            this.ety.in(true);
            this.ety.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.ety.setPendantView(R.drawable.icon_crown);
            this.Xq.setTextSize(0, l.g(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(g5, g4, layoutParams2.rightMargin, g3);
            this.ety.setLayoutParams(layoutParams);
            this.etz.setLayoutParams(layoutParams2);
        } else {
            this.ety.in(false);
        }
        this.ety.ox(this.etE.getPortrait());
        this.ety.setOnClickListener(this.ckI);
        this.Xq.setText(ap.j(this.etE.aWI(), 14, "..."));
        setGrade(this.etE.aWF());
        if (this.etE.aWE() < 1000) {
            String str2 = "0000" + this.etE.aWE();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.etE.aWE();
        }
        this.etA.setText("NO." + str);
        this.etC.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), ap.aO(this.etE.aWD()), ap.aO(this.etE.getPost_num()), ap.aO(this.etE.getThread_num())));
    }

    public void setGrade(int i) {
        al.c(this.etB, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nq(int i) {
        al.c(this.Xq, R.color.cp_cont_b, 1, i);
        al.c(this.etA, R.color.cp_cont_d, 1, i);
        al.c(this.etC, R.color.cp_cont_d, 1, i);
        if (this.etE != null) {
            setGrade(this.etE.aWF());
        }
    }
}
