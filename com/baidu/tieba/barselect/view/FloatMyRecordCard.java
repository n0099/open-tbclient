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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes15.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView dKI;
    private View.OnClickListener eve;
    private f gPf;
    private TextView gSM;
    private ImageView gSN;
    private d gSQ;
    private TextView gTl;
    private BazhuHeadView gTm;
    private VotedAreaLayout gTn;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.gSQ != null && FloatMyRecordCard.this.gSQ.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.gSQ.getUid();
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
        ss();
    }

    private void ss() {
        this.gTl = (TextView) findViewById(R.id.tv_voted_rank);
        this.gTm = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.gTm.getHeadView() != null) {
            this.gTm.getHeadView().setIsRound(true);
        }
        this.dKI = (TextView) findViewById(R.id.user_name);
        this.gSN = (ImageView) findViewById(R.id.grade);
        this.gSM = (TextView) findViewById(R.id.vote_id);
        this.gTn = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.gPf = fVar;
        if (this.gPf != null && this.gPf.bQH() != null) {
            e bQH = this.gPf.bQH();
            if (bQH != null) {
                this.status = bQH.getStatus();
            }
            this.gSQ = this.gPf.bQG();
        }
        if (this.gPf == null || this.gSQ == null || this.status != com.baidu.tieba.barselect.a.d.gTj) {
            setVisibility(8);
            return;
        }
        int rank = this.gSQ.getRank();
        if (rank < 10) {
            this.gTl.setText("0" + rank);
        } else {
            this.gTl.setText("" + rank);
        }
        if (rank == 2) {
            this.gTl.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.gTl.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.gTm.ym(this.gSQ.getPortrait());
        this.gTm.setOnClickListener(this.eve);
        this.dKI.setText(as.cutChineseAndEnglishWithSuffix(this.gSQ.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.gSQ.bQv());
        if (this.gSQ.bQu() < 1000) {
            String str2 = "0000" + this.gSQ.bQu();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.gSQ.bQu();
        }
        this.gSM.setText("NO." + str);
        this.gTn.setMyRecordData(this.gSQ);
    }

    public void setGrade(int i) {
        ao.setImageResource(this.gSN, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void qZ(int i) {
        if (this.gSQ != null) {
            if (this.gSQ.getRank() > 3) {
                ao.setViewTextColor(this.gTl, R.color.cp_cont_b, 1, i);
            }
            ao.setViewTextColor(this.dKI, R.color.cp_cont_b, 1, i);
            setGrade(this.gSQ.bQv());
            ao.setViewTextColor(this.gSM, R.color.cp_cont_d, 1, i);
            this.gTn.qZ(i);
            ao.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.gSQ.bQv());
        }
    }
}
