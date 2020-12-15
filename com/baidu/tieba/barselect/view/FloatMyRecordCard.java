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
    private f ibI;
    private d ifA;
    private TextView ifV;
    private BazhuHeadView ifW;
    private VotedAreaLayout ifX;
    private TextView ifw;
    private ImageView ifx;
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
                if (FloatMyRecordCard.this.ifA != null && FloatMyRecordCard.this.ifA.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.ifA.getUid();
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
        this.ifV = (TextView) findViewById(R.id.tv_voted_rank);
        this.ifW = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.ifW.getHeadView() != null) {
            this.ifW.getHeadView().setIsRound(true);
        }
        this.eBQ = (TextView) findViewById(R.id.user_name);
        this.ifx = (ImageView) findViewById(R.id.grade);
        this.ifw = (TextView) findViewById(R.id.vote_id);
        this.ifX = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ibI = fVar;
        if (this.ibI != null && this.ibI.crd() != null) {
            e crd = this.ibI.crd();
            if (crd != null) {
                this.status = crd.getStatus();
            }
            this.ifA = this.ibI.crc();
        }
        if (this.ibI == null || this.ifA == null || this.status != com.baidu.tieba.barselect.a.d.ifT) {
            setVisibility(8);
            return;
        }
        int rank = this.ifA.getRank();
        if (rank < 10) {
            this.ifV.setText("0" + rank);
        } else {
            this.ifV.setText("" + rank);
        }
        if (rank == 2) {
            this.ifV.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.ifV.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.ifW.Cx(this.ifA.getPortrait());
        this.ifW.setOnClickListener(this.foP);
        this.eBQ.setText(au.cutChineseAndEnglishWithSuffix(this.ifA.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.ifA.cqP());
        if (this.ifA.cqO() < 1000) {
            String str2 = "0000" + this.ifA.cqO();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.ifA.cqO();
        }
        this.ifw.setText("NO." + str);
        this.ifX.setMyRecordData(this.ifA);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.ifx, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void vJ(int i) {
        if (this.ifA != null) {
            if (this.ifA.getRank() > 3) {
                ap.setViewTextColor(this.ifV, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0105, 1, i);
            setGrade(this.ifA.cqP());
            ap.setViewTextColor(this.ifw, R.color.CAM_X0109, 1, i);
            this.ifX.vJ(i);
            ap.setBackgroundColor(this, R.color.CAM_X0201, i);
            setGrade(this.ifA.cqP());
        }
    }
}
