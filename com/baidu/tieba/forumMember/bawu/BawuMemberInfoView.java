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
/* loaded from: classes17.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView gVT;
    private HeadImageView hOb;
    private ImageView hOc;
    private TextView hOd;
    private BawuRoleInfoPub hOe;
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
        this.hOb = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.hOb.setIsRound(true);
        this.hOb.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hOb.setBorderWidth(l.getDimens(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.hOe != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.hOe.user_id, BawuMemberInfoView.this.hOe.user_name)));
                }
            }
        });
        this.hOc = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.gVT = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.hOd = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        String str;
        if (bawuRoleInfoPub != null) {
            this.hOe = bawuRoleInfoPub;
            if (bawuRoleInfoPub.baijiahao_info != null && !TextUtils.isEmpty(bawuRoleInfoPub.baijiahao_info.avatar)) {
                str = bawuRoleInfoPub.baijiahao_info.avatar;
            } else {
                str = bawuRoleInfoPub.portrait;
            }
            this.hOb.startLoad(str, 12, false);
            this.gVT.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.hOd.setVisibility(8);
            } else {
                this.hOd.setText(bawuRoleInfoPub.level_name);
                this.hOd.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.hOc.setVisibility(8);
                return;
            }
            this.hOc.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            ap.setImageResource(this.hOc, smallGradeResourceIdNew);
            this.hOc.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.hOb;
    }

    public TextView getUserNameView() {
        return this.gVT;
    }

    public ImageView getLevelIcon() {
        return this.hOc;
    }

    public TextView getLevelNameView() {
        return this.hOd;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.hOe;
    }
}
