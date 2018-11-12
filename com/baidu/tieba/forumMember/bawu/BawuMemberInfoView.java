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
    private TextView cIi;
    private HeadImageView dxr;
    private ImageView dxs;
    private TextView dxt;
    private BawuRoleInfoPub dxu;
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
        this.dxr = (HeadImageView) this.mRootView.findViewById(e.g.imageview_bawu_member);
        this.dxr.setIsRound(true);
        this.dxr.setBorderColor(al.getColor(e.d.common_color_10043));
        this.dxr.setBorderWidth(l.h(this.mContext, e.C0200e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.dxu != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.dxu.user_id, BawuMemberInfoView.this.dxu.user_name)));
                }
            }
        });
        this.dxs = (ImageView) this.mRootView.findViewById(e.g.imageview_level_icon);
        this.cIi = (TextView) this.mRootView.findViewById(e.g.textview_user_name);
        this.dxt = (TextView) this.mRootView.findViewById(e.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.dxu = bawuRoleInfoPub;
            this.dxr.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.cIi.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.dxt.setVisibility(8);
            } else {
                this.dxt.setText(bawuRoleInfoPub.level_name);
                this.dxt.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.dxs.setVisibility(8);
                return;
            }
            this.dxs.setContentDescription(this.mContext.getString(e.j.degree) + bawuRoleInfoPub.user_level);
            al.c(this.dxs, smallGradeResourceIdNew);
            this.dxs.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.dxr;
    }

    public TextView getUserNameView() {
        return this.cIi;
    }

    public ImageView getLevelIcon() {
        return this.dxs;
    }

    public TextView getLevelNameView() {
        return this.dxt;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.dxu;
    }
}
