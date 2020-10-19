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
    private View.OnClickListener eTU;
    private TextView eig;
    private TextView hBE;
    private ImageView hBF;
    private d hBI;
    private TextView hCd;
    private BazhuHeadView hCe;
    private VotedAreaLayout hCf;
    private f hxT;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.hBI != null && FloatMyRecordCard.this.hBI.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.hBI.getUid();
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
        this.hCd = (TextView) findViewById(R.id.tv_voted_rank);
        this.hCe = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hCe.getHeadView() != null) {
            this.hCe.getHeadView().setIsRound(true);
        }
        this.eig = (TextView) findViewById(R.id.user_name);
        this.hBF = (ImageView) findViewById(R.id.grade);
        this.hBE = (TextView) findViewById(R.id.vote_id);
        this.hCf = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.hxT = fVar;
        if (this.hxT != null && this.hxT.chE() != null) {
            e chE = this.hxT.chE();
            if (chE != null) {
                this.status = chE.getStatus();
            }
            this.hBI = this.hxT.chD();
        }
        if (this.hxT == null || this.hBI == null || this.status != com.baidu.tieba.barselect.a.d.hCb) {
            setVisibility(8);
            return;
        }
        int rank = this.hBI.getRank();
        if (rank < 10) {
            this.hCd.setText("0" + rank);
        } else {
            this.hCd.setText("" + rank);
        }
        if (rank == 2) {
            this.hCd.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.hCd.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.hCe.BJ(this.hBI.getPortrait());
        this.hCe.setOnClickListener(this.eTU);
        this.eig.setText(at.cutChineseAndEnglishWithSuffix(this.hBI.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hBI.chq());
        if (this.hBI.chp() < 1000) {
            String str2 = "0000" + this.hBI.chp();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.hBI.chp();
        }
        this.hBE.setText("NO." + str);
        this.hCf.setMyRecordData(this.hBI);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hBF, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uc(int i) {
        if (this.hBI != null) {
            if (this.hBI.getRank() > 3) {
                ap.setViewTextColor(this.hCd, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.eig, R.color.cp_cont_b, 1, i);
            setGrade(this.hBI.chq());
            ap.setViewTextColor(this.hBE, R.color.cp_cont_d, 1, i);
            this.hCf.uc(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.hBI.chq());
        }
    }
}
