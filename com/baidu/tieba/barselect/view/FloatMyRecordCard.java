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
    private TextView cbK;
    private View.OnClickListener dri;
    private f fCh;
    private TextView fFN;
    private ImageView fFO;
    private d fFR;
    private TextView fGn;
    private BazhuHeadView fGo;
    private VotedAreaLayout fGp;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dri = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.fFR != null && FloatMyRecordCard.this.fFR.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.fFR.getUid();
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
        ns();
    }

    private void ns() {
        this.fGn = (TextView) findViewById(R.id.tv_voted_rank);
        this.fGo = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.fGo.getHeadView() != null) {
            this.fGo.getHeadView().setIsRound(true);
        }
        this.cbK = (TextView) findViewById(R.id.user_name);
        this.fFO = (ImageView) findViewById(R.id.grade);
        this.fFN = (TextView) findViewById(R.id.vote_id);
        this.fGp = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.fCh = fVar;
        if (this.fCh != null && this.fCh.bui() != null) {
            e bui = this.fCh.bui();
            if (bui != null) {
                this.status = bui.getStatus();
            }
            this.fFR = this.fCh.buh();
        }
        if (this.fCh == null || this.fFR == null || this.status != com.baidu.tieba.barselect.a.d.fGl) {
            setVisibility(8);
            return;
        }
        int rank = this.fFR.getRank();
        if (rank < 10) {
            this.fGn.setText("0" + rank);
        } else {
            this.fGn.setText("" + rank);
        }
        if (rank == 2) {
            this.fGn.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.fGn.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.fGo.tT(this.fFR.getPortrait());
        this.fGo.setOnClickListener(this.dri);
        this.cbK.setText(aq.cutChineseAndEnglishWithSuffix(this.fFR.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.fFR.btV());
        if (this.fFR.btU() < 1000) {
            String str2 = "0000" + this.fFR.btU();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.fFR.btU();
        }
        this.fFN.setText("NO." + str);
        this.fGp.setMyRecordData(this.fFR);
    }

    public void setGrade(int i) {
        am.setImageResource(this.fFO, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void pk(int i) {
        if (this.fFR != null) {
            if (this.fFR.getRank() > 3) {
                am.setViewTextColor(this.fGn, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.cbK, R.color.cp_cont_b, 1, i);
            setGrade(this.fFR.btV());
            am.setViewTextColor(this.fFN, R.color.cp_cont_d, 1, i);
            this.fGp.pk(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.fFR.btV());
        }
    }
}
