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
/* loaded from: classes21.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView eBQ;
    private View.OnClickListener foP;
    private f ibG;
    private TextView ifT;
    private BazhuHeadView ifU;
    private VotedAreaLayout ifV;
    private TextView ifu;
    private ImageView ifv;
    private d ify;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.ify != null && FloatMyRecordCard.this.ify.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.ify.getUid();
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
        uo();
    }

    private void uo() {
        this.ifT = (TextView) findViewById(R.id.tv_voted_rank);
        this.ifU = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.ifU.getHeadView() != null) {
            this.ifU.getHeadView().setIsRound(true);
        }
        this.eBQ = (TextView) findViewById(R.id.user_name);
        this.ifv = (ImageView) findViewById(R.id.grade);
        this.ifu = (TextView) findViewById(R.id.vote_id);
        this.ifV = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ibG = fVar;
        if (this.ibG != null && this.ibG.crc() != null) {
            e crc = this.ibG.crc();
            if (crc != null) {
                this.status = crc.getStatus();
            }
            this.ify = this.ibG.crb();
        }
        if (this.ibG == null || this.ify == null || this.status != com.baidu.tieba.barselect.a.d.ifR) {
            setVisibility(8);
            return;
        }
        int rank = this.ify.getRank();
        if (rank < 10) {
            this.ifT.setText("0" + rank);
        } else {
            this.ifT.setText("" + rank);
        }
        if (rank == 2) {
            this.ifT.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.ifT.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.ifU.Cx(this.ify.getPortrait());
        this.ifU.setOnClickListener(this.foP);
        this.eBQ.setText(au.cutChineseAndEnglishWithSuffix(this.ify.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.ify.cqO());
        if (this.ify.cqN() < 1000) {
            String str2 = "0000" + this.ify.cqN();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.ify.cqN();
        }
        this.ifu.setText("NO." + str);
        this.ifV.setMyRecordData(this.ify);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.ifv, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void vJ(int i) {
        if (this.ify != null) {
            if (this.ify.getRank() > 3) {
                ap.setViewTextColor(this.ifT, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0105, 1, i);
            setGrade(this.ify.cqO());
            ap.setViewTextColor(this.ifu, R.color.CAM_X0109, 1, i);
            this.ifV.vJ(i);
            ap.setBackgroundColor(this, R.color.CAM_X0201, i);
            setGrade(this.ify.cqO());
        }
    }
}
