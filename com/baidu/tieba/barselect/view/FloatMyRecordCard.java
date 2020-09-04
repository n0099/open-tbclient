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
    private TextView dTU;
    private View.OnClickListener eFG;
    private f hbZ;
    private TextView hfJ;
    private ImageView hfK;
    private d hfN;
    private TextView hgi;
    private BazhuHeadView hgj;
    private VotedAreaLayout hgk;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.hfN != null && FloatMyRecordCard.this.hfN.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.hfN.getUid();
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
        this.hgi = (TextView) findViewById(R.id.tv_voted_rank);
        this.hgj = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hgj.getHeadView() != null) {
            this.hgj.getHeadView().setIsRound(true);
        }
        this.dTU = (TextView) findViewById(R.id.user_name);
        this.hfK = (ImageView) findViewById(R.id.grade);
        this.hfJ = (TextView) findViewById(R.id.vote_id);
        this.hgk = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.hbZ = fVar;
        if (this.hbZ != null && this.hbZ.caT() != null) {
            e caT = this.hbZ.caT();
            if (caT != null) {
                this.status = caT.getStatus();
            }
            this.hfN = this.hbZ.caS();
        }
        if (this.hbZ == null || this.hfN == null || this.status != com.baidu.tieba.barselect.a.d.hgg) {
            setVisibility(8);
            return;
        }
        int rank = this.hfN.getRank();
        if (rank < 10) {
            this.hgi.setText("0" + rank);
        } else {
            this.hgi.setText("" + rank);
        }
        if (rank == 2) {
            this.hgi.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.hgi.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.hgj.AB(this.hfN.getPortrait());
        this.hgj.setOnClickListener(this.eFG);
        this.dTU.setText(at.cutChineseAndEnglishWithSuffix(this.hfN.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hfN.caH());
        if (this.hfN.caG() < 1000) {
            String str2 = "0000" + this.hfN.caG();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.hfN.caG();
        }
        this.hfJ.setText("NO." + str);
        this.hgk.setMyRecordData(this.hfN);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hfK, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void tl(int i) {
        if (this.hfN != null) {
            if (this.hfN.getRank() > 3) {
                ap.setViewTextColor(this.hgi, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.dTU, R.color.cp_cont_b, 1, i);
            setGrade(this.hfN.caH());
            ap.setViewTextColor(this.hfJ, R.color.cp_cont_d, 1, i);
            this.hgk.tl(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.hfN.caH());
        }
    }
}
