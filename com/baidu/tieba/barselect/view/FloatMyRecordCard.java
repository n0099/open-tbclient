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
    private TextView cbL;
    private View.OnClickListener drw;
    private f fCu;
    private TextView fGA;
    private BazhuHeadView fGB;
    private VotedAreaLayout fGC;
    private TextView fGa;
    private ImageView fGb;
    private d fGe;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drw = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.fGe != null && FloatMyRecordCard.this.fGe.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.fGe.getUid();
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
        this.fGA = (TextView) findViewById(R.id.tv_voted_rank);
        this.fGB = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.fGB.getHeadView() != null) {
            this.fGB.getHeadView().setIsRound(true);
        }
        this.cbL = (TextView) findViewById(R.id.user_name);
        this.fGb = (ImageView) findViewById(R.id.grade);
        this.fGa = (TextView) findViewById(R.id.vote_id);
        this.fGC = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.fCu = fVar;
        if (this.fCu != null && this.fCu.buj() != null) {
            e buj = this.fCu.buj();
            if (buj != null) {
                this.status = buj.getStatus();
            }
            this.fGe = this.fCu.bui();
        }
        if (this.fCu == null || this.fGe == null || this.status != com.baidu.tieba.barselect.a.d.fGy) {
            setVisibility(8);
            return;
        }
        int rank = this.fGe.getRank();
        if (rank < 10) {
            this.fGA.setText("0" + rank);
        } else {
            this.fGA.setText("" + rank);
        }
        if (rank == 2) {
            this.fGA.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.fGA.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.fGB.tU(this.fGe.getPortrait());
        this.fGB.setOnClickListener(this.drw);
        this.cbL.setText(aq.cutChineseAndEnglishWithSuffix(this.fGe.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.fGe.btW());
        if (this.fGe.btV() < 1000) {
            String str2 = "0000" + this.fGe.btV();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.fGe.btV();
        }
        this.fGa.setText("NO." + str);
        this.fGC.setMyRecordData(this.fGe);
    }

    public void setGrade(int i) {
        am.setImageResource(this.fGb, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void pk(int i) {
        if (this.fGe != null) {
            if (this.fGe.getRank() > 3) {
                am.setViewTextColor(this.fGA, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.cbL, R.color.cp_cont_b, 1, i);
            setGrade(this.fGe.btW());
            am.setViewTextColor(this.fGa, R.color.cp_cont_d, 1, i);
            this.fGC.pk(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.fGe.btW());
        }
    }
}
