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
    private f iph;
    private TextView isO;
    private ImageView isP;
    private d isS;
    private TextView itn;
    private BazhuHeadView ito;
    private VotedAreaLayout itp;
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
                if (FloatMyRecordCard.this.isS != null && FloatMyRecordCard.this.isS.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.isS.getUid();
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
        this.itn = (TextView) findViewById(R.id.tv_voted_rank);
        this.ito = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.ito.getHeadView() != null) {
            this.ito.getHeadView().setIsRound(true);
        }
        this.eIO = (TextView) findViewById(R.id.user_name);
        this.isP = (ImageView) findViewById(R.id.grade);
        this.isO = (TextView) findViewById(R.id.vote_id);
        this.itp = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.iph = fVar;
        if (this.iph != null && this.iph.crp() != null) {
            e crp = this.iph.crp();
            if (crp != null) {
                this.status = crp.getStatus();
            }
            this.isS = this.iph.cro();
        }
        if (this.iph == null || this.isS == null || this.status != com.baidu.tieba.barselect.a.d.itl) {
            setVisibility(8);
            return;
        }
        int rank = this.isS.getRank();
        if (rank < 10) {
            this.itn.setText("0" + rank);
        } else {
            this.itn.setText("" + rank);
        }
        if (rank == 2) {
            this.itn.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.itn.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.ito.BA(this.isS.getPortrait());
        this.ito.setOnClickListener(this.onClickListener);
        this.eIO.setText(au.cutChineseAndEnglishWithSuffix(this.isS.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.isS.crb());
        if (this.isS.cra() < 1000) {
            String str2 = "0000" + this.isS.cra();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.isS.cra();
        }
        this.isO.setText("NO." + str);
        this.itp.setMyRecordData(this.isS);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.isP, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uu(int i) {
        if (this.isS != null) {
            if (this.isS.getRank() > 3) {
                ap.setViewTextColor(this.itn, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.eIO, R.color.CAM_X0105, 1, i);
            setGrade(this.isS.crb());
            ap.setViewTextColor(this.isO, R.color.CAM_X0109, 1, i);
            this.itp.uu(i);
            ap.setBackgroundColor(this, R.color.CAM_X0201, i);
            setGrade(this.isS.crb());
        }
    }
}
