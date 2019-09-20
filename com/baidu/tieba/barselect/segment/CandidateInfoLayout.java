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
    private TextView XK;
    private View.OnClickListener cmX;
    private BazhuHeadView eAn;
    private LinearLayout eAo;
    private TextView eAp;
    private ImageView eAq;
    private TextView eAr;
    private Context mContext;

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmX = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.CandidateInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CandidateInfoLayout.this.eAt != null && CandidateInfoLayout.this.eAt.getUid() != 0) {
                    long e = b.e(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = CandidateInfoLayout.this.eAt.getUid();
                    if (CandidateInfoLayout.this.getContext() instanceof Activity) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(CandidateInfoLayout.this.getContext()).createNormalConfig(uid, uid == e, false)));
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
        qY();
    }

    private void qY() {
        this.eAn = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eAn.getHeadView() != null) {
            this.eAn.getHeadView().setIsRound(true);
        }
        this.eAo = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.XK = (TextView) findViewById(R.id.user_name);
        this.eAp = (TextView) findViewById(R.id.vote_id);
        this.eAr = (TextView) findViewById(R.id.agree_post_reply_num);
        this.eAq = (ImageView) findViewById(R.id.grade);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        String str;
        super.setData(i, fVar);
        if (this.ewD == null || this.eAt == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.eAJ) {
            int g = l.g(this.mContext, R.dimen.tbds191);
            int g2 = l.g(this.mContext, R.dimen.tbds157);
            int g3 = l.g(this.mContext, R.dimen.tbds6);
            int g4 = l.g(this.mContext, R.dimen.tbds24);
            int g5 = l.g(this.mContext, R.dimen.tbds30);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g);
            layoutParams.setMargins(layoutParams.leftMargin - g3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.eAn.setLayoutParams(layoutParams);
            this.eAn.iz(true);
            this.eAn.setBawuLogoView(R.drawable.pic_election_bazhu);
            this.eAn.setPendantView(R.drawable.icon_crown);
            this.XK.setTextSize(0, l.g(this.mContext, R.dimen.tbfontsize46));
            setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(g5, g4, layoutParams2.rightMargin, g3);
            this.eAn.setLayoutParams(layoutParams);
            this.eAo.setLayoutParams(layoutParams2);
        } else {
            this.eAn.iz(false);
        }
        this.eAn.oW(this.eAt.getPortrait());
        this.eAn.setOnClickListener(this.cmX);
        this.XK.setText(aq.j(this.eAt.aZk(), 14, "..."));
        setGrade(this.eAt.aZh());
        if (this.eAt.aZg() < 1000) {
            String str2 = "0000" + this.eAt.aZg();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.eAt.aZg();
        }
        this.eAp.setText("NO." + str);
        this.eAr.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), aq.aP(this.eAt.aZf()), aq.aP(this.eAt.getPost_num()), aq.aP(this.eAt.getThread_num())));
    }

    public void setGrade(int i) {
        am.c(this.eAq, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nE(int i) {
        am.d(this.XK, R.color.cp_cont_b, 1, i);
        am.d(this.eAp, R.color.cp_cont_d, 1, i);
        am.d(this.eAr, R.color.cp_cont_d, 1, i);
        if (this.eAt != null) {
            setGrade(this.eAt.aZh());
        }
    }
}
