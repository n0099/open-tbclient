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
    private TextView cbW;
    private View.OnClickListener ckI;
    private f epO;
    private TextView etA;
    private ImageView etB;
    private d etE;
    private TextView eua;
    private BazhuHeadView eub;
    private VotedAreaLayout euc;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckI = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.etE != null && FloatMyRecordCard.this.etE.getUid() != 0) {
                    long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.etE.getUid();
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
        this.eua = (TextView) findViewById(R.id.tv_voted_rank);
        this.eub = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eub.getHeadView() != null) {
            this.eub.getHeadView().setIsRound(true);
        }
        this.cbW = (TextView) findViewById(R.id.user_name);
        this.etB = (ImageView) findViewById(R.id.grade);
        this.etA = (TextView) findViewById(R.id.vote_id);
        this.euc = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.epO = fVar;
        if (this.epO != null && this.epO.aWT() != null) {
            e aWT = this.epO.aWT();
            if (aWT != null) {
                this.status = aWT.getStatus();
            }
            this.etE = this.epO.aWS();
        }
        if (this.epO == null || this.etE == null || this.status != com.baidu.tieba.barselect.a.d.etY) {
            setVisibility(8);
            return;
        }
        int rank = this.etE.getRank();
        if (rank < 10) {
            this.eua.setText("0" + rank);
        } else {
            this.eua.setText("" + rank);
        }
        if (rank == 2) {
            this.eua.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.eua.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.eub.ox(this.etE.getPortrait());
        this.eub.setOnClickListener(this.ckI);
        this.cbW.setText(ap.j(this.etE.aWI(), 14, "..."));
        setGrade(this.etE.aWF());
        if (this.etE.aWE() < 1000) {
            String str2 = "0000" + this.etE.aWE();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.etE.aWE();
        }
        this.etA.setText("NO." + str);
        this.euc.setMyRecordData(this.etE);
    }

    public void setGrade(int i) {
        al.c(this.etB, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void nq(int i) {
        if (this.etE != null) {
            if (this.etE.getRank() > 3) {
                al.c(this.eua, R.color.cp_cont_b, 1, i);
            }
            al.c(this.cbW, R.color.cp_cont_b, 1, i);
            setGrade(this.etE.aWF());
            al.c(this.etA, R.color.cp_cont_d, 1, i);
            this.euc.nq(i);
            al.h(this, R.color.cp_bg_line_d, i);
            setGrade(this.etE.aWF());
        }
    }
}
