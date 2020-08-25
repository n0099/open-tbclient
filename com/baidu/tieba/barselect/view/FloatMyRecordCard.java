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
/* loaded from: classes15.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView dTQ;
    private View.OnClickListener eFC;
    private f hbV;
    private TextView hfF;
    private ImageView hfG;
    private d hfJ;
    private TextView hge;
    private BazhuHeadView hgf;
    private VotedAreaLayout hgg;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.hfJ != null && FloatMyRecordCard.this.hfJ.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.hfJ.getUid();
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
        uf();
    }

    private void uf() {
        this.hge = (TextView) findViewById(R.id.tv_voted_rank);
        this.hgf = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hgf.getHeadView() != null) {
            this.hgf.getHeadView().setIsRound(true);
        }
        this.dTQ = (TextView) findViewById(R.id.user_name);
        this.hfG = (ImageView) findViewById(R.id.grade);
        this.hfF = (TextView) findViewById(R.id.vote_id);
        this.hgg = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.hbV = fVar;
        if (this.hbV != null && this.hbV.caS() != null) {
            e caS = this.hbV.caS();
            if (caS != null) {
                this.status = caS.getStatus();
            }
            this.hfJ = this.hbV.caR();
        }
        if (this.hbV == null || this.hfJ == null || this.status != com.baidu.tieba.barselect.a.d.hgc) {
            setVisibility(8);
            return;
        }
        int rank = this.hfJ.getRank();
        if (rank < 10) {
            this.hge.setText("0" + rank);
        } else {
            this.hge.setText("" + rank);
        }
        if (rank == 2) {
            this.hge.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.hge.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.hgf.AA(this.hfJ.getPortrait());
        this.hgf.setOnClickListener(this.eFC);
        this.dTQ.setText(at.cutChineseAndEnglishWithSuffix(this.hfJ.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hfJ.caG());
        if (this.hfJ.caF() < 1000) {
            String str2 = "0000" + this.hfJ.caF();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.hfJ.caF();
        }
        this.hfF.setText("NO." + str);
        this.hgg.setMyRecordData(this.hfJ);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hfG, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void tl(int i) {
        if (this.hfJ != null) {
            if (this.hfJ.getRank() > 3) {
                ap.setViewTextColor(this.hge, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.dTQ, R.color.cp_cont_b, 1, i);
            setGrade(this.hfJ.caG());
            ap.setViewTextColor(this.hfF, R.color.cp_cont_d, 1, i);
            this.hgg.tl(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.hfJ.caG());
        }
    }
}
