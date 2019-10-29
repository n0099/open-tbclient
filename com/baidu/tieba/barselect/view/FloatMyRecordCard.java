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
import com.baidu.adp.lib.g.b;
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
/* loaded from: classes3.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView csn;
    private View.OnClickListener czV;
    private f eFp;
    private TextView eIX;
    private ImageView eIY;
    private d eJb;
    private TextView eJx;
    private BazhuHeadView eJy;
    private VotedAreaLayout eJz;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czV = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.eJb != null && FloatMyRecordCard.this.eJb.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.eJb.getUid();
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
        md();
    }

    private void md() {
        this.eJx = (TextView) findViewById(R.id.tv_voted_rank);
        this.eJy = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eJy.getHeadView() != null) {
            this.eJy.getHeadView().setIsRound(true);
        }
        this.csn = (TextView) findViewById(R.id.user_name);
        this.eIY = (ImageView) findViewById(R.id.grade);
        this.eIX = (TextView) findViewById(R.id.vote_id);
        this.eJz = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.eFp = fVar;
        if (this.eFp != null && this.eFp.aZy() != null) {
            e aZy = this.eFp.aZy();
            if (aZy != null) {
                this.status = aZy.getStatus();
            }
            this.eJb = this.eFp.aZx();
        }
        if (this.eFp == null || this.eJb == null || this.status != com.baidu.tieba.barselect.a.d.eJv) {
            setVisibility(8);
            return;
        }
        int rank = this.eJb.getRank();
        if (rank < 10) {
            this.eJx.setText("0" + rank);
        } else {
            this.eJx.setText("" + rank);
        }
        if (rank == 2) {
            this.eJx.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.eJx.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.eJy.ov(this.eJb.getPortrait());
        this.eJy.setOnClickListener(this.czV);
        this.csn.setText(aq.cutChineseAndEnglishWithSuffix(this.eJb.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.eJb.aZl());
        if (this.eJb.aZk() < 1000) {
            String str2 = "0000" + this.eJb.aZk();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.eJb.aZk();
        }
        this.eIX.setText("NO." + str);
        this.eJz.setMyRecordData(this.eJb);
    }

    public void setGrade(int i) {
        am.setImageResource(this.eIY, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void mE(int i) {
        if (this.eJb != null) {
            if (this.eJb.getRank() > 3) {
                am.setViewTextColor(this.eJx, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.csn, R.color.cp_cont_b, 1, i);
            setGrade(this.eJb.aZl());
            am.setViewTextColor(this.eIX, R.color.cp_cont_d, 1, i);
            this.eJz.mE(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.eJb.aZl());
        }
    }
}
