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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView cGZ;
    private HeadImageView dvZ;
    private ImageView dwa;
    private TextView dwb;
    private BawuRoleInfoPub dwc;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.bawu_member_info_item_layout, this);
        this.dvZ = (HeadImageView) this.mRootView.findViewById(e.g.imageview_bawu_member);
        this.dvZ.setIsRound(true);
        this.dvZ.setBorderColor(al.getColor(e.d.common_color_10043));
        this.dvZ.setBorderWidth(l.h(this.mContext, e.C0175e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.dwc != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.dwc.user_id, BawuMemberInfoView.this.dwc.user_name)));
                }
            }
        });
        this.dwa = (ImageView) this.mRootView.findViewById(e.g.imageview_level_icon);
        this.cGZ = (TextView) this.mRootView.findViewById(e.g.textview_user_name);
        this.dwb = (TextView) this.mRootView.findViewById(e.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.dwc = bawuRoleInfoPub;
            this.dvZ.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.cGZ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.dwb.setVisibility(8);
            } else {
                this.dwb.setText(bawuRoleInfoPub.level_name);
                this.dwb.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.dwa.setVisibility(8);
                return;
            }
            this.dwa.setContentDescription(this.mContext.getString(e.j.degree) + bawuRoleInfoPub.user_level);
            al.c(this.dwa, smallGradeResourceIdNew);
            this.dwa.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.dvZ;
    }

    public TextView getUserNameView() {
        return this.cGZ;
    }

    public ImageView getLevelIcon() {
        return this.dwa;
    }

    public TextView getLevelNameView() {
        return this.dwb;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.dwc;
    }
}
