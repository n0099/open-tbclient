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
/* loaded from: classes5.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView bXt;
    private View.OnClickListener dmK;
    private TextView fAD;
    private BazhuHeadView fAE;
    private VotedAreaLayout fAF;
    private TextView fAd;
    private ImageView fAe;
    private d fAh;
    private f fww;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.fAh != null && FloatMyRecordCard.this.fAh.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.fAh.getUid();
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
        na();
    }

    private void na() {
        this.fAD = (TextView) findViewById(R.id.tv_voted_rank);
        this.fAE = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.fAE.getHeadView() != null) {
            this.fAE.getHeadView().setIsRound(true);
        }
        this.bXt = (TextView) findViewById(R.id.user_name);
        this.fAe = (ImageView) findViewById(R.id.grade);
        this.fAd = (TextView) findViewById(R.id.vote_id);
        this.fAF = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.fww = fVar;
        if (this.fww != null && this.fww.brA() != null) {
            e brA = this.fww.brA();
            if (brA != null) {
                this.status = brA.getStatus();
            }
            this.fAh = this.fww.brz();
        }
        if (this.fww == null || this.fAh == null || this.status != com.baidu.tieba.barselect.a.d.fAB) {
            setVisibility(8);
            return;
        }
        int rank = this.fAh.getRank();
        if (rank < 10) {
            this.fAD.setText("0" + rank);
        } else {
            this.fAD.setText("" + rank);
        }
        if (rank == 2) {
            this.fAD.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.fAD.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.fAE.tz(this.fAh.getPortrait());
        this.fAE.setOnClickListener(this.dmK);
        this.bXt.setText(aq.cutChineseAndEnglishWithSuffix(this.fAh.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.fAh.brn());
        if (this.fAh.brm() < 1000) {
            String str2 = "0000" + this.fAh.brm();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.fAh.brm();
        }
        this.fAd.setText("NO." + str);
        this.fAF.setMyRecordData(this.fAh);
    }

    public void setGrade(int i) {
        am.setImageResource(this.fAe, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void oT(int i) {
        if (this.fAh != null) {
            if (this.fAh.getRank() > 3) {
                am.setViewTextColor(this.fAD, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.bXt, R.color.cp_cont_b, 1, i);
            setGrade(this.fAh.brn());
            am.setViewTextColor(this.fAd, R.color.cp_cont_d, 1, i);
            this.fAF.oT(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.fAh.brn());
        }
    }
}
