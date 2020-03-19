package com.baidu.tieba.barselect.view;

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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes8.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView cbW;
    private View.OnClickListener drJ;
    private f fDc;
    private TextView fGI;
    private ImageView fGJ;
    private d fGM;
    private TextView fHi;
    private BazhuHeadView fHj;
    private VotedAreaLayout fHk;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.fGM != null && FloatMyRecordCard.this.fGM.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.fGM.getUid();
                    if (FloatMyRecordCard.this.getContext() instanceof Activity) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FloatMyRecordCard.this.getContext()).createNormalConfig(uid, uid == j, false)));
                    }
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.float_my_record_card, (ViewGroup) this, true);
        ns();
    }

    private void ns() {
        this.fHi = (TextView) findViewById(R.id.tv_voted_rank);
        this.fHj = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.fHj.getHeadView() != null) {
            this.fHj.getHeadView().setIsRound(true);
        }
        this.cbW = (TextView) findViewById(R.id.user_name);
        this.fGJ = (ImageView) findViewById(R.id.grade);
        this.fGI = (TextView) findViewById(R.id.vote_id);
        this.fHk = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.fDc = fVar;
        if (this.fDc != null && this.fDc.buo() != null) {
            e buo = this.fDc.buo();
            if (buo != null) {
                this.status = buo.getStatus();
            }
            this.fGM = this.fDc.bun();
        }
        if (this.fDc == null || this.fGM == null || this.status != com.baidu.tieba.barselect.a.d.fHg) {
            setVisibility(8);
            return;
        }
        int rank = this.fGM.getRank();
        if (rank < 10) {
            this.fHi.setText("0" + rank);
        } else {
            this.fHi.setText("" + rank);
        }
        if (rank == 2) {
            this.fHi.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.fHi.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.fHj.tU(this.fGM.getPortrait());
        this.fHj.setOnClickListener(this.drJ);
        this.cbW.setText(aq.cutChineseAndEnglishWithSuffix(this.fGM.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.fGM.bub());
        if (this.fGM.bua() < 1000) {
            String str2 = "0000" + this.fGM.bua();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.fGM.bua();
        }
        this.fGI.setText("NO." + str);
        this.fHk.setMyRecordData(this.fGM);
    }

    public void setGrade(int i) {
        am.setImageResource(this.fGJ, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void pm(int i) {
        if (this.fGM != null) {
            if (this.fGM.getRank() > 3) {
                am.setViewTextColor(this.fHi, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.cbW, R.color.cp_cont_b, 1, i);
            setGrade(this.fGM.bub());
            am.setViewTextColor(this.fGI, R.color.cp_cont_d, 1, i);
            this.fHk.pm(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.fGM.bub());
        }
    }
}
