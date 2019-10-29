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
    private TextView eAg;
    private HeadImageView fqU;
    private ImageView fqV;
    private TextView fqW;
    private BawuRoleInfoPub fqX;
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
        this.fqU = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.fqU.setIsRound(true);
        this.fqU.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fqU.setBorderWidth(l.getDimens(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.fqX != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.fqX.user_id, BawuMemberInfoView.this.fqX.user_name)));
                }
            }
        });
        this.fqV = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.eAg = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.fqW = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.fqX = bawuRoleInfoPub;
            this.fqU.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.eAg.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.fqW.setVisibility(8);
            } else {
                this.fqW.setText(bawuRoleInfoPub.level_name);
                this.fqW.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.fqV.setVisibility(8);
                return;
            }
            this.fqV.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            am.setImageResource(this.fqV, smallGradeResourceIdNew);
            this.fqV.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.fqU;
    }

    public TextView getUserNameView() {
        return this.eAg;
    }

    public ImageView getLevelIcon() {
        return this.fqV;
    }

    public TextView getLevelNameView() {
        return this.fqW;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.fqX;
    }
}
