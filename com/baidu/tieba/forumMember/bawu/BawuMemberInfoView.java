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
/* loaded from: classes23.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView hPL;
    private HeadImageView iOi;
    private ImageView iOj;
    private TextView iOk;
    private BawuRoleInfoPub iOl;
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
        this.iOi = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.iOi.setIsRound(true);
        this.iOi.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iOi.setBorderWidth(l.getDimens(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.iOl != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.iOl.user_id, BawuMemberInfoView.this.iOl.user_name)));
                }
            }
        });
        this.iOj = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.hPL = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.iOk = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        String str;
        if (bawuRoleInfoPub != null) {
            this.iOl = bawuRoleInfoPub;
            if (bawuRoleInfoPub.baijiahao_info != null && !TextUtils.isEmpty(bawuRoleInfoPub.baijiahao_info.avatar)) {
                str = bawuRoleInfoPub.baijiahao_info.avatar;
            } else {
                str = bawuRoleInfoPub.portrait;
            }
            this.iOi.startLoad(str, 12, false);
            this.hPL.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.iOk.setVisibility(8);
            } else {
                this.iOk.setText(bawuRoleInfoPub.level_name);
                this.iOk.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.iOj.setVisibility(8);
                return;
            }
            this.iOj.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            ap.setImageResource(this.iOj, smallGradeResourceIdNew);
            this.iOj.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.iOi;
    }

    public TextView getUserNameView() {
        return this.hPL;
    }

    public ImageView getLevelIcon() {
        return this.iOj;
    }

    public TextView getLevelNameView() {
        return this.iOk;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.iOl;
    }
}
