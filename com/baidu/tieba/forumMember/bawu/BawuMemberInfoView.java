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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes22.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView hGe;
    private HeadImageView iDq;
    private ImageView iDr;
    private TextView iDs;
    private BawuRoleInfoPub iDt;
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
        this.iDq = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.iDq.setIsRound(true);
        this.iDq.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iDq.setBorderWidth(l.getDimens(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.iDt != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.iDt.user_id, BawuMemberInfoView.this.iDt.user_name)));
                }
            }
        });
        this.iDr = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.hGe = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.iDs = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        String str;
        if (bawuRoleInfoPub != null) {
            this.iDt = bawuRoleInfoPub;
            if (bawuRoleInfoPub.baijiahao_info != null && !TextUtils.isEmpty(bawuRoleInfoPub.baijiahao_info.avatar)) {
                str = bawuRoleInfoPub.baijiahao_info.avatar;
            } else {
                str = bawuRoleInfoPub.portrait;
            }
            this.iDq.startLoad(str, 12, false);
            this.hGe.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.iDs.setVisibility(8);
            } else {
                this.iDs.setText(bawuRoleInfoPub.level_name);
                this.iDs.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.iDr.setVisibility(8);
                return;
            }
            this.iDr.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            ap.setImageResource(this.iDr, smallGradeResourceIdNew);
            this.iDr.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.iDq;
    }

    public TextView getUserNameView() {
        return this.hGe;
    }

    public ImageView getLevelIcon() {
        return this.iDr;
    }

    public TextView getLevelNameView() {
        return this.iDs;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.iDt;
    }
}
