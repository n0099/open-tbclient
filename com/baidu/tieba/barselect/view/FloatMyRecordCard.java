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
/* loaded from: classes7.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView eGI;
    private f ijz;
    private TextView inJ;
    private BazhuHeadView inK;
    private VotedAreaLayout inL;
    private TextView inj;
    private ImageView ink;
    private d inn;
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
                if (FloatMyRecordCard.this.inn != null && FloatMyRecordCard.this.inn.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.inn.getUid();
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
        tC();
    }

    private void tC() {
        this.inJ = (TextView) findViewById(R.id.tv_voted_rank);
        this.inK = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.inK.getHeadView() != null) {
            this.inK.getHeadView().setIsRound(true);
        }
        this.eGI = (TextView) findViewById(R.id.user_name);
        this.ink = (ImageView) findViewById(R.id.grade);
        this.inj = (TextView) findViewById(R.id.vote_id);
        this.inL = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ijz = fVar;
        if (this.ijz != null && this.ijz.cqf() != null) {
            e cqf = this.ijz.cqf();
            if (cqf != null) {
                this.status = cqf.getStatus();
            }
            this.inn = this.ijz.cqe();
        }
        if (this.ijz == null || this.inn == null || this.status != com.baidu.tieba.barselect.a.d.inH) {
            setVisibility(8);
            return;
        }
        int rank = this.inn.getRank();
        if (rank < 10) {
            this.inJ.setText("0" + rank);
        } else {
            this.inJ.setText("" + rank);
        }
        if (rank == 2) {
            this.inJ.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.inJ.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.inK.Bj(this.inn.getPortrait());
        this.inK.setOnClickListener(this.onClickListener);
        this.eGI.setText(at.cutChineseAndEnglishWithSuffix(this.inn.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.inn.cpR());
        if (this.inn.cpQ() < 1000) {
            String str2 = "0000" + this.inn.cpQ();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.inn.cpQ();
        }
        this.inj.setText("NO." + str);
        this.inL.setMyRecordData(this.inn);
    }

    public void setGrade(int i) {
        ao.setImageResource(this.ink, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uo(int i) {
        if (this.inn != null) {
            if (this.inn.getRank() > 3) {
                ao.setViewTextColor(this.inJ, R.color.CAM_X0105, 1, i);
            }
            ao.setViewTextColor(this.eGI, R.color.CAM_X0105, 1, i);
            setGrade(this.inn.cpR());
            ao.setViewTextColor(this.inj, R.color.CAM_X0109, 1, i);
            this.inL.uo(i);
            ao.setBackgroundColor(this, R.color.CAM_X0201, i);
            setGrade(this.inn.cpR());
        }
    }
}
