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
/* loaded from: classes8.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView eIO;
    private f ipv;
    private TextView itB;
    private BazhuHeadView itC;
    private VotedAreaLayout itD;
    private TextView itc;
    private ImageView itd;
    private d itg;
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
                if (FloatMyRecordCard.this.itg != null && FloatMyRecordCard.this.itg.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.itg.getUid();
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
        this.itB = (TextView) findViewById(R.id.tv_voted_rank);
        this.itC = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.itC.getHeadView() != null) {
            this.itC.getHeadView().setIsRound(true);
        }
        this.eIO = (TextView) findViewById(R.id.user_name);
        this.itd = (ImageView) findViewById(R.id.grade);
        this.itc = (TextView) findViewById(R.id.vote_id);
        this.itD = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.ipv = fVar;
        if (this.ipv != null && this.ipv.crw() != null) {
            e crw = this.ipv.crw();
            if (crw != null) {
                this.status = crw.getStatus();
            }
            this.itg = this.ipv.crv();
        }
        if (this.ipv == null || this.itg == null || this.status != com.baidu.tieba.barselect.a.d.itz) {
            setVisibility(8);
            return;
        }
        int rank = this.itg.getRank();
        if (rank < 10) {
            this.itB.setText("0" + rank);
        } else {
            this.itB.setText("" + rank);
        }
        if (rank == 2) {
            this.itB.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.itB.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.itC.BA(this.itg.getPortrait());
        this.itC.setOnClickListener(this.onClickListener);
        this.eIO.setText(au.cutChineseAndEnglishWithSuffix(this.itg.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.itg.cri());
        if (this.itg.crh() < 1000) {
            String str2 = "0000" + this.itg.crh();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.itg.crh();
        }
        this.itc.setText("NO." + str);
        this.itD.setMyRecordData(this.itg);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.itd, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uu(int i) {
        if (this.itg != null) {
            if (this.itg.getRank() > 3) {
                ap.setViewTextColor(this.itB, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.eIO, R.color.CAM_X0105, 1, i);
            setGrade(this.itg.cri());
            ap.setViewTextColor(this.itc, R.color.CAM_X0109, 1, i);
            this.itD.uu(i);
            ap.setBackgroundColor(this, R.color.CAM_X0201, i);
            setGrade(this.itg.cri());
        }
    }
}
