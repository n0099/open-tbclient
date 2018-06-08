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
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView csb;
    private TextView ddA;
    private BawuRoleInfoPub ddB;
    private HeadImageView ddy;
    private ImageView ddz;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.bawu_member_info_item_layout, this);
        this.ddy = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.ddy.setIsRound(true);
        this.ddy.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        this.ddy.setBorderWidth(l.e(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.ddB != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.ddB.user_id, BawuMemberInfoView.this.ddB.user_name)));
                }
            }
        });
        this.ddz = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.csb = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.ddA = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.ddB = bawuRoleInfoPub;
            this.ddy.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.csb.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.ddA.setVisibility(8);
            } else {
                this.ddA.setText(bawuRoleInfoPub.level_name);
                this.ddA.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.ddz.setVisibility(8);
                return;
            }
            this.ddz.setContentDescription(this.mContext.getString(d.k.degree) + bawuRoleInfoPub.user_level);
            al.c(this.ddz, smallGradeResourceIdNew);
            this.ddz.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.ddy;
    }

    public TextView getUserNameView() {
        return this.csb;
    }

    public ImageView getLevelIcon() {
        return this.ddz;
    }

    public TextView getLevelNameView() {
        return this.ddA;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.ddB;
    }
}
