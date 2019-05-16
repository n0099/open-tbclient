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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes3.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView cbV;
    private View.OnClickListener ckH;
    private f epN;
    private ImageView etA;
    private d etD;
    private TextView etZ;
    private TextView etz;
    private BazhuHeadView eua;
    private VotedAreaLayout eub;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.etD != null && FloatMyRecordCard.this.etD.getUid() != 0) {
                    long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.etD.getUid();
                    if (FloatMyRecordCard.this.getContext() instanceof Activity) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FloatMyRecordCard.this.getContext()).createNormalConfig(uid, uid == c, false)));
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
        qA();
    }

    private void qA() {
        this.etZ = (TextView) findViewById(R.id.tv_voted_rank);
        this.eua = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eua.getHeadView() != null) {
            this.eua.getHeadView().setIsRound(true);
        }
        this.cbV = (TextView) findViewById(R.id.user_name);
        this.etA = (ImageView) findViewById(R.id.grade);
        this.etz = (TextView) findViewById(R.id.vote_id);
        this.eub = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.epN = fVar;
        if (this.epN != null && this.epN.aWQ() != null) {
            e aWQ = this.epN.aWQ();
            if (aWQ != null) {
                this.status = aWQ.getStatus();
            }
            this.etD = this.epN.aWP();
        }
        if (this.epN == null || this.etD == null || this.status != com.baidu.tieba.barselect.a.d.etX) {
            setVisibility(8);
            return;
        }
        int rank = this.etD.getRank();
        if (rank < 10) {
            this.etZ.setText("0" + rank);
        } else {
            this.etZ.setText("" + rank);
        }
        if (rank == 2) {
            this.etZ.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.etZ.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.eua.oy(this.etD.getPortrait());
        this.eua.setOnClickListener(this.ckH);
        this.cbV.setText(ap.j(this.etD.aWF(), 14, "..."));
        setGrade(this.etD.aWC());
        if (this.etD.aWB() < 1000) {
            String str2 = "0000" + this.etD.aWB();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.etD.aWB();
        }
        this.etz.setText("NO." + str);
        this.eub.setMyRecordData(this.etD);
    }

    public void setGrade(int i) {
        al.c(this.etA, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nq(int i) {
        if (this.etD != null) {
            if (this.etD.getRank() > 3) {
                al.c(this.etZ, R.color.cp_cont_b, 1, i);
            }
            al.c(this.cbV, R.color.cp_cont_b, 1, i);
            setGrade(this.etD.aWC());
            al.c(this.etz, R.color.cp_cont_d, 1, i);
            this.eub.nq(i);
            al.h(this, R.color.cp_bg_line_d, i);
            setGrade(this.etD.aWC());
        }
    }
}
