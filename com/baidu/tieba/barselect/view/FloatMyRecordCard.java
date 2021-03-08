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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes7.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView eKp;
    private f ire;
    private TextView iuL;
    private ImageView iuM;
    private d iuP;
    private TextView ivk;
    private BazhuHeadView ivl;
    private VotedAreaLayout ivm;
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
                if (FloatMyRecordCard.this.iuP != null && FloatMyRecordCard.this.iuP.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.iuP.getUid();
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
        tz();
    }

    private void tz() {
        this.ivk = (TextView) findViewById(R.id.tv_voted_rank);
        this.ivl = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.ivl.getHeadView() != null) {
            this.ivl.getHeadView().setIsRound(true);
        }
        this.eKp = (TextView) findViewById(R.id.user_name);
        this.iuM = (ImageView) findViewById(R.id.grade);
        this.iuL = (TextView) findViewById(R.id.vote_id);
        this.ivm = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ire = fVar;
        if (this.ire != null && this.ire.crC() != null) {
            e crC = this.ire.crC();
            if (crC != null) {
                this.status = crC.getStatus();
            }
            this.iuP = this.ire.crB();
        }
        if (this.ire == null || this.iuP == null || this.status != com.baidu.tieba.barselect.a.d.ivi) {
            setVisibility(8);
            return;
        }
        int rank = this.iuP.getRank();
        if (rank < 10) {
            this.ivk.setText("0" + rank);
        } else {
            this.ivk.setText("" + rank);
        }
        if (rank == 2) {
            this.ivk.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.ivk.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.ivl.BH(this.iuP.getPortrait());
        this.ivl.setOnClickListener(this.onClickListener);
        this.eKp.setText(au.cutChineseAndEnglishWithSuffix(this.iuP.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.iuP.cro());
        if (this.iuP.crn() < 1000) {
            String str2 = "0000" + this.iuP.crn();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.iuP.crn();
        }
        this.iuL.setText("NO." + str);
        this.ivm.setMyRecordData(this.iuP);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.iuM, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uw(int i) {
        if (this.iuP != null) {
            if (this.iuP.getRank() > 3) {
                ap.setViewTextColor(this.ivk, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.eKp, R.color.CAM_X0105, 1, i);
            setGrade(this.iuP.cro());
            ap.setViewTextColor(this.iuL, R.color.CAM_X0109, 1, i);
            this.ivm.uw(i);
            ap.setBackgroundColor(this, R.color.CAM_X0201, i);
            setGrade(this.iuP.cro());
        }
    }
}
