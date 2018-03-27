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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView cSO;
    private ImageView dAA;
    private TextView dAB;
    private BawuRoleInfoPub dAC;
    private HeadImageView dAz;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.bawu_member_info_item_layout, this);
        this.dAz = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.dAz.setIsRound(true);
        this.dAz.setBorderColor(aj.getColor(d.C0141d.common_color_10043));
        this.dAz.setBorderWidth(l.t(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.dAC != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.dAC.user_id, BawuMemberInfoView.this.dAC.user_name)));
                }
            }
        });
        this.dAA = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.cSO = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.dAB = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.dAC = bawuRoleInfoPub;
            this.dAz.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.cSO.setText(bawuRoleInfoPub.user_name);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.dAB.setVisibility(8);
            } else {
                this.dAB.setText(bawuRoleInfoPub.level_name);
                this.dAB.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.dAA.setVisibility(8);
                return;
            }
            this.dAA.setContentDescription(this.mContext.getString(d.j.degree) + bawuRoleInfoPub.user_level);
            aj.c(this.dAA, smallGradeResourceIdNew);
            this.dAA.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.dAz;
    }

    public TextView getUserNameView() {
        return this.cSO;
    }

    public ImageView getLevelIcon() {
        return this.dAA;
    }

    public TextView getLevelNameView() {
        return this.dAB;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.dAC;
    }
}
