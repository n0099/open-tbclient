package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes8.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView icj;
    private HeadImageView jav;
    private ImageView jaw;
    private TextView jax;
    private BawuRoleInfoPub jay;
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
        this.jav = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.jav.setIsRound(true);
        this.jav.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.jav.setBorderWidth(l.getDimens(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.jay != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.jay.user_id, BawuMemberInfoView.this.jay.user_name)));
                }
            }
        });
        this.jaw = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.icj = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.jax = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        String str;
        if (bawuRoleInfoPub != null) {
            this.jay = bawuRoleInfoPub;
            if (bawuRoleInfoPub.baijiahao_info != null && !TextUtils.isEmpty(bawuRoleInfoPub.baijiahao_info.avatar)) {
                str = bawuRoleInfoPub.baijiahao_info.avatar;
            } else {
                str = bawuRoleInfoPub.portrait;
            }
            this.jav.startLoad(str, 12, false);
            this.icj.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.jax.setVisibility(8);
            } else {
                this.jax.setText(bawuRoleInfoPub.level_name);
                this.jax.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.jaw.setVisibility(8);
                return;
            }
            this.jaw.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            ao.setImageResource(this.jaw, smallGradeResourceIdNew);
            this.jaw.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.jav;
    }

    public TextView getUserNameView() {
        return this.icj;
    }

    public ImageView getLevelIcon() {
        return this.jaw;
    }

    public TextView getLevelNameView() {
        return this.jax;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.jay;
    }
}
