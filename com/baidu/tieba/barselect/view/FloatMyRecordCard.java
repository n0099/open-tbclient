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
    private TextView ccZ;
    private View.OnClickListener clU;
    private f euM;
    private ImageView eyA;
    private d eyD;
    private TextView eyZ;
    private TextView eyz;
    private BazhuHeadView eza;
    private VotedAreaLayout ezb;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.eyD != null && FloatMyRecordCard.this.eyD.getUid() != 0) {
                    long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.eyD.getUid();
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
        qX();
    }

    private void qX() {
        this.eyZ = (TextView) findViewById(R.id.tv_voted_rank);
        this.eza = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eza.getHeadView() != null) {
            this.eza.getHeadView().setIsRound(true);
        }
        this.ccZ = (TextView) findViewById(R.id.user_name);
        this.eyA = (ImageView) findViewById(R.id.grade);
        this.eyz = (TextView) findViewById(R.id.vote_id);
        this.ezb = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.euM = fVar;
        if (this.euM != null && this.euM.aYP() != null) {
            e aYP = this.euM.aYP();
            if (aYP != null) {
                this.status = aYP.getStatus();
            }
            this.eyD = this.euM.aYO();
        }
        if (this.euM == null || this.eyD == null || this.status != com.baidu.tieba.barselect.a.d.eyX) {
            setVisibility(8);
            return;
        }
        int rank = this.eyD.getRank();
        if (rank < 10) {
            this.eyZ.setText("0" + rank);
        } else {
            this.eyZ.setText("" + rank);
        }
        if (rank == 2) {
            this.eyZ.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.eyZ.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.eza.oO(this.eyD.getPortrait());
        this.eza.setOnClickListener(this.clU);
        this.ccZ.setText(aq.j(this.eyD.aYE(), 14, "..."));
        setGrade(this.eyD.aYB());
        if (this.eyD.aYA() < 1000) {
            String str2 = "0000" + this.eyD.aYA();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.eyD.aYA();
        }
        this.eyz.setText("NO." + str);
        this.ezb.setMyRecordData(this.eyD);
    }

    public void setGrade(int i) {
        am.c(this.eyA, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nz(int i) {
        if (this.eyD != null) {
            if (this.eyD.getRank() > 3) {
                am.d(this.eyZ, R.color.cp_cont_b, 1, i);
            }
            am.d(this.ccZ, R.color.cp_cont_b, 1, i);
            setGrade(this.eyD.aYB());
            am.d(this.eyz, R.color.cp_cont_d, 1, i);
            this.ezb.nz(i);
            am.h(this, R.color.cp_bg_line_d, i);
            setGrade(this.eyD.aYB());
        }
    }
}
