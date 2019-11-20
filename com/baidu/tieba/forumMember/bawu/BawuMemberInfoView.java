package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView ezp;
    private HeadImageView fqd;
    private ImageView fqe;
    private TextView fqf;
    private BawuRoleInfoPub fqg;
    private Context mContext;
    private View mRootView;

    public BawuMemberInfoView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public BawuMemberInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public BawuMemberInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    public void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.bawu_member_info_item_layout, this);
        this.fqd = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.fqd.setIsRound(true);
        this.fqd.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fqd.setBorderWidth(l.getDimens(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.fqg != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.fqg.user_id, BawuMemberInfoView.this.fqg.user_name)));
                }
            }
        });
        this.fqe = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.ezp = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.fqf = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.fqg = bawuRoleInfoPub;
            this.fqd.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.ezp.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.fqf.setVisibility(8);
            } else {
                this.fqf.setText(bawuRoleInfoPub.level_name);
                this.fqf.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.fqe.setVisibility(8);
                return;
            }
            this.fqe.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            am.setImageResource(this.fqe, smallGradeResourceIdNew);
            this.fqe.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.fqd;
    }

    public TextView getUserNameView() {
        return this.ezp;
    }

    public ImageView getLevelIcon() {
        return this.fqe;
    }

    public TextView getLevelNameView() {
        return this.fqf;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.fqg;
    }
}
