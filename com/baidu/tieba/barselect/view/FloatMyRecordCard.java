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
    private TextView dXU;
    private View.OnClickListener ege;
    private TextView gAU;
    private BazhuHeadView gAV;
    private VotedAreaLayout gAW;
    private TextView gAu;
    private ImageView gAv;
    private d gAy;
    private f gwL;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.gAy != null && FloatMyRecordCard.this.gAy.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.gAy.getUid();
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
        rV();
    }

    private void rV() {
        this.gAU = (TextView) findViewById(R.id.tv_voted_rank);
        this.gAV = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.gAV.getHeadView() != null) {
            this.gAV.getHeadView().setIsRound(true);
        }
        this.dXU = (TextView) findViewById(R.id.user_name);
        this.gAv = (ImageView) findViewById(R.id.grade);
        this.gAu = (TextView) findViewById(R.id.vote_id);
        this.gAW = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.gwL = fVar;
        if (this.gwL != null && this.gwL.bKq() != null) {
            e bKq = this.gwL.bKq();
            if (bKq != null) {
                this.status = bKq.getStatus();
            }
            this.gAy = this.gwL.bKp();
        }
        if (this.gwL == null || this.gAy == null || this.status != com.baidu.tieba.barselect.a.d.gAS) {
            setVisibility(8);
            return;
        }
        int rank = this.gAy.getRank();
        if (rank < 10) {
            this.gAU.setText("0" + rank);
        } else {
            this.gAU.setText("" + rank);
        }
        if (rank == 2) {
            this.gAU.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.gAU.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.gAV.wQ(this.gAy.getPortrait());
        this.gAV.setOnClickListener(this.ege);
        this.dXU.setText(aq.cutChineseAndEnglishWithSuffix(this.gAy.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.gAy.bKe());
        if (this.gAy.bKd() < 1000) {
            String str2 = "0000" + this.gAy.bKd();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.gAy.bKd();
        }
        this.gAu.setText("NO." + str);
        this.gAW.setMyRecordData(this.gAy);
    }

    public void setGrade(int i) {
        am.setImageResource(this.gAv, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void qk(int i) {
        if (this.gAy != null) {
            if (this.gAy.getRank() > 3) {
                am.setViewTextColor(this.gAU, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.dXU, R.color.cp_cont_b, 1, i);
            setGrade(this.gAy.bKe());
            am.setViewTextColor(this.gAu, R.color.cp_cont_d, 1, i);
            this.gAW.qk(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.gAy.bKe());
        }
    }
}
