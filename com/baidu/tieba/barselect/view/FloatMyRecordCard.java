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
/* loaded from: classes20.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView euO;
    private View.OnClickListener fhp;
    private f hQM;
    private d hUB;
    private TextView hUW;
    private BazhuHeadView hUX;
    private VotedAreaLayout hUY;
    private TextView hUx;
    private ImageView hUy;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.hUB != null && FloatMyRecordCard.this.hUB.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.hUB.getUid();
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
        ul();
    }

    private void ul() {
        this.hUW = (TextView) findViewById(R.id.tv_voted_rank);
        this.hUX = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hUX.getHeadView() != null) {
            this.hUX.getHeadView().setIsRound(true);
        }
        this.euO = (TextView) findViewById(R.id.user_name);
        this.hUy = (ImageView) findViewById(R.id.grade);
        this.hUx = (TextView) findViewById(R.id.vote_id);
        this.hUY = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.hQM = fVar;
        if (this.hQM != null && this.hQM.cmP() != null) {
            e cmP = this.hQM.cmP();
            if (cmP != null) {
                this.status = cmP.getStatus();
            }
            this.hUB = this.hQM.cmO();
        }
        if (this.hQM == null || this.hUB == null || this.status != com.baidu.tieba.barselect.a.d.hUU) {
            setVisibility(8);
            return;
        }
        int rank = this.hUB.getRank();
        if (rank < 10) {
            this.hUW.setText("0" + rank);
        } else {
            this.hUW.setText("" + rank);
        }
        if (rank == 2) {
            this.hUW.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.hUW.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.hUX.BP(this.hUB.getPortrait());
        this.hUX.setOnClickListener(this.fhp);
        this.euO.setText(au.cutChineseAndEnglishWithSuffix(this.hUB.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hUB.cmB());
        if (this.hUB.cmA() < 1000) {
            String str2 = "0000" + this.hUB.cmA();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.hUB.cmA();
        }
        this.hUx.setText("NO." + str);
        this.hUY.setMyRecordData(this.hUB);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hUy, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void vc(int i) {
        if (this.hUB != null) {
            if (this.hUB.getRank() > 3) {
                ap.setViewTextColor(this.hUW, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.euO, R.color.CAM_X0105, 1, i);
            setGrade(this.hUB.cmB());
            ap.setViewTextColor(this.hUx, R.color.CAM_X0109, 1, i);
            this.hUY.vc(i);
            ap.setBackgroundColor(this, R.color.CAM_X0201, i);
            setGrade(this.hUB.cmB());
        }
    }
}
