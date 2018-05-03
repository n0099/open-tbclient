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
    private HeadImageView cTi;
    private ImageView cTj;
    private TextView cTk;
    private BawuRoleInfoPub cTl;
    private TextView ciX;
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
        this.cTi = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.cTi.setIsRound(true);
        this.cTi.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cTi.setBorderWidth(l.e(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BawuMemberInfoView.this.cTl != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.cTl.user_id, BawuMemberInfoView.this.cTl.user_name)));
                }
            }
        });
        this.cTj = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.ciX = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.cTk = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.cTl = bawuRoleInfoPub;
            this.cTi.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.ciX.setText(bawuRoleInfoPub.user_name);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.cTk.setVisibility(8);
            } else {
                this.cTk.setText(bawuRoleInfoPub.level_name);
                this.cTk.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.cTj.setVisibility(8);
                return;
            }
            this.cTj.setContentDescription(this.mContext.getString(d.k.degree) + bawuRoleInfoPub.user_level);
            ak.c(this.cTj, smallGradeResourceIdNew);
            this.cTj.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.cTi;
    }

    public TextView getUserNameView() {
        return this.ciX;
    }

    public ImageView getLevelIcon() {
        return this.cTj;
    }

    public TextView getLevelNameView() {
        return this.cTk;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.cTl;
    }
}
