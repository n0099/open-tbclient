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
    private TextView gAJ;
    private BazhuHeadView gAK;
    private VotedAreaLayout gAL;
    private TextView gAj;
    private ImageView gAk;
    private d gAn;
    private f gwA;
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
                if (FloatMyRecordCard.this.gAn != null && FloatMyRecordCard.this.gAn.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.gAn.getUid();
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
        this.gAJ = (TextView) findViewById(R.id.tv_voted_rank);
        this.gAK = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.gAK.getHeadView() != null) {
            this.gAK.getHeadView().setIsRound(true);
        }
        this.dXU = (TextView) findViewById(R.id.user_name);
        this.gAk = (ImageView) findViewById(R.id.grade);
        this.gAj = (TextView) findViewById(R.id.vote_id);
        this.gAL = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.gwA = fVar;
        if (this.gwA != null && this.gwA.bKo() != null) {
            e bKo = this.gwA.bKo();
            if (bKo != null) {
                this.status = bKo.getStatus();
            }
            this.gAn = this.gwA.bKn();
        }
        if (this.gwA == null || this.gAn == null || this.status != com.baidu.tieba.barselect.a.d.gAH) {
            setVisibility(8);
            return;
        }
        int rank = this.gAn.getRank();
        if (rank < 10) {
            this.gAJ.setText("0" + rank);
        } else {
            this.gAJ.setText("" + rank);
        }
        if (rank == 2) {
            this.gAJ.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.gAJ.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.gAK.wQ(this.gAn.getPortrait());
        this.gAK.setOnClickListener(this.ege);
        this.dXU.setText(aq.cutChineseAndEnglishWithSuffix(this.gAn.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.gAn.bKc());
        if (this.gAn.bKb() < 1000) {
            String str2 = "0000" + this.gAn.bKb();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.gAn.bKb();
        }
        this.gAj.setText("NO." + str);
        this.gAL.setMyRecordData(this.gAn);
    }

    public void setGrade(int i) {
        am.setImageResource(this.gAk, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void qi(int i) {
        if (this.gAn != null) {
            if (this.gAn.getRank() > 3) {
                am.setViewTextColor(this.gAJ, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.dXU, R.color.cp_cont_b, 1, i);
            setGrade(this.gAn.bKc());
            am.setViewTextColor(this.gAj, R.color.cp_cont_d, 1, i);
            this.gAL.qi(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.gAn.bKc());
        }
    }
}
