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
    private TextView cBd;
    private View.OnClickListener dRK;
    private f ghJ;
    private TextView glT;
    private BazhuHeadView glU;
    private VotedAreaLayout glV;
    private TextView glt;
    private ImageView glu;
    private d glx;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.glx != null && FloatMyRecordCard.this.glx.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.glx.getUid();
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
        this.glT = (TextView) findViewById(R.id.tv_voted_rank);
        this.glU = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.glU.getHeadView() != null) {
            this.glU.getHeadView().setIsRound(true);
        }
        this.cBd = (TextView) findViewById(R.id.user_name);
        this.glu = (ImageView) findViewById(R.id.grade);
        this.glt = (TextView) findViewById(R.id.vote_id);
        this.glV = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ghJ = fVar;
        if (this.ghJ != null && this.ghJ.bDW() != null) {
            e bDW = this.ghJ.bDW();
            if (bDW != null) {
                this.status = bDW.getStatus();
            }
            this.glx = this.ghJ.bDV();
        }
        if (this.ghJ == null || this.glx == null || this.status != com.baidu.tieba.barselect.a.d.glR) {
            setVisibility(8);
            return;
        }
        int rank = this.glx.getRank();
        if (rank < 10) {
            this.glT.setText("0" + rank);
        } else {
            this.glT.setText("" + rank);
        }
        if (rank == 2) {
            this.glT.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.glT.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.glU.vk(this.glx.getPortrait());
        this.glU.setOnClickListener(this.dRK);
        this.cBd.setText(aq.cutChineseAndEnglishWithSuffix(this.glx.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.glx.bDK());
        if (this.glx.bDJ() < 1000) {
            String str2 = "0000" + this.glx.bDJ();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.glx.bDJ();
        }
        this.glt.setText("NO." + str);
        this.glV.setMyRecordData(this.glx);
    }

    public void setGrade(int i) {
        am.setImageResource(this.glu, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void pH(int i) {
        if (this.glx != null) {
            if (this.glx.getRank() > 3) {
                am.setViewTextColor(this.glT, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.cBd, R.color.cp_cont_b, 1, i);
            setGrade(this.glx.bDK());
            am.setViewTextColor(this.glt, R.color.cp_cont_d, 1, i);
            this.glV.pH(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.glx.bDK());
        }
    }
}
