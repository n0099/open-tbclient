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
/* loaded from: classes6.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView bXF;
    private View.OnClickListener dmY;
    private TextView fDO;
    private BazhuHeadView fDP;
    private VotedAreaLayout fDQ;
    private TextView fDo;
    private ImageView fDp;
    private d fDs;
    private f fzH;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmY = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.fDs != null && FloatMyRecordCard.this.fDs.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.fDs.getUid();
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
        nb();
    }

    private void nb() {
        this.fDO = (TextView) findViewById(R.id.tv_voted_rank);
        this.fDP = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.fDP.getHeadView() != null) {
            this.fDP.getHeadView().setIsRound(true);
        }
        this.bXF = (TextView) findViewById(R.id.user_name);
        this.fDp = (ImageView) findViewById(R.id.grade);
        this.fDo = (TextView) findViewById(R.id.vote_id);
        this.fDQ = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.fzH = fVar;
        if (this.fzH != null && this.fzH.bsC() != null) {
            e bsC = this.fzH.bsC();
            if (bsC != null) {
                this.status = bsC.getStatus();
            }
            this.fDs = this.fzH.bsB();
        }
        if (this.fzH == null || this.fDs == null || this.status != com.baidu.tieba.barselect.a.d.fDM) {
            setVisibility(8);
            return;
        }
        int rank = this.fDs.getRank();
        if (rank < 10) {
            this.fDO.setText("0" + rank);
        } else {
            this.fDO.setText("" + rank);
        }
        if (rank == 2) {
            this.fDO.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.fDO.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.fDP.tD(this.fDs.getPortrait());
        this.fDP.setOnClickListener(this.dmY);
        this.bXF.setText(aq.cutChineseAndEnglishWithSuffix(this.fDs.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.fDs.bsp());
        if (this.fDs.bso() < 1000) {
            String str2 = "0000" + this.fDs.bso();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.fDs.bso();
        }
        this.fDo.setText("NO." + str);
        this.fDQ.setMyRecordData(this.fDs);
    }

    public void setGrade(int i) {
        am.setImageResource(this.fDp, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void oU(int i) {
        if (this.fDs != null) {
            if (this.fDs.getRank() > 3) {
                am.setViewTextColor(this.fDO, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.bXF, R.color.cp_cont_b, 1, i);
            setGrade(this.fDs.bsp());
            am.setViewTextColor(this.fDo, R.color.cp_cont_d, 1, i);
            this.fDQ.oU(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.fDs.bsp());
        }
    }
}
