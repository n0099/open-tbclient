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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes21.dex */
public class FloatMyRecordCard extends LinearLayout {
    private TextView ewx;
    private View.OnClickListener fii;
    private f hQm;
    private TextView hTX;
    private ImageView hTY;
    private d hUb;
    private TextView hUw;
    private BazhuHeadView hUx;
    private VotedAreaLayout hUy;
    private Context mContext;
    private int status;

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.view.FloatMyRecordCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatMyRecordCard.this.hUb != null && FloatMyRecordCard.this.hUb.getUid() != 0) {
                    long j = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long uid = FloatMyRecordCard.this.hUb.getUid();
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
        this.hUw = (TextView) findViewById(R.id.tv_voted_rank);
        this.hUx = (BazhuHeadView) findViewById(R.id.user_avatar);
        if (this.hUx.getHeadView() != null) {
            this.hUx.getHeadView().setIsRound(true);
        }
        this.ewx = (TextView) findViewById(R.id.user_name);
        this.hTY = (ImageView) findViewById(R.id.grade);
        this.hTX = (TextView) findViewById(R.id.vote_id);
        this.hUy = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public void setData(f fVar) {
        String str;
        this.hQm = fVar;
        if (this.hQm != null && this.hQm.cnn() != null) {
            e cnn = this.hQm.cnn();
            if (cnn != null) {
                this.status = cnn.getStatus();
            }
            this.hUb = this.hQm.cnm();
        }
        if (this.hQm == null || this.hUb == null || this.status != com.baidu.tieba.barselect.a.d.hUu) {
            setVisibility(8);
            return;
        }
        int rank = this.hUb.getRank();
        if (rank < 10) {
            this.hUw.setText("0" + rank);
        } else {
            this.hUw.setText("" + rank);
        }
        if (rank == 2) {
            this.hUw.setTextColor(getResources().getColor(R.color.common_color_10263));
        } else if (rank == 3) {
            this.hUw.setTextColor(getResources().getColor(R.color.common_color_10266));
        }
        this.hUx.Cq(this.hUb.getPortrait());
        this.hUx.setOnClickListener(this.fii);
        this.ewx.setText(at.cutChineseAndEnglishWithSuffix(this.hUb.getNickname(), 14, StringHelper.STRING_MORE));
        setGrade(this.hUb.cmZ());
        if (this.hUb.cmY() < 1000) {
            String str2 = "0000" + this.hUb.cmY();
            str = str2.substring(str2.length() - 4, str2.length());
        } else {
            str = "" + this.hUb.cmY();
        }
        this.hTX.setText("NO." + str);
        this.hUy.setMyRecordData(this.hUb);
    }

    public void setGrade(int i) {
        ap.setImageResource(this.hTY, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void uE(int i) {
        if (this.hUb != null) {
            if (this.hUb.getRank() > 3) {
                ap.setViewTextColor(this.hUw, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.ewx, R.color.cp_cont_b, 1, i);
            setGrade(this.hUb.cmZ());
            ap.setViewTextColor(this.hTX, R.color.cp_cont_d, 1, i);
            this.hUy.uE(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
            setGrade(this.hUb.cmZ());
        }
    }
}
