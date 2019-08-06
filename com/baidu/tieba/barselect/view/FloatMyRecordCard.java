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
    private TextView cdg;
    private View.OnClickListener cmb;
    private f euT;
    private TextView eyG;
    private ImageView eyH;
    private d eyK;
    private TextView ezg;
    private BazhuHeadView ezh;
    private VotedAreaLayout ezi;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmb = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.eyK != null && FloatMyRecordCard.this.eyK.getUid() != 0) {
                    long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.eyK.getUid();
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
        this.ezg = (TextView) findViewById(R.id.tv_voted_rank);
        this.ezh = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.ezh.getHeadView() != null) {
            this.ezh.getHeadView().setIsRound(true);
        }
        this.cdg = (TextView) findViewById(R.id.user_name);
        this.eyH = (ImageView) findViewById(R.id.grade);
        this.eyG = (TextView) findViewById(R.id.vote_id);
        this.ezi = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.euT = fVar;
        if (this.euT != null && this.euT.aYR() != null) {
            e aYR = this.euT.aYR();
            if (aYR != null) {
                this.status = aYR.getStatus();
            }
            this.eyK = this.euT.aYQ();
        }
        if (this.euT == null || this.eyK == null || this.status != com.baidu.tieba.barselect.a.d.eze) {
            setVisibility(8);
            return;
        }
        int rank = this.eyK.getRank();
        if (rank < 10) {
            this.ezg.setText("0" + rank);
        } else {
            this.ezg.setText("" + rank);
        }
        if (rank == 2) {
            this.ezg.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.ezg.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.ezh.oO(this.eyK.getPortrait());
        this.ezh.setOnClickListener(this.cmb);
        this.cdg.setText(aq.j(this.eyK.aYG(), 14, "..."));
        setGrade(this.eyK.aYD());
        if (this.eyK.aYC() < 1000) {
            String str2 = "0000" + this.eyK.aYC();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.eyK.aYC();
        }
        this.eyG.setText("NO." + str);
        this.ezi.setMyRecordData(this.eyK);
    }

    public void setGrade(int i) {
        am.c(this.eyH, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nA(int i) {
        if (this.eyK != null) {
            if (this.eyK.getRank() > 3) {
                am.d(this.ezg, R.color.cp_cont_b, 1, i);
            }
            am.d(this.cdg, R.color.cp_cont_b, 1, i);
            setGrade(this.eyK.aYD());
            am.d(this.eyG, R.color.cp_cont_d, 1, i);
            this.ezi.nA(i);
            am.h(this, R.color.cp_bg_line_d, i);
            setGrade(this.eyK.aYD());
        }
    }
}
