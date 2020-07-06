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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes8.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView dEL;
    private View.OnClickListener eoP;
    private f gJz;
    private TextView gNF;
    private BazhuHeadView gNG;
    private VotedAreaLayout gNH;
    private TextView gNg;
    private ImageView gNh;
    private d gNk;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.gNk != null && FloatMyRecordCard.this.gNk.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.gNk.getUid();
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
        sq();
    }

    private void sq() {
        this.gNF = (TextView) findViewById(R.id.tv_voted_rank);
        this.gNG = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.gNG.getHeadView() != null) {
            this.gNG.getHeadView().setIsRound(true);
        }
        this.dEL = (TextView) findViewById(R.id.user_name);
        this.gNh = (ImageView) findViewById(R.id.grade);
        this.gNg = (TextView) findViewById(R.id.vote_id);
        this.gNH = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.gJz = fVar;
        if (this.gJz != null && this.gJz.bNw() != null) {
            e bNw = this.gJz.bNw();
            if (bNw != null) {
                this.status = bNw.getStatus();
            }
            this.gNk = this.gJz.bNv();
        }
        if (this.gJz == null || this.gNk == null || this.status != com.baidu.tieba.barselect.a.d.gND) {
            setVisibility(8);
            return;
        }
        int rank = this.gNk.getRank();
        if (rank < 10) {
            this.gNF.setText("0" + rank);
        } else {
            this.gNF.setText("" + rank);
        }
        if (rank == 2) {
            this.gNF.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.gNF.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.gNG.xh(this.gNk.getPortrait());
        this.gNG.setOnClickListener(this.eoP);
        this.dEL.setText(ar.cutChineseAndEnglishWithSuffix(this.gNk.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.gNk.bNk());
        if (this.gNk.bNj() < 1000) {
            String str2 = "0000" + this.gNk.bNj();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.gNk.bNj();
        }
        this.gNg.setText("NO." + str);
        this.gNH.setMyRecordData(this.gNk);
    }

    public void setGrade(int i) {
        an.setImageResource(this.gNh, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void qJ(int i) {
        if (this.gNk != null) {
            if (this.gNk.getRank() > 3) {
                an.setViewTextColor(this.gNF, R.color.cp_cont_b, 1, i);
            }
            an.setViewTextColor(this.dEL, R.color.cp_cont_b, 1, i);
            setGrade(this.gNk.bNk());
            an.setViewTextColor(this.gNg, R.color.cp_cont_d, 1, i);
            this.gNH.qJ(i);
            an.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.gNk.bNk());
        }
    }
}
