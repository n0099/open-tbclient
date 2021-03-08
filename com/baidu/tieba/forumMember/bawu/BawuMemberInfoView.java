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
/* loaded from: classes7.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView idX;
    private HeadImageView jds;
    private ImageView jdt;
    private TextView jdu;
    private BawuRoleInfoPub jdv;
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
        this.jds = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.jds.setIsRound(true);
        this.jds.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.jds.setBorderWidth(l.getDimens(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.jdv != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.jdv.user_id, BawuMemberInfoView.this.jdv.user_name)));
                }
            }
        });
        this.jdt = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.idX = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.jdu = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        String str;
        if (bawuRoleInfoPub != null) {
            this.jdv = bawuRoleInfoPub;
            if (bawuRoleInfoPub.baijiahao_info != null && !TextUtils.isEmpty(bawuRoleInfoPub.baijiahao_info.avatar)) {
                str = bawuRoleInfoPub.baijiahao_info.avatar;
            } else {
                str = bawuRoleInfoPub.portrait;
            }
            this.jds.startLoad(str, 12, false);
            this.idX.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.jdu.setVisibility(8);
            } else {
                this.jdu.setText(bawuRoleInfoPub.level_name);
                this.jdu.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.jdt.setVisibility(8);
                return;
            }
            this.jdt.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            ap.setImageResource(this.jdt, smallGradeResourceIdNew);
            this.jdt.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.jds;
    }

    public TextView getUserNameView() {
        return this.idX;
    }

    public ImageView getLevelIcon() {
        return this.jdt;
    }

    public TextView getLevelNameView() {
        return this.jdu;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.jdv;
    }
}
