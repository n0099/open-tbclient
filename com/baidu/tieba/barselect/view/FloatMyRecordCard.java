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
import com.baidu.adp.lib.g.b;
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
/* loaded from: classes3.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView cdZ;
    private View.OnClickListener cmX;
    private TextView eAP;
    private BazhuHeadView eAQ;
    private VotedAreaLayout eAR;
    private TextView eAp;
    private ImageView eAq;
    private d eAt;
    private f ewD;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmX = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.eAt != null && FloatMyRecordCard.this.eAt.getUid() != 0) {
                    long e = b.e(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.eAt.getUid();
                    if (FloatMyRecordCard.this.getContext() instanceof Activity) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FloatMyRecordCard.this.getContext()).createNormalConfig(uid, uid == e, false)));
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
        qY();
    }

    private void qY() {
        this.eAP = (TextView) findViewById(R.id.tv_voted_rank);
        this.eAQ = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eAQ.getHeadView() != null) {
            this.eAQ.getHeadView().setIsRound(true);
        }
        this.cdZ = (TextView) findViewById(R.id.user_name);
        this.eAq = (ImageView) findViewById(R.id.grade);
        this.eAp = (TextView) findViewById(R.id.vote_id);
        this.eAR = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ewD = fVar;
        if (this.ewD != null && this.ewD.aZv() != null) {
            e aZv = this.ewD.aZv();
            if (aZv != null) {
                this.status = aZv.getStatus();
            }
            this.eAt = this.ewD.aZu();
        }
        if (this.ewD == null || this.eAt == null || this.status != com.baidu.tieba.barselect.a.d.eAN) {
            setVisibility(8);
            return;
        }
        int rank = this.eAt.getRank();
        if (rank < 10) {
            this.eAP.setText("0" + rank);
        } else {
            this.eAP.setText("" + rank);
        }
        if (rank == 2) {
            this.eAP.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.eAP.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.eAQ.oW(this.eAt.getPortrait());
        this.eAQ.setOnClickListener(this.cmX);
        this.cdZ.setText(aq.j(this.eAt.aZk(), 14, "..."));
        setGrade(this.eAt.aZh());
        if (this.eAt.aZg() < 1000) {
            String str2 = "0000" + this.eAt.aZg();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.eAt.aZg();
        }
        this.eAp.setText("NO." + str);
        this.eAR.setMyRecordData(this.eAt);
    }

    public void setGrade(int i) {
        am.c(this.eAq, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nE(int i) {
        if (this.eAt != null) {
            if (this.eAt.getRank() > 3) {
                am.d(this.eAP, R.color.cp_cont_b, 1, i);
            }
            am.d(this.cdZ, R.color.cp_cont_b, 1, i);
            setGrade(this.eAt.aZh());
            am.d(this.eAp, R.color.cp_cont_d, 1, i);
            this.eAR.nE(i);
            am.h(this, R.color.cp_bg_line_d, i);
            setGrade(this.eAt.aZh());
        }
    }
}
