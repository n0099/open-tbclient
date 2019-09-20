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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView epQ;
    private HeadImageView frK;
    private ImageView frL;
    private TextView frM;
    private BawuRoleInfoPub frN;
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
        this.frK = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.frK.setIsRound(true);
        this.frK.setBorderColor(am.getColor(R.color.common_color_10043));
        this.frK.setBorderWidth(l.g(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.frN != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.frN.user_id, BawuMemberInfoView.this.frN.user_name)));
                }
            }
        });
        this.frL = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.epQ = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.frM = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.frN = bawuRoleInfoPub;
            this.frK.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.epQ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.frM.setVisibility(8);
            } else {
                this.frM.setText(bawuRoleInfoPub.level_name);
                this.frM.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.frL.setVisibility(8);
                return;
            }
            this.frL.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            am.c(this.frL, smallGradeResourceIdNew);
            this.frL.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.frK;
    }

    public TextView getUserNameView() {
        return this.epQ;
    }

    public ImageView getLevelIcon() {
        return this.frL;
    }

    public TextView getLevelNameView() {
        return this.frM;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.frN;
    }
}
