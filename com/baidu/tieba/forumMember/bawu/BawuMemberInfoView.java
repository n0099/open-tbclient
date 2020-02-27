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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView fwA;
    private HeadImageView gjK;
    private ImageView gjL;
    private TextView gjM;
    private BawuRoleInfoPub gjN;
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
        this.gjK = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.gjK.setIsRound(true);
        this.gjK.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gjK.setBorderWidth(l.getDimens(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.gjN != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.gjN.user_id, BawuMemberInfoView.this.gjN.user_name)));
                }
            }
        });
        this.gjL = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.fwA = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.gjM = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        String str;
        if (bawuRoleInfoPub != null) {
            this.gjN = bawuRoleInfoPub;
            if (bawuRoleInfoPub.baijiahao_info != null && !TextUtils.isEmpty(bawuRoleInfoPub.baijiahao_info.avatar)) {
                str = bawuRoleInfoPub.baijiahao_info.avatar;
            } else {
                str = bawuRoleInfoPub.portrait;
            }
            this.gjK.startLoad(str, 12, false);
            this.fwA.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.gjM.setVisibility(8);
            } else {
                this.gjM.setText(bawuRoleInfoPub.level_name);
                this.gjM.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.gjL.setVisibility(8);
                return;
            }
            this.gjL.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            am.setImageResource(this.gjL, smallGradeResourceIdNew);
            this.gjL.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.gjK;
    }

    public TextView getUserNameView() {
        return this.fwA;
    }

    public ImageView getLevelIcon() {
        return this.gjL;
    }

    public TextView getLevelNameView() {
        return this.gjM;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.gjN;
    }
}
