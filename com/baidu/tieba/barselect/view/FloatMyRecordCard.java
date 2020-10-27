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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes21.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView eqE;
    private View.OnClickListener fcr;
    private f hKp;
    private BazhuHeadView hOA;
    private VotedAreaLayout hOB;
    private TextView hOa;
    private ImageView hOb;
    private d hOe;
    private TextView hOz;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.hOe != null && FloatMyRecordCard.this.hOe.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.hOe.getUid();
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
        ul();
    }

    private void ul() {
        this.hOz = (TextView) findViewById(R.id.tv_voted_rank);
        this.hOA = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hOA.getHeadView() != null) {
            this.hOA.getHeadView().setIsRound(true);
        }
        this.eqE = (TextView) findViewById(R.id.user_name);
        this.hOb = (ImageView) findViewById(R.id.grade);
        this.hOa = (TextView) findViewById(R.id.vote_id);
        this.hOB = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.hKp = fVar;
        if (this.hKp != null && this.hKp.ckL() != null) {
            e ckL = this.hKp.ckL();
            if (ckL != null) {
                this.status = ckL.getStatus();
            }
            this.hOe = this.hKp.ckK();
        }
        if (this.hKp == null || this.hOe == null || this.status != com.baidu.tieba.barselect.a.d.hOx) {
            setVisibility(8);
            return;
        }
        int rank = this.hOe.getRank();
        if (rank < 10) {
            this.hOz.setText("0" + rank);
        } else {
            this.hOz.setText("" + rank);
        }
        if (rank == 2) {
            this.hOz.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.hOz.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.hOA.Cc(this.hOe.getPortrait());
        this.hOA.setOnClickListener(this.fcr);
        this.eqE.setText(at.cutChineseAndEnglishWithSuffix(this.hOe.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hOe.ckx());
        if (this.hOe.ckw() < 1000) {
            String str2 = "0000" + this.hOe.ckw();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.hOe.ckw();
        }
        this.hOa.setText("NO." + str);
        this.hOB.setMyRecordData(this.hOe);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hOb, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uu(int i) {
        if (this.hOe != null) {
            if (this.hOe.getRank() > 3) {
                ap.setViewTextColor(this.hOz, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.eqE, R.color.cp_cont_b, 1, i);
            setGrade(this.hOe.ckx());
            ap.setViewTextColor(this.hOa, R.color.cp_cont_d, 1, i);
            this.hOB.uu(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.hOe.ckx());
        }
    }
}
