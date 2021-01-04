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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes8.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView eLt;
    private f ioi;
    private TextView irR;
    private ImageView irS;
    private d irV;
    private TextView isq;
    private BazhuHeadView isr;
    private VotedAreaLayout iss;
    private Context mContext;
    private View.OnClickListener onClickListener;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.irV != null && FloatMyRecordCard.this.irV.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.irV.getUid();
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
        tN();
    }

    private void tN() {
        this.isq = (TextView) findViewById(R.id.tv_voted_rank);
        this.isr = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.isr.getHeadView() != null) {
            this.isr.getHeadView().setIsRound(true);
        }
        this.eLt = (TextView) findViewById(R.id.user_name);
        this.irS = (ImageView) findViewById(R.id.grade);
        this.irR = (TextView) findViewById(R.id.vote_id);
        this.iss = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ioi = fVar;
        if (this.ioi != null && this.ioi.ctW() != null) {
            e ctW = this.ioi.ctW();
            if (ctW != null) {
                this.status = ctW.getStatus();
            }
            this.irV = this.ioi.ctV();
        }
        if (this.ioi == null || this.irV == null || this.status != com.baidu.tieba.barselect.a.d.iso) {
            setVisibility(8);
            return;
        }
        int rank = this.irV.getRank();
        if (rank < 10) {
            this.isq.setText("0" + rank);
        } else {
            this.isq.setText("" + rank);
        }
        if (rank == 2) {
            this.isq.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.isq.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.isr.Cv(this.irV.getPortrait());
        this.isr.setOnClickListener(this.onClickListener);
        this.eLt.setText(at.cutChineseAndEnglishWithSuffix(this.irV.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.irV.ctI());
        if (this.irV.ctH() < 1000) {
            String str2 = "0000" + this.irV.ctH();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.irV.ctH();
        }
        this.irR.setText("NO." + str);
        this.iss.setMyRecordData(this.irV);
    }

    public void setGrade(int i) {
        ao.setImageResource(this.irS, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void vU(int i) {
        if (this.irV != null) {
            if (this.irV.getRank() > 3) {
                ao.setViewTextColor(this.isq, R.color.CAM_X0105, 1, i);
            }
            ao.setViewTextColor(this.eLt, R.color.CAM_X0105, 1, i);
            setGrade(this.irV.ctI());
            ao.setViewTextColor(this.irR, R.color.CAM_X0109, 1, i);
            this.iss.vU(i);
            ao.setBackgroundColor(this, R.color.CAM_X0201, i);
            setGrade(this.irV.ctI());
        }
    }
}
