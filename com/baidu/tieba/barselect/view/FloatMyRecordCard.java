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
    private TextView crw;
    private View.OnClickListener cze;
    private f eEy;
    private TextView eIG;
    private BazhuHeadView eIH;
    private VotedAreaLayout eII;
    private TextView eIg;
    private ImageView eIh;
    private d eIk;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.eIk != null && FloatMyRecordCard.this.eIk.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.eIk.getUid();
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
        this.eIG = (TextView) findViewById(R.id.tv_voted_rank);
        this.eIH = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.eIH.getHeadView() != null) {
            this.eIH.getHeadView().setIsRound(true);
        }
        this.crw = (TextView) findViewById(R.id.user_name);
        this.eIh = (ImageView) findViewById(R.id.grade);
        this.eIg = (TextView) findViewById(R.id.vote_id);
        this.eII = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.eEy = fVar;
        if (this.eEy != null && this.eEy.aZw() != null) {
            e aZw = this.eEy.aZw();
            if (aZw != null) {
                this.status = aZw.getStatus();
            }
            this.eIk = this.eEy.aZv();
        }
        if (this.eEy == null || this.eIk == null || this.status != com.baidu.tieba.barselect.a.d.eIE) {
            setVisibility(8);
            return;
        }
        int rank = this.eIk.getRank();
        if (rank < 10) {
            this.eIG.setText("0" + rank);
        } else {
            this.eIG.setText("" + rank);
        }
        if (rank == 2) {
            this.eIG.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.eIG.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.eIH.ov(this.eIk.getPortrait());
        this.eIH.setOnClickListener(this.cze);
        this.crw.setText(aq.cutChineseAndEnglishWithSuffix(this.eIk.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.eIk.aZj());
        if (this.eIk.aZi() < 1000) {
            String str2 = "0000" + this.eIk.aZi();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.eIk.aZi();
        }
        this.eIg.setText("NO." + str);
        this.eII.setMyRecordData(this.eIk);
    }

    public void setGrade(int i) {
        am.setImageResource(this.eIh, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void mD(int i) {
        if (this.eIk != null) {
            if (this.eIk.getRank() > 3) {
                am.setViewTextColor(this.eIG, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.crw, R.color.cp_cont_b, 1, i);
            setGrade(this.eIk.aZj());
            am.setViewTextColor(this.eIg, R.color.cp_cont_d, 1, i);
            this.eII.mD(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.eIk.aZj());
        }
    }
}
