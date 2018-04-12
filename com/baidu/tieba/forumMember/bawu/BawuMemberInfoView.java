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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private HeadImageView cTl;
    private ImageView cTm;
    private TextView cTn;
    private BawuRoleInfoPub cTo;
    private TextView cja;
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
        this.cTl = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.cTl.setIsRound(true);
        this.cTl.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cTl.setBorderWidth(l.e(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BawuMemberInfoView.this.cTo != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.cTo.user_id, BawuMemberInfoView.this.cTo.user_name)));
                }
            }
        });
        this.cTm = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.cja = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.cTn = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.cTo = bawuRoleInfoPub;
            this.cTl.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.cja.setText(bawuRoleInfoPub.user_name);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.cTn.setVisibility(8);
            } else {
                this.cTn.setText(bawuRoleInfoPub.level_name);
                this.cTn.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.cTm.setVisibility(8);
                return;
            }
            this.cTm.setContentDescription(this.mContext.getString(d.k.degree) + bawuRoleInfoPub.user_level);
            ak.c(this.cTm, smallGradeResourceIdNew);
            this.cTm.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.cTl;
    }

    public TextView getUserNameView() {
        return this.cja;
    }

    public ImageView getLevelIcon() {
        return this.cTm;
    }

    public TextView getLevelNameView() {
        return this.cTn;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.cTo;
    }
}
