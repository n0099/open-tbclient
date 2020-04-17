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
    private TextView cAX;
    private View.OnClickListener dRF;
    private f ghD;
    private TextView glN;
    private BazhuHeadView glO;
    private VotedAreaLayout glP;
    private TextView gln;
    private ImageView glo;
    private d glr;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRF = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.glr != null && FloatMyRecordCard.this.glr.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.glr.getUid();
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
        rL();
    }

    private void rL() {
        this.glN = (TextView) findViewById(R.id.tv_voted_rank);
        this.glO = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.glO.getHeadView() != null) {
            this.glO.getHeadView().setIsRound(true);
        }
        this.cAX = (TextView) findViewById(R.id.user_name);
        this.glo = (ImageView) findViewById(R.id.grade);
        this.gln = (TextView) findViewById(R.id.vote_id);
        this.glP = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ghD = fVar;
        if (this.ghD != null && this.ghD.bDY() != null) {
            e bDY = this.ghD.bDY();
            if (bDY != null) {
                this.status = bDY.getStatus();
            }
            this.glr = this.ghD.bDX();
        }
        if (this.ghD == null || this.glr == null || this.status != com.baidu.tieba.barselect.a.d.glL) {
            setVisibility(8);
            return;
        }
        int rank = this.glr.getRank();
        if (rank < 10) {
            this.glN.setText("0" + rank);
        } else {
            this.glN.setText("" + rank);
        }
        if (rank == 2) {
            this.glN.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.glN.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.glO.vh(this.glr.getPortrait());
        this.glO.setOnClickListener(this.dRF);
        this.cAX.setText(aq.cutChineseAndEnglishWithSuffix(this.glr.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.glr.bDM());
        if (this.glr.bDL() < 1000) {
            String str2 = "0000" + this.glr.bDL();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.glr.bDL();
        }
        this.gln.setText("NO." + str);
        this.glP.setMyRecordData(this.glr);
    }

    public void setGrade(int i) {
        am.setImageResource(this.glo, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void pH(int i) {
        if (this.glr != null) {
            if (this.glr.getRank() > 3) {
                am.setViewTextColor(this.glN, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.cAX, R.color.cp_cont_b, 1, i);
            setGrade(this.glr.bDM());
            am.setViewTextColor(this.gln, R.color.cp_cont_d, 1, i);
            this.glP.pH(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.glr.bDM());
        }
    }
}
